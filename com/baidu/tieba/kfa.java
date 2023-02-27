package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.efa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class kfa implements cfa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final Context b;
    public final String c;
    public final zea d;
    public final mfa e;
    public final nfa f;
    public final Map<String, String> g;
    public final List<ufa> h;
    public final Map<String, String> i;

    public kfa(Context context, String str, zea zeaVar, InputStream inputStream, Map<String, String> map, List<ufa> list, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, zeaVar, inputStream, map, list, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new HashMap();
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.b = context;
        str = str == null ? context.getPackageName() : str;
        this.c = str;
        if (inputStream != null) {
            this.e = new qfa(inputStream, str);
            ifa.a(inputStream);
        } else {
            this.e = new tfa(this.b, str);
        }
        this.f = new nfa(this.e);
        if (zeaVar != zea.b && "1.0".equals(this.e.a("/configuration_version", null))) {
            throw new RuntimeException("The file version does not match,please download the latest agconnect-services.json from the AGC website.");
        }
        this.d = (zeaVar == null || zeaVar == zea.b) ? ifa.f(this.e.a("/region", null), this.e.a("/agcgw/url", null)) : zeaVar;
        this.g = ifa.d(map);
        this.h = list;
        this.a = str2 == null ? e() : str2;
    }

    @Override // com.baidu.tieba.cfa
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? f(str, null) : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.cfa
    public zea b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            zea zeaVar = this.d;
            return zeaVar == null ? zea.b : zeaVar;
        }
        return (zea) invokeV.objValue;
    }

    public final String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            Map<String, efa.a> a = efa.a();
            if (a.containsKey(str)) {
                if (this.i.containsKey(str)) {
                    return this.i.get(str);
                }
                efa.a aVar = a.get(str);
                if (aVar == null) {
                    return null;
                }
                String a2 = aVar.a(this);
                this.i.put(str, a2);
                return a2;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public List<ufa> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.h : (List) invokeV.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return String.valueOf(("{packageName='" + this.c + "', routePolicy=" + this.d + ", reader=" + this.e.toString().hashCode() + ", customConfigMap=" + new JSONObject(this.g).toString().hashCode() + '}').hashCode());
        }
        return (String) invokeV.objValue;
    }

    public String f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            if (str == null) {
                return str2;
            }
            String e = ifa.e(str);
            String str3 = this.g.get(e);
            if (str3 != null) {
                return str3;
            }
            String c = c(e);
            if (c != null) {
                return c;
            }
            String a = this.e.a(e, str2);
            return nfa.c(a) ? this.f.a(a, str2) : a;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.cfa
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cfa
    public String getIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (String) invokeV.objValue;
    }
}
