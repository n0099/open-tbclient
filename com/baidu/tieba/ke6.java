package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tieba.ala.personcenter.model.AlaPersonCenterModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ke6 implements ef6, df6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaPersonCenterModel a;
    public ne6 b;
    public be6 c;
    public TbPageContext d;
    public NavigationBar e;
    public BdTypeListView f;
    public View g;
    public NoNetworkView h;
    public LoadingView i;
    public boolean j;
    public boolean k;
    public int l;
    public ImageView m;
    public TextView n;
    public boolean o;
    public String p;
    public om5 q;
    public boolean r;
    public boolean s;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ke6 a;

        public a(ke6 ke6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ke6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ke6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ke6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ke6 ke6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ke6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ke6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.a != null) {
                this.a.a.loadData();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ke6 a;

        public c(ke6 ke6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ke6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ke6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.a.d.getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ke6 a;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
            }
        }

        public d(ke6 ke6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ke6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ke6Var;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
                this.a.v();
                this.a.u();
            }
        }
    }

    public ke6(TbPageContext tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = true;
        this.l = 0;
        this.o = false;
        this.r = false;
        this.s = false;
        new b(this, AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH);
        this.d = tbPageContext;
        this.o = z;
        this.l = (int) tbPageContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f0703d5);
        AlaPersonCenterModel alaPersonCenterModel = new AlaPersonCenterModel(tbPageContext);
        this.a = alaPersonCenterModel;
        alaPersonCenterModel.O(this);
        n(tbPageContext.getPageActivity());
    }

    @Override // com.baidu.tieba.df6
    public void a(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && i == 1) {
            this.s = true;
        }
    }

    public void r(String str) {
        be6 be6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && (be6Var = this.c) != null) {
            be6Var.c(str);
        }
    }

    public void t(String str) {
        be6 be6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, str) == null) && (be6Var = this.c) != null) {
            be6Var.e(str);
        }
    }

    @Override // com.baidu.tieba.ef6
    public void b(int i, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, obj) == null) {
            LoadingView loadingView = this.i;
            if (loadingView != null) {
                loadingView.dettachView(this.g);
            }
            this.f.setVisibility(0);
            BdTypeListView bdTypeListView = this.f;
            if (bdTypeListView != null && ListUtils.isEmpty(bdTypeListView.getData())) {
                w();
            }
        }
    }

    @Override // com.baidu.tieba.ef6
    public void c(Object obj, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, obj, i) != null) || obj == null) {
            return;
        }
        j();
        if ((obj instanceof ne6) && i == 1) {
            ne6 ne6Var = (ne6) obj;
            this.b = ne6Var;
            ne6Var.e(this.j);
            this.i.dettachView(this.g);
            this.f.setVisibility(0);
            h();
        }
    }

    public void h() {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.b == null) {
            return;
        }
        if (this.j) {
            arrayList = new ArrayList(10);
            qe6 qe6Var = new qe6();
            qe6Var.d(this.b);
            arrayList.add(qe6Var);
            if (TbSingleton.getInstance().isShowStartLiveEntry()) {
                xe6 xe6Var = new xe6();
                xe6Var.d(this.b);
                arrayList.add(xe6Var);
            }
            ue6 ue6Var = new ue6();
            ue6Var.d(this.b);
            arrayList.add(ue6Var);
            ve6 ve6Var = new ve6();
            ve6Var.d(this.b);
            arrayList.add(ve6Var);
            if (this.b.h != null) {
                oe6 oe6Var = new oe6();
                oe6Var.d(this.b);
                arrayList.add(oe6Var);
            }
            se6 se6Var = new se6();
            se6Var.d(this.b);
            arrayList.add(se6Var);
            we6 we6Var = new we6();
            we6Var.d(this.b);
            arrayList.add(we6Var);
            re6 re6Var = new re6();
            re6Var.d(this.b);
            arrayList.add(re6Var);
            pe6 pe6Var = new pe6();
            pe6Var.d(this.b);
            arrayList.add(pe6Var);
            ze6 ze6Var = new ze6();
            ze6Var.d(this.b);
            arrayList.add(ze6Var);
            ye6 ye6Var = new ye6();
            ye6Var.d(this.b);
            arrayList.add(ye6Var);
        } else {
            arrayList = new ArrayList(4);
            qe6 qe6Var2 = new qe6();
            qe6Var2.d(this.b);
            arrayList.add(qe6Var2);
        }
        this.c.b(arrayList);
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && Build.VERSION.SDK_INT >= 11 && this.f.getChildAt(0) != null) {
            int dimension = (int) this.d.getResources().getDimension(R.dimen.obfuscated_res_0x7f070282);
            int i = this.l - (-this.f.getChildAt(0).getTop());
            if (i < dimension) {
                if (this.e.getBarBgView().getAlpha() != 1.0f) {
                    this.e.getBarBgView().setAlpha(1.0f);
                    this.e.getTopCoverBgView().setAlpha(0.0f);
                }
            } else if (i >= dimension && i <= dimension * 2) {
                float f = 1.0f - (((i - dimension) * 1.0f) / dimension);
                this.e.getBarBgView().setAlpha(f);
                this.e.getTopCoverBgView().setAlpha(1.0f - f);
            } else if (i > dimension * 2 && this.e.getBarBgView().getAlpha() != 0.0f) {
                this.e.getBarBgView().setAlpha(0.0f);
                this.e.getTopCoverBgView().setAlpha(1.0f);
            }
            if (this.f.getFirstVisiblePosition() > 0 && this.e.getBarBgView().getAlpha() != 1.0f) {
                this.e.getBarBgView().setAlpha(1.0f);
                this.e.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (View) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.loadData();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            LoadingView loadingView = this.i;
            if (loadingView != null) {
                loadingView.release();
                this.i.dettachView(this.g);
            }
            AlaPersonCenterModel alaPersonCenterModel = this.a;
            if (alaPersonCenterModel != null) {
                alaPersonCenterModel.destory();
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.s) {
            this.s = false;
            l();
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            om5 om5Var = this.q;
            if (om5Var != null && om5Var.getAttachedView().getParent() != null) {
                ((ViewGroup) this.q.getAttachedView().getParent()).removeView(this.q.getAttachedView());
            }
            this.r = false;
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || 2 == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        float alpha = this.e.getBarBgView().getAlpha();
        if (alpha < 0.5f) {
            alpha = 1.0f - alpha;
            if (!this.k) {
                this.k = true;
            }
        } else if (this.k) {
            this.k = false;
        }
        q(alpha, !this.k);
    }

    public void k(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            this.a.setUid(str);
            this.j = z;
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.e.onChangeSkinType(this.d, i);
            this.e.getBackground().mutate().setAlpha(0);
            SkinManager.setNavbarTitleColor(this.e.mTextTitle, R.color.CAM_X0101, R.color.CAM_X0101);
            SkinManager.setNavbarIconSrc(this.m, R.drawable.selector_topbar_return_white, R.drawable.obfuscated_res_0x7f081374);
            this.f.setDivider(SkinManager.getDrawable(i, (int) R.color.CAM_X0204));
            this.f.setDividerHeight(this.d.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4));
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0201);
            if (this.f.getAdapter2() instanceof pm) {
                this.f.getAdapter2().notifyDataSetChanged();
                LoadingView loadingView = this.i;
                if (loadingView != null) {
                    loadingView.onChangeSkinType();
                }
                this.h.onChangeSkinType(this.d, i);
                if (i == 0) {
                    this.e.getBarBgView().setBackgroundColor(this.d.getResources().getColor(R.color.CAM_X0207));
                    this.e.getTopCoverBgView().setBackgroundColor(this.d.getResources().getColor(R.color.CAM_X0201));
                }
            }
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            View inflate = View.inflate(context, R.layout.obfuscated_res_0x7f0d0109, null);
            this.g = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.obfuscated_res_0x7f090222);
            this.e = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            if (this.o) {
                addSystemImageButton.setOnClickListener(new c(this));
            }
            this.m = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
            this.e.showBottomLine(false);
            if (!this.o) {
                this.n = this.e.setCenterTextTitle(this.d.getString(R.string.ala_live));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(UtilHelper.getFixedBarText(this.p, 5, true, true) + this.d.getResources().getString(R.string.obfuscated_res_0x7f0f0774));
                this.n = this.e.setCenterTextTitle(sb.toString());
            }
            this.h = (NoNetworkView) this.g.findViewById(R.id.obfuscated_res_0x7f090223);
            BdTypeListView bdTypeListView = (BdTypeListView) this.g.findViewById(R.id.obfuscated_res_0x7f090221);
            this.f = bdTypeListView;
            bdTypeListView.setItemsCanFocus(true);
            this.f.setVisibility(8);
            be6 be6Var = new be6(this.d, this.f, this);
            this.c = be6Var;
            be6Var.f(this.o);
            if (this.o) {
                this.g.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            LoadingView loadingView = new LoadingView(this.d.getPageActivity());
            this.i = loadingView;
            loadingView.attachView(this.g, false);
            this.f.setOnScrollListener(new d(this));
        }
    }

    public void q(float f, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f), Boolean.valueOf(z)}) == null) {
            if (!z && !this.r) {
                SkinManager.setNavbarIconSrc(this.m, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg_s);
                SkinManager.setNavbarTitleColor(this.n, R.color.CAM_X0105, R.color.s_navbar_title_color);
            } else {
                SkinManager.setNavbarIconSrc(this.m, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg_s);
                SkinManager.setNavbarTitleColor(this.n, R.color.CAM_X0105, R.color.s_navbar_title_color);
            }
            this.n.setAlpha(f);
            this.m.setAlpha(f);
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.p = str;
            be6 be6Var = this.c;
            if (be6Var != null) {
                be6Var.d(str);
            }
            if (!this.o) {
                this.n = this.e.setCenterTextTitle(this.d.getString(R.string.ala_live));
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.p, 5, true, true) + this.d.getResources().getString(R.string.obfuscated_res_0x7f0f0774));
            this.n = this.e.setCenterTextTitle(sb.toString());
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.q == null) {
                om5 om5Var = new om5(this.d.getPageActivity(), new a(this));
                this.q = om5Var;
                om5Var.m(null);
                this.q.f(null);
                this.q.j(this.d.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703c3));
                this.q.o();
                this.q.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.q.l(null);
            this.q.m(this.d.getResources().getString(R.string.refresh_view_title_text));
            this.q.onChangeSkinType();
            if (!this.r) {
                ((ViewGroup) this.g).addView(this.q.getAttachedView(), 0);
            }
            this.r = true;
        }
    }
}
