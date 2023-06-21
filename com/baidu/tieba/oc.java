package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class oc implements vc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object a;

    public oc(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (obj != null && obj.getClass().isArray()) {
            this.a = obj;
        }
    }

    @Override // com.baidu.tieba.vc
    public Object a(ee eeVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eeVar)) == null) {
            Object f = f(eeVar);
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

    @Override // com.baidu.tieba.vc
    public Object b(ee eeVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eeVar)) == null) {
            return this.a;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.vc
    public Object c(ee eeVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eeVar)) == null) {
            return this.a;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.vc
    public Object e(ee eeVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eeVar)) == null) {
            return d(eeVar);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.vc
    public Object d(ee eeVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, eeVar)) == null) {
            Object obj = this.a;
            if (obj != null) {
                Class<?> componentType = obj.getClass().getComponentType();
                if (componentType == Boolean.TYPE) {
                    return this.a;
                }
                if (componentType == Byte.TYPE) {
                    return this.a;
                }
                if (componentType == Character.TYPE) {
                    return this.a;
                }
                if (componentType == Double.TYPE) {
                    return this.a;
                }
                if (componentType == Float.TYPE) {
                    return this.a;
                }
                if (componentType == Integer.TYPE) {
                    return this.a;
                }
                if (componentType == Long.TYPE) {
                    return this.a;
                }
                if (componentType == Short.TYPE) {
                    return this.a;
                }
                if (componentType == String.class) {
                    return this.a;
                }
                int length = Array.getLength(this.a);
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < length; i++) {
                    Object f = he.a(Array.get(this.a, i)).f(new ee(componentType));
                    if (f != null) {
                        jSONArray.put(f);
                    }
                }
                return jSONArray.toString();
            }
            return null;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.vc
    public Object f(ee eeVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eeVar)) == null) {
            Object obj = this.a;
            if (obj != null) {
                Class<?> componentType = obj.getClass().getComponentType();
                if (componentType == Character.TYPE) {
                    return String.valueOf((char[]) this.a);
                }
                if (componentType == Byte.TYPE) {
                    try {
                        oi.k((byte[]) this.a, 0);
                    } catch (Exception unused) {
                        return null;
                    }
                } else {
                    int length = Array.getLength(this.a);
                    JSONArray jSONArray = new JSONArray();
                    for (int i = 0; i < length; i++) {
                        Object f = he.a(Array.get(this.a, i)).f(new ee(componentType));
                        if (f != null) {
                            jSONArray.put(f);
                        }
                    }
                    return jSONArray;
                }
            }
            return null;
        }
        return invokeL.objValue;
    }
}
