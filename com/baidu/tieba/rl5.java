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
public class rl5 extends pl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, sl5> b;
    public ql5 c;
    public String d;
    public String e;

    /* loaded from: classes5.dex */
    public class a extends q9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl5 a;

        public a(rl5 rl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl5Var;
        }

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof ul5)) {
                this.a.j((ul5) obj);
            }
        }
    }

    public rl5(ql5 ql5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ql5Var};
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
        this.c = ql5Var;
    }

    @Override // com.baidu.tieba.pl5
    public ql5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (ql5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pl5
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b.size();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pl5
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MultiDelPostNetModel multiDelPostNetModel = new MultiDelPostNetModel();
            tl5 tl5Var = new tl5();
            for (sl5 sl5Var : this.b.values()) {
                tl5Var.d(sl5Var.a());
                tl5Var.e(sl5Var.c());
                tl5Var.b(this.d);
                tl5Var.c(this.e);
                tl5Var.a(sl5Var.b());
            }
            multiDelPostNetModel.G(tl5Var);
            multiDelPostNetModel.setLoadDataCallBack(new a(this));
            multiDelPostNetModel.loadData();
        }
    }

    @Override // com.baidu.tieba.pl5
    public void f(sl5 sl5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, sl5Var) == null) && sl5Var != null && !TextUtils.isEmpty(sl5Var.b())) {
            this.b.put(sl5Var.b(), sl5Var);
        }
    }

    @Override // com.baidu.tieba.pl5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.d = str;
        }
    }

    @Override // com.baidu.tieba.pl5
    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.e = str;
        }
    }

    @Override // com.baidu.tieba.pl5
    public void i(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && !TextUtils.isEmpty(str)) {
            this.b.remove(str);
        }
    }

    public void j(ul5 ul5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, ul5Var) == null) && d() != null) {
            d().h(ul5Var);
        }
    }
}
