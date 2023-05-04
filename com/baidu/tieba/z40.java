package com.baidu.tieba;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.e50;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import dalvik.system.InMemoryDexClassLoader;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import org.apache.commons.codec.net.QCodec;
/* loaded from: classes7.dex */
public class z40 {
    public static /* synthetic */ Interceptable $ic;
    public static byte[] a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Class[] a;
        public final /* synthetic */ e50.a b;
        public final /* synthetic */ Context c;

        public a(Class[] clsArr, e50.a aVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {clsArr, aVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = clsArr;
            this.b = aVar;
            this.c = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                try {
                    Object invoke = this.a[0].getMethod("asInterface", IBinder.class).invoke(null, iBinder);
                    Method method = invoke.getClass().getMethod("getOaid", new Class[0]);
                    z40.b(((Boolean) invoke.getClass().getMethod("isOaidTrackLimited", new Class[0]).invoke(invoke, new Object[0])).booleanValue());
                    this.b.a(true, (String) method.invoke(invoke, new Object[0]));
                } catch (Throwable unused) {
                    this.b.a(false, null);
                }
                try {
                    this.c.unbindService(this);
                } catch (Throwable unused2) {
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948309843, "Lcom/baidu/tieba/z40;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948309843, "Lcom/baidu/tieba/z40;");
                return;
            }
        }
        a = new byte[]{100, Constants.SHORT_PING_CMD_TYPE, 120, 10, 48, 51, 53, 0, -86, 63, -11, 20, 70, -5, -109, -97, 89, -91, ExifInterface.MARKER_SOI, -13, 18, 90, 117, 21, ExifInterface.MARKER_SOF7, 20, 31, 110, 4, 77, 83, 43, -4, 13, 0, 0, 112, 0, 0, 0, 120, 86, 52, 18, 0, 0, 0, 0, 0, 0, 0, 0, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 13, 0, 0, 68, 0, 0, 0, 112, 0, 0, 0, 17, 0, 0, 0, Byte.MIN_VALUE, 1, 0, 0, 13, 0, 0, 0, -60, 1, 0, 0, 5, 0, 0, 0, 96, 2, 0, 0, 32, 0, 0, 0, -120, 2, 0, 0, 3, 0, 0, 0, -120, 3, 0, 0, 20, 10, 0, 0, -24, 3, 0, 0, -120, 7, 0, 0, -112, 7, 0, 0, -100, 7, 0, 0, -97, 7, 0, 0, -94, 7, 0, 0, -90, 7, 0, 0, -69, 7, 0, 0, -47, 7, 0, 0, -22, 7, 0, 0, -1, 7, 0, 0, 29, 8, 0, 0, 97, 8, 0, 0, -97, 8, 0, 0, ExifInterface.MARKER_SOI, 8, 0, 0, -4, 8, 0, 0, 28, 9, 0, 0, 63, 9, 0, 0, 91, 9, 0, 0, 111, 9, 0, 0, -125, 9, 0, 0, -91, 9, 0, 0, -84, 9, 0, 0, -78, 9, 0, 0, ExifInterface.MARKER_SOF7, 9, 0, 0, -35, 9, 0, 0, -3, 9, 0, 0, 0, 10, 0, 0, 4, 10, 0, 0, 8, 10, 0, 0, 13, 10, 0, 0, 16, 10, 0, 0, 23, 10, 0, 0, 30, 10, 0, 0, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, 10, 0, 0, 47, 10, 0, 0, 60, 10, 0, 0, 70, 10, 0, 0, 83, 10, 0, 0, 100, 10, 0, 0, 106, 10, 0, 0, -95, 10, 0, 0, -89, 10, 0, 0, -77, 10, 0, 0, ExifInterface.MARKER_SOF5, 10, 0, 0, -52, 10, 0, 0, -28, 10, 0, 0, -19, 10, 0, 0, -9, 10, 0, 0, -4, 10, 0, 0, 16, Constants.GZIP_CAST_TYPE, 0, 0, 25, Constants.GZIP_CAST_TYPE, 0, 0, 31, Constants.GZIP_CAST_TYPE, 0, 0, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, Constants.GZIP_CAST_TYPE, 0, 0, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, Constants.GZIP_CAST_TYPE, 0, 0, 56, Constants.GZIP_CAST_TYPE, 0, 0, 77, Constants.GZIP_CAST_TYPE, 0, 0, 92, Constants.GZIP_CAST_TYPE, 0, 0, Constants.SHORT_PING_CMD_TYPE, Constants.GZIP_CAST_TYPE, 0, 0, 113, Constants.GZIP_CAST_TYPE, 0, 0, 122, Constants.GZIP_CAST_TYPE, 0, 0, -126, Constants.GZIP_CAST_TYPE, 0, 0, -119, Constants.GZIP_CAST_TYPE, 0, 0, -113, Constants.GZIP_CAST_TYPE, 0, 0, -103, Constants.GZIP_CAST_TYPE, 0, 0, -96, Constants.GZIP_CAST_TYPE, 0, 0, -86, Constants.GZIP_CAST_TYPE, 0, 0, -65, Constants.GZIP_CAST_TYPE, 0, 0, -47, Constants.GZIP_CAST_TYPE, 0, 0, 2, 0, 0, 0, 5, 0, 0, 0, 6, 0, 0, 0, 7, 0, 0, 0, 8, 0, 0, 0, 9, 0, 0, 0, 10, 0, 0, 0, Constants.GZIP_CAST_TYPE, 0, 0, 0, 12, 0, 0, 0, 13, 0, 0, 0, 14, 0, 0, 0, 15, 0, 0, 0, 16, 0, 0, 0, 17, 0, 0, 0, 18, 0, 0, 0, 25, 0, 0, 0, 29, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 3, 0, 0, 0, 92, 7, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 8, 0, 0, 0, 100, 7, 0, 0, 3, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 25, 0, 0, 0, 15, 0, 0, 0, 0, 0, 0, 0, 26, 0, 0, 0, 15, 0, 0, 0, 108, 7, 0, 0, 27, 0, 0, 0, 15, 0, 0, 0, 100, 7, 0, 0, 28, 0, 0, 0, 15, 0, 0, 0, 116, 7, 0, 0, 27, 0, 0, 0, 15, 0, 0, 0, 92, 7, 0, 0, 29, 0, 0, 0, 16, 0, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 16, 0, 0, 0, 124, 7, 0, 0, 6, 0, 2, 0, 49, 0, 0, 0, 7, 0, 14, 0, 1, 0, 0, 0, 7, 0, 0, 0, 22, 0, 0, 0, 7, 0, 0, 0, 23, 0, 0, 0, 7, 0, 0, 0, 24, 0, 0, 0, 1, 0, 6, 0, 0, 0, 0, 0, 1, 0, 12, 0, 53, 0, 0, 0, 2, 0, 2, 0, 54, 0, 0, 0, 2, 0, 12, 0, 62, 0, 0, 0, 4, 0, 10, 0, ExifInterface.START_CODE, 0, 0, 0, 4, 0, 3, 0, 52, 0, 0, 0, 4, 0, 6, 0, 55, 0, 0, 0, 4, 0, 0, 0, 56, 0, 0, 0, 4, 0, 5, 0, 57, 0, 0, 0, 4, 0, 6, 0, 58, 0, 0, 0, 4, 0, 7, 0, 64, 0, 0, 0, 4, 0, 10, 0, 65, 0, 0, 0, 4, 0, 6, 0, 66, 0, 0, 0, 4, 0, 10, 0, 67, 0, 0, 0, 6, 0, 8, 0, 0, 0, 0, 0, 6, 0, 1, 0, Base64.INTERNAL_PADDING, 0, 0, 0, 6, 0, 5, 0, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 0, 0, 0, 6, 0, 5, 0, 45, 0, 0, 0, 6, 0, 5, 0, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 0, 0, 0, 6, 0, Constants.GZIP_CAST_TYPE, 0, 48, 0, 0, 0, 7, 0, 6, 0, 0, 0, 0, 0, 7, 0, 1, 0, Base64.INTERNAL_PADDING, 0, 0, 0, 7, 0, 4, 0, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 0, 0, 0, 7, 0, 9, 0, 37, 0, 0, 0, 7, 0, 5, 0, 45, 0, 0, 0, 7, 0, 5, 0, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 0, 0, 0, 7, 0, Constants.GZIP_CAST_TYPE, 0, 48, 0, 0, 0, 7, 0, 12, 0, 53, 0, 0, 0, 8, 0, 5, 0, 45, 0, 0, 0, 8, 0, 5, 0, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 0, 0, 0, 8, 0, Constants.GZIP_CAST_TYPE, 0, 48, 0, 0, 0, 13, 0, 6, 0, 0, 0, 0, 0, 8, 0, 0, 0, 1, 6, 0, 0, 13, 0, 0, 0, 76, 7, 0, 0, 19, 0, 0, 0, -28, 6, 0, 0, -37, 12, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 13, 0, 0, 0, 84, 7, 0, 0, 19, 0, 0, 0, 12, 7, 0, 0, -21, 12, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 1, 4, 0, 0, 1, 0, 0, 0, 84, 7, 0, 0, 19, 0, 0, 0, 52, 7, 0, 0, Constants.GZIP_CAST_TYPE, 13, 0, 0, -46, 12, 0, 0, 
        1, 0, 0, 0, -101, 12, 0, 0, 1, 0, 0, 0, -93, 12, 0, 0, 2, 0, 0, 0, -85, 12, 0, 0, -79, 12, 0, 0, 3, 0, 0, 0, -70, 12, 0, 0, ExifInterface.MARKER_SOF0, 12, 0, 0, ExifInterface.MARKER_SOF10, 12, 0, 0, 2, 0, 2, 0, 1, 0, 0, 0, -34, Constants.GZIP_CAST_TYPE, 0, 0, 6, 0, 0, 0, 112, 16, 31, 0, 0, 0, 91, 1, 0, 0, 14, 0, 2, 0, 1, 0, 0, 0, 0, 0, -26, Constants.GZIP_CAST_TYPE, 0, 0, 3, 0, 0, 0, 84, 16, 0, 0, 17, 0, 0, 0, 2, 0, 1, 0, 0, 0, 0, 0, -21, Constants.GZIP_CAST_TYPE, 0, 0, 3, 0, 0, 0, 26, 0, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 0, 17, 0, 0, 0, 7, 0, 1, 0, 5, 0, 1, 0, -16, Constants.GZIP_CAST_TYPE, 0, 0, ExifInterface.START_CODE, 0, 0, 0, 113, 0, 5, 0, 0, 0, 12, 0, 113, 0, 5, 0, 0, 0, 12, 1, 26, 3, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 0, 110, 32, Constants.GZIP_CAST_TYPE, 0, 48, 0, 84, 99, 0, 0, 18, 20, 18, 5, 114, 85, 3, 0, 67, 16, 110, 16, 6, 0, 1, 0, 110, 16, 8, 0, 1, 0, 12, 2, 110, 16, 9, 0, 1, 0, 110, 16, 9, 0, 0, 0, 17, 2, 13, 3, 110, 16, 9, 0, 1, 0, 110, 16, 9, 0, 0, 0, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 3, 8, 0, 0, 0, 18, 0, 1, 0, 1, 0, 34, 0, 7, 0, 1, 0, 5, 0, 1, 0, 13, 12, 0, 0, ExifInterface.START_CODE, 0, 0, 0, 113, 0, 5, 0, 0, 0, 12, 0, 113, 0, 5, 0, 0, 0, 12, 1, 26, 3, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 0, 110, 32, Constants.GZIP_CAST_TYPE, 0, 48, 0, 84, 99, 0, 0, 18, 52, 18, 5, 114, 85, 3, 0, 67, 16, 110, 16, 6, 0, 1, 0, 110, 16, 8, 0, 1, 0, 12, 2, 110, 16, 9, 0, 1, 0, 110, 16, 9, 0, 0, 0, 17, 2, 13, 3, 110, 16, 9, 0, 1, 0, 110, 16, 9, 0, 0, 0, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 3, 8, 0, 0, 0, 18, 0, 1, 0, 1, 0, 34, 0, 7, 0, 1, 0, 5, 0, 1, 0, 43, 12, 0, 0, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 0, 0, 0, 18, 2, 113, 0, 5, 0, 0, 0, 12, 0, 113, 0, 5, 0, 0, 0, 12, 1, 26, 3, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 0, 110, 32, Constants.GZIP_CAST_TYPE, 0, 48, 0, 84, 99, 0, 0, 18, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 18, 5, 114, 85, 3, 0, 67, 16, 110, 16, 6, 0, 1, 0, 110, 16, 7, 0, 1, 0, 10, 3, 56, 3, 3, 0, 18, 18, 110, 16, 9, 0, 1, 0, 110, 16, 9, 0, 0, 0, 15, 2, 13, 3, 110, 16, 9, 0, 1, 0, 110, 16, 9, 0, 0, 0, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 3, 9, 0, 0, 0, 18, 0, 1, 0, 1, 0, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, 0, 2, 0, 1, 0, 3, 0, 0, 0, 72, 12, 0, 0, 9, 0, 0, 0, 112, 16, 0, 0, 1, 0, 26, 0, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 0, 110, 48, 23, 0, 17, 0, 14, 0, 0, 0, 3, 0, 1, 0, 2, 0, 0, 0, 79, 12, 0, 0, 25, 0, 0, 0, 57, 2, 4, 0, 18, 0, 17, 0, 26, 1, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 0, 114, 32, 2, 0, 18, 0, 12, 0, 56, 0, 9, 0, 32, 1, 8, 0, 56, 1, 5, 0, 31, 0, 8, 0, 40, -15, 34, 0, 6, 0, 112, 32, 14, 0, 32, 0, 40, -21, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 99, 12, 0, 0, 1, 0, 0, 0, 17, 0, 0, 0, 9, 0, 5, 0, 5, 0, 0, 0, 104, 12, 0, 0, 80, 0, 0, 0, 18, 19, 26, 1, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 0, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 5, 59, 0, 0, 0, 111, 88, 1, 0, 84, 118, 10, 3, 15, 3, 110, 32, 13, 0, 23, 0, 40, -4, 110, 32, 4, 0, 22, 0, 110, 16, 24, 0, 4, 0, 12, 0, 110, 16, 12, 0, 7, 0, 110, 32, 13, 0, 7, 0, 40, -18, 110, 32, 4, 0, 22, 0, 110, 16, 26, 0, 4, 0, 10, 0, 110, 16, 12, 0, 7, 0, 56, 0, 7, 0, 1, 50, 110, 32, 10, 0, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 0, 40, -35, 18, 2, 40, -5, 110, 32, 4, 0, 22, 0, 110, 16, 25, 0, 4, 0, 12, 0, 110, 16, 12, 0, 7, 0, 110, 32, 13, 0, 7, 0, 40, ExifInterface.MARKER_SOF13, 0, 2, 4, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 70, 84, 78, QCodec.UNDERSCORE, 12, 0, 0, 0, 26, 0, 0, 0, 45, 0, 0, 0, 8, 0, 0, 0, -24, 3, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 28, 0, 0, 0, -16, 3, 0, 0, 29, 0, 0, 0, -16, 3, 0, 0, 30, 0, 0, 0, -16, 3, 0, 0, -8, 3, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 17, 0, 0, 0, -16, 3, 0, 0, 18, 0, 0, 0, -16, 3, 0, 0, 19, 0, 0, 0, -16, 3, 0, 0, 4, 4, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 27, 0, 0, 0, -16, 3, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0, 1, 0, 0, 0, 8, 0, 0, 0, 1, 0, 0, 0, 14, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 3, 0, 14, 0, 4, 0, 0, 0, 0, 0, 4, 0, 4, 0, 0, 0, 6, 60, 105, 110, 105, 116, 62, 0, 10, 68, 69, 83, 67, 82, 73, 80, 84, 79, 82, 0, 1, 73, 0, 1, 76, 0, 2, 76, 76, 0, 19, 76, 97, 110, 100, 114, 111, 105, 100, 47, 111, 115, 47, 66, 105, 110, 100, Constants.SHORT_PING_CMD_TYPE, 114, 59, 0, 20, 76, 97, 110, 100, 114, 111, 105, 100, 47, 111, 115, 47, 73, 66, 105, 110, 100, Constants.SHORT_PING_CMD_TYPE, 114, 59, 
        0, 23, 76, 97, 110, 100, 114, 111, 105, 100, 47, 111, 115, 47, 73, 73, 110, 116, Constants.SHORT_PING_CMD_TYPE, 114, 102, 97, 99, Constants.SHORT_PING_CMD_TYPE, 59, 0, 19, 76, 97, 110, 100, 114, 111, 105, 100, 47, 111, 115, 47, 80, 97, 114, 99, Constants.SHORT_PING_CMD_TYPE, 108, 59, 0, 28, 76, 97, 110, 100, 114, 111, 105, 100, 47, 111, 115, 47, 82, Constants.SHORT_PING_CMD_TYPE, 109, 111, 116, Constants.SHORT_PING_CMD_TYPE, 69, 120, 99, Constants.SHORT_PING_CMD_TYPE, 112, 116, 105, 111, 110, 59, 0, 66, 76, 99, 111, 109, 47, 117, 111, 100, 105, 115, 47, 111, 112, Constants.SHORT_PING_CMD_TYPE, 110, 100, Constants.SHORT_PING_CMD_TYPE, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, 47, 97, 105, 100, 108, 47, 79, 112, Constants.SHORT_PING_CMD_TYPE, 110, 68, Constants.SHORT_PING_CMD_TYPE, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, 73, 100, Constants.SHORT_PING_CMD_TYPE, 110, 116, 105, 102, 105, Constants.SHORT_PING_CMD_TYPE, 114, 83, Constants.SHORT_PING_CMD_TYPE, 114, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 83, 116, 117, 98, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 80, 114, 111, 120, 121, 59, 0, 60, 76, 99, 111, 109, 47, 117, 111, 100, 105, 115, 47, 111, 112, Constants.SHORT_PING_CMD_TYPE, 110, 100, Constants.SHORT_PING_CMD_TYPE, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, 47, 97, 105, 100, 108, 47, 79, 112, Constants.SHORT_PING_CMD_TYPE, 110, 68, Constants.SHORT_PING_CMD_TYPE, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, 73, 100, Constants.SHORT_PING_CMD_TYPE, 110, 116, 105, 102, 105, Constants.SHORT_PING_CMD_TYPE, 114, 83, Constants.SHORT_PING_CMD_TYPE, 114, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 83, 116, 117, 98, 59, 0, 55, 76, 99, 111, 109, 47, 117, 111, 100, 105, 115, 47, 111, 112, Constants.SHORT_PING_CMD_TYPE, 110, 100, Constants.SHORT_PING_CMD_TYPE, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, 47, 97, 105, 100, 108, 47, 79, 112, Constants.SHORT_PING_CMD_TYPE, 110, 68, Constants.SHORT_PING_CMD_TYPE, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, 73, 100, Constants.SHORT_PING_CMD_TYPE, 110, 116, 105, 102, 105, Constants.SHORT_PING_CMD_TYPE, 114, 83, Constants.SHORT_PING_CMD_TYPE, 114, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, 59, 0, 34, 76, 100, 97, 108, 118, 105, 107, 47, 97, 110, 110, 111, 116, 97, 116, 105, 111, 110, 47, 69, 110, 99, 108, 111, 115, 105, 110, 103, 67, 108, 97, 115, 115, 59, 0, 30, 76, 100, 97, 108, 118, 105, 107, 47, 97, 110, 110, 111, 116, 97, 116, 105, 111, 110, 47, 73, 110, 110, Constants.SHORT_PING_CMD_TYPE, 114, 67, 108, 97, 115, 115, 59, 0, 33, 76, 100, 97, 108, 118, 105, 107, 47, 97, 110, 110, 111, 116, 97, 116, 105, 111, 110, 47, 77, Constants.SHORT_PING_CMD_TYPE, 109, 98, Constants.SHORT_PING_CMD_TYPE, 114, 67, 108, 97, 115, 115, Constants.SHORT_PING_CMD_TYPE, 115, 59, 0, 26, 76, 100, 97, 108, 118, 105, 107, 47, 97, 110, 110, 111, 116, 97, 116, 105, 111, 110, 47, 84, 104, 114, 111, 119, 115, 59, 0, 18, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 79, 98, 106, Constants.SHORT_PING_CMD_TYPE, 99, 116, 59, 0, 18, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 0, 32, 79, 112, Constants.SHORT_PING_CMD_TYPE, 110, 68, Constants.SHORT_PING_CMD_TYPE, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, 73, 100, Constants.SHORT_PING_CMD_TYPE, 110, 116, 105, 102, 105, Constants.SHORT_PING_CMD_TYPE, 114, 83, Constants.SHORT_PING_CMD_TYPE, 114, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 106, 97, 118, 97, 0, 5, 80, 114, 111, 120, 121, 0, 4, 83, 116, 117, 98, 0, 19, 84, 82, 65, 78, 83, 65, 67, 84, 73, 79, 78, QCodec.UNDERSCORE, 103, Constants.SHORT_PING_CMD_TYPE, 116, 79, 97, 105, 100, 0, 20, 84, 82, 65, 78, 83, 65, 67, 84, 73, 79, 78, QCodec.UNDERSCORE, 103, Constants.SHORT_PING_CMD_TYPE, 116, 79, 97, 105, 100, 50, 0, 30, 84, 82, 65, 78, 83, 65, 67, 84, 73, 79, 78, QCodec.UNDERSCORE, 105, 115, 79, 97, 105, 100, 84, 114, 97, 99, 107, 76, 105, 109, 105, 116, Constants.SHORT_PING_CMD_TYPE, 100, 0, 1, 86, 0, 2, 86, 73, 0, 2, 86, 76, 0, 3, 86, 76, 76, 0, 1, 90, 0, 5, 90, 73, 76, 76, 73, 0, 5, QCodec.UNDERSCORE, 100, 97, 116, 97, 0, 6, QCodec.UNDERSCORE, 114, Constants.SHORT_PING_CMD_TYPE, 112, 108, 121, 0, 7, QCodec.UNDERSCORE, 114, Constants.SHORT_PING_CMD_TYPE, 115, 117, 108, 116, 0, Constants.GZIP_CAST_TYPE, 97, 99, 99, Constants.SHORT_PING_CMD_TYPE, 115, 115, 70, 108, 97, 103, 115, 0, 8, 97, 115, 66, 105, 110, 100, Constants.SHORT_PING_CMD_TYPE, 114, 0, Constants.GZIP_CAST_TYPE, 97, 115, 73, 110, 116, Constants.SHORT_PING_CMD_TYPE, 114, 102, 97, 99, Constants.SHORT_PING_CMD_TYPE, 0, 15, 97, 116, 116, 97, 99, 104, 73, 110, 116, Constants.SHORT_PING_CMD_TYPE, 114, 102, 97, 99, Constants.SHORT_PING_CMD_TYPE, 0, 4, 99, 111, 100, Constants.SHORT_PING_CMD_TYPE, 0, 53, 99, 111, 109, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 117, 111, 100, 105, 115, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 111, 112, Constants.SHORT_PING_CMD_TYPE, 110, 100, Constants.SHORT_PING_CMD_TYPE, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 97, 105, 100, 108, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 79, 112, Constants.SHORT_PING_CMD_TYPE, 110, 68, Constants.SHORT_PING_CMD_TYPE, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, 73, 100, Constants.SHORT_PING_CMD_TYPE, 110, 116, 105, 102, 105, Constants.SHORT_PING_CMD_TYPE, 114, 83, Constants.SHORT_PING_CMD_TYPE, 114, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, 0, 4, 100, 97, 116, 97, 0, 10, 100, Constants.SHORT_PING_CMD_TYPE, 115, 99, 114, 105, 112, 116, 111, 114, 0, 16, Constants.SHORT_PING_CMD_TYPE, 110, 102, 111, 114, 99, Constants.SHORT_PING_CMD_TYPE, 73, 110, 116, Constants.SHORT_PING_CMD_TYPE, 114, 102, 97, 99, Constants.SHORT_PING_CMD_TYPE, 0, 5, 102, 108, 97, 103, 115, 0, 22, 103, Constants.SHORT_PING_CMD_TYPE, 116, 73, 110, 116, Constants.SHORT_PING_CMD_TYPE, 114, 102, 97, 99, Constants.SHORT_PING_CMD_TYPE, 68, Constants.SHORT_PING_CMD_TYPE, 115, 99, 114, 105, 112, 116, 111, 114, 0, 7, 103, Constants.SHORT_PING_CMD_TYPE, 116, 79, 97, 105, 100, 0, 8, 103, Constants.SHORT_PING_CMD_TYPE, 116, 79, 97, 105, 100, 50, 0, 3, 105, 105, 110, 0, 18, 105, 115, 79, 97, 105, 100, 84, 114, 97, 99, 107, 76, 105, 109, 105, 116, Constants.SHORT_PING_CMD_TYPE, 100, 0, 7, 109, 82, Constants.SHORT_PING_CMD_TYPE, 109, 111, 116, Constants.SHORT_PING_CMD_TYPE, 0, 4, 110, 97, 109, Constants.SHORT_PING_CMD_TYPE, 0, 3, 111, 98, 106, 0, 6, 111, 98, 116, 97, 105, 110, 0, 10, 111, 110, 84, 114, 97, 110, 115, 97, 99, 116, 0, 19, 113, 117, Constants.SHORT_PING_CMD_TYPE, 114, 121, 76, 111, 99, 97, 108, 73, 110, 116, Constants.SHORT_PING_CMD_TYPE, 114, 102, 97, 99, Constants.SHORT_PING_CMD_TYPE, 0, 13, 114, Constants.SHORT_PING_CMD_TYPE, 97, 100, 69, 120, 99, Constants.SHORT_PING_CMD_TYPE, 112, 116, 105, 111, 110, 0, 7, 114, Constants.SHORT_PING_CMD_TYPE, 97, 100, 73, 110, 116, 0, 10, 114, Constants.SHORT_PING_CMD_TYPE, 97, 100, 83, 116, 114, 105, 110, 103, 0, 7, 114, Constants.SHORT_PING_CMD_TYPE, 99, 121, 99, 108, Constants.SHORT_PING_CMD_TYPE, 0, 6, 114, Constants.SHORT_PING_CMD_TYPE, 109, 111, 116, Constants.SHORT_PING_CMD_TYPE, 0, 5, 114, Constants.SHORT_PING_CMD_TYPE, 112, 108, 121, 0, 4, 116, 104, 105, 115, 0, 8, 116, 114, 97, 110, 115, 97, 99, 116, 0, 5, 118, 97, 108, 117, Constants.SHORT_PING_CMD_TYPE, 0, 8, 119, 114, 105, 116, Constants.SHORT_PING_CMD_TYPE, 73, 110, 116, 0, 19, 119, 114, 105, 116, Constants.SHORT_PING_CMD_TYPE, 73, 110, 116, Constants.SHORT_PING_CMD_TYPE, 114, 102, 97, 99, 
        Constants.SHORT_PING_CMD_TYPE, 84, 111, 107, Constants.SHORT_PING_CMD_TYPE, 110, 0, 16, 119, 114, 105, 116, Constants.SHORT_PING_CMD_TYPE, 78, 111, 69, 120, 99, Constants.SHORT_PING_CMD_TYPE, 112, 116, 105, 111, 110, 0, Constants.GZIP_CAST_TYPE, 119, 114, 105, 116, Constants.SHORT_PING_CMD_TYPE, 83, 116, 114, 105, 110, 103, 0, 82, 1, 60, 7, 14, 60, 45, 0, 87, 0, 7, 14, 0, 91, 0, 7, 14, 0, QCodec.UNDERSCORE, 0, 7, 14, 75, 3, 0, 32, 5, 77, 3, 1, 33, 5, 90, 120, 60, 77, 3, 2, 34, 15, 60, 61, 26, 5, 2, 75, 0, -126, 1, 0, 7, 14, 75, 3, 0, 32, 5, 77, 3, 1, 33, 5, 90, 120, 60, 77, 3, 2, 34, 15, 60, 61, 26, 5, 2, 75, 0, 113, 0, 7, 29, 75, 3, 0, 32, 5, 77, 3, 1, 33, 5, 90, 120, 60, 122, 3, 2, 34, 17, 60, 61, 26, 5, 2, 75, 0, 16, 0, 7, 14, 60, 90, 0, 25, 1, 52, 7, 14, 45, Base64.INTERNAL_PADDING, 25, 105, 3, 0, 48, 4, 105, 61, 1, 2, 5, 0, 0, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 0, 7, 14, 0, 40, 4, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, 61, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 7, 29, 45, 3, 1, ExifInterface.START_CODE, 15, 2, 33, 59, 2, 99, 89, 79, 60, 75, 3, 0, 34, 15, 60, 79, 5, 0, 60, 75, 3, 0, 34, 17, 60, -102, 5, 0, 60, 75, 3, 0, 34, 15, 60, 2, 100, 74, 0, 2, Constants.GZIP_CAST_TYPE, 1, 63, 28, 1, 24, 7, 2, 12, 1, 63, 28, 1, 24, 5, 2, 9, 1, 63, 24, 7, 2, 10, 2, 34, 4, 10, 50, 23, 20, 2, 9, 1, 63, 24, 8, 2, 10, 2, 34, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 9, 4, 50, 23, 21, 2, Constants.GZIP_CAST_TYPE, 1, 63, 28, 1, 24, 6, 4, 23, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 4, 1, 4, 3, 4, 2, 0, 0, 0, 3, 28, -127, 8, 0, 1, -127, 8, 0, 1, -127, 8, 0, 0, 1, 1, 5, 0, 2, 14, Byte.MIN_VALUE, Byte.MIN_VALUE, 4, -108, 8, 15, 1, -80, 8, 1, 1, -56, 8, 1, 1, -32, 8, 1, 1, -48, 9, 1, 1, ExifInterface.MARKER_SOF0, 10, 4, 0, 2, 2, 1, 26, 1, 24, 1, 24, 1, 24, 20, -127, Byte.MIN_VALUE, 4, -72, Constants.GZIP_CAST_TYPE, 2, 9, -36, Constants.GZIP_CAST_TYPE, 21, 1, -96, 12, 6, 1, -76, 12, 0, 0, 0, 17, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 68, 0, 0, 0, 112, 0, 0, 0, 2, 0, 0, 0, 17, 0, 0, 0, Byte.MIN_VALUE, 1, 0, 0, 3, 0, 0, 0, 13, 0, 0, 0, -60, 1, 0, 0, 4, 0, 0, 0, 5, 0, 0, 0, 96, 2, 0, 0, 5, 0, 0, 0, 32, 0, 0, 0, -120, 2, 0, 0, 6, 0, 0, 0, 3, 0, 0, 0, -120, 3, 0, 0, 3, 16, 0, 0, 4, 0, 0, 0, -24, 3, 0, 0, 1, 32, 0, 0, 10, 0, 0, 0, 20, 4, 0, 0, 6, 32, 0, 0, 3, 0, 0, 0, -28, 6, 0, 0, 1, 16, 0, 0, 7, 0, 0, 0, 76, 7, 0, 0, 2, 32, 0, 0, 68, 0, 0, 0, -120, 7, 0, 0, 3, 32, 0, 0, 10, 0, 0, 0, -34, Constants.GZIP_CAST_TYPE, 0, 0, 4, 32, 0, 0, 7, 0, 0, 0, -101, 12, 0, 0, 5, 32, 0, 0, 1, 0, 0, 0, -46, 12, 0, 0, 0, 32, 0, 0, 3, 0, 0, 0, -37, 12, 0, 0, 0, 16, 0, 0, 1, 0, 0, 0, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 13, 0, 0};
    }

    public z40() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a(Context context, e50.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, aVar) == null) {
            if (context == null) {
                aVar.a(false, null);
                return;
            }
            Class[] clsArr = new Class[1];
            try {
                clsArr[0] = Class.forName("com.uodis.opendevice.aidl.OpenDeviceIdentifierService$Stub");
            } catch (Throwable unused) {
            }
            if (clsArr[0] == null) {
                try {
                    if (Build.VERSION.SDK_INT >= 26) {
                        clsArr[0] = new InMemoryDexClassLoader(ByteBuffer.wrap(a), z40.class.getClassLoader()).loadClass("com.uodis.opendevice.aidl.OpenDeviceIdentifierService$Stub");
                    }
                } catch (Throwable unused2) {
                }
            }
            if (clsArr[0] == null) {
                aVar.a(false, null);
                return;
            }
            try {
                a aVar2 = new a(clsArr, aVar, context);
                Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                intent.setPackage("com.huawei.hwid");
                context.bindService(intent, aVar2, 1);
            } catch (Throwable unused3) {
                aVar.a(false, null);
            }
        }
    }

    public static /* synthetic */ boolean b(boolean z) {
        return z;
    }
}
