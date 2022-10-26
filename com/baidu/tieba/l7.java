package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes4.dex */
public class l7 {
    public static /* synthetic */ Interceptable $ic;
    public static final Locale d;
    public static boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public l7 a;
    public Locale b;
    public x7 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448308674, "Lcom/baidu/tieba/l7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448308674, "Lcom/baidu/tieba/l7;");
                return;
            }
        }
        d = new Locale("", "", "");
        e = false;
    }

    public l7() {
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

    public Locale g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (Locale) invokeV.objValue;
    }

    public static boolean a(k3 k3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, k3Var)) == null) {
            try {
                k3Var.m().close();
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static Locale f(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, locale)) == null) {
            Locale locale2 = Locale.getDefault();
            if (locale.equals(locale2)) {
                return null;
            }
            return locale2;
        }
        return (Locale) invokeL.objValue;
    }

    public void h(Reader reader) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, reader) == null) {
            x7 x7Var = new x7();
            this.c = x7Var;
            c8.a(x7Var, reader);
        }
    }

    public final void k(Locale locale) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, locale) == null) {
            this.b = locale;
            new l8(locale, !e);
        }
    }

    public static l7 b(k3 k3Var, Locale locale) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, k3Var, locale)) == null) {
            return d(k3Var, locale, "UTF-8");
        }
        return (l7) invokeLL.objValue;
    }

    public static l7 c(k3 k3Var, Locale locale, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, k3Var, locale, str)) == null) {
            return d(k3Var, locale, str);
        }
        return (l7) invokeLLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0085, code lost:
        throw new java.util.MissingResourceException("Can't find bundle for base file handle " + r9.j() + ", locale " + r10, r9 + "_" + r10, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static l7 d(k3 k3Var, Locale locale, String str) {
        InterceptResult invokeLLL;
        l7 j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, k3Var, locale, str)) == null) {
            l7 l7Var = null;
            if (k3Var != null && locale != null && str != null) {
                Locale locale2 = locale;
                do {
                    List e2 = e(locale2);
                    j = j(k3Var, str, e2, 0, l7Var);
                    if (j != null) {
                        Locale g = j.g();
                        boolean equals = g.equals(d);
                        if (!equals || g.equals(locale) || (e2.size() == 1 && g.equals(e2.get(0)))) {
                            break;
                        } else if (equals && l7Var == null) {
                            l7Var = j;
                        }
                    }
                    locale2 = f(locale2);
                } while (locale2 != null);
                return j;
            }
            throw null;
        }
        return (l7) invokeLLL.objValue;
    }

    public static List e(Locale locale) {
        InterceptResult invokeL;
        Locale locale2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, locale)) == null) {
            String language = locale.getLanguage();
            String country = locale.getCountry();
            String variant = locale.getVariant();
            ArrayList arrayList = new ArrayList(4);
            if (variant.length() > 0) {
                arrayList.add(locale);
            }
            if (country.length() > 0) {
                if (arrayList.isEmpty()) {
                    locale2 = locale;
                } else {
                    locale2 = new Locale(language, country);
                }
                arrayList.add(locale2);
            }
            if (language.length() > 0) {
                if (!arrayList.isEmpty()) {
                    locale = new Locale(language);
                }
                arrayList.add(locale);
            }
            arrayList.add(d);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static l7 i(k3 k3Var, String str, Locale locale) {
        InterceptResult invokeLLL;
        l7 l7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, k3Var, str, locale)) == null) {
            Reader reader = null;
            try {
                try {
                    k3 l = l(k3Var, locale);
                    if (a(l)) {
                        l7Var = new l7();
                        reader = l.r(str);
                        l7Var.h(reader);
                    } else {
                        l7Var = null;
                    }
                    if (l7Var != null) {
                        l7Var.k(locale);
                    }
                    return l7Var;
                } catch (IOException e2) {
                    throw new GdxRuntimeException(e2);
                }
            } finally {
                j8.a(reader);
            }
        }
        return (l7) invokeLLL.objValue;
    }

    public static l7 j(k3 k3Var, String str, List list, int i, l7 l7Var) {
        InterceptResult invokeCommon;
        l7 l7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{k3Var, str, list, Integer.valueOf(i), l7Var})) == null) {
            Locale locale = (Locale) list.get(i);
            if (i != list.size() - 1) {
                l7Var2 = j(k3Var, str, list, i + 1, l7Var);
            } else if (l7Var != null && locale.equals(d)) {
                return l7Var;
            } else {
                l7Var2 = null;
            }
            l7 i2 = i(k3Var, str, locale);
            if (i2 != null) {
                i2.a = l7Var2;
                return i2;
            }
            return l7Var2;
        }
        return (l7) invokeCommon.objValue;
    }

    public static k3 l(k3 k3Var, Locale locale) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, k3Var, locale)) == null) {
            k8 k8Var = new k8(k3Var.g());
            if (!locale.equals(d)) {
                String language = locale.getLanguage();
                String country = locale.getCountry();
                String variant = locale.getVariant();
                boolean equals = "".equals(language);
                boolean equals2 = "".equals(country);
                boolean equals3 = "".equals(variant);
                if (!equals || !equals2 || !equals3) {
                    k8Var.a('_');
                    if (!equals3) {
                        k8Var.n(language);
                        k8Var.a('_');
                        k8Var.n(country);
                        k8Var.a('_');
                        k8Var.n(variant);
                    } else if (!equals2) {
                        k8Var.n(language);
                        k8Var.a('_');
                        k8Var.n(country);
                    } else {
                        k8Var.n(language);
                    }
                }
            }
            k8Var.n(".properties");
            return k3Var.s(k8Var.toString());
        }
        return (k3) invokeLL.objValue;
    }
}
