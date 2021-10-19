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
    public int f67239a;

    /* renamed from: b  reason: collision with root package name */
    public int f67240b;

    /* renamed from: c  reason: collision with root package name */
    public float f67241c;

    /* renamed from: d  reason: collision with root package name */
    public int f67242d;

    /* renamed from: e  reason: collision with root package name */
    public int f67243e;

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
        this.f67239a = 1;
        this.f67240b = -1;
        this.f67241c = 1.0f;
        this.f67242d = 600;
        this.f67243e = 150;
        this.f67239a = i2;
        this.f67241c = f2;
        this.f67242d = i3;
        this.f67243e = i4;
    }
}
