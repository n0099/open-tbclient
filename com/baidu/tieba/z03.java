package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.sapi2.SapiOptions;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.tieba.mg3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class z03 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    /* loaded from: classes9.dex */
    public class a implements aq3<kg3<mg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ SwanAppActionBar c;
        public final /* synthetic */ float d;

        public a(z03 z03Var, CallbackHandler callbackHandler, String str, SwanAppActionBar swanAppActionBar, float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z03Var, callbackHandler, str, swanAppActionBar, Float.valueOf(f)};
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
            this.c = swanAppActionBar;
            this.d = f;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<mg3.e> kg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                if (!fg3.h(kg3Var)) {
                    fg3.q(kg3Var, this.a, this.b);
                } else if (this.c.getRightMenu() == null) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                } else {
                    this.c.setRightMenuAlpha(this.d);
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements aq3<kg3<mg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ SwanAppActionBar d;
        public final /* synthetic */ z03 e;

        public b(z03 z03Var, CallbackHandler callbackHandler, String str, boolean z, SwanAppActionBar swanAppActionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z03Var, callbackHandler, str, Boolean.valueOf(z), swanAppActionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = z03Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = z;
            this.d = swanAppActionBar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<mg3.e> kg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                if (!fg3.h(kg3Var)) {
                    fg3.q(kg3Var, this.a, this.b);
                    return;
                }
                if (this.c) {
                    this.e.r(this.d);
                } else {
                    this.e.n(this.d);
                }
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z03(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/menu");
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

    @Override // com.baidu.tieba.ed3
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, hb3 hb3Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, hb3Var)) == null) {
            if (context != null && hb3Var != null) {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    h82.c("menu", "parameters are illegal");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    return false;
                }
                uw2 T2 = uw2.T();
                if (T2 == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                qa2 U = T2.U();
                if (U == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                na2 m = U.m();
                if (m == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                SwanAppActionBar L1 = m.L1();
                if (L1 == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                l(hb3Var, context, callbackHandler, optString, L1, optParamsAsJo, str, m);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            h82.c("menu", "parameters dismissed");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public final void l(hb3 hb3Var, Context context, CallbackHandler callbackHandler, String str, SwanAppActionBar swanAppActionBar, JSONObject jSONObject, String str2, na2 na2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{hb3Var, context, callbackHandler, str, swanAppActionBar, jSONObject, str2, na2Var}) == null) {
            if (swanAppActionBar == null) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            } else if (TextUtils.equals(str2, "/swanAPI/menu/setMenuEnabled")) {
                p(hb3Var, context, callbackHandler, str, swanAppActionBar, jSONObject.optBoolean(SapiOptions.KEY_CACHE_ENABLED, true));
            } else if (TextUtils.equals(str2, "/swanAPI/menu/setPageStyle")) {
                String optString = jSONObject.optString("menuColorStyle", "");
                boolean m = m(jSONObject);
                if (TextUtils.isEmpty(optString)) {
                    optString = "white";
                }
                q(callbackHandler, str, swanAppActionBar, optString, m, na2Var);
                zq3.c().j(jSONObject.optString(PrefetchEvent.EVENT_KEY_PAGE_URL, ""));
            } else if (TextUtils.equals(str2, "/swanAPI/menu/setMenuOpacity")) {
                float optDouble = (float) jSONObject.optDouble(Key.ALPHA, 1.0d);
                if (optDouble <= 1.0f && optDouble >= 0.1f) {
                    o(hb3Var, context, callbackHandler, str, swanAppActionBar, optDouble);
                    return;
                }
                h82.c("menu", "The range of alpha should be in [0.1,1]");
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            } else {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    public final boolean m(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            boolean d = zq3.c().d();
            if (jSONObject != null && jSONObject.has(LiveFeedPageSdk.IMMERSION)) {
                boolean optBoolean = jSONObject.optBoolean(LiveFeedPageSdk.IMMERSION, true);
                zq3.c().k(optBoolean);
                return optBoolean;
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public final boolean n(SwanAppActionBar swanAppActionBar) {
        InterceptResult invokeL;
        View rightMenu;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, swanAppActionBar)) == null) {
            if (swanAppActionBar == null || (rightMenu = swanAppActionBar.getRightMenu()) == null) {
                return false;
            }
            rightMenu.setVisibility(4);
            swanAppActionBar.setRightMenuEnable(false);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean r(SwanAppActionBar swanAppActionBar) {
        InterceptResult invokeL;
        View rightMenu;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, swanAppActionBar)) == null) {
            if (swanAppActionBar == null || (rightMenu = swanAppActionBar.getRightMenu()) == null) {
                return false;
            }
            rightMenu.setVisibility(0);
            swanAppActionBar.setRightMenuEnable(true);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void o(hb3 hb3Var, Context context, CallbackHandler callbackHandler, String str, SwanAppActionBar swanAppActionBar, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{hb3Var, context, callbackHandler, str, swanAppActionBar, Float.valueOf(f)}) == null) {
            hb3Var.e0().g(context, "mapp_change_menu_appearance", new a(this, callbackHandler, str, swanAppActionBar, f));
        }
    }

    public final void p(hb3 hb3Var, Context context, CallbackHandler callbackHandler, String str, SwanAppActionBar swanAppActionBar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{hb3Var, context, callbackHandler, str, swanAppActionBar, Boolean.valueOf(z)}) == null) {
            hb3Var.e0().g(context, "scope_hide_menu", new b(this, callbackHandler, str, z, swanAppActionBar));
        }
    }

    public final void q(CallbackHandler callbackHandler, String str, SwanAppActionBar swanAppActionBar, String str2, boolean z, na2 na2Var) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{callbackHandler, str, swanAppActionBar, str2, Boolean.valueOf(z), na2Var}) == null) {
            if (swanAppActionBar.getRightMenu() == null) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                return;
            }
            int t = SwanAppConfigData.t(str2);
            swanAppActionBar.f(t, false);
            iq3 J1 = na2Var.J1();
            if (J1 == null) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                return;
            }
            if (t == -1) {
                J1.m(0, z, false);
            } else {
                boolean z3 = true;
                if (t == -16777216) {
                    J1.m(0, z, true);
                } else {
                    if (t != 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    J1.m(0, z, (z2 || !tn3.a(t)) ? false : false);
                }
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
    }
}
