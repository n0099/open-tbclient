package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.tieba.q83;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class yv1 extends vv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements ei3<o83<q83.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ l33 d;
        public final /* synthetic */ gw1 e;
        public final /* synthetic */ CameraPreview f;
        public final /* synthetic */ String g;
        public final /* synthetic */ yv1 h;

        public a(yv1 yv1Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, l33 l33Var, gw1 gw1Var, CameraPreview cameraPreview, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv1Var, callbackHandler, unitedSchemeEntity, context, l33Var, gw1Var, cameraPreview, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = yv1Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = context;
            this.d = l33Var;
            this.e = gw1Var;
            this.f = cameraPreview;
            this.g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(o83<q83.e> o83Var) {
            int b;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o83Var) == null) {
                if (j83.h(o83Var)) {
                    this.h.r(this.c, this.b, this.a, this.d, this.e, this.f, this.g);
                } else if (o83Var != null && o83Var.a() != null) {
                    String str = "authorize recorder failed : " + j83.f(b);
                    UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(o83Var.b(), str));
                    l02.o("SwanAppAction", str);
                } else {
                    l02.c("SwanAppAction", "authorize recorder failed : result is invalid");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ei3<o83<q83.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ l33 d;
        public final /* synthetic */ gw1 e;
        public final /* synthetic */ CameraPreview f;
        public final /* synthetic */ String g;
        public final /* synthetic */ yv1 h;

        public b(yv1 yv1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context, l33 l33Var, gw1 gw1Var, CameraPreview cameraPreview, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv1Var, unitedSchemeEntity, callbackHandler, context, l33Var, gw1Var, cameraPreview, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = yv1Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = context;
            this.d = l33Var;
            this.e = gw1Var;
            this.f = cameraPreview;
            this.g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(o83<q83.e> o83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o83Var) == null) {
                if (j83.h(o83Var)) {
                    this.h.t(this.c, this.a, this.b, this.d, this.e, this.f, this.g);
                } else if (o83Var != null && o83Var.a() != null) {
                    this.h.s(o83Var.b(), this.a, this.b);
                } else {
                    l02.c("SwanAppAction", "authorize camera failed : result is invalid");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements oy2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ l33 c;
        public final /* synthetic */ CameraPreview d;
        public final /* synthetic */ gw1 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ yv1 g;

        public c(yv1 yv1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l33 l33Var, CameraPreview cameraPreview, gw1 gw1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv1Var, unitedSchemeEntity, callbackHandler, l33Var, cameraPreview, gw1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = yv1Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = l33Var;
            this.d = cameraPreview;
            this.e = gw1Var;
            this.f = str;
        }

        @Override // com.baidu.tieba.oy2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.g.w(this.a, this.b, this.c, this.d, this.e, this.f);
            }
        }

        @Override // com.baidu.tieba.oy2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.g.s(10005, this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements dw1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CameraPreview a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ HashMap d;
        public final /* synthetic */ yv1 e;

        public d(yv1 yv1Var, CameraPreview cameraPreview, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv1Var, cameraPreview, unitedSchemeEntity, callbackHandler, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = yv1Var;
            this.a = cameraPreview;
            this.b = unitedSchemeEntity;
            this.c = callbackHandler;
            this.d = hashMap;
        }

        @Override // com.baidu.tieba.dw1
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.n();
                this.a.e();
                this.e.u(this.b, this.c, this.d);
                l02.c("SwanAppCameraManager", "start record timeout");
            }
        }

        @Override // com.baidu.tieba.dw1
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.n();
                this.a.e();
                this.e.u(this.b, this.c, this.d);
                l02.c("SwanAppCameraManager", "start record cancel");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yv1(i43 i43Var) {
        super(i43Var, "/swanAPI/camera/startRecord");
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
            gw1 gw1Var = (gw1) v(unitedSchemeEntity);
            if (gw1Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                l02.c("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            kz1 kz1Var = (kz1) yz1.a(gw1Var);
            if (kz1Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                l02.c("SwanAppCameraManager", "get camera component is null");
                return false;
            }
            CameraPreview q = kz1Var.q();
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                l02.c("SwanAppCameraManager", "get camera view is null");
                return false;
            }
            String x = ta3.x(l33Var.b);
            if (TextUtils.isEmpty(x)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                l02.c("SwanAppCameraManager", "get camera start record cache path is empty");
                return false;
            }
            l33Var.e0().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(this, callbackHandler, unitedSchemeEntity, context, l33Var, gw1Var, q, x));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l33 l33Var, gw1 gw1Var, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, l33Var, gw1Var, cameraPreview, str}) == null) {
            l33Var.e0().g(context, PermissionProxy.SCOPE_ID_CAMERA, new b(this, unitedSchemeEntity, callbackHandler, context, l33Var, gw1Var, cameraPreview, str));
        }
    }

    public final void s(int i, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, unitedSchemeEntity, callbackHandler) == null) {
            String str = "authorize camera failed : " + j83.f(i);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i, str));
            l02.o("SwanAppAction", str);
        }
    }

    public final void t(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l33 l33Var, gw1 gw1Var, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, unitedSchemeEntity, callbackHandler, l33Var, gw1Var, cameraPreview, str}) == null) {
            l02.i("SwanAppCameraManager", "handleAuthorized start");
            if (uv1.b().c(context) && uv1.b().d(context)) {
                l02.c("SwanAppCameraManager", "has authorize");
                w(unitedSchemeEntity, callbackHandler, l33Var, cameraPreview, gw1Var, str);
                return;
            }
            ny2.g(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new c(this, unitedSchemeEntity, callbackHandler, l33Var, cameraPreview, gw1Var, str));
        }
    }

    public final void u(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap<String, String> hashMap) {
        HashMap<String, String> params;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, unitedSchemeEntity, callbackHandler, hashMap) == null) || unitedSchemeEntity == null || callbackHandler == null || hashMap == null || (params = unitedSchemeEntity.getParams()) == null || params.isEmpty()) {
            return;
        }
        String str = params.get("params");
        String str2 = null;
        if (str != null) {
            try {
                str2 = new JSONObject(str).optString("timeoutCallback");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        j(unitedSchemeEntity, callbackHandler, hashMap, str2);
    }

    public bz1 v(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, unitedSchemeEntity)) == null) ? new gw1(l(unitedSchemeEntity)) : (bz1) invokeL.objValue;
    }

    public final void w(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l33 l33Var, CameraPreview cameraPreview, gw1 gw1Var, String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{unitedSchemeEntity, callbackHandler, l33Var, cameraPreview, gw1Var, str}) == null) {
            l02.i("SwanAppCameraManager", "start record start");
            HashMap hashMap = new HashMap();
            try {
                z = cameraPreview.m(str);
                try {
                    hashMap.put("tempVideoPath", ta3.J(cameraPreview.getVideoPath(), l33Var.b));
                    hashMap.put("tempThumbPath", ta3.J(cameraPreview.getThumbPath(), l33Var.b));
                    uv1.b().i(31000, new d(this, cameraPreview, unitedSchemeEntity, callbackHandler, hashMap));
                } catch (Exception e) {
                    e = e;
                    uv1.b().e(gw1Var.c, gw1Var.b, false);
                    if (i53.b) {
                        e.printStackTrace();
                    }
                    l02.c("SwanAppCameraManager", "start recording api occur exception");
                    k(unitedSchemeEntity, callbackHandler, z);
                }
            } catch (Exception e2) {
                e = e2;
                z = false;
            }
            k(unitedSchemeEntity, callbackHandler, z);
        }
    }
}
