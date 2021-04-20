package com.baidu.tieba.keepLive.nativekeepalive;

import android.content.Context;
import android.os.Process;
import com.baidu.tieba.keepLive.nativekeepalive.IGuard;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes4.dex */
public class ClientGuard implements IGuardClient {
    public final String DAEMON_PERMITTING_SP_FILENAME = "d_permit";
    public final String DAEMON_PERMITTING_SP_KEY = "permitted";
    public BufferedReader mBufferedReader;
    public GuardConfigurations mConfigurations;
    public Context mContext;

    public ClientGuard(GuardConfigurations guardConfigurations) {
        this.mConfigurations = guardConfigurations;
    }

    private String getProcessName() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
            this.mBufferedReader = bufferedReader;
            return bufferedReader.readLine();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void initDaemon(Context context) {
        if (this.mConfigurations == null) {
            return;
        }
        String processName = getProcessName();
        String packageName = context.getPackageName();
        if (processName.startsWith(this.mConfigurations.PERSISTENT_CONFIG.PROCESS_NAME)) {
            IGuard.Fetcher.fetchGuard().onPersistentCreate(context, this.mConfigurations);
        } else if (processName.startsWith(this.mConfigurations.DAEMON_ASSISTANT_CONFIG.PROCESS_NAME)) {
            IGuard.Fetcher.fetchGuard().onDaemonAssistantCreate(context, this.mConfigurations);
        } else {
            if (processName.startsWith(packageName + ":remote")) {
                IGuard.Fetcher.fetchGuard().onInitialization(context);
            }
        }
        releaseIO();
    }

    private void releaseIO() {
        BufferedReader bufferedReader = this.mBufferedReader;
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.mBufferedReader = null;
        }
    }

    @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuardClient
    public void onAttachBaseContext(Context context) {
        this.mContext = context;
        initDaemon(context);
    }
}
