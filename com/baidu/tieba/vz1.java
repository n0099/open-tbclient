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
public class vz1 extends uz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.gz1
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
        public final /* synthetic */ db3 d;
        public final /* synthetic */ vz1 e;

        public a(vz1 vz1Var, File file, int i, String str, db3 db3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz1Var, file, Integer.valueOf(i), str, db3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = vz1Var;
            this.a = file;
            this.b = i;
            this.c = str;
            this.d = db3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                File k = bo3.k(this.a.getName());
                if (!bo3.b(this.a, k, this.b)) {
                    d82.c("ImageApi", "compress image failed");
                    this.e.d(this.c, new d32(1001, "compress image failed"));
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempFilePath", li3.J(k.getAbsolutePath(), this.d.b));
                } catch (JSONException e) {
                    d82.c("ImageApi", e.toString());
                }
                this.e.d(this.c, new d32(0, jSONObject));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vz1(@NonNull ez1 ez1Var) {
        super(ez1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ez1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ez1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public d32 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#compressImage", false);
            Pair<d32, JSONObject> s = s(str);
            d32 d32Var = (d32) s.first;
            if (!d32Var.isSuccess()) {
                return d32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d82.c("ImageApi", "cb is empty");
                return new d32(202, "cb is empty");
            }
            return y(optString, jSONObject.optString("src"), jSONObject.optInt("quality", 80));
        }
        return (d32) invokeL.objValue;
    }

    public final d32 y(String str, String str2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i)) == null) {
            db3 b0 = db3.b0();
            if (b0 == null) {
                return new d32(1001, "swan app is null");
            }
            if (i >= 0 && i <= 100) {
                i2 = i;
            } else {
                i2 = 80;
            }
            if (TextUtils.isEmpty(str2)) {
                d82.c("ImageApi", "src is null");
                return new d32(202, "src is null");
            }
            PathType s = li3.s(str2);
            String str3 = null;
            if (s == PathType.BD_FILE) {
                str3 = li3.M(str2, b0.b);
            } else if (s == PathType.RELATIVE) {
                str3 = li3.L(str2, b0, b0.k0());
            }
            if (TextUtils.isEmpty(str3)) {
                d82.c("ImageApi", "file path error");
                return new d32(2001, "file path error");
            }
            File file = new File(str3);
            if (!file.exists()) {
                d82.c("ImageApi", "file does not exist");
                return new d32(2001, "file does not exist");
            }
            xn3.k(new a(this, file, i2, str, b0), "compressImage");
            return d32.f();
        }
        return (d32) invokeLLI.objValue;
    }
}
