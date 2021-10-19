package com.bytedance.sdk.component.b.b.a.c;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.http.impl.cookie.DateUtils;
import org.apache.http.impl.cookie.NetscapeDraftSpec;
/* loaded from: classes9.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<DateFormat> f64904a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f64905b;

    /* renamed from: c  reason: collision with root package name */
    public static final DateFormat[] f64906c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-952329392, "Lcom/bytedance/sdk/component/b/b/a/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-952329392, "Lcom/bytedance/sdk/component/b/b/a/c/d;");
                return;
            }
        }
        f64904a = new ThreadLocal<DateFormat>() { // from class: com.bytedance.sdk.component.b.b.a.c.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.lang.ThreadLocal
            /* renamed from: a */
            public DateFormat initialValue() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                    simpleDateFormat.setLenient(false);
                    simpleDateFormat.setTimeZone(com.bytedance.sdk.component.b.b.a.c.f64895g);
                    return simpleDateFormat;
                }
                return (DateFormat) invokeV.objValue;
            }
        };
        String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", DateUtils.PATTERN_RFC1036, DateUtils.PATTERN_ASCTIME, NetscapeDraftSpec.EXPIRES_PATTERN, "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f64905b = strArr;
        f64906c = new DateFormat[strArr.length];
    }

    public static Date a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str.length() == 0) {
                return null;
            }
            ParsePosition parsePosition = new ParsePosition(0);
            Date parse = f64904a.get().parse(str, parsePosition);
            if (parsePosition.getIndex() == str.length()) {
                return parse;
            }
            synchronized (f64905b) {
                int length = f64905b.length;
                for (int i2 = 0; i2 < length; i2++) {
                    DateFormat dateFormat = f64906c[i2];
                    if (dateFormat == null) {
                        dateFormat = new SimpleDateFormat(f64905b[i2], Locale.US);
                        dateFormat.setTimeZone(com.bytedance.sdk.component.b.b.a.c.f64895g);
                        f64906c[i2] = dateFormat;
                    }
                    parsePosition.setIndex(0);
                    Date parse2 = dateFormat.parse(str, parsePosition);
                    if (parsePosition.getIndex() != 0) {
                        return parse2;
                    }
                }
                return null;
            }
        }
        return (Date) invokeL.objValue;
    }

    public static String a(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, date)) == null) ? f64904a.get().format(date) : (String) invokeL.objValue;
    }
}
