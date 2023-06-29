package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class u02 extends t02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.f02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "ImageApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ cc3 d;
        public final /* synthetic */ u02 e;

        public a(u02 u02Var, File file, int i, String str, cc3 cc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u02Var, file, Integer.valueOf(i), str, cc3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = u02Var;
            this.a = file;
            this.b = i;
            this.c = str;
            this.d = cc3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                File k = ap3.k(this.a.getName());
                if (!ap3.b(this.a, k, this.b)) {
                    c92.c("ImageApi", "compress image failed");
                    this.e.d(this.c, new c42(1001, "compress image failed"));
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempFilePath", kj3.J(k.getAbsolutePath(), this.d.b));
                } catch (JSONException e) {
                    c92.c("ImageApi", e.toString());
                }
                this.e.d(this.c, new c42(0, jSONObject));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u02(@NonNull d02 d02Var) {
        super(d02Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d02Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d02) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c42 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#compressImage", false);
            Pair<c42, JSONObject> s = s(str);
            c42 c42Var = (c42) s.first;
            if (!c42Var.isSuccess()) {
                return c42Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c92.c("ImageApi", "cb is empty");
                return new c42(202, "cb is empty");
            }
            return y(optString, jSONObject.optString("src"), jSONObject.optInt("quality", 80));
        }
        return (c42) invokeL.objValue;
    }

    public final c42 y(String str, String str2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i)) == null) {
            cc3 b0 = cc3.b0();
            if (b0 == null) {
                return new c42(1001, "swan app is null");
            }
            if (i >= 0 && i <= 100) {
                i2 = i;
            } else {
                i2 = 80;
            }
            if (TextUtils.isEmpty(str2)) {
                c92.c("ImageApi", "src is null");
                return new c42(202, "src is null");
            }
            PathType s = kj3.s(str2);
            String str3 = null;
            if (s == PathType.BD_FILE) {
                str3 = kj3.M(str2, b0.b);
            } else if (s == PathType.RELATIVE) {
                str3 = kj3.L(str2, b0, b0.k0());
            }
            if (TextUtils.isEmpty(str3)) {
                c92.c("ImageApi", "file path error");
                return new c42(2001, "file path error");
            }
            File file = new File(str3);
            if (!file.exists()) {
                c92.c("ImageApi", "file does not exist");
                return new c42(2001, "file does not exist");
            }
            wo3.k(new a(this, file, i2, str, b0), "compressImage");
            return c42.f();
        }
        return (c42) invokeLLI.objValue;
    }
}
