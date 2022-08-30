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
/* loaded from: classes5.dex */
public class sp1 extends rp1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ a13 d;
        public final /* synthetic */ sp1 e;

        public a(sp1 sp1Var, File file, int i, String str, a13 a13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sp1Var, file, Integer.valueOf(i), str, a13Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = sp1Var;
            this.a = file;
            this.b = i;
            this.c = str;
            this.d = a13Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                File k = yd3.k(this.a.getName());
                if (!yd3.b(this.a, k, this.b)) {
                    ay1.c("ImageApi", "compress image failed");
                    this.e.d(this.c, new at1(1001, "compress image failed"));
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempFilePath", i83.J(k.getAbsolutePath(), this.d.b));
                } catch (JSONException e) {
                    ay1.c("ImageApi", e.toString());
                }
                this.e.d(this.c, new at1(0, jSONObject));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sp1(@NonNull bp1 bp1Var) {
        super(bp1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bp1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((bp1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.dp1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "ImageApi" : (String) invokeV.objValue;
    }

    public at1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#compressImage", false);
            Pair<at1, JSONObject> s = s(str);
            at1 at1Var = (at1) s.first;
            if (at1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    ay1.c("ImageApi", "cb is empty");
                    return new at1(202, "cb is empty");
                }
                return y(optString, jSONObject.optString("src"), jSONObject.optInt("quality", 80));
            }
            return at1Var;
        }
        return (at1) invokeL.objValue;
    }

    public final at1 y(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i)) == null) {
            a13 b0 = a13.b0();
            if (b0 == null) {
                return new at1(1001, "swan app is null");
            }
            int i2 = (i < 0 || i > 100) ? 80 : i;
            if (TextUtils.isEmpty(str2)) {
                ay1.c("ImageApi", "src is null");
                return new at1(202, "src is null");
            }
            PathType s = i83.s(str2);
            String str3 = null;
            if (s == PathType.BD_FILE) {
                str3 = i83.M(str2, b0.b);
            } else if (s == PathType.RELATIVE) {
                str3 = i83.L(str2, b0, b0.k0());
            }
            if (TextUtils.isEmpty(str3)) {
                ay1.c("ImageApi", "file path error");
                return new at1(2001, "file path error");
            }
            File file = new File(str3);
            if (!file.exists()) {
                ay1.c("ImageApi", "file does not exist");
                return new at1(2001, "file does not exist");
            }
            ud3.k(new a(this, file, i2, str, b0), "compressImage");
            return at1.f();
        }
        return (at1) invokeLLI.objValue;
    }
}
