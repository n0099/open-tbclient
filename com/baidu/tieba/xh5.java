package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.nh5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xh5 extends sh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nh5.c a;
    public TbPageContext b;
    public BdRecyclerView c;
    public PbListView d;

    public xh5(TbPageContext tbPageContext, BdRecyclerView bdRecyclerView, nh5.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdRecyclerView, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
        this.c = bdRecyclerView;
        this.a = cVar;
        PbListView pbListView = new PbListView(getActivity());
        this.d = pbListView;
        pbListView.b();
        this.d.q(R.color.transparent);
        this.d.u(this.a.a);
        this.d.N(this.a.b);
        this.d.z();
        this.d.I(R.dimen.tbfontsize33);
        this.d.G(SkinManager.getColor(R.color.CAM_X0107));
        this.d.C(R.color.CAM_X0110);
        this.d.t();
    }

    private Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            return this.b.getPageActivity();
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sh5
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a.g) {
                e();
            } else {
                d();
            }
        }
    }

    @Override // com.baidu.tieba.sh5
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c.setNextPage(this.d);
            this.d.S();
            this.d.E(this.a.c);
            this.d.D(null);
        }
    }

    @Override // com.baidu.tieba.sh5
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.setNextPage(this.d);
            this.d.f();
            this.d.E(this.a.e);
            this.d.D(null);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c.setNextPage(this.d);
            this.d.f();
            this.d.E(this.a.d);
            this.d.D(null);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c.setNextPage(this.d);
            this.d.f();
            this.d.E(this.a.f);
            this.d.D(this.a.h);
        }
    }

    @Override // com.baidu.tieba.vh5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.d.d(i);
        }
    }
}
