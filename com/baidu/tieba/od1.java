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
import com.baidu.tieba.g21;
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
public class od1 {
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
    public String O;
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

        public static void a(JSONObject jSONObject, od1 od1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, jSONObject, od1Var) == null) {
                try {
                    od1Var.a = jSONObject.optInt("advisible");
                    od1Var.b = jSONObject.optString("id");
                    od1Var.c = jSONObject.optString("ukey");
                    od1Var.d = jSONObject.optString("extra");
                    od1Var.e = jSONObject.optString(TtmlNode.TAG_LAYOUT);
                    od1Var.f = jSONObject.optInt("type");
                    od1Var.k = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
                    od1Var.o = jSONObject.optString("action");
                    od1Var.p = jSONObject.optString("action_cmd");
                    od1Var.l = jSONObject.optString("flag_name");
                    od1Var.m = jSONObject.optInt("logo_type");
                    od1Var.n = jSONObject.optInt(CriusAttrConstants.DISPLAY);
                    if (od1Var.i()) {
                        b.a(jSONObject, od1Var);
                    } else {
                        c.a(jSONObject, od1Var);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("show_urls");
                    if (optJSONArray != null) {
                        od1Var.q = new String[optJSONArray.length()];
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            od1Var.q[i] = optJSONArray.optString(i);
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("click_urls");
                    if (optJSONArray2 != null) {
                        od1Var.r = new String[optJSONArray2.length()];
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            od1Var.r[i2] = optJSONArray2.optString(i2);
                        }
                    }
                    od1Var.s = jSONObject.optLong("start");
                    od1Var.t = jSONObject.optLong("end");
                    od1Var.u = jSONObject.optInt("expose_interval");
                    od1Var.v = jSONObject.optInt("expose_times");
                    od1Var.w = jSONObject.optInt("preload_type");
                    od1Var.z = jSONObject.optString("click_float_lottie_url");
                    od1Var.A = jSONObject.optInt("float_bar_show", 1);
                    od1Var.B = jSONObject.optInt("click_float_opt", 1);
                    od1Var.C = jSONObject.optString("style_desc");
                    od1Var.x = jSONObject.optInt("curRate");
                    od1Var.E = jSONObject.optInt(TiebaStatic.Params.AD_TYPE);
                    od1Var.F = jSONObject.optInt("ad_sort");
                    od1Var.G = jSONObject.optInt("gesture_lottie_type");
                    od1Var.H = jSONObject.optString("gesture_lottie_url");
                    od1Var.I = jSONObject.optInt("gesture_lottie_sensitivity");
                    int optInt = jSONObject.optInt("is_topview", 0);
                    od1Var.J = optInt;
                    if (optInt == 1 && jSONObject.optJSONObject("topview_data") != null) {
                        od1Var.K = jSONObject.optJSONObject("topview_data");
                    }
                    if (jSONObject.optJSONObject("animation_data") != null) {
                        od1Var.L = jSONObject.optJSONObject("animation_data");
                    }
                    od1Var.M = jSONObject.optInt("shake_update_interval", 0);
                    od1Var.N = jSONObject.optInt("shake_direction_count", 0);
                    od1Var.O = jSONObject.optString("key");
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, od1 od1Var) {
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, od1Var) == null) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
                    if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                        return;
                    }
                    od1Var.a = optJSONObject.optInt("advisible", 1);
                    od1Var.b = optJSONObject.optString("id");
                    od1Var.c = optJSONObject.optString("ukey");
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
                                    od1Var.d = optString2;
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
                        od1Var.e = optJSONObject4.optString(TtmlNode.TAG_LAYOUT);
                        JSONObject optJSONObject5 = optJSONObject4.optJSONObject("common");
                        if (optJSONObject5 != null) {
                            od1Var.f = optJSONObject5.optInt("type");
                            od1Var.k = optJSONObject5.optString(BigdayActivityConfig.JUMP_URL);
                            od1Var.o = optJSONObject5.optString("action");
                            od1Var.p = optJSONObject5.optString("action_cmd");
                            od1Var.l = optJSONObject5.optString("flag_name");
                            od1Var.m = optJSONObject5.optInt("logo_type");
                            od1Var.n = optJSONObject5.optInt(CriusAttrConstants.DISPLAY);
                            JSONArray optJSONArray5 = optJSONObject5.optJSONArray("image_list");
                            od1Var.z = optJSONObject5.optString("click_float_lottie_url");
                            od1Var.E = optJSONObject5.optInt(TiebaStatic.Params.AD_TYPE);
                            od1Var.F = optJSONObject5.optInt("ad_sort");
                            od1Var.G = optJSONObject5.optInt("gesture_lottie_type");
                            od1Var.H = optJSONObject5.optString("gesture_lottie_url");
                            od1Var.I = optJSONObject5.optInt("gesture_lottie_sensitivity");
                            od1Var.J = optJSONObject5.optInt("is_topview", 0);
                            if (od1Var.i() && optJSONArray5 != null && optJSONArray5.length() > 0) {
                                b.a(optJSONArray5.optJSONObject(0), od1Var);
                            } else {
                                c.a(optJSONObject5, od1Var);
                            }
                            od1Var.L = optJSONObject5.optJSONObject("animation_data");
                            od1Var.M = optJSONObject5.optInt("shake_update_interval", 0);
                            od1Var.N = optJSONObject5.optInt("shake_direction_count", 0);
                            od1Var.O = optJSONObject5.optString("key");
                        }
                        JSONArray optJSONArray6 = optJSONObject4.optJSONArray("show_urls");
                        if (optJSONArray6 != null) {
                            od1Var.q = new String[optJSONArray6.length()];
                            int length = optJSONArray6.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                od1Var.q[i2] = optJSONArray6.optString(i2);
                            }
                        }
                        JSONArray optJSONArray7 = optJSONObject4.optJSONArray("click_urls");
                        if (optJSONArray7 != null) {
                            od1Var.r = new String[optJSONArray7.length()];
                            int length2 = optJSONArray7.length();
                            for (int i3 = 0; i3 < length2; i3++) {
                                od1Var.r[i3] = optJSONArray7.optString(i3);
                            }
                        }
                        JSONObject optJSONObject6 = optJSONObject4.optJSONObject("policy");
                        if (optJSONObject6 != null) {
                            JSONObject jSONObject2 = optJSONObject6.getJSONObject("expire_time");
                            od1Var.s = jSONObject2.optLong("start");
                            od1Var.t = jSONObject2.optLong("end");
                            od1Var.u = optJSONObject6.optInt("expose_interval");
                            od1Var.v = optJSONObject6.optInt("expose_times");
                            od1Var.w = optJSONObject6.optInt("preload_type");
                            od1Var.A = optJSONObject6.optInt("float_bar_show", 1);
                            od1Var.B = optJSONObject6.optInt("click_float_opt", 1);
                            od1Var.C = optJSONObject6.optString("style_desc");
                        }
                        JSONObject optJSONObject7 = optJSONObject4.optJSONObject("topview_data");
                        if (od1Var.J != 1 || optJSONObject7 == null) {
                            return;
                        }
                        JSONObject optJSONObject8 = optJSONObject7.optJSONObject("content");
                        if (optJSONObject8 == null) {
                            od1Var.J = 0;
                            return;
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        kz0.f(jSONObject3, "click_float_lottie_url", od1Var.z);
                        kz0.d(jSONObject3, "click_float_opt", od1Var.B);
                        kz0.d(jSONObject3, "float_bar_show", od1Var.A);
                        kz0.g(jSONObject3, SetImageWatermarkTypeReqMsg.SWITCH, true);
                        kz0.f(jSONObject3, "style_desc", od1Var.C);
                        kz0.d(jSONObject3, "countdown", od1Var.n);
                        kz0.f(jSONObject3, "source_path", md1.s(od1Var.g));
                        kz0.f(optJSONObject8, "topview", jSONObject3);
                        od1Var.K = optJSONObject7;
                    }
                } catch (Exception unused) {
                }
            }
        }

        public static void c(JSONObject jSONObject, od1 od1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, jSONObject, od1Var) == null) {
                try {
                    jSONObject.put("advisible", od1Var.a);
                    jSONObject.put("id", od1Var.b);
                    jSONObject.put("ukey", od1Var.c);
                    jSONObject.put("extra", od1Var.d);
                    jSONObject.put(TtmlNode.TAG_LAYOUT, od1Var.e);
                    jSONObject.put("type", od1Var.f);
                    jSONObject.put(BigdayActivityConfig.JUMP_URL, od1Var.k);
                    jSONObject.put("action", od1Var.o);
                    jSONObject.put("action_cmd", od1Var.p);
                    jSONObject.put("flag_name", od1Var.l);
                    jSONObject.put("logo_type", od1Var.m);
                    jSONObject.put(CriusAttrConstants.DISPLAY, od1Var.n);
                    jSONObject.put("start", od1Var.s);
                    jSONObject.put("end", od1Var.t);
                    jSONObject.put("expose_times", od1Var.v);
                    jSONObject.put("expose_interval", od1Var.u);
                    jSONObject.put("preload_type", od1Var.w);
                    jSONObject.put("curRate", od1Var.x);
                    jSONObject.put("click_float_lottie_url", od1Var.z);
                    jSONObject.put("float_bar_show", od1Var.A);
                    jSONObject.put("click_float_opt", od1Var.B);
                    jSONObject.put("style_desc", od1Var.C);
                    jSONObject.put(TiebaStatic.Params.AD_TYPE, od1Var.E);
                    jSONObject.put("ad_sort", od1Var.F);
                    jSONObject.put("gesture_lottie_type", od1Var.G);
                    jSONObject.put("gesture_lottie_url", od1Var.H);
                    jSONObject.put("gesture_lottie_sensitivity", od1Var.I);
                    jSONObject.put("is_topview", od1Var.J);
                    if (od1Var.J == 1 && od1Var.K != null) {
                        jSONObject.put("topview_data", od1Var.K);
                    }
                    if (od1Var.L != null) {
                        jSONObject.put("animation_data", od1Var.L);
                    }
                    jSONObject.put("shake_update_interval", od1Var.M);
                    jSONObject.put("shake_direction_count", od1Var.N);
                    jSONObject.put("key", od1Var.O);
                    if (od1Var.q != null) {
                        if (g21.b.c()) {
                            jSONObject.put("show_urls", new JSONArray(od1Var.q));
                        } else {
                            jSONObject.put("show_urls", new JSONArray((Collection) Arrays.asList(od1Var.q)));
                        }
                    }
                    if (od1Var.r != null) {
                        if (g21.b.c()) {
                            jSONObject.put("click_urls", new JSONArray(od1Var.r));
                        } else {
                            jSONObject.put("click_urls", new JSONArray((Collection) Arrays.asList(od1Var.r)));
                        }
                    }
                    if (od1Var.i()) {
                        b.b(jSONObject, od1Var);
                    } else {
                        c.b(jSONObject, od1Var);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void d(od1 od1Var, od1 od1Var2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, od1Var, od1Var2) == null) {
                od1Var.a = od1Var2.a;
                od1Var.b = od1Var2.b;
                od1Var.c = od1Var2.c;
                od1Var.d = od1Var2.d;
                od1Var.e = od1Var2.e;
                od1Var.f = od1Var2.f;
                od1Var.g = od1Var2.g;
                od1Var.h = od1Var2.h;
                od1Var.i = od1Var2.i;
                od1Var.j = od1Var2.j;
                od1Var.k = od1Var2.k;
                od1Var.l = od1Var2.l;
                od1Var.m = od1Var2.m;
                od1Var.n = od1Var2.n;
                od1Var.o = od1Var2.o;
                od1Var.p = od1Var2.p;
                od1Var.q = od1Var2.q;
                od1Var.r = od1Var2.r;
                od1Var.s = od1Var2.s;
                od1Var.t = od1Var2.t;
                od1Var.u = od1Var2.u;
                od1Var.v = od1Var2.v;
                od1Var.x = od1Var2.x;
                od1Var.z = od1Var2.z;
                od1Var.A = od1Var2.A;
                od1Var.B = od1Var2.B;
                od1Var.C = od1Var2.C;
                od1Var.E = od1Var2.E;
                od1Var.F = od1Var2.F;
                od1Var.G = od1Var2.G;
                od1Var.H = od1Var2.H;
                od1Var.I = od1Var2.I;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, od1 od1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65536, null, jSONObject, od1Var) == null) || jSONObject == null) {
                return;
            }
            try {
                od1Var.g = jSONObject.optString("url");
                od1Var.h = jSONObject.optInt("width");
                od1Var.i = jSONObject.optInt("height");
                od1Var.j = jSONObject.optString("imageMd5");
            } catch (Exception unused) {
            }
        }

        public static void b(JSONObject jSONObject, od1 od1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, od1Var) == null) {
                try {
                    jSONObject.put("url", od1Var.g);
                    jSONObject.put("imageMd5", od1Var.j);
                    jSONObject.put("width", od1Var.h);
                    jSONObject.put("height", od1Var.i);
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

        public static void a(JSONObject jSONObject, od1 od1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65536, null, jSONObject, od1Var) == null) || jSONObject == null) {
                return;
            }
            try {
                od1Var.g = jSONObject.optString("url");
                od1Var.h = jSONObject.optInt("width");
                od1Var.i = jSONObject.optInt("height");
                od1Var.j = jSONObject.optString(PackageTable.MD5);
            } catch (Exception unused) {
            }
        }

        public static void b(JSONObject jSONObject, od1 od1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, od1Var) == null) {
                try {
                    jSONObject.put("url", od1Var.g);
                    jSONObject.put(PackageTable.MD5, od1Var.j);
                    jSONObject.put("width", od1Var.h);
                    jSONObject.put("height", od1Var.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public od1() {
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

    public static boolean a(od1 od1Var) {
        InterceptResult invokeL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, od1Var)) == null) {
            if (TextUtils.isEmpty(od1Var.d)) {
                str = "7";
                z = false;
            } else {
                str = "";
                z = true;
            }
            if (z && TextUtils.isEmpty(od1Var.g)) {
                str = "66";
                z = false;
            }
            if (z && System.currentTimeMillis() / 1000 > od1Var.t) {
                str = "68";
                z = false;
            }
            if (z) {
                return true;
            }
            new BaseVM(od1Var).g(str);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static od1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            od1 od1Var = new od1();
            try {
                a.a(jSONObject, od1Var);
            } catch (Exception unused) {
            }
            return od1Var;
        }
        return (od1) invokeL.objValue;
    }

    public static od1 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            try {
                od1 od1Var = new od1();
                a.b(jSONObject, od1Var);
                return od1Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (od1) invokeL.objValue;
    }

    public static List<od1> j(JSONArray jSONArray) {
        InterceptResult invokeL;
        od1 c2;
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

    public static void l(od1 od1Var, od1 od1Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, od1Var, od1Var2) == null) {
            a.d(od1Var, od1Var2);
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
