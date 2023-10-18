package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.fx2;
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
/* loaded from: classes9.dex */
public class z34 extends v34 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public long h;

    /* loaded from: classes9.dex */
    public class a implements fx2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ w34 b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ sd3 d;
        public final /* synthetic */ z34 e;

        public a(z34 z34Var, String str, w34 w34Var, boolean z, sd3 sd3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z34Var, str, w34Var, Boolean.valueOf(z), sd3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = z34Var;
            this.a = str;
            this.b = w34Var;
            this.c = z;
            this.d = sd3Var;
        }

        @Override // com.baidu.tieba.fx2.b
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.e.B(this.a, -1, "downloadFile:fail exceed max file size");
                this.b.cancelTag(this.e.c);
            }
        }

        @Override // com.baidu.tieba.fx2.b
        public void b(int i, long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) && System.currentTimeMillis() - this.e.h > 500) {
                if (j2 <= 52428800 && j <= 52428800) {
                    if (i <= 100) {
                        y34 y34Var = new y34(i, j2, j);
                        JSEvent jSEvent = new JSEvent("progressUpdate");
                        jSEvent.data = y34Var;
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

        @Override // com.baidu.tieba.fx2.b
        public void c(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.e.B(this.a, 0, "progress callback fail()");
                this.b.cancelTag(this.e.c);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ sd3 d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ z34 f;

        public b(z34 z34Var, String str, String str2, String str3, sd3 sd3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z34Var, str, str2, str3, sd3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = z34Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = sd3Var;
            this.e = z;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.f.B(this.a, 0, iOException.getMessage());
                if (SwanAppNetworkUtils.i(null)) {
                    ic3.u(0, this.a, 1, iOException.getMessage());
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
                    jSEvent.data = new i44(this.f.H(response.headers()));
                    this.f.dispatchEvent(jSEvent);
                } catch (JSONException e) {
                    if (z34.i) {
                        e.printStackTrace();
                    }
                }
                String str2 = null;
                try {
                    if (TextUtils.isEmpty(this.b)) {
                        str2 = s63.A(this.f.H(response.headers()), this.c);
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
                if (z34.i) {
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
                a44 a44Var = new a44();
                a44Var.statusCode = code;
                if (TextUtils.isEmpty(this.b)) {
                    a44Var.tempFilePath = str;
                } else {
                    a44Var.filePath = str;
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
                    this.f.C(a44Var);
                } else {
                    this.f.B(this.a, -1, "downloadFile:fail abort");
                }
                sl4.d(byteStream);
                sl4.d(response);
                if (z34.i) {
                    Log.d("DownloadTask", "onResponse: respCode: " + code + ", url=" + this.a + ", msg=" + message);
                }
                ic3.u(code, this.a, 1, message);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948309006, "Lcom/baidu/tieba/z34;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948309006, "Lcom/baidu/tieba/z34;");
                return;
            }
        }
        i = am1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z34(zc2 zc2Var, xx1 xx1Var) {
        super(zc2Var, xx1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zc2Var, xx1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((zc2) objArr2[0], (xx1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 2;
    }

    @Override // com.baidu.tieba.v34
    public void B(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            super.B(str, i2, str2);
            j64.c(str, i2, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public void S(Request request, String str, String str2, w34 w34Var, b44 b44Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, str, str2, w34Var, b44Var) == null) {
            String httpUrl = request.url().toString();
            sd3 I = cr2.V().I();
            boolean b2 = I.b(str);
            ic3.A(httpUrl, 1);
            w34Var.a(request, Collections.singletonList(b44Var), new b(this, httpUrl, str, str2, I, b2));
        }
    }

    @Nullable
    public String T(@NonNull String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String i2 = cr2.V().I().i(str);
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
                        sl4.d(fileOutputStream);
                        return true;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                sl4.d(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                sl4.d(fileOutputStream2);
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
        if (p53.M() == null) {
            B("", -1, "request:swanApp is null");
            return;
        }
        w34 w34Var = (w34) p53.M().j0();
        String C = this.b.C("filePath");
        if (!TextUtils.isEmpty(C)) {
            if (sl4.x(C)) {
                B(y, -1, "downloadFile:filePath is invalid");
                return;
            }
            String[] split = C.split("/");
            if (TextUtils.isEmpty(split[split.length - 1])) {
                B(y, -1, "downloadFile:filePath is invalid");
                return;
            }
        }
        sd3 I = cr2.V().I();
        boolean b2 = I.b(C);
        if (b2 && I.d().a(0L)) {
            B(y, -1, "downloadFile:fail exceed max size in usr");
            return;
        }
        HashMap hashMap = new HashMap();
        Request.Builder builder = new Request.Builder();
        F(builder, this.b.x("header"), hashMap, false);
        builder.url(y).tag(this.c).build();
        String t = sl4.t(y);
        this.h = 0L;
        b44 b44Var = new b44();
        b44Var.c(new a(this, y, w34Var, b2, I));
        S(builder.build(), C, t, w34Var, b44Var);
    }
}
