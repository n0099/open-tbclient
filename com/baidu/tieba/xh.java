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
public class xh {
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

    public static String c(fh fhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, fhVar)) == null) {
            if (fhVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("product");
                sb.append("=");
                sb.append(URLEncoder.encode(fhVar.a, "utf-8"));
                sb.append("&");
                sb.append("sub_sys");
                sb.append("=");
                sb.append(URLEncoder.encode(fhVar.b, "utf-8"));
                sb.append("&");
                sb.append("version");
                sb.append("=");
                sb.append(URLEncoder.encode(fhVar.c, "utf-8"));
                sb.append("&");
                sb.append("os");
                sb.append("=");
                sb.append("android");
                sb.append("&");
                sb.append(HttpConstants.OS_VERSION);
                sb.append("=");
                sb.append(URLEncoder.encode(fhVar.q, "utf-8"));
                if (!TextUtils.isEmpty(fhVar.d)) {
                    sb.append("&");
                    sb.append("from");
                    sb.append("=");
                    sb.append(URLEncoder.encode(fhVar.d, "utf-8"));
                }
                if (!TextUtils.isEmpty(fhVar.e)) {
                    sb.append("&");
                    sb.append("cfrom");
                    sb.append("=");
                    sb.append(URLEncoder.encode(fhVar.e, "utf-8"));
                }
                sb.append("&");
                sb.append("phone");
                sb.append("=");
                sb.append(URLEncoder.encode(fhVar.k, "utf-8"));
                if (!TextUtils.isEmpty(fhVar.l)) {
                    sb.append("&");
                    sb.append("uid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(fhVar.l, "utf-8"));
                }
                if (!TextUtils.isEmpty(fhVar.f)) {
                    sb.append("&");
                    sb.append("client_id");
                    sb.append("=");
                    sb.append(URLEncoder.encode(fhVar.f, "utf-8"));
                }
                if (!TextUtils.isEmpty(fhVar.i)) {
                    sb.append("&");
                    sb.append("imei");
                    sb.append("=");
                    sb.append(URLEncoder.encode(fhVar.i, "utf-8"));
                }
                if (!TextUtils.isEmpty(fhVar.m)) {
                    sb.append("&");
                    sb.append("uname");
                    sb.append("=");
                    sb.append(URLEncoder.encode(fhVar.m, "utf-8"));
                }
                if (!TextUtils.isEmpty(fhVar.g)) {
                    sb.append("&");
                    sb.append("cuid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(fhVar.g, "utf-8"));
                }
                if (!TextUtils.isEmpty(fhVar.h)) {
                    sb.append("&");
                    sb.append("cuid_galaxy2");
                    sb.append("=");
                    sb.append(URLEncoder.encode(fhVar.h, "utf-8"));
                }
                sb.append("&");
                sb.append("net");
                sb.append("=");
                sb.append(URLEncoder.encode(fhVar.o, "utf-8"));
            } catch (UnsupportedEncodingException e) {
                BdLog.e(e);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(boolean z, fh fhVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65539, null, z, fhVar)) == null) {
            if (fhVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("_client_type=2");
            b(sb, "_client_version", fhVar.c, z);
            b(sb, HttpRequest.PHONE_IMEI, fhVar.i, z);
            b(sb, HttpRequest.CLIENT_ID, fhVar.f, z);
            b(sb, HttpRequest.SUBAPP_TYPE, fhVar.j, z);
            b(sb, HttpConstants.OS_VERSION, fhVar.q, z);
            b(sb, "from", fhVar.d, z);
            b(sb, "cfrom", fhVar.e, z);
            b(sb, "net_type", fhVar.p, z);
            b(sb, "cuid", fhVar.g, z);
            b(sb, "model", fhVar.k, z);
            if (TextUtils.isEmpty(fhVar.l)) {
                b(sb, "uid", "0", z);
            } else {
                b(sb, "uid", fhVar.l, z);
            }
            b(sb, "un", fhVar.m, z);
            b(sb, "utbrand", fhVar.w, z);
            b(sb, "cuid_galaxy2", fhVar.h, z);
            return sb.toString();
        }
        return (String) invokeZL.objValue;
    }

    public static String e(lh lhVar, fh fhVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, lhVar, fhVar)) == null) {
            if (lhVar.p() != null && (lhVar.p().equals("omp") || lhVar.p().equals("mon"))) {
                return c(fhVar);
            }
            return d(true, fhVar);
        }
        return (String) invokeLL.objValue;
    }

    public static HashMap<String, Object> f(String str, fh fhVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, fhVar, z)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            a(hashMap, HttpRequest.CLIENT_TYPE, "2");
            a(hashMap, "_client_version", fhVar.c);
            a(hashMap, HttpRequest.CLIENT_ID, fhVar.f);
            a(hashMap, HttpRequest.SUBAPP_TYPE, fhVar.j);
            a(hashMap, "from", fhVar.d);
            a(hashMap, "net_type", fhVar.p);
            a(hashMap, "cuid", fhVar.g);
            a(hashMap, "cuid_galaxy2", fhVar.h);
            if (TextUtils.isEmpty(fhVar.l)) {
                fhVar.l = "0";
            }
            a(hashMap, "uid", fhVar.l);
            a(hashMap, "un", fhVar.m);
            a(hashMap, HttpRequest.BDUSS, fhVar.n);
            if (z) {
                a(hashMap, "find_bug", "2");
            } else {
                a(hashMap, "find_bug", "0");
            }
            a(hashMap, "sz", fhVar.r);
            a(hashMap, BaiduIdentityManager.PARAM_CUA, fhVar.s);
            a(hashMap, TiebaStatic.Params.BDID, fhVar.z);
            a(hashMap, "cookie", fhVar.n);
            a(hashMap, "utbrand", fhVar.w);
            a(hashMap, "baiduapppb_ut", fhVar.x);
            a(hashMap, HttpRequest.USER_AGENT, fhVar.y);
            a(hashMap, "active_timestamp", fhVar.A);
            a(hashMap, "first_install_time", fhVar.B);
            a(hashMap, TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, fhVar.C);
            a(hashMap, "event_day", fhVar.D);
            if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, "isKeepOriginalLogic").getData()).booleanValue()) {
                a(hashMap, "model", fhVar.k);
                a(hashMap, "oaid", fhVar.t);
                if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, str).getData()).booleanValue()) {
                    a(hashMap, "isKeepOriginalLogic", YYOption.IsLive.VALUE_TRUE);
                    MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
                } else {
                    a(hashMap, HttpRequest.ANDROID_ID, fhVar.v);
                    a(hashMap, HttpRequest.PHONE_IMEI, fhVar.i);
                }
            } else {
                MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
            }
            if (((Boolean) MessageManager.getInstance().runTask(2000983, Boolean.class, "isKeepOriginalLogic").getData()).booleanValue()) {
                if (((Boolean) MessageManager.getInstance().runTask(2000983, Boolean.class, str).getData()).booleanValue()) {
                    a(hashMap, "isKeepOriginalLogic", YYOption.IsLive.VALUE_TRUE);
                    MessageManager.getInstance().runTask(2000982, HashMap.class, hashMap);
                } else {
                    a(hashMap, "mac", fhVar.u);
                }
            } else {
                MessageManager.getInstance().runTask(2000982, HashMap.class, hashMap);
            }
            return hashMap;
        }
        return (HashMap) invokeLLZ.objValue;
    }
}
