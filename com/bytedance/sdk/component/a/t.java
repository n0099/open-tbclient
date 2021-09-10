package com.bytedance.sdk.component.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f64165a;

    /* renamed from: b  reason: collision with root package name */
    public x f64166b;

    /* renamed from: c  reason: collision with root package name */
    public a f64167c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64168d;

    /* loaded from: classes9.dex */
    public interface a {
    }

    public t(String str, x xVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, xVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64168d = true;
        this.f64165a = str;
        this.f64166b = xVar;
        this.f64167c = aVar;
    }
}
