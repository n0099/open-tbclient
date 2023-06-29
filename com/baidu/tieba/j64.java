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
/* loaded from: classes6.dex */
public final class j64 extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean u;
    public transient /* synthetic */ FieldHolder $fh;
    public mj2 a;
    public do2 b;
    public lb4 c;
    public jb4 d;
    @V8JavascriptField
    public final String domain;
    public JsObject e;
    @V8JavascriptField
    public zn2 env;
    public mb4 f;
    public u94 g;
    public v94 h;
    public fd4 i;
    public le4 j;
    public h54 k;
    public za4 l;
    public v64 m;
    public xb4 n;
    public DesktopGuideApi o;
    public tb4 p;
    public ag4 q;
    public n54 r;
    public f74 s;
    public rb4 t;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947835233, "Lcom/baidu/tieba/j64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947835233, "Lcom/baidu/tieba/j64;");
                return;
            }
        }
        u = ms1.a;
    }

    @JavascriptInterface
    public void clearStorageSync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            md4.a(this.a, "clearStorageSync", "", x().a());
        }
    }

    @JavascriptInterface
    public z54 createInnerAudioContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return new z54(this.a);
        }
        return (z54) invokeV.objValue;
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
    public de4 createUDPSocket() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return ge4.c.b(this.a);
        }
        return (de4) invokeV.objValue;
    }

    @JavascriptInterface
    public n54 getAntiAddiction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.r == null) {
                this.r = new n54(this.a);
            }
            return this.r;
        }
        return (n54) invokeV.objValue;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return mw2.a(this.a);
        }
        return (String) invokeV.objValue;
    }

    @JavascriptInterface
    public do2 getFileSystemManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.b == null) {
                this.b = new do2((kj2) this.a);
            }
            return this.b;
        }
        return (do2) invokeV.objValue;
    }

    @JavascriptInterface
    public lb4 getOpenData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.c == null) {
                this.c = new lb4((kj2) this.a);
            }
            return this.c;
        }
        return (lb4) invokeV.objValue;
    }

    @JavascriptInterface
    public mb4 getOpenDataContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.f == null) {
                mb4 mb4Var = new mb4(this.a);
                this.f = mb4Var;
                mb4Var.canvas = this.e;
                this.e = null;
            }
            return this.f;
        }
        return (mb4) invokeV.objValue;
    }

    @JavascriptInterface
    public ld4 getStorageInfoSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return x().b();
        }
        return (ld4) invokeV.objValue;
    }

    @JavascriptInterface
    public xb4 getVideoRecorderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.n == null) {
                this.n = new xb4(this.a);
            }
            return this.n;
        }
        return (xb4) invokeV.objValue;
    }

    @JavascriptInterface
    public ag4 getWebViewManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.q == null) {
                this.q = new ag4(this.a);
            }
            return this.q;
        }
        return (ag4) invokeV.objValue;
    }

    @JavascriptInterface
    public void hideKeyboard() {
        u94 u94Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (u94Var = this.g) != null) {
            u94Var.k(null);
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
                this.g = new u94(this.a, this.h);
            }
            this.g.l(null);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        u94 u94Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048635, this) == null) && (u94Var = this.g) != null) {
            u94Var.m(null);
        }
    }

    @NonNull
    public final fd4 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            if (this.i == null) {
                this.i = new fd4(this.a);
            }
            return this.i;
        }
        return (fd4) invokeV.objValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            this.h = new v94(this.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j64(mj2 mj2Var) {
        super(mj2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mj2Var};
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
        this.a = mj2Var;
        this.env = new zn2();
        y();
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
            l64 l64Var = new l64();
            k64 e = k64.e(j42.F(jsObject));
            SwanAppActivity activity = px2.T().getActivity();
            if (activity == null) {
                l64Var.errMsg = String.format("%s:%s", "exit", "failed");
                e.b(l64Var);
                return;
            }
            l64Var.errMsg = String.format("%s:%s", "exit", DnsModel.MSG_OK);
            e.d(l64Var);
            activity.finishAndRemoveTask();
        }
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) {
            o74.b(jsObject);
        }
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            if (this.d == null) {
                this.d = new jb4(this.a);
            }
            this.d.checkIsUserAdvisedToRest(jsObject);
        }
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            x().h(jsObject);
        }
    }

    @JavascriptInterface
    public bb4 connectSocket(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jsObject)) == null) {
            if (this.l == null) {
                this.l = new za4(this.a);
            }
            return this.l.a(jsObject);
        }
        return (bb4) invokeL.objValue;
    }

    @JavascriptInterface
    public f54 createBannerAd(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            return new c54(this.a, jsObject);
        }
        return (f54) invokeL.objValue;
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
    public h54 createRewardedVideoAd(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, jsObject)) == null) {
            if (this.k == null) {
                this.k = new k54(this.a, jsObject);
            }
            return this.k;
        }
        return (h54) invokeL.objValue;
    }

    @JavascriptInterface
    public cf4 createUserInfoButton(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, jsObject)) == null) {
            return new cf4(jsObject, this.a);
        }
        return (cf4) invokeL.objValue;
    }

    @JavascriptInterface
    public void exitVoIPChat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jsObject) == null) {
            if (this.t == null) {
                this.t = sb4.a.a();
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
                if (b83.p()) {
                    return SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i);
                }
                return "";
            }
            return SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i);
        }
        return (String) invokeI.objValue;
    }

    @JavascriptInterface
    public f74 getDownloadApp(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, jsObject)) == null) {
            if (this.s == null) {
                this.s = new f74(this.a, j42.F(jsObject));
            }
            return this.s;
        }
        return (f74) invokeL.objValue;
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, jsObject) == null) {
            x().k(jsObject);
        }
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, jsObject) == null) {
            x().l(jsObject);
        }
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            return md4.a(this.a, "getStorageSync", str, x().c(str));
        }
        return invokeL.objValue;
    }

    @JavascriptInterface
    public void getSwanGameDuration(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, jsObject) == null) {
            j74.a(jsObject);
        }
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, jsObject) == null) {
            te4.d(jsObject);
        }
    }

    @JavascriptInterface
    public le4 getUpdateManager(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, jsObject)) == null) {
            if (this.j == null) {
                this.j = new le4(jsObject);
            }
            return this.j;
        }
        return (le4) invokeL.objValue;
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        u94 u94Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, jsObject) == null) && (u94Var = this.g) != null) {
            u94Var.k(jsObject);
        }
    }

    @JavascriptInterface
    public void joinVoIPChat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) {
            if (this.t == null) {
                this.t = sb4.a.a();
            }
            this.t.b(jsObject);
        }
    }

    @JavascriptInterface
    public rd4 loadSubpackage(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, jsObject)) == null) {
            rd4 rd4Var = new rd4(this.a);
            rd4Var.E(jsObject);
            return rd4Var;
        }
        return (rd4) invokeL.objValue;
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        qt1 F;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048611, this, jsObject) == null) && (F = px2.T().F()) != null) {
            F.a(j42.F(jsObject));
        }
    }

    @JavascriptInterface
    public void offVoIPChatInterrupted(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, jsObject) == null) {
            if (this.t == null) {
                this.t = sb4.a.a();
            }
            this.t.a(jsObject);
        }
    }

    @JavascriptInterface
    public void offVoIPChatMembersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, jsObject) == null) {
            if (this.t == null) {
                this.t = sb4.a.a();
            }
            this.t.g(jsObject);
        }
    }

    @JavascriptInterface
    public void offVoIPChatSpeakersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, jsObject) == null) {
            if (this.t == null) {
                this.t = sb4.a.a();
            }
            this.t.i(jsObject);
        }
    }

    @JavascriptInterface
    public void onVoIPChatInterrupted(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, jsObject) == null) {
            if (this.t == null) {
                this.t = sb4.a.a();
            }
            this.t.c(jsObject);
        }
    }

    @JavascriptInterface
    public void onVoIPChatMembersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, jsObject) == null) {
            if (this.t == null) {
                this.t = sb4.a.a();
            }
            this.t.h(jsObject);
        }
    }

    @JavascriptInterface
    public void onVoIPChatSpeakersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, jsObject) == null) {
            if (this.t == null) {
                this.t = sb4.a.a();
            }
            this.t.k(jsObject);
        }
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, jsObject) == null) {
            b74.a((j64) this.a.m(), jsObject);
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, jsObject) == null) {
            if (this.p == null) {
                this.p = new tb4();
            }
            this.p.d(jsObject);
        }
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, jsObject) == null) {
            x().o(jsObject);
        }
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            md4.a(this.a, "removeStorageSync", str, x().e(str));
        }
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, jsObject) == null) {
            if (this.m == null) {
                this.m = new v64(this.a);
            }
            this.m.i(jsObject);
        }
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, jsObject) == null) {
            new a64(jsObject);
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
            x().p(jsObject);
        }
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            md4.a(this.a, "setStorageSync", str, x().f(str, null));
        }
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, jsObject) == null) {
            new oc4(jsObject).m();
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
                this.g = new u94(this.a, this.h);
            }
            this.g.l(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        u94 u94Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, jsObject) == null) && (u94Var = this.g) != null) {
            u94Var.m(jsObject);
        }
    }

    @JavascriptInterface
    public void updateVoIPChatMuteConfig(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, jsObject) == null) {
            if (this.t == null) {
                this.t = sb4.a.a();
            }
            this.t.e(jsObject);
        }
    }

    @JavascriptInterface
    public xa4 uploadFile(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, jsObject)) == null) {
            xa4 xa4Var = new xa4(this.a, j42.F(jsObject));
            xa4Var.start();
            return xa4Var;
        }
        return (xa4) invokeL.objValue;
    }

    public void z(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, jsObject) == null) {
            this.e = jsObject;
        }
    }

    @JavascriptInterface
    public ma4 downloadFile(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, jsObject)) == null) {
            j42 F = j42.F(jsObject);
            ia4 d = qa4.b().d(this.a, F, 2);
            if (d instanceof ma4) {
                ma4 ma4Var = (ma4) d;
                ma4Var.H(F);
                return ma4Var;
            }
            ma4 ma4Var2 = new ma4(this.a, F);
            ma4Var2.start();
            return ma4Var2;
        }
        return (ma4) invokeL.objValue;
    }

    @JavascriptInterface
    public ta4 request(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, jsObject)) == null) {
            j42 F = j42.F(jsObject);
            ia4 d = qa4.b().d(this.a, F, 1);
            if (d instanceof ta4) {
                ta4 ta4Var = (ta4) d;
                ta4Var.H(F);
                return ta4Var;
            }
            ta4 ta4Var2 = new ta4(this.a, F);
            ta4Var2.start();
            return ta4Var2;
        }
        return (ta4) invokeL.objValue;
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048629, this, str, jsSerializeValue) == null) {
            md4.a(this.a, "setStorageSync", str, x().f(str, jsSerializeValue));
        }
    }
}
