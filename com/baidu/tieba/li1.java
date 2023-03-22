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
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.tieba.z31;
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
public class li1 {
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

        public static void a(JSONObject jSONObject, li1 li1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, jSONObject, li1Var) == null) {
                try {
                    li1Var.a = jSONObject.optInt("advisible");
                    li1Var.b = jSONObject.optString("id");
                    li1Var.c = jSONObject.optString("ukey");
                    li1Var.d = jSONObject.optString("extra");
                    li1Var.e = jSONObject.optString(TtmlNode.TAG_LAYOUT);
                    li1Var.f = jSONObject.optInt("type");
                    li1Var.k = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
                    li1Var.o = jSONObject.optString("action");
                    li1Var.p = jSONObject.optString("action_cmd");
                    li1Var.l = jSONObject.optString("flag_name");
                    li1Var.m = jSONObject.optInt("logo_type");
                    li1Var.n = jSONObject.optInt(CriusAttrConstants.DISPLAY);
                    if (li1Var.n()) {
                        b.a(jSONObject, li1Var);
                    } else {
                        c.a(jSONObject, li1Var);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("show_urls");
                    if (optJSONArray != null) {
                        li1Var.q = new String[optJSONArray.length()];
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            li1Var.q[i] = optJSONArray.optString(i);
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("click_urls");
                    if (optJSONArray2 != null) {
                        li1Var.r = new String[optJSONArray2.length()];
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            li1Var.r[i2] = optJSONArray2.optString(i2);
                        }
                    }
                    li1Var.s = jSONObject.optLong("start");
                    li1Var.t = jSONObject.optLong("end");
                    li1Var.u = jSONObject.optInt("expose_interval");
                    li1Var.v = jSONObject.optInt("expose_times");
                    li1Var.w = jSONObject.optInt("preload_type");
                    li1Var.z = jSONObject.optString("click_float_lottie_url");
                    li1Var.A = jSONObject.optInt("float_bar_show", 1);
                    li1Var.B = jSONObject.optInt("click_float_opt", 1);
                    li1Var.C = jSONObject.optString("style_desc");
                    li1Var.x = jSONObject.optInt("curRate");
                    li1Var.E = jSONObject.optInt(TiebaStatic.Params.AD_TYPE);
                    li1Var.F = jSONObject.optInt("ad_sort");
                    li1Var.G = jSONObject.optInt("gesture_lottie_type");
                    li1Var.H = jSONObject.optString("gesture_lottie_url");
                    li1Var.I = (float) jSONObject.optDouble("gesture_lottie_sensitivity", 0.0d);
                    li1Var.X = jSONObject.optInt("gesture_lottie_direction", 1);
                    int optInt = jSONObject.optInt("is_topview", 0);
                    li1Var.J = optInt;
                    if (optInt == 1 && jSONObject.optJSONObject("topview_data") != null) {
                        li1Var.K = jSONObject.optJSONObject("topview_data");
                    }
                    if (jSONObject.optJSONObject("animation_data") != null) {
                        li1Var.L = jSONObject.optJSONObject("animation_data");
                    }
                    li1Var.M = jSONObject.optInt("shake_update_interval", 67);
                    li1Var.N = jSONObject.optInt("shake_direction_count", 2);
                    li1Var.O = jSONObject.optString("key");
                    li1Var.P = (float) jSONObject.optDouble("hot_shake_sensitivity", 0.0d);
                    li1Var.Q = jSONObject.optInt("hot_background_time", 0);
                    li1Var.V = jSONObject.optString("m_ua");
                    li1Var.W = jSONObject.optString("m_pn");
                    li1Var.R = jSONObject.optLong("start_backup");
                    li1Var.S = jSONObject.optLong("end_backup");
                    li1Var.T = jSONObject.optInt("virtual", 0);
                    li1Var.U = (float) jSONObject.optDouble("shake_action_delay_time", -1.0d);
                } catch (Exception unused) {
                }
            }
        }

        public static void c(JSONObject jSONObject, li1 li1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, jSONObject, li1Var) == null) {
                try {
                    jSONObject.put("advisible", li1Var.a);
                    jSONObject.put("id", li1Var.b);
                    jSONObject.put("ukey", li1Var.c);
                    jSONObject.put("extra", li1Var.d);
                    jSONObject.put(TtmlNode.TAG_LAYOUT, li1Var.e);
                    jSONObject.put("type", li1Var.f);
                    jSONObject.put(BigdayActivityConfig.JUMP_URL, li1Var.k);
                    jSONObject.put("action", li1Var.o);
                    jSONObject.put("action_cmd", li1Var.p);
                    jSONObject.put("flag_name", li1Var.l);
                    jSONObject.put("logo_type", li1Var.m);
                    jSONObject.put(CriusAttrConstants.DISPLAY, li1Var.n);
                    jSONObject.put("start", li1Var.s);
                    jSONObject.put("end", li1Var.t);
                    jSONObject.put("expose_times", li1Var.v);
                    jSONObject.put("expose_interval", li1Var.u);
                    jSONObject.put("preload_type", li1Var.w);
                    jSONObject.put("curRate", li1Var.x);
                    jSONObject.put("click_float_lottie_url", li1Var.z);
                    jSONObject.put("float_bar_show", li1Var.A);
                    jSONObject.put("click_float_opt", li1Var.B);
                    jSONObject.put("style_desc", li1Var.C);
                    jSONObject.put(TiebaStatic.Params.AD_TYPE, li1Var.E);
                    jSONObject.put("ad_sort", li1Var.F);
                    jSONObject.put("gesture_lottie_type", li1Var.G);
                    jSONObject.put("gesture_lottie_url", li1Var.H);
                    jSONObject.put("gesture_lottie_sensitivity", li1Var.I);
                    jSONObject.put("gesture_lottie_direction", li1Var.X);
                    jSONObject.put("is_topview", li1Var.J);
                    jSONObject.put("start_backup", li1Var.R);
                    jSONObject.put("end_backup", li1Var.S);
                    if (li1Var.J == 1 && li1Var.K != null) {
                        jSONObject.put("topview_data", li1Var.K);
                    }
                    if (li1Var.L != null) {
                        jSONObject.put("animation_data", li1Var.L);
                    }
                    jSONObject.put("shake_update_interval", li1Var.M);
                    jSONObject.put("shake_direction_count", li1Var.N);
                    jSONObject.put("key", li1Var.O);
                    jSONObject.put("hot_shake_sensitivity", li1Var.P);
                    jSONObject.put("hot_background_time", li1Var.Q);
                    jSONObject.put("virtual", li1Var.T);
                    jSONObject.put("shake_action_delay_time", li1Var.U);
                    jSONObject.put("m_ua", li1Var.V);
                    jSONObject.put("m_pn", li1Var.W);
                    if (li1Var.q != null) {
                        if (z31.b.c()) {
                            jSONObject.put("show_urls", new JSONArray(li1Var.q));
                        } else {
                            jSONObject.put("show_urls", new JSONArray((Collection) Arrays.asList(li1Var.q)));
                        }
                    }
                    if (li1Var.r != null) {
                        if (z31.b.c()) {
                            jSONObject.put("click_urls", new JSONArray(li1Var.r));
                        } else {
                            jSONObject.put("click_urls", new JSONArray((Collection) Arrays.asList(li1Var.r)));
                        }
                    }
                    if (li1Var.n()) {
                        b.b(jSONObject, li1Var);
                    } else {
                        c.b(jSONObject, li1Var);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void b(JSONObject jSONObject, li1 li1Var) {
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, li1Var) == null) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
                    if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                        return;
                    }
                    li1Var.a = optJSONObject.optInt("advisible", 1);
                    li1Var.b = optJSONObject.optString("id");
                    li1Var.c = optJSONObject.optString("ukey");
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
                                    li1Var.d = optString2;
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
                            li1Var.e = optJSONObject4.optString(TtmlNode.TAG_LAYOUT);
                            JSONObject optJSONObject5 = optJSONObject4.optJSONObject("common");
                            if (optJSONObject5 != null) {
                                li1Var.f = optJSONObject5.optInt("type");
                                li1Var.k = optJSONObject5.optString(BigdayActivityConfig.JUMP_URL);
                                li1Var.o = optJSONObject5.optString("action");
                                li1Var.p = optJSONObject5.optString("action_cmd");
                                li1Var.l = optJSONObject5.optString("flag_name");
                                li1Var.m = optJSONObject5.optInt("logo_type");
                                li1Var.n = optJSONObject5.optInt(CriusAttrConstants.DISPLAY);
                                JSONArray optJSONArray5 = optJSONObject5.optJSONArray("image_list");
                                li1Var.z = optJSONObject5.optString("click_float_lottie_url");
                                li1Var.E = optJSONObject5.optInt(TiebaStatic.Params.AD_TYPE);
                                li1Var.F = optJSONObject5.optInt("ad_sort");
                                li1Var.G = optJSONObject5.optInt("gesture_lottie_type");
                                li1Var.H = optJSONObject5.optString("gesture_lottie_url");
                                li1Var.I = (float) optJSONObject5.optDouble("gesture_lottie_sensitivity", 0.0d);
                                li1Var.X = optJSONObject5.optInt("gesture_lottie_direction", 1);
                                li1Var.J = optJSONObject5.optInt("is_topview", 0);
                                if (li1Var.n() && optJSONArray5 != null && optJSONArray5.length() > 0) {
                                    b.a(optJSONArray5.optJSONObject(0), li1Var);
                                } else {
                                    c.a(optJSONObject5, li1Var);
                                }
                                li1Var.L = optJSONObject5.optJSONObject("animation_data");
                                li1Var.M = optJSONObject5.optInt("shake_update_interval", 67);
                                li1Var.N = optJSONObject5.optInt("shake_direction_count", 2);
                                li1Var.O = optJSONObject5.optString("key");
                                li1Var.P = (float) optJSONObject5.optDouble("hot_shake_sensitivity", 0.0d);
                                li1Var.T = optJSONObject5.optInt("virtual", 0);
                                li1Var.U = (float) optJSONObject5.optDouble("shake_action_delay_time", -1.0d);
                            }
                            JSONArray optJSONArray6 = optJSONObject4.optJSONArray("show_urls");
                            if (optJSONArray6 != null) {
                                li1Var.q = new String[optJSONArray6.length()];
                                int length = optJSONArray6.length();
                                for (int i2 = 0; i2 < length; i2++) {
                                    li1Var.q[i2] = optJSONArray6.optString(i2);
                                }
                            }
                            JSONArray optJSONArray7 = optJSONObject4.optJSONArray("click_urls");
                            if (optJSONArray7 != null) {
                                li1Var.r = new String[optJSONArray7.length()];
                                int length2 = optJSONArray7.length();
                                for (int i3 = 0; i3 < length2; i3++) {
                                    li1Var.r[i3] = optJSONArray7.optString(i3);
                                }
                            }
                            JSONObject optJSONObject6 = optJSONObject4.optJSONObject("policy");
                            if (optJSONObject6 != null) {
                                JSONObject optJSONObject7 = optJSONObject6.optJSONObject(PushConstants.REGISTER_STATUS_EXPIRE_TIME);
                                if (optJSONObject7 != null) {
                                    li1Var.s = optJSONObject7.optLong("start");
                                    li1Var.t = optJSONObject7.optLong("end");
                                }
                                li1Var.u = optJSONObject6.optInt("expose_interval");
                                li1Var.v = optJSONObject6.optInt("expose_times");
                                li1Var.w = optJSONObject6.optInt("preload_type");
                                li1Var.A = optJSONObject6.optInt("float_bar_show", 1);
                                li1Var.B = optJSONObject6.optInt("click_float_opt", 1);
                                li1Var.C = optJSONObject6.optString("style_desc");
                                li1Var.Q = optJSONObject6.optInt("hot_background_time", 0);
                                JSONObject optJSONObject8 = optJSONObject6.optJSONObject("expire_time_backup");
                                String optString4 = optJSONObject6.optString("m_ua");
                                if (!TextUtils.isEmpty(optString4)) {
                                    li1Var.V = new String(Base64.decode(optString4.getBytes(), 0));
                                }
                                String optString5 = optJSONObject6.optString("m_pn");
                                if (!TextUtils.isEmpty(optString5)) {
                                    li1Var.W = new String(Base64.decode(optString5.getBytes(), 0));
                                }
                                if (optJSONObject8 != null) {
                                    li1Var.R = optJSONObject8.optLong("start");
                                    li1Var.S = optJSONObject8.optLong("end");
                                }
                            }
                            JSONObject optJSONObject9 = optJSONObject4.optJSONObject("topview_data");
                            if (li1Var.J == 1 && optJSONObject9 != null) {
                                JSONObject optJSONObject10 = optJSONObject9.optJSONObject("content");
                                if (optJSONObject10 == null) {
                                    li1Var.J = 0;
                                    return;
                                }
                                JSONObject jSONObject2 = new JSONObject();
                                v01.f(jSONObject2, "click_float_lottie_url", li1Var.z);
                                v01.d(jSONObject2, "click_float_opt", li1Var.B);
                                v01.d(jSONObject2, "float_bar_show", li1Var.A);
                                v01.g(jSONObject2, SetImageWatermarkTypeReqMsg.SWITCH, true);
                                v01.f(jSONObject2, "style_desc", li1Var.C);
                                v01.d(jSONObject2, "countdown", li1Var.n);
                                v01.f(jSONObject2, "source_path", ji1.r(li1Var.g));
                                v01.f(optJSONObject10, "topview", jSONObject2);
                                li1Var.K = optJSONObject9;
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }

        public static void d(li1 li1Var, li1 li1Var2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, li1Var, li1Var2) == null) {
                li1Var.a = li1Var2.a;
                li1Var.b = li1Var2.b;
                li1Var.c = li1Var2.c;
                li1Var.d = li1Var2.d;
                li1Var.e = li1Var2.e;
                li1Var.f = li1Var2.f;
                li1Var.g = li1Var2.g;
                li1Var.h = li1Var2.h;
                li1Var.i = li1Var2.i;
                li1Var.j = li1Var2.j;
                li1Var.k = li1Var2.k;
                li1Var.l = li1Var2.l;
                li1Var.m = li1Var2.m;
                li1Var.n = li1Var2.n;
                li1Var.o = li1Var2.o;
                li1Var.p = li1Var2.p;
                li1Var.q = li1Var2.q;
                li1Var.r = li1Var2.r;
                li1Var.s = li1Var2.s;
                li1Var.t = li1Var2.t;
                li1Var.u = li1Var2.u;
                li1Var.v = li1Var2.v;
                li1Var.x = li1Var2.x;
                li1Var.z = li1Var2.z;
                li1Var.A = li1Var2.A;
                li1Var.B = li1Var2.B;
                li1Var.C = li1Var2.C;
                li1Var.E = li1Var2.E;
                li1Var.F = li1Var2.F;
                li1Var.G = li1Var2.G;
                li1Var.H = li1Var2.H;
                li1Var.I = li1Var2.I;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, li1 li1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65536, null, jSONObject, li1Var) == null) && jSONObject != null) {
                try {
                    li1Var.g = jSONObject.optString("url");
                    li1Var.h = jSONObject.optInt("width");
                    li1Var.i = jSONObject.optInt("height");
                    li1Var.j = jSONObject.optString("imageMd5");
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, li1 li1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, li1Var) == null) {
                try {
                    jSONObject.put("url", li1Var.g);
                    jSONObject.put("imageMd5", li1Var.j);
                    jSONObject.put("width", li1Var.h);
                    jSONObject.put("height", li1Var.i);
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

        public static void a(JSONObject jSONObject, li1 li1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65536, null, jSONObject, li1Var) == null) && jSONObject != null) {
                try {
                    li1Var.g = jSONObject.optString("url");
                    li1Var.h = jSONObject.optInt("width");
                    li1Var.i = jSONObject.optInt("height");
                    li1Var.j = jSONObject.optString(PackageTable.MD5);
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, li1 li1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, li1Var) == null) {
                try {
                    jSONObject.put("url", li1Var.g);
                    jSONObject.put(PackageTable.MD5, li1Var.j);
                    jSONObject.put("width", li1Var.h);
                    jSONObject.put("height", li1Var.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public li1() {
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
            float f = ki1.f;
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
            int i = ki1.e;
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
            int i = ki1.d;
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

    public static boolean b(li1 li1Var) {
        InterceptResult invokeL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, li1Var)) == null) {
            if (TextUtils.isEmpty(li1Var.d)) {
                str = "7";
                z = false;
            } else {
                str = "";
                z = true;
            }
            String str2 = PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW;
            if (z && TextUtils.isEmpty(li1Var.g)) {
                str = PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW;
                z = false;
            }
            if (z && System.currentTimeMillis() / 1000 > li1Var.t) {
                str = "68";
                z = false;
            }
            if (z && li1Var.p() && (li1Var.g.endsWith(".jpeg") || li1Var.g.endsWith(".jpg") || li1Var.g.endsWith(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX) || li1Var.g.endsWith(".webp"))) {
                str = PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW;
                z = false;
            }
            if (z && li1Var.n() && (li1Var.g.endsWith(DefaultHlsExtractorFactory.MP4_FILE_EXTENSION) || li1Var.g.endsWith(".MP4") || li1Var.g.endsWith(".mov"))) {
                z = false;
            } else {
                str2 = str;
            }
            if (z) {
                return true;
            }
            new BaseVM(li1Var).g(str2);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static li1 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            li1 li1Var = new li1();
            try {
                a.a(jSONObject, li1Var);
            } catch (Exception unused) {
            }
            return li1Var;
        }
        return (li1) invokeL.objValue;
    }

    public static li1 d(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            try {
                li1 li1Var = new li1();
                a.b(jSONObject, li1Var);
                return li1Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (li1) invokeL.objValue;
    }

    public static List<li1> r(JSONArray jSONArray) {
        InterceptResult invokeL;
        li1 d;
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

    public static void t(li1 li1Var, li1 li1Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, li1Var, li1Var2) == null) {
            a.d(li1Var, li1Var2);
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
            if (di1.b() == 1) {
                float f = ki1.c;
                if (f > 0.0f) {
                    return f;
                }
                float f2 = this.P;
                if (f2 > 0.0f) {
                    return f2;
                }
            } else {
                float f3 = ki1.b;
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
