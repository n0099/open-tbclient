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
public class sc {
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

    public static String c(bc bcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bcVar)) == null) {
            if (bcVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("product");
                sb.append("=");
                sb.append(URLEncoder.encode(bcVar.a, "utf-8"));
                sb.append("&");
                sb.append("sub_sys");
                sb.append("=");
                sb.append(URLEncoder.encode(bcVar.b, "utf-8"));
                sb.append("&");
                sb.append("version");
                sb.append("=");
                sb.append(URLEncoder.encode(bcVar.c, "utf-8"));
                sb.append("&");
                sb.append("os");
                sb.append("=");
                sb.append("android");
                sb.append("&");
                sb.append(HttpConstants.OS_VERSION);
                sb.append("=");
                sb.append(URLEncoder.encode(bcVar.q, "utf-8"));
                if (!TextUtils.isEmpty(bcVar.d)) {
                    sb.append("&");
                    sb.append("from");
                    sb.append("=");
                    sb.append(URLEncoder.encode(bcVar.d, "utf-8"));
                }
                if (!TextUtils.isEmpty(bcVar.e)) {
                    sb.append("&");
                    sb.append("cfrom");
                    sb.append("=");
                    sb.append(URLEncoder.encode(bcVar.e, "utf-8"));
                }
                sb.append("&");
                sb.append("phone");
                sb.append("=");
                sb.append(URLEncoder.encode(bcVar.k, "utf-8"));
                if (!TextUtils.isEmpty(bcVar.l)) {
                    sb.append("&");
                    sb.append("uid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(bcVar.l, "utf-8"));
                }
                if (!TextUtils.isEmpty(bcVar.f)) {
                    sb.append("&");
                    sb.append("client_id");
                    sb.append("=");
                    sb.append(URLEncoder.encode(bcVar.f, "utf-8"));
                }
                if (!TextUtils.isEmpty(bcVar.i)) {
                    sb.append("&");
                    sb.append("imei");
                    sb.append("=");
                    sb.append(URLEncoder.encode(bcVar.i, "utf-8"));
                }
                if (!TextUtils.isEmpty(bcVar.m)) {
                    sb.append("&");
                    sb.append("uname");
                    sb.append("=");
                    sb.append(URLEncoder.encode(bcVar.m, "utf-8"));
                }
                if (!TextUtils.isEmpty(bcVar.g)) {
                    sb.append("&");
                    sb.append("cuid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(bcVar.g, "utf-8"));
                }
                if (!TextUtils.isEmpty(bcVar.h)) {
                    sb.append("&");
                    sb.append("cuid_galaxy2");
                    sb.append("=");
                    sb.append(URLEncoder.encode(bcVar.h, "utf-8"));
                }
                sb.append("&");
                sb.append("net");
                sb.append("=");
                sb.append(URLEncoder.encode(bcVar.o, "utf-8"));
            } catch (UnsupportedEncodingException e) {
                BdLog.e(e);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(boolean z, bc bcVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65539, null, z, bcVar)) == null) {
            if (bcVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("_client_type=2");
            b(sb, "_client_version", bcVar.c, z);
            b(sb, HttpRequest.PHONE_IMEI, bcVar.i, z);
            b(sb, HttpRequest.CLIENT_ID, bcVar.f, z);
            b(sb, HttpRequest.SUBAPP_TYPE, bcVar.j, z);
            b(sb, HttpConstants.OS_VERSION, bcVar.q, z);
            b(sb, "from", bcVar.d, z);
            b(sb, "cfrom", bcVar.e, z);
            b(sb, "net_type", bcVar.p, z);
            b(sb, "cuid", bcVar.g, z);
            b(sb, "model", bcVar.k, z);
            if (TextUtils.isEmpty(bcVar.l)) {
                b(sb, "uid", "0", z);
            } else {
                b(sb, "uid", bcVar.l, z);
            }
            b(sb, "un", bcVar.m, z);
            b(sb, "utbrand", bcVar.w, z);
            b(sb, "cuid_galaxy2", bcVar.h, z);
            return sb.toString();
        }
        return (String) invokeZL.objValue;
    }

    public static String e(hc hcVar, bc bcVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, hcVar, bcVar)) == null) {
            if (hcVar.p() != null && (hcVar.p().equals("omp") || hcVar.p().equals("mon"))) {
                return c(bcVar);
            }
            return d(true, bcVar);
        }
        return (String) invokeLL.objValue;
    }

    public static HashMap<String, Object> f(String str, bc bcVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, bcVar, z)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            a(hashMap, HttpRequest.CLIENT_TYPE, "2");
            a(hashMap, "_client_version", bcVar.c);
            a(hashMap, HttpRequest.CLIENT_ID, bcVar.f);
            a(hashMap, HttpRequest.SUBAPP_TYPE, bcVar.j);
            a(hashMap, "from", bcVar.d);
            a(hashMap, "net_type", bcVar.p);
            a(hashMap, "cuid", bcVar.g);
            a(hashMap, "cuid_galaxy2", bcVar.h);
            if (TextUtils.isEmpty(bcVar.l)) {
                bcVar.l = "0";
            }
            a(hashMap, "uid", bcVar.l);
            a(hashMap, "un", bcVar.m);
            a(hashMap, HttpRequest.BDUSS, bcVar.n);
            if (z) {
                a(hashMap, "find_bug", "2");
            } else {
                a(hashMap, "find_bug", "0");
            }
            a(hashMap, "sz", bcVar.r);
            a(hashMap, BaiduIdentityManager.PARAM_CUA, bcVar.s);
            a(hashMap, TiebaStatic.Params.BDID, bcVar.z);
            a(hashMap, "cookie", bcVar.n);
            a(hashMap, "utbrand", bcVar.w);
            a(hashMap, "baiduapppb_ut", bcVar.x);
            a(hashMap, "user_agent", bcVar.y);
            a(hashMap, "active_timestamp", bcVar.A);
            a(hashMap, "first_install_time", bcVar.B);
            a(hashMap, TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, bcVar.C);
            a(hashMap, "event_day", bcVar.D);
            if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, "isKeepOriginalLogic").getData()).booleanValue()) {
                a(hashMap, "model", bcVar.k);
                a(hashMap, "oaid", bcVar.t);
                if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, str).getData()).booleanValue()) {
                    a(hashMap, "isKeepOriginalLogic", YYOption.IsLive.VALUE_TRUE);
                    MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
                } else {
                    a(hashMap, HttpRequest.ANDROID_ID, bcVar.v);
                    a(hashMap, HttpRequest.PHONE_IMEI, bcVar.i);
                }
            } else {
                MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
            }
            if (((Boolean) MessageManager.getInstance().runTask(2000983, Boolean.class, "isKeepOriginalLogic").getData()).booleanValue()) {
                if (((Boolean) MessageManager.getInstance().runTask(2000983, Boolean.class, str).getData()).booleanValue()) {
                    a(hashMap, "isKeepOriginalLogic", YYOption.IsLive.VALUE_TRUE);
                    MessageManager.getInstance().runTask(2000982, HashMap.class, hashMap);
                } else {
                    a(hashMap, "mac", bcVar.u);
                }
            } else {
                MessageManager.getInstance().runTask(2000982, HashMap.class, hashMap);
            }
            return hashMap;
        }
        return (HashMap) invokeLLZ.objValue;
    }
}
