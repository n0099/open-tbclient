package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gob;
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
/* loaded from: classes7.dex */
public class mob implements eob {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final Context b;
    public final String c;
    public final bob d;
    public final oob e;
    public final pob f;
    public final Map<String, String> g;
    public final List<wob> h;
    public final Map<String, String> i;

    public mob(Context context, String str, bob bobVar, InputStream inputStream, Map<String, String> map, List<wob> list, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, bobVar, inputStream, map, list, str2};
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
            this.e = new sob(inputStream, str);
            kob.a(inputStream);
        } else {
            this.e = new vob(this.b, str);
        }
        this.f = new pob(this.e);
        if (bobVar != bob.b && "1.0".equals(this.e.a("/configuration_version", null))) {
            throw new RuntimeException("The file version does not match,please download the latest agconnect-services.json from the AGC website.");
        }
        this.d = (bobVar == null || bobVar == bob.b) ? kob.f(this.e.a("/region", null), this.e.a("/agcgw/url", null)) : bobVar;
        this.g = kob.d(map);
        this.h = list;
        this.a = str2 == null ? e() : str2;
    }

    @Override // com.baidu.tieba.eob
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? f(str, null) : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.eob
    public bob b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            bob bobVar = this.d;
            return bobVar == null ? bob.b : bobVar;
        }
        return (bob) invokeV.objValue;
    }

    public final String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            Map<String, gob.a> a = gob.a();
            if (a.containsKey(str)) {
                if (this.i.containsKey(str)) {
                    return this.i.get(str);
                }
                gob.a aVar = a.get(str);
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

    public List<wob> d() {
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
            String e = kob.e(str);
            String str3 = this.g.get(e);
            if (str3 != null) {
                return str3;
            }
            String c = c(e);
            if (c != null) {
                return c;
            }
            String a = this.e.a(e, str2);
            return pob.c(a) ? this.f.a(a, str2) : a;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.eob
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.eob
    public String getIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (String) invokeV.objValue;
    }
}
