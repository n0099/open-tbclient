package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.manager.ConnectivityMonitor;
/* loaded from: classes7.dex */
public class DefaultConnectivityMonitorFactory implements ConnectivityMonitorFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NETWORK_PERMISSION = "android.permission.ACCESS_NETWORK_STATE";
    public static final String TAG = "ConnectivityMonitor";
    public transient /* synthetic */ FieldHolder $fh;

    public DefaultConnectivityMonitorFactory() {
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

    @Override // com.bumptech.glide.manager.ConnectivityMonitorFactory
    @NonNull
    public ConnectivityMonitor build(@NonNull Context context, @NonNull ConnectivityMonitor.ConnectivityListener connectivityListener) {
        InterceptResult invokeLL;
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, connectivityListener)) == null) {
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0) {
                z = true;
            } else {
                z = false;
            }
            if (Log.isLoggable("ConnectivityMonitor", 3)) {
                if (z) {
                    str = "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor";
                } else {
                    str = "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor";
                }
                Log.d("ConnectivityMonitor", str);
            }
            if (z) {
                return new DefaultConnectivityMonitor(context, connectivityListener);
            }
            return new NullConnectivityMonitor();
        }
        return (ConnectivityMonitor) invokeLL.objValue;
    }
}
