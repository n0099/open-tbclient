package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.ay2;
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
/* loaded from: classes8.dex */
public class u44 extends q44 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public long h;

    /* loaded from: classes8.dex */
    public class a implements ay2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ r44 b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ ne3 d;
        public final /* synthetic */ u44 e;

        public a(u44 u44Var, String str, r44 r44Var, boolean z, ne3 ne3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u44Var, str, r44Var, Boolean.valueOf(z), ne3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = u44Var;
            this.a = str;
            this.b = r44Var;
            this.c = z;
            this.d = ne3Var;
        }

        @Override // com.baidu.tieba.ay2.b
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.e.B(this.a, -1, "downloadFile:fail exceed max file size");
                this.b.cancelTag(this.e.c);
            }
        }

        @Override // com.baidu.tieba.ay2.b
        public void b(int i, long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) && System.currentTimeMillis() - this.e.h > 500) {
                if (j2 <= 52428800 && j <= 52428800) {
                    if (i <= 100) {
                        t44 t44Var = new t44(i, j2, j);
                        JSEvent jSEvent = new JSEvent("progressUpdate");
                        jSEvent.data = t44Var;
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

        @Override // com.baidu.tieba.ay2.b
        public void c(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.e.B(this.a, 0, "progress callback fail()");
                this.b.cancelTag(this.e.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ne3 d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ u44 f;

        public b(u44 u44Var, String str, String str2, String str3, ne3 ne3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u44Var, str, str2, str3, ne3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = u44Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = ne3Var;
            this.e = z;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.f.B(this.a, 0, iOException.getMessage());
                if (SwanAppNetworkUtils.i(null)) {
                    dd3.u(0, this.a, 1, iOException.getMessage());
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
                    jSEvent.data = new d54(this.f.H(response.headers()));
                    this.f.dispatchEvent(jSEvent);
                } catch (JSONException e) {
                    if (u44.i) {
                        e.printStackTrace();
                    }
                }
                String str2 = null;
                try {
                    if (TextUtils.isEmpty(this.b)) {
                        str2 = n73.A(this.f.H(response.headers()), this.c);
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
                if (u44.i) {
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
                v44 v44Var = new v44();
                v44Var.statusCode = code;
                if (TextUtils.isEmpty(this.b)) {
                    v44Var.tempFilePath = str;
                } else {
                    v44Var.filePath = str;
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
                    this.f.C(v44Var);
                } else {
                    this.f.B(this.a, -1, "downloadFile:fail abort");
                }
                nm4.d(byteStream);
                nm4.d(response);
                if (u44.i) {
                    Log.d("DownloadTask", "onResponse: respCode: " + code + ", url=" + this.a + ", msg=" + message);
                }
                dd3.u(code, this.a, 1, message);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948161012, "Lcom/baidu/tieba/u44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948161012, "Lcom/baidu/tieba/u44;");
                return;
            }
        }
        i = vm1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u44(ud2 ud2Var, sy1 sy1Var) {
        super(ud2Var, sy1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ud2Var, sy1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ud2) objArr2[0], (sy1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 2;
    }

    @Override // com.baidu.tieba.q44
    public void B(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            super.B(str, i2, str2);
            e74.c(str, i2, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public void S(Request request, String str, String str2, r44 r44Var, w44 w44Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, str, str2, r44Var, w44Var) == null) {
            String httpUrl = request.url().toString();
            ne3 I = xr2.V().I();
            boolean b2 = I.b(str);
            dd3.A(httpUrl, 1);
            r44Var.a(request, Collections.singletonList(w44Var), new b(this, httpUrl, str, str2, I, b2));
        }
    }

    @Nullable
    public String T(@NonNull String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String i2 = xr2.V().I().i(str);
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
                        nm4.d(fileOutputStream);
                        return true;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                nm4.d(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                nm4.d(fileOutputStream2);
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
        if (k63.M() == null) {
            B("", -1, "request:swanApp is null");
            return;
        }
        r44 r44Var = (r44) k63.M().j0();
        String C = this.b.C("filePath");
        if (!TextUtils.isEmpty(C)) {
            if (nm4.x(C)) {
                B(y, -1, "downloadFile:filePath is invalid");
                return;
            }
            String[] split = C.split("/");
            if (TextUtils.isEmpty(split[split.length - 1])) {
                B(y, -1, "downloadFile:filePath is invalid");
                return;
            }
        }
        ne3 I = xr2.V().I();
        boolean b2 = I.b(C);
        if (b2 && I.d().a(0L)) {
            B(y, -1, "downloadFile:fail exceed max size in usr");
            return;
        }
        HashMap hashMap = new HashMap();
        Request.Builder builder = new Request.Builder();
        F(builder, this.b.x("header"), hashMap, false);
        builder.url(y).tag(this.c).build();
        String t = nm4.t(y);
        this.h = 0L;
        w44 w44Var = new w44();
        w44Var.c(new a(this, y, r44Var, b2, I));
        S(builder.build(), C, t, r44Var, w44Var);
    }
}
