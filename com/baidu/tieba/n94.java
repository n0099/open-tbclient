package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.t23;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class n94 extends j94 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public long h;

    /* loaded from: classes7.dex */
    public class a implements t23.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ k94 b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ gj3 d;
        public final /* synthetic */ n94 e;

        public a(n94 n94Var, String str, k94 k94Var, boolean z, gj3 gj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n94Var, str, k94Var, Boolean.valueOf(z), gj3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = n94Var;
            this.a = str;
            this.b = k94Var;
            this.c = z;
            this.d = gj3Var;
        }

        @Override // com.baidu.tieba.t23.b
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.e.B(this.a, -1, "downloadFile:fail exceed max file size");
                this.b.cancelTag(this.e.c);
            }
        }

        @Override // com.baidu.tieba.t23.b
        public void b(int i, long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) && System.currentTimeMillis() - this.e.h > 500) {
                if (j2 <= 52428800 && j <= 52428800) {
                    if (i <= 100) {
                        m94 m94Var = new m94(i, j2, j);
                        JSEvent jSEvent = new JSEvent("progressUpdate");
                        jSEvent.data = m94Var;
                        this.e.dispatchEvent(jSEvent);
                    }
                    if (this.c && this.d.d().a(j)) {
                        this.e.B(this.a, -1, "downloadFile:fail exceed max file size");
                        this.b.cancelTag(this.e.c);
                    }
                } else {
                    this.e.B(this.a, -1, "downloadFile:fail exceed max file size");
                    this.b.cancelTag(this.e.c);
                }
                this.e.h = System.currentTimeMillis();
            }
        }

        @Override // com.baidu.tieba.t23.b
        public void c(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.e.B(this.a, 0, "progress callback fail()");
                this.b.cancelTag(this.e.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ gj3 d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ n94 f;

        public b(n94 n94Var, String str, String str2, String str3, gj3 gj3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n94Var, str, str2, str3, gj3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = n94Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = gj3Var;
            this.e = z;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.f.B(this.a, 0, iOException.getMessage());
                if (SwanAppNetworkUtils.i(null)) {
                    wh3.u(0, this.a, 1, iOException.getMessage());
                }
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                try {
                    JSEvent jSEvent = new JSEvent("headersReceived");
                    jSEvent.data = new w94(this.f.H(response.headers()));
                    this.f.dispatchEvent(jSEvent);
                } catch (JSONException e) {
                    if (n94.i) {
                        e.printStackTrace();
                    }
                }
                String str2 = null;
                try {
                    if (TextUtils.isEmpty(this.b)) {
                        str2 = gc3.A(this.f.H(response.headers()), this.c);
                    } else {
                        str2 = this.f.T(this.b);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                if (TextUtils.isEmpty(str2)) {
                    this.f.B(this.a, -1, "downloadFile:filePath is invalid");
                    return;
                }
                if (n94.i) {
                    Log.d("DownloadTask", "the real file path is " + str2);
                }
                if (TextUtils.isEmpty(this.b)) {
                    str = this.d.g(str2);
                } else {
                    str = this.b;
                }
                if (TextUtils.isEmpty(str)) {
                    this.f.B(this.a, -1, "parse tmpFilePath from realFilePath fail");
                    return;
                }
                int code = response.code();
                String message = response.message();
                o94 o94Var = new o94();
                o94Var.statusCode = code;
                if (TextUtils.isEmpty(this.b)) {
                    o94Var.tempFilePath = str;
                } else {
                    o94Var.filePath = str;
                }
                InputStream byteStream = response.body().byteStream();
                File file = new File(str2);
                if (file.exists()) {
                    long length = file.length();
                    file.delete();
                    if (this.e) {
                        this.d.d().b(-length);
                    }
                }
                if (this.f.U(byteStream, file)) {
                    if (this.e) {
                        this.d.d().b(file.length());
                    }
                    this.f.C(o94Var);
                } else {
                    this.f.B(this.a, -1, "downloadFile:fail abort");
                }
                hr4.d(byteStream);
                hr4.d(response);
                if (n94.i) {
                    Log.d("DownloadTask", "onResponse: respCode: " + code + ", url=" + this.a + ", msg=" + message);
                }
                wh3.u(code, this.a, 1, message);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947957280, "Lcom/baidu/tieba/n94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947957280, "Lcom/baidu/tieba/n94;");
                return;
            }
        }
        i = nr1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n94(ni2 ni2Var, k32 k32Var) {
        super(ni2Var, k32Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ni2Var, k32Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ni2) objArr2[0], (k32) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 2;
    }

    @Override // com.baidu.tieba.j94
    public void B(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            super.B(str, i2, str2);
            xb4.c(str, i2, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public void S(Request request, String str, String str2, k94 k94Var, p94 p94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, str, str2, k94Var, p94Var) == null) {
            String httpUrl = request.url().toString();
            gj3 G = qw2.T().G();
            boolean b2 = G.b(str);
            wh3.A(httpUrl, 1);
            k94Var.call(request, Collections.singletonList(p94Var), new b(this, httpUrl, str, str2, G, b2));
        }
    }

    @Nullable
    public String T(@NonNull String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String i2 = qw2.T().G().i(str);
            if (i2 == null) {
                return null;
            }
            boolean endsWith = i2.endsWith(File.separator);
            File parentFile = new File(i2).getParentFile();
            if (parentFile != null && parentFile.exists()) {
                z = true;
            } else {
                z = false;
            }
            if (endsWith || !z) {
                return null;
            }
            return i2;
        }
        return (String) invokeL.objValue;
    }

    public boolean U(InputStream inputStream, File file) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, inputStream, file)) == null) {
            if (inputStream == null || file == null) {
                return false;
            }
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        hr4.d(fileOutputStream);
                        return true;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                hr4.d(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                hr4.d(fileOutputStream2);
                throw th;
            }
        } else {
            return invokeLL.booleanValue;
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.b == null) {
            return;
        }
        String y = y();
        if (TextUtils.isEmpty(y)) {
            return;
        }
        if (db3.M() == null) {
            B("", -1, "request:swanApp is null");
            return;
        }
        k94 k94Var = (k94) db3.M().i0();
        String B = this.b.B("filePath");
        if (!TextUtils.isEmpty(B)) {
            if (hr4.x(B)) {
                B(y, -1, "downloadFile:filePath is invalid");
                return;
            }
            String[] split = B.split("/");
            if (TextUtils.isEmpty(split[split.length - 1])) {
                B(y, -1, "downloadFile:filePath is invalid");
                return;
            }
        }
        gj3 G = qw2.T().G();
        boolean b2 = G.b(B);
        if (b2 && G.d().a(0L)) {
            B(y, -1, "downloadFile:fail exceed max size in usr");
            return;
        }
        HashMap hashMap = new HashMap();
        Request.Builder builder = new Request.Builder();
        F(builder, this.b.w("header"), hashMap, false);
        builder.url(y).tag(this.c).build();
        String t = hr4.t(y);
        this.h = 0L;
        p94 p94Var = new p94();
        p94Var.c(new a(this, y, k94Var, b2, G));
        S(builder.build(), B, t, k94Var, p94Var);
    }
}
