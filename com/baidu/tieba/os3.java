package com.baidu.tieba;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.jz1;
import com.baidu.tieba.mg3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class os3 extends kz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.kz1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "PrivateAccount" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "GetBdussApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a extends jz1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ os3 d;

        /* renamed from: com.baidu.tieba.os3$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0424a implements aq3<kg3<mg3.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ jz1.b a;
            public final /* synthetic */ a b;

            public C0424a(a aVar, jz1.b bVar) {
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
            @Override // com.baidu.tieba.aq3
            /* renamed from: b */
            public void a(kg3<mg3.e> kg3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                    if (!fg3.h(kg3Var)) {
                        int b = kg3Var.b();
                        this.a.a(new h32(b, fg3.f(b)));
                        return;
                    }
                    this.a.a(this.b.d.z());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(os3 os3Var, String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {os3Var, str};
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
            this.d = os3Var;
        }

        @Override // com.baidu.tieba.jz1
        @NonNull
        public h32 d(@NonNull JSONObject jSONObject, @NonNull jz1.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
                hb3 b0 = hb3.b0();
                if (b0 == null) {
                    return new h32(1001, "null swan runtime");
                }
                b0.e0().g(gb3.K(), "mapp_i_get_bduss", new C0424a(this, bVar));
                return h32.f();
            }
            return (h32) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.jz1
        @NonNull
        public h32 e(@NonNull JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
                return this.d.z();
            }
            return (h32) invokeL.objValue;
        }

        @Override // com.baidu.tieba.jz1
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (gb3.K().E() && gb3.K().q().e0().f("mapp_i_get_bduss")) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public os3(@NonNull iz1 iz1Var) {
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

    @SuppressLint({"SwanBindApiNote"})
    public h32 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getBduss", false);
            return m(str, new a(this, "getBDUSS"));
        }
        return (h32) invokeL.objValue;
    }

    @NonNull
    public final h32 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String i = ir3.i(gb3.K());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("bduss", i);
                return new h32(0, jSONObject);
            } catch (JSONException e) {
                p("#getBdussResult json put data fail", e, false);
                return new h32(1001, "json put data fail");
            }
        }
        return (h32) invokeV.objValue;
    }
}
