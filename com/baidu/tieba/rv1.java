package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.tt1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class rv1 extends qv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tt1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? "StorageApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements tt1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rv1 a;

        public a(rv1 rv1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rv1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rv1Var;
        }

        @Override // com.baidu.tieba.tt1.a
        public qx1 a(p53 p53Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, p53Var, jSONObject, str)) == null) {
                String R = rv1.R(jSONObject);
                if (R == null) {
                    return new qx1(202);
                }
                if (yc3.b(R)) {
                    return new qx1(1001, "exceed storage key max length");
                }
                String Q = rv1.Q(jSONObject);
                if (Q == null) {
                    return new qx1(202);
                }
                if (yc3.c(Q)) {
                    return new qx1(1001, "exceed storage item max length");
                }
                if (this.a.O(p53Var, R, Q)) {
                    return new qx1(1003, "exceed storage max length");
                }
                rv1 rv1Var = this.a;
                rv1Var.r("#setStorageImpl dataKey=" + R + " dataValue=" + Q, false);
                this.a.G(p53Var).putString(R, Q);
                this.a.Y();
                return qx1.f();
            }
            return (qx1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements tt1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rv1 a;

        public b(rv1 rv1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rv1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rv1Var;
        }

        @Override // com.baidu.tieba.tt1.a
        public qx1 a(p53 p53Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, p53Var, jSONObject, str)) == null) {
                this.a.r("#clearStorageImpl clear", false);
                this.a.G(p53Var).edit().clear().apply();
                this.a.Y();
                return qx1.f();
            }
            return (qx1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements tt1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rv1 a;

        public c(rv1 rv1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rv1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rv1Var;
        }

        @Override // com.baidu.tieba.tt1.a
        public qx1 a(p53 p53Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, p53Var, jSONObject, str)) == null) {
                String R = rv1.R(jSONObject);
                if (R == null) {
                    return new qx1(202);
                }
                rv1 rv1Var = this.a;
                rv1Var.r("#removeStorageImpl dataKey=" + R, false);
                this.a.G(p53Var).remove(R);
                this.a.Y();
                return qx1.f();
            }
            return (qx1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements tt1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rv1 a;

        public d(rv1 rv1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rv1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rv1Var;
        }

        @Override // com.baidu.tieba.tt1.a
        public qx1 a(p53 p53Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, p53Var, jSONObject, str)) == null) {
                String R = rv1.R(jSONObject);
                if (R == null) {
                    return new qx1(202);
                }
                JSONObject P = rv1.P(this.a.G(p53Var).getString(R, null));
                if (P == null) {
                    return new qx1(202, "JSONException");
                }
                return new qx1(0, P);
            }
            return (qx1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class e implements tt1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(rv1 rv1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rv1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.tt1.a
        public qx1 a(p53 p53Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, p53Var, jSONObject, str)) == null) {
                yc3 g0 = p53Var.g0();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(SavedStateHandle.KEYS, new JSONArray((Collection) g0.g().a()));
                    jSONObject2.put(CommonTbJsBridge.FILE_DOWNLOAD_CURRENT_SIZE, g0.e() / 1024);
                    jSONObject2.put("limitSize", g0.n() / 1024);
                    return new qx1(0, jSONObject2);
                } catch (JSONException unused) {
                    return new qx1(202, "JSONException");
                }
            }
            return (qx1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ tt1.a b;
        public final /* synthetic */ p53 c;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ rv1 e;

        public f(rv1 rv1Var, String str, tt1.a aVar, p53 p53Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rv1Var, str, aVar, p53Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = rv1Var;
            this.a = str;
            this.b = aVar;
            this.c = p53Var;
            this.d = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                rv1 rv1Var = this.e;
                String str = this.a;
                rv1Var.d(str, this.b.a(this.c, this.d, str));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rv1(@NonNull rt1 rt1Var) {
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

    @Nullable
    public static JSONObject P(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("key")) {
                        jSONObject.remove("key");
                    }
                    return jSONObject;
                } catch (JSONException unused) {
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            if (str == null) {
                str = "";
            }
            try {
                jSONObject2.put("data", str);
                return jSONObject2;
            } catch (JSONException unused2) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public qx1 V(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            r("#setStorage", false);
            if (str != null && str.length() > 3145728) {
                return new qx1(1001, "exceed storage item max length");
            }
            return W(str, true);
        }
        return (qx1) invokeL.objValue;
    }

    public boolean O(@Nullable p53 p53Var, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, p53Var, str, str2)) == null) {
            if (p53Var == null) {
                return false;
            }
            return p53Var.g0().m(str, str2);
        }
        return invokeLLL.booleanValue;
    }

    @Nullable
    public static String Q(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            if (jSONObject.isNull("data")) {
                return null;
            }
            return jSONObject.optString("data");
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static String R(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            if (jSONObject.isNull("key")) {
                return null;
            }
            return jSONObject.optString("key");
        }
        return (String) invokeL.objValue;
    }

    public qx1 E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            r("#getStorage", false);
            return F(str, true);
        }
        return (qx1) invokeL.objValue;
    }

    public ql4 G(@NonNull p53 p53Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, p53Var)) == null) {
            return p53Var.g0().g();
        }
        return (ql4) invokeL.objValue;
    }

    public qx1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            r("#getStorageInfoAsync", false);
            return J(str, true);
        }
        return (qx1) invokeL.objValue;
    }

    public qx1 L(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            r("#getStorageSync", false);
            return F(str, false);
        }
        return (qx1) invokeL.objValue;
    }

    public qx1 S(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            r("#removeStorage", false);
            return T(str, true);
        }
        return (qx1) invokeL.objValue;
    }

    public qx1 U(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            r("#removeStorageSync", false);
            return T(str, false);
        }
        return (qx1) invokeL.objValue;
    }

    public qx1 X(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            r("#setStorageSync", false);
            return W(str, false);
        }
        return (qx1) invokeL.objValue;
    }

    public qx1 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            r("#clearStorage", false);
            return C(null, true);
        }
        return (qx1) invokeV.objValue;
    }

    public qx1 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            r("#clearStorageSync", false);
            return C(null, false);
        }
        return (qx1) invokeV.objValue;
    }

    public qx1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            r("#getStorageInfo", false);
            return J(null, true);
        }
        return (qx1) invokeV.objValue;
    }

    public qx1 K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            r("#getStorageInfoSync", false);
            return J(null, false);
        }
        return (qx1) invokeV.objValue;
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            lh3.h.b();
        }
    }

    public qx1 C(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            return M(str, z, new b(this));
        }
        return (qx1) invokeLZ.objValue;
    }

    public qx1 F(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
            return M(str, z, new d(this));
        }
        return (qx1) invokeLZ.objValue;
    }

    public qx1 J(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z)) == null) {
            return M(str, z, new e(this));
        }
        return (qx1) invokeLZ.objValue;
    }

    public qx1 T(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048591, this, str, z)) == null) {
            return M(str, z, new c(this));
        }
        return (qx1) invokeLZ.objValue;
    }

    public final qx1 W(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048594, this, str, z)) == null) {
            return M(str, z, new a(this));
        }
        return (qx1) invokeLZ.objValue;
    }

    public final qx1 M(@Nullable String str, boolean z, @NonNull tt1.a aVar) {
        InterceptResult invokeCommon;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, Boolean.valueOf(z), aVar})) == null) {
            p53 M = p53.M();
            if (N() && M == null) {
                return new qx1(1001, "swan app is null");
            }
            if (TextUtils.isEmpty(str)) {
                return aVar.a(M, new JSONObject(), null);
            }
            Pair<qx1, JSONObject> t = t(str);
            qx1 qx1Var = (qx1) t.first;
            if (!qx1Var.isSuccess()) {
                return qx1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            if (z) {
                str2 = jSONObject.optString("cb");
            } else {
                str2 = null;
            }
            if (z && !TextUtils.isEmpty(str2)) {
                ji3.k(new f(this, str2, aVar, M, jSONObject), "StorageApi");
                return qx1.f();
            }
            return aVar.a(M, jSONObject, null);
        }
        return (qx1) invokeCommon.objValue;
    }
}
