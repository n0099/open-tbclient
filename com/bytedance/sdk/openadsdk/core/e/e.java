package com.bytedance.sdk.openadsdk.core.e;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f66023a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f66024b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66025c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66026d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66027e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66028f;

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
        this.f66023a = true;
        this.f66024b = true;
        this.f66025c = true;
        this.f66026d = true;
        this.f66027e = true;
        this.f66028f = true;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "ClickArea{clickUpperContentArea=" + this.f66023a + ", clickUpperNonContentArea=" + this.f66024b + ", clickLowerContentArea=" + this.f66025c + ", clickLowerNonContentArea=" + this.f66026d + ", clickButtonArea=" + this.f66027e + ", clickVideoArea=" + this.f66028f + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
