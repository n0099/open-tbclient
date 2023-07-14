package com.baidu.tieba;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.multidelmenu.model.MultiDelPostNetModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes6.dex */
public class j26 extends h26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, k26> b;
    public i26 c;
    public String d;
    public String e;

    /* loaded from: classes6.dex */
    public class a extends k9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j26 a;

        public a(j26 j26Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j26Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j26Var;
        }

        @Override // com.baidu.tieba.k9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof m26)) {
                this.a.j((m26) obj);
            }
        }
    }

    public j26(i26 i26Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i26Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayMap();
        this.c = i26Var;
    }

    @Override // com.baidu.tieba.h26
    public i26 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (i26) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h26
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b.size();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.h26
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MultiDelPostNetModel multiDelPostNetModel = new MultiDelPostNetModel();
            l26 l26Var = new l26();
            for (k26 k26Var : this.b.values()) {
                l26Var.d(k26Var.a());
                l26Var.e(k26Var.c());
                l26Var.b(this.d);
                l26Var.c(this.e);
                l26Var.a(k26Var.b());
            }
            multiDelPostNetModel.c0(l26Var);
            multiDelPostNetModel.setLoadDataCallBack(new a(this));
            multiDelPostNetModel.loadData();
        }
    }

    @Override // com.baidu.tieba.h26
    public void f(k26 k26Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, k26Var) == null) && k26Var != null && !TextUtils.isEmpty(k26Var.b())) {
            this.b.put(k26Var.b(), k26Var);
        }
    }

    @Override // com.baidu.tieba.h26
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.d = str;
        }
    }

    @Override // com.baidu.tieba.h26
    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.e = str;
        }
    }

    @Override // com.baidu.tieba.h26
    public void i(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && !TextUtils.isEmpty(str)) {
            this.b.remove(str);
        }
    }

    public void j(m26 m26Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, m26Var) == null) && d() != null) {
            d().h(m26Var);
        }
    }
}
