package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class ng7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<pm> a;
    public BdTypeListView b;
    public jg7 c;
    public lg7 d;

    public ng7(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        this.b = bdTypeListView;
        arrayList.add(new fg7(baseActivity.getPageContext(), gg7.d));
        this.a.add(new hg7(baseActivity.getPageContext(), ig7.c));
        this.a.add(new eg7(baseActivity.getPageContext(), ii7.c));
        this.a.add(new vf7(baseActivity.getPageContext(), wf7.b));
        this.a.add(new xf7(baseActivity.getPageContext(), yf7.g));
        this.a.add(new zf7(baseActivity.getPageContext()));
        jg7 jg7Var = new jg7(baseActivity.getPageContext(), kg7.e);
        this.c = jg7Var;
        this.a.add(jg7Var);
        lg7 lg7Var = new lg7(baseActivity.getPageContext(), mg7.d);
        this.d = lg7Var;
        this.a.add(lg7Var);
    }

    public List<pm> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.b) != null && (bdTypeListView.getAdapter2() instanceof tm)) {
            this.b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.onDestroy();
            this.d.onDestroy();
        }
    }
}
