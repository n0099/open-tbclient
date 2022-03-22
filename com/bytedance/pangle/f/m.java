package com.bytedance.pangle.f;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public final class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ByteBuffer a;

    /* renamed from: b  reason: collision with root package name */
    public final long f38122b;

    /* renamed from: c  reason: collision with root package name */
    public final long f38123c;

    /* renamed from: d  reason: collision with root package name */
    public final long f38124d;

    /* renamed from: e  reason: collision with root package name */
    public final ByteBuffer f38125e;

    public m(ByteBuffer byteBuffer, long j, long j2, long j3, ByteBuffer byteBuffer2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byteBuffer, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), byteBuffer2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = byteBuffer;
        this.f38122b = j;
        this.f38123c = j2;
        this.f38124d = j3;
        this.f38125e = byteBuffer2;
    }
}
