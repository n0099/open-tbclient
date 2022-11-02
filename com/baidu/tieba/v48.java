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
/* loaded from: classes6.dex */
public class v48 extends s48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y48 A;
    public PbFirstFloorItemAdapter B;
    public jn C;
    public jn D;
    public View.OnClickListener E;
    public sz7 n;
    public z48 o;
    public PbFirstFloorCommentAndPraiseAdapter p;
    public w48 q;
    public PbFirstFloorEnterForumAdapter r;
    public x08 s;
    public PbReplyLoadMoreAdapter t;
    public s08 u;
    public j08 v;
    public k08 w;
    public rz7 x;
    public pz7 y;
    public h08 z;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v48 a;

        public a(v48 v48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v48Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091b65) {
                    if (this.a.L(11009)) {
                        this.a.N(8);
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091ee2 && this.a.L(11009)) {
                    this.a.N(3);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends gj5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v48 a;

        public b(v48 v48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gj5
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
                return d38.d(this.a.M(), i, this.a.b.K());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements li5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ v48 b;

        public c(v48 v48Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v48Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v48Var;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.li5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.b.b.getContext(), this.a, shareItem, false));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v48(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    @Override // com.baidu.tieba.s48
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            super.A(onClickListener);
            this.n.e(onClickListener);
            this.s.e(onClickListener);
            this.t.w(onClickListener);
        }
    }

    @Override // com.baidu.tieba.s48
    public void B(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.v.w(onClickListener);
        }
    }

    @Override // com.baidu.tieba.s48
    public void C(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.w.w(onClickListener);
        }
    }

    @Override // com.baidu.tieba.s48
    public void D(dx7 dx7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dx7Var) == null) {
            this.s.r(dx7Var);
        }
    }

    @Override // com.baidu.tieba.s48
    public void E(fy7 fy7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fy7Var) == null) {
            super.E(fy7Var);
            this.n.u0(fy7Var);
        }
    }

    @Override // com.baidu.tieba.s48
    public void F(dx7 dx7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dx7Var) == null) {
            this.o.U(dx7Var);
        }
    }

    @Override // com.baidu.tieba.s48
    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.o.o(str);
        }
    }

    @Override // com.baidu.tieba.s48
    public void p(boolean z) {
        jn jnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && (jnVar = this.D) != null && (jnVar instanceof rf8)) {
            ((rf8) jnVar).setIsFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.s48
    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            super.v(onClickListener);
            this.n.k(onClickListener);
        }
    }

    @Override // com.baidu.tieba.s48
    public void w(boolean z) {
        sz7 sz7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048595, this, z) == null) && (sz7Var = this.n) != null) {
            sz7Var.t0(z);
        }
    }

    @Override // com.baidu.tieba.s48
    public void x(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, yVar) == null) {
            super.x(yVar);
            this.n.n(yVar);
        }
    }

    @Override // com.baidu.tieba.s48
    public void y(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onLongClickListener) == null) {
            super.y(onLongClickListener);
            this.n.d(onLongClickListener);
        }
    }

    @Override // com.baidu.tieba.s48
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
            TbadkCoreApplication.getInst().login(this.b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.b.P(), true, i)));
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void N(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            kj5.b(new b(this), new c(this, i));
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
            dx7 dx7Var = this.d;
            if (dx7Var != null && dx7Var.Q() != null) {
                return this.d.Q().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.s48
    public x08 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.s;
        }
        return (x08) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s48
    public sz7 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.n;
        }
        return (sz7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s48
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.p;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s48
    public void m() {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (z48Var = this.o) != null) {
            z48Var.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.s48
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            x08 x08Var = this.s;
            if (x08Var != null) {
                x08Var.onDestroy();
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
            AbsVideoPbFragment B = this.b.B();
            this.o = new z48(B, B, PostData.L0);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(this.b.B(), rx7.f);
            this.p = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.H(this.E);
            this.q = new w48(this.b.getContext(), yx7.b);
            this.r = new PbFirstFloorEnterForumAdapter(this.b, fx7.i);
            this.s = new x08(this.b.B(), qx7.i);
            this.v = new j08(this.b.B(), jx7.c, this.b.getUniqueId());
            this.w = new k08(this.b.B(), kx7.a);
            this.u = new s08(this.b.B(), nx7.b1);
            this.x = new rz7(this.b.B(), cx7.c);
            pz7 pz7Var = new pz7(this.b.B(), is4.e);
            this.y = pz7Var;
            pz7Var.z(true);
            this.z = new h08(this.b.B());
            sz7 sz7Var = new sz7(this.b.B(), PostData.M0);
            this.n = sz7Var;
            sz7Var.v0(this.b.B());
            this.t = new PbReplyLoadMoreAdapter(this.b.B(), PostData.T0);
            this.C = vf8.l().a(this.b.B().getBaseFragmentActivity(), AdvertAppInfo.x);
            this.D = vf8.l().a(this.b.B().getBaseFragmentActivity(), AdvertAppInfo.z);
            y48 y48Var = new y48(this.b.getPageContext(), ThreadData.TYPE_ITEM, this.b.getUniqueId());
            this.A = y48Var;
            y48Var.u(this.c);
            this.B = new PbFirstFloorItemAdapter(this.b.getContext(), gx7.c);
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
            this.e.add(new PbPrivateTitleAdapter(this.b.B()));
            this.c.a(this.e);
        }
    }

    @Override // com.baidu.tieba.s48
    public void q(dx7 dx7Var, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{dx7Var, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.n.r(dx7Var);
            this.n.setFromCDN(z);
            this.n.o(str);
            this.n.c(z2);
        }
    }
}
