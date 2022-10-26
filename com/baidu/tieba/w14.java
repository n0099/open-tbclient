package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.cv2;
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
/* loaded from: classes6.dex */
public class w14 extends s14 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public long h;

    /* loaded from: classes6.dex */
    public class a implements cv2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ t14 b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ pb3 d;
        public final /* synthetic */ w14 e;

        public a(w14 w14Var, String str, t14 t14Var, boolean z, pb3 pb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w14Var, str, t14Var, Boolean.valueOf(z), pb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = w14Var;
            this.a = str;
            this.b = t14Var;
            this.c = z;
            this.d = pb3Var;
        }

        @Override // com.baidu.tieba.cv2.b
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.e.C(this.a, -1, "downloadFile:fail exceed max file size");
                this.b.cancelTag(this.e.c);
            }
        }

        @Override // com.baidu.tieba.cv2.b
        public void b(int i, long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) && System.currentTimeMillis() - this.e.h > 500) {
                if (j2 <= 52428800 && j <= 52428800) {
                    if (i <= 100) {
                        v14 v14Var = new v14(i, j2, j);
                        JSEvent jSEvent = new JSEvent("progressUpdate");
                        jSEvent.data = v14Var;
                        this.e.dispatchEvent(jSEvent);
                    }
                    if (this.c && this.d.d().a(j)) {
                        this.e.C(this.a, -1, "downloadFile:fail exceed max file size");
                        this.b.cancelTag(this.e.c);
                    }
                } else {
                    this.e.C(this.a, -1, "downloadFile:fail exceed max file size");
                    this.b.cancelTag(this.e.c);
                }
                this.e.h = System.currentTimeMillis();
            }
        }

        @Override // com.baidu.tieba.cv2.b
        public void c(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.e.C(this.a, 0, "progress callback fail()");
                this.b.cancelTag(this.e.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ pb3 d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ w14 f;

        public b(w14 w14Var, String str, String str2, String str3, pb3 pb3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w14Var, str, str2, str3, pb3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = w14Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = pb3Var;
            this.e = z;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.f.C(this.a, 0, iOException.getMessage());
                if (SwanAppNetworkUtils.i(null)) {
                    fa3.u(0, this.a, 1, iOException.getMessage());
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
                    jSEvent.data = new f24(this.f.I(response.headers()));
                    this.f.dispatchEvent(jSEvent);
                } catch (JSONException e) {
                    if (w14.i) {
                        e.printStackTrace();
                    }
                }
                String str2 = null;
                try {
                    if (TextUtils.isEmpty(this.b)) {
                        str2 = p43.A(this.f.I(response.headers()), this.c);
                    } else {
                        str2 = this.f.U(this.b);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                if (TextUtils.isEmpty(str2)) {
                    this.f.C(this.a, -1, "downloadFile:filePath is invalid");
                    return;
                }
                if (w14.i) {
                    Log.d("DownloadTask", "the real file path is " + str2);
                }
                if (TextUtils.isEmpty(this.b)) {
                    str = this.d.g(str2);
                } else {
                    str = this.b;
                }
                if (TextUtils.isEmpty(str)) {
                    this.f.C(this.a, -1, "parse tmpFilePath from realFilePath fail");
                    return;
                }
                int code = response.code();
                String message = response.message();
                x14 x14Var = new x14();
                x14Var.statusCode = code;
                if (TextUtils.isEmpty(this.b)) {
                    x14Var.tempFilePath = str;
                } else {
                    x14Var.filePath = str;
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
                if (this.f.V(byteStream, file)) {
                    if (this.e) {
                        this.d.d().b(file.length());
                    }
                    this.f.D(x14Var);
                } else {
                    this.f.C(this.a, -1, "downloadFile:fail abort");
                }
                qj4.d(byteStream);
                qj4.d(response);
                if (w14.i) {
                    Log.d("DownloadTask", "onResponse: respCode: " + code + ", url=" + this.a + ", msg=" + message);
                }
                fa3.u(code, this.a, 1, message);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948217711, "Lcom/baidu/tieba/w14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948217711, "Lcom/baidu/tieba/w14;");
                return;
            }
        }
        i = wj1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w14(wa2 wa2Var, tv1 tv1Var) {
        super(wa2Var, tv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wa2Var, tv1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((wa2) objArr2[0], (tv1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 2;
    }

    @Override // com.baidu.tieba.s14
    public void C(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            super.C(str, i2, str2);
            g44.c(str, i2, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public void T(Request request, String str, String str2, t14 t14Var, y14 y14Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, str, str2, t14Var, y14Var) == null) {
            String httpUrl = request.url().toString();
            pb3 G = zo2.U().G();
            boolean b2 = G.b(str);
            fa3.A(httpUrl, 1);
            t14Var.call(request, Collections.singletonList(y14Var), new b(this, httpUrl, str, str2, G, b2));
        }
    }

    public String U(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String i2 = zo2.U().G().i(str);
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

    public boolean V(InputStream inputStream, File file) {
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
                        qj4.d(fileOutputStream);
                        return true;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                qj4.d(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                qj4.d(fileOutputStream2);
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
        String z = z();
        if (TextUtils.isEmpty(z)) {
            return;
        }
        if (m33.M() == null) {
            C("", -1, "request:swanApp is null");
            return;
        }
        t14 t14Var = (t14) m33.M().i0();
        String B = this.b.B("filePath");
        if (!TextUtils.isEmpty(B)) {
            if (qj4.x(B)) {
                C(z, -1, "downloadFile:filePath is invalid");
                return;
            }
            String[] split = B.split("/");
            if (TextUtils.isEmpty(split[split.length - 1])) {
                C(z, -1, "downloadFile:filePath is invalid");
                return;
            }
        }
        pb3 G = zo2.U().G();
        boolean b2 = G.b(B);
        if (b2 && G.d().a(0L)) {
            C(z, -1, "downloadFile:fail exceed max size in usr");
            return;
        }
        HashMap hashMap = new HashMap();
        Request.Builder builder = new Request.Builder();
        G(builder, this.b.w("header"), hashMap, false);
        builder.url(z).tag(this.c).build();
        String t = qj4.t(z);
        this.h = 0L;
        y14 y14Var = new y14();
        y14Var.c(new a(this, z, t14Var, b2, G));
        T(builder.build(), B, t, t14Var, y14Var);
    }
}
