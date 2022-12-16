package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.PbPrivateTitleAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorEnterForumAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class z78 extends w78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c88 A;
    public PbFirstFloorItemAdapter B;
    public kn C;
    public kn D;
    public View.OnClickListener E;
    public w28 n;
    public d88 o;
    public PbFirstFloorCommentAndPraiseAdapter p;
    public a88 q;
    public PbFirstFloorEnterForumAdapter r;
    public b48 s;
    public PbReplyLoadMoreAdapter t;
    public w38 u;
    public n38 v;
    public o38 w;
    public v28 x;
    public t28 y;
    public l38 z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z78 a;

        public a(z78 z78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z78Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.qq_share_container) {
                    if (this.a.L(11009)) {
                        this.a.N(8);
                    }
                } else if (view2.getId() == R.id.share_num_container && this.a.L(11009)) {
                    this.a.N(3);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends ik5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z78 a;

        public b(z78 z78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z78Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (ShareSwitch.isOn()) {
                    i = 1;
                } else {
                    i = 6;
                }
                return h68.d(this.a.M(), i, this.a.b.M());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements mj5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ z78 b;

        public c(z78 z78Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z78Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z78Var;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.b.b.getContext(), this.a, shareItem, false));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z78(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        super(detailInfoAndReplyFragment, bdTypeRecyclerView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {detailInfoAndReplyFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((DetailInfoAndReplyFragment) objArr2[0], (BdTypeRecyclerView) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.E = new a(this);
        O();
    }

    @Override // com.baidu.tieba.w78
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            super.A(onClickListener);
            this.n.e(onClickListener);
            this.s.e(onClickListener);
            this.t.w(onClickListener);
        }
    }

    @Override // com.baidu.tieba.w78
    public void B(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.v.w(onClickListener);
        }
    }

    @Override // com.baidu.tieba.w78
    public void C(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.w.w(onClickListener);
        }
    }

    @Override // com.baidu.tieba.w78
    public void D(h08 h08Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, h08Var) == null) {
            this.s.r(h08Var);
        }
    }

    @Override // com.baidu.tieba.w78
    public void E(j18 j18Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, j18Var) == null) {
            super.E(j18Var);
            this.n.w0(j18Var);
        }
    }

    @Override // com.baidu.tieba.w78
    public void F(h08 h08Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, h08Var) == null) {
            this.o.U(h08Var);
        }
    }

    @Override // com.baidu.tieba.w78
    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.o.o(str);
        }
    }

    @Override // com.baidu.tieba.w78
    public void p(boolean z) {
        kn knVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && (knVar = this.D) != null && (knVar instanceof vi8)) {
            ((vi8) knVar).setIsFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.w78
    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            super.v(onClickListener);
            this.n.k(onClickListener);
        }
    }

    @Override // com.baidu.tieba.w78
    public void w(boolean z) {
        w28 w28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048595, this, z) == null) && (w28Var = this.n) != null) {
            w28Var.v0(z);
        }
    }

    @Override // com.baidu.tieba.w78
    public void x(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, yVar) == null) {
            super.x(yVar);
            this.n.n(yVar);
        }
    }

    @Override // com.baidu.tieba.w78
    public void y(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onLongClickListener) == null) {
            super.y(onLongClickListener);
            this.n.d(onLongClickListener);
        }
    }

    @Override // com.baidu.tieba.w78
    public void z(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, fVar) == null) {
            super.z(fVar);
            this.s.z(fVar);
        }
    }

    public final boolean L(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                return true;
            }
            TbadkCoreApplication.getInst().login(this.b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.b.R(), true, i)));
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void N(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            mk5.b(new b(this), new c(this, i));
            StatisticItem statisticItem = new StatisticItem("c13833");
            statisticItem.param("obj_locate", 1);
            if (i == 3) {
                statisticItem.param("obj_type", 1);
            } else if (i == 8) {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            h08 h08Var = this.d;
            if (h08Var != null && h08Var.Q() != null) {
                return this.d.Q().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.w78
    public b48 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.s;
        }
        return (b48) invokeV.objValue;
    }

    @Override // com.baidu.tieba.w78
    public w28 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.n;
        }
        return (w28) invokeV.objValue;
    }

    @Override // com.baidu.tieba.w78
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.p;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // com.baidu.tieba.w78
    public void m() {
        d88 d88Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (d88Var = this.o) != null) {
            d88Var.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.w78
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            b48 b48Var = this.s;
            if (b48Var != null) {
                b48Var.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.p;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            AbsVideoPbFragment J = this.b.J();
            this.o = new d88(J, J, PostData.M0);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(this.b.J(), v08.f);
            this.p = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.H(this.E);
            this.q = new a88(this.b.getContext(), c18.b);
            this.r = new PbFirstFloorEnterForumAdapter(this.b, j08.i);
            this.s = new b48(this.b.J(), u08.i);
            this.v = new n38(this.b.J(), n08.c, this.b.getUniqueId());
            this.w = new o38(this.b.J(), o08.a);
            this.u = new w38(this.b.J(), r08.c1);
            this.x = new v28(this.b.J(), g08.c);
            t28 t28Var = new t28(this.b.J(), ms4.e);
            this.y = t28Var;
            t28Var.z(true);
            this.z = new l38(this.b.J());
            w28 w28Var = new w28(this.b.J(), PostData.N0);
            this.n = w28Var;
            w28Var.x0(this.b.J());
            this.t = new PbReplyLoadMoreAdapter(this.b.J(), PostData.U0);
            this.C = zi8.l().a(this.b.J().getBaseFragmentActivity(), AdvertAppInfo.x);
            this.D = zi8.l().a(this.b.J().getBaseFragmentActivity(), AdvertAppInfo.z);
            c88 c88Var = new c88(this.b.getPageContext(), ThreadData.TYPE_ITEM, this.b.getUniqueId());
            this.A = c88Var;
            c88Var.u(this.c);
            this.B = new PbFirstFloorItemAdapter(this.b.getContext(), k08.c);
            this.e.add(this.o);
            this.e.add(this.p);
            this.e.add(this.q);
            this.e.add(this.r);
            this.e.add(this.s);
            this.e.add(this.u);
            this.e.add(this.v);
            this.e.add(this.w);
            this.e.add(this.x);
            this.e.add(this.y);
            this.e.add(this.z);
            this.e.add(this.C);
            this.e.add(this.D);
            this.e.add(this.n);
            this.e.add(this.t);
            this.e.add(this.A);
            this.e.add(this.B);
            this.e.add(new PbPrivateTitleAdapter(this.b.J()));
            this.c.a(this.e);
        }
    }

    @Override // com.baidu.tieba.w78
    public void q(h08 h08Var, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{h08Var, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.n.r(h08Var);
            this.n.setFromCDN(z);
            this.n.o(str);
            this.n.c(z2);
        }
    }
}
