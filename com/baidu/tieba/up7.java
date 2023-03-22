package com.baidu.tieba;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.im.forum.broadcast.adapter.FroumBroadMajorHistoryAdapter;
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
import com.baidu.tieba.im.forum.broadcast.view.ForumBroadcastMajorQuestionDialogView;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.util.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class up7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    public final rp7 b;
    public View c;
    public NavigationBar d;
    public BdRecyclerView e;
    public PbListView f;
    public boolean g;
    public FroumBroadMajorHistoryAdapter h;
    public List<tp7> i;
    public ImageView j;
    public LinearLayout k;
    public TextView l;
    public TextView m;
    public String n;
    public String o;
    public lf5 p;
    public RelativeLayout q;
    public boolean r;
    public ScreenTopToast s;
    public BdListView.p t;
    public xu4<tp7> u;
    public View.OnClickListener v;
    public View.OnClickListener w;
    public View.OnClickListener x;
    public View.OnClickListener y;

    /* loaded from: classes6.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ up7 a;

        public a(up7 up7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {up7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = up7Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e != null) {
                    this.a.e.stopScroll();
                }
                this.a.p();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements xu4<tp7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ up7 a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xu4
        /* renamed from: a */
        public void d(View view2, tp7 tp7Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, tp7Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            }
        }

        public b(up7 up7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {up7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = up7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xu4
        /* renamed from: b */
        public void c(View view2, tp7 tp7Var, int i, long j) {
            long j2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, tp7Var, Integer.valueOf(i), Long.valueOf(j)}) != null) || tp7Var == null) {
                return;
            }
            StatisticItem param = new StatisticItem("c13875").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.a.n);
            if (tp7Var.j() != null) {
                j2 = tp7Var.j().tid.longValue();
            } else {
                j2 = 0;
            }
            TiebaStatic.log(param.param("tid", j2));
            String str = "";
            if (view2.getId() == R.id.obfuscated_res_0x7f090b69) {
                if (uo5.a()) {
                    return;
                }
                if (this.a.r) {
                    this.a.q();
                    return;
                }
                ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(this.a.a.getPageActivity());
                String str2 = tp7Var.b() + "";
                String str3 = this.a.o;
                String str4 = this.a.n;
                if (tp7Var.j() != null) {
                    str = tp7Var.j().tid + "";
                }
                forumBroadcastHelper.jumpFlutterEditRelease(str2, str3, str4, str, tp7Var.k(), tp7Var.c(), tp7Var.f(), ForumBroadcastHelper.VALUE_PARMARS_BCAST_FROM_EDIT, "2");
                forumBroadcastHelper.start();
            } else if (tp7Var.j() != null && tp7Var.j().is_deleted.intValue() != 1) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a.a.getPageActivity());
                pbActivityConfig.createNormalCfg(tp7Var.j().tid + "", null, null);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            } else {
                BdTopToast bdTopToast = new BdTopToast(this.a.a.getPageActivity());
                bdTopToast.h(false);
                bdTopToast.g(this.a.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f06c7));
                bdTopToast.i((ViewGroup) this.a.c.findViewById(R.id.obfuscated_res_0x7f090b87));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ up7 a;

        public c(up7 up7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {up7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = up7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("_forumId", this.a.n);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.a.getPageActivity(), "ForumGradePage", hashMap)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ up7 a;

        public d(up7 up7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {up7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = up7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c13873").param("uid", TbadkCoreApplication.getCurrentAccountId()));
                this.a.t();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ up7 a;

        public e(up7 up7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {up7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = up7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || uo5.a()) {
                return;
            }
            ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(this.a.a.getPageActivity());
            forumBroadcastHelper.jumpFlutterEditGenear(this.a.n, this.a.o, "2");
            forumBroadcastHelper.start();
            TiebaStatic.log(new StatisticItem("c13874").param("uid", TbadkCoreApplication.getCurrentAccountId()));
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ up7 a;

        public f(up7 up7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {up7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = up7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c13874").param("uid", TbadkCoreApplication.getCurrentAccountId()));
                if (uo5.a()) {
                    return;
                }
                this.a.q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ up7 a;

        public g(up7 up7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {up7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = up7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.e != null) {
                    this.a.e.stopScroll();
                }
                if (this.a.f != null && this.a.b != null && BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.f.O(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.a.f.E(null);
                    if (this.a.g) {
                        this.a.f.Q();
                        this.a.b.b();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ up7 a;

        public h(up7 up7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {up7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = up7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately() && this.a.b != null) {
                this.a.k();
                this.a.b.refresh();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz4 a;

        public i(up7 up7Var, zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {up7Var, zz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            zz4 zz4Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (zz4Var = this.a) != null) {
                zz4Var.dismiss();
            }
        }
    }

    public up7(TbPageContext<?> tbPageContext, rp7 rp7Var, View view2, String str, String str2, String str3, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, rp7Var, view2, str, str2, str3, bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new ArrayList();
        this.t = new a(this);
        this.u = new b(this);
        this.v = new d(this);
        this.w = new e(this);
        this.x = new f(this);
        this.y = new g(this);
        this.a = tbPageContext;
        this.b = rp7Var;
        this.n = str;
        this.o = str2;
        l(view2, str3);
        TiebaStatic.log(new StatisticItem("c13872").param("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.d.onChangeSkinType(this.a, i2);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
            this.f.e(i2);
            this.h.notifyDataSetChanged();
        }
    }

    public void k() {
        lf5 lf5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (lf5Var = this.p) != null) {
            lf5Var.dettachView(this.q);
            this.p = null;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.i = null;
            this.s = null;
        }
    }

    public final void l(View view2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, str) == null) {
            this.c = view2;
            this.d = (NavigationBar) view2.findViewById(R.id.obfuscated_res_0x7f0917bf);
            this.q = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090b86);
            this.d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.j = (ImageView) this.d.getCenterImgBox();
            LinearLayout linearLayout = (LinearLayout) this.d.getCenterImgBoxLayout();
            this.k = linearLayout;
            linearLayout.setGravity(16);
            int g2 = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds17);
            int g3 = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            SkinManager.setNavbarIconSrc(this.j, R.drawable.ic_icon_creation_question16_svg, R.drawable.ic_icon_creation_question16_svg);
            this.d.showBottomLine();
            this.m = this.d.setCenterTextTitle(this.a.getResources().getString(R.string.subscribe_bar_title));
            this.j.setPadding(g2, g2, g2, g2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.leftMargin = g2;
            layoutParams.rightMargin = 0;
            this.m.setLayoutParams(layoutParams);
            int i2 = g3 + g2 + g2;
            layoutParams2.width = i2;
            layoutParams2.height = i2;
            this.j.setLayoutParams(layoutParams2);
            this.j.setVisibility(0);
            this.j.setOnClickListener(this.v);
            BdRecyclerView bdRecyclerView = (BdRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f09046a);
            this.e = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity()));
            this.e.setOverScrollMode(2);
            this.e.setOnSrollToBottomListener(this.t);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
            FroumBroadMajorHistoryAdapter froumBroadMajorHistoryAdapter = new FroumBroadMajorHistoryAdapter(this.a.getPageActivity());
            this.h = froumBroadMajorHistoryAdapter;
            froumBroadMajorHistoryAdapter.h(this.u);
            this.e.setAdapter(this.h);
            PbListView pbListView = new PbListView(this.a.getPageActivity());
            this.f = pbListView;
            pbListView.c();
            this.f.r(R.color.CAM_X0204);
            this.f.v(hi.g(this.a.getPageActivity(), R.dimen.tbds182));
            this.f.A();
            this.f.J(R.dimen.tbfontsize33);
            this.f.H(SkinManager.getColor(R.color.CAM_X0107));
            this.f.D(R.color.CAM_X0110);
            this.f.u();
            this.f.E(this.y);
            if (ForumBroadcastHelper.VALUE_INTENT_BCAST_FROM_EDIT_SUCCESS.equals(str)) {
                s();
                int g4 = w8.f().g();
                Activity e2 = w8.f().e(g4 - 2);
                Activity e3 = w8.f().e(g4 - 3);
                if (e2 != null && e3 != null && "FlutterPageActivity".equals(e2.getClass().getSimpleName()) && "ForumBroadCastMajorHistoryActivity".equals(e3.getClass().getSimpleName())) {
                    e3.finish();
                }
            }
        }
    }

    public void o(sp7 sp7Var) {
        BdRecyclerView bdRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, sp7Var) == null) && sp7Var != null && sp7Var.b() != null) {
            if (!ListUtils.isEmpty(sp7Var.b()) && StringUtils.isEmpty(this.n)) {
                tp7 tp7Var = sp7Var.b().get(0);
                if (tp7Var.e() != null) {
                    this.n = tp7Var.e().forum_id + "";
                }
            }
            this.g = sp7Var.a();
            if (sp7Var.c()) {
                if (!ListUtils.isEmpty(sp7Var.b())) {
                    this.i.clear();
                    this.i.addAll(sp7Var.b());
                }
            } else if (!ListUtils.isEmpty(sp7Var.b())) {
                this.i.addAll(sp7Var.b());
            }
            this.h.i(this.i);
            if (sp7Var.c() && (bdRecyclerView = this.e) != null && bdRecyclerView.getChildCount() > 0) {
                this.e.scrollToPosition(0);
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f != null && this.b != null) {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.e.setNextPage(this.f);
                this.f.O(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.f.E(null);
                if (this.g) {
                    this.f.Q();
                    this.b.b();
                    return;
                }
                this.f.F(this.a.getResources().getString(R.string.list_has_no_more));
                this.f.g();
                return;
            }
            this.e.setNextPage(null);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ScreenTopToast screenTopToast = this.s;
            if (screenTopToast == null || !screenTopToast.g()) {
                ScreenTopToast screenTopToast2 = new ScreenTopToast(this.a.getPageActivity());
                screenTopToast2.m(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f06ca));
                screenTopToast2.k(this.a.getPageActivity().getString(R.string.frs_recommend_fail_tip_btn));
                screenTopToast2.j(new c(this));
                this.s = screenTopToast2;
                screenTopToast2.n((ViewGroup) this.c.findViewById(R.id.obfuscated_res_0x7f090b87));
            }
        }
    }

    public void r(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, str, z) == null) {
            lf5 lf5Var = this.p;
            if (lf5Var != null && lf5Var.isViewAttached()) {
                return;
            }
            if (this.p == null) {
                this.p = new lf5(this.a.getPageActivity(), new h(this));
            }
            this.p.m(null);
            this.p.k(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070290));
            this.p.attachView(this.q, false);
            this.p.p();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.c != null) {
            BdTopToast bdTopToast = new BdTopToast(this.a.getPageActivity());
            bdTopToast.h(true);
            bdTopToast.g(this.a.getPageActivity().getString(R.string.frs_forum_bcast_publish_success_tip));
            bdTopToast.i((ViewGroup) this.c.findViewById(R.id.obfuscated_res_0x7f090b87));
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            zz4 zz4Var = new zz4(this.a.getPageActivity());
            zz4Var.setContentViewSize(2);
            zz4Var.setCanceledOnTouchOutside(false);
            ForumBroadcastMajorQuestionDialogView forumBroadcastMajorQuestionDialogView = new ForumBroadcastMajorQuestionDialogView(this.a.getPageActivity());
            forumBroadcastMajorQuestionDialogView.setConfirmButtonListener(new i(this, zz4Var));
            zz4Var.setContentView(forumBroadcastMajorQuestionDialogView);
            zz4Var.create(this.a).show();
        }
    }

    public void u(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, forumBroadcastMajorResidueData) != null) || this.l != null) {
            return;
        }
        if (forumBroadcastMajorResidueData == null) {
            TextView addTextButton = this.d.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(R.string.dynamic_publish), this.w);
            this.l = addTextButton;
            SkinManager.setViewTextColorSelector(addTextButton, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
        } else if (forumBroadcastMajorResidueData.S() >= forumBroadcastMajorResidueData.R()) {
            this.r = true;
            TextView addTextButton2 = this.d.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(R.string.dynamic_publish), this.x);
            this.l = addTextButton2;
            SkinManager.setViewTextColorSelector(addTextButton2, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            this.l.setAlpha(0.33f);
        } else {
            TextView addTextButton3 = this.d.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(R.string.dynamic_publish), this.w);
            this.l = addTextButton3;
            SkinManager.setViewTextColorSelector(addTextButton3, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
        }
    }
}
