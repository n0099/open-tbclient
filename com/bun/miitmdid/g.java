package com.bun.miitmdid;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Keep
    public h a;
    @Keep
    public h b;
    @Keep
    public h c;
    @Keep
    public h d;
    @Keep
    public h e;

    public g() {
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

    @Keep
    public native h a();

    @Keep
    public native void a(h hVar);

    @Keep
    public native h b();

    @Keep
    public native void b(h hVar);

    @Keep
    public native h c();

    @Keep
    public native void c(h hVar);

    @Keep
    public native h d();

    @Keep
    public native void d(h hVar);

    @Keep
    public native h e();

    @Keep
    public native void e(h hVar);

    @Keep
    public native void f();
}
