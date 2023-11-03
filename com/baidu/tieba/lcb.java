package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class lcb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    switch (i) {
                        case 9:
                        default:
                            return "TEXT";
                        case 10:
                            return "RECORD";
                        case 11:
                            return "RICH_TEXT";
                        case 12:
                            return "EVALUATION";
                        case 13:
                            return "LOCAL_CHANNEL";
                        case 14:
                            return "QUESTION";
                        case 15:
                            return "DYNAMIC";
                    }
                }
                return "REPLY_FLOOR";
            }
            return "REPLY";
        }
        return (String) invokeI.objValue;
    }
}
