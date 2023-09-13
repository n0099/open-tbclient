package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.tieba.mg3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes8.dex */
public class x32 extends r32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements aq3<kg3<mg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ x32 d;

        public a(x32 x32Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x32Var, unitedSchemeEntity, callbackHandler, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = x32Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<mg3.e> kg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                b42 b42Var = (b42) this.d.q(this.a);
                if (fg3.h(kg3Var)) {
                    this.d.p(this.c, this.a, this.b, b42Var);
                    return;
                }
                fg3.p(kg3Var, this.b, this.a);
                h82.c("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements k63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b42 a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ x32 d;

        public b(x32 x32Var, b42 b42Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x32Var, b42Var, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = x32Var;
            this.a = b42Var;
            this.b = unitedSchemeEntity;
            this.c = callbackHandler;
        }

        @Override // com.baidu.tieba.k63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.d.k(this.b, this.c, this.d.o(this.a));
            h82.c("SwanAppCameraManager", str + "");
        }

        @Override // com.baidu.tieba.k63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.callCallback(this.c, this.b, 10005);
                h82.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x32(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/camera/update");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ec3) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            if (!(context instanceof Activity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                h82.c("SwanAppCameraManager", "handle action, but context is not Activity");
                return false;
            }
            hb3Var.e0().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, unitedSchemeEntity, callbackHandler, context));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean o(b42 b42Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b42Var)) == null) {
            h82.i("SwanAppCameraManager", "handle update camera instruction start");
            if (b42Var == null) {
                h82.c("SwanAppCameraManager", "Model is null");
                return false;
            }
            String str = b42Var.b;
            n13 n13Var = b42Var.h;
            if (!TextUtils.isEmpty(str) && n13Var != null && n13Var.h()) {
                g72 g72Var = (g72) u72.a(b42Var);
                if (g72Var == null) {
                    h82.c("SwanAppCameraManager", "update camera with a null component");
                    return false;
                }
                y62 update = g72Var.update((g72) b42Var);
                boolean a2 = update.a();
                if (!a2) {
                    h82.c("SwanAppCameraManager", "update camera fail: " + update.b);
                }
                return a2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("cameraId = ");
            sb.append(str);
            sb.append(" ; position = ");
            if (n13Var == null) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            h82.c("SwanAppCameraManager", sb.toString());
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b42 b42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, b42Var) == null) {
            h82.i("SwanAppCameraManager", "handleAuthorized start");
            j63.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 100, context, new b(this, b42Var, unitedSchemeEntity, callbackHandler));
        }
    }

    public x62 q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unitedSchemeEntity)) == null) {
            return new b42(l(unitedSchemeEntity));
        }
        return (x62) invokeL.objValue;
    }
}
