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
/* loaded from: classes5.dex */
public class mk5 extends kk5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, nk5> b;
    public lk5 c;
    public String d;
    public String e;

    /* loaded from: classes5.dex */
    public class a extends q9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mk5 a;

        public a(mk5 mk5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mk5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mk5Var;
        }

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof pk5)) {
                this.a.j((pk5) obj);
            }
        }
    }

    public mk5(lk5 lk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lk5Var};
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
        this.c = lk5Var;
    }

    @Override // com.baidu.tieba.kk5
    public lk5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (lk5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kk5
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b.size() : invokeV.intValue;
    }

    @Override // com.baidu.tieba.kk5
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MultiDelPostNetModel multiDelPostNetModel = new MultiDelPostNetModel();
            ok5 ok5Var = new ok5();
            for (nk5 nk5Var : this.b.values()) {
                ok5Var.d(nk5Var.a());
                ok5Var.e(nk5Var.c());
                ok5Var.b(this.d);
                ok5Var.c(this.e);
                ok5Var.a(nk5Var.b());
            }
            multiDelPostNetModel.G(ok5Var);
            multiDelPostNetModel.setLoadDataCallBack(new a(this));
            multiDelPostNetModel.loadData();
        }
    }

    @Override // com.baidu.tieba.kk5
    public void f(nk5 nk5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, nk5Var) == null) || nk5Var == null || TextUtils.isEmpty(nk5Var.b())) {
            return;
        }
        this.b.put(nk5Var.b(), nk5Var);
    }

    @Override // com.baidu.tieba.kk5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.d = str;
        }
    }

    @Override // com.baidu.tieba.kk5
    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.e = str;
        }
    }

    @Override // com.baidu.tieba.kk5
    public void i(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.b.remove(str);
    }

    public void j(pk5 pk5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, pk5Var) == null) || d() == null) {
            return;
        }
        d().h(pk5Var);
    }
}
