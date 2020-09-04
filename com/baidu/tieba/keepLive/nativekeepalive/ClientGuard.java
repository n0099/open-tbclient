package com.baidu.tieba.keepLive.nativekeepalive;

import android.content.Context;
import android.os.Process;
import com.baidu.tieba.keepLive.nativekeepalive.IGuard;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes.dex */
public class ClientGuard implements IGuardClient {
    private final String DAEMON_PERMITTING_SP_FILENAME = "d_permit";
    private final String DAEMON_PERMITTING_SP_KEY = "permitted";
    private BufferedReader mBufferedReader;
    private GuardConfigurations mConfigurations;
    private Context mContext;

    public ClientGuard(GuardConfigurations guardConfigurations) {
        this.mConfigurations = guardConfigurations;
    }

    @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuardClient
    public void onAttachBaseContext(Context context) {
        this.mContext = context;
        initDaemon(context);
    }

    private void initDaemon(Context context) {
        if (this.mConfigurations != null) {
            String processName = getProcessName();
            String packageName = context.getPackageName();
            if (processName.startsWith(this.mConfigurations.PERSISTENT_CONFIG.PROCESS_NAME)) {
                IGuard.Fetcher.fetchGuard().onPersistentCreate(context, this.mConfigurations);
            } else if (processName.startsWith(this.mConfigurations.DAEMON_ASSISTANT_CONFIG.PROCESS_NAME)) {
                IGuard.Fetcher.fetchGuard().onDaemonAssistantCreate(context, this.mConfigurations);
            } else if (processName.startsWith(packageName + ":remote")) {
                IGuard.Fetcher.fetchGuard().onInitialization(context);
            }
            releaseIO();
        }
    }

    private String getProcessName() {
        try {
            this.mBufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
            return this.mBufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void releaseIO() {
        if (this.mBufferedReader != null) {
            try {
                this.mBufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.mBufferedReader = null;
        }
    }
}
