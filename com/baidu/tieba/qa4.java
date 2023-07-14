package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qa4 extends ba4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long h;

    /* loaded from: classes7.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ca4 b;
        public final /* synthetic */ qa4 c;

        public a(qa4 qa4Var, String str, ca4 ca4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qa4Var, str, ca4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qa4Var;
            this.a = str;
            this.b = ca4Var;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.b.cancelTag(this.c.c);
                this.c.W(this.a, 0, iOException.getMessage());
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x007c  */
        @Override // okhttp3.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResponse(Call call, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                try {
                    try {
                        JSEvent jSEvent = new JSEvent("headersReceived");
                        jSEvent.data = new oa4(this.c.I(response.headers()));
                        this.c.dispatchEvent(jSEvent);
                    } catch (JSONException e) {
                        try {
                            if (ba4.e) {
                                e.printStackTrace();
                            }
                        } catch (JSONException e2) {
                            e = e2;
                            if (ba4.e) {
                                Log.d("UploadFileTask", Log.getStackTraceString(e));
                            }
                            this.c.C(this.a, -1, e.getMessage());
                        }
                    }
                    pa4 pa4Var = new pa4();
                    pa4Var.statusCode = response.code();
                    pa4Var.header = this.c.I(response.headers());
                    pa4Var.data = this.c.X(response.body());
                    if (ba4.e) {
                        Log.d("UploadFileTask", "onResponse = " + pa4Var.data);
                    }
                    this.c.D(pa4Var);
                } catch (IOException e3) {
                    e = e3;
                    if (ba4.e) {
                    }
                    this.c.C(this.a, -1, e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements p33 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ String b;
        public final /* synthetic */ qa4 c;

        public b(qa4 qa4Var, long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qa4Var, Long.valueOf(j), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qa4Var;
            this.a = j;
            this.b = str;
        }

        @Override // com.baidu.tieba.p33
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeJ(1048576, this, j) != null) {
                return;
            }
            this.c.V(this.a, j, this.b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qa4(fj2 fj2Var, c42 c42Var) {
        super(fj2Var, c42Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fj2Var, c42Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((fj2) objArr2[0], (c42) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = 0L;
        this.a = 3;
    }

    public final Object X(ResponseBody responseBody) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, responseBody)) == null) {
            if (responseBody == null) {
                return null;
            }
            String string = responseBody.string();
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            try {
                return new JSONObject(string);
            } catch (JSONException unused) {
                return string;
            }
        }
        return invokeL.objValue;
    }

    public static void Y(MultipartBody.Builder builder, c42 c42Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65547, null, builder, c42Var) == null) && builder != null && c42Var != null && c42Var.k() >= 1) {
            for (String str : c42Var.j()) {
                if (!TextUtils.isEmpty(str)) {
                    String H = c42Var.H(str);
                    if (!TextUtils.isEmpty(H)) {
                        builder.addFormDataPart(str, H);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ba4
    public void C(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i, str2) == null) {
            super.C(str, i, str2);
            pc4.k(str, i, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public final Request T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String z = z();
            if (!TextUtils.isEmpty(z)) {
                String B = this.b.B("filePath");
                if (TextUtils.isEmpty(B)) {
                    C(z, -1, "uploadFile:filePath is empty or invalid");
                    return null;
                } else if (zr4.x(B)) {
                    C(z, -1, "uploadFile:filePath is empty or invalid");
                    return null;
                } else if (this.b.b("header") && this.b.getType("header") != 9) {
                    C(z, -1, "uploadFile:header is invalid");
                    return null;
                } else {
                    File U = U(z, B);
                    if (U != null) {
                        c42 w = this.b.w("formData");
                        Request.Builder builder = new Request.Builder();
                        z23 z23Var = new z23(U, IMAudioTransRequest.CONTENT_TYPE, new b(this, U.length(), z));
                        MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                        Y(type, w);
                        type.addFormDataPart(this.b.B("name"), U.getName(), z23Var);
                        MultipartBody build = type.build();
                        G(builder, this.b.w("header"), new HashMap(), false);
                        return builder.url(z).tag(this.c).post(build).build();
                    }
                }
            }
            return null;
        }
        return (Request) invokeV.objValue;
    }

    public final File U(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            String a2 = ix2.T().G().a(str2);
            if (!TextUtils.isEmpty(a2) && !TextUtils.equals(str2, a2)) {
                File file = new File(a2);
                if (file.exists() && file.isFile()) {
                    if (file.length() > 26214400) {
                        C(str, -1, "request:file size > 25 MB");
                        return null;
                    } else if (TextUtils.isEmpty(this.b.B("name"))) {
                        C(str, -1, "uploadFile:name is invalid");
                        return null;
                    } else if (this.b.b("formData") && this.b.getType("formData") != 9) {
                        C(str, -1, "uploadFile:formData is invalid");
                        return null;
                    } else {
                        return file;
                    }
                }
                C(str, -1, "request:file not exists or not file");
                return null;
            }
            C(str, -1, "uploadFile:filePath is empty or invalid");
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public final void V(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) && j > 0 && j2 <= j && j2 != 0) {
            int floor = (int) Math.floor((100 * j2) / j);
            if (System.currentTimeMillis() - this.h > 500 || floor == 100) {
                if (floor <= 100) {
                    dispatchEvent(new JSEvent("progressUpdate", new ra4(floor, j, j2)));
                }
                this.h = System.currentTimeMillis();
            }
        }
    }

    public final void W(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, str, i, str2) == null) {
            if (ba4.e) {
                Log.d("UploadFileTask", "onFailure: " + str2);
            }
            C(str, i, ("Socket is closed".equalsIgnoreCase(str2) || "Canceled".equalsIgnoreCase(str2)) ? "uploadFile:fail abort" : "uploadFile:fail abort");
        }
    }

    public void start() {
        Request T2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || this.b == null || (T2 = T()) == null) {
            return;
        }
        if (vb3.M() == null) {
            C("", -1, "request:swanApp is null");
            return;
        }
        String httpUrl = T2.url().toString();
        ca4 ca4Var = (ca4) vb3.M().i0();
        ca4Var.call(T2, new a(this, httpUrl, ca4Var));
    }
}
