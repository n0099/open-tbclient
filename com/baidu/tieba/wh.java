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
public class wh {
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

    public static String c(eh ehVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ehVar)) == null) {
            if (ehVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("product");
                sb.append("=");
                sb.append(URLEncoder.encode(ehVar.a, "utf-8"));
                sb.append("&");
                sb.append("sub_sys");
                sb.append("=");
                sb.append(URLEncoder.encode(ehVar.b, "utf-8"));
                sb.append("&");
                sb.append("version");
                sb.append("=");
                sb.append(URLEncoder.encode(ehVar.c, "utf-8"));
                sb.append("&");
                sb.append("os");
                sb.append("=");
                sb.append("android");
                sb.append("&");
                sb.append(HttpConstants.OS_VERSION);
                sb.append("=");
                sb.append(URLEncoder.encode(ehVar.q, "utf-8"));
                if (!TextUtils.isEmpty(ehVar.d)) {
                    sb.append("&");
                    sb.append("from");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ehVar.d, "utf-8"));
                }
                if (!TextUtils.isEmpty(ehVar.e)) {
                    sb.append("&");
                    sb.append("cfrom");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ehVar.e, "utf-8"));
                }
                sb.append("&");
                sb.append("phone");
                sb.append("=");
                sb.append(URLEncoder.encode(ehVar.k, "utf-8"));
                if (!TextUtils.isEmpty(ehVar.l)) {
                    sb.append("&");
                    sb.append("uid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ehVar.l, "utf-8"));
                }
                if (!TextUtils.isEmpty(ehVar.f)) {
                    sb.append("&");
                    sb.append("client_id");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ehVar.f, "utf-8"));
                }
                if (!TextUtils.isEmpty(ehVar.i)) {
                    sb.append("&");
                    sb.append("imei");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ehVar.i, "utf-8"));
                }
                if (!TextUtils.isEmpty(ehVar.m)) {
                    sb.append("&");
                    sb.append("uname");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ehVar.m, "utf-8"));
                }
                if (!TextUtils.isEmpty(ehVar.g)) {
                    sb.append("&");
                    sb.append("cuid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ehVar.g, "utf-8"));
                }
                if (!TextUtils.isEmpty(ehVar.h)) {
                    sb.append("&");
                    sb.append("cuid_galaxy2");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ehVar.h, "utf-8"));
                }
                sb.append("&");
                sb.append("net");
                sb.append("=");
                sb.append(URLEncoder.encode(ehVar.o, "utf-8"));
            } catch (UnsupportedEncodingException e) {
                BdLog.e(e);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(boolean z, eh ehVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65539, null, z, ehVar)) == null) {
            if (ehVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("_client_type=2");
            b(sb, "_client_version", ehVar.c, z);
            b(sb, HttpRequest.PHONE_IMEI, ehVar.i, z);
            b(sb, HttpRequest.CLIENT_ID, ehVar.f, z);
            b(sb, HttpRequest.SUBAPP_TYPE, ehVar.j, z);
            b(sb, HttpConstants.OS_VERSION, ehVar.q, z);
            b(sb, "from", ehVar.d, z);
            b(sb, "cfrom", ehVar.e, z);
            b(sb, "net_type", ehVar.p, z);
            b(sb, "cuid", ehVar.g, z);
            b(sb, "model", ehVar.k, z);
            if (TextUtils.isEmpty(ehVar.l)) {
                b(sb, "uid", "0", z);
            } else {
                b(sb, "uid", ehVar.l, z);
            }
            b(sb, "un", ehVar.m, z);
            b(sb, "utbrand", ehVar.w, z);
            b(sb, "cuid_galaxy2", ehVar.h, z);
            return sb.toString();
        }
        return (String) invokeZL.objValue;
    }

    public static String e(kh khVar, eh ehVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, khVar, ehVar)) == null) {
            if (khVar.p() != null && (khVar.p().equals("omp") || khVar.p().equals("mon"))) {
                return c(ehVar);
            }
            return d(true, ehVar);
        }
        return (String) invokeLL.objValue;
    }

    public static HashMap<String, Object> f(String str, eh ehVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, ehVar, z)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            a(hashMap, HttpRequest.CLIENT_TYPE, "2");
            a(hashMap, "_client_version", ehVar.c);
            a(hashMap, HttpRequest.CLIENT_ID, ehVar.f);
            a(hashMap, HttpRequest.SUBAPP_TYPE, ehVar.j);
            a(hashMap, "from", ehVar.d);
            a(hashMap, "net_type", ehVar.p);
            a(hashMap, "cuid", ehVar.g);
            a(hashMap, "cuid_galaxy2", ehVar.h);
            if (TextUtils.isEmpty(ehVar.l)) {
                ehVar.l = "0";
            }
            a(hashMap, "uid", ehVar.l);
            a(hashMap, "un", ehVar.m);
            a(hashMap, HttpRequest.BDUSS, ehVar.n);
            if (z) {
                a(hashMap, "find_bug", "2");
            } else {
                a(hashMap, "find_bug", "0");
            }
            a(hashMap, "sz", ehVar.r);
            a(hashMap, BaiduIdentityManager.PARAM_CUA, ehVar.s);
            a(hashMap, TiebaStatic.Params.BDID, ehVar.z);
            a(hashMap, "cookie", ehVar.n);
            a(hashMap, "utbrand", ehVar.w);
            a(hashMap, "baiduapppb_ut", ehVar.x);
            a(hashMap, HttpRequest.USER_AGENT, ehVar.y);
            a(hashMap, "active_timestamp", ehVar.A);
            a(hashMap, "first_install_time", ehVar.B);
            a(hashMap, TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, ehVar.C);
            a(hashMap, "event_day", ehVar.D);
            if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, "isKeepOriginalLogic").getData()).booleanValue()) {
                a(hashMap, "model", ehVar.k);
                a(hashMap, "oaid", ehVar.t);
                if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, str).getData()).booleanValue()) {
                    a(hashMap, "isKeepOriginalLogic", YYOption.IsLive.VALUE_TRUE);
                    MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
                } else {
                    a(hashMap, HttpRequest.ANDROID_ID, ehVar.v);
                    a(hashMap, HttpRequest.PHONE_IMEI, ehVar.i);
                }
            } else {
                MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
            }
            if (((Boolean) MessageManager.getInstance().runTask(2000983, Boolean.class, "isKeepOriginalLogic").getData()).booleanValue()) {
                if (((Boolean) MessageManager.getInstance().runTask(2000983, Boolean.class, str).getData()).booleanValue()) {
                    a(hashMap, "isKeepOriginalLogic", YYOption.IsLive.VALUE_TRUE);
                    MessageManager.getInstance().runTask(2000982, HashMap.class, hashMap);
                } else {
                    a(hashMap, "mac", ehVar.u);
                }
            } else {
                MessageManager.getInstance().runTask(2000982, HashMap.class, hashMap);
            }
            return hashMap;
        }
        return (HashMap) invokeLLZ.objValue;
    }
}
