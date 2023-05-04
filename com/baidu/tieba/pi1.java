package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.d41;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class pi1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public String C;
    public int D;
    public int E;
    public int F;
    public int G;
    public String H;
    public float I;
    public int J;
    public JSONObject K;
    public JSONObject L;
    public int M;
    public int N;
    public String O;
    public float P;
    public int Q;
    public long R;
    public long S;
    public int T;
    public float U;
    public String V;
    public String W;
    public int X;
    public int a;
    public String b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;
    public int h;
    public int i;
    public String j;
    public String k;
    public String l;
    public int m;
    public int n;
    public String o;
    public String p;
    public String[] q;
    public String[] r;
    public long s;
    public long t;
    public int u;
    public int v;
    public int w;
    public int x;
    public boolean y;
    public String z;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, pi1 pi1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, jSONObject, pi1Var) == null) {
                try {
                    pi1Var.a = jSONObject.optInt("advisible");
                    pi1Var.b = jSONObject.optString("id");
                    pi1Var.c = jSONObject.optString("ukey");
                    pi1Var.d = jSONObject.optString("extra");
                    pi1Var.e = jSONObject.optString(TtmlNode.TAG_LAYOUT);
                    pi1Var.f = jSONObject.optInt("type");
                    pi1Var.k = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
                    pi1Var.o = jSONObject.optString("action");
                    pi1Var.p = jSONObject.optString("action_cmd");
                    pi1Var.l = jSONObject.optString("flag_name");
                    pi1Var.m = jSONObject.optInt("logo_type");
                    pi1Var.n = jSONObject.optInt(CriusAttrConstants.DISPLAY);
                    if (pi1Var.n()) {
                        b.a(jSONObject, pi1Var);
                    } else {
                        c.a(jSONObject, pi1Var);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("show_urls");
                    if (optJSONArray != null) {
                        pi1Var.q = new String[optJSONArray.length()];
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            pi1Var.q[i] = optJSONArray.optString(i);
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("click_urls");
                    if (optJSONArray2 != null) {
                        pi1Var.r = new String[optJSONArray2.length()];
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            pi1Var.r[i2] = optJSONArray2.optString(i2);
                        }
                    }
                    pi1Var.s = jSONObject.optLong("start");
                    pi1Var.t = jSONObject.optLong("end");
                    pi1Var.u = jSONObject.optInt("expose_interval");
                    pi1Var.v = jSONObject.optInt("expose_times");
                    pi1Var.w = jSONObject.optInt("preload_type");
                    pi1Var.z = jSONObject.optString("click_float_lottie_url");
                    pi1Var.A = jSONObject.optInt("float_bar_show", 1);
                    pi1Var.B = jSONObject.optInt("click_float_opt", 1);
                    pi1Var.C = jSONObject.optString("style_desc");
                    pi1Var.x = jSONObject.optInt("curRate");
                    pi1Var.E = jSONObject.optInt(TiebaStatic.Params.AD_TYPE);
                    pi1Var.F = jSONObject.optInt("ad_sort");
                    pi1Var.G = jSONObject.optInt("gesture_lottie_type");
                    pi1Var.H = jSONObject.optString("gesture_lottie_url");
                    pi1Var.I = (float) jSONObject.optDouble("gesture_lottie_sensitivity", 0.0d);
                    pi1Var.X = jSONObject.optInt("gesture_lottie_direction", 1);
                    int optInt = jSONObject.optInt("is_topview", 0);
                    pi1Var.J = optInt;
                    if (optInt == 1 && jSONObject.optJSONObject("topview_data") != null) {
                        pi1Var.K = jSONObject.optJSONObject("topview_data");
                    }
                    if (jSONObject.optJSONObject("animation_data") != null) {
                        pi1Var.L = jSONObject.optJSONObject("animation_data");
                    }
                    pi1Var.M = jSONObject.optInt("shake_update_interval", 67);
                    pi1Var.N = jSONObject.optInt("shake_direction_count", 2);
                    pi1Var.O = jSONObject.optString("key");
                    pi1Var.P = (float) jSONObject.optDouble("hot_shake_sensitivity", 0.0d);
                    pi1Var.Q = jSONObject.optInt("hot_background_time", 0);
                    pi1Var.V = jSONObject.optString("m_ua");
                    pi1Var.W = jSONObject.optString("m_pn");
                    pi1Var.R = jSONObject.optLong("start_backup");
                    pi1Var.S = jSONObject.optLong("end_backup");
                    pi1Var.T = jSONObject.optInt("virtual", 0);
                    pi1Var.U = (float) jSONObject.optDouble("shake_action_delay_time", -1.0d);
                } catch (Exception unused) {
                }
            }
        }

        public static void c(JSONObject jSONObject, pi1 pi1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, jSONObject, pi1Var) == null) {
                try {
                    jSONObject.put("advisible", pi1Var.a);
                    jSONObject.put("id", pi1Var.b);
                    jSONObject.put("ukey", pi1Var.c);
                    jSONObject.put("extra", pi1Var.d);
                    jSONObject.put(TtmlNode.TAG_LAYOUT, pi1Var.e);
                    jSONObject.put("type", pi1Var.f);
                    jSONObject.put(BigdayActivityConfig.JUMP_URL, pi1Var.k);
                    jSONObject.put("action", pi1Var.o);
                    jSONObject.put("action_cmd", pi1Var.p);
                    jSONObject.put("flag_name", pi1Var.l);
                    jSONObject.put("logo_type", pi1Var.m);
                    jSONObject.put(CriusAttrConstants.DISPLAY, pi1Var.n);
                    jSONObject.put("start", pi1Var.s);
                    jSONObject.put("end", pi1Var.t);
                    jSONObject.put("expose_times", pi1Var.v);
                    jSONObject.put("expose_interval", pi1Var.u);
                    jSONObject.put("preload_type", pi1Var.w);
                    jSONObject.put("curRate", pi1Var.x);
                    jSONObject.put("click_float_lottie_url", pi1Var.z);
                    jSONObject.put("float_bar_show", pi1Var.A);
                    jSONObject.put("click_float_opt", pi1Var.B);
                    jSONObject.put("style_desc", pi1Var.C);
                    jSONObject.put(TiebaStatic.Params.AD_TYPE, pi1Var.E);
                    jSONObject.put("ad_sort", pi1Var.F);
                    jSONObject.put("gesture_lottie_type", pi1Var.G);
                    jSONObject.put("gesture_lottie_url", pi1Var.H);
                    jSONObject.put("gesture_lottie_sensitivity", pi1Var.I);
                    jSONObject.put("gesture_lottie_direction", pi1Var.X);
                    jSONObject.put("is_topview", pi1Var.J);
                    jSONObject.put("start_backup", pi1Var.R);
                    jSONObject.put("end_backup", pi1Var.S);
                    if (pi1Var.J == 1 && pi1Var.K != null) {
                        jSONObject.put("topview_data", pi1Var.K);
                    }
                    if (pi1Var.L != null) {
                        jSONObject.put("animation_data", pi1Var.L);
                    }
                    jSONObject.put("shake_update_interval", pi1Var.M);
                    jSONObject.put("shake_direction_count", pi1Var.N);
                    jSONObject.put("key", pi1Var.O);
                    jSONObject.put("hot_shake_sensitivity", pi1Var.P);
                    jSONObject.put("hot_background_time", pi1Var.Q);
                    jSONObject.put("virtual", pi1Var.T);
                    jSONObject.put("shake_action_delay_time", pi1Var.U);
                    jSONObject.put("m_ua", pi1Var.V);
                    jSONObject.put("m_pn", pi1Var.W);
                    if (pi1Var.q != null) {
                        if (d41.b.c()) {
                            jSONObject.put("show_urls", new JSONArray(pi1Var.q));
                        } else {
                            jSONObject.put("show_urls", new JSONArray((Collection) Arrays.asList(pi1Var.q)));
                        }
                    }
                    if (pi1Var.r != null) {
                        if (d41.b.c()) {
                            jSONObject.put("click_urls", new JSONArray(pi1Var.r));
                        } else {
                            jSONObject.put("click_urls", new JSONArray((Collection) Arrays.asList(pi1Var.r)));
                        }
                    }
                    if (pi1Var.n()) {
                        b.b(jSONObject, pi1Var);
                    } else {
                        c.b(jSONObject, pi1Var);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void b(JSONObject jSONObject, pi1 pi1Var) {
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, pi1Var) == null) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
                    if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                        return;
                    }
                    pi1Var.a = optJSONObject.optInt("advisible", 1);
                    pi1Var.b = optJSONObject.optString("id");
                    pi1Var.c = optJSONObject.optString("ukey");
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("extra");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        int i = 0;
                        while (true) {
                            if (i >= optJSONArray2.length()) {
                                break;
                            }
                            JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i);
                            if (optJSONObject3 != null) {
                                String optString = optJSONObject3.optString("k");
                                String optString2 = optJSONObject3.optString("v");
                                if (!TextUtils.isEmpty(optString2) && TextUtils.equals("extraParam", optString)) {
                                    pi1Var.d = optString2;
                                    break;
                                }
                            }
                            i++;
                        }
                    }
                    JSONArray optJSONArray3 = optJSONObject.optJSONArray("material");
                    if (optJSONArray3 != null && (optJSONObject2 = optJSONArray3.optJSONObject(0)) != null) {
                        JSONArray optJSONArray4 = optJSONObject2.optJSONArray("info");
                        if (optJSONArray4 == null) {
                            String optString3 = optJSONObject2.optString("info");
                            if (!TextUtils.isEmpty(optString3)) {
                                optJSONArray4 = new JSONArray(optString3);
                            }
                        }
                        if (optJSONArray4 != null) {
                            JSONObject optJSONObject4 = optJSONArray4.optJSONObject(0);
                            pi1Var.e = optJSONObject4.optString(TtmlNode.TAG_LAYOUT);
                            JSONObject optJSONObject5 = optJSONObject4.optJSONObject("common");
                            if (optJSONObject5 != null) {
                                pi1Var.f = optJSONObject5.optInt("type");
                                pi1Var.k = optJSONObject5.optString(BigdayActivityConfig.JUMP_URL);
                                pi1Var.o = optJSONObject5.optString("action");
                                pi1Var.p = optJSONObject5.optString("action_cmd");
                                pi1Var.l = optJSONObject5.optString("flag_name");
                                pi1Var.m = optJSONObject5.optInt("logo_type");
                                pi1Var.n = optJSONObject5.optInt(CriusAttrConstants.DISPLAY);
                                JSONArray optJSONArray5 = optJSONObject5.optJSONArray("image_list");
                                pi1Var.z = optJSONObject5.optString("click_float_lottie_url");
                                pi1Var.E = optJSONObject5.optInt(TiebaStatic.Params.AD_TYPE);
                                pi1Var.F = optJSONObject5.optInt("ad_sort");
                                pi1Var.G = optJSONObject5.optInt("gesture_lottie_type");
                                pi1Var.H = optJSONObject5.optString("gesture_lottie_url");
                                pi1Var.I = (float) optJSONObject5.optDouble("gesture_lottie_sensitivity", 0.0d);
                                pi1Var.X = optJSONObject5.optInt("gesture_lottie_direction", 1);
                                pi1Var.J = optJSONObject5.optInt("is_topview", 0);
                                if (pi1Var.n() && optJSONArray5 != null && optJSONArray5.length() > 0) {
                                    b.a(optJSONArray5.optJSONObject(0), pi1Var);
                                } else {
                                    c.a(optJSONObject5, pi1Var);
                                }
                                pi1Var.L = optJSONObject5.optJSONObject("animation_data");
                                pi1Var.M = optJSONObject5.optInt("shake_update_interval", 67);
                                pi1Var.N = optJSONObject5.optInt("shake_direction_count", 2);
                                pi1Var.O = optJSONObject5.optString("key");
                                pi1Var.P = (float) optJSONObject5.optDouble("hot_shake_sensitivity", 0.0d);
                                pi1Var.T = optJSONObject5.optInt("virtual", 0);
                                pi1Var.U = (float) optJSONObject5.optDouble("shake_action_delay_time", -1.0d);
                            }
                            JSONArray optJSONArray6 = optJSONObject4.optJSONArray("show_urls");
                            if (optJSONArray6 != null) {
                                pi1Var.q = new String[optJSONArray6.length()];
                                int length = optJSONArray6.length();
                                for (int i2 = 0; i2 < length; i2++) {
                                    pi1Var.q[i2] = optJSONArray6.optString(i2);
                                }
                            }
                            JSONArray optJSONArray7 = optJSONObject4.optJSONArray("click_urls");
                            if (optJSONArray7 != null) {
                                pi1Var.r = new String[optJSONArray7.length()];
                                int length2 = optJSONArray7.length();
                                for (int i3 = 0; i3 < length2; i3++) {
                                    pi1Var.r[i3] = optJSONArray7.optString(i3);
                                }
                            }
                            JSONObject optJSONObject6 = optJSONObject4.optJSONObject("policy");
                            if (optJSONObject6 != null) {
                                JSONObject optJSONObject7 = optJSONObject6.optJSONObject(PushConstants.REGISTER_STATUS_EXPIRE_TIME);
                                if (optJSONObject7 != null) {
                                    pi1Var.s = optJSONObject7.optLong("start");
                                    pi1Var.t = optJSONObject7.optLong("end");
                                }
                                pi1Var.u = optJSONObject6.optInt("expose_interval");
                                pi1Var.v = optJSONObject6.optInt("expose_times");
                                pi1Var.w = optJSONObject6.optInt("preload_type");
                                pi1Var.A = optJSONObject6.optInt("float_bar_show", 1);
                                pi1Var.B = optJSONObject6.optInt("click_float_opt", 1);
                                pi1Var.C = optJSONObject6.optString("style_desc");
                                pi1Var.Q = optJSONObject6.optInt("hot_background_time", 0);
                                JSONObject optJSONObject8 = optJSONObject6.optJSONObject("expire_time_backup");
                                String optString4 = optJSONObject6.optString("m_ua");
                                if (!TextUtils.isEmpty(optString4)) {
                                    pi1Var.V = new String(Base64.decode(optString4.getBytes(), 0));
                                }
                                String optString5 = optJSONObject6.optString("m_pn");
                                if (!TextUtils.isEmpty(optString5)) {
                                    pi1Var.W = new String(Base64.decode(optString5.getBytes(), 0));
                                }
                                if (optJSONObject8 != null) {
                                    pi1Var.R = optJSONObject8.optLong("start");
                                    pi1Var.S = optJSONObject8.optLong("end");
                                }
                            }
                            JSONObject optJSONObject9 = optJSONObject4.optJSONObject("topview_data");
                            if (pi1Var.J == 1 && optJSONObject9 != null) {
                                JSONObject optJSONObject10 = optJSONObject9.optJSONObject("content");
                                if (optJSONObject10 == null) {
                                    pi1Var.J = 0;
                                    return;
                                }
                                JSONObject jSONObject2 = new JSONObject();
                                z01.f(jSONObject2, "click_float_lottie_url", pi1Var.z);
                                z01.d(jSONObject2, "click_float_opt", pi1Var.B);
                                z01.d(jSONObject2, "float_bar_show", pi1Var.A);
                                z01.g(jSONObject2, SetImageWatermarkTypeReqMsg.SWITCH, true);
                                z01.f(jSONObject2, "style_desc", pi1Var.C);
                                z01.d(jSONObject2, "countdown", pi1Var.n);
                                z01.f(jSONObject2, "source_path", ni1.r(pi1Var.g));
                                z01.f(optJSONObject10, "topview", jSONObject2);
                                pi1Var.K = optJSONObject9;
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }

        public static void d(pi1 pi1Var, pi1 pi1Var2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, pi1Var, pi1Var2) == null) {
                pi1Var.a = pi1Var2.a;
                pi1Var.b = pi1Var2.b;
                pi1Var.c = pi1Var2.c;
                pi1Var.d = pi1Var2.d;
                pi1Var.e = pi1Var2.e;
                pi1Var.f = pi1Var2.f;
                pi1Var.g = pi1Var2.g;
                pi1Var.h = pi1Var2.h;
                pi1Var.i = pi1Var2.i;
                pi1Var.j = pi1Var2.j;
                pi1Var.k = pi1Var2.k;
                pi1Var.l = pi1Var2.l;
                pi1Var.m = pi1Var2.m;
                pi1Var.n = pi1Var2.n;
                pi1Var.o = pi1Var2.o;
                pi1Var.p = pi1Var2.p;
                pi1Var.q = pi1Var2.q;
                pi1Var.r = pi1Var2.r;
                pi1Var.s = pi1Var2.s;
                pi1Var.t = pi1Var2.t;
                pi1Var.u = pi1Var2.u;
                pi1Var.v = pi1Var2.v;
                pi1Var.x = pi1Var2.x;
                pi1Var.z = pi1Var2.z;
                pi1Var.A = pi1Var2.A;
                pi1Var.B = pi1Var2.B;
                pi1Var.C = pi1Var2.C;
                pi1Var.E = pi1Var2.E;
                pi1Var.F = pi1Var2.F;
                pi1Var.G = pi1Var2.G;
                pi1Var.H = pi1Var2.H;
                pi1Var.I = pi1Var2.I;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, pi1 pi1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65536, null, jSONObject, pi1Var) == null) && jSONObject != null) {
                try {
                    pi1Var.g = jSONObject.optString("url");
                    pi1Var.h = jSONObject.optInt("width");
                    pi1Var.i = jSONObject.optInt("height");
                    pi1Var.j = jSONObject.optString("imageMd5");
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, pi1 pi1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, pi1Var) == null) {
                try {
                    jSONObject.put("url", pi1Var.g);
                    jSONObject.put("imageMd5", pi1Var.j);
                    jSONObject.put("width", pi1Var.h);
                    jSONObject.put("height", pi1Var.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, pi1 pi1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65536, null, jSONObject, pi1Var) == null) && jSONObject != null) {
                try {
                    pi1Var.g = jSONObject.optString("url");
                    pi1Var.h = jSONObject.optInt("width");
                    pi1Var.i = jSONObject.optInt("height");
                    pi1Var.j = jSONObject.optString(PackageTable.MD5);
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, pi1 pi1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, pi1Var) == null) {
                try {
                    jSONObject.put("url", pi1Var.g);
                    jSONObject.put(PackageTable.MD5, pi1Var.j);
                    jSONObject.put("width", pi1Var.h);
                    jSONObject.put("height", pi1Var.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public pi1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = 0;
        this.y = false;
        this.U = -1.0f;
    }

    public float g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            float f = oi1.f;
            if (f > 0.0f) {
                return f;
            }
            return this.U;
        }
        return invokeV.floatValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i = oi1.e;
            if (i > 0) {
                return i;
            }
            return this.N;
        }
        return invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i = oi1.d;
            if (i > 0) {
                return i;
            }
            return this.M;
        }
        return invokeV.intValue;
    }

    @NonNull
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (TextUtils.equals(this.e, "splash_image")) {
                return "image";
            }
            if (TextUtils.equals(this.e, "splash_video")) {
                return "video";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.E == 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i = this.E;
            if (i == 0 || i == 1 || i == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return TextUtils.equals(this.e, "splash_image");
        }
        return invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i = this.G;
            if (i == 1 || i == 7) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return TextUtils.equals(this.e, "splash_video");
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.T == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            a.c(jSONObject, this);
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public static boolean b(pi1 pi1Var) {
        InterceptResult invokeL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pi1Var)) == null) {
            if (TextUtils.isEmpty(pi1Var.d)) {
                str = "7";
                z = false;
            } else {
                str = "";
                z = true;
            }
            String str2 = PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW;
            if (z && TextUtils.isEmpty(pi1Var.g)) {
                str = PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW;
                z = false;
            }
            if (z && System.currentTimeMillis() / 1000 > pi1Var.t) {
                str = "68";
                z = false;
            }
            if (z && pi1Var.p() && (pi1Var.g.endsWith(".jpeg") || pi1Var.g.endsWith(".jpg") || pi1Var.g.endsWith(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX) || pi1Var.g.endsWith(".webp"))) {
                str = PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW;
                z = false;
            }
            if (z && pi1Var.n() && (pi1Var.g.endsWith(DefaultHlsExtractorFactory.MP4_FILE_EXTENSION) || pi1Var.g.endsWith(".MP4") || pi1Var.g.endsWith(".mov"))) {
                z = false;
            } else {
                str2 = str;
            }
            if (z) {
                return true;
            }
            new BaseVM(pi1Var).g(str2);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static pi1 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            pi1 pi1Var = new pi1();
            try {
                a.a(jSONObject, pi1Var);
            } catch (Exception unused) {
            }
            return pi1Var;
        }
        return (pi1) invokeL.objValue;
    }

    public static pi1 d(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            try {
                pi1 pi1Var = new pi1();
                a.b(jSONObject, pi1Var);
                return pi1Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (pi1) invokeL.objValue;
    }

    public static List<pi1> r(JSONArray jSONArray) {
        InterceptResult invokeL;
        pi1 d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    d = d((JSONObject) jSONArray.get(i));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (d == null) {
                    break;
                }
                if (d.a != 0 && b(d)) {
                    arrayList.add(d);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void t(pi1 pi1Var, pi1 pi1Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, pi1Var, pi1Var2) == null) {
            a.d(pi1Var, pi1Var2);
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            return decimalFormat.format(e()) + "-" + i() + "-" + h() + "_" + g();
        }
        return (String) invokeV.objValue;
    }

    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.G != 7) {
                return this.I;
            }
            if (hi1.b() == 1) {
                float f = oi1.c;
                if (f > 0.0f) {
                    return f;
                }
                float f2 = this.P;
                if (f2 > 0.0f) {
                    return f2;
                }
            } else {
                float f3 = oi1.b;
                if (f3 > 0.0f) {
                    return f3;
                }
                float f4 = this.I;
                if (f4 > 0.0f) {
                    return f4;
                }
            }
            return this.I;
        }
        return invokeV.floatValue;
    }

    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!TextUtils.isEmpty(this.C)) {
                try {
                    return new JSONObject(this.C);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return new JSONObject();
                }
            }
            return new JSONObject();
        }
        return (JSONObject) invokeV.objValue;
    }
}
