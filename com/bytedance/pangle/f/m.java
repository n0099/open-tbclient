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
    public final ByteBuffer f62305a;

    /* renamed from: b  reason: collision with root package name */
    public final long f62306b;

    /* renamed from: c  reason: collision with root package name */
    public final long f62307c;

    /* renamed from: d  reason: collision with root package name */
    public final long f62308d;

    /* renamed from: e  reason: collision with root package name */
    public final ByteBuffer f62309e;

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
        this.f62305a = byteBuffer;
        this.f62306b = j;
        this.f62307c = j2;
        this.f62308d = j3;
        this.f62309e = byteBuffer2;
    }
}
