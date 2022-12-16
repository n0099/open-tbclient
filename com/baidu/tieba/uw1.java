package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.tieba.j93;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes6.dex */
public class uw1 extends ow1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements xi3<h93<j93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ uw1 d;

        public a(uw1 uw1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uw1Var, unitedSchemeEntity, callbackHandler, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = uw1Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(h93<j93.e> h93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h93Var) == null) {
                yw1 yw1Var = (yw1) this.d.q(this.a);
                if (c93.h(h93Var)) {
                    this.d.p(this.c, this.a, this.b, yw1Var);
                    return;
                }
                c93.p(h93Var, this.b, this.a);
                e12.c("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements hz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yw1 a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ uw1 d;

        public b(uw1 uw1Var, yw1 yw1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uw1Var, yw1Var, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = uw1Var;
            this.a = yw1Var;
            this.b = unitedSchemeEntity;
            this.c = callbackHandler;
        }

        @Override // com.baidu.tieba.hz2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.d.k(this.b, this.c, this.d.o(this.a));
            e12.c("SwanAppCameraManager", str + "");
        }

        @Override // com.baidu.tieba.hz2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.callCallback(this.c, this.b, 10005);
                e12.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uw1(b53 b53Var) {
        super(b53Var, "/swanAPI/camera/update");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b53Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((b53) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.b63
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e43 e43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, e43Var)) == null) {
            if (!(context instanceof Activity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                e12.c("SwanAppCameraManager", "handle action, but context is not Activity");
                return false;
            }
            e43Var.e0().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, unitedSchemeEntity, callbackHandler, context));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean o(yw1 yw1Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yw1Var)) == null) {
            e12.i("SwanAppCameraManager", "handle update camera instruction start");
            if (yw1Var == null) {
                e12.c("SwanAppCameraManager", "Model is null");
                return false;
            }
            String str = yw1Var.b;
            ku2 ku2Var = yw1Var.h;
            if (!TextUtils.isEmpty(str) && ku2Var != null && ku2Var.h()) {
                d02 d02Var = (d02) r02.a(yw1Var);
                if (d02Var == null) {
                    e12.c("SwanAppCameraManager", "update camera with a null component");
                    return false;
                }
                vz1 update = d02Var.update((d02) yw1Var);
                boolean a2 = update.a();
                if (!a2) {
                    e12.c("SwanAppCameraManager", "update camera fail: " + update.b);
                }
                return a2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("cameraId = ");
            sb.append(str);
            sb.append(" ; position = ");
            if (ku2Var == null) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            e12.c("SwanAppCameraManager", sb.toString());
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, yw1 yw1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, yw1Var) == null) {
            e12.i("SwanAppCameraManager", "handleAuthorized start");
            gz2.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 100, context, new b(this, yw1Var, unitedSchemeEntity, callbackHandler));
        }
    }

    public uz1 q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unitedSchemeEntity)) == null) {
            return new yw1(l(unitedSchemeEntity));
        }
        return (uz1) invokeL.objValue;
    }
}
