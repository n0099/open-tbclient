package com.baidu.webkit.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
/* loaded from: classes14.dex */
public class WebViewRendererService extends Service {
    public static final String RENDER_SERVICE_PROCESS_NAME_SUFFIX = "sandboxed_process";
    private static final String TAG = "WebViewRendererService";
    private ServiceProvider mServiceImpl;

    /* loaded from: classes14.dex */
    public interface ServiceProvider {
        IBinder bind(Intent intent);

        void create(Context context);

        void destroy();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        stopSelf();
        if (this.mServiceImpl != null) {
            try {
                return this.mServiceImpl.bind(intent);
            } catch (Exception e) {
                android.util.Log.e(TAG, "exception during onBind: " + e);
                throw e;
            }
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mServiceImpl = WebViewFactory.getProvider().getRendererService();
        if (this.mServiceImpl != null) {
            try {
                this.mServiceImpl.create(getApplicationContext());
            } catch (Exception e) {
                android.util.Log.e(TAG, "exception during onCreate: " + e);
                throw e;
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.mServiceImpl != null) {
            this.mServiceImpl.destroy();
        }
    }
}
