package com.baidu.tieba;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class me1 implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public Uri b;
    public int c;
    public String[] d;
    public HashMap e;
    public boolean f;
    public me1 g;
    public boolean h;
    public JSONObject i;
    public String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947969680, "Lcom/baidu/tieba/me1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947969680, "Lcom/baidu/tieba/me1;");
                return;
            }
        }
        String str = ie1.b() + "://";
    }

    public me1(Uri uri, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.c = -1;
        this.f = false;
        this.h = false;
        this.a = str;
        this.b = uri;
        this.d = pe1.c(uri);
        this.e = pe1.b(uri.toString());
    }

    public me1(Uri uri, String str, String[] strArr, HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, str, strArr, hashMap};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.c = -1;
        this.f = false;
        this.h = false;
        this.b = uri;
        this.a = str;
        this.d = strArr;
        this.e = hashMap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public me1 clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Uri uri = this.b;
            me1 me1Var = new me1(uri, this.a, pe1.c(uri), (HashMap) this.e.clone());
            me1Var.g = this;
            me1Var.h = this.h;
            me1Var.j = this.j;
            return me1Var;
        }
        return (me1) invokeV.objValue;
    }

    public HashMap c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (HashMap) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        String path;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Uri uri = this.b;
            if (uri != null) {
                if (pe1.d(uri) && (path = this.b.getPath()) != null && path.length() > 1) {
                    return this.b.getPath().substring(1);
                }
                return this.b.getHost() + this.b.getPath();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            if (this.d != null) {
                if (z) {
                    this.c++;
                }
                int i = this.c;
                String[] strArr = this.d;
                if (i < strArr.length) {
                    return strArr[i];
                }
                return null;
            }
            return null;
        }
        return (String) invokeZ.objValue;
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f = z;
        }
    }

    public void f(String str, String str2) {
        Uri uri;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) && (uri = this.b) != null && str != null && str2 != null) {
            Uri parse = Uri.parse(uri.toString().replace(str, str2));
            this.b = parse;
            this.d = pe1.c(parse);
        }
    }
}
