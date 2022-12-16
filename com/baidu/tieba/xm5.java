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
public class xm5 extends vm5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ym5> b;
    public wm5 c;
    public String d;
    public String e;

    /* loaded from: classes6.dex */
    public class a extends q9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xm5 a;

        public a(xm5 xm5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xm5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xm5Var;
        }

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof an5)) {
                this.a.j((an5) obj);
            }
        }
    }

    public xm5(wm5 wm5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wm5Var};
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
        this.c = wm5Var;
    }

    @Override // com.baidu.tieba.vm5
    public wm5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (wm5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vm5
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b.size();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.vm5
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MultiDelPostNetModel multiDelPostNetModel = new MultiDelPostNetModel();
            zm5 zm5Var = new zm5();
            for (ym5 ym5Var : this.b.values()) {
                zm5Var.d(ym5Var.a());
                zm5Var.e(ym5Var.c());
                zm5Var.b(this.d);
                zm5Var.c(this.e);
                zm5Var.a(ym5Var.b());
            }
            multiDelPostNetModel.N(zm5Var);
            multiDelPostNetModel.setLoadDataCallBack(new a(this));
            multiDelPostNetModel.loadData();
        }
    }

    @Override // com.baidu.tieba.vm5
    public void f(ym5 ym5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, ym5Var) == null) && ym5Var != null && !TextUtils.isEmpty(ym5Var.b())) {
            this.b.put(ym5Var.b(), ym5Var);
        }
    }

    @Override // com.baidu.tieba.vm5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.d = str;
        }
    }

    @Override // com.baidu.tieba.vm5
    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.e = str;
        }
    }

    @Override // com.baidu.tieba.vm5
    public void i(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && !TextUtils.isEmpty(str)) {
            this.b.remove(str);
        }
    }

    public void j(an5 an5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, an5Var) == null) && d() != null) {
            d().h(an5Var);
        }
    }
}
