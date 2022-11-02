package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.ga4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.AbstractBceClient;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes5.dex */
public class np3 extends wm1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ga4
    public void i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends ResponseCallback<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ma4 a;
        public final /* synthetic */ np3 b;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public a(np3 np3Var, ma4 ma4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {np3Var, ma4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = np3Var;
            this.a = ma4Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, exc) != null) {
                return;
            }
            this.b.v();
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                this.b.x(response, this.a);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    public np3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.ga4
    public void f(int i, List<ma4> list, ga4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, list, aVar) == null) {
            aVar.a(40);
        }
    }

    @Override // com.baidu.tieba.wm1, com.baidu.tieba.ga4
    public boolean j(ma4 ma4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ma4Var)) == null) {
            int c = ma4Var.c();
            if (c != 40) {
                if (c == 45) {
                    t(ma4Var);
                }
            } else {
                u(ma4Var);
            }
            return super.j(ma4Var);
        }
        return invokeL.booleanValue;
    }

    public void o(List<ma4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, list) != null) || list == null) {
            return;
        }
        list.add(new ma4(40, R.string.obfuscated_res_0x7f0f00f5, R.drawable.obfuscated_res_0x7f0800f2, true));
    }

    public final void t(ma4 ma4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, ma4Var) != null) || e43.b0() == null) {
            return;
        }
        q(ma4Var);
    }

    @Override // com.baidu.tieba.wm1, com.baidu.tieba.ga4
    public void d(int i, List<ma4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, list) == null) {
            super.d(i, list);
            if (i == 12 || i == 15 || i == 17 || i == 18) {
                r(list);
                if (!"wYub6F7RD2tEngaTnOQPBEbYXx5s4Y3y".equals(d43.K().getAppId()) && !"sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(d43.K().getAppId()) && ln2.L().a()) {
                    o(list);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ga4
    public boolean k(boolean z, int i) {
        InterceptResult invokeCommon;
        e43 b0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (!yh3.Q()) {
                return false;
            }
            Context appContext = AppRuntime.getAppContext();
            if (!ks1.y(appContext) || (b0 = e43.b0()) == null || !b0.N().e(appContext)) {
                return false;
            }
            PMSAppInfo f0 = b0.W().f0();
            if (b0.w0() || f0 == null || TextUtils.isEmpty(f0.paNumber)) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void x(Response response, ma4 ma4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, response, ma4Var) == null) {
            try {
                if (!response.isSuccessful()) {
                    v();
                    return;
                }
                JSONObject jSONObject = new JSONObject(response.body().string());
                if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                    v();
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    v();
                    return;
                }
                Uri p = p(optJSONObject.optString("scheme"));
                if (p == null) {
                    v();
                } else if (SchemeRouter.invokeScheme(AppRuntime.getAppContext(), p, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                    w(ma4Var);
                }
            } catch (Exception unused) {
                v();
            }
        }
    }

    public final Uri p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            String schemeHead = SchemeConfig.getSchemeHead();
            if (TextUtils.isEmpty(schemeHead)) {
                schemeHead = "baiduboxapp";
            }
            buildUpon.scheme(schemeHead);
            return buildUpon.build();
        }
        return (Uri) invokeL.objValue;
    }

    public final void r(List<ma4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) && list != null && yh3.Q() && ks1.y(AppRuntime.getAppContext())) {
            list.add(new ma4(45, R.string.obfuscated_res_0x7f0f129c, R.drawable.obfuscated_res_0x7f0800df, true));
        }
    }

    public final void u(ma4 ma4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ma4Var) == null) {
            ut2.o("appletCenter");
            hq3.a(SchemeConfig.getSchemeHead() + "://swan/wYub6F7RD2tEngaTnOQPBEbYXx5s4Y3y?_baiduboxapp={\"from\":\"1271009000000000\",\"ext\":{}}&callback=_bdbox_js_275&upgrade=0");
        }
    }

    public final void w(ma4 ma4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, ma4Var) == null) {
            ln2.i().d();
            cu2.j(ma4Var);
            if (ma4Var.e() > 0) {
                i = 1;
            } else {
                i = 0;
            }
            ut2.q("customerService", String.valueOf(i), "click");
            cu2.i();
        }
    }

    public final void q(ma4 ma4Var) {
        e43 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, ma4Var) != null) || (b0 = e43.b0()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        eh3.f(jSONObject, GameGuideConfigInfo.KEY_APP_KEY, b0.getAppId());
        eh3.f(jSONObject, "srcAppPage", eu2.b(yh3.n()));
        JSONObject jSONObject2 = new JSONObject();
        eh3.f(jSONObject2, "appKey", "pjwYb22xF6hUcKpZKsiqvnhUhsoUvLfT");
        eh3.f(jSONObject2, "path", "pages/conversation/index");
        eh3.f(jSONObject2, PrefetchEvent.EVENT_DATA_EXTRA_DATA, s(b0));
        eh3.f(jSONObject, "params", jSONObject2);
        String I = ln2.o().I();
        hb4 hb4Var = new hb4(I, new Request.Builder().url(I).post(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().body(), new a(this, ma4Var));
        hb4Var.f = true;
        hb4Var.g = false;
        hb4Var.h = true;
        ib4.g().e(hb4Var);
    }

    public final JSONObject s(e43 e43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, e43Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            PMSAppInfo f0 = e43Var.W().f0();
            eh3.f(jSONObject, "appname", f0.appName);
            eh3.f(jSONObject, "iconUrl", f0.iconUrl);
            eh3.f(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, f0.appKey);
            eh3.f(jSONObject, "pa", f0.paNumber);
            eh3.f(jSONObject, "isBaiduSeries", Boolean.valueOf(SwanAppAllianceLoginHelper.d.h()));
            eh3.f(jSONObject, "isOpenCustomerService", Boolean.valueOf(yh3.Q()));
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
