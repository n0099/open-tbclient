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
    public int f66713a;

    /* renamed from: b  reason: collision with root package name */
    public int f66714b;

    /* renamed from: c  reason: collision with root package name */
    public float f66715c;

    /* renamed from: d  reason: collision with root package name */
    public int f66716d;

    /* renamed from: e  reason: collision with root package name */
    public int f66717e;

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
        this.f66713a = 1;
        this.f66714b = -1;
        this.f66715c = 1.0f;
        this.f66716d = 600;
        this.f66717e = 150;
        this.f66713a = i2;
        this.f66715c = f2;
        this.f66716d = i3;
        this.f66717e = i4;
    }
}
