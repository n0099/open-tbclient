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
/* loaded from: classes7.dex */
public class qf6 implements kg6, jg6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaPersonCenterModel a;
    public tf6 b;
    public hf6 c;
    public TbPageContext d;
    public NavigationBar e;
    public BdTypeListView f;
    public View g;
    public NoNetworkView h;
    public vm5 i;
    public boolean j;
    public boolean k;
    public int l;
    public ImageView m;
    public TextView n;
    public boolean o;
    public String p;
    public wm5 q;
    public boolean r;
    public boolean s;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qf6 a;

        public a(qf6 qf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qf6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qf6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(qf6 qf6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qf6Var, Integer.valueOf(i)};
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
            this.a = qf6Var;
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

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qf6 a;

        public c(qf6 qf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qf6Var;
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

    /* loaded from: classes7.dex */
    public class d implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qf6 a;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
            }
        }

        public d(qf6 qf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qf6Var;
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

    public qf6(TbPageContext tbPageContext, boolean z) {
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
        this.l = (int) tbPageContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f0703cf);
        AlaPersonCenterModel alaPersonCenterModel = new AlaPersonCenterModel(tbPageContext);
        this.a = alaPersonCenterModel;
        alaPersonCenterModel.V(this);
        n(tbPageContext.getPageActivity());
    }

    @Override // com.baidu.tieba.jg6
    public void a(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && i == 1) {
            this.s = true;
        }
    }

    public void r(String str) {
        hf6 hf6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && (hf6Var = this.c) != null) {
            hf6Var.c(str);
        }
    }

    public void t(String str) {
        hf6 hf6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, str) == null) && (hf6Var = this.c) != null) {
            hf6Var.e(str);
        }
    }

    @Override // com.baidu.tieba.kg6
    public void b(int i, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, obj) == null) {
            vm5 vm5Var = this.i;
            if (vm5Var != null) {
                vm5Var.dettachView(this.g);
            }
            this.f.setVisibility(0);
            BdTypeListView bdTypeListView = this.f;
            if (bdTypeListView != null && ListUtils.isEmpty(bdTypeListView.getData())) {
                w();
            }
        }
    }

    @Override // com.baidu.tieba.kg6
    public void c(Object obj, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, obj, i) != null) || obj == null) {
            return;
        }
        j();
        if ((obj instanceof tf6) && i == 1) {
            tf6 tf6Var = (tf6) obj;
            this.b = tf6Var;
            tf6Var.e(this.j);
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
            wf6 wf6Var = new wf6();
            wf6Var.d(this.b);
            arrayList.add(wf6Var);
            if (TbSingleton.getInstance().isShowStartLiveEntry()) {
                dg6 dg6Var = new dg6();
                dg6Var.d(this.b);
                arrayList.add(dg6Var);
            }
            ag6 ag6Var = new ag6();
            ag6Var.d(this.b);
            arrayList.add(ag6Var);
            bg6 bg6Var = new bg6();
            bg6Var.d(this.b);
            arrayList.add(bg6Var);
            if (this.b.h != null) {
                uf6 uf6Var = new uf6();
                uf6Var.d(this.b);
                arrayList.add(uf6Var);
            }
            yf6 yf6Var = new yf6();
            yf6Var.d(this.b);
            arrayList.add(yf6Var);
            cg6 cg6Var = new cg6();
            cg6Var.d(this.b);
            arrayList.add(cg6Var);
            xf6 xf6Var = new xf6();
            xf6Var.d(this.b);
            arrayList.add(xf6Var);
            vf6 vf6Var = new vf6();
            vf6Var.d(this.b);
            arrayList.add(vf6Var);
            fg6 fg6Var = new fg6();
            fg6Var.d(this.b);
            arrayList.add(fg6Var);
            eg6 eg6Var = new eg6();
            eg6Var.d(this.b);
            arrayList.add(eg6Var);
        } else {
            arrayList = new ArrayList(4);
            wf6 wf6Var2 = new wf6();
            wf6Var2.d(this.b);
            arrayList.add(wf6Var2);
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
            vm5 vm5Var = this.i;
            if (vm5Var != null) {
                vm5Var.n();
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
            wm5 wm5Var = this.q;
            if (wm5Var != null && wm5Var.b().getParent() != null) {
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
            SkinManager.setNavbarIconSrc(this.m, R.drawable.selector_topbar_return_white, R.drawable.obfuscated_res_0x7f081323);
            this.f.setDivider(SkinManager.getDrawable(i, (int) R.color.CAM_X0204));
            this.f.setDividerHeight(this.d.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4));
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0201);
            if (this.f.getAdapter2() instanceof mn) {
                this.f.getAdapter2().notifyDataSetChanged();
                vm5 vm5Var = this.i;
                if (vm5Var != null) {
                    vm5Var.onChangeSkinType();
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
            View inflate = View.inflate(context, R.layout.obfuscated_res_0x7f0d010a, null);
            this.g = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.obfuscated_res_0x7f090225);
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
                sb.append(UtilHelper.getFixedBarText(this.p, 5, true, true) + this.d.getResources().getString(R.string.obfuscated_res_0x7f0f0766));
                this.n = this.e.setCenterTextTitle(sb.toString());
            }
            this.h = (NoNetworkView) this.g.findViewById(R.id.obfuscated_res_0x7f090226);
            BdTypeListView bdTypeListView = (BdTypeListView) this.g.findViewById(R.id.obfuscated_res_0x7f090224);
            this.f = bdTypeListView;
            bdTypeListView.setItemsCanFocus(true);
            this.f.setVisibility(8);
            hf6 hf6Var = new hf6(this.d, this.f, this);
            this.c = hf6Var;
            hf6Var.f(this.o);
            if (this.o) {
                this.g.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            vm5 vm5Var = new vm5(this.d.getPageActivity());
            this.i = vm5Var;
            vm5Var.attachView(this.g, false);
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
            hf6 hf6Var = this.c;
            if (hf6Var != null) {
                hf6Var.d(str);
            }
            if (!this.o) {
                this.n = this.e.setCenterTextTitle(this.d.getString(R.string.ala_live));
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.p, 5, true, true) + this.d.getResources().getString(R.string.obfuscated_res_0x7f0f0766));
            this.n = this.e.setCenterTextTitle(sb.toString());
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.q == null) {
                wm5 wm5Var = new wm5(this.d.getPageActivity(), new a(this));
                this.q = wm5Var;
                wm5Var.n(null);
                this.q.g(null);
                this.q.k(this.d.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703bd));
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
