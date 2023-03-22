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
/* loaded from: classes6.dex */
public class u6 {
    public static /* synthetic */ Interceptable $ic;
    public static final Locale d;
    public static boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public u6 a;
    public Locale b;
    public g7<String, String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448317292, "Lcom/baidu/tieba/u6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448317292, "Lcom/baidu/tieba/u6;");
                return;
            }
        }
        d = new Locale("", "", "");
        e = false;
    }

    public u6() {
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

    public static boolean a(t2 t2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, t2Var)) == null) {
            try {
                t2Var.m().close();
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
            g7<String, String> g7Var = new g7<>();
            this.c = g7Var;
            l7.a(g7Var, reader);
        }
    }

    public final void k(Locale locale) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, locale) == null) {
            this.b = locale;
            new u7(locale, !e);
        }
    }

    public static u6 b(t2 t2Var, Locale locale) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, t2Var, locale)) == null) {
            return d(t2Var, locale, "UTF-8");
        }
        return (u6) invokeLL.objValue;
    }

    public static u6 c(t2 t2Var, Locale locale, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, t2Var, locale, str)) == null) {
            return d(t2Var, locale, str);
        }
        return (u6) invokeLLL.objValue;
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
    public static u6 d(t2 t2Var, Locale locale, String str) {
        InterceptResult invokeLLL;
        u6 j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, t2Var, locale, str)) == null) {
            u6 u6Var = null;
            if (t2Var != null && locale != null && str != null) {
                Locale locale2 = locale;
                do {
                    List<Locale> e2 = e(locale2);
                    j = j(t2Var, str, e2, 0, u6Var);
                    if (j != null) {
                        Locale g = j.g();
                        boolean equals = g.equals(d);
                        if (!equals || g.equals(locale) || (e2.size() == 1 && g.equals(e2.get(0)))) {
                            break;
                        } else if (equals && u6Var == null) {
                            u6Var = j;
                        }
                    }
                    locale2 = f(locale2);
                } while (locale2 != null);
                return j;
            }
            throw null;
        }
        return (u6) invokeLLL.objValue;
    }

    public static List<Locale> e(Locale locale) {
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

    public static u6 i(t2 t2Var, String str, Locale locale) {
        InterceptResult invokeLLL;
        u6 u6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, t2Var, str, locale)) == null) {
            Reader reader = null;
            try {
                try {
                    t2 l = l(t2Var, locale);
                    if (a(l)) {
                        u6Var = new u6();
                        reader = l.r(str);
                        u6Var.h(reader);
                    } else {
                        u6Var = null;
                    }
                    if (u6Var != null) {
                        u6Var.k(locale);
                    }
                    return u6Var;
                } catch (IOException e2) {
                    throw new GdxRuntimeException(e2);
                }
            } finally {
                s7.a(reader);
            }
        }
        return (u6) invokeLLL.objValue;
    }

    public static u6 j(t2 t2Var, String str, List<Locale> list, int i, u6 u6Var) {
        InterceptResult invokeCommon;
        u6 u6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{t2Var, str, list, Integer.valueOf(i), u6Var})) == null) {
            Locale locale = list.get(i);
            if (i != list.size() - 1) {
                u6Var2 = j(t2Var, str, list, i + 1, u6Var);
            } else if (u6Var != null && locale.equals(d)) {
                return u6Var;
            } else {
                u6Var2 = null;
            }
            u6 i2 = i(t2Var, str, locale);
            if (i2 != null) {
                i2.a = u6Var2;
                return i2;
            }
            return u6Var2;
        }
        return (u6) invokeCommon.objValue;
    }

    public static t2 l(t2 t2Var, Locale locale) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, t2Var, locale)) == null) {
            t7 t7Var = new t7(t2Var.g());
            if (!locale.equals(d)) {
                String language = locale.getLanguage();
                String country = locale.getCountry();
                String variant = locale.getVariant();
                boolean equals = "".equals(language);
                boolean equals2 = "".equals(country);
                boolean equals3 = "".equals(variant);
                if (!equals || !equals2 || !equals3) {
                    t7Var.a('_');
                    if (!equals3) {
                        t7Var.n(language);
                        t7Var.a('_');
                        t7Var.n(country);
                        t7Var.a('_');
                        t7Var.n(variant);
                    } else if (!equals2) {
                        t7Var.n(language);
                        t7Var.a('_');
                        t7Var.n(country);
                    } else {
                        t7Var.n(language);
                    }
                }
            }
            t7Var.n(".properties");
            return t2Var.s(t7Var.toString());
        }
        return (t2) invokeLL.objValue;
    }
}
