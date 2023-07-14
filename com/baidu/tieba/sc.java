package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sc implements xc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Bundle a;

    public sc(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bundle;
    }

    @Override // com.baidu.tieba.xc
    public Object a(ge geVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, geVar)) == null) {
            Object f = f(geVar);
            if (f != null) {
                if (f instanceof JSONObject) {
                    return f.toString();
                }
                if (f instanceof JSONArray) {
                    return f.toString();
                }
                return f;
            }
            return null;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.xc
    public Object b(ge geVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, geVar)) == null) {
            return this.a;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.xc
    public Object c(ge geVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, geVar)) == null) {
            return this.a;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.xc
    public Object d(ge geVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, geVar)) == null) {
            return this.a;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.xc
    public Object e(ge geVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, geVar)) == null) {
            return d(geVar);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.xc
    public Object f(ge geVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, geVar)) == null) {
            Type[] b = geVar.b();
            Set<String> keySet = this.a.keySet();
            JSONObject jSONObject = new JSONObject();
            for (String str : keySet) {
                Object obj = this.a.get(str);
                if (b != null && b.length >= 2) {
                    try {
                        jSONObject.put(str, je.a(obj).f(new ge(b[1])));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        jSONObject.put(str, je.a(obj).f(new ge(geVar.a())));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return invokeL.objValue;
    }
}
