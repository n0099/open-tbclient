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
import java.io.File;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class j42 extends f42 {
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
        public final /* synthetic */ q42 e;
        public final /* synthetic */ CameraPreview f;
        public final /* synthetic */ j42 g;

        public a(j42 j42Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, vb3 vb3Var, q42 q42Var, CameraPreview cameraPreview) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j42Var, callbackHandler, unitedSchemeEntity, context, vb3Var, q42Var, cameraPreview};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = j42Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = context;
            this.d = vb3Var;
            this.e = q42Var;
            this.f = cameraPreview;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(yg3<ah3.e> yg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yg3Var) == null) {
                if (tg3.h(yg3Var)) {
                    this.g.o(this.c, this.b, this.a, this.d, this.e, this.f);
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
        public final /* synthetic */ q42 e;
        public final /* synthetic */ j42 f;

        public b(j42 j42Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var, CameraPreview cameraPreview, q42 q42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j42Var, unitedSchemeEntity, callbackHandler, vb3Var, cameraPreview, q42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = j42Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = vb3Var;
            this.d = cameraPreview;
            this.e = q42Var;
        }

        @Override // com.baidu.tieba.y63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.f.r(this.a, this.b, this.c, this.d, this.e);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j42(sc3 sc3Var) {
        super(sc3Var, "/swanAPI/camera/stopRecord");
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

    @Override // com.baidu.tieba.sd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, vb3Var)) == null) {
            q42 q42Var = (q42) q(unitedSchemeEntity);
            if (q42Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                v82.c("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            u72 u72Var = (u72) i82.a(q42Var);
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
            } else if (TextUtils.isEmpty(dj3.x(vb3Var.b))) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                v82.c("SwanAppCameraManager", "get camera stop record cache path is empty");
                return false;
            } else {
                vb3Var.e0().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(this, callbackHandler, unitedSchemeEntity, context, vb3Var, q42Var, q));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var, q42 q42Var, CameraPreview cameraPreview) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, vb3Var, q42Var, cameraPreview}) == null) {
            v82.i("SwanAppCameraManager", "handleAuthorized start");
            if (e42.b().c(context) && e42.b().d(context)) {
                v82.c("SwanAppCameraManager", "has authorize");
                r(unitedSchemeEntity, callbackHandler, vb3Var, cameraPreview, q42Var);
                return;
            }
            x63.g(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new b(this, unitedSchemeEntity, callbackHandler, vb3Var, cameraPreview, q42Var));
        }
    }

    public l72 q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unitedSchemeEntity)) == null) {
            return new q42(l(unitedSchemeEntity));
        }
        return (l72) invokeL.objValue;
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var, CameraPreview cameraPreview, q42 q42Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, unitedSchemeEntity, callbackHandler, vb3Var, cameraPreview, q42Var) == null) {
            v82.i("SwanAppCameraManager", "stop record start");
            try {
                z = cameraPreview.v();
            } catch (Exception e) {
                e = e;
                z = false;
            }
            try {
                e42.b().j();
            } catch (Exception e2) {
                e = e2;
                cameraPreview.m();
                e42.b().e(q42Var.c, q42Var.b, false);
                if (sd3.b) {
                    e.printStackTrace();
                }
                v82.c("SwanAppCameraManager", "stop recording api occur exception");
                String videoPath = cameraPreview.getVideoPath();
                String thumbPath = cameraPreview.getThumbPath();
                if (!z) {
                }
                k(unitedSchemeEntity, callbackHandler, false);
                cameraPreview.m();
                v82.i("SwanAppCameraManager", "stop record end");
            }
            String videoPath2 = cameraPreview.getVideoPath();
            String thumbPath2 = cameraPreview.getThumbPath();
            if (!z && p(videoPath2) && !TextUtils.isEmpty(thumbPath2)) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("tempVideoPath", dj3.J(videoPath2, vb3Var.b));
                hashMap.put("tempThumbPath", dj3.J(thumbPath2, vb3Var.b));
                j(unitedSchemeEntity, callbackHandler, hashMap, "");
            } else {
                k(unitedSchemeEntity, callbackHandler, false);
            }
            cameraPreview.m();
            v82.i("SwanAppCameraManager", "stop record end");
        }
    }
}
