package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.jv5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class tv5 extends ov5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jv5.c a;
    public TbPageContext b;
    public BdRecyclerView c;
    public PbListView d;

    public tv5(TbPageContext tbPageContext, BdRecyclerView bdRecyclerView, jv5.c cVar) {
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
        pbListView.c();
        this.d.s(R.color.transparent);
        this.d.w(this.a.a);
        this.d.P(this.a.b);
        this.d.B();
        this.d.L(R.dimen.tbfontsize33);
        this.d.J(SkinManager.getColor(R.color.CAM_X0107));
        this.d.F(R.color.CAM_X0110);
        this.d.v();
    }

    private Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            return this.b.getPageActivity();
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ov5
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

    @Override // com.baidu.tieba.ov5
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c.setNextPage(this.d);
            this.d.U();
            this.d.H(this.a.c);
            this.d.G(null);
        }
    }

    @Override // com.baidu.tieba.ov5
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.setNextPage(this.d);
            this.d.g();
            this.d.H(this.a.e);
            this.d.G(null);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c.setNextPage(this.d);
            this.d.g();
            this.d.H(this.a.d);
            this.d.G(null);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c.setNextPage(this.d);
            this.d.g();
            this.d.H(this.a.f);
            this.d.G(this.a.h);
        }
    }

    @Override // com.baidu.tieba.rv5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.d.e(i);
        }
    }
}
