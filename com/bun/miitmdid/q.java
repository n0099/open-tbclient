package com.bun.miitmdid;

import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.zui.opendeviceidlibrary.OpenDeviceId;
@Keep
/* loaded from: classes9.dex */
public class q extends m implements OpenDeviceId.CallBack<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Keep
    public Context n;
    @Keep
    public OpenDeviceId o;

    public q(Context context) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.zui.opendeviceidlibrary.OpenDeviceId.CallBack
    @Keep
    /* renamed from: a */
    public native void serviceConnected(String str, OpenDeviceId openDeviceId);

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    @Keep
    public native void doStart();

    @Override // com.bun.miitmdid.m, com.bun.miitmdid.interfaces.IIdProvider
    @Keep
    public native boolean isSync();

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    @Keep
    public native void shutDown();
}
