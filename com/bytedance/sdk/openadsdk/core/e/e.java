package com.bytedance.sdk.openadsdk.core.e;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f29910a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f29911b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f29912c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f29913d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f29914e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29915f;

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
        this.f29910a = true;
        this.f29911b = true;
        this.f29912c = true;
        this.f29913d = true;
        this.f29914e = true;
        this.f29915f = true;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "ClickArea{clickUpperContentArea=" + this.f29910a + ", clickUpperNonContentArea=" + this.f29911b + ", clickLowerContentArea=" + this.f29912c + ", clickLowerNonContentArea=" + this.f29913d + ", clickButtonArea=" + this.f29914e + ", clickVideoArea=" + this.f29915f + '}';
        }
        return (String) invokeV.objValue;
    }
}
