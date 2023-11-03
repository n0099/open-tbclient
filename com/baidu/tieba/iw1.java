package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.ku1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class iw1 extends hw1 {
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

    @Override // com.baidu.tieba.ku1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? "StorageApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements ku1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iw1 a;

        public a(iw1 iw1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iw1Var;
        }

        @Override // com.baidu.tieba.ku1.a
        public hy1 a(g63 g63Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, g63Var, jSONObject, str)) == null) {
                String R = iw1.R(jSONObject);
                if (R == null) {
                    return new hy1(202);
                }
                if (pd3.b(R)) {
                    return new hy1(1001, "exceed storage key max length");
                }
                String Q = iw1.Q(jSONObject);
                if (Q == null) {
                    return new hy1(202);
                }
                if (pd3.c(Q)) {
                    return new hy1(1001, "exceed storage item max length");
                }
                if (this.a.O(g63Var, R, Q)) {
                    return new hy1(1003, "exceed storage max length");
                }
                iw1 iw1Var = this.a;
                iw1Var.r("#setStorageImpl dataKey=" + R + " dataValue=" + Q, false);
                this.a.G(g63Var).putString(R, Q);
                this.a.Y();
                return hy1.f();
            }
            return (hy1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ku1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iw1 a;

        public b(iw1 iw1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iw1Var;
        }

        @Override // com.baidu.tieba.ku1.a
        public hy1 a(g63 g63Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, g63Var, jSONObject, str)) == null) {
                this.a.r("#clearStorageImpl clear", false);
                this.a.G(g63Var).edit().clear().apply();
                this.a.Y();
                return hy1.f();
            }
            return (hy1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ku1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iw1 a;

        public c(iw1 iw1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iw1Var;
        }

        @Override // com.baidu.tieba.ku1.a
        public hy1 a(g63 g63Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, g63Var, jSONObject, str)) == null) {
                String R = iw1.R(jSONObject);
                if (R == null) {
                    return new hy1(202);
                }
                iw1 iw1Var = this.a;
                iw1Var.r("#removeStorageImpl dataKey=" + R, false);
                this.a.G(g63Var).remove(R);
                this.a.Y();
                return hy1.f();
            }
            return (hy1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ku1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iw1 a;

        public d(iw1 iw1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iw1Var;
        }

        @Override // com.baidu.tieba.ku1.a
        public hy1 a(g63 g63Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, g63Var, jSONObject, str)) == null) {
                String R = iw1.R(jSONObject);
                if (R == null) {
                    return new hy1(202);
                }
                JSONObject P = iw1.P(this.a.G(g63Var).getString(R, null));
                if (P == null) {
                    return new hy1(202, "JSONException");
                }
                return new hy1(0, P);
            }
            return (hy1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ku1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(iw1 iw1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.ku1.a
        public hy1 a(g63 g63Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, g63Var, jSONObject, str)) == null) {
                pd3 g0 = g63Var.g0();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(SavedStateHandle.KEYS, new JSONArray((Collection) g0.g().a()));
                    jSONObject2.put(CommonTbJsBridge.FILE_DOWNLOAD_CURRENT_SIZE, g0.e() / 1024);
                    jSONObject2.put("limitSize", g0.n() / 1024);
                    return new hy1(0, jSONObject2);
                } catch (JSONException unused) {
                    return new hy1(202, "JSONException");
                }
            }
            return (hy1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ku1.a b;
        public final /* synthetic */ g63 c;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ iw1 e;

        public f(iw1 iw1Var, String str, ku1.a aVar, g63 g63Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw1Var, str, aVar, g63Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = iw1Var;
            this.a = str;
            this.b = aVar;
            this.c = g63Var;
            this.d = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                iw1 iw1Var = this.e;
                String str = this.a;
                iw1Var.d(str, this.b.a(this.c, this.d, str));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iw1(@NonNull iu1 iu1Var) {
        super(iu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iu1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iu1) newInitContext.callArgs[0]);
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

    public hy1 V(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            r("#setStorage", false);
            if (str != null && str.length() > 3145728) {
                return new hy1(1001, "exceed storage item max length");
            }
            return W(str, true);
        }
        return (hy1) invokeL.objValue;
    }

    public boolean O(@Nullable g63 g63Var, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, g63Var, str, str2)) == null) {
            if (g63Var == null) {
                return false;
            }
            return g63Var.g0().m(str, str2);
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

    public hy1 E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            r("#getStorage", false);
            return F(str, true);
        }
        return (hy1) invokeL.objValue;
    }

    public hm4 G(@NonNull g63 g63Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, g63Var)) == null) {
            return g63Var.g0().g();
        }
        return (hm4) invokeL.objValue;
    }

    public hy1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            r("#getStorageInfoAsync", false);
            return J(str, true);
        }
        return (hy1) invokeL.objValue;
    }

    public hy1 L(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            r("#getStorageSync", false);
            return F(str, false);
        }
        return (hy1) invokeL.objValue;
    }

    public hy1 S(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            r("#removeStorage", false);
            return T(str, true);
        }
        return (hy1) invokeL.objValue;
    }

    public hy1 U(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            r("#removeStorageSync", false);
            return T(str, false);
        }
        return (hy1) invokeL.objValue;
    }

    public hy1 X(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            r("#setStorageSync", false);
            return W(str, false);
        }
        return (hy1) invokeL.objValue;
    }

    public hy1 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            r("#clearStorage", false);
            return C(null, true);
        }
        return (hy1) invokeV.objValue;
    }

    public hy1 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            r("#clearStorageSync", false);
            return C(null, false);
        }
        return (hy1) invokeV.objValue;
    }

    public hy1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            r("#getStorageInfo", false);
            return J(null, true);
        }
        return (hy1) invokeV.objValue;
    }

    public hy1 K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            r("#getStorageInfoSync", false);
            return J(null, false);
        }
        return (hy1) invokeV.objValue;
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ci3.h.b();
        }
    }

    public hy1 C(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            return M(str, z, new b(this));
        }
        return (hy1) invokeLZ.objValue;
    }

    public hy1 F(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
            return M(str, z, new d(this));
        }
        return (hy1) invokeLZ.objValue;
    }

    public hy1 J(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z)) == null) {
            return M(str, z, new e(this));
        }
        return (hy1) invokeLZ.objValue;
    }

    public hy1 T(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048591, this, str, z)) == null) {
            return M(str, z, new c(this));
        }
        return (hy1) invokeLZ.objValue;
    }

    public final hy1 W(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048594, this, str, z)) == null) {
            return M(str, z, new a(this));
        }
        return (hy1) invokeLZ.objValue;
    }

    public final hy1 M(@Nullable String str, boolean z, @NonNull ku1.a aVar) {
        InterceptResult invokeCommon;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, Boolean.valueOf(z), aVar})) == null) {
            g63 M = g63.M();
            if (N() && M == null) {
                return new hy1(1001, "swan app is null");
            }
            if (TextUtils.isEmpty(str)) {
                return aVar.a(M, new JSONObject(), null);
            }
            Pair<hy1, JSONObject> t = t(str);
            hy1 hy1Var = (hy1) t.first;
            if (!hy1Var.isSuccess()) {
                return hy1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            if (z) {
                str2 = jSONObject.optString("cb");
            } else {
                str2 = null;
            }
            if (z && !TextUtils.isEmpty(str2)) {
                aj3.k(new f(this, str2, aVar, M, jSONObject), "StorageApi");
                return hy1.f();
            }
            return aVar.a(M, jSONObject, null);
        }
        return (hy1) invokeCommon.objValue;
    }
}
