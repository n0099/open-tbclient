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
public class mw1 extends lw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.xv1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "ImageApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ u73 d;
        public final /* synthetic */ mw1 e;

        public a(mw1 mw1Var, File file, int i, String str, u73 u73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mw1Var, file, Integer.valueOf(i), str, u73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = mw1Var;
            this.a = file;
            this.b = i;
            this.c = str;
            this.d = u73Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                File k = sk3.k(this.a.getName());
                if (!sk3.b(this.a, k, this.b)) {
                    u42.c("ImageApi", "compress image failed");
                    this.e.d(this.c, new uz1(1001, "compress image failed"));
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempFilePath", cf3.J(k.getAbsolutePath(), this.d.b));
                } catch (JSONException e) {
                    u42.c("ImageApi", e.toString());
                }
                this.e.d(this.c, new uz1(0, jSONObject));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mw1(@NonNull vv1 vv1Var) {
        super(vv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vv1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public uz1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#compressImage", false);
            Pair<uz1, JSONObject> s = s(str);
            uz1 uz1Var = (uz1) s.first;
            if (!uz1Var.isSuccess()) {
                return uz1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                u42.c("ImageApi", "cb is empty");
                return new uz1(202, "cb is empty");
            }
            return y(optString, jSONObject.optString("src"), jSONObject.optInt("quality", 80));
        }
        return (uz1) invokeL.objValue;
    }

    public final uz1 y(String str, String str2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i)) == null) {
            u73 b0 = u73.b0();
            if (b0 == null) {
                return new uz1(1001, "swan app is null");
            }
            if (i >= 0 && i <= 100) {
                i2 = i;
            } else {
                i2 = 80;
            }
            if (TextUtils.isEmpty(str2)) {
                u42.c("ImageApi", "src is null");
                return new uz1(202, "src is null");
            }
            PathType s = cf3.s(str2);
            String str3 = null;
            if (s == PathType.BD_FILE) {
                str3 = cf3.M(str2, b0.b);
            } else if (s == PathType.RELATIVE) {
                str3 = cf3.L(str2, b0, b0.k0());
            }
            if (TextUtils.isEmpty(str3)) {
                u42.c("ImageApi", "file path error");
                return new uz1(2001, "file path error");
            }
            File file = new File(str3);
            if (!file.exists()) {
                u42.c("ImageApi", "file does not exist");
                return new uz1(2001, "file does not exist");
            }
            ok3.k(new a(this, file, i2, str, b0), "compressImage");
            return uz1.f();
        }
        return (uz1) invokeLLI.objValue;
    }
}
