package com.bytedance.sdk.component.adnet.b;

import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.component.adnet.core.Header;
import com.bytedance.sdk.component.adnet.core.HttpResponse;
import com.bytedance.sdk.component.adnet.core.Request;
import com.bytedance.sdk.component.adnet.core.i;
import com.bytedance.sdk.component.adnet.core.m;
import com.bytedance.sdk.component.adnet.core.o;
import com.bytedance.sdk.component.adnet.err.VAdError;
import com.bytedance.sdk.component.adnet.err.f;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
/* loaded from: classes5.dex */
public class a extends Request<File> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public File f28004c;

    /* renamed from: d  reason: collision with root package name */
    public File f28005d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f28006e;
    @Nullable
    @GuardedBy("mLock")

    /* renamed from: f  reason: collision with root package name */
    public m.a<File> f28007f;

    /* renamed from: com.bytedance.sdk.component.adnet.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0315a extends m.a<File> {
        void a(long j, long j2);
    }

    private boolean b(HttpResponse httpResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, httpResponse)) == null) ? TextUtils.equals(a(httpResponse, "Content-Encoding"), AsyncHttpClient.ENCODING_GZIP) : invokeL.booleanValue;
    }

    private boolean c(HttpResponse httpResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, httpResponse)) == null) {
            if (TextUtils.equals(a(httpResponse, Util.ACCEPT_RANGES), "bytes")) {
                return true;
            }
            String a2 = a(httpResponse, "Content-Range");
            return a2 != null && a2.startsWith("bytes");
        }
        return invokeL.booleanValue;
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            try {
                this.f28004c.delete();
            } catch (Throwable unused) {
            }
            try {
                this.f28005d.delete();
            } catch (Throwable unused2) {
            }
        }
    }

    @Override // com.bytedance.sdk.component.adnet.core.Request
    public m<File> a(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iVar)) == null) {
            if (!isCanceled()) {
                if (this.f28005d.canRead() && this.f28005d.length() > 0) {
                    if (this.f28005d.renameTo(this.f28004c)) {
                        return m.a((Object) null, com.bytedance.sdk.component.adnet.d.b.a(iVar));
                    }
                    h();
                    return m.a(new VAdError("Can't rename the download temporary file!", 609));
                }
                h();
                return m.a(new VAdError("Download temporary file was invalid!", 610));
            }
            h();
            return m.a(new VAdError("Request was Canceled!", 611));
        }
        return (m) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.adnet.core.Request
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.cancel();
            synchronized (this.f28006e) {
                this.f28007f = null;
            }
        }
    }

    public File f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f28004c : (File) invokeV.objValue;
    }

    public File g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f28005d : (File) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.adnet.core.Request
    public Map<String, String> getHeaders() throws com.bytedance.sdk.component.adnet.err.a {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("Range", "bytes=" + this.f28005d.length() + "-");
            hashMap.put("Accept-Encoding", "identity");
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.adnet.core.Request
    public Request.b getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? Request.b.f28056a : (Request.b) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0178 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] a(HttpResponse httpResponse) throws IOException, f {
        InterceptResult invokeL;
        RandomAccessFile randomAccessFile;
        int i2;
        InputStream inputStream;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, httpResponse)) == null) {
            long contentLength = httpResponse.getContentLength();
            if (contentLength <= 0) {
                o.b("Response doesn't present Content-Length!", new Object[0]);
            }
            long length = g().length();
            boolean c2 = c(httpResponse);
            if (c2) {
                contentLength += length;
                String a2 = a(httpResponse, "Content-Range");
                if (!TextUtils.isEmpty(a2)) {
                    String str = "bytes " + length + "-" + (contentLength - 1);
                    if (TextUtils.indexOf(a2, str) == -1) {
                        throw new IllegalStateException("The Content-Range Header is invalid Assume[" + str + "] vs Real[" + a2 + "], please remove the temporary file [" + g() + "].");
                    }
                }
            }
            if (contentLength > 0 && f().length() == contentLength) {
                f().renameTo(g());
                a(contentLength, contentLength);
                return null;
            }
            if (f() != null && f().exists()) {
                f().delete();
            }
            try {
                randomAccessFile = new RandomAccessFile(g(), "rw");
                try {
                    if (c2) {
                        randomAccessFile.seek(length);
                    } else {
                        randomAccessFile.setLength(0L);
                        length = 0;
                    }
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                randomAccessFile = null;
            }
            try {
                inputStream = httpResponse.getContent();
                try {
                    if (b(httpResponse) && !(inputStream instanceof GZIPInputStream)) {
                        inputStream = new GZIPInputStream(inputStream);
                    }
                    byte[] bArr = new byte[1024];
                    a(length, contentLength);
                    do {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        randomAccessFile.write(bArr, 0, read);
                        length += read;
                        a(length, contentLength);
                    } while (!isCanceled());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused3) {
                            i4 = 0;
                            o.a("Error occured when calling InputStream.close", new Object[0]);
                        }
                    }
                    i4 = 0;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused4) {
                            o.a("Error occured when calling consumingContent", new Object[i4]);
                        }
                    }
                    try {
                        randomAccessFile.close();
                    } catch (Throwable unused5) {
                        o.a("Error occured when calling tmpFile.close", new Object[i4]);
                    }
                } catch (Throwable unused6) {
                    i2 = 0;
                    try {
                        o.a("Error occured when FileRequest.parseHttpResponse", new Object[i2]);
                        h();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused7) {
                                o.a("Error occured when calling InputStream.close", new Object[i2]);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused8) {
                                o.a("Error occured when calling consumingContent", new Object[i2]);
                            }
                        }
                        try {
                            randomAccessFile.close();
                        } catch (Throwable unused9) {
                            o.a("Error occured when calling tmpFile.close", new Object[i2]);
                        }
                        return null;
                    } catch (Throwable th) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused10) {
                                i3 = 0;
                                o.a("Error occured when calling InputStream.close", new Object[0]);
                                if (inputStream != null) {
                                }
                                randomAccessFile.close();
                                throw th;
                            }
                        }
                        i3 = 0;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused11) {
                                o.a("Error occured when calling consumingContent", new Object[i3]);
                            }
                        }
                        try {
                            randomAccessFile.close();
                        } catch (Throwable unused12) {
                            o.a("Error occured when calling tmpFile.close", new Object[i3]);
                        }
                        throw th;
                    }
                }
            } catch (Throwable unused13) {
                i2 = 0;
                inputStream = null;
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    private String a(HttpResponse httpResponse, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, this, httpResponse, str)) == null) {
            if (httpResponse == null || httpResponse.getHeaders() == null || httpResponse.getHeaders().isEmpty()) {
                return null;
            }
            for (Header header : httpResponse.getHeaders()) {
                if (header != null && TextUtils.equals(header.getName(), str)) {
                    return header.getValue();
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.bytedance.sdk.component.adnet.core.Request
    public void a(m<File> mVar) {
        m.a<File> aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
            synchronized (this.f28006e) {
                aVar = this.f28007f;
            }
            if (aVar != null) {
                aVar.a(m.a(this.f28004c, mVar.f28130b));
            }
        }
    }

    @Override // com.bytedance.sdk.component.adnet.core.Request
    public void a(long j, long j2) {
        m.a<File> aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            synchronized (this.f28006e) {
                aVar = this.f28007f;
            }
            if (aVar instanceof InterfaceC0315a) {
                ((InterfaceC0315a) aVar).a(j, j2);
            }
        }
    }
}
