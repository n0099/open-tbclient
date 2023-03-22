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
import com.baidu.tieba.qs2;
import com.baidu.tieba.x63;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class la3 extends q93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FloatButton c;
    public ja3 d;
    public tc3 e;
    public String f;

    /* loaded from: classes5.dex */
    public class a implements mm3<tc3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ t73 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ la3 g;

        public a(la3 la3Var, CallbackHandler callbackHandler, String str, JSONObject jSONObject, Context context, t73 t73Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la3Var, callbackHandler, str, jSONObject, context, t73Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = la3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = jSONObject;
            this.d = context;
            this.e = t73Var;
            this.f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(tc3 tc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tc3Var) == null) {
                if (tc3Var != null && !tc3Var.d) {
                    if (this.g.w(tc3Var, this.c.optString("scheme"))) {
                        this.g.e = tc3Var;
                        SwanAppActivity swanAppActivity = (SwanAppActivity) this.d;
                        this.g.d = ja3.d();
                        if (this.g.d.c() == null) {
                            la3 la3Var = this.g;
                            la3Var.c = la3Var.y(this.d, this.c);
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
                rc3.o(10005, this.a, this.b);
                me3.r(10005, tc3Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements FullScreenFloatView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ la3 e;

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public b(la3 la3Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la3Var, activity, jSONObject, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = la3Var;
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
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int i = 0;
                if (nl3.F(this.a, this.e.f)) {
                    String optString = this.b.optString("scheme");
                    la3 la3Var = this.e;
                    this.e.z(this.a, optString, la3Var.v(la3Var.e.i.get(0), optString), this.c, this.d);
                    return;
                }
                try {
                    String optString2 = this.b.optString(TTDownloadField.TT_DOWNLOAD_URL);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", optString2);
                    z = nl3.e(this.a, jSONObject.toString());
                } catch (JSONException e) {
                    if (q93.b) {
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

    /* loaded from: classes5.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;

        public c(la3 la3Var, Activity activity, String str, CallbackHandler callbackHandler, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la3Var, activity, str, callbackHandler, str2};
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
                boolean W = nl3.W(this.a, this.b);
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

    /* loaded from: classes5.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;

        public d(la3 la3Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la3Var, callbackHandler, str};
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
    public la3(q83 q83Var) {
        super(q83Var, "/swanAPI/showOpenAppGuide");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q83Var};
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

    @Override // com.baidu.tieba.q93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, t73Var)) == null) {
            JSONObject a2 = q93.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty params");
                return false;
            } else if (t73Var == null) {
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
                ja3 d2 = ja3.d();
                this.d = d2;
                d2.i(this.f);
                if (this.d.c() != null) {
                    this.c = y(context, a2);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                    return true;
                }
                qs2.a Y = t73Var.Y();
                if (Y != null && !TextUtils.isEmpty(Y.T())) {
                    t73Var.e0().e("mapp_open_external_app", new a(this, callbackHandler, optString, a2, context, t73Var, Y.T()));
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
                            if (q93.b) {
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

    public final boolean w(tc3 tc3Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tc3Var, str)) == null) {
            if (tc3Var != null && !TextUtils.isEmpty(str)) {
                for (String str2 : tc3Var.h) {
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
            String string = activity.getString(R.string.obfuscated_res_0x7f0f011c);
            String string2 = activity.getString(R.string.obfuscated_res_0x7f0f0114);
            x63.a aVar = new x63.a(activity);
            aVar.f(true);
            aVar.x(str2);
            aVar.n(new bn3());
            aVar.m(false);
            aVar.P(string, new c(this, activity, str, callbackHandler, str3));
            aVar.C(string2, new d(this, callbackHandler, str3));
            aVar.X();
        }
    }
}
