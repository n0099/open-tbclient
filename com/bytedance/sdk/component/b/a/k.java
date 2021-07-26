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
/* loaded from: classes5.dex */
public final class k implements s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final e f28198a;

    /* renamed from: b  reason: collision with root package name */
    public final Inflater f28199b;

    /* renamed from: c  reason: collision with root package name */
    public int f28200c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f28201d;

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
            this.f28198a = eVar;
            this.f28199b = inflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }

    private void c() throws IOException {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (i2 = this.f28200c) == 0) {
            return;
        }
        int remaining = i2 - this.f28199b.getRemaining();
        this.f28200c -= remaining;
        this.f28198a.h(remaining);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0058, code lost:
        c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
        if (r1.f28216b != r1.f28217c) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0061, code lost:
        r7.f28182a = r1.b();
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
    public long a(c cVar, long j) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLJ = interceptable.invokeLJ(1048576, this, cVar, j)) != null) {
            return invokeLJ.longValue;
        }
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 >= 0) {
            if (this.f28201d) {
                throw new IllegalStateException("closed");
            }
            if (i2 == 0) {
                return 0L;
            }
            while (true) {
                boolean b2 = b();
                try {
                    o e2 = cVar.e(1);
                    int inflate = this.f28199b.inflate(e2.f28215a, e2.f28217c, (int) Math.min(j, 8192 - e2.f28217c));
                    if (inflate > 0) {
                        e2.f28217c += inflate;
                        long j2 = inflate;
                        cVar.f28183b += j2;
                        return j2;
                    } else if (this.f28199b.finished() || this.f28199b.needsDictionary()) {
                        break;
                    } else if (b2) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e3) {
                    throw new IOException(e3);
                }
            }
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
    }

    public final boolean b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f28199b.needsInput()) {
                c();
                if (this.f28199b.getRemaining() == 0) {
                    if (this.f28198a.e()) {
                        return true;
                    }
                    o oVar = this.f28198a.c().f28182a;
                    int i2 = oVar.f28217c;
                    int i3 = oVar.f28216b;
                    int i4 = i2 - i3;
                    this.f28200c = i4;
                    this.f28199b.setInput(oVar.f28215a, i3, i4);
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
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f28201d) {
            return;
        }
        this.f28199b.end();
        this.f28201d = true;
        this.f28198a.close();
    }

    @Override // com.bytedance.sdk.component.b.a.s
    public t a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28198a.a() : (t) invokeV.objValue;
    }
}
