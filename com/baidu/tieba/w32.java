package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.tieba.mg3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class w32 extends r32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements aq3<kg3<mg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ hb3 d;
        public final /* synthetic */ d42 e;
        public final /* synthetic */ CameraPreview f;
        public final /* synthetic */ String g;
        public final /* synthetic */ w32 h;

        public a(w32 w32Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, hb3 hb3Var, d42 d42Var, CameraPreview cameraPreview, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w32Var, callbackHandler, unitedSchemeEntity, context, hb3Var, d42Var, cameraPreview, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = w32Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = context;
            this.d = hb3Var;
            this.e = d42Var;
            this.f = cameraPreview;
            this.g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<mg3.e> kg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                if (fg3.h(kg3Var)) {
                    this.h.p(this.c, this.b, this.a, this.d, this.e, this.f, this.g);
                    return;
                }
                fg3.p(kg3Var, this.a, this.b);
                h82.c("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements k63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ hb3 c;
        public final /* synthetic */ CameraPreview d;
        public final /* synthetic */ d42 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ w32 g;

        public b(w32 w32Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var, CameraPreview cameraPreview, d42 d42Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w32Var, unitedSchemeEntity, callbackHandler, hb3Var, cameraPreview, d42Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = w32Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = hb3Var;
            this.d = cameraPreview;
            this.e = d42Var;
            this.f = str;
        }

        @Override // com.baidu.tieba.k63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.g.r(this.a, this.b, this.c, this.d, this.e, this.f);
            h82.c("SwanAppCameraManager", str + "");
        }

        @Override // com.baidu.tieba.k63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.callCallback(this.b, this.a, 10005);
                h82.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements y32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ hb3 b;
        public final /* synthetic */ d42 c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ UnitedSchemeEntity e;
        public final /* synthetic */ w32 f;

        public c(w32 w32Var, String str, hb3 hb3Var, d42 d42Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w32Var, str, hb3Var, d42Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = w32Var;
            this.a = str;
            this.b = hb3Var;
            this.c = d42Var;
            this.d = callbackHandler;
            this.e = unitedSchemeEntity;
        }

        @Override // com.baidu.tieba.y32
        public void onFailure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f.k(this.e, this.d, false);
                h82.c("SwanAppCameraManager", "take picture onFailure");
            }
        }

        @Override // com.baidu.tieba.y32
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempImagePath", pi3.J(this.a, this.b.b));
                } catch (JSONException e) {
                    h82.c("SwanAppCameraManager", "take picture onSuccess but json object occur exception");
                    q32 b = q32.b();
                    d42 d42Var = this.c;
                    b.e(d42Var.c, d42Var.b, false);
                    if (ed3.b) {
                        e.printStackTrace();
                    }
                }
                UnitedSchemeUtility.callCallback(this.d, this.e, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w32(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/camera/takePhoto");
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
            d42 d42Var = (d42) q(unitedSchemeEntity);
            if (d42Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                h82.c("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            g72 g72Var = (g72) u72.a(d42Var);
            if (g72Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                h82.c("SwanAppCameraManager", "get camera component is null");
                return false;
            }
            CameraPreview q = g72Var.q();
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                h82.c("SwanAppCameraManager", "get camera view is null");
                return false;
            }
            String x = pi3.x(hb3Var.b);
            if (TextUtils.isEmpty(x)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                h82.c("SwanAppCameraManager", "get camera take photo cache path is empty");
                return false;
            }
            hb3Var.e0().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, hb3Var, d42Var, q, x));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var, d42 d42Var, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, hb3Var, d42Var, cameraPreview, str}) == null) {
            h82.i("SwanAppCameraManager", "handleAuthorized start");
            j63.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new b(this, unitedSchemeEntity, callbackHandler, hb3Var, cameraPreview, d42Var, str));
        }
    }

    public x62 q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity)) == null) {
            return new d42(l(unitedSchemeEntity));
        }
        return (x62) invokeL.objValue;
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var, CameraPreview cameraPreview, d42 d42Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{unitedSchemeEntity, callbackHandler, hb3Var, cameraPreview, d42Var, str}) == null) {
            h82.i("SwanAppCameraManager", "take photo start");
            cameraPreview.setQuality(d42Var.j);
            String o = cameraPreview.o(str);
            try {
                cameraPreview.w(o, new c(this, o, hb3Var, d42Var, callbackHandler, unitedSchemeEntity));
            } catch (Exception e) {
                h82.c("SwanAppCameraManager", "take picture api occur exception");
                q32.b().e(d42Var.c, d42Var.b, false);
                if (ed3.b) {
                    e.printStackTrace();
                }
            }
            h82.i("SwanAppCameraManager", "take photo end");
        }
    }
}
