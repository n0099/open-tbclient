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
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class q32 extends n32 {
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
        public final /* synthetic */ y32 e;
        public final /* synthetic */ CameraPreview f;
        public final /* synthetic */ String g;
        public final /* synthetic */ q32 h;

        public a(q32 q32Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, db3 db3Var, y32 y32Var, CameraPreview cameraPreview, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q32Var, callbackHandler, unitedSchemeEntity, context, db3Var, y32Var, cameraPreview, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = q32Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = context;
            this.d = db3Var;
            this.e = y32Var;
            this.f = cameraPreview;
            this.g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<ig3.e> gg3Var) {
            int b;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                if (bg3.h(gg3Var)) {
                    this.h.r(this.c, this.b, this.a, this.d, this.e, this.f, this.g);
                } else if (gg3Var != null && gg3Var.a() != null) {
                    String str = "authorize recorder failed : " + bg3.f(b);
                    UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(gg3Var.b(), str));
                    d82.o("SwanAppAction", str);
                } else {
                    d82.c("SwanAppAction", "authorize recorder failed : result is invalid");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements wp3<gg3<ig3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ db3 d;
        public final /* synthetic */ y32 e;
        public final /* synthetic */ CameraPreview f;
        public final /* synthetic */ String g;
        public final /* synthetic */ q32 h;

        public b(q32 q32Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context, db3 db3Var, y32 y32Var, CameraPreview cameraPreview, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q32Var, unitedSchemeEntity, callbackHandler, context, db3Var, y32Var, cameraPreview, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = q32Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = context;
            this.d = db3Var;
            this.e = y32Var;
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
                    this.h.t(this.c, this.a, this.b, this.d, this.e, this.f, this.g);
                } else if (gg3Var != null && gg3Var.a() != null) {
                    this.h.s(gg3Var.b(), this.a, this.b);
                } else {
                    d82.c("SwanAppAction", "authorize camera failed : result is invalid");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements g63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ db3 c;
        public final /* synthetic */ CameraPreview d;
        public final /* synthetic */ y32 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ q32 g;

        public c(q32 q32Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var, CameraPreview cameraPreview, y32 y32Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q32Var, unitedSchemeEntity, callbackHandler, db3Var, cameraPreview, y32Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = q32Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = db3Var;
            this.d = cameraPreview;
            this.e = y32Var;
            this.f = str;
        }

        @Override // com.baidu.tieba.g63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.g.w(this.a, this.b, this.c, this.d, this.e, this.f);
        }

        @Override // com.baidu.tieba.g63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.g.s(10005, this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements v32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CameraPreview a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ HashMap d;
        public final /* synthetic */ q32 e;

        public d(q32 q32Var, CameraPreview cameraPreview, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q32Var, cameraPreview, unitedSchemeEntity, callbackHandler, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = q32Var;
            this.a = cameraPreview;
            this.b = unitedSchemeEntity;
            this.c = callbackHandler;
            this.d = hashMap;
        }

        @Override // com.baidu.tieba.v32
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.v();
                this.a.m();
                this.e.u(this.b, this.c, this.d);
                d82.c("SwanAppCameraManager", "start record timeout");
            }
        }

        @Override // com.baidu.tieba.v32
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.v();
                this.a.m();
                this.e.u(this.b, this.c, this.d);
                d82.c("SwanAppCameraManager", "start record cancel");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q32(ac3 ac3Var) {
        super(ac3Var, "/swanAPI/camera/startRecord");
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
            y32 y32Var = (y32) v(unitedSchemeEntity);
            if (y32Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d82.c("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            c72 c72Var = (c72) q72.a(y32Var);
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
                d82.c("SwanAppCameraManager", "get camera start record cache path is empty");
                return false;
            }
            db3Var.e0().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(this, callbackHandler, unitedSchemeEntity, context, db3Var, y32Var, q, x));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var, y32 y32Var, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, db3Var, y32Var, cameraPreview, str}) == null) {
            db3Var.e0().g(context, PermissionProxy.SCOPE_ID_CAMERA, new b(this, unitedSchemeEntity, callbackHandler, context, db3Var, y32Var, cameraPreview, str));
        }
    }

    public final void s(int i, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, unitedSchemeEntity, callbackHandler) == null) {
            String str = "authorize camera failed : " + bg3.f(i);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i, str));
            d82.o("SwanAppAction", str);
        }
    }

    public final void t(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var, y32 y32Var, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, unitedSchemeEntity, callbackHandler, db3Var, y32Var, cameraPreview, str}) == null) {
            d82.i("SwanAppCameraManager", "handleAuthorized start");
            if (m32.b().c(context) && m32.b().d(context)) {
                d82.c("SwanAppCameraManager", "has authorize");
                w(unitedSchemeEntity, callbackHandler, db3Var, cameraPreview, y32Var, str);
                return;
            }
            f63.g(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new c(this, unitedSchemeEntity, callbackHandler, db3Var, cameraPreview, y32Var, str));
        }
    }

    public final void u(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap<String, String> hashMap) {
        HashMap<String, String> params;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048580, this, unitedSchemeEntity, callbackHandler, hashMap) == null) && unitedSchemeEntity != null && callbackHandler != null && hashMap != null && (params = unitedSchemeEntity.getParams()) != null && !params.isEmpty()) {
            String str = params.get("params");
            String str2 = null;
            if (str != null) {
                try {
                    str2 = new JSONObject(str).optString("timeoutCallback");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                j(unitedSchemeEntity, callbackHandler, hashMap, str2);
            }
        }
    }

    public t62 v(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, unitedSchemeEntity)) == null) {
            return new y32(l(unitedSchemeEntity));
        }
        return (t62) invokeL.objValue;
    }

    public final void w(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var, CameraPreview cameraPreview, y32 y32Var, String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{unitedSchemeEntity, callbackHandler, db3Var, cameraPreview, y32Var, str}) == null) {
            d82.i("SwanAppCameraManager", "start record start");
            HashMap hashMap = new HashMap();
            try {
                z = cameraPreview.u(str);
                try {
                    hashMap.put("tempVideoPath", li3.J(cameraPreview.getVideoPath(), db3Var.b));
                    hashMap.put("tempThumbPath", li3.J(cameraPreview.getThumbPath(), db3Var.b));
                    m32.b().i(31000, new d(this, cameraPreview, unitedSchemeEntity, callbackHandler, hashMap));
                } catch (Exception e) {
                    e = e;
                    m32.b().e(y32Var.c, y32Var.b, false);
                    if (ad3.b) {
                        e.printStackTrace();
                    }
                    d82.c("SwanAppCameraManager", "start recording api occur exception");
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
