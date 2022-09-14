package com.baidu.tieba;

import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class kd implements bd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<?> a;

    public kd(SparseArray<?> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sparseArray};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = sparseArray;
    }

    @Override // com.baidu.tieba.bd
    public Object a(re reVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, reVar)) == null) {
            Object f = f(reVar);
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

    @Override // com.baidu.tieba.bd
    public Object b(re reVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, reVar)) == null) ? this.a : invokeL.objValue;
    }

    @Override // com.baidu.tieba.bd
    public Object c(re reVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, reVar)) == null) ? this.a : invokeL.objValue;
    }

    @Override // com.baidu.tieba.bd
    public Object d(re reVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, reVar)) == null) {
            Object f = f(reVar);
            if (f == null || !(f instanceof JSONObject)) {
                return null;
            }
            return f.toString();
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.bd
    public Object e(re reVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, reVar)) == null) ? d(reVar) : invokeL.objValue;
    }

    @Override // com.baidu.tieba.bd
    public Object f(re reVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, reVar)) == null) {
            Type[] b = reVar.b();
            JSONObject jSONObject = new JSONObject();
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.a.keyAt(i);
                Object obj = this.a.get(keyAt);
                if (obj != null) {
                    if (b != null && b.length >= 1) {
                        Object f = ue.a(obj).f(new re(b[0]));
                        if (f != null) {
                            try {
                                jSONObject.put(String.valueOf(keyAt), f);
                            } catch (JSONException unused) {
                            }
                        }
                    } else {
                        Object f2 = ue.a(obj).f(new re(reVar.a()));
                        if (f2 != null) {
                            jSONObject.put(String.valueOf(keyAt), f2);
                        }
                    }
                }
            }
            return jSONObject;
        }
        return invokeL.objValue;
    }
}
