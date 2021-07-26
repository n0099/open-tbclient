package com.bytedance.sdk.component.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f27948a;

    /* renamed from: b  reason: collision with root package name */
    public x f27949b;

    /* renamed from: c  reason: collision with root package name */
    public a f27950c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f27951d;

    /* loaded from: classes5.dex */
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
        this.f27951d = true;
        this.f27948a = str;
        this.f27949b = xVar;
        this.f27950c = aVar;
    }
}
