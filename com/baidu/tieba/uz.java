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
import org.apache.commons.codec.net.QCodec;
/* loaded from: classes6.dex */
public class uz {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] a;
    public static final byte[] b;
    public static final byte[] c;
    public static final byte[] d;
    public static final byte[] e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448319400, "Lcom/baidu/tieba/uz;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448319400, "Lcom/baidu/tieba/uz;");
                return;
            }
        }
        a = new byte[]{34, 60, 59, -95, -15, -17, -46, -67, ExifInterface.MARKER_SOF3, ExifInterface.MARKER_SOF10, 110, QCodec.UNDERSCORE, -4, ExifInterface.MARKER_SOS, 9, 45, 102, -33, -108, ExifInterface.MARKER_SOF6, -101, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 120, 49, 68, 73, -1, -83, 120, -3, -47, 114, 86, -20, -105, 30, -33, -29, 24, -18, -19, -21, 115, 3, -99, -48, 77, ExifInterface.MARKER_SOF10, -80, 58, -113, 52, 47, -93, 93, -115, 48, -6, -65, 22, 98, -120, 109, -6, -88, 75, -92, 10, 65, Constants.SHORT_PING_CMD_TYPE, ExifInterface.MARKER_SOF9, -87, 113, -109, ExifInterface.MARKER_SOI, -81, -125, ExifInterface.MARKER_SOI, -98, Base64.INTERNAL_PADDING, -3, -97, 75, -65, 62, 100, 25, -19, ExifInterface.MARKER_SOF7, 125, -89, -86, -120, -79, -104, 26, Byte.MIN_VALUE, 4, -82, 81, -109, 91, -7, -118, -76, ExifInterface.MARKER_SOF6, -105, ExifInterface.MARKER_SOF3, -85, 87, 85, Byte.MIN_VALUE, -36, -75, 49, -10, Byte.MIN_VALUE, -78, -42, 85, -116, 106, -69, 108, -65, 115, -113, -118, 97, 5, 65, -24, 19, 92, 22, -7, Constants.GZIP_CAST_TYPE, 14, 91, -10, 125, 24, -41, 55, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 62, -28, 50, -46, 61, 94, 113, ExifInterface.MARKER_SOF5, -120, -124, 13, ExifInterface.MARKER_SOS, QCodec.UNDERSCORE, -60, -43, 115, 71, -2, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, 8, -22, -107, -78, 62, -75, 83, 17, ExifInterface.MARKER_SOF14, 97, ExifInterface.MARKER_EOI, 10, 126, 77, -113, -87, -116, 92, -14, 23, -41, 75, 125, -110, -18, -103, 9, 99, -73, 54, -75, 91, -19, 3, 58, 81, ExifInterface.MARKER_APP1, 60, -37, 48, Constants.GZIP_CAST_TYPE, -18, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, -66, 78, 68, ExifInterface.MARKER_SOF7, -115, 110, 61, -2, -26, ExifInterface.MARKER_SOF9, 111, 91, 43, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, -112, -19, -25, 13, -101, 0, 93, -60, 120, -18, 12, -76, -116, 70, -70, -99, 16, 5, -76, 67, -44, 50, -121, 13, 119, 105, -99, -7, -119, 61, 30, 32, 43, 55, ExifInterface.MARKER_SOF13};
        b = new byte[]{0, -95, 74, 123, 19, 115, 61, Base64.INTERNAL_PADDING, -89, 25, -82, 82, -76, -19, 10, -101, ExifInterface.MARKER_SOF13, 58, -96, ExifInterface.MARKER_SOF10, Constants.GZIP_CAST_TYPE, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, -84, -1, 93, 63, -66, -34, -48, -15, 57, -28, -112, ExifInterface.MARKER_SOF15, -41, 27, 24, -84, -95, -33, -17, -16, 91, -22, -15, -21, 8, ExifInterface.MARKER_SOF7, 69, 57, -13, Base64.INTERNAL_PADDING, 23, 96, -25, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, ExifInterface.MARKER_SOF6, 61, -94, 87, -122, 47, -72, -22, 71, -9, 4, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 19, 55, 91, -16, 24, ExifInterface.MARKER_SOF11, -12, 76, 48, Base64.INTERNAL_PADDING, ByteCompanionObject.MAX_VALUE, -115, 6, 126, 24, -76, -6, 103, -3, ExifInterface.MARKER_SOF5, -15, 73, ExifInterface.MARKER_SOF0, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, -92, -66, -114, 8, 97, ExifInterface.MARKER_SOF11, 49, -114, ExifInterface.MARKER_APP1, -37, -119, -44, -115, 96, -115, 63, -123, 6, -41, 86, -2, 16, 84, 34, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 83, -127, -23, -83, 9, 75, -45, -127, -81, -90, 120, -17};
        c = new byte[]{34, 120, 93, 28, 86, 125, 58, -72, 104, -79, 40, 125, 82, -26, -85, 124, -100, -25, 25, 17, 88, -127, -116, -8, 0, 33, 70, -4, -1, -110, -69, -85, 5, 81, -70, -27, -98, -7, ExifInterface.START_CODE, 124, -74, 47, -120, 124, 20, -14, 74, -107, -69, 116, -101, -8, -89, -71, 99, -124, 9, 55, 107, -18, -114, 5, -79, 58, 64, -110, ExifInterface.MARKER_SOF13, 78, -29, 69, ExifInterface.MARKER_SOF13, 63, -77, -73, 106, 43, 10, -95, -98, -112, ExifInterface.MARKER_SOF14, -87, -98, -91, ExifInterface.MARKER_SOF3, ExifInterface.MARKER_EOI, 57, -75, ExifInterface.MARKER_APP1, -85, 80, 89, ExifInterface.START_CODE, -25, 45, -119, -18, -90, -56, -101, -23, 59, -91, -52, 124, 83, 61, -20, 119, -105, -74, 102, -27, 86, 17, -15, -110, 75, ExifInterface.MARKER_SOF5, 123, -24, ExifInterface.START_CODE, 117, 48, Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, -127, 9, 12, ExifInterface.MARKER_SOF7, 93, -92, -30, -47, -4, 109, -67, Constants.SHORT_PING_CMD_TYPE, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, -91, -73, -75, -25, 66, -41, -43, -28, -84, ExifInterface.MARKER_SOF14, 33, -65, 10, -94, 5, ExifInterface.MARKER_SOF15, -36, 64, -101, 87, -12, 78, Base64.INTERNAL_PADDING, -44, 94, ExifInterface.MARKER_SOF11, -28, 115, 107, 117, -81, -6, 51, 86, 40, -108, -80, 110, -71, -30, -9, 49, ExifInterface.MARKER_SOF15, 100, 50, -41, 20, -97, 32, -34, -14, 60, -25, 53, -97, Base64.INTERNAL_PADDING, -37, -122, -122, -80, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, 54, 0, -9, -111, 55, 90, 17, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, 82, ExifInterface.MARKER_SOF15, -73, 51, 9, 56, 92, 97, -126, 85, 4, -114, -48, 109, ExifInterface.MARKER_SOF7, 96, ExifInterface.MARKER_APP1, -102, -71, -87, -76, -77, -52, 58, 107, 66, -103, Base64.INTERNAL_PADDING, 5, 47, -112, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, ExifInterface.MARKER_SOF6, Constants.SHORT_PING_CMD_TYPE, 77, -21, 4, ExifInterface.MARKER_SOF5, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, -3, Base64.INTERNAL_PADDING, -36, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 109, 40, -111, 115, 23};
        d = new byte[]{0, -70, ExifInterface.START_CODE, -20, -46, -12, -1, -114, 74, -47, 126, -90, 23, -7, -79, -117, -90, 82, 94, 22, -56, 34, -71, -22, 52, 103, -86, -90, ExifInterface.MARKER_SOF6, -3, 60, -16, 92, 55, 73, -24, 47, -125, 16, 17, -96, -42, 96, 93, 61, -90, 43, -72, -47, 68, 59, -106, ExifInterface.MARKER_SOF5, 67, 103, 34, 69, -88, -92, -19, -15, -112, 58, 17, 94, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, -48, Base64.INTERNAL_PADDING, ExifInterface.MARKER_SOF2, 23, -56, -65, -2, 43, 65, -119, ExifInterface.MARKER_SOF14, ExifInterface.MARKER_SOF5, -90, -119, 17, -66, -99, 90, -71, -111, ExifInterface.MARKER_SOF0, 10, -30, ExifInterface.MARKER_SOF0, 70, 52, 97, 33, 114, -15, 63, 71, ExifInterface.MARKER_SOF10, ExifInterface.MARKER_SOF10, -76, -6, 79, ExifInterface.MARKER_SOF11, 24, 79, -81, 24, -48, 1, 23, ExifInterface.MARKER_SOF1, 89, -86, -83, -121, -1, ExifInterface.START_CODE, ByteCompanionObject.MAX_VALUE, -46, 93, 3, 77, ExifInterface.MARKER_EOI, -81, 123, 114, 20, 89};
        e = new byte[]{0, -113, 121, 53, ExifInterface.MARKER_EOI, -71, -86, -23, -65, -85, -19, -120, 122, ExifInterface.MARKER_SOF15, 73, 81, -74, -13, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, ExifInterface.MARKER_SOF5, -98, 59, -81, 55, 24, -24, -22, -60, -106, 31, 62, -3, 54, 6, -25, 67, 81, -87, -60, 24, 51, 57, -72, 9, -25, ExifInterface.MARKER_SOF2, -82, 28, 83, -101, -89, 71, 91, -123, -48, 17, -83, -72, -76, 121, -121, 117, 73, -124, 105, 92, -84, 14, -113, 20, -77, 54, 8, 40, -94, 47, -6, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 17, 10, 61, 98, -87, -109, 69, 52, 9, -96, -2, 105, 108, 70, 88, -8, 75, -35, 32, -127, -100, 55, 9, -96, 16, 87, -79, -107, -83, ExifInterface.MARKER_SOF13, 0, Base64.INTERNAL_PADDING, 61, -70, 84, -124, -74, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, 31, -99, 100, -114, -8, -125, 68, -122, 119, -105, -100, -20, 4, -76, 52, -90, -84, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 117, -23, -104, 93, -30, 61, -80, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, 47, ExifInterface.MARKER_SOF1, 17, -116, -97, -6, -99, -127, -127, -25, 51, -115, -73, -110, -73, 48, -41, -71, -29, 73, 89, 47, 104, 9, -104, 114, 21, 57, 21, -22, 61, 107, -117, 70, 83, ExifInterface.MARKER_SOF6, 51, 69, -113, Byte.MIN_VALUE, 59, 50, -92, ExifInterface.MARKER_SOF2, -32, -14, 114, -112, 37, 110, 78, 63, -118, 59, 8, 56, -95, -60, 80, -28, ExifInterface.MARKER_APP1, -116, 26, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, -93, 125, -33, 94, -95, 67, -34, 75, 102, -1, 4, -112, 62, -43, ExifInterface.MARKER_SOF15, 22, Base64.INTERNAL_PADDING, ExifInterface.MARKER_APP1, 88, -44, -121, ExifInterface.MARKER_SOF6, 8, -23, ByteCompanionObject.MAX_VALUE, 33, 28, ExifInterface.MARKER_SOI, 29, ExifInterface.MARKER_SOF10, Base64.INTERNAL_PADDING, ExifInterface.MARKER_SOF11, 110, 56, 7, Constants.SHORT_PING_CMD_TYPE, -8, 34, -29, 66, -66, 72, 76, 5, 118, 57, 57, 96, 28, -42, 103};
    }
}
