package com.baidubce.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes6.dex */
public class DateUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static String DATA_TIME_AlternateIso8601_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static String DATA_TIME_Rfc822_FORMAT = "EEE, dd MMM yyyy HH:mm:ss 'GMT'";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1088407705, "Lcom/baidubce/util/DateUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1088407705, "Lcom/baidubce/util/DateUtils;");
        }
    }

    public DateUtils() {
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

    public static String alternateIso8601DateFormat(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, date)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATA_TIME_AlternateIso8601_FORMAT, Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat.format(Long.valueOf(date.getTime()));
        }
        return (String) invokeL.objValue;
    }

    public static Date parseAlternateIso8601Date(String str) throws ParseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATA_TIME_AlternateIso8601_FORMAT);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat.parse(str);
        }
        return (Date) invokeL.objValue;
    }

    public static Date parseRfc822Date(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATA_TIME_Rfc822_FORMAT, Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            new Date();
            try {
                return simpleDateFormat.parse(str);
            } catch (ParseException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Date) invokeL.objValue;
    }

    public static String rfc822DateFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? rfc822DateFormat(new Date()) : (String) invokeV.objValue;
    }

    public static String rfc822DateFormat(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, date)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATA_TIME_Rfc822_FORMAT, Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat.format(calendar.getTime());
        }
        return (String) invokeL.objValue;
    }
}
