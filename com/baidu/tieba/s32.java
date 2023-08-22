package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.tieba.ig3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class s32 extends n32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements wp3<gg3<ig3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ db3 d;
        public final /* synthetic */ z32 e;
        public final /* synthetic */ CameraPreview f;
        public final /* synthetic */ String g;
        public final /* synthetic */ s32 h;

        public a(s32 s32Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, db3 db3Var, z32 z32Var, CameraPreview cameraPreview, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s32Var, callbackHandler, unitedSchemeEntity, context, db3Var, z32Var, cameraPreview, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = s32Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = context;
            this.d = db3Var;
            this.e = z32Var;
            this.f = cameraPreview;
            this.g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<ig3.e> gg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                if (bg3.h(gg3Var)) {
                    this.h.p(this.c, this.b, this.a, this.d, this.e, this.f, this.g);
                    return;
                }
                bg3.p(gg3Var, this.a, this.b);
                d82.c("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements g63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ db3 c;
        public final /* synthetic */ CameraPreview d;
        public final /* synthetic */ z32 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ s32 g;

        public b(s32 s32Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var, CameraPreview cameraPreview, z32 z32Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s32Var, unitedSchemeEntity, callbackHandler, db3Var, cameraPreview, z32Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = s32Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = db3Var;
            this.d = cameraPreview;
            this.e = z32Var;
            this.f = str;
        }

        @Override // com.baidu.tieba.g63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.g.r(this.a, this.b, this.c, this.d, this.e, this.f);
            d82.c("SwanAppCameraManager", str + "");
        }

        @Override // com.baidu.tieba.g63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.callCallback(this.b, this.a, 10005);
                d82.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements u32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ db3 b;
        public final /* synthetic */ z32 c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ UnitedSchemeEntity e;
        public final /* synthetic */ s32 f;

        public c(s32 s32Var, String str, db3 db3Var, z32 z32Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s32Var, str, db3Var, z32Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = s32Var;
            this.a = str;
            this.b = db3Var;
            this.c = z32Var;
            this.d = callbackHandler;
            this.e = unitedSchemeEntity;
        }

        @Override // com.baidu.tieba.u32
        public void onFailure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f.k(this.e, this.d, false);
                d82.c("SwanAppCameraManager", "take picture onFailure");
            }
        }

        @Override // com.baidu.tieba.u32
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempImagePath", li3.J(this.a, this.b.b));
                } catch (JSONException e) {
                    d82.c("SwanAppCameraManager", "take picture onSuccess but json object occur exception");
                    m32 b = m32.b();
                    z32 z32Var = this.c;
                    b.e(z32Var.c, z32Var.b, false);
                    if (ad3.b) {
                        e.printStackTrace();
                    }
                }
                UnitedSchemeUtility.callCallback(this.d, this.e, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s32(ac3 ac3Var) {
        super(ac3Var, "/swanAPI/camera/takePhoto");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ac3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ac3) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.ad3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, db3Var)) == null) {
            z32 z32Var = (z32) q(unitedSchemeEntity);
            if (z32Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d82.c("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            c72 c72Var = (c72) q72.a(z32Var);
            if (c72Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d82.c("SwanAppCameraManager", "get camera component is null");
                return false;
            }
            CameraPreview q = c72Var.q();
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d82.c("SwanAppCameraManager", "get camera view is null");
                return false;
            }
            String x = li3.x(db3Var.b);
            if (TextUtils.isEmpty(x)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d82.c("SwanAppCameraManager", "get camera take photo cache path is empty");
                return false;
            }
            db3Var.e0().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, db3Var, z32Var, q, x));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var, z32 z32Var, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, db3Var, z32Var, cameraPreview, str}) == null) {
            d82.i("SwanAppCameraManager", "handleAuthorized start");
            f63.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new b(this, unitedSchemeEntity, callbackHandler, db3Var, cameraPreview, z32Var, str));
        }
    }

    public t62 q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity)) == null) {
            return new z32(l(unitedSchemeEntity));
        }
        return (t62) invokeL.objValue;
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var, CameraPreview cameraPreview, z32 z32Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{unitedSchemeEntity, callbackHandler, db3Var, cameraPreview, z32Var, str}) == null) {
            d82.i("SwanAppCameraManager", "take photo start");
            cameraPreview.setQuality(z32Var.j);
            String o = cameraPreview.o(str);
            try {
                cameraPreview.w(o, new c(this, o, db3Var, z32Var, callbackHandler, unitedSchemeEntity));
            } catch (Exception e) {
                d82.c("SwanAppCameraManager", "take picture api occur exception");
                m32.b().e(z32Var.c, z32Var.b, false);
                if (ad3.b) {
                    e.printStackTrace();
                }
            }
            d82.i("SwanAppCameraManager", "take photo end");
        }
    }
}
