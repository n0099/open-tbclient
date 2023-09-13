package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
/* loaded from: classes8.dex */
public class yh {
    public static /* synthetic */ Interceptable $ic;
    public static yh c;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile SparseArray<Bitmap> a;
    public Context b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448322686, "Lcom/baidu/tieba/yh;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448322686, "Lcom/baidu/tieba/yh;");
        }
    }

    public yh() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new SparseArray<>();
        Bitmap.Config config = Bitmap.Config.RGB_565;
    }

    public static synchronized yh d() {
        InterceptResult invokeV;
        yh yhVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (yh.class) {
                if (c == null) {
                    c = new yh();
                }
                yhVar = c;
            }
            return yhVar;
        }
        return (yh) invokeV.objValue;
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.a.clear();
            }
        }
    }

    public byte[] a(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bitmap, i)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeLI.objValue;
    }

    public Bitmap c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return BitmapFactory.decodeFile(str);
        }
        return (Bitmap) invokeL.objValue;
    }

    public void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.b = context;
        }
    }

    public Bitmap f(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, bitmap, i, i2)) == null) {
            if (i > 0 && i2 >= 0 && bitmap != null && !bitmap.isRecycled()) {
                if (bitmap.getWidth() <= i && bitmap.getHeight() <= i2) {
                    return bitmap;
                }
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                float f = i2 / height;
                float f2 = i / width;
                if (f > f2) {
                    f = f2;
                }
                Matrix matrix = new Matrix();
                matrix.postScale(f, f);
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                if (createBitmap != bitmap) {
                    bitmap.recycle();
                }
                return createBitmap;
            }
            return null;
        }
        return (Bitmap) invokeLII.objValue;
    }
}
