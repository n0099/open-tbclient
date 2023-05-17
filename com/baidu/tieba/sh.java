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
/* loaded from: classes7.dex */
public class sh {
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

    public static String c(ah ahVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ahVar)) == null) {
            if (ahVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("product");
                sb.append("=");
                sb.append(URLEncoder.encode(ahVar.a, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("sub_sys");
                sb.append("=");
                sb.append(URLEncoder.encode(ahVar.b, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("version");
                sb.append("=");
                sb.append(URLEncoder.encode(ahVar.c, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("os");
                sb.append("=");
                sb.append("android");
                sb.append("&");
                sb.append(HttpConstants.OS_VERSION);
                sb.append("=");
                sb.append(URLEncoder.encode(ahVar.q, IMAudioTransRequest.CHARSET));
                if (!TextUtils.isEmpty(ahVar.d)) {
                    sb.append("&");
                    sb.append("from");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ahVar.d, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ahVar.e)) {
                    sb.append("&");
                    sb.append("cfrom");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ahVar.e, IMAudioTransRequest.CHARSET));
                }
                sb.append("&");
                sb.append("phone");
                sb.append("=");
                sb.append(URLEncoder.encode(ahVar.k, IMAudioTransRequest.CHARSET));
                if (!TextUtils.isEmpty(ahVar.l)) {
                    sb.append("&");
                    sb.append("uid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ahVar.l, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ahVar.f)) {
                    sb.append("&");
                    sb.append("client_id");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ahVar.f, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ahVar.i)) {
                    sb.append("&");
                    sb.append("imei");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ahVar.i, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ahVar.m)) {
                    sb.append("&");
                    sb.append("uname");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ahVar.m, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ahVar.g)) {
                    sb.append("&");
                    sb.append("cuid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ahVar.g, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ahVar.h)) {
                    sb.append("&");
                    sb.append("cuid_galaxy2");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ahVar.h, IMAudioTransRequest.CHARSET));
                }
                sb.append("&");
                sb.append("net");
                sb.append("=");
                sb.append(URLEncoder.encode(ahVar.o, IMAudioTransRequest.CHARSET));
            } catch (UnsupportedEncodingException e) {
                BdLog.e(e);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(boolean z, ah ahVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65539, null, z, ahVar)) == null) {
            if (ahVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("_client_type=2");
            b(sb, "_client_version", ahVar.c, z);
            b(sb, HttpRequest.PHONE_IMEI, ahVar.i, z);
            b(sb, HttpRequest.CLIENT_ID, ahVar.f, z);
            b(sb, HttpRequest.SUBAPP_TYPE, ahVar.j, z);
            b(sb, HttpConstants.OS_VERSION, ahVar.q, z);
            b(sb, "from", ahVar.d, z);
            b(sb, "cfrom", ahVar.e, z);
            b(sb, "net_type", ahVar.p, z);
            b(sb, "cuid", ahVar.g, z);
            b(sb, "model", ahVar.k, z);
            if (TextUtils.isEmpty(ahVar.l)) {
                b(sb, "uid", "0", z);
            } else {
                b(sb, "uid", ahVar.l, z);
            }
            b(sb, "un", ahVar.m, z);
            b(sb, "utbrand", ahVar.w, z);
            b(sb, "cuid_galaxy2", ahVar.h, z);
            return sb.toString();
        }
        return (String) invokeZL.objValue;
    }

    public static String e(gh ghVar, ah ahVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ghVar, ahVar)) == null) {
            if (ghVar.p() != null && (ghVar.p().equals("omp") || ghVar.p().equals("mon"))) {
                return c(ahVar);
            }
            return d(true, ahVar);
        }
        return (String) invokeLL.objValue;
    }

    public static HashMap<String, Object> f(String str, ah ahVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, ahVar, z)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            a(hashMap, HttpRequest.CLIENT_TYPE, "2");
            a(hashMap, "_client_version", ahVar.c);
            a(hashMap, HttpRequest.CLIENT_ID, ahVar.f);
            a(hashMap, HttpRequest.SUBAPP_TYPE, ahVar.j);
            a(hashMap, "from", ahVar.d);
            a(hashMap, "net_type", ahVar.p);
            a(hashMap, "cuid", ahVar.g);
            a(hashMap, "cuid_galaxy2", ahVar.h);
            if (TextUtils.isEmpty(ahVar.l)) {
                ahVar.l = "0";
            }
            a(hashMap, "uid", ahVar.l);
            a(hashMap, "un", ahVar.m);
            a(hashMap, HttpRequest.BDUSS, ahVar.n);
            if (z) {
                a(hashMap, "find_bug", "2");
            } else {
                a(hashMap, "find_bug", "0");
            }
            a(hashMap, "sz", ahVar.r);
            a(hashMap, BaiduIdentityManager.PARAM_CUA, ahVar.s);
            a(hashMap, TiebaStatic.Params.BDID, ahVar.z);
            a(hashMap, "cookie", ahVar.n);
            a(hashMap, "utbrand", ahVar.w);
            a(hashMap, "baiduapppb_ut", ahVar.x);
            a(hashMap, HttpRequest.USER_AGENT, ahVar.y);
            a(hashMap, "active_timestamp", ahVar.A);
            a(hashMap, "first_install_time", ahVar.B);
            a(hashMap, TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, ahVar.C);
            a(hashMap, "event_day", ahVar.D);
            if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, "isKeepOriginalLogic").getData()).booleanValue()) {
                a(hashMap, "model", ahVar.k);
                a(hashMap, "oaid", ahVar.t);
                if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, str).getData()).booleanValue()) {
                    a(hashMap, "isKeepOriginalLogic", "true");
                    MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
                } else {
                    a(hashMap, HttpRequest.ANDROID_ID, ahVar.v);
                    a(hashMap, HttpRequest.PHONE_IMEI, ahVar.i);
                }
            } else {
                MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
            }
            if (((Boolean) MessageManager.getInstance().runTask(2000983, Boolean.class, "isKeepOriginalLogic").getData()).booleanValue()) {
                if (((Boolean) MessageManager.getInstance().runTask(2000983, Boolean.class, str).getData()).booleanValue()) {
                    a(hashMap, "isKeepOriginalLogic", "true");
                    MessageManager.getInstance().runTask(2000982, HashMap.class, hashMap);
                } else {
                    a(hashMap, "mac", ahVar.u);
                }
            } else {
                MessageManager.getInstance().runTask(2000982, HashMap.class, hashMap);
            }
            return hashMap;
        }
        return (HashMap) invokeLLZ.objValue;
    }
}
