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
/* loaded from: classes9.dex */
public class zz1 extends yz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.kz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "ImageApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ hb3 d;
        public final /* synthetic */ zz1 e;

        public a(zz1 zz1Var, File file, int i, String str, hb3 hb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz1Var, file, Integer.valueOf(i), str, hb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zz1Var;
            this.a = file;
            this.b = i;
            this.c = str;
            this.d = hb3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                File k = fo3.k(this.a.getName());
                if (!fo3.b(this.a, k, this.b)) {
                    h82.c("ImageApi", "compress image failed");
                    this.e.d(this.c, new h32(1001, "compress image failed"));
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempFilePath", pi3.J(k.getAbsolutePath(), this.d.b));
                } catch (JSONException e) {
                    h82.c("ImageApi", e.toString());
                }
                this.e.d(this.c, new h32(0, jSONObject));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zz1(@NonNull iz1 iz1Var) {
        super(iz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public h32 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#compressImage", false);
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            if (!h32Var.isSuccess()) {
                return h32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                h82.c("ImageApi", "cb is empty");
                return new h32(202, "cb is empty");
            }
            return y(optString, jSONObject.optString("src"), jSONObject.optInt("quality", 80));
        }
        return (h32) invokeL.objValue;
    }

    public final h32 y(String str, String str2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i)) == null) {
            hb3 b0 = hb3.b0();
            if (b0 == null) {
                return new h32(1001, "swan app is null");
            }
            if (i >= 0 && i <= 100) {
                i2 = i;
            } else {
                i2 = 80;
            }
            if (TextUtils.isEmpty(str2)) {
                h82.c("ImageApi", "src is null");
                return new h32(202, "src is null");
            }
            PathType s = pi3.s(str2);
            String str3 = null;
            if (s == PathType.BD_FILE) {
                str3 = pi3.M(str2, b0.b);
            } else if (s == PathType.RELATIVE) {
                str3 = pi3.L(str2, b0, b0.k0());
            }
            if (TextUtils.isEmpty(str3)) {
                h82.c("ImageApi", "file path error");
                return new h32(2001, "file path error");
            }
            File file = new File(str3);
            if (!file.exists()) {
                h82.c("ImageApi", "file does not exist");
                return new h32(2001, "file does not exist");
            }
            bo3.k(new a(this, file, i2, str, b0), "compressImage");
            return h32.f();
        }
        return (h32) invokeLLI.objValue;
    }
}
