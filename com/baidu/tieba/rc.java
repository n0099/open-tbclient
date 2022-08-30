package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class rc implements nc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, Object> a;

    public rc(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = map;
    }

    @Override // com.baidu.tieba.nc
    public Object a(de deVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, deVar)) == null) {
            Object f = f(deVar);
            if (f != null) {
                if (f instanceof JSONObject) {
                    return f.toString();
                }
                return f instanceof JSONArray ? f.toString() : f;
            }
            return null;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.nc
    public Object b(de deVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, deVar)) == null) ? this.a : invokeL.objValue;
    }

    @Override // com.baidu.tieba.nc
    public Object c(de deVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, deVar)) == null) ? this.a : invokeL.objValue;
    }

    @Override // com.baidu.tieba.nc
    public Object d(de deVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, deVar)) == null) {
            Object f = f(deVar);
            if (f == null || !(f instanceof JSONObject)) {
                return null;
            }
            return f.toString();
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.nc
    public Object e(de deVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, deVar)) == null) ? d(deVar) : invokeL.objValue;
    }

    @Override // com.baidu.tieba.nc
    public Object f(de deVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, deVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.a == null) {
                return jSONObject;
            }
            Type[] b = deVar.b();
            for (String str : this.a.keySet()) {
                Object obj = this.a.get(str);
                if (b != null && b.length >= 2) {
                    try {
                        jSONObject.put(str, ge.a(obj).f(new de(b[1])));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        jSONObject.put(str, ge.a(obj).f(new de(deVar.a())));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return invokeL.objValue;
    }
}
