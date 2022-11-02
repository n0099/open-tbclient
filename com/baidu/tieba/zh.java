package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class zh {
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
                    str2 = URLEncoder.encode(str2, IMAudioTransRequest.CHARSET);
                }
                sb.append(str2);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public static String c(hh hhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hhVar)) == null) {
            if (hhVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("product");
                sb.append("=");
                sb.append(URLEncoder.encode(hhVar.a, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("sub_sys");
                sb.append("=");
                sb.append(URLEncoder.encode(hhVar.b, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("version");
                sb.append("=");
                sb.append(URLEncoder.encode(hhVar.c, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("os");
                sb.append("=");
                sb.append("android");
                sb.append("&");
                sb.append(HttpConstants.OS_VERSION);
                sb.append("=");
                sb.append(URLEncoder.encode(hhVar.q, IMAudioTransRequest.CHARSET));
                if (!TextUtils.isEmpty(hhVar.d)) {
                    sb.append("&");
                    sb.append("from");
                    sb.append("=");
                    sb.append(URLEncoder.encode(hhVar.d, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(hhVar.e)) {
                    sb.append("&");
                    sb.append("cfrom");
                    sb.append("=");
                    sb.append(URLEncoder.encode(hhVar.e, IMAudioTransRequest.CHARSET));
                }
                sb.append("&");
                sb.append("phone");
                sb.append("=");
                sb.append(URLEncoder.encode(hhVar.k, IMAudioTransRequest.CHARSET));
                if (!TextUtils.isEmpty(hhVar.l)) {
                    sb.append("&");
                    sb.append("uid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(hhVar.l, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(hhVar.f)) {
                    sb.append("&");
                    sb.append("client_id");
                    sb.append("=");
                    sb.append(URLEncoder.encode(hhVar.f, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(hhVar.i)) {
                    sb.append("&");
                    sb.append("imei");
                    sb.append("=");
                    sb.append(URLEncoder.encode(hhVar.i, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(hhVar.m)) {
                    sb.append("&");
                    sb.append("uname");
                    sb.append("=");
                    sb.append(URLEncoder.encode(hhVar.m, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(hhVar.g)) {
                    sb.append("&");
                    sb.append("cuid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(hhVar.g, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(hhVar.h)) {
                    sb.append("&");
                    sb.append("cuid_galaxy2");
                    sb.append("=");
                    sb.append(URLEncoder.encode(hhVar.h, IMAudioTransRequest.CHARSET));
                }
                sb.append("&");
                sb.append("net");
                sb.append("=");
                sb.append(URLEncoder.encode(hhVar.o, IMAudioTransRequest.CHARSET));
            } catch (UnsupportedEncodingException e) {
                BdLog.e(e);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(boolean z, hh hhVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65539, null, z, hhVar)) == null) {
            if (hhVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("_client_type=2");
            b(sb, "_client_version", hhVar.c, z);
            b(sb, HttpRequest.PHONE_IMEI, hhVar.i, z);
            b(sb, HttpRequest.CLIENT_ID, hhVar.f, z);
            b(sb, HttpRequest.SUBAPP_TYPE, hhVar.j, z);
            b(sb, HttpConstants.OS_VERSION, hhVar.q, z);
            b(sb, "from", hhVar.d, z);
            b(sb, "cfrom", hhVar.e, z);
            b(sb, "net_type", hhVar.p, z);
            b(sb, "cuid", hhVar.g, z);
            b(sb, "model", hhVar.k, z);
            if (TextUtils.isEmpty(hhVar.l)) {
                b(sb, "uid", "0", z);
            } else {
                b(sb, "uid", hhVar.l, z);
            }
            b(sb, "un", hhVar.m, z);
            b(sb, "utbrand", hhVar.w, z);
            b(sb, "cuid_galaxy2", hhVar.h, z);
            return sb.toString();
        }
        return (String) invokeZL.objValue;
    }

    public static String e(nh nhVar, hh hhVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, nhVar, hhVar)) == null) {
            if (nhVar.p() != null && (nhVar.p().equals("omp") || nhVar.p().equals("mon"))) {
                return c(hhVar);
            }
            return d(true, hhVar);
        }
        return (String) invokeLL.objValue;
    }

    public static HashMap<String, Object> f(String str, hh hhVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, hhVar, z)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            a(hashMap, HttpRequest.CLIENT_TYPE, "2");
            a(hashMap, "_client_version", hhVar.c);
            a(hashMap, HttpRequest.CLIENT_ID, hhVar.f);
            a(hashMap, HttpRequest.SUBAPP_TYPE, hhVar.j);
            a(hashMap, "from", hhVar.d);
            a(hashMap, "net_type", hhVar.p);
            a(hashMap, "cuid", hhVar.g);
            a(hashMap, "cuid_galaxy2", hhVar.h);
            a(hashMap, "model", hhVar.k);
            if (TextUtils.isEmpty(hhVar.l)) {
                hhVar.l = "0";
            }
            a(hashMap, "uid", hhVar.l);
            a(hashMap, "un", hhVar.m);
            a(hashMap, HttpRequest.BDUSS, hhVar.n);
            if (z) {
                a(hashMap, "find_bug", "2");
            } else {
                a(hashMap, "find_bug", "0");
            }
            a(hashMap, "sz", hhVar.r);
            a(hashMap, BaiduIdentityManager.PARAM_CUA, hhVar.s);
            a(hashMap, TiebaStatic.Params.BDID, hhVar.z);
            a(hashMap, "cookie", hhVar.n);
            a(hashMap, "oaid", hhVar.t);
            a(hashMap, "utbrand", hhVar.w);
            a(hashMap, "baiduapppb_ut", hhVar.x);
            a(hashMap, HttpRequest.USER_AGENT, hhVar.y);
            a(hashMap, "active_timestamp", hhVar.A);
            a(hashMap, "first_install_time", hhVar.B);
            a(hashMap, TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, hhVar.C);
            a(hashMap, "event_day", hhVar.D);
            if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, str).getData()).booleanValue()) {
                MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
            } else {
                a(hashMap, "mac", hhVar.u);
                a(hashMap, HttpRequest.ANDROID_ID, hhVar.v);
                a(hashMap, HttpRequest.PHONE_IMEI, hhVar.i);
            }
            return hashMap;
        }
        return (HashMap) invokeLLZ.objValue;
    }
}
