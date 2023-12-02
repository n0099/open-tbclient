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
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.mc4;
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
/* loaded from: classes8.dex */
public class tr3 extends dp1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.mc4
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

    /* loaded from: classes8.dex */
    public class a extends ResponseCallback<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sc4 a;
        public final /* synthetic */ tr3 b;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public a(tr3 tr3Var, sc4 sc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tr3Var, sc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tr3Var;
            this.a = sc4Var;
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

    public tr3() {
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

    @Override // com.baidu.tieba.mc4
    public void f(int i, List<sc4> list, mc4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, list, aVar) == null) {
            aVar.a(40);
        }
    }

    @Override // com.baidu.tieba.dp1, com.baidu.tieba.mc4
    public boolean j(sc4 sc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, sc4Var)) == null) {
            int c = sc4Var.c();
            if (c != 40) {
                if (c == 45) {
                    t(sc4Var);
                }
            } else {
                u(sc4Var);
            }
            return super.j(sc4Var);
        }
        return invokeL.booleanValue;
    }

    public void o(List<sc4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, list) != null) || list == null) {
            return;
        }
        list.add(new sc4(40, R.string.obfuscated_res_0x7f0f012c, R.drawable.obfuscated_res_0x7f080112, true));
    }

    public final void t(sc4 sc4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, sc4Var) != null) || k63.c0() == null) {
            return;
        }
        q(sc4Var);
    }

    @Override // com.baidu.tieba.dp1, com.baidu.tieba.mc4
    public void d(int i, List<sc4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, list) == null) {
            super.d(i, list);
            if (i == 12 || i == 15 || i == 17 || i == 18) {
                r(list);
                if (!"wYub6F7RD2tEngaTnOQPBEbYXx5s4Y3y".equals(j63.K().getAppId()) && !"sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(j63.K().getAppId()) && rp2.L().a()) {
                    o(list);
                }
            }
        }
    }

    @Override // com.baidu.tieba.mc4
    public boolean k(boolean z, int i) {
        InterceptResult invokeCommon;
        k63 c0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (!ek3.Q()) {
                return false;
            }
            Context appContext = AppRuntime.getAppContext();
            if (!ru1.z(appContext) || (c0 = k63.c0()) == null || !c0.N().e(appContext)) {
                return false;
            }
            PMSAppInfo g0 = c0.X().g0();
            if (c0.x0() || g0 == null || TextUtils.isEmpty(g0.paNumber)) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void x(Response response, sc4 sc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, response, sc4Var) == null) {
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
                    w(sc4Var);
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
                schemeHead = BaiduIdentityManager.VALUE_OSNAME;
            }
            buildUpon.scheme(schemeHead);
            return buildUpon.build();
        }
        return (Uri) invokeL.objValue;
    }

    public final void r(List<sc4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) && list != null && ek3.Q() && ru1.z(AppRuntime.getAppContext())) {
            list.add(new sc4(45, R.string.obfuscated_res_0x7f0f1513, R.drawable.obfuscated_res_0x7f0800ff, true));
        }
    }

    public final void u(sc4 sc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, sc4Var) == null) {
            aw2.o("appletCenter");
            ns3.a(SchemeConfig.getSchemeHead() + "://swan/wYub6F7RD2tEngaTnOQPBEbYXx5s4Y3y?_baiduboxapp={\"from\":\"1271009000000000\",\"ext\":{}}&callback=_bdbox_js_275&upgrade=0");
        }
    }

    public final void w(sc4 sc4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, sc4Var) == null) {
            rp2.i().d();
            iw2.j(sc4Var);
            if (sc4Var.e() > 0) {
                i = 1;
            } else {
                i = 0;
            }
            aw2.q("customerService", String.valueOf(i), "click");
            iw2.i();
        }
    }

    public final void q(sc4 sc4Var) {
        k63 c0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, sc4Var) != null) || (c0 = k63.c0()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        kj3.f(jSONObject, GameGuideConfigInfo.KEY_APP_KEY, c0.getAppId());
        kj3.f(jSONObject, "srcAppPage", kw2.b(ek3.n()));
        JSONObject jSONObject2 = new JSONObject();
        kj3.f(jSONObject2, "appKey", "pjwYb22xF6hUcKpZKsiqvnhUhsoUvLfT");
        kj3.f(jSONObject2, "path", "pages/conversation/index");
        kj3.f(jSONObject2, PrefetchEvent.EVENT_DATA_EXTRA_DATA, s(c0));
        kj3.f(jSONObject, "params", jSONObject2);
        String I = rp2.o().I();
        nd4 nd4Var = new nd4(I, new Request.Builder().url(I).post(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().body(), new a(this, sc4Var));
        nd4Var.f = true;
        nd4Var.g = false;
        nd4Var.h = true;
        od4.g().e(nd4Var);
    }

    public final JSONObject s(k63 k63Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, k63Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            PMSAppInfo g0 = k63Var.X().g0();
            kj3.f(jSONObject, "appname", g0.appName);
            kj3.f(jSONObject, GameAssistConstKt.KEY_ICONURL, g0.iconUrl);
            kj3.f(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0.appKey);
            kj3.f(jSONObject, "pa", g0.paNumber);
            kj3.f(jSONObject, "isBaiduSeries", Boolean.valueOf(SwanAppAllianceLoginHelper.d.h()));
            kj3.f(jSONObject, "isOpenCustomerService", Boolean.valueOf(ek3.Q()));
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
