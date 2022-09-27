package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.or1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class mt1 extends lt1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements or1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mt1 a;

        public a(mt1 mt1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mt1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mt1Var;
        }

        @Override // com.baidu.tieba.or1.a
        public lv1 a(l33 l33Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, l33Var, jSONObject, str)) == null) {
                String Q = mt1.Q(jSONObject);
                if (Q == null) {
                    return new lv1(202);
                }
                if (ua3.b(Q)) {
                    return new lv1(1001, "exceed storage key max length");
                }
                String P = mt1.P(jSONObject);
                if (P == null) {
                    return new lv1(202);
                }
                if (ua3.c(P)) {
                    return new lv1(1001, "exceed storage item max length");
                }
                if (this.a.N(l33Var, Q, P)) {
                    return new lv1(1003, "exceed storage max length");
                }
                mt1 mt1Var = this.a;
                mt1Var.q("#setStorageImpl dataKey=" + Q + " dataValue=" + P, false);
                this.a.F(l33Var).putString(Q, P);
                this.a.X();
                return lv1.f();
            }
            return (lv1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements or1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mt1 a;

        public b(mt1 mt1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mt1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mt1Var;
        }

        @Override // com.baidu.tieba.or1.a
        public lv1 a(l33 l33Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, l33Var, jSONObject, str)) == null) {
                this.a.q("#clearStorageImpl clear", false);
                this.a.F(l33Var).edit().clear().apply();
                this.a.X();
                return lv1.f();
            }
            return (lv1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements or1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mt1 a;

        public c(mt1 mt1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mt1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mt1Var;
        }

        @Override // com.baidu.tieba.or1.a
        public lv1 a(l33 l33Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, l33Var, jSONObject, str)) == null) {
                String Q = mt1.Q(jSONObject);
                if (Q == null) {
                    return new lv1(202);
                }
                mt1 mt1Var = this.a;
                mt1Var.q("#removeStorageImpl dataKey=" + Q, false);
                this.a.F(l33Var).remove(Q);
                this.a.X();
                return lv1.f();
            }
            return (lv1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements or1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mt1 a;

        public d(mt1 mt1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mt1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mt1Var;
        }

        @Override // com.baidu.tieba.or1.a
        public lv1 a(l33 l33Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, l33Var, jSONObject, str)) == null) {
                String Q = mt1.Q(jSONObject);
                if (Q == null) {
                    return new lv1(202);
                }
                JSONObject O = mt1.O(this.a.F(l33Var).getString(Q, null));
                if (O == null) {
                    return new lv1(202, "JSONException");
                }
                return new lv1(0, O);
            }
            return (lv1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements or1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(mt1 mt1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mt1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.or1.a
        public lv1 a(l33 l33Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, l33Var, jSONObject, str)) == null) {
                ua3 f0 = l33Var.f0();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(SavedStateHandle.KEYS, new JSONArray((Collection) f0.g().a()));
                    jSONObject2.put("currentSize", f0.e() / 1024);
                    jSONObject2.put("limitSize", f0.n() / 1024);
                    return new lv1(0, jSONObject2);
                } catch (JSONException unused) {
                    return new lv1(202, "JSONException");
                }
            }
            return (lv1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ or1.a b;
        public final /* synthetic */ l33 c;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ mt1 e;

        public f(mt1 mt1Var, String str, or1.a aVar, l33 l33Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mt1Var, str, aVar, l33Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = mt1Var;
            this.a = str;
            this.b = aVar;
            this.c = l33Var;
            this.d = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                mt1 mt1Var = this.e;
                String str = this.a;
                mt1Var.d(str, this.b.a(this.c, this.d, str));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mt1(@NonNull mr1 mr1Var) {
        super(mr1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mr1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mr1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Nullable
    public static JSONObject O(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
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

    @Nullable
    public static String P(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject.isNull("data")) {
                return null;
            }
            return jSONObject.optString("data");
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static String Q(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            if (jSONObject.isNull("key")) {
                return null;
            }
            return jSONObject.optString("key");
        }
        return (String) invokeL.objValue;
    }

    public lv1 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#clearStorage", false);
            return B(null, true);
        }
        return (lv1) invokeV.objValue;
    }

    public lv1 B(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) ? L(str, z, new b(this)) : (lv1) invokeLZ.objValue;
    }

    public lv1 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q("#clearStorageSync", false);
            return B(null, false);
        }
        return (lv1) invokeV.objValue;
    }

    public lv1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#getStorage", false);
            return E(str, true);
        }
        return (lv1) invokeL.objValue;
    }

    public lv1 E(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) ? L(str, z, new d(this)) : (lv1) invokeLZ.objValue;
    }

    public nj4 F(@NonNull l33 l33Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, l33Var)) == null) ? l33Var.f0().g() : (nj4) invokeL.objValue;
    }

    public lv1 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            q("#getStorageInfo", false);
            return I(null, true);
        }
        return (lv1) invokeV.objValue;
    }

    public lv1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#getStorageInfoAsync", false);
            return I(str, true);
        }
        return (lv1) invokeL.objValue;
    }

    public lv1 I(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z)) == null) ? L(str, z, new e(this)) : (lv1) invokeLZ.objValue;
    }

    public lv1 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            q("#getStorageInfoSync", false);
            return I(null, false);
        }
        return (lv1) invokeV.objValue;
    }

    public lv1 K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            q("#getStorageSync", false);
            return E(str, false);
        }
        return (lv1) invokeL.objValue;
    }

    public final lv1 L(@Nullable String str, boolean z, @NonNull or1.a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, Boolean.valueOf(z), aVar})) == null) {
            l33 M = l33.M();
            if (M() && M == null) {
                return new lv1(1001, "swan app is null");
            }
            if (TextUtils.isEmpty(str)) {
                return aVar.a(M, new JSONObject(), null);
            }
            Pair<lv1, JSONObject> s = s(str);
            lv1 lv1Var = (lv1) s.first;
            if (lv1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = z ? jSONObject.optString("cb") : null;
                if (z && !TextUtils.isEmpty(optString)) {
                    fg3.k(new f(this, optString, aVar, M, jSONObject), "StorageApi");
                    return lv1.f();
                }
                return aVar.a(M, jSONObject, null);
            }
            return lv1Var;
        }
        return (lv1) invokeCommon.objValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean N(@Nullable l33 l33Var, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, l33Var, str, str2)) == null) {
            if (l33Var == null) {
                return false;
            }
            return l33Var.f0().m(str, str2);
        }
        return invokeLLL.booleanValue;
    }

    public lv1 R(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            q("#removeStorage", false);
            return S(str, true);
        }
        return (lv1) invokeL.objValue;
    }

    public lv1 S(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048591, this, str, z)) == null) ? L(str, z, new c(this)) : (lv1) invokeLZ.objValue;
    }

    public lv1 T(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            q("#removeStorageSync", false);
            return S(str, false);
        }
        return (lv1) invokeL.objValue;
    }

    public lv1 U(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            q("#setStorage", false);
            if (str != null && str.length() > 3145728) {
                return new lv1(1001, "exceed storage item max length");
            }
            return V(str, true);
        }
        return (lv1) invokeL.objValue;
    }

    public final lv1 V(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048594, this, str, z)) == null) ? L(str, z, new a(this)) : (lv1) invokeLZ.objValue;
    }

    public lv1 W(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            q("#setStorageSync", false);
            return V(str, false);
        }
        return (lv1) invokeL.objValue;
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            hf3.h.update();
        }
    }

    @Override // com.baidu.tieba.or1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? "StorageApi" : (String) invokeV.objValue;
    }
}
