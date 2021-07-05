package com.baidu.wallet.base.a;

import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.core.utils.LogUtil;
import java.net.URLDecoder;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                for (String str3 : str.split("&")) {
                    String[] split = str3.split("=");
                    if (split != null && !TextUtils.isEmpty(split[0]) && str2.equalsIgnoreCase(split[0]) && split.length > 1) {
                        return URLDecoder.decode(split[1]);
                    }
                }
                return "";
            } catch (Exception e2) {
                LogUtil.d(e2.toString());
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static ArrayList<String> a(String str, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, strArr)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            try {
                arrayList.add(a(str, PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID));
                arrayList.add(a(str, "order_no"));
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    if (!TextUtils.isEmpty(strArr[i2])) {
                        arrayList.add(strArr[i2]);
                    } else {
                        arrayList.add("empty");
                    }
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }
}
