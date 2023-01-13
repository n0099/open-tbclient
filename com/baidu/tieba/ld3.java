package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public final class ld3 {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern a;
    public static final Pattern b;
    public static final SparseIntArray c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.d = -1;
            this.e = -1;
            this.f = -1;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a != -1 && this.b != -1 && this.c != -1 && this.d != -1 && this.e != -1 && this.f != -1) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947938990, "Lcom/baidu/tieba/ld3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947938990, "Lcom/baidu/tieba/ld3;");
                return;
            }
        }
        a = Pattern.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");
        b = Pattern.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");
        SparseIntArray sparseIntArray = new SparseIntArray();
        c = sparseIntArray;
        sparseIntArray.put(d("jan"), 0);
        c.put(d("feb"), 1);
        c.put(d("mar"), 2);
        c.put(d("apr"), 3);
        c.put(d("may"), 4);
        c.put(d("jun"), 5);
        c.put(d("jul"), 6);
        c.put(d("aug"), 7);
        c.put(d("sep"), 8);
        c.put(d("oct"), 9);
        c.put(d("nov"), 10);
        c.put(d("dec"), 11);
    }

    public static int a(@NonNull Matcher matcher, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, matcher, i)) == null) {
            try {
                String group = matcher.group(i);
                if (TextUtils.isEmpty(group)) {
                    return -1;
                }
                if (group.length() == 2) {
                    return ((group.charAt(0) - '0') * 10) + (group.charAt(1) - '0');
                }
                return group.charAt(0) - '0';
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeLI.intValue;
    }

    public static int b(@NonNull Matcher matcher, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, matcher, i)) == null) {
            try {
                return c.get(d(matcher.group(i)), -1);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeLI.intValue;
    }

    public static int c(@NonNull Matcher matcher, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, matcher, i)) == null) {
            try {
                String group = matcher.group(i);
                if (TextUtils.isEmpty(group)) {
                    return -1;
                }
                if (group.length() == 2) {
                    int charAt = ((group.charAt(0) - '0') * 10) + (group.charAt(1) - '0');
                    if (charAt >= 70) {
                        return charAt + FeatureCodes.SKY_SEG;
                    }
                    return charAt + 2000;
                } else if (group.length() == 3) {
                    return ((group.charAt(0) - '0') * 100) + ((group.charAt(1) - '0') * 10) + (group.charAt(2) - '0') + FeatureCodes.SKY_SEG;
                } else {
                    if (group.length() == 4) {
                        return ((group.charAt(0) - '0') * 1000) + ((group.charAt(1) - '0') * 100) + ((group.charAt(2) - '0') * 10) + (group.charAt(3) - '0');
                    }
                    return 1970;
                }
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeLI.intValue;
    }

    public static int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            int i = -1;
            if (!TextUtils.isEmpty(str) && str.length() >= 3) {
                for (int i2 = 0; i2 < 3; i2++) {
                    i += Character.toLowerCase(str.charAt(i2)) - 'a';
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static long e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1L;
            }
            b bVar = new b(null);
            Matcher matcher = a.matcher(str);
            if (matcher.find()) {
                bVar.c = a(matcher, 1);
                bVar.b = b(matcher, 2);
                bVar.a = c(matcher, 3);
                f(bVar, matcher, 4);
            } else {
                Matcher matcher2 = b.matcher(str);
                if (!matcher2.find()) {
                    return -1L;
                }
                bVar.b = b(matcher2, 1);
                bVar.c = a(matcher2, 2);
                f(bVar, matcher2, 3);
                bVar.a = c(matcher2, 4);
            }
            if (bVar.a()) {
                return -1L;
            }
            if (bVar.a >= 2038) {
                bVar.a = 2038;
                bVar.b = 0;
                bVar.c = 1;
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeZone(TimeZone.getTimeZone("UTC"));
            gregorianCalendar.set(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e, bVar.f);
            return gregorianCalendar.getTimeInMillis();
        }
        return invokeL.longValue;
    }

    public static void f(@NonNull b bVar, @NonNull Matcher matcher, int i) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65542, null, bVar, matcher, i) == null) {
            try {
                String group = matcher.group(i);
                if (TextUtils.isEmpty(group)) {
                    return;
                }
                int charAt = group.charAt(0) - '0';
                if (group.charAt(1) != ':') {
                    i2 = 2;
                    charAt = (charAt * 10) + (group.charAt(1) - '0');
                } else {
                    i2 = 1;
                }
                bVar.d = charAt;
                bVar.e = ((group.charAt(i3) - '0') * 10) + (group.charAt(i4) - '0');
                int i5 = i2 + 1 + 1 + 1 + 1;
                bVar.f = ((group.charAt(i5) - '0') * 10) + (group.charAt(i5 + 1) - '0');
            } catch (Exception unused) {
            }
        }
    }
}
