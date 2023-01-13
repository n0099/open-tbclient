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
/* loaded from: classes5.dex */
public class qc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ln> a;
    public DetailInfoFragment b;
    public y48 c;
    public BdTypeRecyclerView d;
    public List<yn> e;
    public vc8 f;
    public tc8 g;
    public PbFirstFloorCommentAndPraiseAdapter h;
    public m78 i;
    public k78 j;
    public c88 k;
    public PbFirstFloorItemAdapter l;
    public b98 m;
    public ln n;
    public ln o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qc8 a;

        public a(qc8 qc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qc8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null && this.a.b.M() != null) {
                FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.b.getPageContext());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qc8 a;

        public b(qc8 qc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qc8Var;
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
                } else if (this.a.b != null && this.a.b.J() != null && this.a.b.J().a4() != null) {
                    this.a.b.J().a4().onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends zk5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qc8 a;

        public c(qc8 qc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qc8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zk5
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
                return za8.d(this.a.h(), i, this.a.b.M());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements dk5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ qc8 b;

        public d(qc8 qc8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qc8Var;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dk5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.b.b.getContext(), this.a, shareItem, false));
            }
        }
    }

    public qc8(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public final void e(hx8 hx8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, hx8Var) == null) && hx8Var != null && this.c != null && hx8Var.getAdvertAppInfo() != null) {
            hx8Var.getAdvertAppInfo().i = new ks4();
            if (this.c.z() != null) {
                hx8Var.getAdvertAppInfo().i.b = this.c.z().a();
            }
            hx8Var.getAdvertAppInfo().i.a = hx8Var.r1();
            if (this.c.l() != null && (l = this.c.l()) != null) {
                hx8Var.getAdvertAppInfo().i.c = l.getId();
                hx8Var.getAdvertAppInfo().i.d = l.getFirst_class();
                hx8Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                hx8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            hx8Var.getAdvertAppInfo().i.g = hx8Var.getAdvertAppInfo().g;
            hx8Var.getAdvertAppInfo().i.h = false;
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
            TbadkCoreApplication.getInst().login(this.b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.b.S(), true, i)));
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            dl5.b(new c(this), new d(this, i));
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
            this.n = rn8.l().a(detailInfoFragment.J().getBaseFragmentActivity(), AdvertAppInfo.x);
            this.o = rn8.l().a(detailInfoFragment.J().getBaseFragmentActivity(), AdvertAppInfo.z);
            this.a.add(this.n);
            this.a.add(this.o);
        }
    }

    public void n(y48 y48Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, y48Var) != null) || y48Var == null) {
            return;
        }
        this.c = y48Var;
        BdTypeRecyclerView bdTypeRecyclerView = this.d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f.U(y48Var);
        this.j.y(y48Var);
        this.k.w(y48Var);
        this.d.setData(g(y48Var));
    }

    public final List<yn> g(y48 y48Var) {
        InterceptResult invokeL;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, y48Var)) == null) {
            hx8 hx8Var = null;
            if (y48Var == null) {
                return null;
            }
            this.e = new ArrayList();
            Iterator<PostData> it = y48Var.H().iterator();
            while (true) {
                if (it.hasNext()) {
                    PostData next = it.next();
                    if (next instanceof PostData) {
                        postData = next;
                        if (postData.F() == 1) {
                            break;
                        }
                    }
                } else {
                    postData = null;
                    break;
                }
            }
            if (postData == null && y48Var.j() != null) {
                postData = y48Var.j();
            }
            if (postData != null) {
                this.e.add(postData);
            }
            s58 s58Var = new s58();
            ThreadData Q = y48Var.Q();
            s58Var.a = Q;
            if (Q != null && yi.isEmpty(Q.getForum_name())) {
                s58Var.a.setForum_name(y48Var.n());
            }
            this.e.add(s58Var);
            m58 m58Var = new m58(y48Var.Q(), y48Var.d());
            m58Var.b = true;
            this.e.add(m58Var);
            if (postData != null && postData.q0 != null && (y48Var.l() == null || !TextUtils.equals(y48Var.l().getName(), this.b.M().K0()) || !this.b.M().Q0())) {
                b58 b58Var = new b58(postData.q0);
                b58Var.b = this.b.M().F1();
                this.e.add(b58Var);
            }
            List<hx8> c0 = y48Var.c0();
            int i = 0;
            int i2 = -1;
            if (!uq7.e(c0) && (hx8Var = (hx8) uq7.d(c0, 0)) != null) {
                i2 = hx8Var.getPosition();
            }
            if (y48Var.f() != null) {
                x48 x48Var = new x48();
                x48Var.f(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                this.e.add(x48Var);
                if (PermissionUtil.isBrowseMode()) {
                    this.e.add(new n58());
                } else {
                    int i3 = 1;
                    for (ws4 ws4Var : y48Var.f()) {
                        if (c0 != null && i3 == i2) {
                            if (hx8Var != null) {
                                e(hx8Var);
                                uq7.a(this.e, hx8Var);
                                i++;
                                if (hx8Var.getType() != AdvertAppInfo.x) {
                                    i3++;
                                }
                            }
                            if (i < c0.size() && (hx8Var = (hx8) uq7.d(c0, i)) != null) {
                                i2 = hx8Var.getPosition();
                            }
                        }
                        uq7.a(this.e, ws4Var);
                        i3++;
                        if (i3 == 4 && y48Var.D() != null) {
                            uq7.a(this.e, y48Var.D());
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
            y48 y48Var = this.c;
            if (y48Var != null && y48Var.Q() != null) {
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
        vc8 vc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (vc8Var = this.f) != null) {
            vc8Var.notifyDataSetChanged();
        }
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, detailInfoFragment, bdTypeRecyclerView) == null) {
            AbsVideoPbFragment J = detailInfoFragment.J();
            this.f = new vc8(J, J, PostData.O0);
            this.g = new tc8(detailInfoFragment.getContext(), s58.b);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.J(), m58.f);
            this.h = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.H(this.q);
            this.i = new m78(detailInfoFragment.J(), x48.c);
            k78 k78Var = new k78(detailInfoFragment.J(), ws4.e);
            this.j = k78Var;
            k78Var.z(true);
            this.k = new c88(detailInfoFragment.J());
            this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), b58.c);
            b98 b98Var = new b98(detailInfoFragment.J(), n58.a);
            this.m = b98Var;
            b98Var.x(this.p);
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
