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
    public boolean f66403a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f66404b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66405c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66406d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66407e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66408f;

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
        this.f66403a = true;
        this.f66404b = true;
        this.f66405c = true;
        this.f66406d = true;
        this.f66407e = true;
        this.f66408f = true;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "ClickArea{clickUpperContentArea=" + this.f66403a + ", clickUpperNonContentArea=" + this.f66404b + ", clickLowerContentArea=" + this.f66405c + ", clickLowerNonContentArea=" + this.f66406d + ", clickButtonArea=" + this.f66407e + ", clickVideoArea=" + this.f66408f + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
