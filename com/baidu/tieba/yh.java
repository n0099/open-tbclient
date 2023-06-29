package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class yh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(HashMap<String, Object> hashMap, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65536, null, hashMap, str, str2) == null) && hashMap != null && str != null && str2 != null) {
            hashMap.put(str, str2);
        }
    }

    public static void b(StringBuilder sb, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{sb, str, str2, Boolean.valueOf(z)}) == null) && sb != null && !TextUtils.isEmpty(str)) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                sb.append("&");
                sb.append(str);
                sb.append("=");
                if (z) {
                    str2 = URLEncoder.encode(str2, "utf-8");
                }
                sb.append(str2);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public static String c(gh ghVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ghVar)) == null) {
            if (ghVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("product");
                sb.append("=");
                sb.append(URLEncoder.encode(ghVar.a, "utf-8"));
                sb.append("&");
                sb.append("sub_sys");
                sb.append("=");
                sb.append(URLEncoder.encode(ghVar.b, "utf-8"));
                sb.append("&");
                sb.append("version");
                sb.append("=");
                sb.append(URLEncoder.encode(ghVar.c, "utf-8"));
                sb.append("&");
                sb.append("os");
                sb.append("=");
                sb.append("android");
                sb.append("&");
                sb.append(HttpConstants.OS_VERSION);
                sb.append("=");
                sb.append(URLEncoder.encode(ghVar.q, "utf-8"));
                if (!TextUtils.isEmpty(ghVar.d)) {
                    sb.append("&");
                    sb.append("from");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ghVar.d, "utf-8"));
                }
                if (!TextUtils.isEmpty(ghVar.e)) {
                    sb.append("&");
                    sb.append("cfrom");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ghVar.e, "utf-8"));
                }
                sb.append("&");
                sb.append("phone");
                sb.append("=");
                sb.append(URLEncoder.encode(ghVar.k, "utf-8"));
                if (!TextUtils.isEmpty(ghVar.l)) {
                    sb.append("&");
                    sb.append("uid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ghVar.l, "utf-8"));
                }
                if (!TextUtils.isEmpty(ghVar.f)) {
                    sb.append("&");
                    sb.append("client_id");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ghVar.f, "utf-8"));
                }
                if (!TextUtils.isEmpty(ghVar.i)) {
                    sb.append("&");
                    sb.append("imei");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ghVar.i, "utf-8"));
                }
                if (!TextUtils.isEmpty(ghVar.m)) {
                    sb.append("&");
                    sb.append("uname");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ghVar.m, "utf-8"));
                }
                if (!TextUtils.isEmpty(ghVar.g)) {
                    sb.append("&");
                    sb.append("cuid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ghVar.g, "utf-8"));
                }
                if (!TextUtils.isEmpty(ghVar.h)) {
                    sb.append("&");
                    sb.append("cuid_galaxy2");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ghVar.h, "utf-8"));
                }
                sb.append("&");
                sb.append("net");
                sb.append("=");
                sb.append(URLEncoder.encode(ghVar.o, "utf-8"));
            } catch (UnsupportedEncodingException e) {
                BdLog.e(e);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(boolean z, gh ghVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65539, null, z, ghVar)) == null) {
            if (ghVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("_client_type=2");
            b(sb, "_client_version", ghVar.c, z);
            b(sb, HttpRequest.PHONE_IMEI, ghVar.i, z);
            b(sb, HttpRequest.CLIENT_ID, ghVar.f, z);
            b(sb, HttpRequest.SUBAPP_TYPE, ghVar.j, z);
            b(sb, HttpConstants.OS_VERSION, ghVar.q, z);
            b(sb, "from", ghVar.d, z);
            b(sb, "cfrom", ghVar.e, z);
            b(sb, "net_type", ghVar.p, z);
            b(sb, "cuid", ghVar.g, z);
            b(sb, "model", ghVar.k, z);
            if (TextUtils.isEmpty(ghVar.l)) {
                b(sb, "uid", "0", z);
            } else {
                b(sb, "uid", ghVar.l, z);
            }
            b(sb, "un", ghVar.m, z);
            b(sb, "utbrand", ghVar.w, z);
            b(sb, "cuid_galaxy2", ghVar.h, z);
            return sb.toString();
        }
        return (String) invokeZL.objValue;
    }

    public static String e(mh mhVar, gh ghVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, mhVar, ghVar)) == null) {
            if (mhVar.p() != null && (mhVar.p().equals("omp") || mhVar.p().equals("mon"))) {
                return c(ghVar);
            }
            return d(true, ghVar);
        }
        return (String) invokeLL.objValue;
    }

    public static HashMap<String, Object> f(String str, gh ghVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, ghVar, z)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            a(hashMap, HttpRequest.CLIENT_TYPE, "2");
            a(hashMap, "_client_version", ghVar.c);
            a(hashMap, HttpRequest.CLIENT_ID, ghVar.f);
            a(hashMap, HttpRequest.SUBAPP_TYPE, ghVar.j);
            a(hashMap, "from", ghVar.d);
            a(hashMap, "net_type", ghVar.p);
            a(hashMap, "cuid", ghVar.g);
            a(hashMap, "cuid_galaxy2", ghVar.h);
            if (TextUtils.isEmpty(ghVar.l)) {
                ghVar.l = "0";
            }
            a(hashMap, "uid", ghVar.l);
            a(hashMap, "un", ghVar.m);
            a(hashMap, HttpRequest.BDUSS, ghVar.n);
            if (z) {
                a(hashMap, "find_bug", "2");
            } else {
                a(hashMap, "find_bug", "0");
            }
            a(hashMap, "sz", ghVar.r);
            a(hashMap, BaiduIdentityManager.PARAM_CUA, ghVar.s);
            a(hashMap, TiebaStatic.Params.BDID, ghVar.z);
            a(hashMap, "cookie", ghVar.n);
            a(hashMap, "utbrand", ghVar.w);
            a(hashMap, "baiduapppb_ut", ghVar.x);
            a(hashMap, HttpRequest.USER_AGENT, ghVar.y);
            a(hashMap, "active_timestamp", ghVar.A);
            a(hashMap, "first_install_time", ghVar.B);
            a(hashMap, TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, ghVar.C);
            a(hashMap, "event_day", ghVar.D);
            if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, "isKeepOriginalLogic").getData()).booleanValue()) {
                a(hashMap, "model", ghVar.k);
                a(hashMap, "oaid", ghVar.t);
                if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, str).getData()).booleanValue()) {
                    a(hashMap, "isKeepOriginalLogic", YYOption.IsLive.VALUE_TRUE);
                    MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
                } else {
                    a(hashMap, HttpRequest.ANDROID_ID, ghVar.v);
                    a(hashMap, HttpRequest.PHONE_IMEI, ghVar.i);
                }
            } else {
                MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
            }
            if (((Boolean) MessageManager.getInstance().runTask(2000983, Boolean.class, "isKeepOriginalLogic").getData()).booleanValue()) {
                if (((Boolean) MessageManager.getInstance().runTask(2000983, Boolean.class, str).getData()).booleanValue()) {
                    a(hashMap, "isKeepOriginalLogic", YYOption.IsLive.VALUE_TRUE);
                    MessageManager.getInstance().runTask(2000982, HashMap.class, hashMap);
                } else {
                    a(hashMap, "mac", ghVar.u);
                }
            } else {
                MessageManager.getInstance().runTask(2000982, HashMap.class, hashMap);
            }
            return hashMap;
        }
        return (HashMap) invokeLLZ.objValue;
    }
}
