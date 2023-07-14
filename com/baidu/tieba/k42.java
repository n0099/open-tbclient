package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.tieba.ah3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k42 extends f42 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements oq3<yg3<ah3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ vb3 d;
        public final /* synthetic */ r42 e;
        public final /* synthetic */ CameraPreview f;
        public final /* synthetic */ String g;
        public final /* synthetic */ k42 h;

        public a(k42 k42Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, vb3 vb3Var, r42 r42Var, CameraPreview cameraPreview, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k42Var, callbackHandler, unitedSchemeEntity, context, vb3Var, r42Var, cameraPreview, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = k42Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = context;
            this.d = vb3Var;
            this.e = r42Var;
            this.f = cameraPreview;
            this.g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(yg3<ah3.e> yg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yg3Var) == null) {
                if (tg3.h(yg3Var)) {
                    this.h.p(this.c, this.b, this.a, this.d, this.e, this.f, this.g);
                    return;
                }
                tg3.p(yg3Var, this.a, this.b);
                v82.c("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements y63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ vb3 c;
        public final /* synthetic */ CameraPreview d;
        public final /* synthetic */ r42 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ k42 g;

        public b(k42 k42Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var, CameraPreview cameraPreview, r42 r42Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k42Var, unitedSchemeEntity, callbackHandler, vb3Var, cameraPreview, r42Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = k42Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = vb3Var;
            this.d = cameraPreview;
            this.e = r42Var;
            this.f = str;
        }

        @Override // com.baidu.tieba.y63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.g.r(this.a, this.b, this.c, this.d, this.e, this.f);
            v82.c("SwanAppCameraManager", str + "");
        }

        @Override // com.baidu.tieba.y63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.callCallback(this.b, this.a, 10005);
                v82.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements m42 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ vb3 b;
        public final /* synthetic */ r42 c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ UnitedSchemeEntity e;
        public final /* synthetic */ k42 f;

        public c(k42 k42Var, String str, vb3 vb3Var, r42 r42Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k42Var, str, vb3Var, r42Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = k42Var;
            this.a = str;
            this.b = vb3Var;
            this.c = r42Var;
            this.d = callbackHandler;
            this.e = unitedSchemeEntity;
        }

        @Override // com.baidu.tieba.m42
        public void onFailure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f.k(this.e, this.d, false);
                v82.c("SwanAppCameraManager", "take picture onFailure");
            }
        }

        @Override // com.baidu.tieba.m42
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempImagePath", dj3.J(this.a, this.b.b));
                } catch (JSONException e) {
                    v82.c("SwanAppCameraManager", "take picture onSuccess but json object occur exception");
                    e42 b = e42.b();
                    r42 r42Var = this.c;
                    b.e(r42Var.c, r42Var.b, false);
                    if (sd3.b) {
                        e.printStackTrace();
                    }
                }
                UnitedSchemeUtility.callCallback(this.d, this.e, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k42(sc3 sc3Var) {
        super(sc3Var, "/swanAPI/camera/takePhoto");
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
                super((sc3) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.sd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, vb3Var)) == null) {
            r42 r42Var = (r42) q(unitedSchemeEntity);
            if (r42Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                v82.c("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            u72 u72Var = (u72) i82.a(r42Var);
            if (u72Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                v82.c("SwanAppCameraManager", "get camera component is null");
                return false;
            }
            CameraPreview q = u72Var.q();
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                v82.c("SwanAppCameraManager", "get camera view is null");
                return false;
            }
            String x = dj3.x(vb3Var.b);
            if (TextUtils.isEmpty(x)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                v82.c("SwanAppCameraManager", "get camera take photo cache path is empty");
                return false;
            }
            vb3Var.e0().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, vb3Var, r42Var, q, x));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var, r42 r42Var, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, vb3Var, r42Var, cameraPreview, str}) == null) {
            v82.i("SwanAppCameraManager", "handleAuthorized start");
            x63.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new b(this, unitedSchemeEntity, callbackHandler, vb3Var, cameraPreview, r42Var, str));
        }
    }

    public l72 q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity)) == null) {
            return new r42(l(unitedSchemeEntity));
        }
        return (l72) invokeL.objValue;
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var, CameraPreview cameraPreview, r42 r42Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{unitedSchemeEntity, callbackHandler, vb3Var, cameraPreview, r42Var, str}) == null) {
            v82.i("SwanAppCameraManager", "take photo start");
            cameraPreview.setQuality(r42Var.j);
            String o = cameraPreview.o(str);
            try {
                cameraPreview.w(o, new c(this, o, vb3Var, r42Var, callbackHandler, unitedSchemeEntity));
            } catch (Exception e) {
                v82.c("SwanAppCameraManager", "take picture api occur exception");
                e42.b().e(r42Var.c, r42Var.b, false);
                if (sd3.b) {
                    e.printStackTrace();
                }
            }
            v82.i("SwanAppCameraManager", "take photo end");
        }
    }
}
