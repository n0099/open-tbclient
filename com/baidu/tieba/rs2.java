package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.swan.apps.media.audio.SwanAppAudioClient;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.mq2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class rs2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public static vb3 j;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppAudioClient a;
    public Context b;
    public ps2 c;
    public vs2 d;
    public int e;
    public int f;
    public boolean g;
    @Nullable
    public xq2 h;

    /* loaded from: classes8.dex */
    public class a extends xq2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rs2 a;

        public a(rs2 rs2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rs2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rs2Var;
        }

        @Override // com.baidu.tieba.xq2, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, activity) != null) {
                return;
            }
            this.a.g = false;
            if (this.a.x()) {
                return;
            }
            this.a.p();
        }

        @Override // com.baidu.tieba.xq2, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) != null) {
                return;
            }
            this.a.g = true;
            if (this.a.w()) {
                if (!this.a.x()) {
                    if (rs2.j != null) {
                        return;
                    }
                    vb3 unused = rs2.j = ic3.c("1044");
                    return;
                }
                vb3 unused2 = rs2.j = null;
                return;
            }
            super.onActivityStopped(activity);
            this.a.L();
            p22.o("SwanAppBGAudioPlayer", "stop player without requiredBackgroundModes");
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ik3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rs2 a;

        public b(rs2 rs2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rs2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rs2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    this.a.v().w(this.a.c.c(str), str);
                } else if (TextUtils.isEmpty(str)) {
                    vc3.b("audio", 3001, "cloud url is null", -1, "");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements SwanAppAudioClient.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ rs2 b;

        public c(rs2 rs2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rs2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rs2Var;
        }

        public /* synthetic */ c(rs2 rs2Var, a aVar) {
            this(rs2Var);
        }

        @Override // com.baidu.swan.apps.media.audio.SwanAppAudioClient.c
        public boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i = message.what;
                int i2 = message.arg1;
                int i3 = message.arg2;
                JSONObject jSONObject = new JSONObject();
                this.b.H(message, i3, this.b.u() / 1000);
                switch (i) {
                    case 1001:
                        ss2.b("SwanAppBGAudioPlayer", "#onHandleMessage [onCanPlay]");
                        p22.i("backgroundAudio", "event onCanPlay");
                        if (this.b.d != null) {
                            this.b.d.a("onCanplay");
                        }
                        this.a = true;
                        return true;
                    case 1002:
                        ss2.b("SwanAppBGAudioPlayer", "#onHandleMessage [onPlay]");
                        p22.i("backgroundAudio", "event onPlay");
                        if (this.b.d != null) {
                            this.b.d.a("onPlay");
                        }
                        if (this.b.g) {
                            vb3 unused = rs2.j = ic3.c("1044");
                        }
                        return true;
                    case 1003:
                        ss2.b("SwanAppBGAudioPlayer", "#onHandleMessage [onPause]");
                        p22.i("backgroundAudio", "event onPause");
                        if (this.b.d != null) {
                            this.b.d.a(MissionEvent.MESSAGE_PAUSE);
                        }
                        if (this.b.g) {
                            this.b.p();
                        }
                        return true;
                    case 1004:
                        ss2.b("SwanAppBGAudioPlayer", "#onHandleMessage [onStop]");
                        p22.i("backgroundAudio", "event onStop");
                        if (this.b.d != null) {
                            this.b.d.a(MissionEvent.MESSAGE_STOP);
                        }
                        this.a = true;
                        if (this.b.g) {
                            this.b.p();
                        }
                        return true;
                    case 1005:
                        p22.i("backgroundAudio", "event onEnd");
                        if (this.b.d != null) {
                            this.b.d.a("onEnded");
                        }
                        if (this.b.g) {
                            this.b.p();
                        }
                        return true;
                    case 1006:
                        this.b.e = i3;
                        try {
                            jSONObject.putOpt("currentTime", Integer.valueOf(this.b.r()));
                            jSONObject.putOpt("duration", Integer.valueOf(this.b.u() / 1000));
                        } catch (JSONException e) {
                            if (rs2.i) {
                                e.printStackTrace();
                            }
                        }
                        p22.i("backgroundAudio", "event onTimeUpdate " + jSONObject.toString());
                        if (this.b.d != null) {
                            this.b.d.b("onTimeUpdate", jSONObject);
                        }
                        if (this.a) {
                            if (this.b.c.k > 0) {
                                rs2 rs2Var = this.b;
                                rs2Var.G(rs2Var.c.k);
                            }
                            this.a = false;
                        }
                        return true;
                    case 1007:
                        try {
                            vc3.b("audio", 4000, "audio fail, src: " + this.b.v().r(), i2, "");
                            jSONObject.putOpt(StatConstants.KEY_EXT_ERR_CODE, Integer.valueOf(i2));
                        } catch (JSONException e2) {
                            if (rs2.i) {
                                e2.printStackTrace();
                            }
                        }
                        p22.i("backgroundAudio", "event onError code:" + i2);
                        if (this.b.d != null) {
                            this.b.d.b(GameAssistConstKt.TYPE_CALLBACK_ERROR, jSONObject);
                        }
                        return true;
                    case 1008:
                        int s = this.b.s();
                        this.b.f = i2;
                        p22.i("backgroundAudio", "event onDownloadProgress " + this.b.f);
                        if (this.b.d != null && s >= this.b.f) {
                            this.b.d.a("onWaiting");
                        }
                        return true;
                    case 1009:
                        p22.i("backgroundAudio", "event onPrev");
                        if (this.b.d != null) {
                            this.b.d.a("onPrev");
                        }
                        return true;
                    case 1010:
                        p22.i("backgroundAudio", "event onNext");
                        if (this.b.d != null) {
                            this.b.d.a("onNext");
                        }
                        return true;
                    case 1011:
                        p22.i("backgroundAudio", "event onSeekEnd");
                        if (this.b.d != null) {
                            this.b.d.a("onSeeked");
                        }
                        return true;
                    case 1012:
                        p22.i("backgroundAudio", "event onSeeking");
                        if (this.b.d != null) {
                            this.b.d.a("onSeeking");
                        }
                        return true;
                    default:
                        return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948132120, "Lcom/baidu/tieba/rs2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948132120, "Lcom/baidu/tieba/rs2;");
                return;
            }
        }
        i = am1.a;
    }

    public void A() {
        SwanAppAudioClient swanAppAudioClient;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (swanAppAudioClient = this.a) != null) {
            swanAppAudioClient.v();
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            p22.i("backgroundAudio", "release ");
            if (this.a != null && !w()) {
                this.a.x();
                I("#release");
                this.a = null;
                j = null;
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (i) {
                Log.d("SwanAppBGAudioPlayer", "play");
            }
            SwanAppAudioClient swanAppAudioClient = this.a;
            if (swanAppAudioClient != null) {
                swanAppAudioClient.z();
            }
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.h != null) {
                wo2.c().unregisterActivityLifecycleCallbacks(this.h);
            }
            this.h = new a(this);
            wo2.c().registerActivityLifecycleCallbacks(this.h);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            SwanAppAudioClient swanAppAudioClient = this.a;
            if (swanAppAudioClient != null) {
                swanAppAudioClient.D();
            }
            if (this.h != null) {
                wo2.c().unregisterActivityLifecycleCallbacks(this.h);
                this.h = null;
            }
        }
    }

    public ps2 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.c;
        }
        return (ps2) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public final int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            int u = u();
            if (u <= 0) {
                return 0;
            }
            return (int) ((r() / u) * 100.0f);
        }
        return invokeV.intValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            SwanAppAudioClient swanAppAudioClient = this.a;
            if (swanAppAudioClient != null) {
                return swanAppAudioClient.s();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final SwanAppAudioClient v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.a == null) {
                this.a = new SwanAppAudioClient(this.b);
                this.a.B(new c(this, null));
            }
            return this.a;
        }
        return (SwanAppAudioClient) invokeV.objValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            SwanAppAudioClient swanAppAudioClient = this.a;
            if (swanAppAudioClient == null) {
                return true;
            }
            return !swanAppAudioClient.t();
        }
        return invokeV.booleanValue;
    }

    public rs2(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new ps2();
        this.e = 0;
        this.f = 0;
        this.b = context;
    }

    public void G(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048582, this, i2) != null) || i2 < 0) {
            return;
        }
        SwanAppAudioClient swanAppAudioClient = this.a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.A(i2 * 1000);
        }
        p22.i("backgroundAudio", "seekTo " + i2);
        vs2 vs2Var = this.d;
        if (vs2Var != null) {
            vs2Var.a("onSeeking");
        }
    }

    public void M(ps2 ps2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ps2Var) == null) {
            if (i) {
                Log.d("SwanAppBGAudioPlayer", "Audio Update : " + ps2Var);
            }
            this.c = ps2Var;
            vs2 vs2Var = this.d;
            if (vs2Var != null) {
                vs2Var.d(ps2Var.p);
            }
            B();
        }
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            wo2.l().b(this.b, str, new b(this));
        }
    }

    public final void I(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            ss2.c("SwanAppBGAudioPlayer", "#policyContinueFlag", new Exception(str));
            cr2.V().c();
        }
    }

    public final void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            ss2.c("SwanAppBGAudioPlayer", "#setPolicyStopFlag", new Exception(str));
            cr2.V().q();
        }
    }

    public void y(boolean z) {
        SwanAppAudioClient swanAppAudioClient;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048598, this, z) == null) && (swanAppAudioClient = this.a) != null) {
            swanAppAudioClient.u(z);
            J("#onForegroundChanged foreground=" + z);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (i) {
                Log.d("SwanAppBGAudioPlayer", "play");
            }
            if (this.c.a()) {
                return;
            }
            K();
            String str = this.c.c;
            p53 M = p53.M();
            if (xc3.s(str) == PathType.CLOUD) {
                C(str);
            } else {
                D(str, M);
            }
            J("#play");
        }
    }

    public final boolean w() {
        InterceptResult invokeV;
        SwanAppConfigData swanAppConfigData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (p53.M() != null) {
                swanAppConfigData = p53.M().R();
            } else {
                swanAppConfigData = null;
            }
            if (swanAppConfigData != null && swanAppConfigData.q.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO.mMode)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void D(String str, p53 p53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, p53Var) == null) {
            if (this.c.q && p53Var != null) {
                fn1 m = xo2.m();
                if (this.d.c()) {
                    if (m == null) {
                        str = null;
                    } else {
                        str = m.a(str);
                    }
                } else {
                    str = xc3.H(str, p53Var);
                }
            }
            v().w(this.c.c(str), str);
        }
    }

    public final void H(Message message, int i2, int i3) {
        ps2 ps2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048583, this, message, i2, i3) == null) && (ps2Var = this.c) != null && ps2Var.i) {
            ps2Var.n = i2;
            ps2Var.o = i3;
            wo2.o().x(message, this.c);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (p53.M() != null && p53.M().Z() != null && j != null) {
                mq2.a Z = p53.M().Z();
                sc3 sc3Var = new sc3();
                sc3Var.a = ic3.n(Z.H());
                sc3Var.f = Z.I();
                sc3Var.c = Z.U();
                sc3Var.a("appid", Z.I());
                sc3Var.a("cuid", wo2.h0().i(wo2.c()));
                JSONObject k = ic3.k(Z.X());
                if (k != null) {
                    sc3Var.a("keyfeed", k.optString("keyfeed"));
                }
                ic3.i(j, sc3Var);
            }
            j = null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public Object t(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            switch (str.hashCode()) {
                case -2129294769:
                    if (str.equals("startTime")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1992012396:
                    if (str.equals("duration")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1522036513:
                    if (str.equals("buffered")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1296614986:
                    if (str.equals("epname")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1094703982:
                    if (str.equals("lrcURL")) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -995321554:
                    if (str.equals("paused")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -902265988:
                    if (str.equals("singer")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -453814973:
                    if (str.equals("coverImgUrl")) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 114148:
                    if (str.equals("src")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 110371416:
                    if (str.equals("title")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 601235430:
                    if (str.equals("currentTime")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    return Integer.valueOf(u() / 1000);
                case 1:
                    return Integer.valueOf(this.e);
                case 2:
                    return Boolean.valueOf(x());
                case 3:
                    return this.c.c;
                case 4:
                    return Integer.valueOf(this.c.k);
                case 5:
                    return Integer.valueOf(this.f);
                case 6:
                    return this.c.d;
                case 7:
                    return this.c.e;
                case '\b':
                    return this.c.f;
                case '\t':
                    return this.c.g;
                case '\n':
                    return this.c.h;
                default:
                    return "";
            }
        }
        return invokeL.objValue;
    }

    public void z(ps2 ps2Var, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, ps2Var, callbackHandler) == null) {
            ss2.b("SwanAppBGAudioPlayer", "#openPlayer params=" + ps2Var);
            this.c = ps2Var;
            if (ps2Var.p != null) {
                try {
                    this.d = new vs2(callbackHandler, new JSONObject(this.c.p));
                } catch (JSONException e) {
                    vc3.b("audio", 2009, "open audio fail", -1, "");
                    p22.c("backgroundAudio", e.toString());
                    if (i) {
                        Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                    }
                }
            }
            B();
        }
    }
}
