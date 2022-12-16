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
/* loaded from: classes5.dex */
public class mi6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<kn> a;
    public BdTypeListView b;
    public ii6 c;
    public ki6 d;

    public mi6(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
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
        arrayList.add(new ei6(baseActivity.getPageContext(), fi6.d));
        this.a.add(new gi6(baseActivity.getPageContext(), hi6.c));
        this.a.add(new di6(baseActivity.getPageContext(), fk6.c));
        this.a.add(new uh6(baseActivity.getPageContext(), vh6.b));
        this.a.add(new wh6(baseActivity.getPageContext(), xh6.g));
        this.a.add(new yh6(baseActivity.getPageContext()));
        ii6 ii6Var = new ii6(baseActivity.getPageContext(), ji6.e);
        this.c = ii6Var;
        this.a.add(ii6Var);
        ki6 ki6Var = new ki6(baseActivity.getPageContext(), li6.d);
        this.d = ki6Var;
        this.a.add(ki6Var);
    }

    public List<kn> a() {
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.b) != null && (bdTypeListView.getAdapter2() instanceof on)) {
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
