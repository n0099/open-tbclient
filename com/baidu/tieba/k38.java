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
public class k38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List a;
    public DetailInfoFragment b;
    public uv7 c;
    public BdTypeRecyclerView d;
    public List e;
    public p38 f;
    public n38 g;
    public PbFirstFloorCommentAndPraiseAdapter h;
    public iy7 i;
    public gy7 j;
    public yy7 k;
    public PbFirstFloorItemAdapter l;
    public xz7 m;
    public rn n;
    public rn o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k38 a;

        /* renamed from: com.baidu.tieba.k38$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0293a implements FullBrowseHelper.IAcceptPrivacyConfirm {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.k38$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC0294a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0293a a;

                public RunnableC0294a(C0293a c0293a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0293a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0293a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.a.a.a.b.K().o3(3);
                    }
                }
            }

            public C0293a(a aVar) {
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
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        hh.a().postDelayed(new RunnableC0294a(this), 10L);
                    } else {
                        this.a.a.b.I1();
                    }
                }
            }
        }

        public a(k38 k38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k38Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null && this.a.b.K() != null) {
                FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.b.getPageContext(), new C0293a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k38 a;

        public b(k38 k38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k38Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091b21) {
                    if (!this.a.f(11009)) {
                        return;
                    }
                    this.a.i(8);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091e97) {
                    if (!this.a.f(11009)) {
                        return;
                    }
                    this.a.i(3);
                } else if (this.a.b != null && this.a.b.B() != null && this.a.b.B().O3() != null) {
                    this.a.b.B().O3().onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends ii5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k38 a;

        public c(k38 k38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k38Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ii5
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
                return t18.d(this.a.h(), i, this.a.b.K());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements oh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ k38 b;

        public d(k38 k38Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k38Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k38Var;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oh5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.b.b.getContext(), this.a, shareItem, false));
            }
        }
    }

    public k38(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public final void e(qn8 qn8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, qn8Var) == null) && qn8Var != null && this.c != null && qn8Var.getAdvertAppInfo() != null) {
            qn8Var.getAdvertAppInfo().i = new fr4();
            if (this.c.y() != null) {
                qn8Var.getAdvertAppInfo().i.b = this.c.y().a();
            }
            qn8Var.getAdvertAppInfo().i.a = qn8Var.m1();
            if (this.c.l() != null && (l = this.c.l()) != null) {
                qn8Var.getAdvertAppInfo().i.c = l.getId();
                qn8Var.getAdvertAppInfo().i.d = l.getFirst_class();
                qn8Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                qn8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            qn8Var.getAdvertAppInfo().i.g = qn8Var.getAdvertAppInfo().g;
            qn8Var.getAdvertAppInfo().i.h = false;
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
            TbadkCoreApplication.getInst().login(this.b.getPageContext(), new CustomMessage(2002001, new LoginActivityConfig(this.b.P(), true, i)));
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            mi5.b(new c(this), new d(this, i));
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
            this.n = le8.l().a(detailInfoFragment.B().getBaseFragmentActivity(), AdvertAppInfo.x);
            this.o = le8.l().a(detailInfoFragment.B().getBaseFragmentActivity(), AdvertAppInfo.z);
            this.a.add(this.n);
            this.a.add(this.o);
        }
    }

    public void n(uv7 uv7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, uv7Var) != null) || uv7Var == null) {
            return;
        }
        this.c = uv7Var;
        BdTypeRecyclerView bdTypeRecyclerView = this.d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f.U(uv7Var);
        this.j.y(uv7Var);
        this.k.w(uv7Var);
        this.d.setData(g(uv7Var));
    }

    public final List g(uv7 uv7Var) {
        InterceptResult invokeL;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uv7Var)) == null) {
            qn8 qn8Var = null;
            if (uv7Var == null) {
                return null;
            }
            this.e = new ArrayList();
            Iterator it = uv7Var.G().iterator();
            while (true) {
                if (it.hasNext()) {
                    eo eoVar = (eo) it.next();
                    if (eoVar instanceof PostData) {
                        postData = (PostData) eoVar;
                        if (postData.D() == 1) {
                            break;
                        }
                    }
                } else {
                    postData = null;
                    break;
                }
            }
            if (postData == null && uv7Var.j() != null) {
                postData = uv7Var.j();
            }
            if (postData != null) {
                this.e.add(postData);
            }
            ow7 ow7Var = new ow7();
            ThreadData P = uv7Var.P();
            ow7Var.a = P;
            if (P != null && ej.isEmpty(P.getForum_name())) {
                ow7Var.a.setForum_name(uv7Var.n());
            }
            this.e.add(ow7Var);
            iw7 iw7Var = new iw7(uv7Var.P(), uv7Var.d());
            iw7Var.b = true;
            this.e.add(iw7Var);
            if (postData != null && postData.j0 != null && (uv7Var.l() == null || !TextUtils.equals(uv7Var.l().getName(), this.b.K().r1()) || !this.b.K().x1())) {
                xv7 xv7Var = new xv7(postData.j0);
                xv7Var.b = this.b.K().m2();
                this.e.add(xv7Var);
            }
            List b0 = uv7Var.b0();
            int i = 0;
            int i2 = -1;
            if (!lh7.e(b0) && (qn8Var = (qn8) lh7.d(b0, 0)) != null) {
                i2 = qn8Var.getPosition();
            }
            if (uv7Var.f() != null) {
                tv7 tv7Var = new tv7();
                tv7Var.f(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ff0));
                this.e.add(tv7Var);
                if (TbSingleton.getInstance().isBrowseMode()) {
                    this.e.add(new jw7());
                } else {
                    int i3 = 1;
                    for (rr4 rr4Var : uv7Var.f()) {
                        if (b0 != null && i3 == i2) {
                            if (qn8Var != null) {
                                e(qn8Var);
                                lh7.a(this.e, qn8Var);
                                i++;
                                if (qn8Var.getType() != AdvertAppInfo.x) {
                                    i3++;
                                }
                            }
                            if (i < b0.size() && (qn8Var = (qn8) lh7.d(b0, i)) != null) {
                                i2 = qn8Var.getPosition();
                            }
                        }
                        lh7.a(this.e, rr4Var);
                        i3++;
                        if (i3 == 4 && uv7Var.C() != null) {
                            lh7.a(this.e, uv7Var.C());
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
            uv7 uv7Var = this.c;
            if (uv7Var != null && uv7Var.P() != null) {
                return this.c.P().getActInfoType();
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
        p38 p38Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (p38Var = this.f) != null) {
            p38Var.notifyDataSetChanged();
        }
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, detailInfoFragment, bdTypeRecyclerView) == null) {
            AbsVideoPbFragment B = detailInfoFragment.B();
            this.f = new p38(B, B, PostData.K0);
            this.g = new n38(detailInfoFragment.getContext(), ow7.b);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.B(), iw7.f);
            this.h = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.G(this.q);
            this.i = new iy7(detailInfoFragment.B(), tv7.c);
            gy7 gy7Var = new gy7(detailInfoFragment.B(), rr4.e);
            this.j = gy7Var;
            gy7Var.z(true);
            this.k = new yy7(detailInfoFragment.B());
            this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), xv7.c);
            xz7 xz7Var = new xz7(detailInfoFragment.B(), jw7.a);
            this.m = xz7Var;
            xz7Var.x(this.p);
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
