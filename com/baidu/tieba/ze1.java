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
import com.baidu.tieba.r31;
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
/* loaded from: classes7.dex */
public class ze1 {
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

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, ze1 ze1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, jSONObject, ze1Var) == null) {
                try {
                    ze1Var.a = jSONObject.optInt("advisible");
                    ze1Var.b = jSONObject.optString("id");
                    ze1Var.c = jSONObject.optString("ukey");
                    ze1Var.d = jSONObject.optString("extra");
                    ze1Var.e = jSONObject.optString(TtmlNode.TAG_LAYOUT);
                    ze1Var.f = jSONObject.optInt("type");
                    ze1Var.k = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
                    ze1Var.o = jSONObject.optString("action");
                    ze1Var.p = jSONObject.optString("action_cmd");
                    ze1Var.l = jSONObject.optString("flag_name");
                    ze1Var.m = jSONObject.optInt("logo_type");
                    ze1Var.n = jSONObject.optInt(CriusAttrConstants.DISPLAY);
                    if (ze1Var.j()) {
                        b.a(jSONObject, ze1Var);
                    } else {
                        c.a(jSONObject, ze1Var);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("show_urls");
                    if (optJSONArray != null) {
                        ze1Var.q = new String[optJSONArray.length()];
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            ze1Var.q[i] = optJSONArray.optString(i);
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("click_urls");
                    if (optJSONArray2 != null) {
                        ze1Var.r = new String[optJSONArray2.length()];
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            ze1Var.r[i2] = optJSONArray2.optString(i2);
                        }
                    }
                    ze1Var.s = jSONObject.optLong("start");
                    ze1Var.t = jSONObject.optLong("end");
                    ze1Var.u = jSONObject.optInt("expose_interval");
                    ze1Var.v = jSONObject.optInt("expose_times");
                    ze1Var.w = jSONObject.optInt("preload_type");
                    ze1Var.z = jSONObject.optString("click_float_lottie_url");
                    ze1Var.A = jSONObject.optInt("float_bar_show", 1);
                    ze1Var.B = jSONObject.optInt("click_float_opt", 1);
                    ze1Var.C = jSONObject.optString("style_desc");
                    ze1Var.x = jSONObject.optInt("curRate");
                    ze1Var.E = jSONObject.optInt(TiebaStatic.Params.AD_TYPE);
                    ze1Var.F = jSONObject.optInt("ad_sort");
                    ze1Var.G = jSONObject.optInt("gesture_lottie_type");
                    ze1Var.H = jSONObject.optString("gesture_lottie_url");
                    ze1Var.I = (float) jSONObject.optDouble("gesture_lottie_sensitivity", 0.0d);
                    int optInt = jSONObject.optInt("is_topview", 0);
                    ze1Var.J = optInt;
                    if (optInt == 1 && jSONObject.optJSONObject("topview_data") != null) {
                        ze1Var.K = jSONObject.optJSONObject("topview_data");
                    }
                    if (jSONObject.optJSONObject("animation_data") != null) {
                        ze1Var.L = jSONObject.optJSONObject("animation_data");
                    }
                    ze1Var.M = jSONObject.optInt("shake_update_interval", 0);
                    ze1Var.N = jSONObject.optInt("shake_direction_count", 0);
                    ze1Var.O = jSONObject.optString("key");
                    ze1Var.P = (float) jSONObject.optDouble("hot_shake_sensitivity", 0.0d);
                    ze1Var.Q = jSONObject.optInt("hot_background_time", 0);
                    ze1Var.R = jSONObject.optLong("start_backup");
                    ze1Var.S = jSONObject.optLong("end_backup");
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, ze1 ze1Var) {
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, ze1Var) == null) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
                    if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                        return;
                    }
                    ze1Var.a = optJSONObject.optInt("advisible", 1);
                    ze1Var.b = optJSONObject.optString("id");
                    ze1Var.c = optJSONObject.optString("ukey");
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
                                    ze1Var.d = optString2;
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
                            ze1Var.e = optJSONObject4.optString(TtmlNode.TAG_LAYOUT);
                            JSONObject optJSONObject5 = optJSONObject4.optJSONObject("common");
                            if (optJSONObject5 != null) {
                                ze1Var.f = optJSONObject5.optInt("type");
                                ze1Var.k = optJSONObject5.optString(BigdayActivityConfig.JUMP_URL);
                                ze1Var.o = optJSONObject5.optString("action");
                                ze1Var.p = optJSONObject5.optString("action_cmd");
                                ze1Var.l = optJSONObject5.optString("flag_name");
                                ze1Var.m = optJSONObject5.optInt("logo_type");
                                ze1Var.n = optJSONObject5.optInt(CriusAttrConstants.DISPLAY);
                                JSONArray optJSONArray5 = optJSONObject5.optJSONArray("image_list");
                                ze1Var.z = optJSONObject5.optString("click_float_lottie_url");
                                ze1Var.E = optJSONObject5.optInt(TiebaStatic.Params.AD_TYPE);
                                ze1Var.F = optJSONObject5.optInt("ad_sort");
                                ze1Var.G = optJSONObject5.optInt("gesture_lottie_type");
                                ze1Var.H = optJSONObject5.optString("gesture_lottie_url");
                                ze1Var.I = (float) optJSONObject5.optDouble("gesture_lottie_sensitivity", 0.0d);
                                ze1Var.J = optJSONObject5.optInt("is_topview", 0);
                                if (ze1Var.j() && optJSONArray5 != null && optJSONArray5.length() > 0) {
                                    b.a(optJSONArray5.optJSONObject(0), ze1Var);
                                } else {
                                    c.a(optJSONObject5, ze1Var);
                                }
                                ze1Var.L = optJSONObject5.optJSONObject("animation_data");
                                ze1Var.M = optJSONObject5.optInt("shake_update_interval", 0);
                                ze1Var.N = optJSONObject5.optInt("shake_direction_count", 0);
                                ze1Var.O = optJSONObject5.optString("key");
                                ze1Var.P = (float) optJSONObject5.optDouble("hot_shake_sensitivity", 0.0d);
                            }
                            JSONArray optJSONArray6 = optJSONObject4.optJSONArray("show_urls");
                            if (optJSONArray6 != null) {
                                ze1Var.q = new String[optJSONArray6.length()];
                                int length = optJSONArray6.length();
                                for (int i2 = 0; i2 < length; i2++) {
                                    ze1Var.q[i2] = optJSONArray6.optString(i2);
                                }
                            }
                            JSONArray optJSONArray7 = optJSONObject4.optJSONArray("click_urls");
                            if (optJSONArray7 != null) {
                                ze1Var.r = new String[optJSONArray7.length()];
                                int length2 = optJSONArray7.length();
                                for (int i3 = 0; i3 < length2; i3++) {
                                    ze1Var.r[i3] = optJSONArray7.optString(i3);
                                }
                            }
                            JSONObject optJSONObject6 = optJSONObject4.optJSONObject("policy");
                            if (optJSONObject6 != null) {
                                JSONObject jSONObject2 = optJSONObject6.getJSONObject("expire_time");
                                ze1Var.s = jSONObject2.optLong("start");
                                ze1Var.t = jSONObject2.optLong("end");
                                ze1Var.u = optJSONObject6.optInt("expose_interval");
                                ze1Var.v = optJSONObject6.optInt("expose_times");
                                ze1Var.w = optJSONObject6.optInt("preload_type");
                                ze1Var.A = optJSONObject6.optInt("float_bar_show", 1);
                                ze1Var.B = optJSONObject6.optInt("click_float_opt", 1);
                                ze1Var.C = optJSONObject6.optString("style_desc");
                                ze1Var.Q = optJSONObject6.optInt("hot_background_time", 0);
                                JSONObject jSONObject3 = optJSONObject6.getJSONObject("expire_time_backup");
                                ze1Var.R = jSONObject3.optLong("start");
                                ze1Var.S = jSONObject3.optLong("end");
                            }
                            JSONObject optJSONObject7 = optJSONObject4.optJSONObject("topview_data");
                            if (ze1Var.J == 1 && optJSONObject7 != null) {
                                JSONObject optJSONObject8 = optJSONObject7.optJSONObject("content");
                                if (optJSONObject8 == null) {
                                    ze1Var.J = 0;
                                    return;
                                }
                                JSONObject jSONObject4 = new JSONObject();
                                u01.f(jSONObject4, "click_float_lottie_url", ze1Var.z);
                                u01.d(jSONObject4, "click_float_opt", ze1Var.B);
                                u01.d(jSONObject4, "float_bar_show", ze1Var.A);
                                u01.g(jSONObject4, SetImageWatermarkTypeReqMsg.SWITCH, true);
                                u01.f(jSONObject4, "style_desc", ze1Var.C);
                                u01.d(jSONObject4, "countdown", ze1Var.n);
                                u01.f(jSONObject4, "source_path", xe1.r(ze1Var.g));
                                u01.f(optJSONObject8, "topview", jSONObject4);
                                ze1Var.K = optJSONObject7;
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }

        public static void c(JSONObject jSONObject, ze1 ze1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, jSONObject, ze1Var) == null) {
                try {
                    jSONObject.put("advisible", ze1Var.a);
                    jSONObject.put("id", ze1Var.b);
                    jSONObject.put("ukey", ze1Var.c);
                    jSONObject.put("extra", ze1Var.d);
                    jSONObject.put(TtmlNode.TAG_LAYOUT, ze1Var.e);
                    jSONObject.put("type", ze1Var.f);
                    jSONObject.put(BigdayActivityConfig.JUMP_URL, ze1Var.k);
                    jSONObject.put("action", ze1Var.o);
                    jSONObject.put("action_cmd", ze1Var.p);
                    jSONObject.put("flag_name", ze1Var.l);
                    jSONObject.put("logo_type", ze1Var.m);
                    jSONObject.put(CriusAttrConstants.DISPLAY, ze1Var.n);
                    jSONObject.put("start", ze1Var.s);
                    jSONObject.put("end", ze1Var.t);
                    jSONObject.put("expose_times", ze1Var.v);
                    jSONObject.put("expose_interval", ze1Var.u);
                    jSONObject.put("preload_type", ze1Var.w);
                    jSONObject.put("curRate", ze1Var.x);
                    jSONObject.put("click_float_lottie_url", ze1Var.z);
                    jSONObject.put("float_bar_show", ze1Var.A);
                    jSONObject.put("click_float_opt", ze1Var.B);
                    jSONObject.put("style_desc", ze1Var.C);
                    jSONObject.put(TiebaStatic.Params.AD_TYPE, ze1Var.E);
                    jSONObject.put("ad_sort", ze1Var.F);
                    jSONObject.put("gesture_lottie_type", ze1Var.G);
                    jSONObject.put("gesture_lottie_url", ze1Var.H);
                    jSONObject.put("gesture_lottie_sensitivity", ze1Var.I);
                    jSONObject.put("is_topview", ze1Var.J);
                    jSONObject.put("start_backup", ze1Var.R);
                    jSONObject.put("end_backup", ze1Var.S);
                    if (ze1Var.J == 1 && ze1Var.K != null) {
                        jSONObject.put("topview_data", ze1Var.K);
                    }
                    if (ze1Var.L != null) {
                        jSONObject.put("animation_data", ze1Var.L);
                    }
                    jSONObject.put("shake_update_interval", ze1Var.M);
                    jSONObject.put("shake_direction_count", ze1Var.N);
                    jSONObject.put("key", ze1Var.O);
                    jSONObject.put("hot_shake_sensitivity", ze1Var.P);
                    jSONObject.put("hot_background_time", ze1Var.Q);
                    if (ze1Var.q != null) {
                        if (r31.b.c()) {
                            jSONObject.put("show_urls", new JSONArray(ze1Var.q));
                        } else {
                            jSONObject.put("show_urls", new JSONArray((Collection) Arrays.asList(ze1Var.q)));
                        }
                    }
                    if (ze1Var.r != null) {
                        if (r31.b.c()) {
                            jSONObject.put("click_urls", new JSONArray(ze1Var.r));
                        } else {
                            jSONObject.put("click_urls", new JSONArray((Collection) Arrays.asList(ze1Var.r)));
                        }
                    }
                    if (ze1Var.j()) {
                        b.b(jSONObject, ze1Var);
                    } else {
                        c.b(jSONObject, ze1Var);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void d(ze1 ze1Var, ze1 ze1Var2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, ze1Var, ze1Var2) == null) {
                ze1Var.a = ze1Var2.a;
                ze1Var.b = ze1Var2.b;
                ze1Var.c = ze1Var2.c;
                ze1Var.d = ze1Var2.d;
                ze1Var.e = ze1Var2.e;
                ze1Var.f = ze1Var2.f;
                ze1Var.g = ze1Var2.g;
                ze1Var.h = ze1Var2.h;
                ze1Var.i = ze1Var2.i;
                ze1Var.j = ze1Var2.j;
                ze1Var.k = ze1Var2.k;
                ze1Var.l = ze1Var2.l;
                ze1Var.m = ze1Var2.m;
                ze1Var.n = ze1Var2.n;
                ze1Var.o = ze1Var2.o;
                ze1Var.p = ze1Var2.p;
                ze1Var.q = ze1Var2.q;
                ze1Var.r = ze1Var2.r;
                ze1Var.s = ze1Var2.s;
                ze1Var.t = ze1Var2.t;
                ze1Var.u = ze1Var2.u;
                ze1Var.v = ze1Var2.v;
                ze1Var.x = ze1Var2.x;
                ze1Var.z = ze1Var2.z;
                ze1Var.A = ze1Var2.A;
                ze1Var.B = ze1Var2.B;
                ze1Var.C = ze1Var2.C;
                ze1Var.E = ze1Var2.E;
                ze1Var.F = ze1Var2.F;
                ze1Var.G = ze1Var2.G;
                ze1Var.H = ze1Var2.H;
                ze1Var.I = ze1Var2.I;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, ze1 ze1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65536, null, jSONObject, ze1Var) == null) && jSONObject != null) {
                try {
                    ze1Var.g = jSONObject.optString("url");
                    ze1Var.h = jSONObject.optInt("width");
                    ze1Var.i = jSONObject.optInt("height");
                    ze1Var.j = jSONObject.optString("imageMd5");
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, ze1 ze1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, ze1Var) == null) {
                try {
                    jSONObject.put("url", ze1Var.g);
                    jSONObject.put("imageMd5", ze1Var.j);
                    jSONObject.put("width", ze1Var.h);
                    jSONObject.put("height", ze1Var.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, ze1 ze1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65536, null, jSONObject, ze1Var) == null) && jSONObject != null) {
                try {
                    ze1Var.g = jSONObject.optString("url");
                    ze1Var.h = jSONObject.optInt("width");
                    ze1Var.i = jSONObject.optInt("height");
                    ze1Var.j = jSONObject.optString(PackageTable.MD5);
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, ze1 ze1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, ze1Var) == null) {
                try {
                    jSONObject.put("url", ze1Var.g);
                    jSONObject.put(PackageTable.MD5, ze1Var.j);
                    jSONObject.put("width", ze1Var.h);
                    jSONObject.put("height", ze1Var.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ze1() {
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
            if (this.G == 7 && re1.b() == 1) {
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

    public static boolean a(ze1 ze1Var) {
        InterceptResult invokeL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ze1Var)) == null) {
            if (TextUtils.isEmpty(ze1Var.d)) {
                str = "7";
                z = false;
            } else {
                str = "";
                z = true;
            }
            if (z && TextUtils.isEmpty(ze1Var.g)) {
                str = PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW;
                z = false;
            }
            if (z && System.currentTimeMillis() / 1000 > ze1Var.t) {
                str = "68";
                z = false;
            }
            if (z) {
                return true;
            }
            new BaseVM(ze1Var).g(str);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static ze1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            ze1 ze1Var = new ze1();
            try {
                a.a(jSONObject, ze1Var);
            } catch (Exception unused) {
            }
            return ze1Var;
        }
        return (ze1) invokeL.objValue;
    }

    public static ze1 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            try {
                ze1 ze1Var = new ze1();
                a.b(jSONObject, ze1Var);
                return ze1Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (ze1) invokeL.objValue;
    }

    public static List<ze1> k(JSONArray jSONArray) {
        InterceptResult invokeL;
        ze1 c2;
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

    public static void m(ze1 ze1Var, ze1 ze1Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, ze1Var, ze1Var2) == null) {
            a.d(ze1Var, ze1Var2);
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
