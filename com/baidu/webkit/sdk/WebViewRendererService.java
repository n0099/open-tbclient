package com.baidu.webkit.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
/* loaded from: classes5.dex */
public class WebViewRendererService extends Service {
    public static final String RENDER_SERVICE_PROCESS_NAME_SUFFIX = "sandboxed_process";
    public static final String TAG = "WebViewRendererService";
    public ServiceProvider mServiceImpl;

    /* loaded from: classes5.dex */
    public interface ServiceProvider {
        IBinder bind(Intent intent);

        void create(Context context);

        void destroy();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        stopSelf();
        ServiceProvider serviceProvider = this.mServiceImpl;
        if (serviceProvider != null) {
            try {
                return serviceProvider.bind(intent);
            } catch (Exception e2) {
                android.util.Log.e(TAG, "exception during onBind: " + e2);
                throw e2;
            }
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ServiceProvider rendererService = WebViewFactory.getProvider().getRendererService();
        this.mServiceImpl = rendererService;
        if (rendererService != null) {
            try {
                rendererService.create(getApplicationContext());
            } catch (Exception e2) {
                android.util.Log.e(TAG, "exception during onCreate: " + e2);
                throw e2;
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ServiceProvider serviceProvider = this.mServiceImpl;
        if (serviceProvider != null) {
            serviceProvider.destroy();
        }
    }
}
