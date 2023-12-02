package com.baidu.tieba;

import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class xm0 {
    public static /* synthetic */ Interceptable $ic;
    public static final a w;
    public transient /* synthetic */ FieldHolder $fh;
    @JvmField
    public int a;
    @JvmField
    public String b;
    @JvmField
    public String c;
    @JvmField
    public boolean d;
    @JvmField
    public boolean e;
    @JvmField
    public boolean f;
    @JvmField
    public boolean g;
    @JvmField
    public List<MonitorUrl> h;
    @JvmField
    public String i;
    @JvmField
    public String j;
    @JvmField
    public String k;
    @JvmField
    public String l;
    @JvmField
    public String m;
    @JvmField
    public String n;
    @JvmField
    public List<bn0> o;
    @JvmField
    public tm0 p;
    @JvmField
    public wm0 q;
    @JvmField
    public String r;
    @JvmField
    public pn0 s;
    @JvmField
    public String t;
    @JvmField
    public boolean u;
    @JvmField
    public String v;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948305038, "Lcom/baidu/tieba/xm0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948305038, "Lcom/baidu/tieba/xm0;");
                return;
            }
        }
        w = new a(null);
    }

    @JvmStatic
    public static final xm0 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) ? w.a(jSONObject) : (xm0) invokeL.objValue;
    }

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:40:0x00f9, code lost:
            if (r0.equals(com.baidu.searchbox.net.listener.DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST) != false) goto L36;
         */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0130  */
        @JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final xm0 a(JSONObject jSONObject) {
            InterceptResult invokeL;
            boolean z;
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("convert");
                if (optJSONObject2 == null) {
                    optJSONObject2 = oy0.c(jSONObject.optString("convert"));
                }
                if (optJSONObject2 == null) {
                    return null;
                }
                xm0 xm0Var = new xm0();
                xm0Var.b = optJSONObject2.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
                xm0Var.c = optJSONObject2.optString("button_icon");
                xm0Var.i = optJSONObject2.optString("download_button_start_color");
                xm0Var.j = optJSONObject2.optString("download_button_end_color");
                xm0Var.k = optJSONObject2.optString("invoke_button_start_color");
                xm0Var.l = optJSONObject2.optString("invoke_button_end_color");
                xm0Var.m = optJSONObject2.optString("invoke_button_icon");
                xm0Var.n = optJSONObject2.optString("invoke_button_text");
                String optString = optJSONObject2.optString("button_text_color");
                Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"button_text_color\")");
                int i = 1;
                if (optString.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    optJSONObject2.optString("button_text_color");
                } else {
                    optJSONObject2.optString("textColor");
                }
                optJSONObject2.optInt("buttonShineType");
                String optString2 = optJSONObject2.optString("button_shine_lottie");
                Intrinsics.checkNotNullExpressionValue(optString2, "it.optString(\"button_shine_lottie\")");
                xm0Var.v = optString2;
                xm0Var.r = optJSONObject2.optString("background_color");
                xm0Var.t = optJSONObject2.optString("button_scheme");
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = optJSONObject2.optJSONArray(AnimatedStateListDrawableCompat.ELEMENT_TRANSITION);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        bn0 a = bn0.d.a(optJSONArray.optJSONObject(i2));
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
                xm0Var.o = arrayList;
                String optString3 = optJSONObject2.optString("type");
                if (optString3 != null) {
                    int hashCode = optString3.hashCode();
                    if (hashCode != -1335224239) {
                        if (hashCode != -1183693704) {
                            if (hashCode == 1427818632 && optString3.equals("download")) {
                                i = 2;
                            }
                        }
                        xm0Var.a = i;
                        xm0Var.p = tm0.c(optJSONObject2.optJSONObject("download"));
                        wm0 wm0Var = new wm0();
                        wm0Var.d = optJSONObject2.optString("ext");
                        wm0Var.a = optJSONObject2.optString(BdVideoAd.AD_VIDEO_DAPAGE);
                        Unit unit2 = Unit.INSTANCE;
                        xm0Var.q = wm0Var;
                        optJSONObject = optJSONObject2.optJSONObject("app_info");
                        if (optJSONObject != null) {
                            pn0 d = pn0.d(optJSONObject);
                            xm0Var.s = d;
                            if (d != null) {
                                d.n = optJSONObject2.optString("ext");
                            }
                        }
                        ym0.d.a(optJSONObject2.optJSONObject("click_button_lottie"));
                        return xm0Var;
                    }
                    optString3.equals("detail");
                }
                i = 0;
                xm0Var.a = i;
                xm0Var.p = tm0.c(optJSONObject2.optJSONObject("download"));
                wm0 wm0Var2 = new wm0();
                wm0Var2.d = optJSONObject2.optString("ext");
                wm0Var2.a = optJSONObject2.optString(BdVideoAd.AD_VIDEO_DAPAGE);
                Unit unit22 = Unit.INSTANCE;
                xm0Var.q = wm0Var2;
                optJSONObject = optJSONObject2.optJSONObject("app_info");
                if (optJSONObject != null) {
                }
                ym0.d.a(optJSONObject2.optJSONObject("click_button_lottie"));
                return xm0Var;
            }
            return (xm0) invokeL.objValue;
        }
    }

    public xm0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 1;
        this.h = new ArrayList();
        this.v = "";
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a != 2 || this.p != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
