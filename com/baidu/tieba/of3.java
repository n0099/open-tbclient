package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tieba.nf3;
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
/* loaded from: classes5.dex */
public class of3 extends or1 implements nf3.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public String f;
    public String g;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ft2 a;
        public final /* synthetic */ of3 b;

        public a(of3 of3Var, ft2 ft2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {of3Var, ft2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = of3Var;
            this.a = ft2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (sm2.h().a(this.b.f, this.a)) {
                    this.b.A(this.a);
                    return;
                }
                of3 of3Var = this.b;
                of3Var.d(of3Var.g, new lv1(2003, "upload fail"));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948030285, "Lcom/baidu/tieba/of3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948030285, "Lcom/baidu/tieba/of3;");
                return;
            }
        }
        h = vj1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public of3(@NonNull mr1 mr1Var) {
        super(mr1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mr1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mr1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void A(ft2 ft2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ft2Var) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("bosUrl", ft2Var.e);
                d(this.g, new lv1(0, jSONObject));
            } catch (JSONException e) {
                if (h) {
                    e.printStackTrace();
                }
                d(this.g, new lv1(2003, "upload fail"));
            }
        }
    }

    public final boolean B(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file)) == null) ? file.length() > 52428800 : invokeL.booleanValue;
    }

    public lv1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#uploadBosFile", false);
            if (h) {
                Log.d("UploadBosApi", "#uploadBosFile params=" + str);
            }
            Pair<lv1, JSONObject> s = s(str);
            lv1 lv1Var = (lv1) s.first;
            if (lv1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                this.g = optString;
                if (TextUtils.isEmpty(optString)) {
                    return new lv1(202);
                }
                String optString2 = jSONObject.optString("filePath");
                if (TextUtils.isEmpty(optString2)) {
                    return new lv1(202);
                }
                yo2 U = yo2.U();
                String i = U.G().i(optString2);
                this.f = i;
                if (TextUtils.isEmpty(i)) {
                    return new lv1(2001, "file not found");
                }
                File file = new File(this.f);
                if (file.exists() && file.isFile()) {
                    if (B(file)) {
                        return new lv1(2002, "file over size");
                    }
                    if (!k33.K().q().N().e(U.getActivity())) {
                        return new lv1(10004, "user not logged in");
                    }
                    sm2.h().b(U.getActivity(), this.f, this);
                    return lv1.f();
                }
                return new lv1(2001, "file not found");
            }
            return lv1Var;
        }
        return (lv1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.nf3.a
    public void c(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, jSONObject, str) == null) {
            if (jSONObject == null) {
                d(this.g, new lv1(2003, "upload fail"));
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                d(this.g, new lv1(2003, "upload fail"));
                return;
            }
            String optString = jSONObject.optString("errno");
            if (!TextUtils.isEmpty(optString) && TextUtils.equals(optString, "0")) {
                ft2 a2 = ft2.a(optJSONObject, str);
                if (TextUtils.isEmpty(a2.e)) {
                    d(this.g, new lv1(2003, "upload fail"));
                    return;
                } else {
                    ExecutorUtilsExt.postOnElastic(new a(this, a2), "doBosUpload", 2);
                    return;
                }
            }
            d(this.g, new lv1(2003, "upload fail"));
        }
    }

    @Override // com.baidu.tieba.or1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "PrivateFile" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.or1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "UploadBosApi" : (String) invokeV.objValue;
    }
}
