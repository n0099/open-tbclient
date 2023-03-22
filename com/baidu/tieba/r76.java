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
import com.baidu.tieba.ala.personcenter.model.AlaPersonCenterModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class r76 implements l86, k86 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaPersonCenterModel a;
    public u76 b;
    public i76 c;
    public TbPageContext d;
    public NavigationBar e;
    public BdTypeListView f;
    public View g;
    public NoNetworkView h;
    public kf5 i;
    public boolean j;
    public boolean k;
    public int l;
    public ImageView m;
    public TextView n;
    public boolean o;
    public String p;
    public lf5 q;
    public boolean r;
    public boolean s;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r76 a;

        public a(r76 r76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r76Var;
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
        public final /* synthetic */ r76 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(r76 r76Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r76Var, Integer.valueOf(i)};
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
            this.a = r76Var;
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
        public final /* synthetic */ r76 a;

        public c(r76 r76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r76Var;
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
        public final /* synthetic */ r76 a;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
            }
        }

        public d(r76 r76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r76Var;
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

    public r76(TbPageContext tbPageContext, boolean z) {
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
        this.l = (int) tbPageContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f0702bc);
        AlaPersonCenterModel alaPersonCenterModel = new AlaPersonCenterModel(tbPageContext);
        this.a = alaPersonCenterModel;
        alaPersonCenterModel.S(this);
        n(tbPageContext.getPageActivity());
    }

    @Override // com.baidu.tieba.k86
    public void a(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && i == 1) {
            this.s = true;
        }
    }

    public void r(String str) {
        i76 i76Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && (i76Var = this.c) != null) {
            i76Var.c(str);
        }
    }

    public void t(String str) {
        i76 i76Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, str) == null) && (i76Var = this.c) != null) {
            i76Var.e(str);
        }
    }

    @Override // com.baidu.tieba.l86
    public void b(int i, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, obj) == null) {
            kf5 kf5Var = this.i;
            if (kf5Var != null) {
                kf5Var.dettachView(this.g);
            }
            this.f.setVisibility(0);
            BdTypeListView bdTypeListView = this.f;
            if (bdTypeListView != null && ListUtils.isEmpty(bdTypeListView.getData())) {
                w();
            }
        }
    }

    @Override // com.baidu.tieba.l86
    public void c(Object obj, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, obj, i) != null) || obj == null) {
            return;
        }
        j();
        if ((obj instanceof u76) && i == 1) {
            u76 u76Var = (u76) obj;
            this.b = u76Var;
            u76Var.e(this.j);
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
            x76 x76Var = new x76();
            x76Var.f(this.b);
            arrayList.add(x76Var);
            if (TbSingleton.getInstance().isShowStartLiveEntry()) {
                e86 e86Var = new e86();
                e86Var.f(this.b);
                arrayList.add(e86Var);
            }
            b86 b86Var = new b86();
            b86Var.f(this.b);
            arrayList.add(b86Var);
            c86 c86Var = new c86();
            c86Var.f(this.b);
            arrayList.add(c86Var);
            if (this.b.h != null) {
                v76 v76Var = new v76();
                v76Var.f(this.b);
                arrayList.add(v76Var);
            }
            z76 z76Var = new z76();
            z76Var.f(this.b);
            arrayList.add(z76Var);
            d86 d86Var = new d86();
            d86Var.f(this.b);
            arrayList.add(d86Var);
            y76 y76Var = new y76();
            y76Var.f(this.b);
            arrayList.add(y76Var);
            w76 w76Var = new w76();
            w76Var.f(this.b);
            arrayList.add(w76Var);
            g86 g86Var = new g86();
            g86Var.f(this.b);
            arrayList.add(g86Var);
            f86 f86Var = new f86();
            f86Var.f(this.b);
            arrayList.add(f86Var);
        } else {
            arrayList = new ArrayList(4);
            x76 x76Var2 = new x76();
            x76Var2.f(this.b);
            arrayList.add(x76Var2);
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
            kf5 kf5Var = this.i;
            if (kf5Var != null) {
                kf5Var.n();
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
            lf5 lf5Var = this.q;
            if (lf5Var != null && lf5Var.b().getParent() != null) {
                ((ViewGroup) this.q.b().getParent()).removeView(this.q.b());
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
            SkinManager.setNavbarIconSrc(this.m, R.drawable.selector_topbar_return_white, R.drawable.obfuscated_res_0x7f081175);
            this.f.setDivider(SkinManager.getDrawable(i, (int) R.color.CAM_X0204));
            this.f.setDividerHeight(this.d.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4));
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0201);
            if (this.f.getAdapter2() instanceof xm) {
                this.f.getAdapter2().notifyDataSetChanged();
                kf5 kf5Var = this.i;
                if (kf5Var != null) {
                    kf5Var.onChangeSkinType();
                }
                this.h.d(this.d, i);
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
            View inflate = View.inflate(context, R.layout.obfuscated_res_0x7f0d0107, null);
            this.g = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.obfuscated_res_0x7f09021f);
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
                sb.append(UtilHelper.getFixedBarText(this.p, 5, true, true) + this.d.getResources().getString(R.string.obfuscated_res_0x7f0f06bd));
                this.n = this.e.setCenterTextTitle(sb.toString());
            }
            this.h = (NoNetworkView) this.g.findViewById(R.id.obfuscated_res_0x7f090220);
            BdTypeListView bdTypeListView = (BdTypeListView) this.g.findViewById(R.id.obfuscated_res_0x7f09021e);
            this.f = bdTypeListView;
            bdTypeListView.setItemsCanFocus(true);
            this.f.setVisibility(8);
            i76 i76Var = new i76(this.d, this.f, this);
            this.c = i76Var;
            i76Var.f(this.o);
            if (this.o) {
                this.g.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            kf5 kf5Var = new kf5(this.d.getPageActivity());
            this.i = kf5Var;
            kf5Var.attachView(this.g, false);
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
            i76 i76Var = this.c;
            if (i76Var != null) {
                i76Var.d(str);
            }
            if (!this.o) {
                this.n = this.e.setCenterTextTitle(this.d.getString(R.string.ala_live));
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.p, 5, true, true) + this.d.getResources().getString(R.string.obfuscated_res_0x7f0f06bd));
            this.n = this.e.setCenterTextTitle(sb.toString());
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.q == null) {
                lf5 lf5Var = new lf5(this.d.getPageActivity(), new a(this));
                this.q = lf5Var;
                lf5Var.n(null);
                this.q.g(null);
                this.q.k(this.d.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702a6));
                this.q.p();
                this.q.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.q.m(null);
            this.q.n(this.d.getResources().getString(R.string.refresh_view_title_text));
            this.q.onChangeSkinType();
            if (!this.r) {
                ((ViewGroup) this.g).addView(this.q.b(), 0);
            }
            this.r = true;
        }
    }
}
