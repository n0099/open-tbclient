package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class pc implements nc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<?> a;

    public pc(List<?> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = list;
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
            Type[] b = deVar.b();
            ArrayList arrayList = new ArrayList();
            for (Object obj : this.a) {
                if (obj != null) {
                    if (b != null && b.length >= 1) {
                        Object f = ge.a(obj).f(new de(b[0]));
                        if (f != null) {
                            arrayList.add(f.toString());
                        }
                    } else {
                        Object f2 = ge.a(obj).f(new de(deVar.a()));
                        if (f2 != null) {
                            arrayList.add(f2.toString());
                        }
                    }
                }
            }
            return arrayList;
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
            Type[] b = deVar.b();
            JSONArray jSONArray = new JSONArray();
            for (Object obj : this.a) {
                if (obj != null) {
                    if (b != null && b.length >= 1) {
                        Object f = ge.a(obj).f(new de(b[0]));
                        if (f != null) {
                            jSONArray.put(f);
                        }
                    } else {
                        Object f2 = ge.a(obj).f(new de(deVar.a()));
                        if (f2 != null) {
                            jSONArray.put(f2);
                        }
                    }
                }
            }
            return jSONArray;
        }
        return invokeL.objValue;
    }
}
