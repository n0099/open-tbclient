package com.baidu.tieba.live;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class LiveGroupManagerCheckerService extends Service {
    public static final String IS_LIVE_PLUGIN_LOADED = "isLivePluginLoaded";
    public static final String LIVE_GROUP_SERVICE_NAME = "LiveGroupServiceName";
    public static final int LIVE_PLUGIN_CHECK = 4097;
    public static final int LIVE_PLUGIN_LOADED = 4096;
    public static final int PLUGIN_LOADED_FAILED = 0;
    public static final int PLUGIN_LOADED_SUCCESS = 1;
    private Messenger mMessenger = null;
    private Messenger replyMessenger = null;
    private String targetComponent;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent != null) {
            this.targetComponent = intent.getStringExtra(LIVE_GROUP_SERVICE_NAME);
            if (this.mMessenger == null) {
                this.mMessenger = new Messenger(new ServerHandler());
            }
            return this.mMessenger.getBinder();
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class ServerHandler extends Handler {
        public ServerHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z;
            if (message != null && message.what == 4097 && !TextUtils.isEmpty(LiveGroupManagerCheckerService.this.targetComponent)) {
                LiveGroupManagerCheckerService.this.replyMessenger = message.replyTo;
                try {
                    Class.forName(LiveGroupManagerCheckerService.this.targetComponent);
                    z = true;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    z = false;
                }
                try {
                    if (LiveGroupManagerCheckerService.this.replyMessenger != null) {
                        LiveGroupManagerCheckerService.this.replyMessenger.send(Message.obtain(null, 4096, z ? 1 : 0, 0));
                    }
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
