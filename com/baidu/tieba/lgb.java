package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fgb;
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
/* loaded from: classes6.dex */
public class lgb implements dgb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final Context b;
    public final String c;
    public final agb d;
    public final ngb e;
    public final ogb f;
    public final Map<String, String> g;
    public final List<vgb> h;
    public final Map<String, String> i;

    public lgb(Context context, String str, agb agbVar, InputStream inputStream, Map<String, String> map, List<vgb> list, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, agbVar, inputStream, map, list, str2};
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
            this.e = new rgb(inputStream, str);
            jgb.a(inputStream);
        } else {
            this.e = new ugb(this.b, str);
        }
        this.f = new ogb(this.e);
        if (agbVar != agb.b && "1.0".equals(this.e.a("/configuration_version", null))) {
            throw new RuntimeException("The file version does not match,please download the latest agconnect-services.json from the AGC website.");
        }
        this.d = (agbVar == null || agbVar == agb.b) ? jgb.f(this.e.a("/region", null), this.e.a("/agcgw/url", null)) : agbVar;
        this.g = jgb.d(map);
        this.h = list;
        this.a = str2 == null ? e() : str2;
    }

    @Override // com.baidu.tieba.dgb
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? f(str, null) : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.dgb
    public agb b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            agb agbVar = this.d;
            return agbVar == null ? agb.b : agbVar;
        }
        return (agb) invokeV.objValue;
    }

    public final String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            Map<String, fgb.a> a = fgb.a();
            if (a.containsKey(str)) {
                if (this.i.containsKey(str)) {
                    return this.i.get(str);
                }
                fgb.a aVar = a.get(str);
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

    public List<vgb> d() {
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
            String e = jgb.e(str);
            String str3 = this.g.get(e);
            if (str3 != null) {
                return str3;
            }
            String c = c(e);
            if (c != null) {
                return c;
            }
            String a = this.e.a(e, str2);
            return ogb.c(a) ? this.f.a(a, str2) : a;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.dgb
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dgb
    public String getIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (String) invokeV.objValue;
    }
}
