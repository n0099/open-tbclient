package com.baidu.tieba;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class lc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<in> a;
    public TbPageContext b;
    public HTypeListView c;
    public jc9 d;
    public ic9 e;
    public hc9 f;

    public lc9(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, hTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.b = tbPageContext;
        this.c = hTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d = new jc9(this.b, hh5.d);
            this.e = new ic9(this.b, pc9.b);
            this.f = new hc9(this.b.getPageActivity(), dc9.d);
            this.a.add(this.d);
            this.a.add(this.e);
            this.a.add(this.f);
            this.c.a(this.a);
        }
    }

    public void b() {
        HTypeListView hTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (hTypeListView = this.c) != null && (hTypeListView.getAdapter() instanceof TypeAdapter)) {
            ((TypeAdapter) this.c.getAdapter()).notifyDataSetChanged();
        }
    }

    public void c(List<vn> list) {
        HTypeListView hTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (hTypeListView = this.c) != null) {
            hTypeListView.setData(list);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.d.u(onClickListener);
            this.e.u(onClickListener);
        }
    }
}
