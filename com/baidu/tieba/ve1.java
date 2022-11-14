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
import com.baidu.tieba.n31;
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
public class ve1 {
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

        public static void a(JSONObject jSONObject, ve1 ve1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, jSONObject, ve1Var) == null) {
                try {
                    ve1Var.a = jSONObject.optInt("advisible");
                    ve1Var.b = jSONObject.optString("id");
                    ve1Var.c = jSONObject.optString("ukey");
                    ve1Var.d = jSONObject.optString("extra");
                    ve1Var.e = jSONObject.optString(TtmlNode.TAG_LAYOUT);
                    ve1Var.f = jSONObject.optInt("type");
                    ve1Var.k = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
                    ve1Var.o = jSONObject.optString("action");
                    ve1Var.p = jSONObject.optString("action_cmd");
                    ve1Var.l = jSONObject.optString("flag_name");
                    ve1Var.m = jSONObject.optInt("logo_type");
                    ve1Var.n = jSONObject.optInt(CriusAttrConstants.DISPLAY);
                    if (ve1Var.j()) {
                        b.a(jSONObject, ve1Var);
                    } else {
                        c.a(jSONObject, ve1Var);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("show_urls");
                    if (optJSONArray != null) {
                        ve1Var.q = new String[optJSONArray.length()];
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            ve1Var.q[i] = optJSONArray.optString(i);
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("click_urls");
                    if (optJSONArray2 != null) {
                        ve1Var.r = new String[optJSONArray2.length()];
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            ve1Var.r[i2] = optJSONArray2.optString(i2);
                        }
                    }
                    ve1Var.s = jSONObject.optLong("start");
                    ve1Var.t = jSONObject.optLong("end");
                    ve1Var.u = jSONObject.optInt("expose_interval");
                    ve1Var.v = jSONObject.optInt("expose_times");
                    ve1Var.w = jSONObject.optInt("preload_type");
                    ve1Var.z = jSONObject.optString("click_float_lottie_url");
                    ve1Var.A = jSONObject.optInt("float_bar_show", 1);
                    ve1Var.B = jSONObject.optInt("click_float_opt", 1);
                    ve1Var.C = jSONObject.optString("style_desc");
                    ve1Var.x = jSONObject.optInt("curRate");
                    ve1Var.E = jSONObject.optInt(TiebaStatic.Params.AD_TYPE);
                    ve1Var.F = jSONObject.optInt("ad_sort");
                    ve1Var.G = jSONObject.optInt("gesture_lottie_type");
                    ve1Var.H = jSONObject.optString("gesture_lottie_url");
                    ve1Var.I = (float) jSONObject.optDouble("gesture_lottie_sensitivity", 0.0d);
                    int optInt = jSONObject.optInt("is_topview", 0);
                    ve1Var.J = optInt;
                    if (optInt == 1 && jSONObject.optJSONObject("topview_data") != null) {
                        ve1Var.K = jSONObject.optJSONObject("topview_data");
                    }
                    if (jSONObject.optJSONObject("animation_data") != null) {
                        ve1Var.L = jSONObject.optJSONObject("animation_data");
                    }
                    ve1Var.M = jSONObject.optInt("shake_update_interval", 0);
                    ve1Var.N = jSONObject.optInt("shake_direction_count", 0);
                    ve1Var.O = jSONObject.optString("key");
                    ve1Var.P = (float) jSONObject.optDouble("hot_shake_sensitivity", 0.0d);
                    ve1Var.Q = jSONObject.optInt("hot_background_time", 0);
                } catch (Exception unused) {
                }
            }
        }

        public static void c(JSONObject jSONObject, ve1 ve1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, jSONObject, ve1Var) == null) {
                try {
                    jSONObject.put("advisible", ve1Var.a);
                    jSONObject.put("id", ve1Var.b);
                    jSONObject.put("ukey", ve1Var.c);
                    jSONObject.put("extra", ve1Var.d);
                    jSONObject.put(TtmlNode.TAG_LAYOUT, ve1Var.e);
                    jSONObject.put("type", ve1Var.f);
                    jSONObject.put(BigdayActivityConfig.JUMP_URL, ve1Var.k);
                    jSONObject.put("action", ve1Var.o);
                    jSONObject.put("action_cmd", ve1Var.p);
                    jSONObject.put("flag_name", ve1Var.l);
                    jSONObject.put("logo_type", ve1Var.m);
                    jSONObject.put(CriusAttrConstants.DISPLAY, ve1Var.n);
                    jSONObject.put("start", ve1Var.s);
                    jSONObject.put("end", ve1Var.t);
                    jSONObject.put("expose_times", ve1Var.v);
                    jSONObject.put("expose_interval", ve1Var.u);
                    jSONObject.put("preload_type", ve1Var.w);
                    jSONObject.put("curRate", ve1Var.x);
                    jSONObject.put("click_float_lottie_url", ve1Var.z);
                    jSONObject.put("float_bar_show", ve1Var.A);
                    jSONObject.put("click_float_opt", ve1Var.B);
                    jSONObject.put("style_desc", ve1Var.C);
                    jSONObject.put(TiebaStatic.Params.AD_TYPE, ve1Var.E);
                    jSONObject.put("ad_sort", ve1Var.F);
                    jSONObject.put("gesture_lottie_type", ve1Var.G);
                    jSONObject.put("gesture_lottie_url", ve1Var.H);
                    jSONObject.put("gesture_lottie_sensitivity", ve1Var.I);
                    jSONObject.put("is_topview", ve1Var.J);
                    if (ve1Var.J == 1 && ve1Var.K != null) {
                        jSONObject.put("topview_data", ve1Var.K);
                    }
                    if (ve1Var.L != null) {
                        jSONObject.put("animation_data", ve1Var.L);
                    }
                    jSONObject.put("shake_update_interval", ve1Var.M);
                    jSONObject.put("shake_direction_count", ve1Var.N);
                    jSONObject.put("key", ve1Var.O);
                    jSONObject.put("hot_shake_sensitivity", ve1Var.P);
                    jSONObject.put("hot_background_time", ve1Var.Q);
                    if (ve1Var.q != null) {
                        if (n31.b.c()) {
                            jSONObject.put("show_urls", new JSONArray(ve1Var.q));
                        } else {
                            jSONObject.put("show_urls", new JSONArray((Collection) Arrays.asList(ve1Var.q)));
                        }
                    }
                    if (ve1Var.r != null) {
                        if (n31.b.c()) {
                            jSONObject.put("click_urls", new JSONArray(ve1Var.r));
                        } else {
                            jSONObject.put("click_urls", new JSONArray((Collection) Arrays.asList(ve1Var.r)));
                        }
                    }
                    if (ve1Var.j()) {
                        b.b(jSONObject, ve1Var);
                    } else {
                        c.b(jSONObject, ve1Var);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void b(JSONObject jSONObject, ve1 ve1Var) {
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, ve1Var) == null) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
                    if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                        return;
                    }
                    ve1Var.a = optJSONObject.optInt("advisible", 1);
                    ve1Var.b = optJSONObject.optString("id");
                    ve1Var.c = optJSONObject.optString("ukey");
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
                                    ve1Var.d = optString2;
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
                            ve1Var.e = optJSONObject4.optString(TtmlNode.TAG_LAYOUT);
                            JSONObject optJSONObject5 = optJSONObject4.optJSONObject("common");
                            if (optJSONObject5 != null) {
                                ve1Var.f = optJSONObject5.optInt("type");
                                ve1Var.k = optJSONObject5.optString(BigdayActivityConfig.JUMP_URL);
                                ve1Var.o = optJSONObject5.optString("action");
                                ve1Var.p = optJSONObject5.optString("action_cmd");
                                ve1Var.l = optJSONObject5.optString("flag_name");
                                ve1Var.m = optJSONObject5.optInt("logo_type");
                                ve1Var.n = optJSONObject5.optInt(CriusAttrConstants.DISPLAY);
                                JSONArray optJSONArray5 = optJSONObject5.optJSONArray("image_list");
                                ve1Var.z = optJSONObject5.optString("click_float_lottie_url");
                                ve1Var.E = optJSONObject5.optInt(TiebaStatic.Params.AD_TYPE);
                                ve1Var.F = optJSONObject5.optInt("ad_sort");
                                ve1Var.G = optJSONObject5.optInt("gesture_lottie_type");
                                ve1Var.H = optJSONObject5.optString("gesture_lottie_url");
                                ve1Var.I = (float) optJSONObject5.optDouble("gesture_lottie_sensitivity", 0.0d);
                                ve1Var.J = optJSONObject5.optInt("is_topview", 0);
                                if (ve1Var.j() && optJSONArray5 != null && optJSONArray5.length() > 0) {
                                    b.a(optJSONArray5.optJSONObject(0), ve1Var);
                                } else {
                                    c.a(optJSONObject5, ve1Var);
                                }
                                ve1Var.L = optJSONObject5.optJSONObject("animation_data");
                                ve1Var.M = optJSONObject5.optInt("shake_update_interval", 0);
                                ve1Var.N = optJSONObject5.optInt("shake_direction_count", 0);
                                ve1Var.O = optJSONObject5.optString("key");
                                ve1Var.P = (float) optJSONObject5.optDouble("hot_shake_sensitivity", 0.0d);
                            }
                            JSONArray optJSONArray6 = optJSONObject4.optJSONArray("show_urls");
                            if (optJSONArray6 != null) {
                                ve1Var.q = new String[optJSONArray6.length()];
                                int length = optJSONArray6.length();
                                for (int i2 = 0; i2 < length; i2++) {
                                    ve1Var.q[i2] = optJSONArray6.optString(i2);
                                }
                            }
                            JSONArray optJSONArray7 = optJSONObject4.optJSONArray("click_urls");
                            if (optJSONArray7 != null) {
                                ve1Var.r = new String[optJSONArray7.length()];
                                int length2 = optJSONArray7.length();
                                for (int i3 = 0; i3 < length2; i3++) {
                                    ve1Var.r[i3] = optJSONArray7.optString(i3);
                                }
                            }
                            JSONObject optJSONObject6 = optJSONObject4.optJSONObject("policy");
                            if (optJSONObject6 != null) {
                                JSONObject jSONObject2 = optJSONObject6.getJSONObject("expire_time");
                                ve1Var.s = jSONObject2.optLong("start");
                                ve1Var.t = jSONObject2.optLong("end");
                                ve1Var.u = optJSONObject6.optInt("expose_interval");
                                ve1Var.v = optJSONObject6.optInt("expose_times");
                                ve1Var.w = optJSONObject6.optInt("preload_type");
                                ve1Var.A = optJSONObject6.optInt("float_bar_show", 1);
                                ve1Var.B = optJSONObject6.optInt("click_float_opt", 1);
                                ve1Var.C = optJSONObject6.optString("style_desc");
                                ve1Var.Q = optJSONObject6.optInt("hot_background_time", 0);
                            }
                            JSONObject optJSONObject7 = optJSONObject4.optJSONObject("topview_data");
                            if (ve1Var.J == 1 && optJSONObject7 != null) {
                                JSONObject optJSONObject8 = optJSONObject7.optJSONObject("content");
                                if (optJSONObject8 == null) {
                                    ve1Var.J = 0;
                                    return;
                                }
                                JSONObject jSONObject3 = new JSONObject();
                                q01.f(jSONObject3, "click_float_lottie_url", ve1Var.z);
                                q01.d(jSONObject3, "click_float_opt", ve1Var.B);
                                q01.d(jSONObject3, "float_bar_show", ve1Var.A);
                                q01.g(jSONObject3, SetImageWatermarkTypeReqMsg.SWITCH, true);
                                q01.f(jSONObject3, "style_desc", ve1Var.C);
                                q01.d(jSONObject3, "countdown", ve1Var.n);
                                q01.f(jSONObject3, "source_path", te1.q(ve1Var.g));
                                q01.f(optJSONObject8, "topview", jSONObject3);
                                ve1Var.K = optJSONObject7;
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }

        public static void d(ve1 ve1Var, ve1 ve1Var2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, ve1Var, ve1Var2) == null) {
                ve1Var.a = ve1Var2.a;
                ve1Var.b = ve1Var2.b;
                ve1Var.c = ve1Var2.c;
                ve1Var.d = ve1Var2.d;
                ve1Var.e = ve1Var2.e;
                ve1Var.f = ve1Var2.f;
                ve1Var.g = ve1Var2.g;
                ve1Var.h = ve1Var2.h;
                ve1Var.i = ve1Var2.i;
                ve1Var.j = ve1Var2.j;
                ve1Var.k = ve1Var2.k;
                ve1Var.l = ve1Var2.l;
                ve1Var.m = ve1Var2.m;
                ve1Var.n = ve1Var2.n;
                ve1Var.o = ve1Var2.o;
                ve1Var.p = ve1Var2.p;
                ve1Var.q = ve1Var2.q;
                ve1Var.r = ve1Var2.r;
                ve1Var.s = ve1Var2.s;
                ve1Var.t = ve1Var2.t;
                ve1Var.u = ve1Var2.u;
                ve1Var.v = ve1Var2.v;
                ve1Var.x = ve1Var2.x;
                ve1Var.z = ve1Var2.z;
                ve1Var.A = ve1Var2.A;
                ve1Var.B = ve1Var2.B;
                ve1Var.C = ve1Var2.C;
                ve1Var.E = ve1Var2.E;
                ve1Var.F = ve1Var2.F;
                ve1Var.G = ve1Var2.G;
                ve1Var.H = ve1Var2.H;
                ve1Var.I = ve1Var2.I;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, ve1 ve1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65536, null, jSONObject, ve1Var) == null) && jSONObject != null) {
                try {
                    ve1Var.g = jSONObject.optString("url");
                    ve1Var.h = jSONObject.optInt("width");
                    ve1Var.i = jSONObject.optInt("height");
                    ve1Var.j = jSONObject.optString("imageMd5");
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, ve1 ve1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, ve1Var) == null) {
                try {
                    jSONObject.put("url", ve1Var.g);
                    jSONObject.put("imageMd5", ve1Var.j);
                    jSONObject.put("width", ve1Var.h);
                    jSONObject.put("height", ve1Var.i);
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

        public static void a(JSONObject jSONObject, ve1 ve1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65536, null, jSONObject, ve1Var) == null) && jSONObject != null) {
                try {
                    ve1Var.g = jSONObject.optString("url");
                    ve1Var.h = jSONObject.optInt("width");
                    ve1Var.i = jSONObject.optInt("height");
                    ve1Var.j = jSONObject.optString(PackageTable.MD5);
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, ve1 ve1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, ve1Var) == null) {
                try {
                    jSONObject.put("url", ve1Var.g);
                    jSONObject.put(PackageTable.MD5, ve1Var.j);
                    jSONObject.put("width", ve1Var.h);
                    jSONObject.put("height", ve1Var.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ve1() {
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
            if (this.G == 7 && ne1.b() == 1) {
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

    public static boolean a(ve1 ve1Var) {
        InterceptResult invokeL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ve1Var)) == null) {
            if (TextUtils.isEmpty(ve1Var.d)) {
                str = "7";
                z = false;
            } else {
                str = "";
                z = true;
            }
            if (z && TextUtils.isEmpty(ve1Var.g)) {
                str = PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW;
                z = false;
            }
            if (z && System.currentTimeMillis() / 1000 > ve1Var.t) {
                str = "68";
                z = false;
            }
            if (z) {
                return true;
            }
            new BaseVM(ve1Var).g(str);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static ve1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            ve1 ve1Var = new ve1();
            try {
                a.a(jSONObject, ve1Var);
            } catch (Exception unused) {
            }
            return ve1Var;
        }
        return (ve1) invokeL.objValue;
    }

    public static ve1 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            try {
                ve1 ve1Var = new ve1();
                a.b(jSONObject, ve1Var);
                return ve1Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (ve1) invokeL.objValue;
    }

    public static List<ve1> k(JSONArray jSONArray) {
        InterceptResult invokeL;
        ve1 c2;
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

    public static void m(ve1 ve1Var, ve1 ve1Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, ve1Var, ve1Var2) == null) {
            a.d(ve1Var, ve1Var2);
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
