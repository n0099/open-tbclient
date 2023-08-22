package com.baidu.tieba;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.FileNotFoundException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class oo3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean d(int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (z) {
                return false;
            }
            float f = i;
            if (f > 100.0f) {
                float f2 = i2;
                if (f2 > 100.0f) {
                    float f3 = f / f2;
                    return f3 > 2.5f || 1.0f / f3 > 2.5f;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static BitmapFactory.Options a(Uri uri) {
        InterceptResult invokeL;
        InputStream openInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, uri)) == null) {
            Context appContext = AppRuntime.getAppContext();
            InputStream inputStream = null;
            if (appContext == null || uri == null) {
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            try {
                try {
                    openInputStream = appContext.getContentResolver().openInputStream(uri);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e) {
                e = e;
            }
            try {
                BitmapFactory.decodeStream(openInputStream, null, options);
                hr4.d(openInputStream);
            } catch (FileNotFoundException e2) {
                e = e2;
                inputStream = openInputStream;
                e.printStackTrace();
                hr4.d(inputStream);
                return options;
            } catch (Throwable th2) {
                th = th2;
                inputStream = openInputStream;
                hr4.d(inputStream);
                throw th;
            }
            return options;
        }
        return (BitmapFactory.Options) invokeL.objValue;
    }

    public static boolean b(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uri)) == null) {
            BitmapFactory.Options a = a(uri);
            if (a == null) {
                return false;
            }
            String str = a.outMimeType;
            if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("image/gif")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return b(vo3.p(str));
        }
        return invokeL.booleanValue;
    }

    public static boolean e(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, uri)) == null) {
            BitmapFactory.Options a = a(uri);
            if (a != null && d(a.outWidth, a.outHeight, b(uri))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return e(vo3.p(str));
        }
        return invokeL.booleanValue;
    }
}
