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
    public String f63785a;

    /* renamed from: b  reason: collision with root package name */
    public x f63786b;

    /* renamed from: c  reason: collision with root package name */
    public a f63787c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f63788d;

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
        this.f63788d = true;
        this.f63785a = str;
        this.f63786b = xVar;
        this.f63787c = aVar;
    }
}
