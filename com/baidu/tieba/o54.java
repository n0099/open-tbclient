package com.baidu.tieba;

import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.games.view.desktopguide.DesktopGuideApi;
import com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class o54 extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean u;
    public transient /* synthetic */ FieldHolder $fh;
    public ri2 a;
    public in2 b;
    public qa4 c;
    public oa4 d;
    @V8JavascriptField
    public final String domain;
    public JsObject e;
    @V8JavascriptField
    public en2 env;
    public ra4 f;
    public z84 g;
    public a94 h;
    public kc4 i;
    public qd4 j;
    public m44 k;
    public ea4 l;
    public a64 m;
    public cb4 n;
    public DesktopGuideApi o;
    public ya4 p;
    public ff4 q;
    public s44 r;
    public k64 s;
    public wa4 t;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947983227, "Lcom/baidu/tieba/o54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947983227, "Lcom/baidu/tieba/o54;");
                return;
            }
        }
        u = rr1.a;
    }

    @JavascriptInterface
    public void clearStorageSync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            rc4.a(this.a, "clearStorageSync", "", w().a());
        }
    }

    @JavascriptInterface
    public e54 createInnerAudioContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return new e54(this.a);
        }
        return (e54) invokeV.objValue;
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return createRecommendationButton(null);
        }
        return (RecommendButtonApiProxy) invokeV.objValue;
    }

    @JavascriptInterface
    public id4 createUDPSocket() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return ld4.c.b(this.a);
        }
        return (id4) invokeV.objValue;
    }

    @JavascriptInterface
    public s44 getAntiAddiction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.r == null) {
                this.r = new s44(this.a);
            }
            return this.r;
        }
        return (s44) invokeV.objValue;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return rv2.a(this.a);
        }
        return (String) invokeV.objValue;
    }

    @JavascriptInterface
    public in2 getFileSystemManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.b == null) {
                this.b = new in2((pi2) this.a);
            }
            return this.b;
        }
        return (in2) invokeV.objValue;
    }

    @JavascriptInterface
    public qa4 getOpenData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.c == null) {
                this.c = new qa4((pi2) this.a);
            }
            return this.c;
        }
        return (qa4) invokeV.objValue;
    }

    @JavascriptInterface
    public ra4 getOpenDataContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.f == null) {
                ra4 ra4Var = new ra4(this.a);
                this.f = ra4Var;
                ra4Var.canvas = this.e;
                this.e = null;
            }
            return this.f;
        }
        return (ra4) invokeV.objValue;
    }

    @JavascriptInterface
    public qc4 getStorageInfoSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return w().b();
        }
        return (qc4) invokeV.objValue;
    }

    @JavascriptInterface
    public cb4 getVideoRecorderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.n == null) {
                this.n = new cb4(this.a);
            }
            return this.n;
        }
        return (cb4) invokeV.objValue;
    }

    @JavascriptInterface
    public ff4 getWebViewManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.q == null) {
                this.q = new ff4(this.a);
            }
            return this.q;
        }
        return (ff4) invokeV.objValue;
    }

    @JavascriptInterface
    public void hideKeyboard() {
        z84 z84Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (z84Var = this.g) != null) {
            z84Var.k(null);
        }
    }

    @JavascriptInterface
    public void reload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            reload(null);
        }
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            showAddToDesktopGuide(null);
        }
    }

    @JavascriptInterface
    public void showKeyboard() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            if (this.g == null) {
                this.g = new z84(this.a, this.h);
            }
            this.g.l(null);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        z84 z84Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048635, this) == null) && (z84Var = this.g) != null) {
            z84Var.m(null);
        }
    }

    @NonNull
    public final kc4 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            if (this.i == null) {
                this.i = new kc4(this.a);
            }
            return this.i;
        }
        return (kc4) invokeV.objValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            this.h = new a94(this.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o54(ri2 ri2Var) {
        super(ri2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ri2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.domain = "main";
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.a = ri2Var;
        this.env = new en2();
        x();
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jsObject) == null) {
            if (u) {
                this.a.w().b("exit from java side.");
            }
            if (jsObject == null) {
                return;
            }
            q54 q54Var = new q54();
            p54 e = p54.e(o32.F(jsObject));
            SwanAppActivity activity = uw2.T().getActivity();
            if (activity == null) {
                q54Var.errMsg = String.format("%s:%s", "exit", "failed");
                e.b(q54Var);
                return;
            }
            q54Var.errMsg = String.format("%s:%s", "exit", DnsModel.MSG_OK);
            e.d(q54Var);
            activity.finishAndRemoveTask();
        }
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) {
            t64.b(jsObject);
        }
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            if (this.d == null) {
                this.d = new oa4(this.a);
            }
            this.d.checkIsUserAdvisedToRest(jsObject);
        }
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            w().h(jsObject);
        }
    }

    @JavascriptInterface
    public ga4 connectSocket(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jsObject)) == null) {
            if (this.l == null) {
                this.l = new ea4(this.a);
            }
            return this.l.a(jsObject);
        }
        return (ga4) invokeL.objValue;
    }

    @JavascriptInterface
    public k44 createBannerAd(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            return new h44(this.a, jsObject);
        }
        return (k44) invokeL.objValue;
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject)) == null) {
            return new RecommendButtonApiProxy(this.a, jsObject);
        }
        return (RecommendButtonApiProxy) invokeL.objValue;
    }

    @JavascriptInterface
    public m44 createRewardedVideoAd(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, jsObject)) == null) {
            if (this.k == null) {
                this.k = new p44(this.a, jsObject);
            }
            return this.k;
        }
        return (m44) invokeL.objValue;
    }

    @JavascriptInterface
    public he4 createUserInfoButton(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, jsObject)) == null) {
            return new he4(jsObject, this.a);
        }
        return (he4) invokeL.objValue;
    }

    @JavascriptInterface
    public void exitVoIPChat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jsObject) == null) {
            if (this.t == null) {
                this.t = xa4.a.a();
            }
            this.t.d(jsObject);
        }
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            if (u) {
                if (g73.p()) {
                    return SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i);
                }
                return "";
            }
            return SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i);
        }
        return (String) invokeI.objValue;
    }

    @JavascriptInterface
    public k64 getDownloadApp(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, jsObject)) == null) {
            if (this.s == null) {
                this.s = new k64(this.a, o32.F(jsObject));
            }
            return this.s;
        }
        return (k64) invokeL.objValue;
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, jsObject) == null) {
            w().k(jsObject);
        }
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, jsObject) == null) {
            w().l(jsObject);
        }
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            return rc4.a(this.a, "getStorageSync", str, w().c(str));
        }
        return invokeL.objValue;
    }

    @JavascriptInterface
    public void getSwanGameDuration(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, jsObject) == null) {
            o64.a(jsObject);
        }
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, jsObject) == null) {
            yd4.d(jsObject);
        }
    }

    @JavascriptInterface
    public qd4 getUpdateManager(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, jsObject)) == null) {
            if (this.j == null) {
                this.j = new qd4(jsObject);
            }
            return this.j;
        }
        return (qd4) invokeL.objValue;
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        z84 z84Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, jsObject) == null) && (z84Var = this.g) != null) {
            z84Var.k(jsObject);
        }
    }

    @JavascriptInterface
    public void joinVoIPChat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) {
            if (this.t == null) {
                this.t = xa4.a.a();
            }
            this.t.b(jsObject);
        }
    }

    @JavascriptInterface
    public wc4 loadSubpackage(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, jsObject)) == null) {
            wc4 wc4Var = new wc4(this.a);
            wc4Var.D(jsObject);
            return wc4Var;
        }
        return (wc4) invokeL.objValue;
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        vs1 F;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048611, this, jsObject) == null) && (F = uw2.T().F()) != null) {
            F.a(o32.F(jsObject));
        }
    }

    @JavascriptInterface
    public void offVoIPChatInterrupted(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, jsObject) == null) {
            if (this.t == null) {
                this.t = xa4.a.a();
            }
            this.t.a(jsObject);
        }
    }

    @JavascriptInterface
    public void offVoIPChatMembersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, jsObject) == null) {
            if (this.t == null) {
                this.t = xa4.a.a();
            }
            this.t.g(jsObject);
        }
    }

    @JavascriptInterface
    public void offVoIPChatSpeakersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, jsObject) == null) {
            if (this.t == null) {
                this.t = xa4.a.a();
            }
            this.t.i(jsObject);
        }
    }

    @JavascriptInterface
    public void onVoIPChatInterrupted(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, jsObject) == null) {
            if (this.t == null) {
                this.t = xa4.a.a();
            }
            this.t.c(jsObject);
        }
    }

    @JavascriptInterface
    public void onVoIPChatMembersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, jsObject) == null) {
            if (this.t == null) {
                this.t = xa4.a.a();
            }
            this.t.h(jsObject);
        }
    }

    @JavascriptInterface
    public void onVoIPChatSpeakersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, jsObject) == null) {
            if (this.t == null) {
                this.t = xa4.a.a();
            }
            this.t.k(jsObject);
        }
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, jsObject) == null) {
            g64.a((o54) this.a.m(), jsObject);
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, jsObject) == null) {
            if (this.p == null) {
                this.p = new ya4();
            }
            this.p.d(jsObject);
        }
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, jsObject) == null) {
            w().o(jsObject);
        }
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            rc4.a(this.a, "removeStorageSync", str, w().e(str));
        }
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, jsObject) == null) {
            if (this.m == null) {
                this.m = new a64(this.a);
            }
            this.m.i(jsObject);
        }
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, jsObject) == null) {
            new f54(jsObject);
        }
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Short.valueOf(s)}) == null) && s >= 1 && s <= 60) {
            this.a.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, jsObject) == null) {
            w().p(jsObject);
        }
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            rc4.a(this.a, "setStorageSync", str, w().f(str, null));
        }
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, jsObject) == null) {
            new tb4(jsObject).m();
        }
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, jsObject) == null) {
            if (this.o == null) {
                this.o = new DesktopGuideApi(this.a);
            }
            this.o.v(jsObject);
        }
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, jsObject) == null) {
            if (this.g == null) {
                this.g = new z84(this.a, this.h);
            }
            this.g.l(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        z84 z84Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, jsObject) == null) && (z84Var = this.g) != null) {
            z84Var.m(jsObject);
        }
    }

    @JavascriptInterface
    public void updateVoIPChatMuteConfig(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, jsObject) == null) {
            if (this.t == null) {
                this.t = xa4.a.a();
            }
            this.t.e(jsObject);
        }
    }

    @JavascriptInterface
    public ca4 uploadFile(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, jsObject)) == null) {
            ca4 ca4Var = new ca4(this.a, o32.F(jsObject));
            ca4Var.start();
            return ca4Var;
        }
        return (ca4) invokeL.objValue;
    }

    public void y(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, jsObject) == null) {
            this.e = jsObject;
        }
    }

    @JavascriptInterface
    public r94 downloadFile(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, jsObject)) == null) {
            o32 F = o32.F(jsObject);
            n94 d = v94.b().d(this.a, F, 2);
            if (d instanceof r94) {
                r94 r94Var = (r94) d;
                r94Var.G(F);
                return r94Var;
            }
            r94 r94Var2 = new r94(this.a, F);
            r94Var2.start();
            return r94Var2;
        }
        return (r94) invokeL.objValue;
    }

    @JavascriptInterface
    public y94 request(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, jsObject)) == null) {
            o32 F = o32.F(jsObject);
            n94 d = v94.b().d(this.a, F, 1);
            if (d instanceof y94) {
                y94 y94Var = (y94) d;
                y94Var.G(F);
                return y94Var;
            }
            y94 y94Var2 = new y94(this.a, F);
            y94Var2.start();
            return y94Var2;
        }
        return (y94) invokeL.objValue;
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048629, this, str, jsSerializeValue) == null) {
            rc4.a(this.a, "setStorageSync", str, w().f(str, jsSerializeValue));
        }
    }
}
