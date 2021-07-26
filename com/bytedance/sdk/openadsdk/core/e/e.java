package com.bytedance.sdk.openadsdk.core.e;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f30120a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30121b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30122c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30123d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30124e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f30125f;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30120a = true;
        this.f30121b = true;
        this.f30122c = true;
        this.f30123d = true;
        this.f30124e = true;
        this.f30125f = true;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "ClickArea{clickUpperContentArea=" + this.f30120a + ", clickUpperNonContentArea=" + this.f30121b + ", clickLowerContentArea=" + this.f30122c + ", clickLowerNonContentArea=" + this.f30123d + ", clickButtonArea=" + this.f30124e + ", clickVideoArea=" + this.f30125f + '}';
        }
        return (String) invokeV.objValue;
    }
}
