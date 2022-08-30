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
import com.baidu.tieba.q01;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class rb1 {
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
    public int I;
    public int J;
    public JSONObject K;
    public JSONObject L;
    public int M;
    public int N;
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

        public static void a(JSONObject jSONObject, rb1 rb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, jSONObject, rb1Var) == null) {
                try {
                    rb1Var.a = jSONObject.optInt("advisible");
                    rb1Var.b = jSONObject.optString("id");
                    rb1Var.c = jSONObject.optString("ukey");
                    rb1Var.d = jSONObject.optString("extra");
                    rb1Var.e = jSONObject.optString(TtmlNode.TAG_LAYOUT);
                    rb1Var.f = jSONObject.optInt("type");
                    rb1Var.k = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
                    rb1Var.o = jSONObject.optString("action");
                    rb1Var.p = jSONObject.optString("action_cmd");
                    rb1Var.l = jSONObject.optString("flag_name");
                    rb1Var.m = jSONObject.optInt("logo_type");
                    rb1Var.n = jSONObject.optInt(CriusAttrConstants.DISPLAY);
                    if (rb1Var.i()) {
                        b.a(jSONObject, rb1Var);
                    } else {
                        c.a(jSONObject, rb1Var);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("show_urls");
                    if (optJSONArray != null) {
                        rb1Var.q = new String[optJSONArray.length()];
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            rb1Var.q[i] = optJSONArray.optString(i);
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("click_urls");
                    if (optJSONArray2 != null) {
                        rb1Var.r = new String[optJSONArray2.length()];
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            rb1Var.r[i2] = optJSONArray2.optString(i2);
                        }
                    }
                    rb1Var.s = jSONObject.optLong("start");
                    rb1Var.t = jSONObject.optLong("end");
                    rb1Var.u = jSONObject.optInt("expose_interval");
                    rb1Var.v = jSONObject.optInt("expose_times");
                    rb1Var.w = jSONObject.optInt("preload_type");
                    rb1Var.z = jSONObject.optString("click_float_lottie_url");
                    rb1Var.A = jSONObject.optInt("float_bar_show", 1);
                    rb1Var.B = jSONObject.optInt("click_float_opt", 1);
                    rb1Var.C = jSONObject.optString("style_desc");
                    rb1Var.x = jSONObject.optInt("curRate");
                    rb1Var.E = jSONObject.optInt(TiebaStatic.Params.AD_TYPE);
                    rb1Var.F = jSONObject.optInt("ad_sort");
                    rb1Var.G = jSONObject.optInt("gesture_lottie_type");
                    rb1Var.H = jSONObject.optString("gesture_lottie_url");
                    rb1Var.I = jSONObject.optInt("gesture_lottie_sensitivity");
                    int optInt = jSONObject.optInt("is_topview", 0);
                    rb1Var.J = optInt;
                    if (optInt == 1 && jSONObject.optJSONObject("topview_data") != null) {
                        rb1Var.K = jSONObject.optJSONObject("topview_data");
                    }
                    if (jSONObject.optJSONObject("animation_data") != null) {
                        rb1Var.L = jSONObject.optJSONObject("animation_data");
                    }
                    rb1Var.M = jSONObject.optInt("shake_update_interval", 0);
                    rb1Var.N = jSONObject.optInt("shake_direction_count", 0);
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, rb1 rb1Var) {
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, rb1Var) == null) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
                    if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                        return;
                    }
                    rb1Var.a = optJSONObject.optInt("advisible", 1);
                    rb1Var.b = optJSONObject.optString("id");
                    rb1Var.c = optJSONObject.optString("ukey");
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
                                    rb1Var.d = optString2;
                                    break;
                                }
                            }
                            i++;
                        }
                    }
                    JSONArray optJSONArray3 = optJSONObject.optJSONArray("material");
                    if (optJSONArray3 == null || (optJSONObject2 = optJSONArray3.optJSONObject(0)) == null) {
                        return;
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("info");
                    if (optJSONArray4 == null) {
                        String optString3 = optJSONObject2.optString("info");
                        if (!TextUtils.isEmpty(optString3)) {
                            optJSONArray4 = new JSONArray(optString3);
                        }
                    }
                    if (optJSONArray4 != null) {
                        JSONObject optJSONObject4 = optJSONArray4.optJSONObject(0);
                        rb1Var.e = optJSONObject4.optString(TtmlNode.TAG_LAYOUT);
                        JSONObject optJSONObject5 = optJSONObject4.optJSONObject("common");
                        if (optJSONObject5 != null) {
                            rb1Var.f = optJSONObject5.optInt("type");
                            rb1Var.k = optJSONObject5.optString(BigdayActivityConfig.JUMP_URL);
                            rb1Var.o = optJSONObject5.optString("action");
                            rb1Var.p = optJSONObject5.optString("action_cmd");
                            rb1Var.l = optJSONObject5.optString("flag_name");
                            rb1Var.m = optJSONObject5.optInt("logo_type");
                            rb1Var.n = optJSONObject5.optInt(CriusAttrConstants.DISPLAY);
                            JSONArray optJSONArray5 = optJSONObject5.optJSONArray("image_list");
                            rb1Var.z = optJSONObject5.optString("click_float_lottie_url");
                            rb1Var.E = optJSONObject5.optInt(TiebaStatic.Params.AD_TYPE);
                            rb1Var.F = optJSONObject5.optInt("ad_sort");
                            rb1Var.G = optJSONObject5.optInt("gesture_lottie_type");
                            rb1Var.H = optJSONObject5.optString("gesture_lottie_url");
                            rb1Var.I = optJSONObject5.optInt("gesture_lottie_sensitivity");
                            rb1Var.J = optJSONObject5.optInt("is_topview", 0);
                            if (rb1Var.i() && optJSONArray5 != null && optJSONArray5.length() > 0) {
                                b.a(optJSONArray5.optJSONObject(0), rb1Var);
                            } else {
                                c.a(optJSONObject5, rb1Var);
                            }
                            rb1Var.L = optJSONObject5.optJSONObject("animation_data");
                            rb1Var.M = optJSONObject5.optInt("shake_update_interval", 0);
                            rb1Var.N = optJSONObject5.optInt("shake_direction_count", 0);
                        }
                        JSONArray optJSONArray6 = optJSONObject4.optJSONArray("show_urls");
                        if (optJSONArray6 != null) {
                            rb1Var.q = new String[optJSONArray6.length()];
                            int length = optJSONArray6.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                rb1Var.q[i2] = optJSONArray6.optString(i2);
                            }
                        }
                        JSONArray optJSONArray7 = optJSONObject4.optJSONArray("click_urls");
                        if (optJSONArray7 != null) {
                            rb1Var.r = new String[optJSONArray7.length()];
                            int length2 = optJSONArray7.length();
                            for (int i3 = 0; i3 < length2; i3++) {
                                rb1Var.r[i3] = optJSONArray7.optString(i3);
                            }
                        }
                        JSONObject optJSONObject6 = optJSONObject4.optJSONObject("policy");
                        if (optJSONObject6 != null) {
                            JSONObject jSONObject2 = optJSONObject6.getJSONObject("expire_time");
                            rb1Var.s = jSONObject2.optLong("start");
                            rb1Var.t = jSONObject2.optLong("end");
                            rb1Var.u = optJSONObject6.optInt("expose_interval");
                            rb1Var.v = optJSONObject6.optInt("expose_times");
                            rb1Var.w = optJSONObject6.optInt("preload_type");
                            rb1Var.A = optJSONObject6.optInt("float_bar_show", 1);
                            rb1Var.B = optJSONObject6.optInt("click_float_opt", 1);
                            rb1Var.C = optJSONObject6.optString("style_desc");
                        }
                        JSONObject optJSONObject7 = optJSONObject4.optJSONObject("topview_data");
                        if (rb1Var.J != 1 || optJSONObject7 == null) {
                            return;
                        }
                        JSONObject optJSONObject8 = optJSONObject7.optJSONObject("content");
                        if (optJSONObject8 == null) {
                            rb1Var.J = 0;
                            return;
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        yx0.f(jSONObject3, "click_float_lottie_url", rb1Var.z);
                        yx0.d(jSONObject3, "click_float_opt", rb1Var.B);
                        yx0.d(jSONObject3, "float_bar_show", rb1Var.A);
                        yx0.g(jSONObject3, SetImageWatermarkTypeReqMsg.SWITCH, true);
                        yx0.f(jSONObject3, "style_desc", rb1Var.C);
                        yx0.d(jSONObject3, "countdown", rb1Var.n);
                        yx0.f(jSONObject3, "source_path", pb1.s(rb1Var.g));
                        yx0.f(optJSONObject8, "topview", jSONObject3);
                        rb1Var.K = optJSONObject7;
                    }
                } catch (Exception unused) {
                }
            }
        }

        public static void c(JSONObject jSONObject, rb1 rb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, jSONObject, rb1Var) == null) {
                try {
                    jSONObject.put("advisible", rb1Var.a);
                    jSONObject.put("id", rb1Var.b);
                    jSONObject.put("ukey", rb1Var.c);
                    jSONObject.put("extra", rb1Var.d);
                    jSONObject.put(TtmlNode.TAG_LAYOUT, rb1Var.e);
                    jSONObject.put("type", rb1Var.f);
                    jSONObject.put(BigdayActivityConfig.JUMP_URL, rb1Var.k);
                    jSONObject.put("action", rb1Var.o);
                    jSONObject.put("action_cmd", rb1Var.p);
                    jSONObject.put("flag_name", rb1Var.l);
                    jSONObject.put("logo_type", rb1Var.m);
                    jSONObject.put(CriusAttrConstants.DISPLAY, rb1Var.n);
                    jSONObject.put("start", rb1Var.s);
                    jSONObject.put("end", rb1Var.t);
                    jSONObject.put("expose_times", rb1Var.v);
                    jSONObject.put("expose_interval", rb1Var.u);
                    jSONObject.put("preload_type", rb1Var.w);
                    jSONObject.put("curRate", rb1Var.x);
                    jSONObject.put("click_float_lottie_url", rb1Var.z);
                    jSONObject.put("float_bar_show", rb1Var.A);
                    jSONObject.put("click_float_opt", rb1Var.B);
                    jSONObject.put("style_desc", rb1Var.C);
                    jSONObject.put(TiebaStatic.Params.AD_TYPE, rb1Var.E);
                    jSONObject.put("ad_sort", rb1Var.F);
                    jSONObject.put("gesture_lottie_type", rb1Var.G);
                    jSONObject.put("gesture_lottie_url", rb1Var.H);
                    jSONObject.put("gesture_lottie_sensitivity", rb1Var.I);
                    jSONObject.put("is_topview", rb1Var.J);
                    if (rb1Var.J == 1 && rb1Var.K != null) {
                        jSONObject.put("topview_data", rb1Var.K);
                    }
                    if (rb1Var.L != null) {
                        jSONObject.put("animation_data", rb1Var.L);
                    }
                    jSONObject.put("shake_update_interval", rb1Var.M);
                    jSONObject.put("shake_direction_count", rb1Var.N);
                    if (rb1Var.q != null) {
                        if (q01.b.c()) {
                            jSONObject.put("show_urls", new JSONArray(rb1Var.q));
                        } else {
                            jSONObject.put("show_urls", new JSONArray((Collection) Arrays.asList(rb1Var.q)));
                        }
                    }
                    if (rb1Var.r != null) {
                        if (q01.b.c()) {
                            jSONObject.put("click_urls", new JSONArray(rb1Var.r));
                        } else {
                            jSONObject.put("click_urls", new JSONArray((Collection) Arrays.asList(rb1Var.r)));
                        }
                    }
                    if (rb1Var.i()) {
                        b.b(jSONObject, rb1Var);
                    } else {
                        c.b(jSONObject, rb1Var);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void d(rb1 rb1Var, rb1 rb1Var2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, rb1Var, rb1Var2) == null) {
                rb1Var.a = rb1Var2.a;
                rb1Var.b = rb1Var2.b;
                rb1Var.c = rb1Var2.c;
                rb1Var.d = rb1Var2.d;
                rb1Var.e = rb1Var2.e;
                rb1Var.f = rb1Var2.f;
                rb1Var.g = rb1Var2.g;
                rb1Var.h = rb1Var2.h;
                rb1Var.i = rb1Var2.i;
                rb1Var.j = rb1Var2.j;
                rb1Var.k = rb1Var2.k;
                rb1Var.l = rb1Var2.l;
                rb1Var.m = rb1Var2.m;
                rb1Var.n = rb1Var2.n;
                rb1Var.o = rb1Var2.o;
                rb1Var.p = rb1Var2.p;
                rb1Var.q = rb1Var2.q;
                rb1Var.r = rb1Var2.r;
                rb1Var.s = rb1Var2.s;
                rb1Var.t = rb1Var2.t;
                rb1Var.u = rb1Var2.u;
                rb1Var.v = rb1Var2.v;
                rb1Var.x = rb1Var2.x;
                rb1Var.z = rb1Var2.z;
                rb1Var.A = rb1Var2.A;
                rb1Var.B = rb1Var2.B;
                rb1Var.C = rb1Var2.C;
                rb1Var.E = rb1Var2.E;
                rb1Var.F = rb1Var2.F;
                rb1Var.G = rb1Var2.G;
                rb1Var.H = rb1Var2.H;
                rb1Var.I = rb1Var2.I;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, rb1 rb1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65536, null, jSONObject, rb1Var) == null) || jSONObject == null) {
                return;
            }
            try {
                rb1Var.g = jSONObject.optString("url");
                rb1Var.h = jSONObject.optInt("width");
                rb1Var.i = jSONObject.optInt("height");
                rb1Var.j = jSONObject.optString("imageMd5");
            } catch (Exception unused) {
            }
        }

        public static void b(JSONObject jSONObject, rb1 rb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, rb1Var) == null) {
                try {
                    jSONObject.put("url", rb1Var.g);
                    jSONObject.put("imageMd5", rb1Var.j);
                    jSONObject.put("width", rb1Var.h);
                    jSONObject.put("height", rb1Var.i);
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

        public static void a(JSONObject jSONObject, rb1 rb1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65536, null, jSONObject, rb1Var) == null) || jSONObject == null) {
                return;
            }
            try {
                rb1Var.g = jSONObject.optString("url");
                rb1Var.h = jSONObject.optInt("width");
                rb1Var.i = jSONObject.optInt("height");
                rb1Var.j = jSONObject.optString(PackageTable.MD5);
            } catch (Exception unused) {
            }
        }

        public static void b(JSONObject jSONObject, rb1 rb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, rb1Var) == null) {
                try {
                    jSONObject.put("url", rb1Var.g);
                    jSONObject.put(PackageTable.MD5, rb1Var.j);
                    jSONObject.put("width", rb1Var.h);
                    jSONObject.put("height", rb1Var.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public rb1() {
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

    public static boolean a(rb1 rb1Var) {
        InterceptResult invokeL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, rb1Var)) == null) {
            if (TextUtils.isEmpty(rb1Var.d)) {
                str = "7";
                z = false;
            } else {
                str = "";
                z = true;
            }
            if (z && TextUtils.isEmpty(rb1Var.g)) {
                str = "66";
                z = false;
            }
            if (z && System.currentTimeMillis() / 1000 > rb1Var.t) {
                str = "68";
                z = false;
            }
            if (z) {
                return true;
            }
            new BaseVM(rb1Var).g(str);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static rb1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            rb1 rb1Var = new rb1();
            try {
                a.a(jSONObject, rb1Var);
            } catch (Exception unused) {
            }
            return rb1Var;
        }
        return (rb1) invokeL.objValue;
    }

    public static rb1 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            try {
                rb1 rb1Var = new rb1();
                a.b(jSONObject, rb1Var);
                return rb1Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (rb1) invokeL.objValue;
    }

    public static List<rb1> j(JSONArray jSONArray) {
        InterceptResult invokeL;
        rb1 c2;
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

    public static void l(rb1 rb1Var, rb1 rb1Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, rb1Var, rb1Var2) == null) {
            a.d(rb1Var, rb1Var2);
        }
    }

    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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

    @NonNull
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TextUtils.equals(this.e, "splash_image") ? "image" : TextUtils.equals(this.e, "splash_video") ? "video" : "" : (String) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.E == 3 : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f == 1 : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i = this.E;
            return i == 0 || i == 1 || i == 2;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? TextUtils.equals(this.e, "splash_image") : invokeV.booleanValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            a.c(jSONObject, this);
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
