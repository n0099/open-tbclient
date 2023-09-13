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
import com.baidu.tieba.mg3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes7.dex */
public class s32 extends r32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public yac c;

    /* loaded from: classes7.dex */
    public class a implements aq3<kg3<mg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ b42 d;
        public final /* synthetic */ s32 e;

        public a(s32 s32Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, b42 b42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s32Var, callbackHandler, unitedSchemeEntity, context, b42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = s32Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = context;
            this.d = b42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<mg3.e> kg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                if (fg3.h(kg3Var)) {
                    this.e.q(this.c, this.b, this.a, this.d);
                    return;
                }
                fg3.p(kg3Var, this.a, this.b);
                if (this.e.c != null) {
                    this.e.c.onError(new Throwable());
                } else {
                    h82.c("SwanAppCameraManager", "camera authorize failure with a null subscriber ");
                }
                h82.c("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements k63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ b42 b;
        public final /* synthetic */ UnitedSchemeEntity c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ s32 e;

        public b(s32 s32Var, Context context, b42 b42Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s32Var, context, b42Var, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = s32Var;
            this.a = context;
            this.b = b42Var;
            this.c = unitedSchemeEntity;
            this.d = callbackHandler;
        }

        @Override // com.baidu.tieba.k63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.e.k(this.c, this.d, this.e.p(this.a, this.b));
            h82.c("SwanAppCameraManager", str + "");
        }

        @Override // com.baidu.tieba.k63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.callCallback(this.d, this.c, 10005);
                if (this.e.c != null) {
                    this.e.c.onError(new Throwable());
                } else {
                    h82.c("SwanAppCameraManager", "handleAuthorized end, failure with a null subscriber ");
                }
                h82.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s32(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/camera/insert");
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

    public x62 r(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unitedSchemeEntity)) == null) {
            return new b42(l(unitedSchemeEntity));
        }
        return (x62) invokeL.objValue;
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
            b42 b42Var = (b42) r(unitedSchemeEntity);
            yac w = new g72(context, b42Var).w();
            this.c = w;
            if (w == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                h82.c("SwanAppCameraManager", "camera component insert delayed fail");
                return false;
            }
            hb3Var.e0().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, b42Var));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean p(Context context, b42 b42Var) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, b42Var)) == null) {
            h82.i("SwanAppCameraManager", "handle insert camera instruction start");
            boolean z2 = true;
            if (context != null && b42Var != null) {
                String str = b42Var.b;
                n13 n13Var = b42Var.h;
                if (!TextUtils.isEmpty(str) && n13Var != null && n13Var.h()) {
                    yac yacVar = this.c;
                    if (yacVar == null) {
                        a82.a("SwanAppCameraManager", "executionInstruction with a null subscriber");
                        return false;
                    }
                    yacVar.onCompleted();
                    h82.i("SwanAppCameraManager", "handle insert camera instruction end");
                    return true;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("cameraId = ");
                sb.append(str);
                sb.append(" ; position = ");
                if (n13Var != null) {
                    z2 = false;
                }
                sb.append(z2);
                h82.c("SwanAppCameraManager", sb.toString());
                return false;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Context is null ? = ");
            if (context == null) {
                z = true;
            } else {
                z = false;
            }
            sb2.append(z);
            sb2.append(" ; model is null ? = ");
            if (b42Var != null) {
                z2 = false;
            }
            sb2.append(z2);
            h82.c("SwanAppCameraManager", sb2.toString());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b42 b42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, b42Var) == null) {
            h82.i("SwanAppCameraManager", "handleAuthorized start");
            j63.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new b(this, context, b42Var, unitedSchemeEntity, callbackHandler));
        }
    }
}
