package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.b51;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
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
/* loaded from: classes5.dex */
public class kj1 {
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

        public static void a(JSONObject jSONObject, kj1 kj1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, jSONObject, kj1Var) == null) {
                try {
                    kj1Var.a = jSONObject.optInt("advisible");
                    kj1Var.b = jSONObject.optString("id");
                    kj1Var.c = jSONObject.optString("ukey");
                    kj1Var.d = jSONObject.optString("extra");
                    kj1Var.e = jSONObject.optString(TtmlNode.TAG_LAYOUT);
                    kj1Var.f = jSONObject.optInt("type");
                    kj1Var.k = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
                    kj1Var.o = jSONObject.optString("action");
                    kj1Var.p = jSONObject.optString("action_cmd");
                    kj1Var.l = jSONObject.optString("flag_name");
                    kj1Var.m = jSONObject.optInt("logo_type");
                    kj1Var.n = jSONObject.optInt(CriusAttrConstants.DISPLAY);
                    if (kj1Var.n()) {
                        b.a(jSONObject, kj1Var);
                    } else {
                        c.a(jSONObject, kj1Var);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("show_urls");
                    if (optJSONArray != null) {
                        kj1Var.q = new String[optJSONArray.length()];
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            kj1Var.q[i] = optJSONArray.optString(i);
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("click_urls");
                    if (optJSONArray2 != null) {
                        kj1Var.r = new String[optJSONArray2.length()];
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            kj1Var.r[i2] = optJSONArray2.optString(i2);
                        }
                    }
                    kj1Var.s = jSONObject.optLong("start");
                    kj1Var.t = jSONObject.optLong("end");
                    kj1Var.u = jSONObject.optInt("expose_interval");
                    kj1Var.v = jSONObject.optInt("expose_times");
                    kj1Var.w = jSONObject.optInt("preload_type");
                    kj1Var.z = jSONObject.optString("click_float_lottie_url");
                    kj1Var.A = jSONObject.optInt("float_bar_show", 1);
                    kj1Var.B = jSONObject.optInt("click_float_opt", 1);
                    kj1Var.C = jSONObject.optString("style_desc");
                    kj1Var.x = jSONObject.optInt("curRate");
                    kj1Var.E = jSONObject.optInt(TiebaStatic.Params.AD_TYPE);
                    kj1Var.F = jSONObject.optInt("ad_sort");
                    kj1Var.G = jSONObject.optInt("gesture_lottie_type");
                    kj1Var.H = jSONObject.optString("gesture_lottie_url");
                    kj1Var.I = (float) jSONObject.optDouble("gesture_lottie_sensitivity", 0.0d);
                    int optInt = jSONObject.optInt("is_topview", 0);
                    kj1Var.J = optInt;
                    if (optInt == 1 && jSONObject.optJSONObject("topview_data") != null) {
                        kj1Var.K = jSONObject.optJSONObject("topview_data");
                    }
                    if (jSONObject.optJSONObject("animation_data") != null) {
                        kj1Var.L = jSONObject.optJSONObject("animation_data");
                    }
                    kj1Var.M = jSONObject.optInt("shake_update_interval", 67);
                    kj1Var.N = jSONObject.optInt("shake_direction_count", 2);
                    kj1Var.O = jSONObject.optString("key");
                    kj1Var.P = (float) jSONObject.optDouble("hot_shake_sensitivity", 0.0d);
                    kj1Var.Q = jSONObject.optInt("hot_background_time", 0);
                    kj1Var.R = jSONObject.optLong("start_backup");
                    kj1Var.S = jSONObject.optLong("end_backup");
                    kj1Var.T = jSONObject.optInt("virtual", 0);
                    kj1Var.U = (float) jSONObject.optDouble("shake_action_delay_time", -1.0d);
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, kj1 kj1Var) {
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, kj1Var) == null) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
                    if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                        return;
                    }
                    kj1Var.a = optJSONObject.optInt("advisible", 1);
                    kj1Var.b = optJSONObject.optString("id");
                    kj1Var.c = optJSONObject.optString("ukey");
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
                                    kj1Var.d = optString2;
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
                            kj1Var.e = optJSONObject4.optString(TtmlNode.TAG_LAYOUT);
                            JSONObject optJSONObject5 = optJSONObject4.optJSONObject("common");
                            if (optJSONObject5 != null) {
                                kj1Var.f = optJSONObject5.optInt("type");
                                kj1Var.k = optJSONObject5.optString(BigdayActivityConfig.JUMP_URL);
                                kj1Var.o = optJSONObject5.optString("action");
                                kj1Var.p = optJSONObject5.optString("action_cmd");
                                kj1Var.l = optJSONObject5.optString("flag_name");
                                kj1Var.m = optJSONObject5.optInt("logo_type");
                                kj1Var.n = optJSONObject5.optInt(CriusAttrConstants.DISPLAY);
                                JSONArray optJSONArray5 = optJSONObject5.optJSONArray("image_list");
                                kj1Var.z = optJSONObject5.optString("click_float_lottie_url");
                                kj1Var.E = optJSONObject5.optInt(TiebaStatic.Params.AD_TYPE);
                                kj1Var.F = optJSONObject5.optInt("ad_sort");
                                kj1Var.G = optJSONObject5.optInt("gesture_lottie_type");
                                kj1Var.H = optJSONObject5.optString("gesture_lottie_url");
                                kj1Var.I = (float) optJSONObject5.optDouble("gesture_lottie_sensitivity", 0.0d);
                                kj1Var.J = optJSONObject5.optInt("is_topview", 0);
                                if (kj1Var.n() && optJSONArray5 != null && optJSONArray5.length() > 0) {
                                    b.a(optJSONArray5.optJSONObject(0), kj1Var);
                                } else {
                                    c.a(optJSONObject5, kj1Var);
                                }
                                kj1Var.L = optJSONObject5.optJSONObject("animation_data");
                                kj1Var.M = optJSONObject5.optInt("shake_update_interval", 67);
                                kj1Var.N = optJSONObject5.optInt("shake_direction_count", 2);
                                kj1Var.O = optJSONObject5.optString("key");
                                kj1Var.P = (float) optJSONObject5.optDouble("hot_shake_sensitivity", 0.0d);
                                kj1Var.T = optJSONObject5.optInt("virtual", 0);
                                kj1Var.U = (float) optJSONObject5.optDouble("shake_action_delay_time", -1.0d);
                            }
                            JSONArray optJSONArray6 = optJSONObject4.optJSONArray("show_urls");
                            if (optJSONArray6 != null) {
                                kj1Var.q = new String[optJSONArray6.length()];
                                int length = optJSONArray6.length();
                                for (int i2 = 0; i2 < length; i2++) {
                                    kj1Var.q[i2] = optJSONArray6.optString(i2);
                                }
                            }
                            JSONArray optJSONArray7 = optJSONObject4.optJSONArray("click_urls");
                            if (optJSONArray7 != null) {
                                kj1Var.r = new String[optJSONArray7.length()];
                                int length2 = optJSONArray7.length();
                                for (int i3 = 0; i3 < length2; i3++) {
                                    kj1Var.r[i3] = optJSONArray7.optString(i3);
                                }
                            }
                            JSONObject optJSONObject6 = optJSONObject4.optJSONObject("policy");
                            if (optJSONObject6 != null) {
                                JSONObject optJSONObject7 = optJSONObject6.optJSONObject("expire_time");
                                if (optJSONObject7 != null) {
                                    kj1Var.s = optJSONObject7.optLong("start");
                                    kj1Var.t = optJSONObject7.optLong("end");
                                }
                                kj1Var.u = optJSONObject6.optInt("expose_interval");
                                kj1Var.v = optJSONObject6.optInt("expose_times");
                                kj1Var.w = optJSONObject6.optInt("preload_type");
                                kj1Var.A = optJSONObject6.optInt("float_bar_show", 1);
                                kj1Var.B = optJSONObject6.optInt("click_float_opt", 1);
                                kj1Var.C = optJSONObject6.optString("style_desc");
                                kj1Var.Q = optJSONObject6.optInt("hot_background_time", 0);
                                JSONObject optJSONObject8 = optJSONObject6.optJSONObject("expire_time_backup");
                                if (optJSONObject8 != null) {
                                    kj1Var.R = optJSONObject8.optLong("start");
                                    kj1Var.S = optJSONObject8.optLong("end");
                                }
                            }
                            JSONObject optJSONObject9 = optJSONObject4.optJSONObject("topview_data");
                            if (kj1Var.J == 1 && optJSONObject9 != null) {
                                JSONObject optJSONObject10 = optJSONObject9.optJSONObject("content");
                                if (optJSONObject10 == null) {
                                    kj1Var.J = 0;
                                    return;
                                }
                                JSONObject jSONObject2 = new JSONObject();
                                y11.f(jSONObject2, "click_float_lottie_url", kj1Var.z);
                                y11.d(jSONObject2, "click_float_opt", kj1Var.B);
                                y11.d(jSONObject2, "float_bar_show", kj1Var.A);
                                y11.g(jSONObject2, SetImageWatermarkTypeReqMsg.SWITCH, true);
                                y11.f(jSONObject2, "style_desc", kj1Var.C);
                                y11.d(jSONObject2, "countdown", kj1Var.n);
                                y11.f(jSONObject2, "source_path", ij1.r(kj1Var.g));
                                y11.f(optJSONObject10, "topview", jSONObject2);
                                kj1Var.K = optJSONObject9;
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }

        public static void c(JSONObject jSONObject, kj1 kj1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, jSONObject, kj1Var) == null) {
                try {
                    jSONObject.put("advisible", kj1Var.a);
                    jSONObject.put("id", kj1Var.b);
                    jSONObject.put("ukey", kj1Var.c);
                    jSONObject.put("extra", kj1Var.d);
                    jSONObject.put(TtmlNode.TAG_LAYOUT, kj1Var.e);
                    jSONObject.put("type", kj1Var.f);
                    jSONObject.put(BigdayActivityConfig.JUMP_URL, kj1Var.k);
                    jSONObject.put("action", kj1Var.o);
                    jSONObject.put("action_cmd", kj1Var.p);
                    jSONObject.put("flag_name", kj1Var.l);
                    jSONObject.put("logo_type", kj1Var.m);
                    jSONObject.put(CriusAttrConstants.DISPLAY, kj1Var.n);
                    jSONObject.put("start", kj1Var.s);
                    jSONObject.put("end", kj1Var.t);
                    jSONObject.put("expose_times", kj1Var.v);
                    jSONObject.put("expose_interval", kj1Var.u);
                    jSONObject.put("preload_type", kj1Var.w);
                    jSONObject.put("curRate", kj1Var.x);
                    jSONObject.put("click_float_lottie_url", kj1Var.z);
                    jSONObject.put("float_bar_show", kj1Var.A);
                    jSONObject.put("click_float_opt", kj1Var.B);
                    jSONObject.put("style_desc", kj1Var.C);
                    jSONObject.put(TiebaStatic.Params.AD_TYPE, kj1Var.E);
                    jSONObject.put("ad_sort", kj1Var.F);
                    jSONObject.put("gesture_lottie_type", kj1Var.G);
                    jSONObject.put("gesture_lottie_url", kj1Var.H);
                    jSONObject.put("gesture_lottie_sensitivity", kj1Var.I);
                    jSONObject.put("is_topview", kj1Var.J);
                    jSONObject.put("start_backup", kj1Var.R);
                    jSONObject.put("end_backup", kj1Var.S);
                    if (kj1Var.J == 1 && kj1Var.K != null) {
                        jSONObject.put("topview_data", kj1Var.K);
                    }
                    if (kj1Var.L != null) {
                        jSONObject.put("animation_data", kj1Var.L);
                    }
                    jSONObject.put("shake_update_interval", kj1Var.M);
                    jSONObject.put("shake_direction_count", kj1Var.N);
                    jSONObject.put("key", kj1Var.O);
                    jSONObject.put("hot_shake_sensitivity", kj1Var.P);
                    jSONObject.put("hot_background_time", kj1Var.Q);
                    jSONObject.put("virtual", kj1Var.T);
                    jSONObject.put("shake_action_delay_time", kj1Var.U);
                    if (kj1Var.q != null) {
                        if (b51.b.c()) {
                            jSONObject.put("show_urls", new JSONArray(kj1Var.q));
                        } else {
                            jSONObject.put("show_urls", new JSONArray((Collection) Arrays.asList(kj1Var.q)));
                        }
                    }
                    if (kj1Var.r != null) {
                        if (b51.b.c()) {
                            jSONObject.put("click_urls", new JSONArray(kj1Var.r));
                        } else {
                            jSONObject.put("click_urls", new JSONArray((Collection) Arrays.asList(kj1Var.r)));
                        }
                    }
                    if (kj1Var.n()) {
                        b.b(jSONObject, kj1Var);
                    } else {
                        c.b(jSONObject, kj1Var);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void d(kj1 kj1Var, kj1 kj1Var2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, kj1Var, kj1Var2) == null) {
                kj1Var.a = kj1Var2.a;
                kj1Var.b = kj1Var2.b;
                kj1Var.c = kj1Var2.c;
                kj1Var.d = kj1Var2.d;
                kj1Var.e = kj1Var2.e;
                kj1Var.f = kj1Var2.f;
                kj1Var.g = kj1Var2.g;
                kj1Var.h = kj1Var2.h;
                kj1Var.i = kj1Var2.i;
                kj1Var.j = kj1Var2.j;
                kj1Var.k = kj1Var2.k;
                kj1Var.l = kj1Var2.l;
                kj1Var.m = kj1Var2.m;
                kj1Var.n = kj1Var2.n;
                kj1Var.o = kj1Var2.o;
                kj1Var.p = kj1Var2.p;
                kj1Var.q = kj1Var2.q;
                kj1Var.r = kj1Var2.r;
                kj1Var.s = kj1Var2.s;
                kj1Var.t = kj1Var2.t;
                kj1Var.u = kj1Var2.u;
                kj1Var.v = kj1Var2.v;
                kj1Var.x = kj1Var2.x;
                kj1Var.z = kj1Var2.z;
                kj1Var.A = kj1Var2.A;
                kj1Var.B = kj1Var2.B;
                kj1Var.C = kj1Var2.C;
                kj1Var.E = kj1Var2.E;
                kj1Var.F = kj1Var2.F;
                kj1Var.G = kj1Var2.G;
                kj1Var.H = kj1Var2.H;
                kj1Var.I = kj1Var2.I;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, kj1 kj1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65536, null, jSONObject, kj1Var) == null) && jSONObject != null) {
                try {
                    kj1Var.g = jSONObject.optString("url");
                    kj1Var.h = jSONObject.optInt("width");
                    kj1Var.i = jSONObject.optInt("height");
                    kj1Var.j = jSONObject.optString("imageMd5");
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, kj1 kj1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, kj1Var) == null) {
                try {
                    jSONObject.put("url", kj1Var.g);
                    jSONObject.put("imageMd5", kj1Var.j);
                    jSONObject.put("width", kj1Var.h);
                    jSONObject.put("height", kj1Var.i);
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

        public static void a(JSONObject jSONObject, kj1 kj1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65536, null, jSONObject, kj1Var) == null) && jSONObject != null) {
                try {
                    kj1Var.g = jSONObject.optString("url");
                    kj1Var.h = jSONObject.optInt("width");
                    kj1Var.i = jSONObject.optInt("height");
                    kj1Var.j = jSONObject.optString(PackageTable.MD5);
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, kj1 kj1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, kj1Var) == null) {
                try {
                    jSONObject.put("url", kj1Var.g);
                    jSONObject.put(PackageTable.MD5, kj1Var.j);
                    jSONObject.put("width", kj1Var.h);
                    jSONObject.put("height", kj1Var.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public kj1() {
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
            float f = jj1.f;
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
            int i = jj1.e;
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
            int i = jj1.d;
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

    public static boolean b(kj1 kj1Var) {
        InterceptResult invokeL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, kj1Var)) == null) {
            if (TextUtils.isEmpty(kj1Var.d)) {
                str = "7";
                z = false;
            } else {
                str = "";
                z = true;
            }
            String str2 = PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW;
            if (z && TextUtils.isEmpty(kj1Var.g)) {
                str = PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW;
                z = false;
            }
            if (z && System.currentTimeMillis() / 1000 > kj1Var.t) {
                str = "68";
                z = false;
            }
            if (z && kj1Var.p() && (kj1Var.g.endsWith(".jpeg") || kj1Var.g.endsWith(".jpg") || kj1Var.g.endsWith(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX) || kj1Var.g.endsWith(".webp"))) {
                str = PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW;
                z = false;
            }
            if (z && kj1Var.n() && (kj1Var.g.endsWith(DefaultHlsExtractorFactory.MP4_FILE_EXTENSION) || kj1Var.g.endsWith(".MP4") || kj1Var.g.endsWith(".mov"))) {
                z = false;
            } else {
                str2 = str;
            }
            if (z) {
                return true;
            }
            new BaseVM(kj1Var).g(str2);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static kj1 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            kj1 kj1Var = new kj1();
            try {
                a.a(jSONObject, kj1Var);
            } catch (Exception unused) {
            }
            return kj1Var;
        }
        return (kj1) invokeL.objValue;
    }

    public static kj1 d(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            try {
                kj1 kj1Var = new kj1();
                a.b(jSONObject, kj1Var);
                return kj1Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (kj1) invokeL.objValue;
    }

    public static List<kj1> r(JSONArray jSONArray) {
        InterceptResult invokeL;
        kj1 d;
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

    public static void t(kj1 kj1Var, kj1 kj1Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, kj1Var, kj1Var2) == null) {
            a.d(kj1Var, kj1Var2);
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
            if (cj1.b() == 1) {
                float f = jj1.c;
                if (f > 0.0f) {
                    return f;
                }
                float f2 = this.P;
                if (f2 > 0.0f) {
                    return f2;
                }
            } else {
                float f3 = jj1.b;
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
