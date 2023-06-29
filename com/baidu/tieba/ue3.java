package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.tieba.gb3;
import com.baidu.tieba.zw2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ue3 extends zd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FloatButton c;
    public se3 d;
    public ch3 e;
    public String f;

    /* loaded from: classes8.dex */
    public class a implements vq3<ch3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ cc3 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ ue3 g;

        public a(ue3 ue3Var, CallbackHandler callbackHandler, String str, JSONObject jSONObject, Context context, cc3 cc3Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var, callbackHandler, str, jSONObject, context, cc3Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ue3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = jSONObject;
            this.d = context;
            this.e = cc3Var;
            this.f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(ch3 ch3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ch3Var) == null) {
                if (ch3Var != null && !ch3Var.d) {
                    if (this.g.w(ch3Var, this.c.optString("scheme"))) {
                        this.g.e = ch3Var;
                        SwanAppActivity swanAppActivity = (SwanAppActivity) this.d;
                        this.g.d = se3.d();
                        if (this.g.d.c() == null) {
                            ue3 ue3Var = this.g;
                            ue3Var.c = ue3Var.y(this.d, this.c);
                            this.g.x(this.b, this.c, this.a, swanAppActivity);
                        }
                        this.e.U().h(this.f, Boolean.TRUE);
                        return;
                    }
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001, "open app scheme is not allowed").toString());
                    return;
                }
                FloatButton c = this.g.d.c();
                if (c != null) {
                    c.setVisibility(8);
                }
                ah3.o(10005, this.a, this.b);
                vi3.r(10005, ch3Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements FullScreenFloatView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ue3 e;

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onDrag() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public b(ue3 ue3Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var, activity, jSONObject, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ue3Var;
            this.a = activity;
            this.b = jSONObject;
            this.c = callbackHandler;
            this.d = str;
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onClick() {
            boolean z;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = 0;
                if (wp3.F(this.a, this.e.f)) {
                    String optString = this.b.optString("scheme");
                    ue3 ue3Var = this.e;
                    this.e.z(this.a, optString, ue3Var.v(ue3Var.e.i.get(0), optString), this.c, this.d);
                    return;
                }
                try {
                    String optString2 = this.b.optString(TTDownloadField.TT_DOWNLOAD_URL);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", optString2);
                    z = wp3.e(this.a, jSONObject.toString());
                } catch (JSONException e) {
                    if (zd3.b) {
                        e.printStackTrace();
                    }
                    z = false;
                }
                if (!z) {
                    i = 1001;
                }
                if (z) {
                    str = "download app success";
                } else {
                    str = "download app fail";
                }
                this.c.handleSchemeDispatchCallback(this.d, UnitedSchemeUtility.wrapCallbackParams(i, str).toString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;

        public c(ue3 ue3Var, Activity activity, String str, CallbackHandler callbackHandler, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var, activity, str, callbackHandler, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.b = str;
            this.c = callbackHandler;
            this.d = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            int i2;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                boolean W = wp3.W(this.a, this.b);
                if (W) {
                    i2 = 0;
                } else {
                    i2 = 1001;
                }
                if (W) {
                    str = "open app success";
                } else {
                    str = "open app fail";
                }
                this.c.handleSchemeDispatchCallback(this.d, UnitedSchemeUtility.wrapCallbackParams(i2, str).toString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;

        public d(ue3 ue3Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var, callbackHandler, str};
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
            this.b = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ue3(zc3 zc3Var) {
        super(zc3Var, "/swanAPI/showOpenAppGuide");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zc3Var};
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

    public final FloatButton y(Context context, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, jSONObject)) == null) {
            this.d.g((SwanAppActivity) context, jSONObject);
            return this.d.f();
        }
        return (FloatButton) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.zd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, cc3 cc3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, cc3Var)) == null) {
            JSONObject a2 = zd3.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty params");
                return false;
            } else if (cc3Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
                return false;
            } else if (!(context instanceof SwanAppActivity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not instanceof SwanAppActivity");
                return false;
            } else {
                String optString = a2.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    return false;
                }
                String optString2 = a2.optString("name");
                this.f = optString2;
                if (TextUtils.isEmpty(optString2)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "packageName is empty");
                    return false;
                }
                se3 d2 = se3.d();
                this.d = d2;
                d2.i(this.f);
                if (this.d.c() != null) {
                    this.c = y(context, a2);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                    return true;
                }
                zw2.a Y = cc3Var.Y();
                if (Y != null && !TextUtils.isEmpty(Y.T())) {
                    cc3Var.e0().e("mapp_open_external_app", new a(this, callbackHandler, optString, a2, context, cc3Var, Y.T()));
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "launchInfo or source is empty");
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final String v(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            String str4 = "";
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> keys = jSONObject.keys();
                    str3 = "";
                    while (keys.hasNext()) {
                        try {
                            String next = keys.next();
                            if (next.equals("slogan_base")) {
                                str4 = jSONObject.optString(next);
                            }
                            if (str2.contains(next)) {
                                str3 = jSONObject.optString(next);
                            }
                        } catch (JSONException e) {
                            e = e;
                            if (zd3.b) {
                                e.printStackTrace();
                            }
                            if (!TextUtils.isEmpty(str4)) {
                                return str4 + str3;
                            }
                            return null;
                        }
                    }
                } catch (JSONException e2) {
                    e = e2;
                    str3 = "";
                }
                if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                    return str4 + str3;
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public final boolean w(ch3 ch3Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ch3Var, str)) == null) {
            if (ch3Var != null && !TextUtils.isEmpty(str)) {
                for (String str2 : ch3Var.h) {
                    if (str.contains(str2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void x(String str, JSONObject jSONObject, CallbackHandler callbackHandler, Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, str, jSONObject, callbackHandler, activity) == null) && callbackHandler != null && !TextUtils.isEmpty(str)) {
            this.c.setDragImageListener(new b(this, activity, jSONObject, callbackHandler, str));
        }
    }

    public final void z(Activity activity, String str, String str2, CallbackHandler callbackHandler, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(1048581, this, activity, str, str2, callbackHandler, str3) == null) && (activity instanceof SwanAppActivity) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String string = activity.getString(R.string.obfuscated_res_0x7f0f0146);
            String string2 = activity.getString(R.string.obfuscated_res_0x7f0f013e);
            gb3.a aVar = new gb3.a(activity);
            aVar.f(true);
            aVar.x(str2);
            aVar.n(new kr3());
            aVar.m(false);
            aVar.P(string, new c(this, activity, str, callbackHandler, str3));
            aVar.C(string2, new d(this, callbackHandler, str3));
            aVar.X();
        }
    }
}
