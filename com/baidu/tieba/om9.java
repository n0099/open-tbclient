package com.baidu.tieba;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.WebChromeClient;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class om9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        String[] split;
        String[] split2;
        String[] split3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (hi.isEmpty(str) || (split = str.split("\\?")) == null || split.length == 0 || (split2 = split[0].split("\\/\\/")) == null || split2.length < 2 || (split3 = split2[1].split("\\/")) == null || split2.length < 2) {
                return null;
            }
            return split3[split3.length - 1];
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (hi.isEmpty(str) || (parse = Uri.parse(str)) == null) {
                return null;
            }
            return parse.getQueryParameter(WebChromeClient.KEY_ARG_CALLBACK);
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (hi.isEmpty(str) || (parse = Uri.parse(str)) == null) {
                return null;
            }
            return parse.getQueryParameter("upgrade");
        }
        return (String) invokeL.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (hi.isEmpty(str) || (parse = Uri.parse(str)) == null) {
                return null;
            }
            return parse.getQueryParameter("notificationName");
        }
        return (String) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        String[] split;
        String[] split2;
        String str2;
        String[] split3;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                if (!hi.isEmpty(str) && (split = str.split("\\?")) != null && split.length != 0 && (split2 = split[0].split("\\/\\/")) != null && split2.length >= 2 && (split3 = (str2 = split2[1]).split("\\/")) != null && split2.length >= 2 && (str3 = split3[split3.length - 1]) != null && str3.length() != 0) {
                    return str2.substring(0, (str2.length() - str3.length()) - 1);
                }
                return null;
            } catch (Exception e) {
                BdLog.e(e);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static JSONObject f(String str) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (hi.isEmpty(str)) {
                return new JSONObject();
            }
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return new JSONObject();
            }
            String queryParameter = parse.getQueryParameter("params");
            if (hi.isEmpty(queryParameter)) {
                return new JSONObject();
            }
            return new JSONObject(queryParameter);
        }
        return (JSONObject) invokeL.objValue;
    }
}
