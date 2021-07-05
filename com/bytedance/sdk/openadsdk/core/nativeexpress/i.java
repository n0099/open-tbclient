package com.bytedance.sdk.openadsdk.core.nativeexpress;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f30332a;

    /* renamed from: b  reason: collision with root package name */
    public int f30333b;

    /* renamed from: c  reason: collision with root package name */
    public float f30334c;

    /* renamed from: d  reason: collision with root package name */
    public int f30335d;

    /* renamed from: e  reason: collision with root package name */
    public int f30336e;

    public i(int i2, float f2, int i3, int i4) {
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
        this.f30332a = 1;
        this.f30333b = -1;
        this.f30334c = 1.0f;
        this.f30335d = 600;
        this.f30336e = 150;
        this.f30332a = i2;
        this.f30334c = f2;
        this.f30335d = i3;
        this.f30336e = i4;
    }
}
