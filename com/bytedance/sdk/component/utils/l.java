package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile l f28903c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f28904a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f28905b;

    /* renamed from: d  reason: collision with root package name */
    public Context f28906d;

    public l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28905b = false;
        if (context != null && this.f28906d == null) {
            this.f28906d = context.getApplicationContext();
            a();
        }
        this.f28906d = context;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            int indexOf = str.indexOf(47);
            int indexOf2 = str.indexOf(59);
            if (indexOf < 0) {
                return null;
            }
            String lowerCase = str.substring(0, indexOf).trim().toLowerCase(Locale.ENGLISH);
            if (c(lowerCase)) {
                int i2 = indexOf + 1;
                if (indexOf2 < 0) {
                    substring = str.substring(i2);
                } else {
                    substring = str.substring(i2, indexOf2);
                }
                String lowerCase2 = substring.trim().toLowerCase(Locale.ENGLISH);
                if (c(lowerCase2)) {
                    StringBuilder sb = new StringBuilder(lowerCase.length() + lowerCase2.length() + 1);
                    sb.append(lowerCase);
                    sb.append('/');
                    sb.append(lowerCase2);
                    return sb.toString();
                }
                return null;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            int length = str.length();
            if (length == 0) {
                return false;
            }
            for (int i2 = 0; i2 < length; i2++) {
                if (!a(str.charAt(i2))) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private String d(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, str)) == null) {
            String e2 = e(str);
            if (e2.isEmpty()) {
                return null;
            }
            a();
            Map<String, String> map = this.f28904a;
            if (map == null || map.isEmpty()) {
                return null;
            }
            do {
                str2 = this.f28904a.get(e2);
                if (str2 == null) {
                    e2 = e(e2);
                }
                if (str2 != null) {
                    break;
                }
            } while (!e2.isEmpty());
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        int indexOf;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? (str == null || str.isEmpty() || (indexOf = str.indexOf(46)) < 0 || indexOf >= str.length() + (-1)) ? "" : str.substring(indexOf + 1) : (String) invokeL.objValue;
    }

    private void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, str) == null) {
            String trim = str.trim();
            if (trim.isEmpty()) {
                return;
            }
            if (trim.charAt(0) == '#') {
                return;
            }
            String replaceAll = trim.replaceAll("\\s*#.*", "");
            if (replaceAll.indexOf(61) > 0) {
                Matcher matcher = Pattern.compile("\\btype=(\"\\p{Graph}+?/\\p{Graph}+?\"|\\p{Graph}+/\\p{Graph}+\\b)").matcher(replaceAll);
                if (matcher.find()) {
                    String substring = matcher.group().substring(5);
                    if (substring.charAt(0) == '\"') {
                        substring = substring.substring(1, substring.length() - 1);
                    }
                    Matcher matcher2 = Pattern.compile("\\bexts=(\"[\\p{Graph}|\\p{Blank}]+?\"|\\p{Graph}+\\b)").matcher(replaceAll);
                    if (matcher2.find()) {
                        String substring2 = matcher2.group().substring(5);
                        if (substring2.charAt(0) == '\"') {
                            substring2 = substring2.substring(1, substring2.length() - 1);
                        }
                        for (String str2 : substring2.split("[\\p{Blank}|\\p{Punct}]+")) {
                            a(str2, substring);
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            String[] split = replaceAll.split("\\s+");
            for (int i2 = 1; i2 < split.length; i2++) {
                a(split[i2], split[0]);
            }
        }
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            if (str != null) {
                try {
                    if (str.startsWith("http") && str.contains("?")) {
                        str = str.split("\\?")[0];
                        if (str.endsWith("/")) {
                            str = str.substring(0, str.length() - 1);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            return a(context).a(str);
        }
        return (String) invokeLL.objValue;
    }

    public static l a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f28903c == null) {
                synchronized (l.class) {
                    if (f28903c == null) {
                        f28903c = new l(context);
                    }
                }
            }
            return f28903c;
        }
        return (l) invokeL.objValue;
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String d2 = d(str);
            if (TextUtils.isEmpty(d2)) {
                return null;
            }
            return b(d2);
        }
        return (String) invokeL.objValue;
    }

    public static boolean a(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 > ' ' && c2 < 127 && "()<>@,;:/[]?=\\\"".indexOf(c2) < 0 : invokeCommon.booleanValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || this.f28906d == null || this.f28905b) {
            return;
        }
        synchronized (this) {
            if (!this.f28905b) {
                List list = (List) AccessController.doPrivileged(new PrivilegedAction<List<String>>(this) { // from class: com.bytedance.sdk.component.utils.l.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ l f28907a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f28907a = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.security.PrivilegedAction
                    /* renamed from: a */
                    public List<String> run() {
                        InterceptResult invokeV;
                        BufferedReader bufferedReader;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                            return (List) invokeV.objValue;
                        }
                        InputStream inputStream = null;
                        try {
                            ArrayList arrayList = new ArrayList();
                            InputStream open = this.f28907a.f28906d.getAssets().open("tt_mime_type.pro");
                            try {
                                bufferedReader = new BufferedReader(new InputStreamReader(open));
                                while (true) {
                                    try {
                                        String readLine = bufferedReader.readLine();
                                        if (readLine == null) {
                                            break;
                                        } else if (!TextUtils.isEmpty(readLine)) {
                                            arrayList.add(readLine);
                                        }
                                    } catch (Throwable unused) {
                                        inputStream = open;
                                        try {
                                            List<String> emptyList = Collections.emptyList();
                                            if (bufferedReader != null) {
                                                try {
                                                    bufferedReader.close();
                                                } catch (Throwable unused2) {
                                                }
                                            }
                                            return emptyList;
                                        } finally {
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Throwable unused3) {
                                                }
                                            }
                                            if (bufferedReader != null) {
                                                try {
                                                    bufferedReader.close();
                                                } catch (Throwable unused4) {
                                                }
                                            }
                                        }
                                    }
                                }
                                if (open != null) {
                                    try {
                                        open.close();
                                    } catch (Throwable unused5) {
                                    }
                                }
                                try {
                                    bufferedReader.close();
                                } catch (Throwable unused6) {
                                }
                                return arrayList;
                            } catch (Throwable unused7) {
                                bufferedReader = null;
                            }
                        } catch (Throwable unused8) {
                            bufferedReader = null;
                        }
                    }
                });
                this.f28904a = new HashMap(list.size());
                String str = "";
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    String str2 = str + ((String) it.next());
                    if (str2.endsWith(IStringUtil.WINDOWS_FOLDER_SEPARATOR)) {
                        str = str2.substring(0, str2.length() - 1);
                    } else {
                        f(str2);
                        str = "";
                    }
                }
                if (!str.isEmpty()) {
                    f(str);
                }
                this.f28905b = true;
            }
        }
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, str, str2) == null) || str == null || str.isEmpty() || str2 == null || str2.isEmpty() || this.f28904a.containsKey(str)) {
            return;
        }
        this.f28904a.put(str, str2);
    }
}
