package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarTipListAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class wa7 extends p9<OfficialBarTipActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;
    public OfficialBarTipListAdapter b;
    public NavigationBar c;
    public NoDataView d;
    public NoNetworkView e;
    public OfficialBarTipActivity f;
    public ViewGroup g;
    public boolean h;
    public RelativeLayout i;
    public TextView j;
    public boolean k;
    public TextView l;
    public View m;
    public TextView n;
    public TextView o;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarTipActivity a;

        public a(wa7 wa7Var, OfficialBarTipActivity officialBarTipActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wa7Var, officialBarTipActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarTipActivity a;
        public final /* synthetic */ wa7 b;

        public b(wa7 wa7Var, OfficialBarTipActivity officialBarTipActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wa7Var, officialBarTipActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wa7Var;
            this.a = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!this.b.h) {
                    if (this.b.f.N1()) {
                        this.b.n.setVisibility(0);
                    }
                    this.b.u(this.a, true);
                    return;
                }
                this.b.u(this.a, false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarTipActivity a;
        public final /* synthetic */ wa7 b;

        public c(wa7 wa7Var, OfficialBarTipActivity officialBarTipActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wa7Var, officialBarTipActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wa7Var;
            this.a = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.L1();
                this.b.u(this.a, false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wa7 a;

        public d(wa7 wa7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wa7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wa7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!this.a.k) {
                    this.a.w(true);
                } else {
                    this.a.w(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarTipActivity a;
        public final /* synthetic */ wa7 b;

        public e(wa7 wa7Var, OfficialBarTipActivity officialBarTipActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wa7Var, officialBarTipActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wa7Var;
            this.a = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.f.X1();
                this.b.u(this.a, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wa7(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {officialBarTipActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = false;
        this.i = null;
        this.k = false;
        officialBarTipActivity.setContentView(R.layout.obfuscated_res_0x7f0d069f);
        this.f = officialBarTipActivity;
        r(officialBarTipActivity);
        s(officialBarTipActivity);
        q(officialBarTipActivity);
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            rq4 layoutMode = this.f.getLayoutMode();
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            layoutMode.l(z);
            this.f.getLayoutMode().k(this.g);
            this.c.onChangeSkinType(this.f.getPageContext(), i);
            SkinManager.setNavbarTitleColor(this.o, R.color.navi_op_text, R.color.obfuscated_res_0x7f0608b2);
            SkinManager.setNavbarTitleColor(this.n, R.color.navi_op_text, R.color.obfuscated_res_0x7f0608b2);
            NoDataView noDataView = this.d;
            if (noDataView != null) {
                noDataView.f(this.f.getPageContext(), i);
            }
            NoNetworkView noNetworkView = this.e;
            if (noNetworkView != null) {
                noNetworkView.d(this.f.getPageContext(), i);
            }
            this.b.notifyDataSetChanged();
        }
    }

    public void t(List<ImMessageCenterShowItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.b.r(list);
            if (list != null && list.size() <= 0) {
                this.o.setVisibility(8);
            }
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                this.l.setAlpha(1.0f);
                this.l.setEnabled(true);
                return;
            }
            this.l.setAlpha(0.3f);
            this.l.setEnabled(false);
        }
    }

    public OfficialBarTipListAdapter o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (OfficialBarTipListAdapter) invokeV.objValue;
    }

    public BdListView p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (BdListView) invokeV.objValue;
    }

    public final void q(OfficialBarTipActivity officialBarTipActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, officialBarTipActivity) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) officialBarTipActivity.findViewById(R.id.obfuscated_res_0x7f09224c);
            this.i = relativeLayout;
            TextView textView = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0907ab);
            this.l = textView;
            textView.setOnClickListener(new c(this, officialBarTipActivity));
            this.j = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091e8b);
            int g = yi.g(this.f.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070225);
            Drawable drawable = SkinManager.getDrawable(R.drawable.btn_bgb_choice_n);
            drawable.setBounds(0, 0, g, g);
            this.j.setText(this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f1136));
            this.j.setCompoundDrawables(drawable, null, null, null);
            this.j.setOnClickListener(new d(this));
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            int g = yi.g(this.f.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070225);
            if (z) {
                Drawable drawable = SkinManager.getDrawable(R.drawable.btn_bgb_choice_s);
                drawable.setBounds(0, 0, g, g);
                this.j.setText(this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f0380));
                this.j.setCompoundDrawables(drawable, null, null, null);
                v(true);
                this.k = true;
                this.f.Z1(true);
                return;
            }
            Drawable drawable2 = SkinManager.getDrawable(R.drawable.btn_bgb_choice_n);
            drawable2.setBounds(0, 0, g, g);
            this.j.setText(this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f1136));
            this.j.setCompoundDrawables(drawable2, null, null, null);
            v(false);
            this.k = false;
            this.f.Z1(false);
        }
    }

    public final void r(OfficialBarTipActivity officialBarTipActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, officialBarTipActivity) == null) {
            NavigationBar navigationBar = (NavigationBar) officialBarTipActivity.findViewById(R.id.obfuscated_res_0x7f092613);
            this.c = navigationBar;
            navigationBar.setCenterTextTitle(officialBarTipActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f1273));
            this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this, officialBarTipActivity));
            this.c.showBottomLine();
            ViewGroup viewGroup = (ViewGroup) officialBarTipActivity.findViewById(R.id.obfuscated_res_0x7f091cd4);
            this.g = viewGroup;
            this.e = (NoNetworkView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091715);
            View inflate = LayoutInflater.from(this.f.getBaseContext()).inflate(R.layout.obfuscated_res_0x7f0d03c3, (ViewGroup) null);
            this.m = inflate;
            inflate.setVisibility(8);
            TextView textView = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f09027e);
            this.n = textView;
            textView.setVisibility(8);
            TextView textView2 = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f090884);
            this.o = textView2;
            textView2.setVisibility(0);
            this.m = this.c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.m, (View.OnClickListener) null);
            this.o.setOnClickListener(new b(this, officialBarTipActivity));
        }
    }

    public final void s(OfficialBarTipActivity officialBarTipActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, officialBarTipActivity) == null) {
            this.a = (BdListView) officialBarTipActivity.findViewById(R.id.obfuscated_res_0x7f0915bb);
            OfficialBarTipListAdapter officialBarTipListAdapter = new OfficialBarTipListAdapter(officialBarTipActivity);
            this.b = officialBarTipListAdapter;
            this.a.setAdapter((ListAdapter) officialBarTipListAdapter);
            this.d = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.g, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0d18), null);
        }
    }

    public final void u(OfficialBarTipActivity officialBarTipActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, officialBarTipActivity, z) == null) {
            if (z) {
                this.i.setVisibility(0);
                this.b.s(true);
                this.b.notifyDataSetChanged();
                if (officialBarTipActivity.O1()) {
                    v(true);
                } else {
                    v(false);
                }
                this.o.setText(officialBarTipActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0377));
                this.n.setOnClickListener(new e(this, officialBarTipActivity));
                this.h = true;
                return;
            }
            this.i.setVisibility(8);
            this.n.setVisibility(8);
            this.b.s(false);
            this.b.notifyDataSetChanged();
            this.o.setText(officialBarTipActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0540));
            this.h = false;
        }
    }
}
