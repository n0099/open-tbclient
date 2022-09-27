package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.ps1;
import com.baidu.tieba.q83;
import com.baidu.tieba.qs1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class j63 extends i53 implements qs1.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CallbackHandler c;

    /* loaded from: classes4.dex */
    public class a implements ei3<o83<q83.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ ps1.c b;
        public final /* synthetic */ l33 c;
        public final /* synthetic */ j63 d;

        public a(j63 j63Var, CallbackHandler callbackHandler, ps1.c cVar, l33 l33Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j63Var, callbackHandler, cVar, l33Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = j63Var;
            this.a = callbackHandler;
            this.b = cVar;
            this.c = l33Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(o83<q83.e> o83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o83Var) == null) {
                this.d.k(o83Var, this.a, this.b, this.c.n0());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j63(i43 i43Var) {
        super(i43Var, "/swanAPI/getLocation");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i43Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.qs1.c
    public void b(ps1.c cVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, cVar, i) == null) || this.c == null) {
            return;
        }
        l02.c("GetLocationAction", "request location error code : " + i);
        this.c.handleSchemeDispatchCallback(cVar.c, UnitedSchemeUtility.wrapCallbackParams(i).toString());
    }

    @Override // com.baidu.tieba.i53
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, l33Var)) == null) {
            if (i53.b) {
                Log.d("GetLocationAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = callbackHandler;
            if (l33Var == null) {
                l02.c("location", "swan app is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            ps1.c b = ps1.c.b(unitedSchemeEntity.getParam("params"));
            if (b != null && b.a()) {
                if (TextUtils.isEmpty(b.c)) {
                    l02.c("location", "empty cb");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    return false;
                }
                l33Var.e0().g(context, "mapp_location", new a(this, callbackHandler, b, l33Var));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            l02.c("location", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.qs1.c
    public void f(ps1.c cVar, String str) {
        CallbackHandler callbackHandler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, str) == null) || (callbackHandler = this.c) == null) {
            return;
        }
        callbackHandler.handleSchemeDispatchCallback(cVar.c, UnitedSchemeUtility.wrapCallbackParams(10005, "system deny").toString());
    }

    @Override // com.baidu.tieba.qs1.c
    public void g(ps1.c cVar, k63 k63Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cVar, k63Var) == null) {
            if (i53.b) {
                Log.d("GetLocationAction", "convert info : " + k63Var.a());
            }
            CallbackHandler callbackHandler = this.c;
            if (callbackHandler == null) {
                return;
            }
            callbackHandler.handleSchemeDispatchCallback(cVar.c, UnitedSchemeUtility.wrapCallbackParams(k63Var.a(), 0).toString());
        }
    }

    public final void k(o83<q83.e> o83Var, CallbackHandler callbackHandler, ps1.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{o83Var, callbackHandler, cVar, Boolean.valueOf(z)}) == null) {
            l02.i("GetLocationAction", "authorized result is " + o83Var);
            if (j83.h(o83Var)) {
                qs1.d().e(cVar, this, z);
                return;
            }
            int b = o83Var.b();
            callbackHandler.handleSchemeDispatchCallback(cVar.c, UnitedSchemeUtility.wrapCallbackParams(b, j83.f(b)).toString());
        }
    }
}
