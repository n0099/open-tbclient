package com.baidu.ufosdk.ui;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class cl implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ck f59785a;

    public cl(ck ckVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ckVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59785a = ckVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.f59785a.f59784b.f59777a.B) {
                    this.f59785a.f59784b.f59777a.a(this.f59785a.f59784b.f59777a, this.f59785a.f59784b.f59777a.f59676f, this.f59785a.f59784b.f59777a.A);
                }
                com.baidu.ufosdk.e.a.a(this.f59785a.f59784b.f59777a.f59676f, 9);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
