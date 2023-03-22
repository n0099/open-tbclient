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
/* loaded from: classes6.dex */
public class uc implements lc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<?> a;

    public uc(SparseArray<?> sparseArray) {
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

    @Override // com.baidu.tieba.lc
    public Object a(ud udVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, udVar)) == null) {
            Object f = f(udVar);
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

    @Override // com.baidu.tieba.lc
    public Object b(ud udVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, udVar)) == null) {
            return this.a;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.lc
    public Object c(ud udVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, udVar)) == null) {
            return this.a;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.lc
    public Object d(ud udVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, udVar)) == null) {
            Object f = f(udVar);
            if (f != null && (f instanceof JSONObject)) {
                return f.toString();
            }
            return null;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.lc
    public Object e(ud udVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, udVar)) == null) {
            return d(udVar);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.lc
    public Object f(ud udVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, udVar)) == null) {
            Type[] b = udVar.b();
            JSONObject jSONObject = new JSONObject();
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.a.keyAt(i);
                Object obj = this.a.get(keyAt);
                if (obj != null) {
                    if (b != null && b.length >= 1) {
                        Object f = xd.a(obj).f(new ud(b[0]));
                        if (f != null) {
                            try {
                                jSONObject.put(String.valueOf(keyAt), f);
                            } catch (JSONException unused) {
                            }
                        }
                    } else {
                        Object f2 = xd.a(obj).f(new ud(udVar.a()));
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
