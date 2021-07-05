package com.bytedance.sdk.component.adnet.d;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.component.net.utils.MultiProcessFileUtils;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65537, null, context, i2, str) == null) {
            try {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (i2 == 1) {
                    linkedHashMap.put(MultiProcessFileUtils.KEY_TNC_CONFIG, str);
                }
                d.b(MultiProcessFileUtils.TAG, "saveData = " + str);
                com.bytedance.sdk.component.adnet.a.a().a(context, linkedHashMap);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, int i2) {
        InterceptResult invokeLI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(65536, null, context, i2)) != null) {
            return (String) invokeLI.objValue;
        }
        if (i2 == 1) {
            try {
                str = com.bytedance.sdk.component.adnet.a.a().a(context, MultiProcessFileUtils.KEY_TNC_CONFIG, "");
            } catch (Exception unused) {
                str = "";
            }
            return !(str instanceof String) ? String.valueOf(str) : "";
        }
        str = "";
        if (!(str instanceof String)) {
        }
    }
}
