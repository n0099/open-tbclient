package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
/* loaded from: classes5.dex */
public class pg3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public long e;
    public boolean f;
    public long g;
    public long h;
    public int i;

    /* loaded from: classes5.dex */
    public static final class a implements Comparator<pg3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(pg3 pg3Var, pg3 pg3Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, pg3Var, pg3Var2)) == null) {
                int length = pg3Var2.b.length() - pg3Var.b.length();
                if (length != 0) {
                    return length;
                }
                int length2 = pg3Var2.a.length() - pg3Var.a.length();
                if (length2 != 0) {
                    return length2;
                }
                int hashCode = pg3Var2.c.hashCode() - pg3Var.c.hashCode();
                if (hashCode != 0) {
                    return hashCode;
                }
                if (pg3Var2.d == null) {
                    return -1;
                }
                if (pg3Var.d == null) {
                    return 1;
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    public pg3() {
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

    public pg3(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = str2;
        this.e = -1L;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.a)) {
                if (!this.a.startsWith(".")) {
                    return str.equals(this.a);
                }
                if (str.endsWith(this.a.substring(1))) {
                    int length = this.a.length();
                    int length2 = str.length();
                    if (length2 > length - 1 && str.charAt(length2 - length) != '.') {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean b(pg3 pg3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pg3Var)) == null) {
            if (pg3Var == null || TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c) || !TextUtils.equals(this.a, pg3Var.a) || !TextUtils.equals(this.b, pg3Var.b) || !TextUtils.equals(this.c, pg3Var.c)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.b) || !str.startsWith(this.b)) {
                return false;
            }
            int length = this.b.length();
            int length2 = str.length();
            if (this.b.charAt(length - 1) != '/' && length2 > length && str.charAt(length) != '/') {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "domain: " + this.a + "; path: " + this.b + "; name: " + this.c + "; value: " + this.d + "; expires: " + this.e + "; secure: " + this.f;
        }
        return (String) invokeV.objValue;
    }
}
