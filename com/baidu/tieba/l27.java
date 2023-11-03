package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class l27 implements qa7 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<Integer> d;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public TbPageContext b;
    public String c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947891064, "Lcom/baidu/tieba/l27;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947891064, "Lcom/baidu/tieba/l27;");
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        d = arrayList;
        arrayList.add(2);
        d.add(8);
        d.add(6);
        d.add(7);
        d.add(14);
    }

    public l27(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = i;
    }

    @Override // com.baidu.tieba.qa7
    @NonNull
    public List<ya7<?, ?>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < yb9.a.size(); i++) {
                int keyAt = yb9.a.keyAt(i);
                if (keyAt != 17 && keyAt != 33 && keyAt != 34) {
                    n27 n27Var = new n27(keyAt, this.a);
                    n27Var.f(this.b);
                    n27Var.e(this.c);
                    arrayList.add(n27Var);
                } else {
                    for (Integer num : d) {
                        n27 n27Var2 = new n27(keyAt, num.intValue(), this.a);
                        n27Var2.f(this.b);
                        n27Var2.e(this.c);
                        arrayList.add(n27Var2);
                    }
                }
            }
            arrayList.add(new o27());
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public l27 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (l27) invokeL.objValue;
    }

    public l27 c(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext)) == null) {
            this.b = tbPageContext;
            return this;
        }
        return (l27) invokeL.objValue;
    }
}
