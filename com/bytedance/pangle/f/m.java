package com.bytedance.pangle.f;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public final class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ByteBuffer a;

    /* renamed from: b  reason: collision with root package name */
    public final long f53282b;

    /* renamed from: c  reason: collision with root package name */
    public final long f53283c;

    /* renamed from: d  reason: collision with root package name */
    public final long f53284d;

    /* renamed from: e  reason: collision with root package name */
    public final ByteBuffer f53285e;

    public m(ByteBuffer byteBuffer, long j2, long j3, long j4, ByteBuffer byteBuffer2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byteBuffer, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), byteBuffer2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = byteBuffer;
        this.f53282b = j2;
        this.f53283c = j3;
        this.f53284d = j4;
        this.f53285e = byteBuffer2;
    }
}
