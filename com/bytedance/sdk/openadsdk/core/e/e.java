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
    public boolean f66714a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f66715b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66716c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66717d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66718e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66719f;

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
        this.f66714a = true;
        this.f66715b = true;
        this.f66716c = true;
        this.f66717d = true;
        this.f66718e = true;
        this.f66719f = true;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "ClickArea{clickUpperContentArea=" + this.f66714a + ", clickUpperNonContentArea=" + this.f66715b + ", clickLowerContentArea=" + this.f66716c + ", clickLowerNonContentArea=" + this.f66717d + ", clickButtonArea=" + this.f66718e + ", clickVideoArea=" + this.f66719f + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
