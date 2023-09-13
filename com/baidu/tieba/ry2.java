package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
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
/* loaded from: classes7.dex */
public class ry2 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements k63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ hb3 c;
        public final /* synthetic */ zy2 d;
        public final /* synthetic */ ry2 e;

        public a(ry2 ry2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var, zy2 zy2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry2Var, unitedSchemeEntity, callbackHandler, hb3Var, zy2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ry2Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = hb3Var;
            this.d = zy2Var;
        }

        @Override // com.baidu.tieba.k63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (ed3.b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.e.p(this.a, this.b, this.c, this.d);
            }
        }

        @Override // com.baidu.tieba.k63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.safeCallback(this.b, this.a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.d.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements k63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ hb3 d;
        public final /* synthetic */ zy2 e;
        public final /* synthetic */ ry2 f;

        public b(ry2 ry2Var, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var, zy2 zy2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry2Var, context, unitedSchemeEntity, callbackHandler, hb3Var, zy2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ry2Var;
            this.a = context;
            this.b = unitedSchemeEntity;
            this.c = callbackHandler;
            this.d = hb3Var;
            this.e = zy2Var;
        }

        @Override // com.baidu.tieba.k63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (ed3.b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.f.r(this.a, this.b, this.c, this.d, this.e);
            }
        }

        @Override // com.baidu.tieba.k63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.safeCallback(this.c, this.b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.e.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements dz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hb3 a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ UnitedSchemeEntity c;
        public final /* synthetic */ zy2 d;

        public c(ry2 ry2Var, hb3 hb3Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, zy2 zy2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry2Var, hb3Var, callbackHandler, unitedSchemeEntity, zy2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hb3Var;
            this.b = callbackHandler;
            this.c = unitedSchemeEntity;
            this.d = zy2Var;
        }

        @Override // com.baidu.tieba.dz2
        public void a(boolean z, String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, obj}) == null) {
                if (z && (obj instanceof ArrayList)) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (ed3.b) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Log.d("chooseVideo", "tempPath = " + ((MediaModel) it.next()).getTempPath());
                        }
                    }
                    h82.i("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.b, this.c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(xy2.n(arrayList, this.a), 0).toString(), this.d.c);
                }
                yy2.a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements bz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy2 a;
        public final /* synthetic */ hb3 b;
        public final /* synthetic */ dz2 c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ UnitedSchemeEntity e;

        public d(ry2 ry2Var, zy2 zy2Var, hb3 hb3Var, dz2 dz2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry2Var, zy2Var, hb3Var, dz2Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy2Var;
            this.b = hb3Var;
            this.c = dz2Var;
            this.d = callbackHandler;
            this.e = unitedSchemeEntity;
        }

        @Override // com.baidu.tieba.bz2
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                h82.i("chooseVideo", "capture success");
                yy2.i(vy2.c(file));
                Bundle bundle = new Bundle();
                bundle.putString("swanTmpPath", uw2.T().G().k());
                bundle.putBoolean("compressed", this.a.b);
                bundle.putString("swanAppId", this.b.b);
                bundle.putParcelableArrayList("mediaModels", yy2.e());
                xy2.h(this.b.w(), bundle, this.c);
            }
        }

        @Override // com.baidu.tieba.bz2
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                UnitedSchemeUtility.safeCallback(this.d, this.e, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.a.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements cz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ zy2 c;
        public final /* synthetic */ hb3 d;

        public e(ry2 ry2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, zy2 zy2Var, hb3 hb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry2Var, callbackHandler, unitedSchemeEntity, zy2Var, hb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = zy2Var;
            this.d = hb3Var;
        }

        @Override // com.baidu.tieba.cz2
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                h82.i("chooseVideo", str);
                UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.c.c);
            }
        }

        @Override // com.baidu.tieba.cz2
        public void f(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list != null && list.size() > 0) {
                    h82.i("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(xy2.n(list, this.d), 0).toString(), this.c.c);
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.c.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ry2(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/chooseVideo");
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
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var, zy2 zy2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, hb3Var, zy2Var) == null) {
            j63.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new b(this, context, unitedSchemeEntity, callbackHandler, hb3Var, zy2Var));
        }
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var, zy2 zy2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, hb3Var, zy2Var) == null) {
            j63.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new a(this, unitedSchemeEntity, callbackHandler, hb3Var, zy2Var));
        }
    }

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            if (hb3Var != null && hb3Var.n0()) {
                if (ed3.b) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            }
            zy2 a2 = zy2.a(UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
            if (a2.a == 2) {
                q(context, unitedSchemeEntity, callbackHandler, hb3Var, a2);
            } else {
                o(context, unitedSchemeEntity, callbackHandler, hb3Var, a2);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var, zy2 zy2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, callbackHandler, hb3Var, zy2Var) == null) {
            d dVar = new d(this, zy2Var, hb3Var, new c(this, hb3Var, callbackHandler, unitedSchemeEntity, zy2Var), callbackHandler, unitedSchemeEntity);
            vy2.e(hb3Var.w(), hb3Var.b, zy2Var.e, TextUtils.equals(zy2Var.d, "front"), dVar);
        }
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var, zy2 zy2Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, context, unitedSchemeEntity, callbackHandler, hb3Var, zy2Var) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("launchType", "video");
            if (zy2Var.a == 3) {
                z = true;
            } else {
                z = false;
            }
            bundle.putBoolean("isShowCamera", z);
            bundle.putBoolean("isFrontCamera", TextUtils.equals(zy2Var.d, "front"));
            bundle.putInt("maxDuration", zy2Var.e);
            bundle.putInt("count", 1);
            bundle.putString("mode", "single");
            bundle.putBoolean("compressed", zy2Var.b);
            bundle.putString("swanAppId", hb3Var.b);
            bundle.putString("swanTmpPath", uw2.T().G().k());
            xy2.l(context, bundle, new e(this, callbackHandler, unitedSchemeEntity, zy2Var, hb3Var));
        }
    }
}
