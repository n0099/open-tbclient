package com.baidu.tieba;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.Base64;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import kotlin.jvm.internal.ByteCompanionObject;
import org.apache.commons.codec.binary4util.BaseNCodec;
/* loaded from: classes5.dex */
public final class p60 {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] a;
    public static final byte[] b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948013855, "Lcom/baidu/tieba/p60;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948013855, "Lcom/baidu/tieba/p60;");
                return;
            }
        }
        a = new byte[]{0, -118, 109, 108, -43, -56, 63, 62, 108, ExifInterface.MARKER_SOF1, -94, 72, -110, -122, -111, -109, 102, -12, 17, 110, 123, 1, -110, 124, 18, 78, -48, -23, 85, -21, -48, 4, ExifInterface.MARKER_SOF14, -68, 88, -15, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, -32, -14, 54, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, ExifInterface.MARKER_SOF3, -110, ExifInterface.MARKER_SOF3, 113, -21, -60, 66, -122, -52, Base64.INTERNAL_PADDING, 28, -48, -24, -96, -25, 13, -88, -96, -98, 23, -14, -89, 24, 90, 82, -16, -65, 107, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, -22, 113, 24, -46, 120, 57, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, -13, 2, Constants.SHORT_PING_CMD_TYPE, 92, 9, 69, 91, 107, ExifInterface.MARKER_SOF15, -127, 54, -70, 104, 34, -13, 76, 26, 84, -1, -99, 80, -98, 43, ExifInterface.MARKER_SOS, -60, 86, 58, 107, 40, -69, -43, -109, -124, 103, -79, -43, -22, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, -11, -52, 55, 86, 75, -43, 114, -18, 2, 77, ExifInterface.MARKER_SOF11, -65, 3, 8, 45, 106, -117, -42, 56, 51, -11, -76, 21, 68, 116, -52, -71, 81, -17, 49, 71, 4, -1, -60, 52, ExifInterface.MARKER_SOF9, -72, 8, -100, 90, -12, 15, 108, 45, 86, 97, 20, 53, 70, -106, -36, -1, 10, -115, 53, -109, -52, -73, 108, 122, -8, 113, 98, Byte.MIN_VALUE, -81, 79, 98, -15, -36, 119, 118, ExifInterface.MARKER_SOF9, -125, BaseNCodec.PAD_DEFAULT, -98, 59, 111, 16, 22, 118, 40, -18, -5, 2, -17, 71, -114, ExifInterface.START_CODE, -45, 96, 10, -104, 64, 95, -47, 73, ByteCompanionObject.MAX_VALUE, 88, ExifInterface.MARKER_SOF10, -3, -99, 16, ExifInterface.MARKER_SOF6, 27, -7, -36, 60, -60, -13, -99, 55, 55, -7, -96, -34, 7, -34, 28, ExifInterface.MARKER_APP1, -26, -96, ExifInterface.MARKER_APP1, 54, -108, 45, 6, -27, -106, -104, ExifInterface.MARKER_SOF6, -22, -71, -81, -30, 100, BaseNCodec.PAD_DEFAULT, -1, ExifInterface.MARKER_SOF5, 56, 48, ExifInterface.MARKER_SOF3, -11};
        b = new byte[]{1, 0, 1};
    }
}
