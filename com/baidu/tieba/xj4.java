package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class xj4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List a;

    public xj4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList(6);
    }

    public void a(ak4 ak4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, ak4Var) == null) && ak4Var != null && !this.a.contains(ak4Var)) {
            this.a.add(ak4Var);
        }
    }

    public Object b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<ak4> arrayList = new ArrayList();
            Iterator it = this.a.iterator();
            Object obj = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ak4 ak4Var = (ak4) it.next();
                Object obj2 = ak4Var.get();
                if (c(obj2)) {
                    obj = obj2;
                    break;
                }
                arrayList.add(ak4Var);
                obj = obj2;
            }
            if (arrayList.size() > 0) {
                for (ak4 ak4Var2 : arrayList) {
                    ak4Var2.put(obj);
                }
            }
            return obj;
        }
        return invokeV.objValue;
    }

    public final boolean c(Object obj) {
        InterceptResult invokeL;
        char[] charArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj == null || !(obj instanceof String)) {
                return false;
            }
            String str = (String) obj;
            if (str.length() != 32) {
                return false;
            }
            for (char c : str.toCharArray()) {
                if ((c < 'A' || c > 'Z') && (c < '0' || c > '9')) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void d(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, obj) != null) || c(obj)) {
            return;
        }
        for (ak4 ak4Var : this.a) {
            if (ak4Var.a()) {
                ak4Var.put(obj);
            }
        }
    }
}
