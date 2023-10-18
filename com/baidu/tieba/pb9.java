package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.newinterest.fragment.BaseInterestedForumFragment;
import com.baidu.tieba.newinterest.model.InterestedForumModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes7.dex */
public class pb9 implements InterestedForumModel.d, cc9, View.OnClickListener, InterestedForumModel.c, bc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ob9 a;
    public final BaseInterestedForumFragment b;
    public final InterestedForumModel c;
    public final BdTypeRecyclerView d;
    public PbListView e;
    public final TBSpecificationBtn f;
    public final TBSpecificationBtn g;
    public final TbPageContext<BaseFragmentActivity> h;
    public boolean i;
    public tb9 j;
    public BdListView.p k;
    public View.OnClickListener l;

    /* loaded from: classes7.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pb9 a;

        public a(pb9 pb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pb9Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pb9 a;

        public b(pb9 pb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pb9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.k();
        }
    }

    public pb9(BaseInterestedForumFragment baseInterestedForumFragment, BdTypeRecyclerView bdTypeRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, InterestedForumModel interestedForumModel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseInterestedForumFragment, bdTypeRecyclerView, tBSpecificationBtn, tBSpecificationBtn2, tbPageContext, interestedForumModel, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = false;
        this.k = new a(this);
        this.l = new b(this);
        this.b = baseInterestedForumFragment;
        this.d = bdTypeRecyclerView;
        this.c = interestedForumModel;
        this.h = tbPageContext;
        this.g = tBSpecificationBtn;
        this.f = tBSpecificationBtn2;
        this.a = new ob9(tbPageContext.getPageActivity(), this.d);
        i();
        j();
    }

    public void h(List<sb9> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.c.q(list);
            this.c.m();
            if (!this.i) {
                this.c.g();
            }
        }
    }

    public void l(int i) {
        ob9 ob9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && (ob9Var = this.a) != null) {
            ob9Var.g(i);
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.a.b(z);
        }
    }

    @Override // com.baidu.tieba.cc9
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a.e()) {
                this.g.setEnabled(true);
                this.g.setText(this.d.getResources().getString(R.string.obfuscated_res_0x7f0f148b));
            } else {
                this.g.setEnabled(false);
                this.g.setText(this.d.getResources().getString(R.string.obfuscated_res_0x7f0f0aef));
            }
            b55 b55Var = new b55();
            this.f.setTextSize(R.dimen.T_X06);
            if (!this.a.f()) {
                this.f.setText(this.h.getString(R.string.obfuscated_res_0x7f0f0af5));
                b55Var.r(R.color.CAM_X0304);
                this.f.setConfig(b55Var);
                return;
            }
            this.f.setText(this.h.getString(R.string.obfuscated_res_0x7f0f0af7));
            b55Var.t(R.color.CAM_X0105);
            this.f.setConfig(b55Var);
        }
    }

    @Override // com.baidu.tieba.newinterest.model.InterestedForumModel.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.i) {
                this.i = true;
            } else if (UbsABTestHelper.isFirstLoginTestB()) {
                this.b.getActivity().setResult(-1);
                this.b.getActivity().finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.h.getPageActivity()).createNormalCfg(0)));
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            PbListView pbListView = new PbListView(this.d.getContext());
            this.e = pbListView;
            pbListView.a();
            this.e.s(R.color.CAM_X0601);
            this.e.B();
            this.e.J(SkinManager.getColor(R.color.CAM_X0109));
            this.e.L(R.dimen.tbfontsize33);
            this.e.F(R.color.CAM_X0110);
            this.e.G(this.l);
            this.d.setNextPage(this.e);
            n();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.e.I(this.d.getContext().getString(R.string.obfuscated_res_0x7f0f0af1), BdUtilHelper.getDimens(this.d.getContext(), R.dimen.tbds178));
            this.e.L(R.dimen.tbds36);
            this.e.F(R.color.CAM_X0109);
            this.e.g();
            this.e.G(null);
            this.e.P(BdUtilHelper.getDimens(this.d.getContext(), R.dimen.tbds217));
        }
    }

    @Override // com.baidu.tieba.newinterest.model.InterestedForumModel.d
    public void c(tb9 tb9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tb9Var) == null) {
            tb9 tb9Var2 = this.j;
            if (tb9Var2 != null && !ListUtils.isEmpty(tb9Var2.a)) {
                if (tb9Var != null) {
                    this.j.a.addAll(tb9Var.a);
                }
            } else {
                this.j = tb9Var;
            }
            if (tb9Var != null && !ListUtils.isEmpty(tb9Var.a)) {
                if (this.d.getVisibility() == 8) {
                    this.d.setVisibility(0);
                }
                this.a.j(tb9Var.a);
                this.b.d2();
            }
            if (!this.c.n()) {
                o();
            }
        }
    }

    public String g(List<yh> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                yh yhVar = list.get(i);
                if (yhVar instanceof ub9) {
                    ub9 ub9Var = (ub9) yhVar;
                    if (ub9Var.h()) {
                        if (sb.length() > 0) {
                            sb.append("|");
                        }
                        sb.append(ub9Var.c());
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bc9
    public void d(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            zb9.b(str);
            this.a.a(i, this.j, i2);
        }
    }

    public void f() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (bdTypeRecyclerView = this.d) != null) {
            bdTypeRecyclerView.setOnSrollToBottomListener(null);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.c.n()) {
            InterestedForumModel interestedForumModel = this.c;
            if (!interestedForumModel.f) {
                interestedForumModel.m();
                n();
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.d.setOnSrollToBottomListener(this.k);
            this.c.s(this);
            this.c.r(this);
            this.a.k(this);
            this.a.i(this);
            this.g.setOnClickListener(this);
            this.f.setOnClickListener(this);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.e.N();
            this.e.U();
            this.e.H(this.d.getContext().getString(R.string.list_loading));
            this.e.P(BdUtilHelper.getDimens(this.d.getContext(), R.dimen.tbds217));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            if (view2 == this.g) {
                List<yh> c = this.a.c();
                try {
                    this.c.i(c);
                    zb9.a(2, 1, this.b.c2(), "", g(c));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else if (view2 != this.f || gr5.a()) {
            } else {
                if (this.h.getString(R.string.obfuscated_res_0x7f0f0af5).equals(this.f.getText())) {
                    m(true);
                } else if (this.h.getString(R.string.obfuscated_res_0x7f0f0af7).equals(this.f.getText())) {
                    m(false);
                }
                a();
            }
        }
    }

    @Override // com.baidu.tieba.newinterest.model.InterestedForumModel.d
    public void onError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i, str) == null) {
            tb9 tb9Var = this.j;
            if (tb9Var != null && !ListUtils.isEmpty(tb9Var.a)) {
                PbListView pbListView = this.e;
                if (pbListView != null) {
                    pbListView.H(this.d.getContext().getString(R.string.pb_load_more));
                    this.e.g();
                    return;
                }
                return;
            }
            this.b.e2(str);
        }
    }
}
