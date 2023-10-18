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
public class iu1 extends hu1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.tt1
    public String k() {
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
        public final /* synthetic */ p53 d;
        public final /* synthetic */ iu1 e;

        public a(iu1 iu1Var, File file, int i, String str, p53 p53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iu1Var, file, Integer.valueOf(i), str, p53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = iu1Var;
            this.a = file;
            this.b = i;
            this.c = str;
            this.d = p53Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                File k = ni3.k(this.a.getName());
                if (!ni3.b(this.a, k, this.b)) {
                    p22.c("ImageApi", "compress image failed");
                    this.e.d(this.c, new qx1(1001, "compress image failed"));
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempFilePath", xc3.J(k.getAbsolutePath(), this.d.b));
                } catch (JSONException e) {
                    p22.c("ImageApi", e.toString());
                }
                this.e.d(this.c, new qx1(0, jSONObject));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iu1(@NonNull rt1 rt1Var) {
        super(rt1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rt1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((rt1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public qx1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            r("#compressImage", false);
            Pair<qx1, JSONObject> t = t(str);
            qx1 qx1Var = (qx1) t.first;
            if (!qx1Var.isSuccess()) {
                return qx1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                p22.c("ImageApi", "cb is empty");
                return new qx1(202, "cb is empty");
            }
            return z(optString, jSONObject.optString("src"), jSONObject.optInt("quality", 80));
        }
        return (qx1) invokeL.objValue;
    }

    public final qx1 z(String str, String str2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i)) == null) {
            p53 c0 = p53.c0();
            if (c0 == null) {
                return new qx1(1001, "swan app is null");
            }
            if (i >= 0 && i <= 100) {
                i2 = i;
            } else {
                i2 = 80;
            }
            if (TextUtils.isEmpty(str2)) {
                p22.c("ImageApi", "src is null");
                return new qx1(202, "src is null");
            }
            PathType s = xc3.s(str2);
            String str3 = null;
            if (s == PathType.BD_FILE) {
                str3 = xc3.M(str2, c0.b);
            } else if (s == PathType.RELATIVE) {
                str3 = xc3.L(str2, c0, c0.l0());
            }
            if (TextUtils.isEmpty(str3)) {
                p22.c("ImageApi", "file path error");
                return new qx1(2001, "file path error");
            }
            File file = new File(str3);
            if (!file.exists()) {
                p22.c("ImageApi", "file does not exist");
                return new qx1(2001, "file does not exist");
            }
            ji3.k(new a(this, file, i2, str, c0), "compressImage");
            return qx1.f();
        }
        return (qx1) invokeLLI.objValue;
    }
}
