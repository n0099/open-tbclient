package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class ue6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                Uri parse = Uri.parse(str);
                return parse.getAuthority() + parse.getPath();
            } catch (Exception unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    int lastIndexOf2 = str.lastIndexOf(47);
                    if (lastIndexOf2 >= 0) {
                        str = str.substring(lastIndexOf2 + 1);
                    }
                    if (!str.isEmpty() && Pattern.matches("[a-zA-Z_0-9~\\.\\-\\(\\)\\%]+", str) && (lastIndexOf = str.lastIndexOf(46)) >= 0) {
                        return str.substring(lastIndexOf + 1);
                    }
                    return "";
                } catch (Exception unused) {
                    return "";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        String mimeTypeFromExtension;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String str2 = null;
            try {
                String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
                if (!TextUtils.isEmpty(fileExtensionFromUrl) && !TextUtils.equals(fileExtensionFromUrl, StringUtil.NULL_STRING)) {
                    if (TextUtils.equals(fileExtensionFromUrl, "json")) {
                        mimeTypeFromExtension = "application/json";
                    } else {
                        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
                    }
                    str2 = mimeTypeFromExtension;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (TextUtils.isEmpty(str2)) {
                return "*/*";
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static String d(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            int indexOf = str.indexOf("?");
            if (indexOf > 0) {
                return str.substring(0, indexOf);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
