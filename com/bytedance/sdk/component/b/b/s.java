package com.bytedance.sdk.component.b.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes5.dex */
public final class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String[] f28704a;

    public s(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        List<String> list = aVar.f28705a;
        this.f28704a = (String[]) list.toArray(new String[list.size()]);
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? a(this.f28704a, str) : (String) invokeL.objValue;
    }

    public String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.f28704a[(i2 * 2) + 1] : (String) invokeI.objValue;
    }

    public a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            a aVar = new a();
            Collections.addAll(aVar.f28705a, this.f28704a);
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) ? (obj instanceof s) && Arrays.equals(((s) obj).f28704a, this.f28704a) : invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? Arrays.hashCode(this.f28704a) : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            StringBuilder sb = new StringBuilder();
            int a2 = a();
            for (int i2 = 0; i2 < a2; i2++) {
                sb.append(a(i2));
                sb.append(": ");
                sb.append(b(i2));
                sb.append("\n");
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f28705a;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28705a = new ArrayList(20);
        }

        private void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, this, str, str2) == null) {
                if (str != null) {
                    if (!str.isEmpty()) {
                        int length = str.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            char charAt = str.charAt(i2);
                            if (charAt <= ' ' || charAt >= 127) {
                                throw new IllegalArgumentException(com.bytedance.sdk.component.b.b.a.c.a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str));
                            }
                        }
                        if (str2 != null) {
                            int length2 = str2.length();
                            for (int i3 = 0; i3 < length2; i3++) {
                                char charAt2 = str2.charAt(i3);
                                if ((charAt2 <= 31 && charAt2 != '\t') || charAt2 >= 127) {
                                    throw new IllegalArgumentException(com.bytedance.sdk.component.b.b.a.c.a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i3), str, str2));
                                }
                            }
                            return;
                        }
                        throw new NullPointerException("value for name " + str + " == null");
                    }
                    throw new IllegalArgumentException("name is empty");
                }
                throw new NullPointerException("name == null");
            }
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                int indexOf = str.indexOf(":", 1);
                if (indexOf != -1) {
                    return b(str.substring(0, indexOf), str.substring(indexOf + 1));
                }
                if (str.startsWith(":")) {
                    return b("", str.substring(1));
                }
                return b("", str);
            }
            return (a) invokeL.objValue;
        }

        public a b(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
                this.f28705a.add(str);
                this.f28705a.add(str2.trim());
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a c(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
                try {
                    d(str, str2);
                } catch (Throwable unused) {
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        try {
                            StringBuilder sb = new StringBuilder();
                            int length = str2.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                char charAt = str2.charAt(i2);
                                if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                                    sb.append(URLEncoder.encode(String.valueOf(charAt), "UTF-8"));
                                } else {
                                    sb.append(charAt);
                                }
                            }
                            str2 = sb.toString();
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                            return this;
                        }
                    }
                    return this;
                }
                b(str);
                b(str, str2);
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                int i2 = 0;
                while (i2 < this.f28705a.size()) {
                    if (str.equalsIgnoreCase(this.f28705a.get(i2))) {
                        this.f28705a.remove(i2);
                        this.f28705a.remove(i2);
                        i2 -= 2;
                    }
                    i2 += 2;
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                try {
                    d(str, str2);
                } catch (Throwable unused) {
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        try {
                            StringBuilder sb = new StringBuilder();
                            int length = str2.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                char charAt = str2.charAt(i2);
                                if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                                    sb.append(URLEncoder.encode(String.valueOf(charAt), "UTF-8"));
                                } else {
                                    sb.append(charAt);
                                }
                            }
                            str2 = sb.toString();
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                            return this;
                        }
                    }
                    return this;
                }
                return b(str, str2);
            }
            return (a) invokeLL.objValue;
        }

        public s a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new s(this) : (s) invokeV.objValue;
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28704a.length / 2 : invokeV.intValue;
    }

    public Set<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
            int a2 = a();
            for (int i2 = 0; i2 < a2; i2++) {
                treeSet.add(a(i2));
            }
            return Collections.unmodifiableSet(treeSet);
        }
        return (Set) invokeV.objValue;
    }

    public String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f28704a[i2 * 2] : (String) invokeI.objValue;
    }

    public static String a(String[] strArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, strArr, str)) == null) {
            for (int length = strArr.length - 2; length >= 0; length -= 2) {
                if (str.equalsIgnoreCase(strArr[length])) {
                    return strArr[length + 1];
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public List<String> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            int a2 = a();
            ArrayList arrayList = null;
            for (int i2 = 0; i2 < a2; i2++) {
                if (str.equalsIgnoreCase(a(i2))) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(2);
                    }
                    arrayList.add(b(i2));
                }
            }
            if (arrayList != null) {
                return Collections.unmodifiableList(arrayList);
            }
            return Collections.emptyList();
        }
        return (List) invokeL.objValue;
    }
}
