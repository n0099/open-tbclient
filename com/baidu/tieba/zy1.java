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
import java.io.File;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class zy1 extends vy1 {
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
        public final /* synthetic */ zy1 g;

        public a(zy1 zy1Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, k63 k63Var, gz1 gz1Var, CameraPreview cameraPreview) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy1Var, callbackHandler, unitedSchemeEntity, context, k63Var, gz1Var, cameraPreview};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = zy1Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = context;
            this.d = k63Var;
            this.e = gz1Var;
            this.f = cameraPreview;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<pb3.e> nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                if (ib3.h(nb3Var)) {
                    this.g.o(this.c, this.b, this.a, this.d, this.e, this.f);
                    return;
                }
                ib3.p(nb3Var, this.a, this.b);
                k32.c("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements n13 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ k63 c;
        public final /* synthetic */ CameraPreview d;
        public final /* synthetic */ gz1 e;
        public final /* synthetic */ zy1 f;

        public b(zy1 zy1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var, CameraPreview cameraPreview, gz1 gz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy1Var, unitedSchemeEntity, callbackHandler, k63Var, cameraPreview, gz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = zy1Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = k63Var;
            this.d = cameraPreview;
            this.e = gz1Var;
        }

        @Override // com.baidu.tieba.n13
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.f.r(this.a, this.b, this.c, this.d, this.e);
        }

        @Override // com.baidu.tieba.n13
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.callCallback(this.b, this.a, 10005);
                k32.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zy1(h73 h73Var) {
        super(h73Var, "/swanAPI/camera/stopRecord");
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

    @Override // com.baidu.tieba.h83
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, k63Var)) == null) {
            gz1 gz1Var = (gz1) q(unitedSchemeEntity);
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
            } else if (TextUtils.isEmpty(sd3.x(k63Var.b))) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                k32.c("SwanAppCameraManager", "get camera stop record cache path is empty");
                return false;
            } else {
                k63Var.f0().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(this, callbackHandler, unitedSchemeEntity, context, k63Var, gz1Var, q));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var, gz1 gz1Var, CameraPreview cameraPreview) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, k63Var, gz1Var, cameraPreview}) == null) {
            k32.i("SwanAppCameraManager", "handleAuthorized start");
            if (uy1.b().c(context) && uy1.b().d(context)) {
                k32.c("SwanAppCameraManager", "has authorize");
                r(unitedSchemeEntity, callbackHandler, k63Var, cameraPreview, gz1Var);
                return;
            }
            m13.f(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new b(this, unitedSchemeEntity, callbackHandler, k63Var, cameraPreview, gz1Var));
        }
    }

    public b22 q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unitedSchemeEntity)) == null) {
            return new gz1(l(unitedSchemeEntity));
        }
        return (b22) invokeL.objValue;
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var, CameraPreview cameraPreview, gz1 gz1Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, unitedSchemeEntity, callbackHandler, k63Var, cameraPreview, gz1Var) == null) {
            k32.i("SwanAppCameraManager", "stop record start");
            try {
                z = cameraPreview.v();
            } catch (Exception e) {
                e = e;
                z = false;
            }
            try {
                uy1.b().j();
            } catch (Exception e2) {
                e = e2;
                cameraPreview.m();
                uy1.b().e(gz1Var.c, gz1Var.b, false);
                if (h83.b) {
                    e.printStackTrace();
                }
                k32.c("SwanAppCameraManager", "stop recording api occur exception");
                String videoPath = cameraPreview.getVideoPath();
                String thumbPath = cameraPreview.getThumbPath();
                if (!z) {
                }
                k(unitedSchemeEntity, callbackHandler, false);
                cameraPreview.m();
                k32.i("SwanAppCameraManager", "stop record end");
            }
            String videoPath2 = cameraPreview.getVideoPath();
            String thumbPath2 = cameraPreview.getThumbPath();
            if (!z && p(videoPath2) && !TextUtils.isEmpty(thumbPath2)) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("tempVideoPath", sd3.J(videoPath2, k63Var.b));
                hashMap.put("tempThumbPath", sd3.J(thumbPath2, k63Var.b));
                j(unitedSchemeEntity, callbackHandler, hashMap, "");
            } else {
                k(unitedSchemeEntity, callbackHandler, false);
            }
            cameraPreview.m();
            k32.i("SwanAppCameraManager", "stop record end");
        }
    }
}
