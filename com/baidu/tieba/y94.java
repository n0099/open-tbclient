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
/* loaded from: classes8.dex */
public class y94 extends j94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long h;

    /* loaded from: classes8.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ k94 b;
        public final /* synthetic */ y94 c;

        public a(y94 y94Var, String str, k94 k94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y94Var, str, k94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = y94Var;
            this.a = str;
            this.b = k94Var;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.b.cancelTag(this.c.c);
                this.c.V(this.a, 0, iOException.getMessage());
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
                        jSEvent.data = new w94(this.c.H(response.headers()));
                        this.c.dispatchEvent(jSEvent);
                    } catch (JSONException e) {
                        try {
                            if (j94.e) {
                                e.printStackTrace();
                            }
                        } catch (JSONException e2) {
                            e = e2;
                            if (j94.e) {
                                Log.d("UploadFileTask", Log.getStackTraceString(e));
                            }
                            this.c.B(this.a, -1, e.getMessage());
                        }
                    }
                    x94 x94Var = new x94();
                    x94Var.statusCode = response.code();
                    x94Var.header = this.c.H(response.headers());
                    x94Var.data = this.c.W(response.body());
                    if (j94.e) {
                        Log.d("UploadFileTask", "onResponse = " + x94Var.data);
                    }
                    this.c.C(x94Var);
                } catch (IOException e3) {
                    e = e3;
                    if (j94.e) {
                    }
                    this.c.B(this.a, -1, e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements x23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ String b;
        public final /* synthetic */ y94 c;

        public b(y94 y94Var, long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y94Var, Long.valueOf(j), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = y94Var;
            this.a = j;
            this.b = str;
        }

        @Override // com.baidu.tieba.x23
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeJ(1048576, this, j) != null) {
                return;
            }
            this.c.U(this.a, j, this.b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y94(ni2 ni2Var, k32 k32Var) {
        super(ni2Var, k32Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ni2Var, k32Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ni2) objArr2[0], (k32) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = 0L;
        this.a = 3;
    }

    public final Object W(ResponseBody responseBody) throws IOException {
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

    public static void X(MultipartBody.Builder builder, k32 k32Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65547, null, builder, k32Var) == null) && builder != null && k32Var != null && k32Var.k() >= 1) {
            for (String str : k32Var.j()) {
                if (!TextUtils.isEmpty(str)) {
                    String H = k32Var.H(str);
                    if (!TextUtils.isEmpty(H)) {
                        builder.addFormDataPart(str, H);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.j94
    public void B(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i, str2) == null) {
            super.B(str, i, str2);
            xb4.k(str, i, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public final Request S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String y = y();
            if (!TextUtils.isEmpty(y)) {
                String B = this.b.B("filePath");
                if (TextUtils.isEmpty(B)) {
                    B(y, -1, "uploadFile:filePath is empty or invalid");
                    return null;
                } else if (hr4.x(B)) {
                    B(y, -1, "uploadFile:filePath is empty or invalid");
                    return null;
                } else if (this.b.b("header") && this.b.getType("header") != 9) {
                    B(y, -1, "uploadFile:header is invalid");
                    return null;
                } else {
                    File T2 = T(y, B);
                    if (T2 != null) {
                        k32 w = this.b.w("formData");
                        Request.Builder builder = new Request.Builder();
                        h23 h23Var = new h23(T2, IMAudioTransRequest.CONTENT_TYPE, new b(this, T2.length(), y));
                        MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                        X(type, w);
                        type.addFormDataPart(this.b.B("name"), T2.getName(), h23Var);
                        MultipartBody build = type.build();
                        F(builder, this.b.w("header"), new HashMap(), false);
                        return builder.url(y).tag(this.c).post(build).build();
                    }
                }
            }
            return null;
        }
        return (Request) invokeV.objValue;
    }

    public final File T(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            String a2 = qw2.T().G().a(str2);
            if (!TextUtils.isEmpty(a2) && !TextUtils.equals(str2, a2)) {
                File file = new File(a2);
                if (file.exists() && file.isFile()) {
                    if (file.length() > 26214400) {
                        B(str, -1, "request:file size > 25 MB");
                        return null;
                    } else if (TextUtils.isEmpty(this.b.B("name"))) {
                        B(str, -1, "uploadFile:name is invalid");
                        return null;
                    } else if (this.b.b("formData") && this.b.getType("formData") != 9) {
                        B(str, -1, "uploadFile:formData is invalid");
                        return null;
                    } else {
                        return file;
                    }
                }
                B(str, -1, "request:file not exists or not file");
                return null;
            }
            B(str, -1, "uploadFile:filePath is empty or invalid");
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public final void U(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) && j > 0 && j2 <= j && j2 != 0) {
            int floor = (int) Math.floor((100 * j2) / j);
            if (System.currentTimeMillis() - this.h > 500 || floor == 100) {
                if (floor <= 100) {
                    dispatchEvent(new JSEvent("progressUpdate", new z94(floor, j, j2)));
                }
                this.h = System.currentTimeMillis();
            }
        }
    }

    public final void V(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, str, i, str2) == null) {
            if (j94.e) {
                Log.d("UploadFileTask", "onFailure: " + str2);
            }
            B(str, i, ("Socket is closed".equalsIgnoreCase(str2) || "Canceled".equalsIgnoreCase(str2)) ? "uploadFile:fail abort" : "uploadFile:fail abort");
        }
    }

    public void start() {
        Request S;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || this.b == null || (S = S()) == null) {
            return;
        }
        if (db3.M() == null) {
            B("", -1, "request:swanApp is null");
            return;
        }
        String httpUrl = S.url().toString();
        k94 k94Var = (k94) db3.M().i0();
        k94Var.call(S, new a(this, httpUrl, k94Var));
    }
}
