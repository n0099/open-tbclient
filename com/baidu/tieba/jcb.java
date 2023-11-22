package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class jcb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            switch (str.hashCode()) {
                case -1256417762:
                    if (str.equals("TOOL_ID_EMOTION")) {
                        return 5;
                    }
                    break;
                case -76182512:
                    if (str.equals("TOOL_ID_ITEM")) {
                        return 35;
                    }
                    break;
                case -76103433:
                    if (str.equals("TOOL_ID_LINK")) {
                        return 31;
                    }
                    break;
                case -76067758:
                    if (str.equals("TOOL_ID_MORE")) {
                        return 2;
                    }
                    break;
                case -75799577:
                    if (str.equals("TOOL_ID_VOTE")) {
                        return 32;
                    }
                    break;
                case 303703088:
                    if (str.equals("TOOL_ID_COMMODITY")) {
                        return 33;
                    }
                    break;
                case 1380924528:
                    if (str.equals("TOOL_ID_AT")) {
                        return 9;
                    }
                    break;
                case 1933096926:
                    if (str.equals("TOOL_ID_IMAGE")) {
                        return 10;
                    }
                    break;
                case 1944986366:
                    if (str.equals("TOOL_ID_VIDEO")) {
                        return 34;
                    }
                    break;
                case 1945169845:
                    if (str.equals("TOOL_ID_VOICE")) {
                        return 6;
                    }
                    break;
            }
            return -2;
        }
        return invokeL.intValue;
    }
}
