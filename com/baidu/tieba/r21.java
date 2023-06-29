package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
/* loaded from: classes7.dex */
public abstract class r21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract boolean c(int i, @Nullable String str);

    public r21() {
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

    public void a(int i, @Nullable String str, @Nullable String str2, @Nullable Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, th}) != null) || !c(i, str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            if (th == null) {
                return;
            }
            str2 = b(th);
        } else if (th != null) {
            str2 = str2 + "\n" + b(th);
        }
        if (TextUtils.isEmpty(str)) {
            d(i, null, str2);
        } else if (str.length() > 23 && Build.VERSION.SDK_INT < 24) {
            d(i, str.substring(0, 23), str2);
        } else {
            d(i, str, str2);
        }
    }

    public final String b(@NonNull Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
            try {
                StringWriter stringWriter = new StringWriter(256);
                PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
                th.printStackTrace(printWriter);
                printWriter.flush();
                printWriter.close();
                return stringWriter.toString();
            } catch (Exception e) {
                String message = e.getMessage();
                if (TextUtils.isEmpty(message)) {
                    return "unknown throwable by VideoLog.java";
                }
                return message;
            }
        }
        return (String) invokeL.objValue;
    }

    public void d(int i, @Nullable String str, @NonNull String str2) {
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i, str, str2) == null) {
            if (str2.length() < 4096) {
                if (i == 7) {
                    Log.wtf(str, str2);
                    return;
                } else {
                    Log.println(i, str, str2);
                    return;
                }
            }
            int i2 = 0;
            int length = str2.length();
            while (i2 < length) {
                int indexOf = str2.indexOf(10, i2);
                if (indexOf == -1) {
                    indexOf = length;
                }
                while (true) {
                    min = Math.min(indexOf, i2 + 4096);
                    String substring = str2.substring(i2, min);
                    if (i == 7) {
                        Log.wtf(str, substring);
                    } else {
                        Log.println(i, str, substring);
                    }
                    if (min >= indexOf) {
                        break;
                    }
                    i2 = min;
                }
                i2 = min + 1;
            }
        }
    }
}
