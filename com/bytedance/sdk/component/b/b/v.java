package com.bytedance.sdk.component.b.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public final class v {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f28635a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f28636b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final String f28637c;

    /* renamed from: d  reason: collision with root package name */
    public final String f28638d;

    /* renamed from: e  reason: collision with root package name */
    public final String f28639e;

    /* renamed from: f  reason: collision with root package name */
    public final String f28640f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(731369188, "Lcom/bytedance/sdk/component/b/b/v;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(731369188, "Lcom/bytedance/sdk/component/b/b/v;");
                return;
            }
        }
        f28635a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
        f28636b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    }

    public v(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28637c = str;
        this.f28638d = str2;
        this.f28639e = str3;
        this.f28640f = str4;
    }

    public static v a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            Matcher matcher = f28635a.matcher(str);
            if (matcher.lookingAt()) {
                String lowerCase = matcher.group(1).toLowerCase(Locale.US);
                String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
                Matcher matcher2 = f28636b.matcher(str);
                String str2 = null;
                for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
                    matcher2.region(end, str.length());
                    if (!matcher2.lookingAt()) {
                        return null;
                    }
                    String group = matcher2.group(1);
                    if (group != null && group.equalsIgnoreCase("charset")) {
                        String group2 = matcher2.group(2);
                        if (group2 != null) {
                            if (group2.startsWith("'") && group2.endsWith("'") && group2.length() > 2) {
                                group2 = group2.substring(1, group2.length() - 1);
                            }
                        } else {
                            group2 = matcher2.group(3);
                        }
                        if (str2 != null && !group2.equalsIgnoreCase(str2)) {
                            return null;
                        }
                        str2 = group2;
                    }
                }
                return new v(str, lowerCase, lowerCase2, str2);
            }
            return null;
        }
        return (v) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? (obj instanceof v) && ((v) obj).f28637c.equals(this.f28637c) : invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28637c.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f28637c : (String) invokeV.objValue;
    }

    public Charset a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a((Charset) null) : (Charset) invokeV.objValue;
    }

    public Charset a(Charset charset) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charset)) == null) {
            try {
                return this.f28640f != null ? Charset.forName(this.f28640f) : charset;
            } catch (IllegalArgumentException unused) {
                return charset;
            }
        }
        return (Charset) invokeL.objValue;
    }
}
