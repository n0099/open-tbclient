package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AvatarPendantActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackdropGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardCategoryActivityConfig;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.p55;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.dressCenter.DressupCenterActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class xja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DressupCenterActivity a;
    public View b;
    public BdListView c;
    public NavigationBar d;
    public NoNetworkView e;
    public CoverFlowView<vja> f;
    public MemberRecommendView g;
    public TextView h;
    public wja i;
    public int j;

    /* loaded from: classes8.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xja a;

        public a(xja xjaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xjaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xjaVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            yja item;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || (item = this.a.i.getItem(i)) == null) {
                return;
            }
            da5 p = da5.p();
            p.H("dressup_center_red_tip_" + TbadkCoreApplication.getCurrentAccount() + "_" + item.getType(), item.c());
            this.a.i.notifyDataSetChanged();
            if (StringUtils.isNull(item.getType())) {
                return;
            }
            String type = item.getType();
            int e = wg.e(type, 0);
            CustomMessage customMessage = null;
            if (e != 1) {
                if (e != 2) {
                    if (e != 3) {
                        if (e != 4) {
                            if (e != 5) {
                                UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{type});
                            } else {
                                TiebaStatic.log("c11611");
                                customMessage = new CustomMessage(2002001, new AvatarPendantActivityConfig(this.a.a.getActivity()));
                            }
                        } else {
                            customMessage = new CustomMessage(2002001, new PersonalCardCategoryActivityConfig(this.a.a.getPageContext().getPageActivity()));
                        }
                    } else {
                        customMessage = new CustomMessage(2002001, new BubbleGroupActivityConfig(this.a.a.getActivity()));
                    }
                } else {
                    TiebaStatic.log("c10264");
                    customMessage = new CustomMessage(2002001, new PersonalBackdropGroupActivityConfig(this.a.a.getActivity()));
                }
            } else {
                TiebaStatic.log("c10263");
                this.a.m();
            }
            if (customMessage != null) {
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(xja xjaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xjaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                p55Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements g85 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.g85
        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        public c(xja xjaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xjaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.g85
        public TbImageView d(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setGifIconSupport(false);
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }

        @Override // com.baidu.tieba.g85
        public j85 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                j85 j85Var = new j85();
                j85Var.c(R.drawable.icon_diandian_white_n);
                j85Var.g(R.drawable.icon_diandian_white_s);
                j85Var.h(R.dimen.obfuscated_res_0x7f070198);
                j85Var.d(85);
                j85Var.f(R.dimen.obfuscated_res_0x7f070201);
                j85Var.e(R.dimen.obfuscated_res_0x7f0701d5);
                return j85Var;
            }
            return (j85) invokeV.objValue;
        }

        @Override // com.baidu.tieba.g85
        public m85 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                m85 m85Var = new m85();
                m85Var.a(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703b0));
                return m85Var;
            }
            return (m85) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements k85<vja> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xja a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.k85
        /* renamed from: c */
        public void a(int i, vja vjaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, vjaVar) == null) {
            }
        }

        public d(xja xjaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xjaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xjaVar;
        }

        @Override // com.baidu.tieba.k85
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                TiebaStatic.log("c10262");
                UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{str});
            }
        }
    }

    public xja(DressupCenterActivity dressupCenterActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dressupCenterActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = 0;
        this.a = dressupCenterActivity;
        this.j = yi.g(dressupCenterActivity.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070364);
        View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0277, (ViewGroup) null);
        this.b = inflate;
        this.a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.view_navigation_bar);
        this.d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.setCenterTextTitle(this.a.getPageContext().getString(R.string.dressup_center_title));
        this.e = (NoNetworkView) this.b.findViewById(R.id.view_no_network);
        this.c = (BdListView) this.b.findViewById(R.id.obfuscated_res_0x7f090950);
        this.f = (CoverFlowView) this.b.findViewById(R.id.obfuscated_res_0x7f090951);
        l();
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.b.findViewById(R.id.obfuscated_res_0x7f090952);
        this.g = memberRecommendView;
        memberRecommendView.setFromType(1);
        this.i = new wja(this.a.getPageContext());
        TextView textView = new TextView(this.a.getActivity());
        this.h = textView;
        textView.setHeight(yi.g(this.a.getActivity(), R.dimen.obfuscated_res_0x7f070201));
        this.c.setAdapter((ListAdapter) this.i);
        this.c.setOnItemClickListener(new a(this));
    }

    public final boolean i(List<vja> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list != null && list.size() > 0) {
                this.f.setVisibility(0);
                this.f.setData(list);
                return true;
            }
            this.f.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.hideNetRefreshView(this.b);
            this.c.setVisibility(0);
            this.g.setVisibility(0);
            this.f.setVisibility(0);
        }
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void g() {
        CoverFlowView<vja> coverFlowView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (coverFlowView = this.f) != null) {
            coverFlowView.x();
        }
    }

    public void h() {
        CoverFlowView<vja> coverFlowView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (coverFlowView = this.f) != null) {
            coverFlowView.m();
        }
    }

    public final void l() {
        CoverFlowView<vja> coverFlowView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || (coverFlowView = this.f) == null) {
            return;
        }
        coverFlowView.setCoverFlowFactory(new c(this));
        this.f.setCallback(new d(this));
    }

    @SuppressLint({"ResourceAsColor"})
    public void f() {
        boolean z;
        wja wjaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            q05 layoutMode = this.a.getLayoutMode();
            if (TbadkApplication.getInst().getSkinType() == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.a.getLayoutMode().k(this.b);
            NavigationBar navigationBar = this.d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            NoNetworkView noNetworkView = this.e;
            if (noNetworkView != null) {
                noNetworkView.d(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            CoverFlowView<vja> coverFlowView = this.f;
            if (coverFlowView != null && coverFlowView.getVisibility() == 0) {
                this.f.t();
            }
            BdListView bdListView = this.c;
            if (bdListView != null && bdListView.getVisibility() == 0 && (wjaVar = this.i) != null) {
                wjaVar.notifyDataSetChanged();
            }
            MemberRecommendView memberRecommendView = this.g;
            if (memberRecommendView != null && memberRecommendView.getVisibility() == 0) {
                this.g.d();
            }
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0204);
        }
    }

    public final void j(List<yja> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, list, z) == null) {
            if (list != null && list.size() > 0) {
                if (z) {
                    this.c.removeHeaderView(this.h);
                    this.c.addHeaderView(this.h);
                } else {
                    this.c.removeHeaderView(this.h);
                }
                this.c.setVisibility(0);
                this.i.b(list);
                this.i.notifyDataSetChanged();
                return;
            }
            this.c.setVisibility(8);
        }
    }

    public final boolean k(zja zjaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, zjaVar)) == null) {
            if (zjaVar != null && !StringUtils.isNull(zjaVar.c())) {
                this.g.setVisibility(0);
                this.g.e(zjaVar);
                return true;
            }
            this.g.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            p55 p55Var = new p55(this.a.getPageContext().getPageActivity());
            p55Var.setMessageId(R.string.obfuscated_res_0x7f0f08b1);
            p55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04c1, new b(this));
            p55Var.create(this.a.getPageContext()).show();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.c.setVisibility(8);
            this.f.setVisibility(8);
            this.g.setVisibility(8);
            String string = this.a.getPageContext().getResources().getString(R.string.no_data_text);
            this.a.setNetRefreshViewTopMargin(this.j);
            this.a.showNetRefreshView(this.b, string, false);
        }
    }

    public void o(List<vja> list, zja zjaVar, List<yja> list2, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{list, zjaVar, list2, Boolean.valueOf(z)}) == null) {
            if ((list != null && list.size() > 0) || ((zjaVar != null && !StringUtils.isNull(zjaVar.c())) || (list2 != null && list2.size() > 0))) {
                d();
                boolean i = i(list);
                boolean k = k(zjaVar);
                if (!i && !k) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                j(list2, z2);
                return;
            }
            n();
        }
    }
}
