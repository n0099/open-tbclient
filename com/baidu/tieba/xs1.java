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
/* loaded from: classes6.dex */
public class xs1 extends ws1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.is1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "ImageApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ f43 d;
        public final /* synthetic */ xs1 e;

        public a(xs1 xs1Var, File file, int i, String str, f43 f43Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xs1Var, file, Integer.valueOf(i), str, f43Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = xs1Var;
            this.a = file;
            this.b = i;
            this.c = str;
            this.d = f43Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                File k = dh3.k(this.a.getName());
                if (!dh3.b(this.a, k, this.b)) {
                    f12.c("ImageApi", "compress image failed");
                    this.e.d(this.c, new fw1(1001, "compress image failed"));
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempFilePath", nb3.J(k.getAbsolutePath(), this.d.b));
                } catch (JSONException e) {
                    f12.c("ImageApi", e.toString());
                }
                this.e.d(this.c, new fw1(0, jSONObject));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xs1(@NonNull gs1 gs1Var) {
        super(gs1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gs1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((gs1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public fw1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#compressImage", false);
            Pair<fw1, JSONObject> s = s(str);
            fw1 fw1Var = (fw1) s.first;
            if (!fw1Var.isSuccess()) {
                return fw1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                f12.c("ImageApi", "cb is empty");
                return new fw1(202, "cb is empty");
            }
            return y(optString, jSONObject.optString("src"), jSONObject.optInt("quality", 80));
        }
        return (fw1) invokeL.objValue;
    }

    public final fw1 y(String str, String str2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i)) == null) {
            f43 b0 = f43.b0();
            if (b0 == null) {
                return new fw1(1001, "swan app is null");
            }
            if (i >= 0 && i <= 100) {
                i2 = i;
            } else {
                i2 = 80;
            }
            if (TextUtils.isEmpty(str2)) {
                f12.c("ImageApi", "src is null");
                return new fw1(202, "src is null");
            }
            PathType s = nb3.s(str2);
            String str3 = null;
            if (s == PathType.BD_FILE) {
                str3 = nb3.M(str2, b0.b);
            } else if (s == PathType.RELATIVE) {
                str3 = nb3.L(str2, b0, b0.k0());
            }
            if (TextUtils.isEmpty(str3)) {
                f12.c("ImageApi", "file path error");
                return new fw1(2001, "file path error");
            }
            File file = new File(str3);
            if (!file.exists()) {
                f12.c("ImageApi", "file does not exist");
                return new fw1(2001, "file does not exist");
            }
            zg3.k(new a(this, file, i2, str, b0), "compressImage");
            return fw1.f();
        }
        return (fw1) invokeLLI.objValue;
    }
}
