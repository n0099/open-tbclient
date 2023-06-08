package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.immessagecenter.im.stranger.StrangerListActivity;
import com.baidu.tieba.immessagecenter.im.stranger.StrangerListAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class qi8 extends i9<StrangerListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout a;
    public BdListView b;
    public StrangerListAdapter c;
    public NavigationBar d;
    public StrangerListActivity e;
    public ViewGroup f;
    public NoNetworkView g;
    public NoDataView h;
    public boolean i;
    public RelativeLayout j;
    public TextView k;
    public boolean l;
    public TBSpecificationBtn m;
    public TBSpecificationBtn n;
    public TextView o;
    public ImageView p;
    public ImageView q;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qi8 a;

        public a(qi8 qi8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qi8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qi8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                qi8 qi8Var = this.a;
                qi8Var.Q(!qi8Var.l);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StrangerListActivity a;
        public final /* synthetic */ qi8 b;

        public b(qi8 qi8Var, StrangerListActivity strangerListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qi8Var, strangerListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qi8Var;
            this.a = strangerListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.p.setVisibility(0);
                this.b.d.setCenterTextTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0749));
                this.b.q.setVisibility(0);
                this.b.Q(false);
                this.b.O(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qi8 a;

        public c(qi8 qi8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qi8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qi8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.e.Z1(true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qi8(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strangerListActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = false;
        this.j = null;
        this.l = false;
        strangerListActivity.setContentView(R.layout.obfuscated_res_0x7f0d08c3);
        this.e = strangerListActivity;
        K(strangerListActivity);
        M(strangerListActivity);
        J(strangerListActivity);
    }

    public final void M(StrangerListActivity strangerListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, strangerListActivity) == null) {
            this.a = (FrameLayout) strangerListActivity.findViewById(R.id.obfuscated_res_0x7f091778);
            BdListView bdListView = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
            this.b = bdListView;
            bdListView.setOnItemClickListener(strangerListActivity);
            this.b.setOnItemLongClickListener(strangerListActivity);
            StrangerListAdapter strangerListAdapter = new StrangerListAdapter(strangerListActivity);
            this.c = strangerListAdapter;
            this.b.setAdapter((ListAdapter) strangerListAdapter);
            this.h = NoDataViewFactory.a(strangerListActivity.getPageContext().getPageActivity(), this.f, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.a(R.string.no_message_desc), null);
        }
    }

    public void N(List<ImMessageCenterShowItemData> list) {
        StrangerListAdapter strangerListAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, list) == null) && (strangerListAdapter = this.c) != null && this.o != null) {
            strangerListAdapter.t(list);
            if (this.o != null && list != null && list.size() <= 0) {
                this.o.setVisibility(8);
            }
        }
    }

    public void P(boolean z) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048589, this, z) != null) || (tBSpecificationBtn = this.n) == null) {
            return;
        }
        tBSpecificationBtn.setEnabled(z);
    }

    public StrangerListAdapter B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (StrangerListAdapter) invokeV.objValue;
    }

    public BdListView C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (BdListView) invokeV.objValue;
    }

    public View D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.p;
        }
        return (View) invokeV.objValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public FrameLayout F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public NavigationBar G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public NoDataView H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.h;
        }
        return (NoDataView) invokeV.objValue;
    }

    public View I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.q;
        }
        return (View) invokeV.objValue;
    }

    public final void J(StrangerListActivity strangerListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, strangerListActivity) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) strangerListActivity.findViewById(R.id.tip_footer);
            this.j = relativeLayout;
            this.k = (TextView) relativeLayout.findViewById(R.id.select_all_txt);
            int g = vi.g(this.e.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07026f);
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.btn_bgb_choice_n_new, SkinManager.getColor(R.color.CAM_X0111), null);
            pureDrawable.setBounds(0, 0, g, g);
            this.k.setText(this.e.getPageContext().getString(R.string.select_all));
            this.k.setCompoundDrawables(pureDrawable, null, null, null);
            this.k.setOnClickListener(new a(this));
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) strangerListActivity.findViewById(R.id.obfuscated_res_0x7f090536);
            this.m = tBSpecificationBtn;
            tBSpecificationBtn.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f03c9));
            this.m.setTextSize(R.dimen.T_X07);
            ma5 ma5Var = new ma5();
            ma5Var.q(R.color.CAM_X0105);
            this.m.setConfig(ma5Var);
            this.m.setOnClickListener(new b(this, strangerListActivity));
            TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) this.j.findViewById(R.id.delete_txt);
            this.n = tBSpecificationBtn2;
            tBSpecificationBtn2.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f0748));
            this.n.setTextSize(R.dimen.T_X07);
            ma5 ma5Var2 = new ma5();
            ma5Var2.q(R.color.CAM_X0301);
            this.n.setConfig(ma5Var2);
            this.n.setOnClickListener(new c(this));
        }
    }

    public final void K(StrangerListActivity strangerListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, strangerListActivity) == null) {
            NavigationBar navigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
            this.d = navigationBar;
            navigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0749));
            this.d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.d.showBottomLine();
            o75.d(this.d.getCenterText()).C(R.string.F_X02);
            ImageView imageView = (ImageView) this.d.getCenterImgBox();
            this.q = imageView;
            imageView.setOnClickListener(this.e);
            this.q.setVisibility(0);
            int g = vi.g(strangerListActivity, R.dimen.L_X05);
            this.q.setPadding(g, g, g, g);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.q.getLayoutParams();
            layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            layoutParams.width = vi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703d4);
            layoutParams.height = vi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703d4);
            this.q.setLayoutParams(layoutParams);
            TextView centerText = this.d.getCenterText();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) centerText.getLayoutParams();
            layoutParams2.rightMargin = 0;
            centerText.setLayoutParams(layoutParams2);
            ImageView imageView2 = (ImageView) this.d.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d08c2, this.e);
            this.p = imageView2;
            WebPManager.setPureDrawable(imageView2, R.drawable.obfuscated_res_0x7f080bef, R.color.CAM_X0105, null);
            WebPManager.setPureDrawable(this.q, R.drawable.obfuscated_res_0x7f080be9, R.color.CAM_X0105, null);
            LinearLayout linearLayout = (LinearLayout) strangerListActivity.findViewById(R.id.obfuscated_res_0x7f091ed0);
            this.f = linearLayout;
            this.g = (NoNetworkView) linearLayout.findViewById(R.id.no_network_view);
        }
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                this.j.setVisibility(0);
                this.c.v(true);
                this.c.notifyDataSetChanged();
                P(this.e.R1());
                this.i = true;
                return;
            }
            this.j.setVisibility(8);
            this.c.v(false);
            this.c.notifyDataSetChanged();
            this.i = false;
        }
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            int g = vi.g(this.e.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07026f);
            if (z) {
                Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.btn_bgb_choice_s_new, SkinManager.getColor(R.color.CAM_X0304), null);
                pureDrawable.setBounds(0, 0, g, g);
                this.k.setText(this.e.getPageContext().getString(R.string.select_all));
                this.k.setCompoundDrawables(pureDrawable, null, null, null);
                P(true);
                this.l = true;
                this.e.b2(true);
                return;
            }
            Drawable pureDrawable2 = WebPManager.getPureDrawable(R.drawable.btn_bgb_choice_n_new, SkinManager.getColor(R.color.CAM_X0111), null);
            pureDrawable2.setBounds(0, 0, g, g);
            this.k.setText(this.e.getPageContext().getString(R.string.select_all));
            this.k.setCompoundDrawables(pureDrawable2, null, null, null);
            P(false);
            this.l = false;
            this.e.b2(false);
        }
    }

    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            d05 layoutMode = this.e.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.e.getLayoutMode().k(this.f);
            this.d.onChangeSkinType(this.e.getPageContext(), i);
            this.g.d(this.e.getPageContext(), i);
            this.c.notifyDataSetChanged();
            o75 d = o75.d(this.q);
            d.o(R.string.J_X01);
            d.f(R.color.CAM_X0209);
            WebPManager.setPureDrawable(this.p, R.drawable.obfuscated_res_0x7f080bef, R.color.CAM_X0105, null);
            WebPManager.setPureDrawable(this.q, R.drawable.obfuscated_res_0x7f080be9, R.color.CAM_X0105, null);
            NoDataView noDataView = this.h;
            if (noDataView != null) {
                noDataView.f(this.e.getPageContext(), i);
            }
        }
    }
}
