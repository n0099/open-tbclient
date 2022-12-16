package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.tieba.j93;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class sw1 extends ow1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements xi3<h93<j93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ e43 d;
        public final /* synthetic */ zw1 e;
        public final /* synthetic */ CameraPreview f;
        public final /* synthetic */ sw1 g;

        public a(sw1 sw1Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, e43 e43Var, zw1 zw1Var, CameraPreview cameraPreview) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sw1Var, callbackHandler, unitedSchemeEntity, context, e43Var, zw1Var, cameraPreview};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = sw1Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = context;
            this.d = e43Var;
            this.e = zw1Var;
            this.f = cameraPreview;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(h93<j93.e> h93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h93Var) == null) {
                if (c93.h(h93Var)) {
                    this.g.o(this.c, this.b, this.a, this.d, this.e, this.f);
                    return;
                }
                c93.p(h93Var, this.a, this.b);
                e12.c("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements hz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ e43 c;
        public final /* synthetic */ CameraPreview d;
        public final /* synthetic */ zw1 e;
        public final /* synthetic */ sw1 f;

        public b(sw1 sw1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e43 e43Var, CameraPreview cameraPreview, zw1 zw1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sw1Var, unitedSchemeEntity, callbackHandler, e43Var, cameraPreview, zw1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = sw1Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = e43Var;
            this.d = cameraPreview;
            this.e = zw1Var;
        }

        @Override // com.baidu.tieba.hz2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.f.r(this.a, this.b, this.c, this.d, this.e);
        }

        @Override // com.baidu.tieba.hz2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.callCallback(this.b, this.a, 10005);
                e12.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sw1(b53 b53Var) {
        super(b53Var, "/swanAPI/camera/stopRecord");
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

    public final boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!(!TextUtils.isEmpty(str))) {
                return false;
            }
            File file = new File(str);
            if (file.exists() && file.length() > 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.b63
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e43 e43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, e43Var)) == null) {
            zw1 zw1Var = (zw1) q(unitedSchemeEntity);
            if (zw1Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                e12.c("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            d02 d02Var = (d02) r02.a(zw1Var);
            if (d02Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                e12.c("SwanAppCameraManager", "get camera component is null");
                return false;
            }
            CameraPreview q = d02Var.q();
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                e12.c("SwanAppCameraManager", "get camera view is null");
                return false;
            } else if (TextUtils.isEmpty(mb3.x(e43Var.b))) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                e12.c("SwanAppCameraManager", "get camera stop record cache path is empty");
                return false;
            } else {
                e43Var.e0().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(this, callbackHandler, unitedSchemeEntity, context, e43Var, zw1Var, q));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e43 e43Var, zw1 zw1Var, CameraPreview cameraPreview) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, e43Var, zw1Var, cameraPreview}) == null) {
            e12.i("SwanAppCameraManager", "handleAuthorized start");
            if (nw1.b().c(context) && nw1.b().d(context)) {
                e12.c("SwanAppCameraManager", "has authorize");
                r(unitedSchemeEntity, callbackHandler, e43Var, cameraPreview, zw1Var);
                return;
            }
            gz2.g(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new b(this, unitedSchemeEntity, callbackHandler, e43Var, cameraPreview, zw1Var));
        }
    }

    public uz1 q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unitedSchemeEntity)) == null) {
            return new zw1(l(unitedSchemeEntity));
        }
        return (uz1) invokeL.objValue;
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e43 e43Var, CameraPreview cameraPreview, zw1 zw1Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, unitedSchemeEntity, callbackHandler, e43Var, cameraPreview, zw1Var) == null) {
            e12.i("SwanAppCameraManager", "stop record start");
            try {
                z = cameraPreview.v();
            } catch (Exception e) {
                e = e;
                z = false;
            }
            try {
                nw1.b().j();
            } catch (Exception e2) {
                e = e2;
                cameraPreview.m();
                nw1.b().e(zw1Var.c, zw1Var.b, false);
                if (b63.b) {
                    e.printStackTrace();
                }
                e12.c("SwanAppCameraManager", "stop recording api occur exception");
                String videoPath = cameraPreview.getVideoPath();
                String thumbPath = cameraPreview.getThumbPath();
                if (!z) {
                }
                k(unitedSchemeEntity, callbackHandler, false);
                cameraPreview.m();
                e12.i("SwanAppCameraManager", "stop record end");
            }
            String videoPath2 = cameraPreview.getVideoPath();
            String thumbPath2 = cameraPreview.getThumbPath();
            if (!z && p(videoPath2) && !TextUtils.isEmpty(thumbPath2)) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("tempVideoPath", mb3.J(videoPath2, e43Var.b));
                hashMap.put("tempThumbPath", mb3.J(thumbPath2, e43Var.b));
                j(unitedSchemeEntity, callbackHandler, hashMap, "");
            } else {
                k(unitedSchemeEntity, callbackHandler, false);
            }
            cameraPreview.m();
            e12.i("SwanAppCameraManager", "stop record end");
        }
    }
}
