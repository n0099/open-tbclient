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
/* loaded from: classes7.dex */
public class r02 extends q02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.c02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "ImageApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ zb3 d;
        public final /* synthetic */ r02 e;

        public a(r02 r02Var, File file, int i, String str, zb3 zb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r02Var, file, Integer.valueOf(i), str, zb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = r02Var;
            this.a = file;
            this.b = i;
            this.c = str;
            this.d = zb3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                File k = xo3.k(this.a.getName());
                if (!xo3.b(this.a, k, this.b)) {
                    z82.c("ImageApi", "compress image failed");
                    this.e.d(this.c, new z32(1001, "compress image failed"));
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempFilePath", hj3.J(k.getAbsolutePath(), this.d.b));
                } catch (JSONException e) {
                    z82.c("ImageApi", e.toString());
                }
                this.e.d(this.c, new z32(0, jSONObject));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r02(@NonNull a02 a02Var) {
        super(a02Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a02Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a02) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public z32 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#compressImage", false);
            Pair<z32, JSONObject> s = s(str);
            z32 z32Var = (z32) s.first;
            if (!z32Var.isSuccess()) {
                return z32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                z82.c("ImageApi", "cb is empty");
                return new z32(202, "cb is empty");
            }
            return y(optString, jSONObject.optString("src"), jSONObject.optInt("quality", 80));
        }
        return (z32) invokeL.objValue;
    }

    public final z32 y(String str, String str2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i)) == null) {
            zb3 b0 = zb3.b0();
            if (b0 == null) {
                return new z32(1001, "swan app is null");
            }
            if (i >= 0 && i <= 100) {
                i2 = i;
            } else {
                i2 = 80;
            }
            if (TextUtils.isEmpty(str2)) {
                z82.c("ImageApi", "src is null");
                return new z32(202, "src is null");
            }
            PathType s = hj3.s(str2);
            String str3 = null;
            if (s == PathType.BD_FILE) {
                str3 = hj3.M(str2, b0.b);
            } else if (s == PathType.RELATIVE) {
                str3 = hj3.L(str2, b0, b0.k0());
            }
            if (TextUtils.isEmpty(str3)) {
                z82.c("ImageApi", "file path error");
                return new z32(2001, "file path error");
            }
            File file = new File(str3);
            if (!file.exists()) {
                z82.c("ImageApi", "file does not exist");
                return new z32(2001, "file does not exist");
            }
            to3.k(new a(this, file, i2, str, b0), "compressImage");
            return z32.f();
        }
        return (z32) invokeLLI.objValue;
    }
}
