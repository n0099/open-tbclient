package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ph {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (BdNetTypeUtil.isWifiNet()) {
                return "WIFI";
            }
            if (BdNetTypeUtil.isMobileNet()) {
                int curOperatorType = BdNetTypeUtil.curOperatorType();
                StringBuilder sb = new StringBuilder();
                if (curOperatorType == 1) {
                    sb.append('M');
                } else if (curOperatorType == 2) {
                    sb.append('U');
                } else if (curOperatorType != 3) {
                    sb.append('N');
                } else {
                    sb.append('T');
                }
                if (BdNetTypeUtil.isWap()) {
                    sb.append("_WAP_");
                } else {
                    sb.append("_NET_");
                }
                if (BdNetTypeUtil.is3GNet()) {
                    sb.append("3G");
                } else if (BdNetTypeUtil.is4GNet()) {
                    sb.append("4G");
                } else if (BdNetTypeUtil.is2GNet()) {
                    sb.append("2G");
                } else {
                    sb.append('N');
                }
                return sb.toString();
            }
            return "unknown";
        }
        return (String) invokeL.objValue;
    }
}
