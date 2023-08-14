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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AvatarPendantActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackdropGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardCategoryActivityConfig;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.m45;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.dressCenter.DressupCenterActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class pia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DressupCenterActivity a;
    public View b;
    public BdListView c;
    public NavigationBar d;
    public NoNetworkView e;
    public CoverFlowView<nia> f;
    public MemberRecommendView g;
    public TextView h;
    public oia i;
    public int j;

    /* loaded from: classes7.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pia a;

        public a(pia piaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {piaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = piaVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            qia item;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || (item = this.a.i.getItem(i)) == null) {
                return;
            }
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            sharedPrefHelper.putLong("dressup_center_red_tip_" + TbadkCoreApplication.getCurrentAccount() + "_" + item.getType(), item.c());
            this.a.i.notifyDataSetChanged();
            if (StringUtils.isNull(item.getType())) {
                return;
            }
            String type = item.getType();
            int i2 = JavaTypesHelper.toInt(type, 0);
            CustomMessage customMessage = null;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
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

    /* loaded from: classes7.dex */
    public class b implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(pia piaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {piaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a75 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.a75
        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        public c(pia piaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {piaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.a75
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

        @Override // com.baidu.tieba.a75
        public d75 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d75 d75Var = new d75();
                d75Var.c(R.drawable.icon_diandian_white_n);
                d75Var.g(R.drawable.icon_diandian_white_s);
                d75Var.h(R.dimen.obfuscated_res_0x7f070198);
                d75Var.d(85);
                d75Var.f(R.dimen.obfuscated_res_0x7f070201);
                d75Var.e(R.dimen.obfuscated_res_0x7f0701d5);
                return d75Var;
            }
            return (d75) invokeV.objValue;
        }

        @Override // com.baidu.tieba.a75
        public g75 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                g75 g75Var = new g75();
                g75Var.a(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703b0));
                return g75Var;
            }
            return (g75) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements e75<nia> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pia a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.e75
        /* renamed from: c */
        public void a(int i, nia niaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, niaVar) == null) {
            }
        }

        public d(pia piaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {piaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = piaVar;
        }

        @Override // com.baidu.tieba.e75
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                TiebaStatic.log("c10262");
                UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{str});
            }
        }
    }

    public pia(DressupCenterActivity dressupCenterActivity) {
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
        this.j = BdUtilHelper.getDimens(dressupCenterActivity.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070364);
        View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d027a, (ViewGroup) null);
        this.b = inflate;
        this.a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.view_navigation_bar);
        this.d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.setCenterTextTitle(this.a.getPageContext().getString(R.string.dressup_center_title));
        this.e = (NoNetworkView) this.b.findViewById(R.id.view_no_network);
        this.c = (BdListView) this.b.findViewById(R.id.obfuscated_res_0x7f09095f);
        this.f = (CoverFlowView) this.b.findViewById(R.id.obfuscated_res_0x7f090960);
        l();
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.b.findViewById(R.id.obfuscated_res_0x7f090961);
        this.g = memberRecommendView;
        memberRecommendView.setFromType(1);
        this.i = new oia(this.a.getPageContext());
        TextView textView = new TextView(this.a.getActivity());
        this.h = textView;
        textView.setHeight(BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.obfuscated_res_0x7f070201));
        this.c.setAdapter((ListAdapter) this.i);
        this.c.setOnItemClickListener(new a(this));
    }

    public final boolean i(List<nia> list) {
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
        CoverFlowView<nia> coverFlowView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (coverFlowView = this.f) != null) {
            coverFlowView.x();
        }
    }

    public void h() {
        CoverFlowView<nia> coverFlowView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (coverFlowView = this.f) != null) {
            coverFlowView.m();
        }
    }

    public final void l() {
        CoverFlowView<nia> coverFlowView;
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
        oia oiaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BDLayoutMode layoutMode = this.a.getLayoutMode();
            if (TbadkApplication.getInst().getSkinType() == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.a.getLayoutMode().onModeChanged(this.b);
            NavigationBar navigationBar = this.d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            NoNetworkView noNetworkView = this.e;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            CoverFlowView<nia> coverFlowView = this.f;
            if (coverFlowView != null && coverFlowView.getVisibility() == 0) {
                this.f.t();
            }
            BdListView bdListView = this.c;
            if (bdListView != null && bdListView.getVisibility() == 0 && (oiaVar = this.i) != null) {
                oiaVar.notifyDataSetChanged();
            }
            MemberRecommendView memberRecommendView = this.g;
            if (memberRecommendView != null && memberRecommendView.getVisibility() == 0) {
                this.g.d();
            }
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0204);
        }
    }

    public final void j(List<qia> list, boolean z) {
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

    public final boolean k(ria riaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, riaVar)) == null) {
            if (riaVar != null && !StringUtils.isNull(riaVar.c())) {
                this.g.setVisibility(0);
                this.g.e(riaVar);
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
            m45 m45Var = new m45(this.a.getPageContext().getPageActivity());
            m45Var.setMessageId(R.string.obfuscated_res_0x7f0f08b2);
            m45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04c1, new b(this));
            m45Var.create(this.a.getPageContext()).show();
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

    public void o(List<nia> list, ria riaVar, List<qia> list2, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{list, riaVar, list2, Boolean.valueOf(z)}) == null) {
            if ((list != null && list.size() > 0) || ((riaVar != null && !StringUtils.isNull(riaVar.c())) || (list2 != null && list2.size() > 0))) {
                d();
                boolean i = i(list);
                boolean k = k(riaVar);
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
