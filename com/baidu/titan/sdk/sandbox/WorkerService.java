package com.baidu.titan.sdk.sandbox;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.titan.sdk.pm.IPatchInstallObserver;
import com.baidu.titan.sdk.pm.IPatchManager;
import com.baidu.titan.sdk.pm.PatchManagerService;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes11.dex */
public class WorkerService extends JobIntentService {
    public static final String ACTION_CLEAN_PATCH = "action_clean_patch";
    public static final String ACTION_INSTALL_PATCH = "action_install_patch";
    public static final boolean DEBUG = false;
    public static final int JOB_ID = 1001;
    public static final String REQUEST_WORKER_SERVICE_BINDER = "worker_service_binder";
    public static final String TAG = WorkerService.class.getSimpleName();
    public static final String TOKEN = "token";
    public final AtomicLong mTokenGen = new AtomicLong(1000);
    public HashMap<Long, InstallParameter> mInstallParameters = new HashMap<>();
    public IPatchManager.Stub mPatchManager = new IPatchManager.Stub() { // from class: com.baidu.titan.sdk.sandbox.WorkerService.1
        @Override // com.baidu.titan.sdk.pm.IPatchManager
        public void install(Uri uri, int i2, Bundle bundle, IPatchInstallObserver iPatchInstallObserver) throws RemoteException {
            Intent intent = new Intent(WorkerService.this, WorkerService.class);
            intent.setAction("action_install_patch");
            Long valueOf = Long.valueOf(WorkerService.this.mTokenGen.incrementAndGet());
            InstallParameter installParameter = new InstallParameter();
            installParameter.uri = uri;
            installParameter.flages = i2;
            installParameter.observer = iPatchInstallObserver;
            installParameter.extra = bundle;
            WorkerService.this.mInstallParameters.put(valueOf, installParameter);
            intent.putExtra("token", valueOf);
            if (Build.VERSION.SDK_INT >= 26) {
                WorkerService.enqueueWork(WorkerService.this, intent);
            } else {
                WorkerService.this.startService(intent);
            }
        }

        @Override // com.baidu.titan.sdk.pm.IPatchManager
        public void requestCleanPatches() throws RemoteException {
            Intent intent = new Intent(WorkerService.this, WorkerService.class);
            intent.setAction("action_clean_patch");
            if (Build.VERSION.SDK_INT >= 26) {
                WorkerService.enqueueWork(WorkerService.this, intent);
            } else {
                WorkerService.this.startService(intent);
            }
        }
    };

    /* loaded from: classes11.dex */
    public static class InstallParameter {
        public Bundle extra;
        public int flages;
        public IPatchInstallObserver observer;
        public Uri uri;

        public InstallParameter() {
        }

        public String toString() {
            return "InstallParameter{uri=" + this.uri + ", flages=" + this.flages + ", observer=" + this.observer + ", extra=" + this.extra + ExtendedMessageFormat.END_FE;
        }
    }

    public static void enqueueWork(Context context, Intent intent) {
        JobIntentService.enqueueWork(context, WorkerService.class, 1001, intent);
    }

    private void handleCleanPatches() {
        PatchManagerService.getInstance().doCleanPatchsLocked();
    }

    private void handleInstallPatch(Intent intent) {
        InstallParameter installParameter;
        Long valueOf = Long.valueOf(intent.getLongExtra("token", -1L));
        if (valueOf.longValue() >= 0 && (installParameter = this.mInstallParameters.get(valueOf)) != null) {
            IPatchInstallObserver iPatchInstallObserver = installParameter.observer;
            PatchManagerService patchManagerService = PatchManagerService.getInstance();
            Bundle bundle = new Bundle();
            try {
                iPatchInstallObserver.onPatchInstalled(patchManagerService.installSyncLocked(installParameter.uri, installParameter.extra, bundle), bundle);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.titan.sdk.sandbox.JobIntentService, android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent.getBooleanExtra(REQUEST_WORKER_SERVICE_BINDER, false)) {
            return this.mPatchManager.asBinder();
        }
        return super.onBind(intent);
    }

    @Override // com.baidu.titan.sdk.sandbox.JobIntentService
    public void onHandleWork(Intent intent) {
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("action_install_patch".equals(action)) {
            handleInstallPatch(intent);
        } else if ("action_clean_patch".equals(action)) {
            handleCleanPatches();
        }
    }
}
