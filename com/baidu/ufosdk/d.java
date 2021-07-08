package com.baidu.ufosdk;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class d implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f23304a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f23305b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f23306c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f23307d;

    public d(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23304a = i2;
        this.f23305b = i3;
        this.f23306c = i4;
        this.f23307d = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            context = UfoSDK.mApplication;
            com.baidu.ufosdk.e.a.a(context, this.f23304a, this.f23305b, this.f23306c, this.f23307d, false);
        }
    }
}
