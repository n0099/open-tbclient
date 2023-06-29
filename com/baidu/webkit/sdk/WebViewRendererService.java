package com.baidu.webkit.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes9.dex */
public class WebViewRendererService extends Service {
    public static final String RENDER_SERVICE_PROCESS_NAME_SUFFIX = "sandboxed_process";
    public static final String TAG = "WebViewRendererService";
    public ServiceProvider mServiceImpl;

    /* loaded from: classes9.dex */
    public interface ServiceProvider {
        IBinder bind(Intent intent);

        void create(Context context);

        void destroy();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        android.util.Log.i("s_mp", "onBind");
        stopSelf();
        ServiceProvider serviceProvider = this.mServiceImpl;
        if (serviceProvider != null) {
            try {
                return serviceProvider.bind(intent);
            } catch (Exception e) {
                android.util.Log.e(TAG, "exception during onBind: ".concat(String.valueOf(e)));
                throw e;
            }
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mServiceImpl = WebViewFactory.getProvider().getRendererService();
        StringBuilder sb = new StringBuilder("onCreate, pid=");
        sb.append(Process.myPid());
        sb.append(", mServiceImpl: ");
        sb.append(this.mServiceImpl != null);
        android.util.Log.i("s_mp", sb.toString());
        ServiceProvider serviceProvider = this.mServiceImpl;
        if (serviceProvider != null) {
            try {
                serviceProvider.create(getApplicationContext());
            } catch (Exception e) {
                android.util.Log.e(TAG, "exception during onCreate: ".concat(String.valueOf(e)));
                throw e;
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        android.util.Log.i("s_mp", MissionEvent.MESSAGE_DESTROY);
        super.onDestroy();
        ServiceProvider serviceProvider = this.mServiceImpl;
        if (serviceProvider != null) {
            serviceProvider.destroy();
        }
    }
}
