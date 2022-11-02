package com.baidu.webkit.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class WebViewRendererService extends Service {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String RENDER_SERVICE_PROCESS_NAME_SUFFIX = "sandboxed_process";
    public static final String TAG = "WebViewRendererService";
    public transient /* synthetic */ FieldHolder $fh;
    public ServiceProvider mServiceImpl;

    /* loaded from: classes7.dex */
    public interface ServiceProvider {
        IBinder bind(Intent intent);

        void create(Context context);

        void destroy();
    }

    public WebViewRendererService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
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
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            android.util.Log.i("s_mp", MissionEvent.MESSAGE_DESTROY);
            super.onDestroy();
            ServiceProvider serviceProvider = this.mServiceImpl;
            if (serviceProvider != null) {
                serviceProvider.destroy();
            }
        }
    }
}
