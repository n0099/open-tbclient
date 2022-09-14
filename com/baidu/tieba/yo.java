package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.lang.reflect.Array;
import java.security.InvalidParameterException;
/* loaded from: classes6.dex */
public class yo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            if (obj.getClass().isArray()) {
                int length = Array.getLength(obj);
                StringBuilder sb = new StringBuilder();
                sb.append('[');
                int i = 0;
                while (i < length) {
                    sb.append(Array.get(obj, i));
                    sb.append(',');
                    sb.append(WebvttCueParser.CHAR_SPACE);
                    i++;
                }
                if (i > 0) {
                    sb.delete(sb.length() - 2, sb.length());
                }
                sb.append(']');
                return sb.toString();
            }
            throw new InvalidParameterException("Not a primitive array: " + obj.getClass());
        }
        return (String) invokeL.objValue;
    }
}
