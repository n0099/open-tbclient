package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.AssetUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public final class on3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                hr4.d(context.getAssets().open(str, 0));
                return true;
            } catch (IOException unused) {
                hr4.d(null);
                return false;
            } catch (Throwable th) {
                hr4.d(null);
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            InputStream inputStream2 = null;
            r0 = null;
            String str2 = null;
            try {
                inputStream = context.getAssets().open(str);
            } catch (IOException e) {
                e = e;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                hr4.d(inputStream2);
                throw th;
            }
            if (inputStream == null) {
                hr4.d(inputStream);
                return null;
            }
            try {
                try {
                    str2 = kr4.b(inputStream);
                } catch (IOException e2) {
                    e = e2;
                    if (nr1.a) {
                        Log.w(AssetUtils.TAG, "loadPresetDatas", e);
                    }
                    hr4.d(inputStream);
                    return str2;
                }
                hr4.d(inputStream);
                return str2;
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                hr4.d(inputStream2);
                throw th;
            }
        }
        return (String) invokeLL.objValue;
    }
}
