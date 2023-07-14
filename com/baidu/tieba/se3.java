package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.nb3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class se3 extends sd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ UnitedSchemeEntity c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ se3 g;

        public a(se3 se3Var, Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se3Var, context, callbackHandler, unitedSchemeEntity, str, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = se3Var;
            this.a = context;
            this.b = callbackHandler;
            this.c = unitedSchemeEntity;
            this.d = str;
            this.e = i;
            this.f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.r(this.a, this.b, this.c, this.d, this.e, this.f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ UnitedSchemeEntity c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ Drawable f;
        public final /* synthetic */ boolean g;
        public final /* synthetic */ se3 h;

        public b(se3 se3Var, Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i, Drawable drawable, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se3Var, context, callbackHandler, unitedSchemeEntity, str, Integer.valueOf(i), drawable, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = se3Var;
            this.a = context;
            this.b = callbackHandler;
            this.c = unitedSchemeEntity;
            this.d = str;
            this.e = i;
            this.f = drawable;
            this.g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.h.p(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ UnitedSchemeEntity c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ se3 g;

        public c(se3 se3Var, Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se3Var, context, callbackHandler, unitedSchemeEntity, str, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = se3Var;
            this.a = context;
            this.b = callbackHandler;
            this.c = unitedSchemeEntity;
            this.d = str;
            this.e = i;
            this.f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.q(this.a, this.b, this.c, this.d, this.e, this.f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ UnitedSchemeEntity c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ se3 h;

        public d(se3 se3Var, Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se3Var, context, callbackHandler, unitedSchemeEntity, str, Integer.valueOf(i), str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = se3Var;
            this.a = context;
            this.b = callbackHandler;
            this.c = unitedSchemeEntity;
            this.d = str;
            this.e = i;
            this.f = str2;
            this.g = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.h.o(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements nb3.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ CallbackHandler b;

        public e(se3 se3Var, String str, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se3Var, str, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = callbackHandler;
        }

        @Override // com.baidu.tieba.nb3.c
        public void onToastClick() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !TextUtils.isEmpty(this.a)) {
                this.b.handleSchemeDispatchCallback(this.a, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public se3(sc3 sc3Var) {
        super(sc3Var, "/swanAPI/showToast");
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
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.sd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, vb3Var)) == null) {
            if (vb3Var != null && vb3Var.n0()) {
                if (sd3.b) {
                    Log.d("ShowToastAction", "ShowToastAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                return false;
            }
            HashMap<String, String> params = unitedSchemeEntity.getParams();
            if (params != null && params.size() != 0) {
                String str = params.get("params");
                if (TextUtils.isEmpty(str)) {
                    v82.c("ShowToastAction", "the key params is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("type", "1");
                    int F = w02.F(jSONObject);
                    String optString2 = jSONObject.optString("message");
                    if (TextUtils.isEmpty(optString2)) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                        v82.c("ShowToastAction", "message is null");
                        return false;
                    }
                    boolean optBoolean = jSONObject.optBoolean("mask");
                    String optString3 = jSONObject.optString("image", "-1");
                    if (!TextUtils.equals(optString3, "-1") && !optString3.startsWith(pp3.x(vb3Var).getPath())) {
                        optString3 = pp3.w(vb3Var, optString3);
                    }
                    Drawable L = w02.L(context, optString3, vb3Var);
                    if (sd3.b) {
                        Log.e("ShowToastAction", "imagepath = " + optString3);
                    }
                    if (!TextUtils.equals(optString3, "-1") && L == null && TextUtils.equals(optString, "2")) {
                        optString = "1";
                    }
                    String optString4 = jSONObject.optString("cb");
                    String optString5 = jSONObject.optString("buttonText");
                    switch (optString.hashCode()) {
                        case 49:
                            if (optString.equals("1")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 50:
                            if (optString.equals("2")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 51:
                            if (optString.equals("3")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 52:
                            if (optString.equals("4")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    try {
                        if (c2 != 0) {
                            if (c2 != 1) {
                                if (c2 != 2) {
                                    if (c2 != 3) {
                                        n(unitedSchemeEntity);
                                        return false;
                                    }
                                    pp3.e0(new d(this, context, callbackHandler, unitedSchemeEntity, optString2, F, optString5, optString4));
                                } else {
                                    pp3.e0(new c(this, context, callbackHandler, unitedSchemeEntity, optString2, F, optBoolean));
                                }
                            } else {
                                pp3.e0(new b(this, context, callbackHandler, unitedSchemeEntity, optString2, F, L, optBoolean));
                            }
                        } else {
                            pp3.e0(new a(this, context, callbackHandler, unitedSchemeEntity, optString2, F, optBoolean));
                        }
                        return true;
                    } catch (JSONException e2) {
                        e = e2;
                        if (sd3.b) {
                            e.printStackTrace();
                        }
                        v82.c("ShowToastAction", "json exception");
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                        return false;
                    }
                } catch (JSONException e3) {
                    e = e3;
                }
            } else {
                v82.c("ShowToastAction", "hasMmap for params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
        } else {
            return invokeLLLL.booleanValue;
        }
    }

    public final void n(UnitedSchemeEntity unitedSchemeEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity) == null) {
            if (sd3.b) {
                Log.w("ShowToastAction", "the toast type is unknown");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
        }
    }

    public final void o(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i, @NonNull String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, callbackHandler, unitedSchemeEntity, str, Integer.valueOf(i), str2, str3}) == null) {
            nb3 e2 = nb3.e(context);
            e2.r(str);
            e2.k(str2);
            e2.l(i);
            e2.u(new e(this, str3, callbackHandler));
            e2.w();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        }
    }

    public final void p(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i, Drawable drawable, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, callbackHandler, unitedSchemeEntity, str, Integer.valueOf(i), drawable, Boolean.valueOf(z)}) == null) {
            nb3 g = nb3.g(context, w02.H(str, 14));
            g.n(drawable);
            g.l(i);
            g.s(z);
            g.B();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        }
    }

    public final void q(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, callbackHandler, unitedSchemeEntity, str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            nb3 g = nb3.g(context, w02.H(str, 14));
            g.l(i);
            g.s(z);
            g.z();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        }
    }

    public final void r(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, callbackHandler, unitedSchemeEntity, str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            nb3 g = nb3.g(context, str);
            g.l(i);
            g.s(z);
            g.q(2);
            g.G();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        }
    }
}
