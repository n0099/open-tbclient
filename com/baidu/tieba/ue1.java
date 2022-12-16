package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.m31;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ue1 {
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

        public static void a(JSONObject jSONObject, ue1 ue1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, jSONObject, ue1Var) == null) {
                try {
                    ue1Var.a = jSONObject.optInt("advisible");
                    ue1Var.b = jSONObject.optString("id");
                    ue1Var.c = jSONObject.optString("ukey");
                    ue1Var.d = jSONObject.optString("extra");
                    ue1Var.e = jSONObject.optString(TtmlNode.TAG_LAYOUT);
                    ue1Var.f = jSONObject.optInt("type");
                    ue1Var.k = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
                    ue1Var.o = jSONObject.optString("action");
                    ue1Var.p = jSONObject.optString("action_cmd");
                    ue1Var.l = jSONObject.optString("flag_name");
                    ue1Var.m = jSONObject.optInt("logo_type");
                    ue1Var.n = jSONObject.optInt(CriusAttrConstants.DISPLAY);
                    if (ue1Var.j()) {
                        b.a(jSONObject, ue1Var);
                    } else {
                        c.a(jSONObject, ue1Var);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("show_urls");
                    if (optJSONArray != null) {
                        ue1Var.q = new String[optJSONArray.length()];
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            ue1Var.q[i] = optJSONArray.optString(i);
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("click_urls");
                    if (optJSONArray2 != null) {
                        ue1Var.r = new String[optJSONArray2.length()];
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            ue1Var.r[i2] = optJSONArray2.optString(i2);
                        }
                    }
                    ue1Var.s = jSONObject.optLong("start");
                    ue1Var.t = jSONObject.optLong("end");
                    ue1Var.u = jSONObject.optInt("expose_interval");
                    ue1Var.v = jSONObject.optInt("expose_times");
                    ue1Var.w = jSONObject.optInt("preload_type");
                    ue1Var.z = jSONObject.optString("click_float_lottie_url");
                    ue1Var.A = jSONObject.optInt("float_bar_show", 1);
                    ue1Var.B = jSONObject.optInt("click_float_opt", 1);
                    ue1Var.C = jSONObject.optString("style_desc");
                    ue1Var.x = jSONObject.optInt("curRate");
                    ue1Var.E = jSONObject.optInt(TiebaStatic.Params.AD_TYPE);
                    ue1Var.F = jSONObject.optInt("ad_sort");
                    ue1Var.G = jSONObject.optInt("gesture_lottie_type");
                    ue1Var.H = jSONObject.optString("gesture_lottie_url");
                    ue1Var.I = (float) jSONObject.optDouble("gesture_lottie_sensitivity", 0.0d);
                    int optInt = jSONObject.optInt("is_topview", 0);
                    ue1Var.J = optInt;
                    if (optInt == 1 && jSONObject.optJSONObject("topview_data") != null) {
                        ue1Var.K = jSONObject.optJSONObject("topview_data");
                    }
                    if (jSONObject.optJSONObject("animation_data") != null) {
                        ue1Var.L = jSONObject.optJSONObject("animation_data");
                    }
                    ue1Var.M = jSONObject.optInt("shake_update_interval", 0);
                    ue1Var.N = jSONObject.optInt("shake_direction_count", 0);
                    ue1Var.O = jSONObject.optString("key");
                    ue1Var.P = (float) jSONObject.optDouble("hot_shake_sensitivity", 0.0d);
                    ue1Var.Q = jSONObject.optInt("hot_background_time", 0);
                    ue1Var.R = jSONObject.optLong("start_backup");
                    ue1Var.S = jSONObject.optLong("end_backup");
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, ue1 ue1Var) {
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, ue1Var) == null) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
                    if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                        return;
                    }
                    ue1Var.a = optJSONObject.optInt("advisible", 1);
                    ue1Var.b = optJSONObject.optString("id");
                    ue1Var.c = optJSONObject.optString("ukey");
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
                                    ue1Var.d = optString2;
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
                            ue1Var.e = optJSONObject4.optString(TtmlNode.TAG_LAYOUT);
                            JSONObject optJSONObject5 = optJSONObject4.optJSONObject("common");
                            if (optJSONObject5 != null) {
                                ue1Var.f = optJSONObject5.optInt("type");
                                ue1Var.k = optJSONObject5.optString(BigdayActivityConfig.JUMP_URL);
                                ue1Var.o = optJSONObject5.optString("action");
                                ue1Var.p = optJSONObject5.optString("action_cmd");
                                ue1Var.l = optJSONObject5.optString("flag_name");
                                ue1Var.m = optJSONObject5.optInt("logo_type");
                                ue1Var.n = optJSONObject5.optInt(CriusAttrConstants.DISPLAY);
                                JSONArray optJSONArray5 = optJSONObject5.optJSONArray("image_list");
                                ue1Var.z = optJSONObject5.optString("click_float_lottie_url");
                                ue1Var.E = optJSONObject5.optInt(TiebaStatic.Params.AD_TYPE);
                                ue1Var.F = optJSONObject5.optInt("ad_sort");
                                ue1Var.G = optJSONObject5.optInt("gesture_lottie_type");
                                ue1Var.H = optJSONObject5.optString("gesture_lottie_url");
                                ue1Var.I = (float) optJSONObject5.optDouble("gesture_lottie_sensitivity", 0.0d);
                                ue1Var.J = optJSONObject5.optInt("is_topview", 0);
                                if (ue1Var.j() && optJSONArray5 != null && optJSONArray5.length() > 0) {
                                    b.a(optJSONArray5.optJSONObject(0), ue1Var);
                                } else {
                                    c.a(optJSONObject5, ue1Var);
                                }
                                ue1Var.L = optJSONObject5.optJSONObject("animation_data");
                                ue1Var.M = optJSONObject5.optInt("shake_update_interval", 0);
                                ue1Var.N = optJSONObject5.optInt("shake_direction_count", 0);
                                ue1Var.O = optJSONObject5.optString("key");
                                ue1Var.P = (float) optJSONObject5.optDouble("hot_shake_sensitivity", 0.0d);
                            }
                            JSONArray optJSONArray6 = optJSONObject4.optJSONArray("show_urls");
                            if (optJSONArray6 != null) {
                                ue1Var.q = new String[optJSONArray6.length()];
                                int length = optJSONArray6.length();
                                for (int i2 = 0; i2 < length; i2++) {
                                    ue1Var.q[i2] = optJSONArray6.optString(i2);
                                }
                            }
                            JSONArray optJSONArray7 = optJSONObject4.optJSONArray("click_urls");
                            if (optJSONArray7 != null) {
                                ue1Var.r = new String[optJSONArray7.length()];
                                int length2 = optJSONArray7.length();
                                for (int i3 = 0; i3 < length2; i3++) {
                                    ue1Var.r[i3] = optJSONArray7.optString(i3);
                                }
                            }
                            JSONObject optJSONObject6 = optJSONObject4.optJSONObject("policy");
                            if (optJSONObject6 != null) {
                                JSONObject jSONObject2 = optJSONObject6.getJSONObject("expire_time");
                                ue1Var.s = jSONObject2.optLong("start");
                                ue1Var.t = jSONObject2.optLong("end");
                                ue1Var.u = optJSONObject6.optInt("expose_interval");
                                ue1Var.v = optJSONObject6.optInt("expose_times");
                                ue1Var.w = optJSONObject6.optInt("preload_type");
                                ue1Var.A = optJSONObject6.optInt("float_bar_show", 1);
                                ue1Var.B = optJSONObject6.optInt("click_float_opt", 1);
                                ue1Var.C = optJSONObject6.optString("style_desc");
                                ue1Var.Q = optJSONObject6.optInt("hot_background_time", 0);
                                JSONObject jSONObject3 = optJSONObject6.getJSONObject("expire_time_backup");
                                ue1Var.R = jSONObject3.optLong("start");
                                ue1Var.S = jSONObject3.optLong("end");
                            }
                            JSONObject optJSONObject7 = optJSONObject4.optJSONObject("topview_data");
                            if (ue1Var.J == 1 && optJSONObject7 != null) {
                                JSONObject optJSONObject8 = optJSONObject7.optJSONObject("content");
                                if (optJSONObject8 == null) {
                                    ue1Var.J = 0;
                                    return;
                                }
                                JSONObject jSONObject4 = new JSONObject();
                                p01.f(jSONObject4, "click_float_lottie_url", ue1Var.z);
                                p01.d(jSONObject4, "click_float_opt", ue1Var.B);
                                p01.d(jSONObject4, "float_bar_show", ue1Var.A);
                                p01.g(jSONObject4, SetImageWatermarkTypeReqMsg.SWITCH, true);
                                p01.f(jSONObject4, "style_desc", ue1Var.C);
                                p01.d(jSONObject4, "countdown", ue1Var.n);
                                p01.f(jSONObject4, "source_path", se1.r(ue1Var.g));
                                p01.f(optJSONObject8, "topview", jSONObject4);
                                ue1Var.K = optJSONObject7;
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }

        public static void c(JSONObject jSONObject, ue1 ue1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, jSONObject, ue1Var) == null) {
                try {
                    jSONObject.put("advisible", ue1Var.a);
                    jSONObject.put("id", ue1Var.b);
                    jSONObject.put("ukey", ue1Var.c);
                    jSONObject.put("extra", ue1Var.d);
                    jSONObject.put(TtmlNode.TAG_LAYOUT, ue1Var.e);
                    jSONObject.put("type", ue1Var.f);
                    jSONObject.put(BigdayActivityConfig.JUMP_URL, ue1Var.k);
                    jSONObject.put("action", ue1Var.o);
                    jSONObject.put("action_cmd", ue1Var.p);
                    jSONObject.put("flag_name", ue1Var.l);
                    jSONObject.put("logo_type", ue1Var.m);
                    jSONObject.put(CriusAttrConstants.DISPLAY, ue1Var.n);
                    jSONObject.put("start", ue1Var.s);
                    jSONObject.put("end", ue1Var.t);
                    jSONObject.put("expose_times", ue1Var.v);
                    jSONObject.put("expose_interval", ue1Var.u);
                    jSONObject.put("preload_type", ue1Var.w);
                    jSONObject.put("curRate", ue1Var.x);
                    jSONObject.put("click_float_lottie_url", ue1Var.z);
                    jSONObject.put("float_bar_show", ue1Var.A);
                    jSONObject.put("click_float_opt", ue1Var.B);
                    jSONObject.put("style_desc", ue1Var.C);
                    jSONObject.put(TiebaStatic.Params.AD_TYPE, ue1Var.E);
                    jSONObject.put("ad_sort", ue1Var.F);
                    jSONObject.put("gesture_lottie_type", ue1Var.G);
                    jSONObject.put("gesture_lottie_url", ue1Var.H);
                    jSONObject.put("gesture_lottie_sensitivity", ue1Var.I);
                    jSONObject.put("is_topview", ue1Var.J);
                    jSONObject.put("start_backup", ue1Var.R);
                    jSONObject.put("end_backup", ue1Var.S);
                    if (ue1Var.J == 1 && ue1Var.K != null) {
                        jSONObject.put("topview_data", ue1Var.K);
                    }
                    if (ue1Var.L != null) {
                        jSONObject.put("animation_data", ue1Var.L);
                    }
                    jSONObject.put("shake_update_interval", ue1Var.M);
                    jSONObject.put("shake_direction_count", ue1Var.N);
                    jSONObject.put("key", ue1Var.O);
                    jSONObject.put("hot_shake_sensitivity", ue1Var.P);
                    jSONObject.put("hot_background_time", ue1Var.Q);
                    if (ue1Var.q != null) {
                        if (m31.b.c()) {
                            jSONObject.put("show_urls", new JSONArray(ue1Var.q));
                        } else {
                            jSONObject.put("show_urls", new JSONArray((Collection) Arrays.asList(ue1Var.q)));
                        }
                    }
                    if (ue1Var.r != null) {
                        if (m31.b.c()) {
                            jSONObject.put("click_urls", new JSONArray(ue1Var.r));
                        } else {
                            jSONObject.put("click_urls", new JSONArray((Collection) Arrays.asList(ue1Var.r)));
                        }
                    }
                    if (ue1Var.j()) {
                        b.b(jSONObject, ue1Var);
                    } else {
                        c.b(jSONObject, ue1Var);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void d(ue1 ue1Var, ue1 ue1Var2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, ue1Var, ue1Var2) == null) {
                ue1Var.a = ue1Var2.a;
                ue1Var.b = ue1Var2.b;
                ue1Var.c = ue1Var2.c;
                ue1Var.d = ue1Var2.d;
                ue1Var.e = ue1Var2.e;
                ue1Var.f = ue1Var2.f;
                ue1Var.g = ue1Var2.g;
                ue1Var.h = ue1Var2.h;
                ue1Var.i = ue1Var2.i;
                ue1Var.j = ue1Var2.j;
                ue1Var.k = ue1Var2.k;
                ue1Var.l = ue1Var2.l;
                ue1Var.m = ue1Var2.m;
                ue1Var.n = ue1Var2.n;
                ue1Var.o = ue1Var2.o;
                ue1Var.p = ue1Var2.p;
                ue1Var.q = ue1Var2.q;
                ue1Var.r = ue1Var2.r;
                ue1Var.s = ue1Var2.s;
                ue1Var.t = ue1Var2.t;
                ue1Var.u = ue1Var2.u;
                ue1Var.v = ue1Var2.v;
                ue1Var.x = ue1Var2.x;
                ue1Var.z = ue1Var2.z;
                ue1Var.A = ue1Var2.A;
                ue1Var.B = ue1Var2.B;
                ue1Var.C = ue1Var2.C;
                ue1Var.E = ue1Var2.E;
                ue1Var.F = ue1Var2.F;
                ue1Var.G = ue1Var2.G;
                ue1Var.H = ue1Var2.H;
                ue1Var.I = ue1Var2.I;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, ue1 ue1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65536, null, jSONObject, ue1Var) == null) && jSONObject != null) {
                try {
                    ue1Var.g = jSONObject.optString("url");
                    ue1Var.h = jSONObject.optInt("width");
                    ue1Var.i = jSONObject.optInt("height");
                    ue1Var.j = jSONObject.optString("imageMd5");
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, ue1 ue1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, ue1Var) == null) {
                try {
                    jSONObject.put("url", ue1Var.g);
                    jSONObject.put("imageMd5", ue1Var.j);
                    jSONObject.put("width", ue1Var.h);
                    jSONObject.put("height", ue1Var.i);
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

        public static void a(JSONObject jSONObject, ue1 ue1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65536, null, jSONObject, ue1Var) == null) && jSONObject != null) {
                try {
                    ue1Var.g = jSONObject.optString("url");
                    ue1Var.h = jSONObject.optInt("width");
                    ue1Var.i = jSONObject.optInt("height");
                    ue1Var.j = jSONObject.optString(PackageTable.MD5);
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, ue1 ue1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, ue1Var) == null) {
                try {
                    jSONObject.put("url", ue1Var.g);
                    jSONObject.put(PackageTable.MD5, ue1Var.j);
                    jSONObject.put("width", ue1Var.h);
                    jSONObject.put("height", ue1Var.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ue1() {
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
    }

    public float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.G == 7 && me1.b() == 1) {
                float f = this.P;
                if (f > 0.0f) {
                    return f;
                }
            }
            return this.I;
        }
        return invokeV.floatValue;
    }

    @NonNull
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.E == 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i = this.E;
            if (i == 0 || i == 1 || i == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return TextUtils.equals(this.e, "splash_image");
        }
        return invokeV.booleanValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            a.c(jSONObject, this);
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public static boolean a(ue1 ue1Var) {
        InterceptResult invokeL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ue1Var)) == null) {
            if (TextUtils.isEmpty(ue1Var.d)) {
                str = "7";
                z = false;
            } else {
                str = "";
                z = true;
            }
            if (z && TextUtils.isEmpty(ue1Var.g)) {
                str = PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW;
                z = false;
            }
            if (z && System.currentTimeMillis() / 1000 > ue1Var.t) {
                str = "68";
                z = false;
            }
            if (z) {
                return true;
            }
            new BaseVM(ue1Var).g(str);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static ue1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            ue1 ue1Var = new ue1();
            try {
                a.a(jSONObject, ue1Var);
            } catch (Exception unused) {
            }
            return ue1Var;
        }
        return (ue1) invokeL.objValue;
    }

    public static ue1 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            try {
                ue1 ue1Var = new ue1();
                a.b(jSONObject, ue1Var);
                return ue1Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (ue1) invokeL.objValue;
    }

    public static List<ue1> k(JSONArray jSONArray) {
        InterceptResult invokeL;
        ue1 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    c2 = c((JSONObject) jSONArray.get(i));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (c2 == null) {
                    break;
                }
                if (c2.a != 0 && a(c2)) {
                    arrayList.add(c2);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void m(ue1 ue1Var, ue1 ue1Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, ue1Var, ue1Var2) == null) {
            a.d(ue1Var, ue1Var2);
        }
    }

    public JSONObject e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
