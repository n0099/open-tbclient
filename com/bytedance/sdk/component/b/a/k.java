package com.bytedance.sdk.component.b.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* loaded from: classes9.dex */
public final class k implements s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final e f64767a;

    /* renamed from: b  reason: collision with root package name */
    public final Inflater f64768b;

    /* renamed from: c  reason: collision with root package name */
    public int f64769c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64770d;

    public k(e eVar, Inflater inflater) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, inflater};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater != null) {
            this.f64767a = eVar;
            this.f64768b = inflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }

    private void c() throws IOException {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (i2 = this.f64769c) == 0) {
            return;
        }
        int remaining = i2 - this.f64768b.getRemaining();
        this.f64769c -= remaining;
        this.f64767a.h(remaining);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0058, code lost:
        c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
        if (r1.f64785b != r1.f64786c) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0061, code lost:
        r7.f64751a = r1.b();
        com.bytedance.sdk.component.b.a.p.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
        return -1;
     */
    @Override // com.bytedance.sdk.component.b.a.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long a(c cVar, long j2) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLJ = interceptable.invokeLJ(1048576, this, cVar, j2)) != null) {
            return invokeLJ.longValue;
        }
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 >= 0) {
            if (this.f64770d) {
                throw new IllegalStateException("closed");
            }
            if (i2 == 0) {
                return 0L;
            }
            while (true) {
                boolean b2 = b();
                try {
                    o e2 = cVar.e(1);
                    int inflate = this.f64768b.inflate(e2.f64784a, e2.f64786c, (int) Math.min(j2, 8192 - e2.f64786c));
                    if (inflate > 0) {
                        e2.f64786c += inflate;
                        long j3 = inflate;
                        cVar.f64752b += j3;
                        return j3;
                    } else if (this.f64768b.finished() || this.f64768b.needsDictionary()) {
                        break;
                    } else if (b2) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e3) {
                    throw new IOException(e3);
                }
            }
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }
    }

    public final boolean b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f64768b.needsInput()) {
                c();
                if (this.f64768b.getRemaining() == 0) {
                    if (this.f64767a.e()) {
                        return true;
                    }
                    o oVar = this.f64767a.c().f64751a;
                    int i2 = oVar.f64786c;
                    int i3 = oVar.f64785b;
                    int i4 = i2 - i3;
                    this.f64769c = i4;
                    this.f64768b.setInput(oVar.f64784a, i3, i4);
                    return false;
                }
                throw new IllegalStateException("?");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.component.b.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f64770d) {
            return;
        }
        this.f64768b.end();
        this.f64770d = true;
        this.f64767a.close();
    }

    @Override // com.bytedance.sdk.component.b.a.s
    public t a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64767a.a() : (t) invokeV.objValue;
    }
}
