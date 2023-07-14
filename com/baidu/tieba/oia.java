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
public class oia implements dc7 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<Integer> d;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public TbPageContext b;
    public String c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948034594, "Lcom/baidu/tieba/oia;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948034594, "Lcom/baidu/tieba/oia;");
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

    public oia(int i) {
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

    @Override // com.baidu.tieba.dc7
    @NonNull
    public List<lc7<?, ?>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < wz8.a.size(); i++) {
                int keyAt = wz8.a.keyAt(i);
                if (keyAt != 17 && keyAt != 33 && keyAt != 34) {
                    qia qiaVar = new qia(keyAt, this.a);
                    qiaVar.f(this.b);
                    qiaVar.e(this.c);
                    arrayList.add(qiaVar);
                } else {
                    for (Integer num : d) {
                        qia qiaVar2 = new qia(keyAt, num.intValue(), this.a);
                        qiaVar2.f(this.b);
                        qiaVar2.e(this.c);
                        arrayList.add(qiaVar2);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public oia b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (oia) invokeL.objValue;
    }

    public oia c(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext)) == null) {
            this.b = tbPageContext;
            return this;
        }
        return (oia) invokeL.objValue;
    }
}
