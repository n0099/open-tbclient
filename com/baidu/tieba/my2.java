package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.toolbar.CommonToolbarStatisticConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.tieba.ig3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class my2 extends ad3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int c;
    public String d;
    public String e;

    /* loaded from: classes7.dex */
    public class a implements wp3<gg3<ig3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ db3 d;
        public final /* synthetic */ my2 e;

        public a(my2 my2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, db3 db3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my2Var, callbackHandler, unitedSchemeEntity, context, db3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = my2Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = context;
            this.d = db3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<ig3.e> gg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                if (bg3.h(gg3Var)) {
                    this.e.v(this.c, this.b, this.a, this.d);
                    return;
                }
                bg3.p(gg3Var, this.a, this.b);
                d82.c("chooseImage", "camera authorize failure");
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
        public final /* synthetic */ my2 d;

        public b(my2 my2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my2Var, unitedSchemeEntity, callbackHandler, db3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = my2Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = db3Var;
        }

        @Override // com.baidu.tieba.g63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (ad3.b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.d.t(this.a, this.b, this.c);
            }
        }

        @Override // com.baidu.tieba.g63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.safeCallback(this.b, this.a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.d.e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements g63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ db3 d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ my2 f;

        public c(my2 my2Var, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my2Var, context, unitedSchemeEntity, callbackHandler, db3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = my2Var;
            this.a = context;
            this.b = unitedSchemeEntity;
            this.c = callbackHandler;
            this.d = db3Var;
            this.e = z;
        }

        @Override // com.baidu.tieba.g63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (ad3.b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.f.x(this.a, this.b, this.c, this.d, this.e);
            }
        }

        @Override // com.baidu.tieba.g63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.safeCallback(this.c, this.b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f.e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements zy2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db3 a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ UnitedSchemeEntity c;
        public final /* synthetic */ my2 d;

        public d(my2 my2Var, db3 db3Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my2Var, db3Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = my2Var;
            this.a = db3Var;
            this.b = callbackHandler;
            this.c = unitedSchemeEntity;
        }

        @Override // com.baidu.tieba.zy2
        public void a(boolean z, String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, obj}) == null) {
                if (z && (obj instanceof ArrayList)) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (ad3.b) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Log.d("chooseImage", "tempPath = " + ((MediaModel) it.next()).getTempPath());
                        }
                    }
                    d82.i("chooseImage", "choose success");
                    UnitedSchemeUtility.safeCallback(this.b, this.c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(ty2.m(arrayList, this.a, "Image"), 0).toString(), this.d.e);
                }
                uy2.a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements xy2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db3 a;
        public final /* synthetic */ zy2 b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ my2 e;

        public e(my2 my2Var, db3 db3Var, zy2 zy2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my2Var, db3Var, zy2Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = my2Var;
            this.a = db3Var;
            this.b = zy2Var;
            this.c = callbackHandler;
            this.d = unitedSchemeEntity;
        }

        @Override // com.baidu.tieba.xy2
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                d82.i("chooseImage", "capture success");
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                uy2.i(imageModel);
                Bundle bundle = new Bundle();
                bundle.putString("swanTmpPath", qw2.T().G().k());
                bundle.putBoolean("compressed", TextUtils.equals(this.e.d, "compressed"));
                bundle.putString("swanAppId", this.a.b);
                bundle.putParcelableArrayList("mediaModels", uy2.e());
                ty2.h(this.a.w(), bundle, this.b);
            }
        }

        @Override // com.baidu.tieba.xy2
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                UnitedSchemeUtility.safeCallback(this.c, this.d, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.e.e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements yy2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ db3 c;
        public final /* synthetic */ my2 d;

        public f(my2 my2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, db3 db3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my2Var, callbackHandler, unitedSchemeEntity, db3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = my2Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = db3Var;
        }

        @Override // com.baidu.tieba.yy2
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d82.i("chooseImage", str);
                UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.d.e);
            }
        }

        @Override // com.baidu.tieba.yy2
        public void f(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list != null && list.size() > 0) {
                    d82.i("chooseImage", "choose success");
                    UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(ty2.m(list, this.c, "Image"), 0).toString(), this.d.e);
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.d.e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public my2(ac3 ac3Var) {
        super(ac3Var, "/swanAPI/chooseImage");
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
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final boolean w(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return true;
            }
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (TextUtils.equals("camera", jSONArray.optString(i))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void v(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, context, unitedSchemeEntity, callbackHandler, db3Var) == null) {
            f63.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new b(this, unitedSchemeEntity, callbackHandler, db3Var));
        }
    }

    public final String r(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray)) == null) {
            boolean z = true;
            if ((jSONArray != null && jSONArray.length() == 1 && TextUtils.equals("original", jSONArray.optString(0))) ? false : false) {
                return "original";
            }
            return "compressed";
        }
        return (String) invokeL.objValue;
    }

    public final String s(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray)) == null) {
            boolean z = true;
            if ((jSONArray != null && jSONArray.length() == 1 && TextUtils.equals("camera", jSONArray.optString(0))) ? false : false) {
                return "camera";
            }
            return CommonToolbarStatisticConstants.TOOLBAR_MENU_STAT_SOURCE_PICTURE_BROWSER;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ad3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, db3Var)) == null) {
            if (db3Var != null && db3Var.w() != null) {
                if (db3Var.n0()) {
                    if (ad3.b) {
                        Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                    return false;
                }
                JSONObject d2 = do3.d(unitedSchemeEntity.getParam("params"));
                String optString = d2.optString("cb");
                this.e = optString;
                if (TextUtils.isEmpty(optString)) {
                    d82.c("chooseImage", "empty cb");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                try {
                    int parseInt = Integer.parseInt(d2.optString("count"));
                    this.c = parseInt;
                    if (parseInt < 1 || parseInt > 9) {
                        this.c = 9;
                    }
                } catch (NumberFormatException unused) {
                    d82.c("chooseImage", "count format error");
                    this.c = 9;
                }
                this.d = r(d2.optJSONArray("sizeType"));
                JSONArray optJSONArray = d2.optJSONArray("sourceType");
                String s = s(optJSONArray);
                d82.i("chooseImage", "sizeType: " + this.d + ",sourceType: " + s);
                if (TextUtils.equals(s, CommonToolbarStatisticConstants.TOOLBAR_MENU_STAT_SOURCE_PICTURE_BROWSER)) {
                    u(context, unitedSchemeEntity, callbackHandler, db3Var, w(optJSONArray));
                } else {
                    db3Var.e0().g(db3Var.w(), PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, db3Var));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            d82.c("chooseImage", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void t(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, unitedSchemeEntity, callbackHandler, db3Var) == null) {
            ry2.f(db3Var.w(), db3Var.b, new e(this, db3Var, new d(this, db3Var, callbackHandler, unitedSchemeEntity), callbackHandler, unitedSchemeEntity));
        }
    }

    public final void u(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, unitedSchemeEntity, callbackHandler, db3Var, Boolean.valueOf(z)}) == null) {
            f63.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new c(this, context, unitedSchemeEntity, callbackHandler, db3Var, z));
        }
    }

    public final void x(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, unitedSchemeEntity, callbackHandler, db3Var, Boolean.valueOf(z)}) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("launchType", "Image");
            bundle.putBoolean("isShowCamera", z);
            bundle.putInt("count", this.c);
            bundle.putString("mode", "single");
            bundle.putBoolean("compressed", TextUtils.equals(this.d, "compressed"));
            bundle.putString("swanAppId", db3Var.b);
            bundle.putString("swanTmpPath", qw2.T().G().k());
            ty2.l(context, bundle, new f(this, callbackHandler, unitedSchemeEntity, db3Var));
        }
    }
}
