package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class tu8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static short b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            switch (i) {
                case -100000306:
                    return (short) 6;
                case -100000303:
                    return (short) 2;
                case 3160010:
                    return (short) 5;
                case 3160011:
                    return (short) 4;
                default:
                    return (short) 9;
            }
        }
        return invokeI.shortValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002d, code lost:
        if (android.text.TextUtils.isEmpty(r5) != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, str)) == null) {
            short b = b(i);
            int i2 = R.string.message_text_error_because_network;
            if (b != 2) {
                if (b != 9) {
                    if (b != 4) {
                        if (b != 5) {
                            if (b == 6) {
                                i2 = R.string.message_text_error_because_refuse;
                            }
                            i2 = -1;
                        } else {
                            i2 = R.string.message_text_error_because_refuse_stranger;
                        }
                    } else {
                        i2 = R.string.message_text_error_because_refuse_friend;
                    }
                }
            }
            if (i2 != -1) {
                return TbadkCoreApplication.getInst().getResources().getString(i2);
            }
            return str;
        }
        return (String) invokeIL.objValue;
    }
}
