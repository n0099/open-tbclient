package com.bytedance.sdk.openadsdk.core.nativeexpress;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f66513a;

    /* renamed from: b  reason: collision with root package name */
    public int f66514b;

    /* renamed from: c  reason: collision with root package name */
    public float f66515c;

    /* renamed from: d  reason: collision with root package name */
    public int f66516d;

    /* renamed from: e  reason: collision with root package name */
    public int f66517e;

    public k(int i2, float f2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66513a = 1;
        this.f66514b = -1;
        this.f66515c = 1.0f;
        this.f66516d = 600;
        this.f66517e = 150;
        this.f66513a = i2;
        this.f66515c = f2;
        this.f66516d = i3;
        this.f66517e = i4;
    }
}
