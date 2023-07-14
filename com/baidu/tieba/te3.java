package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.a12;
import com.baidu.tieba.ah3;
import com.baidu.tieba.z02;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class te3 extends sd3 implements a12.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CallbackHandler c;

    /* loaded from: classes8.dex */
    public class a implements oq3<yg3<ah3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ z02.c b;
        public final /* synthetic */ vb3 c;
        public final /* synthetic */ te3 d;

        public a(te3 te3Var, CallbackHandler callbackHandler, z02.c cVar, vb3 vb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {te3Var, callbackHandler, cVar, vb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = te3Var;
            this.a = callbackHandler;
            this.b = cVar;
            this.c = vb3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(yg3<ah3.e> yg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yg3Var) == null) {
                this.d.k(yg3Var, this.a, this.b, this.c.n0());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public te3(sc3 sc3Var) {
        super(sc3Var, "/swanAPI/getLocation");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sc3Var};
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

    @Override // com.baidu.tieba.a12.c
    public void b(z02.c cVar, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048576, this, cVar, i) != null) || this.c == null) {
            return;
        }
        v82.c("GetLocationAction", "request location error code : " + i);
        this.c.handleSchemeDispatchCallback(cVar.c, UnitedSchemeUtility.wrapCallbackParams(i).toString());
    }

    @Override // com.baidu.tieba.a12.c
    public void g(z02.c cVar, ue3 ue3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cVar, ue3Var) == null) {
            if (sd3.b) {
                Log.d("GetLocationAction", "convert info : " + ue3Var.a());
            }
            CallbackHandler callbackHandler = this.c;
            if (callbackHandler == null) {
                return;
            }
            callbackHandler.handleSchemeDispatchCallback(cVar.c, UnitedSchemeUtility.wrapCallbackParams(ue3Var.a(), 0).toString());
        }
    }

    @Override // com.baidu.tieba.sd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, vb3Var)) == null) {
            if (sd3.b) {
                Log.d("GetLocationAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = callbackHandler;
            if (vb3Var == null) {
                v82.c("location", "swan app is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            z02.c b = z02.c.b(unitedSchemeEntity.getParam("params"));
            if (b != null && b.a()) {
                if (TextUtils.isEmpty(b.c)) {
                    v82.c("location", "empty cb");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    return false;
                }
                vb3Var.e0().g(context, "mapp_location", new a(this, callbackHandler, b, vb3Var));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            v82.c("location", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.a12.c
    public void f(z02.c cVar, String str) {
        CallbackHandler callbackHandler;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, str) != null) || (callbackHandler = this.c) == null) {
            return;
        }
        callbackHandler.handleSchemeDispatchCallback(cVar.c, UnitedSchemeUtility.wrapCallbackParams(10005, "system deny").toString());
    }

    public final void k(yg3<ah3.e> yg3Var, CallbackHandler callbackHandler, z02.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{yg3Var, callbackHandler, cVar, Boolean.valueOf(z)}) == null) {
            v82.i("GetLocationAction", "authorized result is " + yg3Var);
            if (tg3.h(yg3Var)) {
                a12.d().e(cVar, this, z);
                return;
            }
            int b = yg3Var.b();
            callbackHandler.handleSchemeDispatchCallback(cVar.c, UnitedSchemeUtility.wrapCallbackParams(b, tg3.f(b)).toString());
        }
    }
}
