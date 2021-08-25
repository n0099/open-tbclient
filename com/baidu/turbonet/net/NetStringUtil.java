package com.baidu.turbonet.net;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.text.Normalizer;
@JNINamespace
/* loaded from: classes8.dex */
public class NetStringUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public NetStringUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @CalledByNative
    public static String convertToUnicode(ByteBuffer byteBuffer, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, byteBuffer, str)) == null) {
            try {
                return Charset.forName(str).newDecoder().decode(byteBuffer).toString();
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    @CalledByNative
    public static String convertToUnicodeAndNormalize(ByteBuffer byteBuffer, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, byteBuffer, str)) == null) {
            String convertToUnicode = convertToUnicode(byteBuffer, str);
            if (convertToUnicode == null) {
                return null;
            }
            return Normalizer.normalize(convertToUnicode, Normalizer.Form.NFC);
        }
        return (String) invokeLL.objValue;
    }

    @CalledByNative
    public static String convertToUnicodeWithSubstitutions(ByteBuffer byteBuffer, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, byteBuffer, str)) == null) {
            try {
                CharsetDecoder newDecoder = Charset.forName(str).newDecoder();
                newDecoder.onMalformedInput(CodingErrorAction.REPLACE);
                newDecoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
                newDecoder.replaceWith("�");
                return newDecoder.decode(byteBuffer).toString();
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }
}
