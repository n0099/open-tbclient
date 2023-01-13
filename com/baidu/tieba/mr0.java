package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.net.request.BodyStyle;
import com.baidu.nadcore.net.request.RequestMethod;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.RequestBody;
/* loaded from: classes5.dex */
public class mr0 {
    public static /* synthetic */ Interceptable $ic;
    public static final MediaType a;
    public static final MediaType b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-594921631, "Lcom/baidu/tieba/mr0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-594921631, "Lcom/baidu/tieba/mr0$a;");
                    return;
                }
            }
            int[] iArr = new int[BodyStyle.values().length];
            b = iArr;
            try {
                iArr[BodyStyle.BYTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[BodyStyle.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[BodyStyle.FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[BodyStyle.FORM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[RequestMethod.values().length];
            a = iArr2;
            try {
                iArr2[RequestMethod.HEAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[RequestMethod.GET.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[RequestMethod.POST.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[RequestMethod.PUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[RequestMethod.DELETE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[RequestMethod.PATCH.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[RequestMethod.OPTIONS.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[RequestMethod.TRACE.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947982142, "Lcom/baidu/tieba/mr0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947982142, "Lcom/baidu/tieba/mr0;");
                return;
            }
        }
        a = MediaType.parse("text/plain");
        b = MediaType.parse("application/octet-stream");
        MediaType.parse("application/x-www-form-urlencoded");
    }

    public static RequestBody a(@NonNull or0 or0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, or0Var)) == null) {
            byte[] bArr = or0Var.d;
            if (bArr != null && bArr.length > 0) {
                return RequestBody.create(d(or0Var.b, b), or0Var.d);
            }
            return RequestBody.create((MediaType) null, new byte[0]);
        }
        return (RequestBody) invokeL.objValue;
    }

    public static RequestBody f(@NonNull or0 or0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, or0Var)) == null) {
            if (!TextUtils.isEmpty(or0Var.c)) {
                return RequestBody.create(d(or0Var.b, a), or0Var.c);
            }
            return RequestBody.create((MediaType) null, new byte[0]);
        }
        return (RequestBody) invokeL.objValue;
    }

    public static RequestBody b(@NonNull or0 or0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, or0Var)) == null) {
            if (or0Var.e != null) {
                return RequestBody.create(d(or0Var.b, b), or0Var.e);
            }
            return RequestBody.create((MediaType) null, new byte[0]);
        }
        return (RequestBody) invokeL.objValue;
    }

    public static RequestBody c(@NonNull or0 or0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, or0Var)) == null) {
            if (!t01.h(or0Var.f)) {
                FormBody.Builder builder = new FormBody.Builder();
                for (Map.Entry<String, String> entry : or0Var.f.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                        builder.add(entry.getKey(), entry.getValue());
                    }
                }
                return builder.build();
            }
            return RequestBody.create((MediaType) null, new byte[0]);
        }
        return (RequestBody) invokeL.objValue;
    }

    public static MediaType d(@NonNull String str, MediaType mediaType) {
        InterceptResult invokeLL;
        MediaType mediaType2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, mediaType)) == null) {
            if (!TextUtils.isEmpty(str)) {
                mediaType2 = MediaType.parse(str);
            } else {
                mediaType2 = null;
            }
            if (mediaType2 != null || mediaType == null) {
                return mediaType2;
            }
            return mediaType;
        }
        return (MediaType) invokeLL.objValue;
    }

    public static RequestBody e(@NonNull or0 or0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, or0Var)) == null) {
            int i = a.b[or0Var.a.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return RequestBody.create((MediaType) null, new byte[0]);
                        }
                        return c(or0Var);
                    }
                    return b(or0Var);
                }
                return f(or0Var);
            }
            return a(or0Var);
        }
        return (RequestBody) invokeL.objValue;
    }

    public static RequestBody g(@NonNull String str, or0 or0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, or0Var)) == null) {
            if (or0Var == null) {
                return null;
            }
            int i = a.a[RequestMethod.reverse(str).ordinal()];
            if (i != 3 && i != 4 && i != 5 && i != 6) {
                return null;
            }
            return e(or0Var);
        }
        return (RequestBody) invokeLL.objValue;
    }
}
