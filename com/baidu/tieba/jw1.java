package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jw1 extends iw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ jw1 d;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public a(jw1 jw1Var, String str, String str2, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jw1Var, str, str2, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = jw1Var;
            this.a = str;
            this.b = str2;
            this.c = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                jw1 jw1Var = this.d;
                CallbackHandler callbackHandler = this.c;
                String str = this.b;
                jw1Var.r(callbackHandler, str, null, "downloadFile:fail" + exc.getMessage());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                this.d.s(response, this.a, this.b, this.c);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jw1(da3 da3Var) {
        super(da3Var, "/swanAPI/cloudDownloadFile");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {da3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((da3) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.iw1, com.baidu.tieba.db3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, g93 g93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, g93Var)) == null) {
            return super.d(context, unitedSchemeEntity, callbackHandler, g93Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final void r(CallbackHandler callbackHandler, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, callbackHandler, str, str2, str3) == null) {
            if (TextUtils.isEmpty(str2)) {
                k(callbackHandler, str, 1001, "downloadFile:fail");
            } else {
                k(callbackHandler, str, 1001, gw1.k(str3));
            }
        }
    }

    @Override // com.baidu.tieba.iw1
    public void j(Response response, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, callbackHandler, str) == null) {
            if (!response.isSuccessful()) {
                k(callbackHandler, str, 1001, "downloadFile:fail");
                return;
            }
            String header = response.header("Content-Type", "");
            if (header != null && header.contains("application/json")) {
                JSONObject m = gw1.m(response);
                if (m != null && response.isSuccessful()) {
                    String optString = m.optString("errno", String.valueOf(0));
                    String optString2 = m.optString("errmsg");
                    if (gw1.o(optString)) {
                        r(callbackHandler, str, optString, optString2);
                        return;
                    }
                    String optString3 = m.optString("DownloadUrl");
                    if (TextUtils.isEmpty(optString3)) {
                        r(callbackHandler, str, optString, optString2);
                        return;
                    } else {
                        p(optString3, callbackHandler, str);
                        return;
                    }
                }
                k(callbackHandler, str, 1001, "downloadFile:fail");
                return;
            }
            k(callbackHandler, str, 1001, "downloadFile:fail");
        }
    }

    public void p(String str, CallbackHandler callbackHandler, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, callbackHandler, str2) == null) {
            if (g93.M() == null) {
                r(callbackHandler, str2, null, null);
            } else {
                q(str, str2, callbackHandler);
            }
        }
    }

    public final void q(String str, String str2, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, callbackHandler) == null) {
            jg4 jg4Var = new jg4(str, new a(this, str, str2, callbackHandler));
            jg4Var.f = true;
            jg4Var.g = false;
            jg4Var.h = true;
            kg4.g().d(jg4Var);
        }
    }

    public final void s(Response response, String str, String str2, CallbackHandler callbackHandler) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, response, str, str2, callbackHandler) == null) {
            if (!response.isSuccessful()) {
                r(callbackHandler, str2, null, "downloadFile:fail");
                return;
            }
            try {
                str3 = ja3.A(i03.s(response.headers()), kp4.t(str));
            } catch (JSONException e) {
                e.printStackTrace();
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                r(callbackHandler, str2, null, null);
                return;
            }
            String g = tu2.U().G().g(str3);
            if (TextUtils.isEmpty(g)) {
                r(callbackHandler, str2, null, null);
            } else if (t(response, str3)) {
                m(callbackHandler, str2, gw1.n(null, g, "downloadFile:ok"));
            } else {
                r(callbackHandler, str2, null, null);
            }
        }
    }

    public boolean t(Response response, String str) {
        InterceptResult invokeLL;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, response, str)) == null) {
            if (response.body() != null) {
                inputStream = response.body().byteStream();
            } else {
                inputStream = null;
            }
            File file = new File(str);
            if (file.exists()) {
                file.delete();
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    if (iw1.c) {
                        e.printStackTrace();
                    }
                }
            }
            return np4.a(inputStream, file);
        }
        return invokeLL.booleanValue;
    }
}
