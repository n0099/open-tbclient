package com.baidu.titan.sdk.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.baidu.titan.sdk.initer.TitanIniter;
import com.baidu.titan.sdk.pm.IPatchInstallObserver;
import com.baidu.titan.sdk.pm.IPatchManager;
import com.baidu.titan.sdk.sandbox.WorkerService;
import java.io.File;
/* loaded from: classes6.dex */
public class PatchManager {
    public static final String ACTION_CLEAN_PATCH = "action_clean_patch";
    public static final String ACTION_INSTALL_PATCH = "action_install_patch";
    public static final boolean DEBUG = false;
    public static final String INSTALL_RESULT_EXTRA_KEY = "install_result_extra";
    public static final int INSTALL_STATE_ALREADY_INSTALLED = 1;
    public static final int INSTALL_STATE_ERROR_APKID_FETCH = -2;
    public static final int INSTALL_STATE_ERROR_EXTRACT_DEX = -10;
    public static final int INSTALL_STATE_ERROR_IO = -3;
    public static final int INSTALL_STATE_PATCH_ERROR_DEXOPT = -7;
    public static final int INSTALL_STATE_PATCH_VERSION_DOWNGRADE = -6;
    public static final int INSTALL_STATE_SUCCESS = 0;
    public static final int INSTALL_STATE_VERIFY_ERROR_EXTRACT_DEX = -8;
    public static final int INSTALL_STATE_VERIFY_ERROR_OPT_DEX = -9;
    public static final int INSTALL_STATE_VERIFY_ERROR_OTHER = -1;
    public static final int INSTALL_STATE_VERIFY_ERROR_PATCH_ID_DISMATCH = -4;
    public static final int INSTALL_STATE_VERIFY_ERROR_SIGNATURE_DISMATCH = -5;
    public static final String PENDING_CLEAN_FILE = ".PENDING_CLEAN";
    public static final String TAG = "PatchManager";
    public static PatchManager sInstance;
    public final Context mContext;

    /* loaded from: classes6.dex */
    public interface PatchInstallObserver {
        void onPatchInstalled(int i, Bundle bundle);
    }

    /* loaded from: classes6.dex */
    public class PatchInstallWrapper extends RemoteServiceWrapper {
        public static final int MSG_WHAT_PATCH_INSTALL = 1;
        public Bundle mExtra;
        public PatchInstallObserver mLocalObserver;
        public PatchInstallObserverImpl mRemoteObserver;
        public Handler mUiHandler;
        public Uri mUri;

        /* loaded from: classes6.dex */
        public class PatchInstallObserverImpl extends IPatchInstallObserver.Stub {
            public PatchInstallObserverImpl() {
            }

            @Override // com.baidu.titan.sdk.pm.IPatchInstallObserver
            public void onPatchInstalled(int i, Bundle bundle) throws RemoteException {
                Message obtainMessage = PatchInstallWrapper.this.mUiHandler.obtainMessage(1);
                obtainMessage.arg1 = i;
                obtainMessage.arg2 = 1;
                obtainMessage.obj = bundle;
                obtainMessage.sendToTarget();
                PatchInstallWrapper.this.unbind();
            }
        }

        public PatchInstallWrapper(Context context, Uri uri, Bundle bundle, PatchInstallObserver patchInstallObserver) {
            super(context, "action_install_patch");
            this.mUiHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.titan.sdk.pm.PatchManager.PatchInstallWrapper.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (message.what == 1) {
                        PatchInstallWrapper.this.mLocalObserver.onPatchInstalled(message.arg1, (Bundle) message.obj);
                    }
                }
            };
            this.mUri = uri;
            this.mExtra = bundle;
            this.mLocalObserver = patchInstallObserver;
            this.mRemoteObserver = new PatchInstallObserverImpl();
        }

        @Override // com.baidu.titan.sdk.pm.PatchManager.RemoteServiceWrapper
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                IPatchManager.Stub.asInterface(iBinder).install(this.mUri, 0, this.mExtra, this.mRemoteObserver);
            } catch (Throwable th) {
                th.printStackTrace();
                this.mUiHandler.obtainMessage(1, -100, 0, null).sendToTarget();
            }
        }
    }

    /* loaded from: classes6.dex */
    public abstract class RemoteServiceWrapper {
        public String mAction;
        public Context mContext;
        public ServiceConnectionImpl mServiceConnection = new ServiceConnectionImpl();

        public abstract void onServiceConnected(ComponentName componentName, IBinder iBinder);

        /* loaded from: classes6.dex */
        public class ServiceConnectionImpl implements ServiceConnection {
            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
            }

            public ServiceConnectionImpl() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                RemoteServiceWrapper.this.onServiceConnected(componentName, iBinder);
            }
        }

        public RemoteServiceWrapper(Context context, String str) {
            this.mAction = str;
            this.mContext = context;
        }

        public void bind() {
            this.mContext.bindService(new Intent(this.mContext, WorkerService.class).setAction(this.mAction).putExtra(WorkerService.REQUEST_WORKER_SERVICE_BINDER, true), this.mServiceConnection, 1);
        }

        public void unbind() {
            this.mContext.unbindService(this.mServiceConnection);
        }
    }

    /* loaded from: classes6.dex */
    public class PatchCleanWrapper extends RemoteServiceWrapper {
        public static final int MSG_WHAT_UNBIND = 1;
        public Handler mUiHandler;

        public PatchCleanWrapper(Context context) {
            super(context, "action_clean_patch");
            this.mUiHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.titan.sdk.pm.PatchManager.PatchCleanWrapper.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (message.what == 1) {
                        PatchCleanWrapper.this.unbind();
                    }
                }
            };
        }

        @Override // com.baidu.titan.sdk.pm.PatchManager.RemoteServiceWrapper
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                IPatchManager.Stub.asInterface(iBinder).requestCleanPatches();
            } catch (Throwable th) {
                th.printStackTrace();
                this.mUiHandler.obtainMessage(1, -100, 0, null).sendToTarget();
            }
        }
    }

    public PatchManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static PatchManager getInstance() {
        PatchManager patchManager;
        synchronized (PatchManager.class) {
            if (sInstance == null) {
                sInstance = new PatchManager(TitanIniter.getAppContext());
            }
            patchManager = sInstance;
        }
        return patchManager;
    }

    public static File getPendingCleanFile() {
        return new File(TitanPaths.getBaseDir(), PENDING_CLEAN_FILE);
    }

    public boolean needClean() {
        return getPendingCleanFile().exists();
    }

    public void requestCleanPatchs() {
        new PatchCleanWrapper(this.mContext).bind();
    }

    public void installPatch(Uri uri, Bundle bundle, PatchInstallObserver patchInstallObserver) {
        new PatchInstallWrapper(this.mContext, uri, bundle, patchInstallObserver).bind();
    }
}
