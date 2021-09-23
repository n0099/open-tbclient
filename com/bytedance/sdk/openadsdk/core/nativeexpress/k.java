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
    public int f67204a;

    /* renamed from: b  reason: collision with root package name */
    public int f67205b;

    /* renamed from: c  reason: collision with root package name */
    public float f67206c;

    /* renamed from: d  reason: collision with root package name */
    public int f67207d;

    /* renamed from: e  reason: collision with root package name */
    public int f67208e;

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
        this.f67204a = 1;
        this.f67205b = -1;
        this.f67206c = 1.0f;
        this.f67207d = 600;
        this.f67208e = 150;
        this.f67204a = i2;
        this.f67206c = f2;
        this.f67207d = i3;
        this.f67208e = i4;
    }
}
