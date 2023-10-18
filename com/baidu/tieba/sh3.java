package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tieba.rh3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class sh3 extends tt1 implements rh3.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public String f;
    public String g;

    @Override // com.baidu.tieba.tt1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "PrivateFile" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tt1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "UploadBosApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jv2 a;
        public final /* synthetic */ sh3 b;

        public a(sh3 sh3Var, jv2 jv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sh3Var, jv2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sh3Var;
            this.a = jv2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!wo2.h().a(this.b.f, this.a)) {
                    sh3 sh3Var = this.b;
                    sh3Var.d(sh3Var.g, new qx1(2003, "upload fail"));
                    return;
                }
                this.b.B(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948151371, "Lcom/baidu/tieba/sh3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948151371, "Lcom/baidu/tieba/sh3;");
                return;
            }
        }
        h = am1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sh3(@NonNull rt1 rt1Var) {
        super(rt1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rt1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((rt1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void B(jv2 jv2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jv2Var) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("bosUrl", jv2Var.e);
                d(this.g, new qx1(0, jSONObject));
            } catch (JSONException e) {
                if (h) {
                    e.printStackTrace();
                }
                d(this.g, new qx1(2003, "upload fail"));
            }
        }
    }

    public final boolean C(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file)) == null) {
            if (file.length() > 52428800) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public qx1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#uploadBosFile", false);
            if (h) {
                Log.d("UploadBosApi", "#uploadBosFile params=" + str);
            }
            Pair<qx1, JSONObject> t = t(str);
            qx1 qx1Var = (qx1) t.first;
            if (!qx1Var.isSuccess()) {
                return qx1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            String optString = jSONObject.optString("cb");
            this.g = optString;
            if (TextUtils.isEmpty(optString)) {
                return new qx1(202);
            }
            String optString2 = jSONObject.optString("filePath");
            if (TextUtils.isEmpty(optString2)) {
                return new qx1(202);
            }
            cr2 V = cr2.V();
            String i = V.I().i(optString2);
            this.f = i;
            if (TextUtils.isEmpty(i)) {
                return new qx1(2001, "file not found");
            }
            File file = new File(this.f);
            if (file.exists() && file.isFile()) {
                if (C(file)) {
                    return new qx1(2002, "file over size");
                }
                if (!o53.K().q().N().e(V.getActivity())) {
                    return new qx1(10004, "user not logged in");
                }
                wo2.h().b(V.getActivity(), this.f, this);
                return qx1.f();
            }
            return new qx1(2001, "file not found");
        }
        return (qx1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.rh3.a
    public void c(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, jSONObject, str) == null) {
            if (jSONObject == null) {
                d(this.g, new qx1(2003, "upload fail"));
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                d(this.g, new qx1(2003, "upload fail"));
                return;
            }
            String optString = jSONObject.optString("errno");
            if (!TextUtils.isEmpty(optString) && TextUtils.equals(optString, "0")) {
                jv2 a2 = jv2.a(optJSONObject, str);
                if (TextUtils.isEmpty(a2.e)) {
                    d(this.g, new qx1(2003, "upload fail"));
                    return;
                } else {
                    ExecutorUtilsExt.postOnElastic(new a(this, a2), "doBosUpload", 2);
                    return;
                }
            }
            d(this.g, new qx1(2003, "upload fail"));
        }
    }
}
