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
    public boolean f30020a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30021b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30022c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30023d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30024e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f30025f;

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
        this.f30020a = true;
        this.f30021b = true;
        this.f30022c = true;
        this.f30023d = true;
        this.f30024e = true;
        this.f30025f = true;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "ClickArea{clickUpperContentArea=" + this.f30020a + ", clickUpperNonContentArea=" + this.f30021b + ", clickLowerContentArea=" + this.f30022c + ", clickLowerNonContentArea=" + this.f30023d + ", clickButtonArea=" + this.f30024e + ", clickVideoArea=" + this.f30025f + '}';
        }
        return (String) invokeV.objValue;
    }
}
