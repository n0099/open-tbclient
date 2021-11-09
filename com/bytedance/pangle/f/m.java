package com.bytedance.pangle.f;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public final class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f61406a;

    /* renamed from: b  reason: collision with root package name */
    public final long f61407b;

    /* renamed from: c  reason: collision with root package name */
    public final long f61408c;

    /* renamed from: d  reason: collision with root package name */
    public final long f61409d;

    /* renamed from: e  reason: collision with root package name */
    public final ByteBuffer f61410e;

    public m(ByteBuffer byteBuffer, long j, long j2, long j3, ByteBuffer byteBuffer2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byteBuffer, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), byteBuffer2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61406a = byteBuffer;
        this.f61407b = j;
        this.f61408c = j2;
        this.f61409d = j3;
        this.f61410e = byteBuffer2;
    }
}
