package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class y78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<kn> a;
    public DetailInfoFragment b;
    public h08 c;
    public BdTypeRecyclerView d;
    public List<xn> e;
    public d88 f;
    public b88 g;
    public PbFirstFloorCommentAndPraiseAdapter h;
    public v28 i;
    public t28 j;
    public l38 k;
    public PbFirstFloorItemAdapter l;
    public k48 m;
    public kn n;
    public kn o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y78 a;

        public a(y78 y78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y78Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null && this.a.b.M() != null) {
                FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.b.getPageContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y78 a;

        public b(y78 y78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y78Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.qq_share_container) {
                    if (!this.a.f(11009)) {
                        return;
                    }
                    this.a.i(8);
                } else if (view2.getId() == R.id.share_num_container) {
                    if (!this.a.f(11009)) {
                        return;
                    }
                    this.a.i(3);
                } else if (this.a.b != null && this.a.b.J() != null && this.a.b.J().U3() != null) {
                    this.a.b.J().U3().onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends ik5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y78 a;

        public c(y78 y78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y78Var;
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
                return h68.d(this.a.h(), i, this.a.b.M());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements mj5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ y78 b;

        public d(y78 y78Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y78Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y78Var;
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

    public y78(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {detailInfoFragment, bdTypeRecyclerView};
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
        this.p = new a(this);
        this.q = new b(this);
        this.b = detailInfoFragment;
        this.d = bdTypeRecyclerView;
        k(detailInfoFragment, bdTypeRecyclerView);
    }

    public final void e(ks8 ks8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, ks8Var) == null) && ks8Var != null && this.c != null && ks8Var.getAdvertAppInfo() != null) {
            ks8Var.getAdvertAppInfo().i = new as4();
            if (this.c.z() != null) {
                ks8Var.getAdvertAppInfo().i.b = this.c.z().a();
            }
            ks8Var.getAdvertAppInfo().i.a = ks8Var.o1();
            if (this.c.l() != null && (l = this.c.l()) != null) {
                ks8Var.getAdvertAppInfo().i.c = l.getId();
                ks8Var.getAdvertAppInfo().i.d = l.getFirst_class();
                ks8Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                ks8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            ks8Var.getAdvertAppInfo().i.g = ks8Var.getAdvertAppInfo().g;
            ks8Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                return true;
            }
            TbadkCoreApplication.getInst().login(this.b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.b.R(), true, i)));
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            mk5.b(new c(this), new d(this, i));
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

    public final void j(DetailInfoFragment detailInfoFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, detailInfoFragment) == null) {
            this.n = zi8.l().a(detailInfoFragment.J().getBaseFragmentActivity(), AdvertAppInfo.x);
            this.o = zi8.l().a(detailInfoFragment.J().getBaseFragmentActivity(), AdvertAppInfo.z);
            this.a.add(this.n);
            this.a.add(this.o);
        }
    }

    public void n(h08 h08Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, h08Var) != null) || h08Var == null) {
            return;
        }
        this.c = h08Var;
        BdTypeRecyclerView bdTypeRecyclerView = this.d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f.U(h08Var);
        this.j.y(h08Var);
        this.k.w(h08Var);
        this.d.setData(g(h08Var));
    }

    public final List<xn> g(h08 h08Var) {
        InterceptResult invokeL;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, h08Var)) == null) {
            ks8 ks8Var = null;
            if (h08Var == null) {
                return null;
            }
            this.e = new ArrayList();
            Iterator<PostData> it = h08Var.H().iterator();
            while (true) {
                if (it.hasNext()) {
                    PostData next = it.next();
                    if (next instanceof PostData) {
                        postData = next;
                        if (postData.D() == 1) {
                            break;
                        }
                    }
                } else {
                    postData = null;
                    break;
                }
            }
            if (postData == null && h08Var.j() != null) {
                postData = h08Var.j();
            }
            if (postData != null) {
                this.e.add(postData);
            }
            b18 b18Var = new b18();
            ThreadData Q = h08Var.Q();
            b18Var.a = Q;
            if (Q != null && xi.isEmpty(Q.getForum_name())) {
                b18Var.a.setForum_name(h08Var.n());
            }
            this.e.add(b18Var);
            v08 v08Var = new v08(h08Var.Q(), h08Var.d());
            v08Var.b = true;
            this.e.add(v08Var);
            if (postData != null && postData.q0 != null && (h08Var.l() == null || !TextUtils.equals(h08Var.l().getName(), this.b.M().K0()) || !this.b.M().Q0())) {
                k08 k08Var = new k08(postData.q0);
                k08Var.b = this.b.M().F1();
                this.e.add(k08Var);
            }
            List<ks8> c0 = h08Var.c0();
            int i = 0;
            int i2 = -1;
            if (!em7.e(c0) && (ks8Var = (ks8) em7.d(c0, 0)) != null) {
                i2 = ks8Var.getPosition();
            }
            if (h08Var.f() != null) {
                g08 g08Var = new g08();
                g08Var.f(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                this.e.add(g08Var);
                if (PermissionUtil.isBrowseMode()) {
                    this.e.add(new w08());
                } else {
                    int i3 = 1;
                    for (ms4 ms4Var : h08Var.f()) {
                        if (c0 != null && i3 == i2) {
                            if (ks8Var != null) {
                                e(ks8Var);
                                em7.a(this.e, ks8Var);
                                i++;
                                if (ks8Var.getType() != AdvertAppInfo.x) {
                                    i3++;
                                }
                            }
                            if (i < c0.size() && (ks8Var = (ks8) em7.d(c0, i)) != null) {
                                i2 = ks8Var.getPosition();
                            }
                        }
                        em7.a(this.e, ms4Var);
                        i3++;
                        if (i3 == 4 && h08Var.D() != null) {
                            em7.a(this.e, h08Var.D());
                            i3++;
                        }
                    }
                }
            }
            return this.e;
        }
        return (List) invokeL.objValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            h08 h08Var = this.c;
            if (h08Var != null && h08Var.Q() != null) {
                return this.c.Q().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (bdTypeRecyclerView = this.d) != null && bdTypeRecyclerView.getAdapter() != null) {
            this.d.getListAdapter().notifyDataSetChanged();
        }
    }

    public void m() {
        d88 d88Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (d88Var = this.f) != null) {
            d88Var.notifyDataSetChanged();
        }
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, detailInfoFragment, bdTypeRecyclerView) == null) {
            AbsVideoPbFragment J = detailInfoFragment.J();
            this.f = new d88(J, J, PostData.M0);
            this.g = new b88(detailInfoFragment.getContext(), b18.b);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.J(), v08.f);
            this.h = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.H(this.q);
            this.i = new v28(detailInfoFragment.J(), g08.c);
            t28 t28Var = new t28(detailInfoFragment.J(), ms4.e);
            this.j = t28Var;
            t28Var.z(true);
            this.k = new l38(detailInfoFragment.J());
            this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), k08.c);
            k48 k48Var = new k48(detailInfoFragment.J(), w08.a);
            this.m = k48Var;
            k48Var.x(this.p);
            this.a.add(this.f);
            this.a.add(this.g);
            this.a.add(this.h);
            this.a.add(this.i);
            this.a.add(this.j);
            this.a.add(this.k);
            this.a.add(this.l);
            this.a.add(this.m);
            j(detailInfoFragment);
            bdTypeRecyclerView.a(this.a);
        }
    }
}
