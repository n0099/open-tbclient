package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.ec;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes5.dex */
public class m18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Bitmap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            Bitmap bitmap = null;
            try {
                File file = new File(str);
                if (file.exists()) {
                    if (c(file)) {
                        jn jnVar = ec.a.b().get(str);
                        if (jnVar != null) {
                            bitmap = jnVar.p();
                        }
                    } else {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeFile(str, options);
                        bitmap = BitmapHelper.loadResizedBitmap(str, options.outWidth, options.outHeight);
                    }
                }
            } catch (OutOfMemoryError unused) {
            }
            return bitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public static boolean c(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, file)) == null) {
            FileInputStream fileInputStream2 = null;
            boolean z = false;
            try {
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (FileNotFoundException e) {
                    e = e;
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                byte[] bArr = new byte[7];
                if (fileInputStream.read(bArr, 0, 6) == 6) {
                    z = zi.D(bArr);
                }
                fileInputStream.close();
            } catch (FileNotFoundException e4) {
                e = e4;
                fileInputStream2 = fileInputStream;
                e.printStackTrace();
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                return z;
            } catch (IOException e5) {
                e = e5;
                fileInputStream2 = fileInputStream;
                e.printStackTrace();
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
            if (0 != 0) {
                fileInputStream2.close();
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static Bitmap b(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        Bitmap f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, imageFileInfo)) == null) {
            ea5 ea5Var = new ea5();
            jn c = ea5Var.c(imageFileInfo, true);
            if (c != null) {
                f = c.p();
            } else {
                f = ea5Var.f(imageFileInfo, true);
            }
            if (f == null) {
                return a(imageFileInfo.getFilePath());
            }
            return f;
        }
        return (Bitmap) invokeL.objValue;
    }
}
