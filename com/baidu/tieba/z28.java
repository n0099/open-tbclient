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
/* loaded from: classes6.dex */
public class z28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<qn> a;
    public DetailInfoFragment b;
    public jv7 c;
    public BdTypeRecyclerView d;
    public List<Cdo> e;
    public e38 f;
    public c38 g;
    public PbFirstFloorCommentAndPraiseAdapter h;
    public xx7 i;
    public vx7 j;
    public ny7 k;
    public PbFirstFloorItemAdapter l;
    public mz7 m;
    public qn n;
    public qn o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z28 a;

        /* renamed from: com.baidu.tieba.z28$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0477a implements FullBrowseHelper.IAcceptPrivacyConfirm {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.z28$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0478a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0477a a;

                public RunnableC0478a(C0477a c0477a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0477a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0477a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.a.a.a.b.K().o3(3);
                    }
                }
            }

            public C0477a(a aVar) {
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
                        gh.a().postDelayed(new RunnableC0478a(this), 10L);
                    }
                }
            }
        }

        public a(z28 z28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z28Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null || this.a.b.K() == null) {
                return;
            }
            FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.b.getPageContext(), new C0477a(this));
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z28 a;

        public b(z28 z28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z28Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091b24) {
                    if (this.a.f(11009)) {
                        this.a.i(8);
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091e97) {
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

    /* loaded from: classes6.dex */
    public class c extends di5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z28 a;

        public c(z28 z28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z28Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.di5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return i18.d(this.a.h(), ShareSwitch.isOn() ? 1 : 6, this.a.b.K());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ih5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ z28 b;

        public d(z28 z28Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z28Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z28Var;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ih5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.b.b.getContext(), this.a, shareItem, false));
            }
        }
    }

    public z28(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public final void e(jn8 jn8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jn8Var) == null) || jn8Var == null || this.c == null || jn8Var.getAdvertAppInfo() == null) {
            return;
        }
        jn8Var.getAdvertAppInfo().i = new dr4();
        if (this.c.y() != null) {
            jn8Var.getAdvertAppInfo().i.b = this.c.y().a();
        }
        jn8Var.getAdvertAppInfo().i.a = jn8Var.l1();
        if (this.c.l() != null && (l = this.c.l()) != null) {
            jn8Var.getAdvertAppInfo().i.c = l.getId();
            jn8Var.getAdvertAppInfo().i.d = l.getFirst_class();
            jn8Var.getAdvertAppInfo().i.e = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            jn8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        jn8Var.getAdvertAppInfo().i.g = jn8Var.getAdvertAppInfo().g;
        jn8Var.getAdvertAppInfo().i.h = false;
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

    public final List<Cdo> g(jv7 jv7Var) {
        InterceptResult invokeL;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jv7Var)) == null) {
            jn8 jn8Var = null;
            if (jv7Var == null) {
                return null;
            }
            this.e = new ArrayList();
            Iterator<PostData> it = jv7Var.F().iterator();
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
            if (postData == null && jv7Var.j() != null) {
                postData = jv7Var.j();
            }
            if (postData != null) {
                this.e.add(postData);
            }
            dw7 dw7Var = new dw7();
            ThreadData O = jv7Var.O();
            dw7Var.a = O;
            if (O != null && dj.isEmpty(O.getForum_name())) {
                dw7Var.a.setForum_name(jv7Var.n());
            }
            this.e.add(dw7Var);
            xv7 xv7Var = new xv7(jv7Var.O(), jv7Var.d());
            xv7Var.b = true;
            this.e.add(xv7Var);
            if (postData != null && postData.j0 != null && (jv7Var.l() == null || !TextUtils.equals(jv7Var.l().getName(), this.b.K().r1()) || !this.b.K().x1())) {
                mv7 mv7Var = new mv7(postData.j0);
                mv7Var.b = this.b.K().m2();
                this.e.add(mv7Var);
            }
            List<jn8> Z = jv7Var.Z();
            int i = 0;
            int i2 = -1;
            if (!ah7.e(Z) && (jn8Var = (jn8) ah7.d(Z, 0)) != null) {
                i2 = jn8Var.getPosition();
            }
            if (jv7Var.f() != null) {
                iv7 iv7Var = new iv7();
                iv7Var.f(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fdd));
                this.e.add(iv7Var);
                if (TbSingleton.getInstance().isBrowseMode()) {
                    this.e.add(new yv7());
                } else {
                    int i3 = 1;
                    for (pr4 pr4Var : jv7Var.f()) {
                        if (Z != null && i3 == i2) {
                            if (jn8Var != null) {
                                e(jn8Var);
                                ah7.a(this.e, jn8Var);
                                i++;
                                if (jn8Var.getType() != AdvertAppInfo.x) {
                                    i3++;
                                }
                            }
                            if (i < Z.size() && (jn8Var = (jn8) ah7.d(Z, i)) != null) {
                                i2 = jn8Var.getPosition();
                            }
                        }
                        ah7.a(this.e, pr4Var);
                        i3++;
                        if (i3 == 4 && jv7Var.C() != null) {
                            ah7.a(this.e, jv7Var.C());
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
            jv7 jv7Var = this.c;
            if (jv7Var == null || jv7Var.O() == null) {
                return -1;
            }
            return this.c.O().getActInfoType();
        }
        return invokeV.intValue;
    }

    public final void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            hi5.b(new c(this), new d(this, i));
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
            this.n = be8.l().a(detailInfoFragment.B().getBaseFragmentActivity(), AdvertAppInfo.x);
            this.o = be8.l().a(detailInfoFragment.B().getBaseFragmentActivity(), AdvertAppInfo.z);
            this.a.add(this.n);
            this.a.add(this.o);
        }
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, detailInfoFragment, bdTypeRecyclerView) == null) {
            AbsVideoPbFragment B = detailInfoFragment.B();
            this.f = new e38(B, B, PostData.K0);
            this.g = new c38(detailInfoFragment.getContext(), dw7.b);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.B(), xv7.f);
            this.h = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.G(this.q);
            this.i = new xx7(detailInfoFragment.B(), iv7.c);
            vx7 vx7Var = new vx7(detailInfoFragment.B(), pr4.e);
            this.j = vx7Var;
            vx7Var.z(true);
            this.k = new ny7(detailInfoFragment.B());
            this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), mv7.c);
            mz7 mz7Var = new mz7(detailInfoFragment.B(), yv7.a);
            this.m = mz7Var;
            mz7Var.x(this.p);
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
        e38 e38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (e38Var = this.f) == null) {
            return;
        }
        e38Var.notifyDataSetChanged();
    }

    public void n(jv7 jv7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, jv7Var) == null) || jv7Var == null) {
            return;
        }
        this.c = jv7Var;
        BdTypeRecyclerView bdTypeRecyclerView = this.d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f.U(jv7Var);
        this.j.y(jv7Var);
        this.k.w(jv7Var);
        this.d.setData(g(jv7Var));
    }
}
