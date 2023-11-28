package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class rd3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948117736, "Lcom/baidu/tieba/rd3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948117736, "Lcom/baidu/tieba/rd3;");
                return;
            }
        }
        a = sm1.a;
    }

    public static boolean a() {
        InterceptResult invokeV;
        String X;
        String queryParameter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            h63 c0 = h63.c0();
            if (c0 == null || (X = c0.X().X()) == null || (queryParameter = Uri.parse(X).getQueryParameter("params")) == null) {
                return false;
            }
            try {
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            if (!TextUtils.equals(new JSONObject(queryParameter).optString("forcePath"), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
