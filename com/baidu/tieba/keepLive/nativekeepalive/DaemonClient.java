package com.baidu.tieba.keepLive.nativekeepalive;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes.dex */
public class DaemonClient implements IDaemonClient {
    private final String DAEMON_PERMITTING_SP_FILENAME = "d_permit";
    private final String DAEMON_PERMITTING_SP_KEY = "permitted";
    private BufferedReader mBufferedReader;
    private DaemonConfigurations mConfigurations;
    private Context mContext;

    public DaemonClient(DaemonConfigurations daemonConfigurations) {
        this.mConfigurations = daemonConfigurations;
    }

    @Override // com.baidu.tieba.keepLive.nativekeepalive.IDaemonClient
    public void onAttachBaseContext(Context context) {
        this.mContext = context;
        initDaemon(context);
    }

    private void initDaemon(Context context) {
        if (this.mConfigurations != null) {
            String processName = getProcessName();
            String packageName = context.getPackageName();
            if (processName.startsWith(this.mConfigurations.PERSISTENT_CONFIG.PROCESS_NAME)) {
                IDaemonStrategy.Fetcher.fetchStrategy().onPersistentCreate(context, this.mConfigurations);
            } else if (processName.startsWith(this.mConfigurations.DAEMON_ASSISTANT_CONFIG.PROCESS_NAME)) {
                IDaemonStrategy.Fetcher.fetchStrategy().onDaemonAssistantCreate(context, this.mConfigurations);
            } else if (processName.startsWith(packageName + ":remote")) {
                IDaemonStrategy.Fetcher.fetchStrategy().onInitialization(context);
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

    private boolean isDaemonPermitting(Context context) {
        return context.getSharedPreferences("d_permit", 0).getBoolean("permitted", true);
    }

    protected boolean setDaemonPermiiting(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences("d_permit", 0).edit();
        edit.putBoolean("permitted", z);
        return edit.commit();
    }
}
