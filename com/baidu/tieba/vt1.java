package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.kd3;
import com.baidu.tieba.or1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class vt1 extends rt1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements or1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vt1 a;

        /* renamed from: com.baidu.tieba.vt1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0451a implements kd3.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ du1 a;
            public final /* synthetic */ a b;

            public C0451a(a aVar, du1 du1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, du1Var};
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
                this.a = du1Var;
            }

            @Override // com.baidu.tieba.kd3.c
            public void a(float f, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Integer.valueOf(i)}) == null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("direction", f);
                        jSONObject.put("accuracy", kd3.h(i));
                        this.a.d(this.b.a, jSONObject);
                    } catch (JSONException e) {
                        l02.c("CompassApi", "handle compass,json error，" + e.toString());
                        this.a.f(this.b.a, "Json error");
                    }
                }
            }
        }

        public a(vt1 vt1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vt1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vt1Var;
        }

        @Override // com.baidu.tieba.or1.a
        public lv1 a(l33 l33Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, l33Var, jSONObject, str)) == null) {
                du1 du1Var = new du1("compassChange", jSONObject, str);
                kd3 i = kd3.i();
                i.l(this.a.getContext());
                i.o(new C0451a(this, du1Var));
                l02.i("CompassApi", "start listen compass");
                i.p();
                du1Var.b(this.a);
                return lv1.f();
            }
            return (lv1) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vt1(@NonNull mr1 mr1Var) {
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
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "CompassApi" : (String) invokeV.objValue;
    }

    public lv1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#startCompass", true);
            return l(str, true, new a(this));
        }
        return (lv1) invokeL.objValue;
    }

    public lv1 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q("#stopCompass", true);
            kd3.i().q();
            return lv1.f();
        }
        return (lv1) invokeV.objValue;
    }
}
