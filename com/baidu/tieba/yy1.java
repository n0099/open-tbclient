package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.tieba.pb3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class yy1 extends vy1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public class a implements dl3<nb3<pb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ k63 d;
        public final /* synthetic */ gz1 e;
        public final /* synthetic */ CameraPreview f;
        public final /* synthetic */ String g;
        public final /* synthetic */ yy1 h;

        public a(yy1 yy1Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, k63 k63Var, gz1 gz1Var, CameraPreview cameraPreview, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy1Var, callbackHandler, unitedSchemeEntity, context, k63Var, gz1Var, cameraPreview, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = yy1Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = context;
            this.d = k63Var;
            this.e = gz1Var;
            this.f = cameraPreview;
            this.g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<pb3.e> nb3Var) {
            int b;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                if (ib3.h(nb3Var)) {
                    this.h.r(this.c, this.b, this.a, this.d, this.e, this.f, this.g);
                } else if (nb3Var != null && nb3Var.a() != null) {
                    String str = "authorize recorder failed : " + ib3.f(b);
                    UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(nb3Var.b(), str));
                    k32.o("SwanAppAction", str);
                } else {
                    k32.c("SwanAppAction", "authorize recorder failed : result is invalid");
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements dl3<nb3<pb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ k63 d;
        public final /* synthetic */ gz1 e;
        public final /* synthetic */ CameraPreview f;
        public final /* synthetic */ String g;
        public final /* synthetic */ yy1 h;

        public b(yy1 yy1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context, k63 k63Var, gz1 gz1Var, CameraPreview cameraPreview, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy1Var, unitedSchemeEntity, callbackHandler, context, k63Var, gz1Var, cameraPreview, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = yy1Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = context;
            this.d = k63Var;
            this.e = gz1Var;
            this.f = cameraPreview;
            this.g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<pb3.e> nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                if (ib3.h(nb3Var)) {
                    this.h.t(this.c, this.a, this.b, this.d, this.e, this.f, this.g);
                } else if (nb3Var != null && nb3Var.a() != null) {
                    this.h.s(nb3Var.b(), this.a, this.b);
                } else {
                    k32.c("SwanAppAction", "authorize camera failed : result is invalid");
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements n13 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ k63 c;
        public final /* synthetic */ CameraPreview d;
        public final /* synthetic */ gz1 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ yy1 g;

        public c(yy1 yy1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var, CameraPreview cameraPreview, gz1 gz1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy1Var, unitedSchemeEntity, callbackHandler, k63Var, cameraPreview, gz1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = yy1Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = k63Var;
            this.d = cameraPreview;
            this.e = gz1Var;
            this.f = str;
        }

        @Override // com.baidu.tieba.n13
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.g.w(this.a, this.b, this.c, this.d, this.e, this.f);
        }

        @Override // com.baidu.tieba.n13
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.g.s(10005, this.a, this.b);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements dz1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CameraPreview a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ HashMap d;
        public final /* synthetic */ yy1 e;

        public d(yy1 yy1Var, CameraPreview cameraPreview, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy1Var, cameraPreview, unitedSchemeEntity, callbackHandler, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = yy1Var;
            this.a = cameraPreview;
            this.b = unitedSchemeEntity;
            this.c = callbackHandler;
            this.d = hashMap;
        }

        @Override // com.baidu.tieba.dz1
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.v();
                this.a.m();
                this.e.u(this.b, this.c, this.d);
                k32.c("SwanAppCameraManager", "start record timeout");
            }
        }

        @Override // com.baidu.tieba.dz1
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.v();
                this.a.m();
                this.e.u(this.b, this.c, this.d);
                k32.c("SwanAppCameraManager", "start record cancel");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yy1(h73 h73Var) {
        super(h73Var, "/swanAPI/camera/startRecord");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h73Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((h73) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.h83
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, k63Var)) == null) {
            gz1 gz1Var = (gz1) v(unitedSchemeEntity);
            if (gz1Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                k32.c("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            j22 j22Var = (j22) x22.a(gz1Var);
            if (j22Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                k32.c("SwanAppCameraManager", "get camera component is null");
                return false;
            }
            CameraPreview q = j22Var.q();
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                k32.c("SwanAppCameraManager", "get camera view is null");
                return false;
            }
            String x = sd3.x(k63Var.b);
            if (TextUtils.isEmpty(x)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                k32.c("SwanAppCameraManager", "get camera start record cache path is empty");
                return false;
            }
            k63Var.f0().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(this, callbackHandler, unitedSchemeEntity, context, k63Var, gz1Var, q, x));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var, gz1 gz1Var, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, k63Var, gz1Var, cameraPreview, str}) == null) {
            k63Var.f0().g(context, PermissionProxy.SCOPE_ID_CAMERA, new b(this, unitedSchemeEntity, callbackHandler, context, k63Var, gz1Var, cameraPreview, str));
        }
    }

    public final void s(int i, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, unitedSchemeEntity, callbackHandler) == null) {
            String str = "authorize camera failed : " + ib3.f(i);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i, str));
            k32.o("SwanAppAction", str);
        }
    }

    public final void t(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var, gz1 gz1Var, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, unitedSchemeEntity, callbackHandler, k63Var, gz1Var, cameraPreview, str}) == null) {
            k32.i("SwanAppCameraManager", "handleAuthorized start");
            if (uy1.b().c(context) && uy1.b().d(context)) {
                k32.c("SwanAppCameraManager", "has authorize");
                w(unitedSchemeEntity, callbackHandler, k63Var, cameraPreview, gz1Var, str);
                return;
            }
            m13.f(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new c(this, unitedSchemeEntity, callbackHandler, k63Var, cameraPreview, gz1Var, str));
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

    public b22 v(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, unitedSchemeEntity)) == null) {
            return new gz1(l(unitedSchemeEntity));
        }
        return (b22) invokeL.objValue;
    }

    public final void w(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var, CameraPreview cameraPreview, gz1 gz1Var, String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{unitedSchemeEntity, callbackHandler, k63Var, cameraPreview, gz1Var, str}) == null) {
            k32.i("SwanAppCameraManager", "start record start");
            HashMap hashMap = new HashMap();
            try {
                z = cameraPreview.u(str);
                try {
                    hashMap.put("tempVideoPath", sd3.J(cameraPreview.getVideoPath(), k63Var.b));
                    hashMap.put("tempThumbPath", sd3.J(cameraPreview.getThumbPath(), k63Var.b));
                    uy1.b().i(31000, new d(this, cameraPreview, unitedSchemeEntity, callbackHandler, hashMap));
                } catch (Exception e) {
                    e = e;
                    uy1.b().e(gz1Var.c, gz1Var.b, false);
                    if (h83.b) {
                        e.printStackTrace();
                    }
                    k32.c("SwanAppCameraManager", "start recording api occur exception");
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
