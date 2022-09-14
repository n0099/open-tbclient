package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.FullBrowseHelper;
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
/* loaded from: classes4.dex */
public class l28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<qn> a;
    public DetailInfoFragment b;
    public vu7 c;
    public BdTypeRecyclerView d;
    public List<Cdo> e;
    public q28 f;
    public o28 g;
    public PbFirstFloorCommentAndPraiseAdapter h;
    public jx7 i;
    public hx7 j;
    public zx7 k;
    public PbFirstFloorItemAdapter l;
    public yy7 m;
    public qn n;
    public qn o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l28 a;

        /* renamed from: com.baidu.tieba.l28$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0317a implements FullBrowseHelper.IAcceptPrivacyConfirm {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.l28$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC0318a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0317a a;

                public RunnableC0318a(C0317a c0317a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0317a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0317a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.a.a.a.b.K().o3(3);
                    }
                }
            }

            public C0317a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tbadk.core.util.FullBrowseHelper.IAcceptPrivacyConfirm
            public void onConfirm() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.a.b.I1();
                    } else {
                        gh.a().postDelayed(new RunnableC0318a(this), 10L);
                    }
                }
            }
        }

        public a(l28 l28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l28Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null || this.a.b.K() == null) {
                return;
            }
            FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.b.getPageContext(), new C0317a(this));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l28 a;

        public b(l28 l28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l28Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091b22) {
                    if (this.a.f(11009)) {
                        this.a.i(8);
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091e95) {
                    if (this.a.f(11009)) {
                        this.a.i(3);
                    }
                } else if (this.a.b == null || this.a.b.B() == null || this.a.b.B().P3() == null) {
                } else {
                    this.a.b.B().P3().onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends qh5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l28 a;

        public c(l28 l28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l28Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qh5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return u08.d(this.a.h(), ShareSwitch.isOn() ? 1 : 6, this.a.b.K());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements vg5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ l28 b;

        public d(l28 l28Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l28Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l28Var;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.b.b.getContext(), this.a, shareItem, false));
            }
        }
    }

    public l28(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public final void e(um8 um8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, um8Var) == null) || um8Var == null || this.c == null || um8Var.getAdvertAppInfo() == null) {
            return;
        }
        um8Var.getAdvertAppInfo().i = new qq4();
        if (this.c.y() != null) {
            um8Var.getAdvertAppInfo().i.b = this.c.y().a();
        }
        um8Var.getAdvertAppInfo().i.a = um8Var.l1();
        if (this.c.l() != null && (l = this.c.l()) != null) {
            um8Var.getAdvertAppInfo().i.c = l.getId();
            um8Var.getAdvertAppInfo().i.d = l.getFirst_class();
            um8Var.getAdvertAppInfo().i.e = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            um8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        um8Var.getAdvertAppInfo().i.g = um8Var.getAdvertAppInfo().g;
        um8Var.getAdvertAppInfo().i.h = false;
    }

    public final boolean f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.b.P(), true, i)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final List<Cdo> g(vu7 vu7Var) {
        InterceptResult invokeL;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vu7Var)) == null) {
            um8 um8Var = null;
            if (vu7Var == null) {
                return null;
            }
            this.e = new ArrayList();
            Iterator<PostData> it = vu7Var.F().iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    break;
                }
                PostData next = it.next();
                if (next instanceof PostData) {
                    postData = next;
                    if (postData.C() == 1) {
                        break;
                    }
                }
            }
            if (postData == null && vu7Var.j() != null) {
                postData = vu7Var.j();
            }
            if (postData != null) {
                this.e.add(postData);
            }
            pv7 pv7Var = new pv7();
            ThreadData O = vu7Var.O();
            pv7Var.a = O;
            if (O != null && dj.isEmpty(O.getForum_name())) {
                pv7Var.a.setForum_name(vu7Var.n());
            }
            this.e.add(pv7Var);
            jv7 jv7Var = new jv7(vu7Var.O(), vu7Var.d());
            jv7Var.b = true;
            this.e.add(jv7Var);
            if (postData != null && postData.i0 != null && (vu7Var.l() == null || !TextUtils.equals(vu7Var.l().getName(), this.b.K().r1()) || !this.b.K().x1())) {
                yu7 yu7Var = new yu7(postData.i0);
                yu7Var.b = this.b.K().m2();
                this.e.add(yu7Var);
            }
            List<um8> Z = vu7Var.Z();
            int i = 0;
            int i2 = -1;
            if (!mg7.e(Z) && (um8Var = (um8) mg7.d(Z, 0)) != null) {
                i2 = um8Var.getPosition();
            }
            if (vu7Var.f() != null) {
                uu7 uu7Var = new uu7();
                uu7Var.f(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fdd));
                this.e.add(uu7Var);
                if (TbSingleton.getInstance().isBrowseMode()) {
                    this.e.add(new kv7());
                } else {
                    int i3 = 1;
                    for (cr4 cr4Var : vu7Var.f()) {
                        if (Z != null && i3 == i2) {
                            if (um8Var != null) {
                                e(um8Var);
                                mg7.a(this.e, um8Var);
                                i++;
                                if (um8Var.getType() != AdvertAppInfo.x) {
                                    i3++;
                                }
                            }
                            if (i < Z.size() && (um8Var = (um8) mg7.d(Z, i)) != null) {
                                i2 = um8Var.getPosition();
                            }
                        }
                        mg7.a(this.e, cr4Var);
                        i3++;
                        if (i3 == 4 && vu7Var.C() != null) {
                            mg7.a(this.e, vu7Var.C());
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
            vu7 vu7Var = this.c;
            if (vu7Var == null || vu7Var.O() == null) {
                return -1;
            }
            return this.c.O().getActInfoType();
        }
        return invokeV.intValue;
    }

    public final void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            uh5.b(new c(this), new d(this, i));
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
            this.n = md8.l().a(detailInfoFragment.B().getBaseFragmentActivity(), AdvertAppInfo.x);
            this.o = md8.l().a(detailInfoFragment.B().getBaseFragmentActivity(), AdvertAppInfo.z);
            this.a.add(this.n);
            this.a.add(this.o);
        }
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, detailInfoFragment, bdTypeRecyclerView) == null) {
            AbsVideoPbFragment B = detailInfoFragment.B();
            this.f = new q28(B, B, PostData.J0);
            this.g = new o28(detailInfoFragment.getContext(), pv7.b);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.B(), jv7.f);
            this.h = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.G(this.q);
            this.i = new jx7(detailInfoFragment.B(), uu7.c);
            hx7 hx7Var = new hx7(detailInfoFragment.B(), cr4.e);
            this.j = hx7Var;
            hx7Var.z(true);
            this.k = new zx7(detailInfoFragment.B());
            this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), yu7.c);
            yy7 yy7Var = new yy7(detailInfoFragment.B(), kv7.a);
            this.m = yy7Var;
            yy7Var.x(this.p);
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

    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bdTypeRecyclerView = this.d) == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.d.getListAdapter().notifyDataSetChanged();
    }

    public void m() {
        q28 q28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (q28Var = this.f) == null) {
            return;
        }
        q28Var.notifyDataSetChanged();
    }

    public void n(vu7 vu7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, vu7Var) == null) || vu7Var == null) {
            return;
        }
        this.c = vu7Var;
        BdTypeRecyclerView bdTypeRecyclerView = this.d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f.U(vu7Var);
        this.j.y(vu7Var);
        this.k.w(vu7Var);
        this.d.setData(g(vu7Var));
    }
}
