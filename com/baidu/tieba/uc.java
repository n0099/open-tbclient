package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class uc implements nc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<?> a;

    public uc(Set<?> set) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {set};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = set;
    }

    @Override // com.baidu.tieba.nc
    public Object a(wd wdVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wdVar)) == null) {
            Object f = f(wdVar);
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

    @Override // com.baidu.tieba.nc
    public Object b(wd wdVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wdVar)) == null) {
            return this.a;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.nc
    public Object c(wd wdVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wdVar)) == null) {
            return this.a;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.nc
    public Object e(wd wdVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, wdVar)) == null) {
            return d(wdVar);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.nc
    public Object d(wd wdVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, wdVar)) == null) {
            Type[] b = wdVar.b();
            ArrayList arrayList = new ArrayList();
            for (Object obj : this.a) {
                if (obj != null) {
                    if (b != null && b.length >= 1) {
                        Object f = zd.a(obj).f(new wd(b[0]));
                        if (f != null) {
                            arrayList.add(f.toString());
                        }
                    } else {
                        Object f2 = zd.a(obj).f(new wd(wdVar.a()));
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
    public Object f(wd wdVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, wdVar)) == null) {
            Type[] b = wdVar.b();
            JSONArray jSONArray = new JSONArray();
            for (Object obj : this.a) {
                if (obj != null) {
                    if (b != null && b.length >= 1) {
                        Object f = zd.a(obj).f(new wd(b[0]));
                        if (f != null) {
                            jSONArray.put(f);
                        }
                    } else {
                        Object f2 = zd.a(obj).f(new wd(wdVar.a()));
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
