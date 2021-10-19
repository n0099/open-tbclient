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
    public boolean f66749a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f66750b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66751c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66752d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66753e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66754f;

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
        this.f66749a = true;
        this.f66750b = true;
        this.f66751c = true;
        this.f66752d = true;
        this.f66753e = true;
        this.f66754f = true;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "ClickArea{clickUpperContentArea=" + this.f66749a + ", clickUpperNonContentArea=" + this.f66750b + ", clickLowerContentArea=" + this.f66751c + ", clickLowerNonContentArea=" + this.f66752d + ", clickButtonArea=" + this.f66753e + ", clickVideoArea=" + this.f66754f + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
