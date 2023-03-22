package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class my6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsADFragment a;
    public BdTypeRecyclerView b;
    public py6 c;
    public lw6 d;
    public List<tm> e;

    public my6(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsADFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new ArrayList();
        this.a = frsADFragment;
        this.b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c = new py6(this.a.getPageContext(), oy6.h, this.a.getUniqueId());
            this.d = new lw6(this.a.getPageContext(), mw6.b);
            this.e.add(this.c);
            this.e.add(this.d);
            e();
            this.b.addAdapters(this.e);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (tm tmVar : this.e) {
                if (tmVar instanceof ew6) {
                    ((ew6) tmVar).x();
                }
            }
        }
    }

    public void d(ArrayList<gn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || ListUtils.isEmpty(this.e) || this.a == null) {
            return;
        }
        for (tm tmVar : this.e) {
            if (tmVar instanceof ew6) {
                ((ew6) tmVar).E(this.a.getTbPageTag());
            }
        }
    }

    public void f(qn qnVar) {
        List<tm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, qnVar) == null) && (list = this.e) != null && list.size() != 0) {
            for (tm tmVar : this.e) {
                if (tmVar != null && (tmVar instanceof ew6)) {
                    tmVar.setOnAdapterItemClickListener(qnVar);
                }
            }
        }
    }
}
