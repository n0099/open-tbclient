package com.bytedance.sdk.component.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f27789a;

    /* renamed from: b  reason: collision with root package name */
    public w f27790b;

    /* renamed from: c  reason: collision with root package name */
    public a f27791c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f27792d;

    /* loaded from: classes5.dex */
    public interface a {
    }

    public s(String str, w wVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, wVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27792d = true;
        this.f27789a = str;
        this.f27790b = wVar;
        this.f27791c = aVar;
    }
}
