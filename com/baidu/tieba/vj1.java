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
import com.baidu.tieba.j51;
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
/* loaded from: classes6.dex */
public class vj1 {
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

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, vj1 vj1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, jSONObject, vj1Var) == null) {
                try {
                    vj1Var.a = jSONObject.optInt("advisible");
                    vj1Var.b = jSONObject.optString("id");
                    vj1Var.c = jSONObject.optString("ukey");
                    vj1Var.d = jSONObject.optString("extra");
                    vj1Var.e = jSONObject.optString(TtmlNode.TAG_LAYOUT);
                    vj1Var.f = jSONObject.optInt("type");
                    vj1Var.k = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
                    vj1Var.o = jSONObject.optString("action");
                    vj1Var.p = jSONObject.optString("action_cmd");
                    vj1Var.l = jSONObject.optString("flag_name");
                    vj1Var.m = jSONObject.optInt("logo_type");
                    vj1Var.n = jSONObject.optInt(CriusAttrConstants.DISPLAY);
                    if (vj1Var.n()) {
                        b.a(jSONObject, vj1Var);
                    } else {
                        c.a(jSONObject, vj1Var);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("show_urls");
                    if (optJSONArray != null) {
                        vj1Var.q = new String[optJSONArray.length()];
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            vj1Var.q[i] = optJSONArray.optString(i);
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("click_urls");
                    if (optJSONArray2 != null) {
                        vj1Var.r = new String[optJSONArray2.length()];
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            vj1Var.r[i2] = optJSONArray2.optString(i2);
                        }
                    }
                    vj1Var.s = jSONObject.optLong("start");
                    vj1Var.t = jSONObject.optLong("end");
                    vj1Var.u = jSONObject.optInt("expose_interval");
                    vj1Var.v = jSONObject.optInt("expose_times");
                    vj1Var.w = jSONObject.optInt("preload_type");
                    vj1Var.z = jSONObject.optString("click_float_lottie_url");
                    vj1Var.A = jSONObject.optInt("float_bar_show", 1);
                    vj1Var.B = jSONObject.optInt("click_float_opt", 1);
                    vj1Var.C = jSONObject.optString("style_desc");
                    vj1Var.x = jSONObject.optInt("curRate");
                    vj1Var.E = jSONObject.optInt(TiebaStatic.Params.AD_TYPE);
                    vj1Var.F = jSONObject.optInt("ad_sort");
                    vj1Var.G = jSONObject.optInt("gesture_lottie_type");
                    vj1Var.H = jSONObject.optString("gesture_lottie_url");
                    vj1Var.I = (float) jSONObject.optDouble("gesture_lottie_sensitivity", 0.0d);
                    vj1Var.X = jSONObject.optInt("gesture_lottie_direction", 1);
                    int optInt = jSONObject.optInt("is_topview", 0);
                    vj1Var.J = optInt;
                    if (optInt == 1 && jSONObject.optJSONObject("topview_data") != null) {
                        vj1Var.K = jSONObject.optJSONObject("topview_data");
                    }
                    if (jSONObject.optJSONObject("animation_data") != null) {
                        vj1Var.L = jSONObject.optJSONObject("animation_data");
                    }
                    vj1Var.M = jSONObject.optInt("shake_update_interval", 67);
                    vj1Var.N = jSONObject.optInt("shake_direction_count", 2);
                    vj1Var.O = jSONObject.optString("key");
                    vj1Var.P = (float) jSONObject.optDouble("hot_shake_sensitivity", 0.0d);
                    vj1Var.Q = jSONObject.optInt("hot_background_time", 0);
                    vj1Var.V = jSONObject.optString("m_ua");
                    vj1Var.W = jSONObject.optString("m_pn");
                    vj1Var.R = jSONObject.optLong("start_backup");
                    vj1Var.S = jSONObject.optLong("end_backup");
                    vj1Var.T = jSONObject.optInt("virtual", 0);
                    vj1Var.U = (float) jSONObject.optDouble("shake_action_delay_time", -1.0d);
                } catch (Exception unused) {
                }
            }
        }

        public static void c(JSONObject jSONObject, vj1 vj1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, jSONObject, vj1Var) == null) {
                try {
                    jSONObject.put("advisible", vj1Var.a);
                    jSONObject.put("id", vj1Var.b);
                    jSONObject.put("ukey", vj1Var.c);
                    jSONObject.put("extra", vj1Var.d);
                    jSONObject.put(TtmlNode.TAG_LAYOUT, vj1Var.e);
                    jSONObject.put("type", vj1Var.f);
                    jSONObject.put(BigdayActivityConfig.JUMP_URL, vj1Var.k);
                    jSONObject.put("action", vj1Var.o);
                    jSONObject.put("action_cmd", vj1Var.p);
                    jSONObject.put("flag_name", vj1Var.l);
                    jSONObject.put("logo_type", vj1Var.m);
                    jSONObject.put(CriusAttrConstants.DISPLAY, vj1Var.n);
                    jSONObject.put("start", vj1Var.s);
                    jSONObject.put("end", vj1Var.t);
                    jSONObject.put("expose_times", vj1Var.v);
                    jSONObject.put("expose_interval", vj1Var.u);
                    jSONObject.put("preload_type", vj1Var.w);
                    jSONObject.put("curRate", vj1Var.x);
                    jSONObject.put("click_float_lottie_url", vj1Var.z);
                    jSONObject.put("float_bar_show", vj1Var.A);
                    jSONObject.put("click_float_opt", vj1Var.B);
                    jSONObject.put("style_desc", vj1Var.C);
                    jSONObject.put(TiebaStatic.Params.AD_TYPE, vj1Var.E);
                    jSONObject.put("ad_sort", vj1Var.F);
                    jSONObject.put("gesture_lottie_type", vj1Var.G);
                    jSONObject.put("gesture_lottie_url", vj1Var.H);
                    jSONObject.put("gesture_lottie_sensitivity", vj1Var.I);
                    jSONObject.put("gesture_lottie_direction", vj1Var.X);
                    jSONObject.put("is_topview", vj1Var.J);
                    jSONObject.put("start_backup", vj1Var.R);
                    jSONObject.put("end_backup", vj1Var.S);
                    if (vj1Var.J == 1 && vj1Var.K != null) {
                        jSONObject.put("topview_data", vj1Var.K);
                    }
                    if (vj1Var.L != null) {
                        jSONObject.put("animation_data", vj1Var.L);
                    }
                    jSONObject.put("shake_update_interval", vj1Var.M);
                    jSONObject.put("shake_direction_count", vj1Var.N);
                    jSONObject.put("key", vj1Var.O);
                    jSONObject.put("hot_shake_sensitivity", vj1Var.P);
                    jSONObject.put("hot_background_time", vj1Var.Q);
                    jSONObject.put("virtual", vj1Var.T);
                    jSONObject.put("shake_action_delay_time", vj1Var.U);
                    jSONObject.put("m_ua", vj1Var.V);
                    jSONObject.put("m_pn", vj1Var.W);
                    if (vj1Var.q != null) {
                        if (j51.b.c()) {
                            jSONObject.put("show_urls", new JSONArray(vj1Var.q));
                        } else {
                            jSONObject.put("show_urls", new JSONArray((Collection) Arrays.asList(vj1Var.q)));
                        }
                    }
                    if (vj1Var.r != null) {
                        if (j51.b.c()) {
                            jSONObject.put("click_urls", new JSONArray(vj1Var.r));
                        } else {
                            jSONObject.put("click_urls", new JSONArray((Collection) Arrays.asList(vj1Var.r)));
                        }
                    }
                    if (vj1Var.n()) {
                        b.b(jSONObject, vj1Var);
                    } else {
                        c.b(jSONObject, vj1Var);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void b(JSONObject jSONObject, vj1 vj1Var) {
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, vj1Var) == null) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
                    if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                        return;
                    }
                    vj1Var.a = optJSONObject.optInt("advisible", 1);
                    vj1Var.b = optJSONObject.optString("id");
                    vj1Var.c = optJSONObject.optString("ukey");
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
                                    vj1Var.d = optString2;
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
                            vj1Var.e = optJSONObject4.optString(TtmlNode.TAG_LAYOUT);
                            JSONObject optJSONObject5 = optJSONObject4.optJSONObject("common");
                            if (optJSONObject5 != null) {
                                vj1Var.f = optJSONObject5.optInt("type");
                                vj1Var.k = optJSONObject5.optString(BigdayActivityConfig.JUMP_URL);
                                vj1Var.o = optJSONObject5.optString("action");
                                vj1Var.p = optJSONObject5.optString("action_cmd");
                                vj1Var.l = optJSONObject5.optString("flag_name");
                                vj1Var.m = optJSONObject5.optInt("logo_type");
                                vj1Var.n = optJSONObject5.optInt(CriusAttrConstants.DISPLAY);
                                JSONArray optJSONArray5 = optJSONObject5.optJSONArray("image_list");
                                vj1Var.z = optJSONObject5.optString("click_float_lottie_url");
                                vj1Var.E = optJSONObject5.optInt(TiebaStatic.Params.AD_TYPE);
                                vj1Var.F = optJSONObject5.optInt("ad_sort");
                                vj1Var.G = optJSONObject5.optInt("gesture_lottie_type");
                                vj1Var.H = optJSONObject5.optString("gesture_lottie_url");
                                vj1Var.I = (float) optJSONObject5.optDouble("gesture_lottie_sensitivity", 0.0d);
                                vj1Var.X = optJSONObject5.optInt("gesture_lottie_direction", 1);
                                vj1Var.J = optJSONObject5.optInt("is_topview", 0);
                                if (vj1Var.n() && optJSONArray5 != null && optJSONArray5.length() > 0) {
                                    b.a(optJSONArray5.optJSONObject(0), vj1Var);
                                } else {
                                    c.a(optJSONObject5, vj1Var);
                                }
                                vj1Var.L = optJSONObject5.optJSONObject("animation_data");
                                vj1Var.M = optJSONObject5.optInt("shake_update_interval", 67);
                                vj1Var.N = optJSONObject5.optInt("shake_direction_count", 2);
                                vj1Var.O = optJSONObject5.optString("key");
                                vj1Var.P = (float) optJSONObject5.optDouble("hot_shake_sensitivity", 0.0d);
                                vj1Var.T = optJSONObject5.optInt("virtual", 0);
                                vj1Var.U = (float) optJSONObject5.optDouble("shake_action_delay_time", -1.0d);
                            }
                            JSONArray optJSONArray6 = optJSONObject4.optJSONArray("show_urls");
                            if (optJSONArray6 != null) {
                                vj1Var.q = new String[optJSONArray6.length()];
                                int length = optJSONArray6.length();
                                for (int i2 = 0; i2 < length; i2++) {
                                    vj1Var.q[i2] = optJSONArray6.optString(i2);
                                }
                            }
                            JSONArray optJSONArray7 = optJSONObject4.optJSONArray("click_urls");
                            if (optJSONArray7 != null) {
                                vj1Var.r = new String[optJSONArray7.length()];
                                int length2 = optJSONArray7.length();
                                for (int i3 = 0; i3 < length2; i3++) {
                                    vj1Var.r[i3] = optJSONArray7.optString(i3);
                                }
                            }
                            JSONObject optJSONObject6 = optJSONObject4.optJSONObject("policy");
                            if (optJSONObject6 != null) {
                                JSONObject optJSONObject7 = optJSONObject6.optJSONObject(PushConstants.REGISTER_STATUS_EXPIRE_TIME);
                                if (optJSONObject7 != null) {
                                    vj1Var.s = optJSONObject7.optLong("start");
                                    vj1Var.t = optJSONObject7.optLong("end");
                                }
                                vj1Var.u = optJSONObject6.optInt("expose_interval");
                                vj1Var.v = optJSONObject6.optInt("expose_times");
                                vj1Var.w = optJSONObject6.optInt("preload_type");
                                vj1Var.A = optJSONObject6.optInt("float_bar_show", 1);
                                vj1Var.B = optJSONObject6.optInt("click_float_opt", 1);
                                vj1Var.C = optJSONObject6.optString("style_desc");
                                vj1Var.Q = optJSONObject6.optInt("hot_background_time", 0);
                                JSONObject optJSONObject8 = optJSONObject6.optJSONObject("expire_time_backup");
                                String optString4 = optJSONObject6.optString("m_ua");
                                if (!TextUtils.isEmpty(optString4)) {
                                    vj1Var.V = new String(Base64.decode(optString4.getBytes(), 0));
                                }
                                String optString5 = optJSONObject6.optString("m_pn");
                                if (!TextUtils.isEmpty(optString5)) {
                                    vj1Var.W = new String(Base64.decode(optString5.getBytes(), 0));
                                }
                                if (optJSONObject8 != null) {
                                    vj1Var.R = optJSONObject8.optLong("start");
                                    vj1Var.S = optJSONObject8.optLong("end");
                                }
                            }
                            JSONObject optJSONObject9 = optJSONObject4.optJSONObject("topview_data");
                            if (vj1Var.J == 1 && optJSONObject9 != null) {
                                JSONObject optJSONObject10 = optJSONObject9.optJSONObject("content");
                                if (optJSONObject10 == null) {
                                    vj1Var.J = 0;
                                    return;
                                }
                                JSONObject jSONObject2 = new JSONObject();
                                f21.f(jSONObject2, "click_float_lottie_url", vj1Var.z);
                                f21.d(jSONObject2, "click_float_opt", vj1Var.B);
                                f21.d(jSONObject2, "float_bar_show", vj1Var.A);
                                f21.g(jSONObject2, SetImageWatermarkTypeReqMsg.SWITCH, true);
                                f21.f(jSONObject2, "style_desc", vj1Var.C);
                                f21.d(jSONObject2, "countdown", vj1Var.n);
                                f21.f(jSONObject2, "source_path", tj1.r(vj1Var.g));
                                f21.f(optJSONObject10, "topview", jSONObject2);
                                vj1Var.K = optJSONObject9;
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }

        public static void d(vj1 vj1Var, vj1 vj1Var2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, vj1Var, vj1Var2) == null) {
                vj1Var.a = vj1Var2.a;
                vj1Var.b = vj1Var2.b;
                vj1Var.c = vj1Var2.c;
                vj1Var.d = vj1Var2.d;
                vj1Var.e = vj1Var2.e;
                vj1Var.f = vj1Var2.f;
                vj1Var.g = vj1Var2.g;
                vj1Var.h = vj1Var2.h;
                vj1Var.i = vj1Var2.i;
                vj1Var.j = vj1Var2.j;
                vj1Var.k = vj1Var2.k;
                vj1Var.l = vj1Var2.l;
                vj1Var.m = vj1Var2.m;
                vj1Var.n = vj1Var2.n;
                vj1Var.o = vj1Var2.o;
                vj1Var.p = vj1Var2.p;
                vj1Var.q = vj1Var2.q;
                vj1Var.r = vj1Var2.r;
                vj1Var.s = vj1Var2.s;
                vj1Var.t = vj1Var2.t;
                vj1Var.u = vj1Var2.u;
                vj1Var.v = vj1Var2.v;
                vj1Var.x = vj1Var2.x;
                vj1Var.z = vj1Var2.z;
                vj1Var.A = vj1Var2.A;
                vj1Var.B = vj1Var2.B;
                vj1Var.C = vj1Var2.C;
                vj1Var.E = vj1Var2.E;
                vj1Var.F = vj1Var2.F;
                vj1Var.G = vj1Var2.G;
                vj1Var.H = vj1Var2.H;
                vj1Var.I = vj1Var2.I;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, vj1 vj1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65536, null, jSONObject, vj1Var) == null) && jSONObject != null) {
                try {
                    vj1Var.g = jSONObject.optString("url");
                    vj1Var.h = jSONObject.optInt("width");
                    vj1Var.i = jSONObject.optInt("height");
                    vj1Var.j = jSONObject.optString("imageMd5");
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, vj1 vj1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, vj1Var) == null) {
                try {
                    jSONObject.put("url", vj1Var.g);
                    jSONObject.put("imageMd5", vj1Var.j);
                    jSONObject.put("width", vj1Var.h);
                    jSONObject.put("height", vj1Var.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, vj1 vj1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65536, null, jSONObject, vj1Var) == null) && jSONObject != null) {
                try {
                    vj1Var.g = jSONObject.optString("url");
                    vj1Var.h = jSONObject.optInt("width");
                    vj1Var.i = jSONObject.optInt("height");
                    vj1Var.j = jSONObject.optString(PackageTable.MD5);
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, vj1 vj1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, vj1Var) == null) {
                try {
                    jSONObject.put("url", vj1Var.g);
                    jSONObject.put(PackageTable.MD5, vj1Var.j);
                    jSONObject.put("width", vj1Var.h);
                    jSONObject.put("height", vj1Var.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public vj1() {
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
            float f = uj1.f;
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
            int i = uj1.e;
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
            int i = uj1.d;
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

    public static boolean b(vj1 vj1Var) {
        InterceptResult invokeL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, vj1Var)) == null) {
            if (TextUtils.isEmpty(vj1Var.d)) {
                str = "7";
                z = false;
            } else {
                str = "";
                z = true;
            }
            String str2 = PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW;
            if (z && TextUtils.isEmpty(vj1Var.g)) {
                str = PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW;
                z = false;
            }
            if (z && System.currentTimeMillis() / 1000 > vj1Var.t) {
                str = "68";
                z = false;
            }
            if (z && vj1Var.p() && (vj1Var.g.endsWith(".jpeg") || vj1Var.g.endsWith(".jpg") || vj1Var.g.endsWith(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX) || vj1Var.g.endsWith(".webp"))) {
                str = PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW;
                z = false;
            }
            if (z && vj1Var.n() && (vj1Var.g.endsWith(DefaultHlsExtractorFactory.MP4_FILE_EXTENSION) || vj1Var.g.endsWith(".MP4") || vj1Var.g.endsWith(".mov"))) {
                z = false;
            } else {
                str2 = str;
            }
            if (z) {
                return true;
            }
            new BaseVM(vj1Var).g(str2);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static vj1 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            vj1 vj1Var = new vj1();
            try {
                a.a(jSONObject, vj1Var);
            } catch (Exception unused) {
            }
            return vj1Var;
        }
        return (vj1) invokeL.objValue;
    }

    public static vj1 d(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            try {
                vj1 vj1Var = new vj1();
                a.b(jSONObject, vj1Var);
                return vj1Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (vj1) invokeL.objValue;
    }

    public static List<vj1> r(JSONArray jSONArray) {
        InterceptResult invokeL;
        vj1 d;
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

    public static void t(vj1 vj1Var, vj1 vj1Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, vj1Var, vj1Var2) == null) {
            a.d(vj1Var, vj1Var2);
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
            if (nj1.b() == 1) {
                float f = uj1.c;
                if (f > 0.0f) {
                    return f;
                }
                float f2 = this.P;
                if (f2 > 0.0f) {
                    return f2;
                }
            } else {
                float f3 = uj1.b;
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
