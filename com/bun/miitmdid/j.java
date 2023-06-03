package com.bun.miitmdid;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coolpad.deviceidsupport.IDeviceIdManager;
@Keep
/* loaded from: classes9.dex */
public class j extends m implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    @Keep
    public static IDeviceIdManager p;
    public transient /* synthetic */ FieldHolder $fh;
    @Keep
    public Context n;
    @Keep
    public String o;

    public j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = context;
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    @Keep
    public native void doStart();

    @Override // android.content.ServiceConnection
    @Keep
    public native void onServiceConnected(ComponentName componentName, IBinder iBinder);

    @Override // android.content.ServiceConnection
    @Keep
    public native void onServiceDisconnected(ComponentName componentName);

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    @Keep
    public native void shutDown();
}
