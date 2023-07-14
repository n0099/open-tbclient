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
/* loaded from: classes6.dex */
public class jq8 extends j9<StrangerListActivity> {
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

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jq8 a;

        public a(jq8 jq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jq8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                jq8 jq8Var = this.a;
                jq8Var.S(!jq8Var.l);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StrangerListActivity a;
        public final /* synthetic */ jq8 b;

        public b(jq8 jq8Var, StrangerListActivity strangerListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq8Var, strangerListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jq8Var;
            this.a = strangerListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.p.setVisibility(0);
                this.b.d.setCenterTextTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0756));
                this.b.q.setVisibility(0);
                this.b.S(false);
                this.b.Q(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jq8 a;

        public c(jq8 jq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jq8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.e.W1(true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jq8(StrangerListActivity strangerListActivity) {
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
                super((l9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = false;
        this.j = null;
        this.l = false;
        strangerListActivity.setContentView(R.layout.obfuscated_res_0x7f0d08f3);
        this.e = strangerListActivity;
        N(strangerListActivity);
        O(strangerListActivity);
        M(strangerListActivity);
    }

    public final void O(StrangerListActivity strangerListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, strangerListActivity) == null) {
            this.a = (FrameLayout) strangerListActivity.findViewById(R.id.obfuscated_res_0x7f0917bb);
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

    public void P(List<ImMessageCenterShowItemData> list) {
        StrangerListAdapter strangerListAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, list) == null) && (strangerListAdapter = this.c) != null && this.o != null) {
            strangerListAdapter.u(list);
            if (this.o != null && list != null && list.size() <= 0) {
                this.o.setVisibility(8);
            }
        }
    }

    public void R(boolean z) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048589, this, z) != null) || (tBSpecificationBtn = this.n) == null) {
            return;
        }
        tBSpecificationBtn.setEnabled(z);
    }

    public StrangerListAdapter D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (StrangerListAdapter) invokeV.objValue;
    }

    public BdListView E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (BdListView) invokeV.objValue;
    }

    public View F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.p;
        }
        return (View) invokeV.objValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public FrameLayout H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public NavigationBar I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public NoDataView J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.h;
        }
        return (NoDataView) invokeV.objValue;
    }

    public View L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.q;
        }
        return (View) invokeV.objValue;
    }

    public final void M(StrangerListActivity strangerListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, strangerListActivity) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) strangerListActivity.findViewById(R.id.tip_footer);
            this.j = relativeLayout;
            this.k = (TextView) relativeLayout.findViewById(R.id.select_all_txt);
            int g = yi.g(this.e.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07026f);
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.btn_bgb_choice_n_new, SkinManager.getColor(R.color.CAM_X0111), null);
            pureDrawable.setBounds(0, 0, g, g);
            this.k.setText(this.e.getPageContext().getString(R.string.select_all));
            this.k.setCompoundDrawables(pureDrawable, null, null, null);
            this.k.setOnClickListener(new a(this));
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) strangerListActivity.findViewById(R.id.obfuscated_res_0x7f090536);
            this.m = tBSpecificationBtn;
            tBSpecificationBtn.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f03ce));
            this.m.setTextSize(R.dimen.T_X07);
            ib5 ib5Var = new ib5();
            ib5Var.r(R.color.CAM_X0105);
            this.m.setConfig(ib5Var);
            this.m.setOnClickListener(new b(this, strangerListActivity));
            TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) this.j.findViewById(R.id.delete_txt);
            this.n = tBSpecificationBtn2;
            tBSpecificationBtn2.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f0755));
            this.n.setTextSize(R.dimen.T_X07);
            ib5 ib5Var2 = new ib5();
            ib5Var2.r(R.color.CAM_X0301);
            this.n.setConfig(ib5Var2);
            this.n.setOnClickListener(new c(this));
        }
    }

    public final void N(StrangerListActivity strangerListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, strangerListActivity) == null) {
            NavigationBar navigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
            this.d = navigationBar;
            navigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0756));
            this.d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.d.showBottomLine();
            d85.d(this.d.getCenterText()).D(R.string.F_X02);
            ImageView imageView = (ImageView) this.d.getCenterImgBox();
            this.q = imageView;
            imageView.setOnClickListener(this.e);
            this.q.setVisibility(0);
            int g = yi.g(strangerListActivity, R.dimen.L_X05);
            this.q.setPadding(g, g, g, g);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.q.getLayoutParams();
            layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            layoutParams.width = yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703da);
            layoutParams.height = yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703da);
            this.q.setLayoutParams(layoutParams);
            TextView centerText = this.d.getCenterText();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) centerText.getLayoutParams();
            layoutParams2.rightMargin = 0;
            centerText.setLayoutParams(layoutParams2);
            ImageView imageView2 = (ImageView) this.d.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d08f2, this.e);
            this.p = imageView2;
            WebPManager.setPureDrawable(imageView2, R.drawable.obfuscated_res_0x7f080c09, R.color.CAM_X0105, null);
            WebPManager.setPureDrawable(this.q, R.drawable.obfuscated_res_0x7f080c03, R.color.CAM_X0105, null);
            LinearLayout linearLayout = (LinearLayout) strangerListActivity.findViewById(R.id.obfuscated_res_0x7f091f6a);
            this.f = linearLayout;
            this.g = (NoNetworkView) linearLayout.findViewById(R.id.no_network_view);
        }
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                this.j.setVisibility(0);
                this.c.w(true);
                this.c.notifyDataSetChanged();
                R(this.e.O1());
                this.i = true;
                return;
            }
            this.j.setVisibility(8);
            this.c.w(false);
            this.c.notifyDataSetChanged();
            this.i = false;
        }
    }

    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            int g = yi.g(this.e.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07026f);
            if (z) {
                Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.btn_bgb_choice_s_new, SkinManager.getColor(R.color.CAM_X0304), null);
                pureDrawable.setBounds(0, 0, g, g);
                this.k.setText(this.e.getPageContext().getString(R.string.select_all));
                this.k.setCompoundDrawables(pureDrawable, null, null, null);
                R(true);
                this.l = true;
                this.e.Y1(true);
                return;
            }
            Drawable pureDrawable2 = WebPManager.getPureDrawable(R.drawable.btn_bgb_choice_n_new, SkinManager.getColor(R.color.CAM_X0111), null);
            pureDrawable2.setBounds(0, 0, g, g);
            this.k.setText(this.e.getPageContext().getString(R.string.select_all));
            this.k.setCompoundDrawables(pureDrawable2, null, null, null);
            R(false);
            this.l = false;
            this.e.Y1(false);
        }
    }

    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            q05 layoutMode = this.e.getLayoutMode();
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
            d85 d = d85.d(this.q);
            d.o(R.string.J_X01);
            d.f(R.color.CAM_X0209);
            WebPManager.setPureDrawable(this.p, R.drawable.obfuscated_res_0x7f080c09, R.color.CAM_X0105, null);
            WebPManager.setPureDrawable(this.q, R.drawable.obfuscated_res_0x7f080c03, R.color.CAM_X0105, null);
            NoDataView noDataView = this.h;
            if (noDataView != null) {
                noDataView.f(this.e.getPageContext(), i);
            }
        }
    }
}
