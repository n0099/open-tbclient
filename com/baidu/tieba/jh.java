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
/* loaded from: classes5.dex */
public class jh {
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

    public static String c(rg rgVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, rgVar)) == null) {
            if (rgVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("product");
                sb.append("=");
                sb.append(URLEncoder.encode(rgVar.a, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("sub_sys");
                sb.append("=");
                sb.append(URLEncoder.encode(rgVar.b, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("version");
                sb.append("=");
                sb.append(URLEncoder.encode(rgVar.c, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("os");
                sb.append("=");
                sb.append("android");
                sb.append("&");
                sb.append(HttpConstants.OS_VERSION);
                sb.append("=");
                sb.append(URLEncoder.encode(rgVar.q, IMAudioTransRequest.CHARSET));
                if (!TextUtils.isEmpty(rgVar.d)) {
                    sb.append("&");
                    sb.append("from");
                    sb.append("=");
                    sb.append(URLEncoder.encode(rgVar.d, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(rgVar.e)) {
                    sb.append("&");
                    sb.append("cfrom");
                    sb.append("=");
                    sb.append(URLEncoder.encode(rgVar.e, IMAudioTransRequest.CHARSET));
                }
                sb.append("&");
                sb.append("phone");
                sb.append("=");
                sb.append(URLEncoder.encode(rgVar.k, IMAudioTransRequest.CHARSET));
                if (!TextUtils.isEmpty(rgVar.l)) {
                    sb.append("&");
                    sb.append("uid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(rgVar.l, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(rgVar.f)) {
                    sb.append("&");
                    sb.append("client_id");
                    sb.append("=");
                    sb.append(URLEncoder.encode(rgVar.f, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(rgVar.i)) {
                    sb.append("&");
                    sb.append("imei");
                    sb.append("=");
                    sb.append(URLEncoder.encode(rgVar.i, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(rgVar.m)) {
                    sb.append("&");
                    sb.append("uname");
                    sb.append("=");
                    sb.append(URLEncoder.encode(rgVar.m, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(rgVar.g)) {
                    sb.append("&");
                    sb.append("cuid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(rgVar.g, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(rgVar.h)) {
                    sb.append("&");
                    sb.append("cuid_galaxy2");
                    sb.append("=");
                    sb.append(URLEncoder.encode(rgVar.h, IMAudioTransRequest.CHARSET));
                }
                sb.append("&");
                sb.append("net");
                sb.append("=");
                sb.append(URLEncoder.encode(rgVar.o, IMAudioTransRequest.CHARSET));
            } catch (UnsupportedEncodingException e) {
                BdLog.e(e);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(boolean z, rg rgVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65539, null, z, rgVar)) == null) {
            if (rgVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("_client_type=2");
            b(sb, "_client_version", rgVar.c, z);
            b(sb, HttpRequest.PHONE_IMEI, rgVar.i, z);
            b(sb, HttpRequest.CLIENT_ID, rgVar.f, z);
            b(sb, HttpRequest.SUBAPP_TYPE, rgVar.j, z);
            b(sb, HttpConstants.OS_VERSION, rgVar.q, z);
            b(sb, "from", rgVar.d, z);
            b(sb, "cfrom", rgVar.e, z);
            b(sb, "net_type", rgVar.p, z);
            b(sb, "cuid", rgVar.g, z);
            b(sb, "model", rgVar.k, z);
            if (TextUtils.isEmpty(rgVar.l)) {
                b(sb, "uid", "0", z);
            } else {
                b(sb, "uid", rgVar.l, z);
            }
            b(sb, "un", rgVar.m, z);
            b(sb, "utbrand", rgVar.w, z);
            b(sb, "cuid_galaxy2", rgVar.h, z);
            return sb.toString();
        }
        return (String) invokeZL.objValue;
    }

    public static String e(xg xgVar, rg rgVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, xgVar, rgVar)) == null) {
            if (xgVar.p() != null && (xgVar.p().equals("omp") || xgVar.p().equals("mon"))) {
                return c(rgVar);
            }
            return d(true, rgVar);
        }
        return (String) invokeLL.objValue;
    }

    public static HashMap<String, Object> f(String str, rg rgVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, rgVar, z)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            a(hashMap, HttpRequest.CLIENT_TYPE, "2");
            a(hashMap, "_client_version", rgVar.c);
            a(hashMap, HttpRequest.CLIENT_ID, rgVar.f);
            a(hashMap, HttpRequest.SUBAPP_TYPE, rgVar.j);
            a(hashMap, "from", rgVar.d);
            a(hashMap, "net_type", rgVar.p);
            a(hashMap, "cuid", rgVar.g);
            a(hashMap, "cuid_galaxy2", rgVar.h);
            a(hashMap, "model", rgVar.k);
            if (TextUtils.isEmpty(rgVar.l)) {
                rgVar.l = "0";
            }
            a(hashMap, "uid", rgVar.l);
            a(hashMap, "un", rgVar.m);
            a(hashMap, HttpRequest.BDUSS, rgVar.n);
            if (z) {
                a(hashMap, "find_bug", "2");
            } else {
                a(hashMap, "find_bug", "0");
            }
            a(hashMap, "sz", rgVar.r);
            a(hashMap, BaiduIdentityManager.PARAM_CUA, rgVar.s);
            a(hashMap, TiebaStatic.Params.BDID, rgVar.z);
            a(hashMap, "cookie", rgVar.n);
            a(hashMap, "oaid", rgVar.t);
            a(hashMap, "utbrand", rgVar.w);
            a(hashMap, "baiduapppb_ut", rgVar.x);
            a(hashMap, HttpRequest.USER_AGENT, rgVar.y);
            a(hashMap, "active_timestamp", rgVar.A);
            a(hashMap, "first_install_time", rgVar.B);
            a(hashMap, TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, rgVar.C);
            a(hashMap, "event_day", rgVar.D);
            if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, str).getData()).booleanValue()) {
                MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
            } else {
                a(hashMap, "mac", rgVar.u);
                a(hashMap, HttpRequest.ANDROID_ID, rgVar.v);
                a(hashMap, HttpRequest.PHONE_IMEI, rgVar.i);
            }
            return hashMap;
        }
        return (HashMap) invokeLLZ.objValue;
    }
}
