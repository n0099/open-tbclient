package com.baidu.tieba;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
/* loaded from: classes8.dex */
public class x00 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile byte[] a;
    public transient /* synthetic */ FieldHolder $fh;

    public x00() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (x00.class) {
                    if (a == null) {
                        byte[] bArr = new byte[16];
                        System.arraycopy(e10.b(), 0, bArr, 0, 16);
                        t00 t00Var = new t00();
                        t00Var.a(2, bArr, bArr);
                        a = t00Var.b(new byte[]{-71, -100, -115, 26, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, -124, 14, 14, ExifInterface.MARKER_APP1, -46, -56, 1, 25, -127, -99, -107, ExifInterface.MARKER_SOF10, 51, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 14, 68, -68, -19, 28, 66, 19, -113, 5, 25, -11, -123, 50});
                    }
                }
            }
            return a;
        }
        return (byte[]) invokeV.objValue;
    }
}
