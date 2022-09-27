package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.tieba.q83;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes6.dex */
public class wv1 extends vv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public lx9 c;

    /* loaded from: classes6.dex */
    public class a implements ei3<o83<q83.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ fw1 d;
        public final /* synthetic */ wv1 e;

        public a(wv1 wv1Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, fw1 fw1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wv1Var, callbackHandler, unitedSchemeEntity, context, fw1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = wv1Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = context;
            this.d = fw1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(o83<q83.e> o83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o83Var) == null) {
                if (j83.h(o83Var)) {
                    this.e.q(this.c, this.b, this.a, this.d);
                    return;
                }
                j83.p(o83Var, this.a, this.b);
                if (this.e.c != null) {
                    this.e.c.onError(new Throwable());
                } else {
                    l02.c("SwanAppCameraManager", "camera authorize failure with a null subscriber ");
                }
                l02.c("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements oy2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ fw1 b;
        public final /* synthetic */ UnitedSchemeEntity c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ wv1 e;

        public b(wv1 wv1Var, Context context, fw1 fw1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wv1Var, context, fw1Var, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = wv1Var;
            this.a = context;
            this.b = fw1Var;
            this.c = unitedSchemeEntity;
            this.d = callbackHandler;
        }

        @Override // com.baidu.tieba.oy2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.k(this.c, this.d, this.e.p(this.a, this.b));
                l02.c("SwanAppCameraManager", str + "");
            }
        }

        @Override // com.baidu.tieba.oy2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.callCallback(this.d, this.c, 10005);
                if (this.e.c != null) {
                    this.e.c.onError(new Throwable());
                } else {
                    l02.c("SwanAppCameraManager", "handleAuthorized end, failure with a null subscriber ");
                }
                l02.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wv1(i43 i43Var) {
        super(i43Var, "/swanAPI/camera/insert");
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
                super((i43) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.i53
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, l33Var)) == null) {
            if (!(context instanceof Activity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                l02.c("SwanAppCameraManager", "handle action, but context is not Activity");
                return false;
            }
            fw1 fw1Var = (fw1) r(unitedSchemeEntity);
            lx9 w = new kz1(context, fw1Var).w();
            this.c = w;
            if (w == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                l02.c("SwanAppCameraManager", "camera component insert delayed fail");
                return false;
            }
            l33Var.e0().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, fw1Var));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean p(Context context, fw1 fw1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, fw1Var)) == null) {
            l02.i("SwanAppCameraManager", "handle insert camera instruction start");
            if (context != null && fw1Var != null) {
                String str = fw1Var.b;
                rt2 rt2Var = fw1Var.h;
                if (!TextUtils.isEmpty(str) && rt2Var != null && rt2Var.h()) {
                    lx9 lx9Var = this.c;
                    if (lx9Var == null) {
                        e02.a("SwanAppCameraManager", "executionInstruction with a null subscriber");
                        return false;
                    }
                    lx9Var.onCompleted();
                    l02.i("SwanAppCameraManager", "handle insert camera instruction end");
                    return true;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("cameraId = ");
                sb.append(str);
                sb.append(" ; position = ");
                sb.append(rt2Var == null);
                l02.c("SwanAppCameraManager", sb.toString());
                return false;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Context is null ? = ");
            sb2.append(context == null);
            sb2.append(" ; model is null ? = ");
            sb2.append(fw1Var == null);
            l02.c("SwanAppCameraManager", sb2.toString());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, fw1 fw1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, fw1Var) == null) {
            l02.i("SwanAppCameraManager", "handleAuthorized start");
            ny2.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new b(this, context, fw1Var, unitedSchemeEntity, callbackHandler));
        }
    }

    public bz1 r(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unitedSchemeEntity)) == null) ? new fw1(l(unitedSchemeEntity)) : (bz1) invokeL.objValue;
    }
}
