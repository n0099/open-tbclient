package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompatJellybean;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.parser.JSONLexer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.atomData.TbPreviewVideoActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.sdk.WebChromeClient;
import com.bytedance.JProtect;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.activity.base.TTMiddlePageActivity;
import com.bytedance.sdk.openadsdk.core.e.k;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.google.zxing.maxicode.decoder.DecodedBitStreamParser;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes5.dex */
public class w implements u.a, com.bytedance.sdk.openadsdk.h.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final Map<String, Boolean> f30719f;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public List<com.bytedance.sdk.openadsdk.core.e.m> B;
    public HashMap<String, i> C;
    public boolean D;
    public boolean E;
    public com.bytedance.sdk.openadsdk.e.p F;
    public com.bytedance.sdk.component.a.q G;
    public String H;
    public boolean I;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Object> f30720a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30721b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30722c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<SSWebView> f30723d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.component.utils.u f30724e;

    /* renamed from: g  reason: collision with root package name */
    public WeakReference<Context> f30725g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.h.c f30726h;

    /* renamed from: i  reason: collision with root package name */
    public String f30727i;
    public WeakReference<View> j;
    public String k;
    public int l;
    public String m;
    public com.bytedance.sdk.openadsdk.core.e.m n;
    public boolean o;
    public WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.j> p;
    public WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.g> q;
    public JSONObject r;
    public WeakReference<com.bytedance.sdk.openadsdk.h.d> s;
    public WeakReference<com.bytedance.sdk.openadsdk.j.a> t;
    public WeakReference<com.bytedance.sdk.openadsdk.j.e> u;
    public WeakReference<com.bytedance.sdk.openadsdk.j.d> v;
    public JSONObject w;
    public WeakReference<com.bytedance.sdk.openadsdk.core.b.d> x;
    public WeakReference<com.bytedance.sdk.openadsdk.j.b> y;
    public WeakReference<com.bytedance.sdk.openadsdk.j.h> z;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f30744a;

        /* renamed from: b  reason: collision with root package name */
        public String f30745b;

        /* renamed from: c  reason: collision with root package name */
        public String f30746c;

        /* renamed from: d  reason: collision with root package name */
        public JSONObject f30747d;

        /* renamed from: e  reason: collision with root package name */
        public int f30748e;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(210335199, "Lcom/bytedance/sdk/openadsdk/core/w;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(210335199, "Lcom/bytedance/sdk/openadsdk/core/w;");
                return;
            }
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f30719f = concurrentHashMap;
        concurrentHashMap.put("log_event", Boolean.TRUE);
        f30719f.put(PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE, Boolean.TRUE);
        f30719f.put("dispatch_message", Boolean.TRUE);
        f30719f.put("custom_event", Boolean.TRUE);
        f30719f.put("log_event_v3", Boolean.TRUE);
    }

    public w(Context context) {
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
        this.o = true;
        this.A = true;
        this.D = false;
        this.E = false;
        this.f30722c = false;
        this.I = false;
        this.f30725g = new WeakReference<>(context);
        this.f30724e = new com.bytedance.sdk.component.utils.u(Looper.getMainLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        List<com.bytedance.sdk.openadsdk.core.e.m> list;
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (list = this.B) == null || list.size() <= 0) {
            return;
        }
        this.C = new HashMap<>();
        WeakReference<SSWebView> weakReference = this.f30723d;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        WeakReference<Context> weakReference2 = this.f30725g;
        if (weakReference2 == null || (context = weakReference2.get()) == null) {
            return;
        }
        for (com.bytedance.sdk.openadsdk.core.e.m mVar : this.B) {
            this.C.put(mVar.ak(), new i(context, mVar, sSWebView, this.H));
        }
    }

    private boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            com.bytedance.sdk.openadsdk.core.e.m mVar = this.n;
            if (mVar == null || mVar.aw() == null || com.bytedance.sdk.openadsdk.core.e.o.a(this.n) || this.D || this.n.aw().optInt("parent_type") != 2) {
                return false;
            }
            int c2 = com.bytedance.sdk.openadsdk.r.o.c(this.k);
            if (c2 == 8 || c2 == 7) {
                this.D = true;
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void C() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && this.f30726h == null) {
            this.f30726h = com.bytedance.sdk.openadsdk.h.a.a(this, this.n);
        }
    }

    private void a(a aVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, aVar, jSONObject) == null) || aVar == null) {
            return;
        }
        try {
            a(aVar.f30747d, new com.bytedance.sdk.openadsdk.j.c(this, jSONObject, aVar) { // from class: com.bytedance.sdk.openadsdk.core.w.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ JSONObject f30735a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f30736b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ w f30737c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, jSONObject, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f30737c = this;
                    this.f30735a = jSONObject;
                    this.f30736b = aVar;
                }

                @Override // com.bytedance.sdk.openadsdk.j.c
                public void a(boolean z, List<com.bytedance.sdk.openadsdk.core.e.m> list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z, list) == null) {
                        if (z) {
                            try {
                                this.f30735a.put("creatives", w.b(list));
                                this.f30737c.c(this.f30736b.f30745b, this.f30735a);
                                return;
                            } catch (Exception unused) {
                                return;
                            }
                        }
                        this.f30737c.c(this.f30736b.f30745b, this.f30735a);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    private void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65546, this, str, z) == null) || this.F == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            this.F.a(str);
        } else {
            this.F.b(str);
        }
    }

    private void a(JSONObject jSONObject, int i2) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, this, jSONObject, i2) == null) {
            JSONArray jSONArray = new JSONArray();
            for (String str : v()) {
                jSONArray.put(str);
            }
            jSONObject.put("appName", com.bytedance.sdk.openadsdk.c.a.a());
            jSONObject.put("innerAppName", com.bytedance.sdk.openadsdk.c.a.e());
            jSONObject.put("aid", com.bytedance.sdk.openadsdk.c.a.b());
            jSONObject.put("sdkEdition", com.bytedance.sdk.openadsdk.c.a.c());
            jSONObject.put("appVersion", com.bytedance.sdk.openadsdk.c.a.d());
            jSONObject.put("netType", com.bytedance.sdk.openadsdk.c.a.f());
            jSONObject.put("supportList", jSONArray);
            jSONObject.put("deviceId", com.bytedance.sdk.openadsdk.c.a.a(o.a()));
            jSONObject.put("themeStatus", h.d().A());
        }
    }

    private boolean a(String str, int i2, com.bytedance.sdk.openadsdk.core.e.k kVar) {
        InterceptResult invokeLIL;
        HashMap<String, i> hashMap;
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65548, this, str, i2, kVar)) == null) {
            if (TextUtils.isEmpty(str) || (hashMap = this.C) == null || (iVar = hashMap.get(str)) == null) {
                return false;
            }
            iVar.a(i2, kVar);
            return true;
        }
        return invokeLIL.booleanValue;
    }

    public static JSONArray b(List<com.bytedance.sdk.openadsdk.core.e.m> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, list)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (list == null) {
                return jSONArray;
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                jSONArray.put(list.get(i2).aO());
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, this, str, jSONObject) == null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("__msg_type", "callback");
                jSONObject2.put("__callback_id", str);
                if (jSONObject != null) {
                    jSONObject2.put("__params", jSONObject);
                }
                r(jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    private void d(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, this, str, jSONObject) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("__msg_type", "event");
                jSONObject2.put("__event_id", str);
                if (jSONObject != null) {
                    jSONObject2.put("__params", jSONObject);
                }
                r(jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    private void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, str) == null) {
            try {
                String str2 = new String(Base64.decode(str, 2));
                com.bytedance.sdk.component.utils.j.b("TTAndroidObject", str2);
                JSONArray jSONArray = new JSONArray(str2);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    a aVar = new a();
                    try {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            aVar.f30744a = optJSONObject.optString("__msg_type", null);
                            aVar.f30745b = optJSONObject.optString("__callback_id", null);
                            aVar.f30746c = optJSONObject.optString(WebChromeClient.KEY_FUNCTION_NAME);
                            aVar.f30747d = optJSONObject.optJSONObject("params");
                            aVar.f30748e = optJSONObject.optInt("JSSDK");
                        }
                    } catch (Throwable unused) {
                    }
                    if (!TextUtils.isEmpty(aVar.f30744a) && !TextUtils.isEmpty(aVar.f30746c)) {
                        Message obtainMessage = this.f30724e.obtainMessage(11);
                        obtainMessage.obj = aVar;
                        this.f30724e.sendMessage(obtainMessage);
                    }
                }
            } catch (Exception unused2) {
                com.bytedance.sdk.component.utils.j.d("TTAndroidObject", com.bytedance.sdk.component.utils.j.a() ? "failed to parse jsbridge msg queue " + str : "failed to parse jsbridge msg queue");
            }
        }
    }

    private void e(JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, jSONObject) == null) {
            if (!TextUtils.isEmpty(this.f30727i)) {
                jSONObject.put(IAdRequestParam.CELL_ID, this.f30727i);
            }
            if (!TextUtils.isEmpty(this.k)) {
                jSONObject.put("log_extra", this.k);
            }
            if (TextUtils.isEmpty(this.m)) {
                return;
            }
            jSONObject.put("download_url", this.m);
        }
    }

    private void f(JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, this, jSONObject) == null) || TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.e.o.c(this.n))) {
            return;
        }
        jSONObject.put("playable_style", com.bytedance.sdk.openadsdk.core.e.o.c(this.n));
    }

    private boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, this, str)) == null) ? TextUtils.isEmpty(str) || !"click_other".equals(str) || l() : invokeL.booleanValue;
    }

    private String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, this, str)) == null) ? this.p == null ? com.bytedance.sdk.openadsdk.r.o.a(this.l) : str : (String) invokeL.objValue;
    }

    @MainThread
    private void g(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.e.p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65560, this, jSONObject) == null) || jSONObject == null || (pVar = this.F) == null) {
            return;
        }
        pVar.b(jSONObject);
    }

    private void h(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65561, this, str) == null) && str != null && str.startsWith("bytedance://")) {
            try {
                if (str.equals("bytedance://dispatch_message/")) {
                    WebView t = t();
                    if (t != null) {
                        com.bytedance.sdk.component.utils.i.a(t, "javascript:ToutiaoJSBridge._fetchQueue()");
                    }
                } else if (str.startsWith("bytedance://private/setresult/")) {
                    int indexOf = str.indexOf(38, 30);
                    if (indexOf <= 0) {
                        return;
                    }
                    String substring = str.substring(30, indexOf);
                    String substring2 = str.substring(indexOf + 1);
                    if (substring.equals("SCENE_FETCHQUEUE") && substring2.length() > 0) {
                        e(substring2);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private void h(JSONObject jSONObject) {
        WeakReference<com.bytedance.sdk.openadsdk.j.b> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65562, this, jSONObject) == null) || (weakReference = this.y) == null || jSONObject == null || weakReference.get() == null) {
            return;
        }
        this.y.get().a(jSONObject.optBoolean("isRenderSuc", false), jSONObject.optInt("code", -1), jSONObject.optString("msg", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(JSONObject jSONObject) {
        WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.g> weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65563, this, jSONObject) == null) && (weakReference = this.q) != null && weakReference.get() != null && jSONObject != null) {
            try {
                this.q.get().a(jSONObject.optBoolean("mute", false));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(JSONObject jSONObject) {
        WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.g> weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65564, this, jSONObject) == null) && (weakReference = this.q) != null && weakReference.get() != null && jSONObject != null) {
            try {
                this.q.get().a(jSONObject.optInt("stateType", -1));
            } catch (Exception unused) {
            }
        }
    }

    private boolean k(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, this, jSONObject)) == null) {
            WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.g> weakReference = this.q;
            if (weakReference != null && weakReference.get() != null && jSONObject != null) {
                double c2 = this.q.get().c();
                int d2 = this.q.get().d();
                try {
                    jSONObject.put("currentTime", c2 / 1000.0d);
                    jSONObject.put("state", d2);
                    com.bytedance.sdk.component.utils.j.b("TTAndroidObject", "currentTime,state:" + d2);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Keep
    @JProtect
    public void l(JSONObject jSONObject) {
        w wVar;
        String str;
        int i2;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65566, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        com.bytedance.sdk.component.utils.j.b("TTAndroidObject", "TTAndroidObject handleClickEvent");
        try {
            String optString = jSONObject.optString("adId");
            int optInt = jSONObject.optInt("areaType", 1);
            String optString2 = jSONObject.optString("clickAreaType");
            JSONObject optJSONObject = jSONObject.optJSONObject("clickInfo");
            double d11 = 0.0d;
            if (optJSONObject != null) {
                double optDouble = optJSONObject.optDouble("down_x", 0.0d);
                d5 = optJSONObject.optDouble("down_y", 0.0d);
                d6 = optJSONObject.optDouble("up_x", 0.0d);
                d7 = optJSONObject.optDouble("up_y", 0.0d);
                double optDouble2 = optJSONObject.optDouble("down_time", 0.0d);
                double optDouble3 = optJSONObject.optDouble("up_time", 0.0d);
                double optDouble4 = optJSONObject.optDouble("button_x", 0.0d);
                double optDouble5 = optJSONObject.optDouble("button_y", 0.0d);
                double optDouble6 = optJSONObject.optDouble("button_width", 0.0d);
                str = optString;
                d10 = optJSONObject.optDouble("button_height", 0.0d);
                d4 = optDouble2;
                d11 = optDouble;
                d2 = optDouble3;
                d8 = optDouble5;
                d9 = optDouble6;
                i2 = optInt;
                d3 = optDouble4;
            } else {
                str = optString;
                i2 = optInt;
                d2 = 0.0d;
                d3 = 0.0d;
                d4 = 0.0d;
                d5 = 0.0d;
                d6 = 0.0d;
                d7 = 0.0d;
                d8 = 0.0d;
                d9 = 0.0d;
                d10 = 0.0d;
            }
            try {
                com.bytedance.sdk.openadsdk.core.e.k a2 = new k.a().d((int) d11).c((int) d5).b((int) d6).a((int) d7).b((long) d4).a((long) d2).e((int) d3).f((int) d8).g((int) d9).h((int) d10).a(optString2).a();
                wVar = this;
                int i3 = i2;
                try {
                    if (wVar.a(str, i3, a2) || wVar.p == null || wVar.p.get() == null) {
                        return;
                    }
                    wVar.p.get().a(i3, a2);
                } catch (Exception unused) {
                    WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.j> weakReference = wVar.p;
                    if (weakReference == null || weakReference.get() == null) {
                        return;
                    }
                    wVar.p.get().a(-1, null);
                }
            } catch (Exception unused2) {
                wVar = this;
            }
        } catch (Exception unused3) {
            wVar = this;
        }
    }

    private void m(JSONObject jSONObject) {
        w wVar;
        WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.j> weakReference;
        int i2;
        double d2;
        double d3;
        boolean z;
        double d4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65567, this, jSONObject) == null) || (weakReference = (wVar = this).p) == null || weakReference.get() == null || jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.e.p pVar = new com.bytedance.sdk.openadsdk.core.e.p();
        pVar.a(1);
        try {
            boolean optBoolean = jSONObject.optBoolean("isRenderSuc");
            JSONObject optJSONObject = jSONObject.optJSONObject("AdSize");
            d2 = 0.0d;
            if (optJSONObject != null) {
                d2 = optJSONObject.optDouble("width");
                d3 = optJSONObject.optDouble("height");
            } else {
                d3 = 0.0d;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(TbPreviewVideoActivityConfig.KEY_VIDEO_INFO);
            if (optJSONObject2 != null) {
                try {
                    double optDouble = optJSONObject2.optDouble("x");
                    double optDouble2 = optJSONObject2.optDouble("y");
                    z = optBoolean;
                    double optDouble3 = optJSONObject2.optDouble("width");
                    double optDouble4 = optJSONObject2.optDouble("height");
                    if (wVar.n(optJSONObject2)) {
                        d4 = d3;
                        pVar.a((float) optJSONObject2.optDouble("borderRadiusTopLeft"));
                        pVar.b((float) optJSONObject2.optDouble("borderRadiusTopRight"));
                        pVar.c((float) optJSONObject2.optDouble("borderRadiusBottomLeft"));
                        pVar.d((float) optJSONObject2.optDouble("borderRadiusBottomRight"));
                    } else {
                        d4 = d3;
                    }
                    pVar.c(optDouble);
                    pVar.d(optDouble2);
                    pVar.e(optDouble3);
                    pVar.f(optDouble4);
                } catch (Exception unused) {
                    i2 = 101;
                    wVar = this;
                    pVar.b(i2);
                    pVar.a(g.a(i2));
                    wVar.p.get().a(pVar);
                }
            } else {
                z = optBoolean;
                d4 = d3;
            }
        } catch (Exception unused2) {
        }
        try {
            String optString = jSONObject.optString("message", g.a(101));
            int optInt = jSONObject.optInt("code", 101);
            pVar.a(z);
            pVar.a(d2);
            pVar.b(d4);
            pVar.a(optString);
            pVar.b(optInt);
            wVar = this;
            wVar.p.get().a(pVar);
        } catch (Exception unused3) {
            wVar = this;
            i2 = 101;
            pVar.b(i2);
            pVar.a(g.a(i2));
            wVar.p.get().a(pVar);
        }
    }

    private boolean n(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65568, this, jSONObject)) == null) ? jSONObject.has("borderRadiusTopLeft") && jSONObject.has("borderRadiusBottomLeft") && jSONObject.has("borderRadiusTopRight") && jSONObject.has("borderRadiusBottomRight") : invokeL.booleanValue;
    }

    private void o(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65569, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        com.bytedance.sdk.component.utils.j.b("TTAndroidObject", "TTAndroidObject handlerDynamicTrack");
        try {
            Uri parse = Uri.parse(jSONObject.optString("trackData"));
            if ("bytedance".equals(parse.getScheme().toLowerCase())) {
                com.bytedance.sdk.openadsdk.r.h.a(parse, this);
            }
        } catch (Exception unused) {
        }
    }

    private void p(JSONObject jSONObject) {
        WeakReference<com.bytedance.sdk.openadsdk.h.d> weakReference;
        com.bytedance.sdk.openadsdk.h.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65570, this, jSONObject) == null) || jSONObject == null || (weakReference = this.s) == null || (dVar = weakReference.get()) == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("temaiProductIds");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                dVar.a(false, null);
            } else {
                dVar.a(true, optJSONArray);
            }
        } catch (Exception unused) {
            dVar.a(false, null);
        }
    }

    private boolean q(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, this, jSONObject)) == null) {
            try {
                jSONObject.put("creatives", b(this.B));
            } catch (Exception unused) {
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private void r(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65572, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            s(jSONObject);
        } else {
            l.d().post(new Runnable(this, jSONObject) { // from class: com.bytedance.sdk.openadsdk.core.w.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ JSONObject f30742a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ w f30743b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, jSONObject};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f30743b = this;
                    this.f30742a = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f30743b.s(this.f30742a);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(JSONObject jSONObject) {
        WebView t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65573, this, jSONObject) == null) || (t = t()) == null) {
            return;
        }
        String str = "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + jSONObject.toString() + SmallTailInfo.EMOTION_SUFFIX;
        com.bytedance.sdk.component.utils.i.a(t, str);
        if (com.bytedance.sdk.component.utils.j.a()) {
            com.bytedance.sdk.component.utils.j.a("TTAndroidObject", "js_msg " + str);
        }
    }

    private WebView t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, this)) == null) {
            WeakReference<SSWebView> weakReference = this.f30723d;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (WebView) invokeV.objValue;
    }

    private JSONObject t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, this, jSONObject)) == null) {
            if (this.f30720a != null) {
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    String optString = jSONObject.optString("ad_extra_data", null);
                    if (optString != null) {
                        jSONObject2 = new JSONObject(optString);
                    }
                    for (Map.Entry<String, Object> entry : this.f30720a.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Exception e2) {
                    com.bytedance.sdk.component.utils.j.b(e2.toString());
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    private JSONObject u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, this)) == null) {
            try {
                View view = this.j.get();
                SSWebView sSWebView = this.f30723d.get();
                if (view != null && sSWebView != null) {
                    int[] b2 = com.bytedance.sdk.openadsdk.r.q.b(view);
                    int[] b3 = com.bytedance.sdk.openadsdk.r.q.b((View) sSWebView);
                    if (b2 != null && b3 != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("x", com.bytedance.sdk.openadsdk.r.q.c(o.a(), b2[0] - b3[0]));
                        jSONObject.put("y", com.bytedance.sdk.openadsdk.r.q.c(o.a(), b2[1] - b3[1]));
                        jSONObject.put("w", com.bytedance.sdk.openadsdk.r.q.c(o.a(), view.getWidth()));
                        jSONObject.put("h", com.bytedance.sdk.openadsdk.r.q.c(o.a(), view.getHeight()));
                        jSONObject.put("isExist", true);
                        return jSONObject;
                    }
                    com.bytedance.sdk.component.utils.j.f("TTAndroidObject", "setCloseButtonInfo error position or webViewPosition is null");
                    return null;
                }
                com.bytedance.sdk.component.utils.j.f("TTAndroidObject", "setCloseButtonInfo error closeButton is null");
                return null;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.j.a("TTAndroidObject", "setCloseButtonInfo error", th);
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    private List<String> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65577, this)) == null) ? Arrays.asList(DI.APP_INFO_NAME, "adInfo", "getTemplateInfo", "getTeMaiAds") : (List) invokeV.objValue;
    }

    private void w() {
        WeakReference<com.bytedance.sdk.openadsdk.j.h> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65578, this) == null) || (weakReference = this.z) == null || weakReference.get() == null) {
            return;
        }
        this.z.get().a();
    }

    private void x() {
        WeakReference<com.bytedance.sdk.openadsdk.j.h> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65579, this) == null) || (weakReference = this.z) == null || weakReference.get() == null) {
            return;
        }
        this.z.get().b();
    }

    private void y() {
        WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.g> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65580, this) == null) || (weakReference = this.q) == null || weakReference.get() == null) {
            return;
        }
        this.q.get().a();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0082 A[Catch: Exception -> 0x008e, TryCatch #0 {Exception -> 0x008e, blocks: (B:6:0x000f, B:11:0x0043, B:13:0x0054, B:15:0x006e, B:19:0x0079, B:21:0x0082, B:22:0x0088, B:12:0x004c), top: B:29:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONObject z() {
        InterceptResult invokeV;
        boolean c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65581, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (o.h() != null) {
                try {
                    int d2 = com.bytedance.sdk.openadsdk.r.o.d(this.k);
                    int c3 = com.bytedance.sdk.openadsdk.r.o.c(this.k);
                    int g2 = o.h().g(String.valueOf(d2));
                    int h2 = o.h().h(d2);
                    boolean b2 = o.h().b(String.valueOf(d2));
                    if (c3 != 7 && c3 != 8) {
                        c2 = o.h().b(d2);
                        jSONObject.put("voice_control", c2);
                        jSONObject.put("rv_skip_time", g2);
                        jSONObject.put("fv_skip_show", b2);
                        jSONObject.put("iv_skip_time", h2);
                        jSONObject.put("show_dislike", this.n == null && this.n.aM());
                        jSONObject.put("video_adaptation", this.n != null ? this.n.i() : 0);
                    }
                    c2 = o.h().c(d2);
                    jSONObject.put("voice_control", c2);
                    jSONObject.put("rv_skip_time", g2);
                    jSONObject.put("fv_skip_show", b2);
                    jSONObject.put("iv_skip_time", h2);
                    jSONObject.put("show_dislike", this.n == null && this.n.aM());
                    jSONObject.put("video_adaptation", this.n != null ? this.n.i() : 0);
                } catch (Exception unused) {
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public w a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            this.l = i2;
            return this;
        }
        return (w) invokeI.objValue;
    }

    public w a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
            this.j = new WeakReference<>(view);
            return this;
        }
        return (w) invokeL.objValue;
    }

    public w a(com.bytedance.sdk.openadsdk.core.b.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) {
            this.x = new WeakReference<>(dVar);
            return this;
        }
        return (w) invokeL.objValue;
    }

    public w a(com.bytedance.sdk.openadsdk.core.e.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mVar)) == null) {
            this.n = mVar;
            return this;
        }
        return (w) invokeL.objValue;
    }

    public w a(com.bytedance.sdk.openadsdk.core.nativeexpress.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gVar)) == null) {
            this.q = new WeakReference<>(gVar);
            return this;
        }
        return (w) invokeL.objValue;
    }

    public w a(com.bytedance.sdk.openadsdk.core.nativeexpress.j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jVar)) == null) {
            this.p = new WeakReference<>(jVar);
            return this;
        }
        return (w) invokeL.objValue;
    }

    public w a(SSWebView sSWebView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, sSWebView)) == null) {
            com.bytedance.sdk.component.utils.j.f("webviewpool", "===useJsb2 webView hashCode:" + sSWebView.hashCode());
            com.bytedance.sdk.component.a.q b2 = com.bytedance.sdk.component.a.q.a(sSWebView).a(new com.bytedance.sdk.openadsdk.i.a()).a("ToutiaoJSBridge").a(new com.bytedance.sdk.component.a.l(this) { // from class: com.bytedance.sdk.openadsdk.core.w.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ w f30728a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f30728a = this;
                }

                @Override // com.bytedance.sdk.component.a.l
                @NonNull
                public <T> T a(@NonNull String str, @NonNull Type type) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, type)) == null) {
                        return null;
                    }
                    return (T) invokeLL.objValue;
                }

                @Override // com.bytedance.sdk.component.a.l
                @NonNull
                public <T> String a(@NonNull T t) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) {
                        return null;
                    }
                    return (String) invokeL2.objValue;
                }
            }).a(h.d().x()).b(true).a().b();
            this.G = b2;
            com.bytedance.sdk.openadsdk.i.a.g.a(b2, this);
            com.bytedance.sdk.openadsdk.i.a.b.a(this.G, this);
            com.bytedance.sdk.openadsdk.i.a.j.a(this.G);
            com.bytedance.sdk.openadsdk.i.a.f.a(this.G);
            com.bytedance.sdk.openadsdk.i.a.i.a(this.G, sSWebView);
            com.bytedance.sdk.openadsdk.i.a.d.a(this.G, this);
            com.bytedance.sdk.openadsdk.i.a.e.a(this.G, this);
            com.bytedance.sdk.openadsdk.i.a.l.a(this.G, this);
            com.bytedance.sdk.openadsdk.i.a.a.a(this.G, this);
            com.bytedance.sdk.openadsdk.i.a.k.a(this.G, this);
            com.bytedance.sdk.openadsdk.i.a.h.a(this.G, this);
            com.bytedance.sdk.openadsdk.i.a.c.a(this.G, this);
            return this;
        }
        return (w) invokeL.objValue;
    }

    public w a(com.bytedance.sdk.openadsdk.e.p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, pVar)) == null) {
            this.F = pVar;
            return this;
        }
        return (w) invokeL.objValue;
    }

    public w a(com.bytedance.sdk.openadsdk.h.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar)) == null) {
            this.s = new WeakReference<>(dVar);
            return this;
        }
        return (w) invokeL.objValue;
    }

    public w a(com.bytedance.sdk.openadsdk.j.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, aVar)) == null) {
            this.t = new WeakReference<>(aVar);
            return this;
        }
        return (w) invokeL.objValue;
    }

    public w a(com.bytedance.sdk.openadsdk.j.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bVar)) == null) {
            this.y = new WeakReference<>(bVar);
            return this;
        }
        return (w) invokeL.objValue;
    }

    public w a(com.bytedance.sdk.openadsdk.j.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, dVar)) == null) {
            this.v = new WeakReference<>(dVar);
            return this;
        }
        return (w) invokeL.objValue;
    }

    public w a(com.bytedance.sdk.openadsdk.j.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, eVar)) == null) {
            this.u = new WeakReference<>(eVar);
            return this;
        }
        return (w) invokeL.objValue;
    }

    public w a(com.bytedance.sdk.openadsdk.j.h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, hVar)) == null) {
            this.z = new WeakReference<>(hVar);
            return this;
        }
        return (w) invokeL.objValue;
    }

    public w a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.H = str;
            return this;
        }
        return (w) invokeL.objValue;
    }

    public w a(List<com.bytedance.sdk.openadsdk.core.e.m> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, list)) == null) {
            this.B = list;
            return this;
        }
        return (w) invokeL.objValue;
    }

    public w a(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, map)) == null) {
            this.f30720a = map;
            return this;
        }
        return (w) invokeL.objValue;
    }

    public w a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, jSONObject)) == null) {
            this.r = jSONObject;
            return this;
        }
        return (w) invokeL.objValue;
    }

    public w a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
            this.f30721b = z;
            return this;
        }
        return (w) invokeZ.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: boolean */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x032b, code lost:
        if (r4 != null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0356, code lost:
        if (r4 != null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0358, code lost:
        r3 = r4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject a(a aVar, int i2) throws Exception {
        InterceptResult invokeLI;
        char c2;
        JSONObject jSONObject;
        String str;
        int i3;
        Context context;
        WeakReference<Context> weakReference;
        Context context2;
        Context context3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048595, this, aVar, i2)) == null) {
            if (NotificationCompat.CATEGORY_CALL.equals(aVar.f30744a)) {
                if (h.d().x()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[JSB-REQ] version:");
                    sb.append(i2);
                    sb.append(" method:");
                    sb.append(aVar.f30746c);
                    sb.append(" params=");
                    JSONObject jSONObject2 = aVar.f30747d;
                    sb.append(jSONObject2 != null ? jSONObject2.toString() : "");
                    Log.d("TTAndroidObject", sb.toString());
                }
                JSONObject jSONObject3 = new JSONObject();
                String str2 = aVar.f30746c;
                int i4 = -1;
                switch (str2.hashCode()) {
                    case -2036781162:
                        if (str2.equals("subscribe_app_ad")) {
                            c2 = 11;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1752549500:
                        if (str2.equals("adInfoStash")) {
                            c2 = 31;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1423303823:
                        if (str2.equals("adInfo")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1330994877:
                        if (str2.equals("pauseWebView")) {
                            c2 = 27;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1169135450:
                        if (str2.equals("changeVideoState")) {
                            c2 = 21;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -844321441:
                        if (str2.equals("webview_time_track")) {
                            c2 = DecodedBitStreamParser.GS;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -800853518:
                        if (str2.equals("clickEvent")) {
                            c2 = 16;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -794273169:
                        if (str2.equals(DI.APP_INFO_NAME)) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -715147645:
                        if (str2.equals("getScreenSize")) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -489318846:
                        if (str2.equals("getMaterialMeta")) {
                            c2 = 24;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -278382602:
                        if (str2.equals("send_temai_product_ids")) {
                            c2 = 23;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -173752734:
                        if (str2.equals("getTeMaiAds")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 27837080:
                        if (str2.equals("download_app_ad")) {
                            c2 = '\f';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 105049135:
                        if (str2.equals("unsubscribe_app_ad")) {
                            c2 = 14;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 352242576:
                        if (str2.equals("getDownloadStatus")) {
                            c2 = DecodedBitStreamParser.RS;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 399543522:
                        if (str2.equals("getCloseButtonInfo")) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 402955465:
                        if (str2.equals("isViewable")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 442647767:
                        if (str2.equals("sendReward")) {
                            c2 = '\n';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 571273292:
                        if (str2.equals("dynamicTrack")) {
                            c2 = 18;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 650209982:
                        if (str2.equals("getTemplateInfo")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 672928467:
                        if (str2.equals("cancel_download_app_ad")) {
                            c2 = '\r';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 711635577:
                        if (str2.equals("getCurrentVideoState")) {
                            c2 = 22;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 885131792:
                        if (str2.equals("getVolume")) {
                            c2 = '\b';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1107374321:
                        if (str2.equals("pauseWebViewTimers")) {
                            c2 = DecodedBitStreamParser.FS;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1151744482:
                        if (str2.equals("muteVideo")) {
                            c2 = 20;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1237100796:
                        if (str2.equals("renderDidFinish")) {
                            c2 = 17;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1532142616:
                        if (str2.equals("removeLoading")) {
                            c2 = '\t';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1634511418:
                        if (str2.equals("endcard_load")) {
                            c2 = JSONLexer.EOI;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1713585602:
                        if (str2.equals("getNetworkData")) {
                            c2 = 25;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1731806400:
                        if (str2.equals("playable_style")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2086000188:
                        if (str2.equals("skipVideo")) {
                            c2 = 19;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2105008900:
                        if (str2.equals("landscape_click")) {
                            c2 = 15;
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
                        a(jSONObject3, aVar.f30748e);
                        break;
                    case 1:
                        e(jSONObject3);
                        break;
                    case 2:
                        f(jSONObject3);
                        break;
                    case 3:
                        JSONObject jSONObject4 = this.r;
                        if (jSONObject4 != null) {
                            jSONObject4.put(com.alipay.sdk.sys.a.j, z());
                            com.bytedance.sdk.openadsdk.core.e.m mVar = this.n;
                            if (mVar != null) {
                                this.r.put(ETAG.KEY_EXTENSION, mVar.ac());
                            }
                        }
                        jSONObject3 = this.r;
                        break;
                    case 4:
                        jSONObject = this.w;
                        break;
                    case 5:
                        str = "viewStatus";
                        i3 = this.E;
                        jSONObject3.put(str, i3);
                        break;
                    case 6:
                        WeakReference<com.bytedance.sdk.openadsdk.j.a> weakReference2 = this.t;
                        com.bytedance.sdk.openadsdk.j.a aVar2 = weakReference2 != null ? weakReference2.get() : null;
                        if (aVar2 != null) {
                            int b2 = aVar2.b();
                            int a2 = aVar2.a();
                            jSONObject3.put("width", b2);
                            str = "height";
                            i3 = a2;
                            jSONObject3.put(str, i3);
                            break;
                        }
                        break;
                    case 7:
                        jSONObject = u();
                        break;
                    case '\b':
                        AudioManager audioManager = (AudioManager) o.a().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                        if (audioManager != null) {
                            i4 = audioManager.getStreamVolume(3);
                            com.bytedance.sdk.component.utils.j.b("TTAndroidObject", "音乐音量 >>>> AudioManager-->currentVolume=" + i4);
                        }
                        jSONObject3.put("endcard_mute", i4 <= 0);
                        break;
                    case '\t':
                        WeakReference<com.bytedance.sdk.openadsdk.j.d> weakReference3 = this.v;
                        if (weakReference3 != null && weakReference3.get() != null) {
                            this.v.get().a();
                            break;
                        }
                        break;
                    case '\n':
                        this.f30722c = true;
                        WeakReference<com.bytedance.sdk.openadsdk.j.e> weakReference4 = this.u;
                        if (weakReference4 != null && weakReference4.get() != null) {
                            this.u.get().a();
                            break;
                        }
                        break;
                    case 11:
                        C();
                        WeakReference<Context> weakReference5 = this.f30725g;
                        if (weakReference5 != null && (context = weakReference5.get()) != null) {
                            this.f30726h.a(context, aVar.f30747d, this.k, this.l, this.o);
                            break;
                        }
                        break;
                    case '\f':
                        this.I = true;
                        WeakReference<com.bytedance.sdk.openadsdk.core.b.d> weakReference6 = this.x;
                        if (weakReference6 != null && weakReference6.get() != null) {
                            this.x.get().a(this.A);
                            break;
                        } else if (this.f30726h != null && (weakReference = this.f30725g) != null && (context2 = weakReference.get()) != null) {
                            this.f30726h.a(context2, aVar.f30747d, this.H);
                            break;
                        }
                        break;
                    case '\r':
                        com.bytedance.sdk.openadsdk.h.c cVar = this.f30726h;
                        if (cVar != null) {
                            cVar.b(aVar.f30747d);
                            break;
                        }
                        break;
                    case 14:
                        com.bytedance.sdk.openadsdk.h.c cVar2 = this.f30726h;
                        if (cVar2 != null) {
                            cVar2.a(aVar.f30747d);
                            break;
                        }
                        break;
                    case 15:
                        WeakReference<Context> weakReference7 = this.f30725g;
                        if (weakReference7 != null && (context3 = weakReference7.get()) != null && (context3 instanceof com.bytedance.sdk.openadsdk.core.video.b.b)) {
                            ((com.bytedance.sdk.openadsdk.core.video.b.b) context3).B();
                            break;
                        }
                        break;
                    case 16:
                        l(aVar.f30747d);
                        break;
                    case 17:
                        m(aVar.f30747d);
                        break;
                    case 18:
                        o(aVar.f30747d);
                        break;
                    case 19:
                        y();
                        break;
                    case 20:
                        i(aVar.f30747d);
                        break;
                    case 21:
                        j(aVar.f30747d);
                        break;
                    case 22:
                        k(jSONObject3);
                        break;
                    case 23:
                        p(aVar.f30747d);
                        break;
                    case 24:
                        q(jSONObject3);
                        break;
                    case 25:
                        a(aVar, jSONObject3);
                        break;
                    case 26:
                        h(aVar.f30747d);
                        break;
                    case 27:
                        w();
                        break;
                    case 28:
                        x();
                        break;
                    case 29:
                        g(aVar.f30747d);
                        break;
                    case 30:
                        jSONObject3 = com.bytedance.sdk.openadsdk.i.a.f.a(aVar.f30747d);
                        break;
                    case 31:
                        d(aVar.f30747d);
                        break;
                }
                if (i2 == 1 && !TextUtils.isEmpty(aVar.f30745b)) {
                    c(aVar.f30745b, jSONObject3);
                    if (h.d().x()) {
                        Log.d("TTAndroidObject", "[JSB-RSP] version:" + i2 + " data=" + jSONObject3);
                    }
                }
                return jSONObject3;
            }
            return null;
        }
        return (JSONObject) invokeLI.objValue;
    }

    public void a() {
        com.bytedance.sdk.component.a.q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (qVar = this.G) == null) {
            return;
        }
        qVar.a();
        this.G = null;
    }

    @Override // com.bytedance.sdk.component.utils.u.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, message) == null) && message != null && message.what == 11) {
            Object obj = message.obj;
            if (obj instanceof a) {
                try {
                    a((a) obj, 1);
                } catch (Exception unused) {
                }
            }
        }
    }

    public void a(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, adSlot) == null) {
            a((JSONObject) null, new com.bytedance.sdk.openadsdk.j.c(this) { // from class: com.bytedance.sdk.openadsdk.core.w.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ w f30741a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f30741a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.j.c
                public void a(boolean z, List<com.bytedance.sdk.openadsdk.core.e.m> list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z, list) == null) {
                        this.f30741a.B = list;
                        this.f30741a.A();
                        this.f30741a.j();
                    }
                }
            }, adSlot);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.h.b
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, str, jSONObject) == null) {
            d(str, jSONObject);
        }
    }

    public void a(JSONObject jSONObject, com.bytedance.sdk.openadsdk.j.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, jSONObject, cVar) == null) {
            a(jSONObject, cVar, (AdSlot) null);
        }
    }

    public void a(JSONObject jSONObject, com.bytedance.sdk.openadsdk.j.c cVar, AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048601, this, jSONObject, cVar, adSlot) == null) || cVar == null) {
            return;
        }
        try {
            if (this.n != null && !TextUtils.isEmpty(this.k)) {
                int c2 = com.bytedance.sdk.openadsdk.r.o.c(this.k);
                AdSlot m = this.n.m();
                if (m != null) {
                    adSlot = m;
                }
                com.bytedance.sdk.openadsdk.core.e.n nVar = new com.bytedance.sdk.openadsdk.core.e.n();
                if (this.n.P() != null) {
                    nVar.f30104e = 2;
                }
                JSONObject aw = this.n.aw();
                if (aw == null) {
                    aw = new JSONObject();
                }
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        aw.put(next, jSONObject.opt(next));
                    }
                }
                nVar.j = aw;
                o.f().a(adSlot, nVar, c2, new p.b(this, cVar) { // from class: com.bytedance.sdk.openadsdk.core.w.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ com.bytedance.sdk.openadsdk.j.c f30739a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ w f30740b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, cVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f30740b = this;
                        this.f30739a = cVar;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.p.b
                    public void a(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                            this.f30739a.a(false, null);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.p.b
                    public void a(com.bytedance.sdk.openadsdk.core.e.a aVar) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                            if (aVar.c() != null && !aVar.c().isEmpty()) {
                                this.f30739a.a(true, aVar.c());
                            } else {
                                this.f30739a.a(false, null);
                            }
                        }
                    }
                });
                return;
            }
            cVar.a(false, null);
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.j.c("TTAndroidObject", "get ads error", e2);
        }
    }

    public boolean a(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, uri)) == null) {
            if (uri == null) {
                return false;
            }
            if ("bytedance".equals(uri.getScheme())) {
                return f30719f.containsKey(uri.getHost());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @JavascriptInterface
    public String adInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                e(jSONObject);
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    @JavascriptInterface
    public String appInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                a(jSONObject, 0);
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public com.bytedance.sdk.component.a.q b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.G : (com.bytedance.sdk.component.a.q) invokeV.objValue;
    }

    public w b(SSWebView sSWebView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, sSWebView)) == null) {
            this.f30723d = new WeakReference<>(sSWebView);
            return this;
        }
        return (w) invokeL.objValue;
    }

    public w b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            this.f30727i = str;
            return this;
        }
        return (w) invokeL.objValue;
    }

    public w b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, jSONObject)) == null) {
            this.w = jSONObject;
            return this;
        }
        return (w) invokeL.objValue;
    }

    public w b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048609, this, z)) == null) {
            this.E = z;
            return this;
        }
        return (w) invokeZ.objValue;
    }

    public void b(@NonNull Uri uri) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, uri) == null) {
            try {
                String host = uri.getHost();
                if (!"log_event".equals(host) && !"custom_event".equals(host) && !"log_event_v3".equals(host)) {
                    if (!PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equals(host) && !"dispatch_message".equals(host)) {
                        com.bytedance.sdk.component.utils.j.d("TTAndroidObject", "handlrUir: not match schema host");
                        return;
                    }
                    h(uri.toString());
                    return;
                }
                String queryParameter = uri.getQueryParameter("category");
                String queryParameter2 = uri.getQueryParameter("tag");
                String queryParameter3 = uri.getQueryParameter(NotificationCompatJellybean.KEY_LABEL);
                if (f(queryParameter3)) {
                    long j2 = 0;
                    try {
                        j = Long.parseLong(uri.getQueryParameter("value"));
                    } catch (Exception unused) {
                        j = 0;
                    }
                    try {
                        j2 = Long.parseLong(uri.getQueryParameter("ext_value"));
                    } catch (Exception unused2) {
                    }
                    long j3 = j2;
                    JSONObject jSONObject = null;
                    String queryParameter4 = uri.getQueryParameter("extra");
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        try {
                            jSONObject = new JSONObject(queryParameter4);
                        } catch (Exception unused3) {
                        }
                    }
                    com.bytedance.sdk.openadsdk.e.d.a(queryParameter, g(queryParameter2), queryParameter3, j, j3, PrefetchEvent.STATE_CLICK.equals(queryParameter3) ? t(jSONObject) : jSONObject);
                }
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.j.b("TTAndroidObject", "handleUri exception: ", e2);
            }
        }
    }

    public void b(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, str, jSONObject) == null) {
            try {
                if (this.G != null) {
                    this.G.a(str, (String) jSONObject);
                }
            } catch (Throwable th) {
                Log.e("TTAndroidObject", "sendJsMsg2020 error", th);
            }
        }
    }

    public w c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
            this.k = str;
            return this;
        }
        return (w) invokeL.objValue;
    }

    public w c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048613, this, z)) == null) {
            this.A = z;
            return this;
        }
        return (w) invokeZ.objValue;
    }

    public void c() {
        WeakReference<Context> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (weakReference = this.f30725g) == null || weakReference.get() == null || !(this.f30725g.get() instanceof TTMiddlePageActivity)) {
            return;
        }
        ((Activity) this.f30725g.get()).finish();
    }

    @Keep
    @JProtect
    public void c(JSONObject jSONObject) {
        String str;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        com.bytedance.sdk.component.utils.j.b("TTAndroidObject", "TTAndroidObject handleNewClickEvent");
        try {
            String optString = jSONObject.optString("adId");
            int optInt = jSONObject.optInt("areaType", 1);
            String optString2 = jSONObject.optString("clickAreaType");
            boolean z = jSONObject.optInt("downloadDialogStatus", 2) == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("clickInfo");
            double d11 = 0.0d;
            if (optJSONObject != null) {
                double optDouble = optJSONObject.optDouble("down_x", 0.0d);
                d4 = optJSONObject.optDouble("down_y", 0.0d);
                d5 = optJSONObject.optDouble("up_x", 0.0d);
                double optDouble2 = optJSONObject.optDouble("up_y", 0.0d);
                double optDouble3 = optJSONObject.optDouble("down_time", 0.0d);
                double optDouble4 = optJSONObject.optDouble("up_time", 0.0d);
                double optDouble5 = optJSONObject.optDouble("button_x", 0.0d);
                double optDouble6 = optJSONObject.optDouble("button_y", 0.0d);
                double optDouble7 = optJSONObject.optDouble("button_width", 0.0d);
                str = optString;
                d10 = optJSONObject.optDouble("button_height", 0.0d);
                d11 = optDouble;
                d3 = optDouble2;
                d2 = optDouble3;
                d6 = optDouble4;
                d7 = optDouble5;
                d8 = optDouble6;
                d9 = optDouble7;
            } else {
                str = optString;
                d2 = 0.0d;
                d3 = 0.0d;
                d4 = 0.0d;
                d5 = 0.0d;
                d6 = 0.0d;
                d7 = 0.0d;
                d8 = 0.0d;
                d9 = 0.0d;
                d10 = 0.0d;
            }
            com.bytedance.sdk.openadsdk.core.e.k a2 = new k.a().d((int) d11).c((int) d4).b((int) d5).a((int) d3).b((long) d2).a((long) d6).e((int) d7).f((int) d8).g((int) d9).h((int) d10).a(optString2).a();
            if (this.p != null && this.p.get() != null) {
                this.p.get().a(optInt, a2, !z);
            }
            a(str, optInt, a2);
        } catch (Exception unused) {
            WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.j> weakReference = this.p;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.p.get().a(-1, null, true);
        }
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    j(jSONObject);
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable(this, jSONObject) { // from class: com.bytedance.sdk.openadsdk.core.w.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ JSONObject f30731a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ w f30732b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, jSONObject};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f30732b = this;
                            this.f30731a = jSONObject;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f30732b.j(this.f30731a);
                            }
                        }
                    });
                }
            } catch (Exception unused) {
            }
        }
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    l(jSONObject);
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable(this, jSONObject) { // from class: com.bytedance.sdk.openadsdk.core.w.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ JSONObject f30733a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ w f30734b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, jSONObject};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f30734b = this;
                            this.f30733a = jSONObject;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f30734b.l(this.f30733a);
                            }
                        }
                    });
                }
            } catch (Exception unused) {
            }
        }
    }

    public com.bytedance.sdk.openadsdk.core.e.m d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.n : (com.bytedance.sdk.openadsdk.core.e.m) invokeV.objValue;
    }

    public w d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, str)) == null) {
            this.m = str;
            return this;
        }
        return (w) invokeL.objValue;
    }

    public void d(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f30727i = jSONObject.optString(IAdRequestParam.CELL_ID);
        this.k = jSONObject.optString("log_extra");
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.f30722c = z;
        }
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            try {
                o(new JSONObject(str));
            } catch (Exception unused) {
            }
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            com.bytedance.sdk.openadsdk.core.e.m mVar = this.n;
            return mVar != null && mVar.f();
        }
        return invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.f30722c : invokeV.booleanValue;
    }

    public void g() {
        WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.g> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048625, this) == null) || (weakReference = this.q) == null || weakReference.get() == null) {
            return;
        }
        this.q.get().b();
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            k(jSONObject);
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            a("getTemplateInfo", true);
            try {
                if (this.r != null) {
                    this.r.put(com.alipay.sdk.sys.a.j, z());
                    if (this.n != null) {
                        this.r.put(ETAG.KEY_EXTENSION, this.n.ac());
                    }
                }
                a("getTemplateInfo", false);
                return this.r.toString();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public void h() {
        WeakReference<com.bytedance.sdk.openadsdk.core.nativeexpress.g> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || (weakReference = this.q) == null || weakReference.get() == null) {
            return;
        }
        this.q.get().f();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            a((JSONObject) null, new com.bytedance.sdk.openadsdk.j.c(this) { // from class: com.bytedance.sdk.openadsdk.core.w.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ w f30738a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f30738a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.j.c
                public void a(boolean z, List<com.bytedance.sdk.openadsdk.core.e.m> list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z, list) == null) {
                        this.f30738a.B = list;
                        this.f30738a.A();
                        this.f30738a.j();
                    }
                }
            });
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("material", b(this.B));
                a("materialMeta", jSONObject);
            } catch (Exception unused) {
            }
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.I : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            com.bytedance.sdk.openadsdk.core.e.m mVar = this.n;
            return mVar != null && mVar.A() == 1;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        com.bytedance.sdk.openadsdk.core.e.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048633, this) == null) || (mVar = this.n) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.r.b.a(this.f30725g.get(), mVar.U());
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    i(jSONObject);
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable(this, jSONObject) { // from class: com.bytedance.sdk.openadsdk.core.w.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ JSONObject f30729a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ w f30730b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, jSONObject};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f30730b = this;
                            this.f30729a = jSONObject;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f30730b.i(this.f30729a);
                            }
                        }
                    });
                }
            } catch (Exception unused) {
                com.bytedance.sdk.component.utils.j.f("TTAndroidObject", "");
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            com.bytedance.sdk.openadsdk.r.b.a(this.n, this.f30725g.get(), p());
        }
    }

    public JSONObject o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            com.bytedance.sdk.openadsdk.core.e.m mVar = this.n;
            if (mVar == null) {
                return jSONObject;
            }
            String U = mVar.U();
            if (TextUtils.isEmpty(U)) {
                return jSONObject;
            }
            try {
                return new JSONObject(U);
            } catch (Exception e2) {
                e2.printStackTrace();
                return jSONObject;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? com.bytedance.sdk.openadsdk.r.o.a(this.l) : (String) invokeV.objValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            com.bytedance.sdk.openadsdk.h.c cVar = this.f30726h;
            if (cVar != null) {
                cVar.a();
            }
            if (B()) {
                i();
            }
        }
    }

    public void r() {
        com.bytedance.sdk.openadsdk.h.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048639, this) == null) || (cVar = this.f30726h) == null) {
            return;
        }
        cVar.b();
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, str) == null) {
            try {
                m(new JSONObject(str));
            } catch (Exception unused) {
            }
        }
    }

    public void s() {
        com.bytedance.sdk.openadsdk.h.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048641, this) == null) || (cVar = this.f30726h) == null) {
            return;
        }
        cVar.c();
    }

    @JavascriptInterface
    public void skipVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            y();
        }
    }
}
