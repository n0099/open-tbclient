package com.baidu.tieba;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.nr1;
import com.baidu.tieba.q83;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class sk3 extends or1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a extends nr1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sk3 d;

        /* renamed from: com.baidu.tieba.sk3$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0414a implements ei3<o83<q83.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ nr1.b a;
            public final /* synthetic */ a b;

            public C0414a(a aVar, nr1.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ei3
            /* renamed from: b */
            public void a(o83<q83.e> o83Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o83Var) == null) {
                    if (j83.h(o83Var)) {
                        this.a.a(this.b.d.z());
                        return;
                    }
                    int b = o83Var.b();
                    this.a.a(new lv1(b, j83.f(b)));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(sk3 sk3Var, String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sk3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = sk3Var;
        }

        @Override // com.baidu.tieba.nr1
        @NonNull
        public lv1 d(@NonNull JSONObject jSONObject, @NonNull nr1.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
                l33 b0 = l33.b0();
                if (b0 == null) {
                    return new lv1(1001, "null swan runtime");
                }
                b0.e0().g(k33.K(), "mapp_i_get_bduss", new C0414a(this, bVar));
                return lv1.f();
            }
            return (lv1) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.nr1
        @NonNull
        public lv1 e(@NonNull JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) ? this.d.z() : (lv1) invokeL.objValue;
        }

        @Override // com.baidu.tieba.nr1
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? k33.K().E() && k33.K().q().e0().f("mapp_i_get_bduss") : invokeV.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sk3(@NonNull mr1 mr1Var) {
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

    @Override // com.baidu.tieba.or1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "PrivateAccount" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.or1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "GetBdussApi" : (String) invokeV.objValue;
    }

    @SuppressLint({"SwanBindApiNote"})
    public lv1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getBduss", false);
            return m(str, new a(this, "getBDUSS"));
        }
        return (lv1) invokeL.objValue;
    }

    @NonNull
    public final lv1 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String i = mj3.i(k33.K());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("bduss", i);
                return new lv1(0, jSONObject);
            } catch (JSONException e) {
                p("#getBdussResult json put data fail", e, false);
                return new lv1(1001, "json put data fail");
            }
        }
        return (lv1) invokeV.objValue;
    }
}
