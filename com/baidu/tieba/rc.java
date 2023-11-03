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
public class rc {
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

    public static String c(ac acVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, acVar)) == null) {
            if (acVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("product");
                sb.append("=");
                sb.append(URLEncoder.encode(acVar.a, "utf-8"));
                sb.append("&");
                sb.append("sub_sys");
                sb.append("=");
                sb.append(URLEncoder.encode(acVar.b, "utf-8"));
                sb.append("&");
                sb.append("version");
                sb.append("=");
                sb.append(URLEncoder.encode(acVar.c, "utf-8"));
                sb.append("&");
                sb.append("os");
                sb.append("=");
                sb.append("android");
                sb.append("&");
                sb.append(HttpConstants.OS_VERSION);
                sb.append("=");
                sb.append(URLEncoder.encode(acVar.q, "utf-8"));
                if (!TextUtils.isEmpty(acVar.d)) {
                    sb.append("&");
                    sb.append("from");
                    sb.append("=");
                    sb.append(URLEncoder.encode(acVar.d, "utf-8"));
                }
                if (!TextUtils.isEmpty(acVar.e)) {
                    sb.append("&");
                    sb.append("cfrom");
                    sb.append("=");
                    sb.append(URLEncoder.encode(acVar.e, "utf-8"));
                }
                sb.append("&");
                sb.append("phone");
                sb.append("=");
                sb.append(URLEncoder.encode(acVar.k, "utf-8"));
                if (!TextUtils.isEmpty(acVar.l)) {
                    sb.append("&");
                    sb.append("uid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(acVar.l, "utf-8"));
                }
                if (!TextUtils.isEmpty(acVar.f)) {
                    sb.append("&");
                    sb.append("client_id");
                    sb.append("=");
                    sb.append(URLEncoder.encode(acVar.f, "utf-8"));
                }
                if (!TextUtils.isEmpty(acVar.i)) {
                    sb.append("&");
                    sb.append("imei");
                    sb.append("=");
                    sb.append(URLEncoder.encode(acVar.i, "utf-8"));
                }
                if (!TextUtils.isEmpty(acVar.m)) {
                    sb.append("&");
                    sb.append("uname");
                    sb.append("=");
                    sb.append(URLEncoder.encode(acVar.m, "utf-8"));
                }
                if (!TextUtils.isEmpty(acVar.g)) {
                    sb.append("&");
                    sb.append("cuid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(acVar.g, "utf-8"));
                }
                if (!TextUtils.isEmpty(acVar.h)) {
                    sb.append("&");
                    sb.append("cuid_galaxy2");
                    sb.append("=");
                    sb.append(URLEncoder.encode(acVar.h, "utf-8"));
                }
                sb.append("&");
                sb.append("net");
                sb.append("=");
                sb.append(URLEncoder.encode(acVar.o, "utf-8"));
            } catch (UnsupportedEncodingException e) {
                BdLog.e(e);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(boolean z, ac acVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65539, null, z, acVar)) == null) {
            if (acVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("_client_type=2");
            b(sb, "_client_version", acVar.c, z);
            b(sb, HttpRequest.PHONE_IMEI, acVar.i, z);
            b(sb, HttpRequest.CLIENT_ID, acVar.f, z);
            b(sb, HttpRequest.SUBAPP_TYPE, acVar.j, z);
            b(sb, HttpConstants.OS_VERSION, acVar.q, z);
            b(sb, "from", acVar.d, z);
            b(sb, "cfrom", acVar.e, z);
            b(sb, "net_type", acVar.p, z);
            b(sb, "cuid", acVar.g, z);
            b(sb, "model", acVar.k, z);
            if (TextUtils.isEmpty(acVar.l)) {
                b(sb, "uid", "0", z);
            } else {
                b(sb, "uid", acVar.l, z);
            }
            b(sb, "un", acVar.m, z);
            b(sb, "utbrand", acVar.w, z);
            b(sb, "cuid_galaxy2", acVar.h, z);
            return sb.toString();
        }
        return (String) invokeZL.objValue;
    }

    public static String e(gc gcVar, ac acVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, gcVar, acVar)) == null) {
            if (gcVar.p() != null && (gcVar.p().equals("omp") || gcVar.p().equals("mon"))) {
                return c(acVar);
            }
            return d(true, acVar);
        }
        return (String) invokeLL.objValue;
    }

    public static HashMap<String, Object> f(String str, ac acVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, acVar, z)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            a(hashMap, HttpRequest.CLIENT_TYPE, "2");
            a(hashMap, "_client_version", acVar.c);
            a(hashMap, HttpRequest.CLIENT_ID, acVar.f);
            a(hashMap, HttpRequest.SUBAPP_TYPE, acVar.j);
            a(hashMap, "from", acVar.d);
            a(hashMap, "net_type", acVar.p);
            a(hashMap, "cuid", acVar.g);
            a(hashMap, "cuid_galaxy2", acVar.h);
            if (TextUtils.isEmpty(acVar.l)) {
                acVar.l = "0";
            }
            a(hashMap, "uid", acVar.l);
            a(hashMap, "un", acVar.m);
            a(hashMap, HttpRequest.BDUSS, acVar.n);
            if (z) {
                a(hashMap, "find_bug", "2");
            } else {
                a(hashMap, "find_bug", "0");
            }
            a(hashMap, "sz", acVar.r);
            a(hashMap, BaiduIdentityManager.PARAM_CUA, acVar.s);
            a(hashMap, TiebaStatic.Params.BDID, acVar.z);
            a(hashMap, "cookie", acVar.n);
            a(hashMap, "utbrand", acVar.w);
            a(hashMap, "baiduapppb_ut", acVar.x);
            a(hashMap, "user_agent", acVar.y);
            a(hashMap, "active_timestamp", acVar.A);
            a(hashMap, "first_install_time", acVar.B);
            a(hashMap, TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, acVar.C);
            a(hashMap, "event_day", acVar.D);
            if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, "isKeepOriginalLogic").getData()).booleanValue()) {
                a(hashMap, "model", acVar.k);
                a(hashMap, "oaid", acVar.t);
                if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, str).getData()).booleanValue()) {
                    a(hashMap, "isKeepOriginalLogic", YYOption.IsLive.VALUE_TRUE);
                    MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
                } else {
                    a(hashMap, HttpRequest.ANDROID_ID, acVar.v);
                    a(hashMap, HttpRequest.PHONE_IMEI, acVar.i);
                }
            } else {
                MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
            }
            if (((Boolean) MessageManager.getInstance().runTask(2000983, Boolean.class, "isKeepOriginalLogic").getData()).booleanValue()) {
                if (((Boolean) MessageManager.getInstance().runTask(2000983, Boolean.class, str).getData()).booleanValue()) {
                    a(hashMap, "isKeepOriginalLogic", YYOption.IsLive.VALUE_TRUE);
                    MessageManager.getInstance().runTask(2000982, HashMap.class, hashMap);
                } else {
                    a(hashMap, "mac", acVar.u);
                }
            } else {
                MessageManager.getInstance().runTask(2000982, HashMap.class, hashMap);
            }
            return hashMap;
        }
        return (HashMap) invokeLLZ.objValue;
    }
}
