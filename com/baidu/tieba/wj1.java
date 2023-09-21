package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.p61;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class wj1 {
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

    /* renamed from: T  reason: collision with root package name */
    public int f1174T;
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
    public double u;
    public int v;
    public int w;
    public int x;
    public boolean y;
    public String z;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, wj1 wj1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, jSONObject, wj1Var) == null) {
                try {
                    wj1Var.a = jSONObject.optInt("advisible");
                    wj1Var.b = jSONObject.optString("id");
                    wj1Var.c = jSONObject.optString("ukey");
                    wj1Var.d = jSONObject.optString("extra");
                    wj1Var.e = jSONObject.optString(TtmlNode.TAG_LAYOUT);
                    wj1Var.f = jSONObject.optInt("type");
                    wj1Var.k = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
                    wj1Var.o = jSONObject.optString("action");
                    wj1Var.p = jSONObject.optString("action_cmd");
                    wj1Var.l = jSONObject.optString("flag_name");
                    wj1Var.m = jSONObject.optInt("logo_type");
                    wj1Var.n = jSONObject.optInt(CriusAttrConstants.DISPLAY);
                    if (wj1Var.n()) {
                        b.a(jSONObject, wj1Var);
                    } else {
                        c.a(jSONObject, wj1Var);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("show_urls");
                    if (optJSONArray != null) {
                        wj1Var.q = new String[optJSONArray.length()];
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            wj1Var.q[i] = optJSONArray.optString(i);
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("click_urls");
                    if (optJSONArray2 != null) {
                        wj1Var.r = new String[optJSONArray2.length()];
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            wj1Var.r[i2] = optJSONArray2.optString(i2);
                        }
                    }
                    wj1Var.s = jSONObject.optLong("start");
                    wj1Var.t = jSONObject.optLong("end");
                    wj1Var.u = jSONObject.optDouble("expose_interval", 0.0d);
                    wj1Var.v = jSONObject.optInt("expose_times");
                    wj1Var.w = jSONObject.optInt("preload_type");
                    wj1Var.z = jSONObject.optString("click_float_lottie_url");
                    wj1Var.A = jSONObject.optInt("float_bar_show", 1);
                    wj1Var.B = jSONObject.optInt("click_float_opt", 1);
                    wj1Var.C = jSONObject.optString("style_desc");
                    wj1Var.x = jSONObject.optInt("curRate");
                    wj1Var.E = jSONObject.optInt(TiebaStatic.Params.AD_TYPE);
                    wj1Var.F = jSONObject.optInt("ad_sort");
                    wj1Var.G = jSONObject.optInt("gesture_lottie_type");
                    wj1Var.H = jSONObject.optString("gesture_lottie_url");
                    wj1Var.I = (float) jSONObject.optDouble("gesture_lottie_sensitivity", 0.0d);
                    wj1Var.X = jSONObject.optInt("gesture_lottie_direction", 1);
                    int optInt = jSONObject.optInt("is_topview", 0);
                    wj1Var.J = optInt;
                    if (optInt == 1 && jSONObject.optJSONObject("topview_data") != null) {
                        wj1Var.K = jSONObject.optJSONObject("topview_data");
                    }
                    if (jSONObject.optJSONObject("animation_data") != null) {
                        wj1Var.L = jSONObject.optJSONObject("animation_data");
                    }
                    wj1Var.M = jSONObject.optInt("shake_update_interval", 67);
                    wj1Var.N = jSONObject.optInt("shake_direction_count", 2);
                    wj1Var.O = jSONObject.optString("key");
                    wj1Var.P = (float) jSONObject.optDouble("hot_shake_sensitivity", 0.0d);
                    wj1Var.Q = jSONObject.optInt("hot_background_time", 0);
                    wj1Var.V = jSONObject.optString("m_ua");
                    wj1Var.W = jSONObject.optString("m_pn");
                    wj1Var.R = jSONObject.optLong("start_backup");
                    wj1Var.S = jSONObject.optLong("end_backup");
                    wj1Var.f1174T = jSONObject.optInt("virtual", 0);
                    wj1Var.U = (float) jSONObject.optDouble("shake_action_delay_time", -1.0d);
                } catch (Exception unused) {
                }
            }
        }

        public static void c(JSONObject jSONObject, wj1 wj1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, jSONObject, wj1Var) == null) {
                try {
                    jSONObject.put("advisible", wj1Var.a);
                    jSONObject.put("id", wj1Var.b);
                    jSONObject.put("ukey", wj1Var.c);
                    jSONObject.put("extra", wj1Var.d);
                    jSONObject.put(TtmlNode.TAG_LAYOUT, wj1Var.e);
                    jSONObject.put("type", wj1Var.f);
                    jSONObject.put(BigdayActivityConfig.JUMP_URL, wj1Var.k);
                    jSONObject.put("action", wj1Var.o);
                    jSONObject.put("action_cmd", wj1Var.p);
                    jSONObject.put("flag_name", wj1Var.l);
                    jSONObject.put("logo_type", wj1Var.m);
                    jSONObject.put(CriusAttrConstants.DISPLAY, wj1Var.n);
                    jSONObject.put("start", wj1Var.s);
                    jSONObject.put("end", wj1Var.t);
                    jSONObject.put("expose_times", wj1Var.v);
                    jSONObject.put("expose_interval", wj1Var.u);
                    jSONObject.put("preload_type", wj1Var.w);
                    jSONObject.put("curRate", wj1Var.x);
                    jSONObject.put("click_float_lottie_url", wj1Var.z);
                    jSONObject.put("float_bar_show", wj1Var.A);
                    jSONObject.put("click_float_opt", wj1Var.B);
                    jSONObject.put("style_desc", wj1Var.C);
                    jSONObject.put(TiebaStatic.Params.AD_TYPE, wj1Var.E);
                    jSONObject.put("ad_sort", wj1Var.F);
                    jSONObject.put("gesture_lottie_type", wj1Var.G);
                    jSONObject.put("gesture_lottie_url", wj1Var.H);
                    jSONObject.put("gesture_lottie_sensitivity", wj1Var.I);
                    jSONObject.put("gesture_lottie_direction", wj1Var.X);
                    jSONObject.put("is_topview", wj1Var.J);
                    jSONObject.put("start_backup", wj1Var.R);
                    jSONObject.put("end_backup", wj1Var.S);
                    if (wj1Var.J == 1 && wj1Var.K != null) {
                        jSONObject.put("topview_data", wj1Var.K);
                    }
                    if (wj1Var.L != null) {
                        jSONObject.put("animation_data", wj1Var.L);
                    }
                    jSONObject.put("shake_update_interval", wj1Var.M);
                    jSONObject.put("shake_direction_count", wj1Var.N);
                    jSONObject.put("key", wj1Var.O);
                    jSONObject.put("hot_shake_sensitivity", wj1Var.P);
                    jSONObject.put("hot_background_time", wj1Var.Q);
                    jSONObject.put("virtual", wj1Var.f1174T);
                    jSONObject.put("shake_action_delay_time", wj1Var.U);
                    jSONObject.put("m_ua", wj1Var.V);
                    jSONObject.put("m_pn", wj1Var.W);
                    if (wj1Var.q != null) {
                        if (p61.b.c()) {
                            jSONObject.put("show_urls", new JSONArray(wj1Var.q));
                        } else {
                            jSONObject.put("show_urls", new JSONArray((Collection) Arrays.asList(wj1Var.q)));
                        }
                    }
                    if (wj1Var.r != null) {
                        if (p61.b.c()) {
                            jSONObject.put("click_urls", new JSONArray(wj1Var.r));
                        } else {
                            jSONObject.put("click_urls", new JSONArray((Collection) Arrays.asList(wj1Var.r)));
                        }
                    }
                    if (wj1Var.n()) {
                        b.b(jSONObject, wj1Var);
                    } else {
                        c.b(jSONObject, wj1Var);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void b(JSONObject jSONObject, wj1 wj1Var) {
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, wj1Var) == null) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
                    if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                        return;
                    }
                    wj1Var.a = optJSONObject.optInt("advisible", 1);
                    wj1Var.b = optJSONObject.optString("id");
                    wj1Var.c = optJSONObject.optString("ukey");
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
                                    wj1Var.d = optString2;
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
                            wj1Var.e = optJSONObject4.optString(TtmlNode.TAG_LAYOUT);
                            JSONObject optJSONObject5 = optJSONObject4.optJSONObject("common");
                            if (optJSONObject5 != null) {
                                wj1Var.f = optJSONObject5.optInt("type");
                                wj1Var.k = optJSONObject5.optString(BigdayActivityConfig.JUMP_URL);
                                wj1Var.o = optJSONObject5.optString("action");
                                wj1Var.p = optJSONObject5.optString("action_cmd");
                                wj1Var.l = optJSONObject5.optString("flag_name");
                                wj1Var.m = optJSONObject5.optInt("logo_type");
                                wj1Var.n = optJSONObject5.optInt(CriusAttrConstants.DISPLAY);
                                JSONArray optJSONArray5 = optJSONObject5.optJSONArray("image_list");
                                wj1Var.z = optJSONObject5.optString("click_float_lottie_url");
                                wj1Var.E = optJSONObject5.optInt(TiebaStatic.Params.AD_TYPE);
                                wj1Var.F = optJSONObject5.optInt("ad_sort");
                                wj1Var.G = optJSONObject5.optInt("gesture_lottie_type");
                                wj1Var.H = optJSONObject5.optString("gesture_lottie_url");
                                wj1Var.I = (float) optJSONObject5.optDouble("gesture_lottie_sensitivity", 0.0d);
                                wj1Var.X = optJSONObject5.optInt("gesture_lottie_direction", 1);
                                wj1Var.J = optJSONObject5.optInt("is_topview", 0);
                                if (wj1Var.n() && optJSONArray5 != null && optJSONArray5.length() > 0) {
                                    b.a(optJSONArray5.optJSONObject(0), wj1Var);
                                } else {
                                    c.a(optJSONObject5, wj1Var);
                                }
                                wj1Var.L = optJSONObject5.optJSONObject("animation_data");
                                wj1Var.M = optJSONObject5.optInt("shake_update_interval", 67);
                                wj1Var.N = optJSONObject5.optInt("shake_direction_count", 2);
                                wj1Var.O = optJSONObject5.optString("key");
                                wj1Var.P = (float) optJSONObject5.optDouble("hot_shake_sensitivity", 0.0d);
                                wj1Var.f1174T = optJSONObject5.optInt("virtual", 0);
                                wj1Var.U = (float) optJSONObject5.optDouble("shake_action_delay_time", -1.0d);
                            }
                            JSONArray optJSONArray6 = optJSONObject4.optJSONArray("show_urls");
                            if (optJSONArray6 != null) {
                                wj1Var.q = new String[optJSONArray6.length()];
                                int length = optJSONArray6.length();
                                for (int i2 = 0; i2 < length; i2++) {
                                    wj1Var.q[i2] = optJSONArray6.optString(i2);
                                }
                            }
                            JSONArray optJSONArray7 = optJSONObject4.optJSONArray("click_urls");
                            if (optJSONArray7 != null) {
                                wj1Var.r = new String[optJSONArray7.length()];
                                int length2 = optJSONArray7.length();
                                for (int i3 = 0; i3 < length2; i3++) {
                                    wj1Var.r[i3] = optJSONArray7.optString(i3);
                                }
                            }
                            JSONObject optJSONObject6 = optJSONObject4.optJSONObject("policy");
                            if (optJSONObject6 != null) {
                                JSONObject optJSONObject7 = optJSONObject6.optJSONObject("expire_time");
                                if (optJSONObject7 != null) {
                                    wj1Var.s = optJSONObject7.optLong("start");
                                    wj1Var.t = optJSONObject7.optLong("end");
                                }
                                wj1Var.u = optJSONObject6.optDouble("expose_interval", 0.0d);
                                wj1Var.v = optJSONObject6.optInt("expose_times");
                                wj1Var.w = optJSONObject6.optInt("preload_type");
                                wj1Var.A = optJSONObject6.optInt("float_bar_show", 1);
                                wj1Var.B = optJSONObject6.optInt("click_float_opt", 1);
                                wj1Var.C = optJSONObject6.optString("style_desc");
                                wj1Var.Q = optJSONObject6.optInt("hot_background_time", 0);
                                JSONObject optJSONObject8 = optJSONObject6.optJSONObject("expire_time_backup");
                                String optString4 = optJSONObject6.optString("m_ua");
                                if (!TextUtils.isEmpty(optString4)) {
                                    wj1Var.V = new String(Base64.decode(optString4.getBytes(), 0));
                                }
                                String optString5 = optJSONObject6.optString("m_pn");
                                if (!TextUtils.isEmpty(optString5)) {
                                    wj1Var.W = new String(Base64.decode(optString5.getBytes(), 0));
                                }
                                if (optJSONObject8 != null) {
                                    wj1Var.R = optJSONObject8.optLong("start");
                                    wj1Var.S = optJSONObject8.optLong("end");
                                }
                            }
                            JSONObject optJSONObject9 = optJSONObject4.optJSONObject("topview_data");
                            if (wj1Var.J == 1 && optJSONObject9 != null) {
                                JSONObject optJSONObject10 = optJSONObject9.optJSONObject("content");
                                if (optJSONObject10 == null) {
                                    wj1Var.J = 0;
                                    return;
                                }
                                JSONObject jSONObject2 = new JSONObject();
                                h31.f(jSONObject2, "click_float_lottie_url", wj1Var.z);
                                h31.d(jSONObject2, "click_float_opt", wj1Var.B);
                                h31.d(jSONObject2, "float_bar_show", wj1Var.A);
                                h31.g(jSONObject2, "switch", true);
                                h31.f(jSONObject2, "style_desc", wj1Var.C);
                                h31.d(jSONObject2, "countdown", wj1Var.n);
                                h31.f(jSONObject2, "source_path", uj1.r(wj1Var.g));
                                h31.f(optJSONObject10, "topview", jSONObject2);
                                wj1Var.K = optJSONObject9;
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }

        public static void d(wj1 wj1Var, wj1 wj1Var2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, wj1Var, wj1Var2) == null) {
                wj1Var.a = wj1Var2.a;
                wj1Var.b = wj1Var2.b;
                wj1Var.c = wj1Var2.c;
                wj1Var.d = wj1Var2.d;
                wj1Var.e = wj1Var2.e;
                wj1Var.f = wj1Var2.f;
                wj1Var.g = wj1Var2.g;
                wj1Var.h = wj1Var2.h;
                wj1Var.i = wj1Var2.i;
                wj1Var.j = wj1Var2.j;
                wj1Var.k = wj1Var2.k;
                wj1Var.l = wj1Var2.l;
                wj1Var.m = wj1Var2.m;
                wj1Var.n = wj1Var2.n;
                wj1Var.o = wj1Var2.o;
                wj1Var.p = wj1Var2.p;
                wj1Var.q = wj1Var2.q;
                wj1Var.r = wj1Var2.r;
                wj1Var.s = wj1Var2.s;
                wj1Var.t = wj1Var2.t;
                wj1Var.u = wj1Var2.u;
                wj1Var.v = wj1Var2.v;
                wj1Var.x = wj1Var2.x;
                wj1Var.z = wj1Var2.z;
                wj1Var.A = wj1Var2.A;
                wj1Var.B = wj1Var2.B;
                wj1Var.C = wj1Var2.C;
                wj1Var.E = wj1Var2.E;
                wj1Var.F = wj1Var2.F;
                wj1Var.G = wj1Var2.G;
                wj1Var.H = wj1Var2.H;
                wj1Var.I = wj1Var2.I;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, wj1 wj1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65536, null, jSONObject, wj1Var) == null) && jSONObject != null) {
                try {
                    wj1Var.g = jSONObject.optString("url");
                    wj1Var.h = jSONObject.optInt("width");
                    wj1Var.i = jSONObject.optInt("height");
                    wj1Var.j = jSONObject.optString("imageMd5");
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, wj1 wj1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, wj1Var) == null) {
                try {
                    jSONObject.put("url", wj1Var.g);
                    jSONObject.put("imageMd5", wj1Var.j);
                    jSONObject.put("width", wj1Var.h);
                    jSONObject.put("height", wj1Var.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, wj1 wj1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65536, null, jSONObject, wj1Var) == null) && jSONObject != null) {
                try {
                    wj1Var.g = jSONObject.optString("url");
                    wj1Var.h = jSONObject.optInt("width");
                    wj1Var.i = jSONObject.optInt("height");
                    wj1Var.j = jSONObject.optString(PackageTable.MD5);
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, wj1 wj1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, wj1Var) == null) {
                try {
                    jSONObject.put("url", wj1Var.g);
                    jSONObject.put(PackageTable.MD5, wj1Var.j);
                    jSONObject.put("width", wj1Var.h);
                    jSONObject.put("height", wj1Var.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public wj1() {
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
            float f = vj1.f;
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
            int i = vj1.e;
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
            int i = vj1.d;
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
            if (this.f1174T == 1) {
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

    public static boolean b(wj1 wj1Var) {
        InterceptResult invokeL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, wj1Var)) == null) {
            if (TextUtils.isEmpty(wj1Var.d)) {
                str = "7";
                z = false;
            } else {
                str = "";
                z = true;
            }
            String str2 = PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW;
            if (z && TextUtils.isEmpty(wj1Var.g)) {
                str = PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW;
                z = false;
            }
            if (z && System.currentTimeMillis() / 1000 > wj1Var.t) {
                str = PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK;
                z = false;
            }
            if (z && wj1Var.p() && (wj1Var.g.endsWith(".jpeg") || wj1Var.g.endsWith(".jpg") || wj1Var.g.endsWith(".png") || wj1Var.g.endsWith(".webp"))) {
                str = PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW;
                z = false;
            }
            if (z && wj1Var.n() && (wj1Var.g.endsWith(DefaultHlsExtractorFactory.MP4_FILE_EXTENSION) || wj1Var.g.endsWith(".MP4") || wj1Var.g.endsWith(".mov"))) {
                z = false;
            } else {
                str2 = str;
            }
            if (z) {
                return true;
            }
            new BaseVM(wj1Var).g(str2);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static wj1 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            wj1 wj1Var = new wj1();
            try {
                a.a(jSONObject, wj1Var);
            } catch (Exception unused) {
            }
            return wj1Var;
        }
        return (wj1) invokeL.objValue;
    }

    public static wj1 d(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            try {
                wj1 wj1Var = new wj1();
                a.b(jSONObject, wj1Var);
                return wj1Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (wj1) invokeL.objValue;
    }

    public static List<wj1> r(JSONArray jSONArray) {
        InterceptResult invokeL;
        wj1 d;
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

    public static void t(wj1 wj1Var, wj1 wj1Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, wj1Var, wj1Var2) == null) {
            a.d(wj1Var, wj1Var2);
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
            if (oj1.b() == 1) {
                float f = vj1.c;
                if (f > 0.0f) {
                    return f;
                }
                float f2 = this.P;
                if (f2 > 0.0f) {
                    return f2;
                }
            } else {
                float f3 = vj1.b;
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
