package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.j;
import b.a.q0.g0.g;
import b.a.q0.g0.h;
import b.a.q0.s.s.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f51894e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f51895f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.o1.c.a f51896g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f51897h;

    /* renamed from: i  reason: collision with root package name */
    public View f51898i;
    public TextView j;
    public NoNetworkView k;
    public GridLineView l;
    public g m;
    public h n;
    public b.a.r0.o1.a.b o;
    public b.a.q0.s.s.a p;
    public boolean q;
    public NoNetworkView.b r;

    /* loaded from: classes9.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LabelSettingView f51899e;

        public a(LabelSettingView labelSettingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {labelSettingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51899e = labelSettingView;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.f51899e.o.getCount() == 0 && this.f51899e.f51896g != null) {
                this.f51899e.f51896g.getLabel();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LabelSettingView f51900e;

        public b(LabelSettingView labelSettingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {labelSettingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51900e = labelSettingView;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f51900e.f51895f.getPageActivity().finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LabelSettingView f51901e;

        public c(LabelSettingView labelSettingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {labelSettingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51901e = labelSettingView;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LabelSettingView f51902e;

        public d(LabelSettingView labelSettingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {labelSettingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51902e = labelSettingView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A() && this.f51902e.f51896g != null) {
                this.f51902e.f51896g.getLabel();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LabelSettingView(TbPageContext<?> tbPageContext, b.a.r0.o1.c.a aVar) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51894e = 3;
        this.r = new a(this);
        this.f51895f = tbPageContext;
        this.f51896g = aVar;
        d(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    public void changeCompleteStatu(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.q = z;
            this.j.setSelected(z);
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.activity_label_setting_layout, (ViewGroup) this, true);
            this.f51897h = (NavigationBar) findViewById(R.id.label_setting_navigation_bar_view);
            this.k = (NoNetworkView) findViewById(R.id.label_setting_no_network_view);
            this.l = (GridLineView) findViewById(R.id.label_setting_gridview);
            this.f51897h.setTitleText(context.getString(R.string.choose_interest_label));
            this.f51898i = this.f51897h.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
            this.j = (TextView) this.f51897h.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.item_label_setting_nav_complete, this);
            this.k.addNetworkChangeListener(this.r);
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f51895f.getPageActivity());
            this.p = aVar;
            aVar.setMessage(this.f51895f.getString(R.string.confirm_give_up_label));
            this.p.setPositiveButton(this.f51895f.getString(R.string.alert_yes_button), new b(this));
            this.p.setNegativeButton(this.f51895f.getString(R.string.cancel), new c(this));
            this.p.create(this.f51895f);
            b.a.r0.o1.a.b bVar = new b.a.r0.o1.a.b(this);
            this.o = bVar;
            this.l.setAdapter((ListAdapter) bVar);
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            NoNetworkView noNetworkView = this.k;
            if (noNetworkView != null) {
                noNetworkView.removeNetworkChangeListener(this.r);
            }
            this.p.dismiss();
            hideLoadingView();
            hideNetRefreshView();
        }
    }

    public boolean hasChangeLabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            b.a.r0.o1.a.b bVar = this.o;
            if (bVar == null) {
                return false;
            }
            return !ListUtils.equalList(bVar.f(), this.o.g());
        }
        return invokeV.booleanValue;
    }

    public void hideLoadingView() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gVar = this.m) == null) {
            return;
        }
        gVar.dettachView(this);
        this.m = null;
    }

    public void hideNetRefreshView() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (hVar = this.n) == null) {
            return;
        }
        hVar.dettachView(this);
        this.n = null;
    }

    public boolean isLoadingViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            g gVar = this.m;
            if (gVar != null) {
                return gVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isRefreshViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            h hVar = this.n;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onChangeSkinType() {
        int skinType;
        NoNetworkView noNetworkView;
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f51894e) {
            return;
        }
        this.f51894e = skinType;
        TbPageContext<?> tbPageContext = this.f51895f;
        if (tbPageContext != null && (navigationBar = this.f51897h) != null) {
            navigationBar.onChangeSkinType(tbPageContext, skinType);
        }
        TextView textView = this.j;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.drawable.color_nav_complete_selector);
        }
        TbPageContext<?> tbPageContext2 = this.f51895f;
        if (tbPageContext2 != null && (noNetworkView = this.k) != null) {
            noNetworkView.onChangeSkinType(tbPageContext2, this.f51894e);
        }
        GridLineView gridLineView = this.l;
        if (gridLineView != null) {
            gridLineView.onChangeSkinType();
        }
        g gVar = this.m;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        h hVar = this.n;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        b.a.r0.o1.a.b bVar = this.o;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
        setBackgroundColor(SkinManager.getColor(this.f51894e, R.color.CAM_X0205));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            if (view == this.f51898i) {
                if (hasChangeLabel()) {
                    showDialog();
                } else {
                    this.f51895f.getPageActivity().finish();
                }
            } else if (view == this.j && this.f51896g != null && this.q) {
                TiebaStatic.log(new StatisticItem("c12237").param("uid", TbadkCoreApplication.getCurrentAccount()));
                this.f51896g.subLabel(this.o.g());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            destroy();
            super.onDetachedFromWindow();
        }
    }

    public void setData(b.a.r0.o1.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) || bVar == null || ListUtils.isEmpty(bVar.b())) {
            return;
        }
        this.l.setVisibility(0);
        this.o.h(bVar);
        this.o.notifyDataSetChanged();
    }

    public void showDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.p.show();
        }
    }

    public void showLoadingView(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || isLoadingViewShowing()) {
            return;
        }
        if (this.m == null) {
            g gVar = new g(getContext());
            this.m = gVar;
            gVar.onChangeSkinType();
        }
        this.m.attachView(this, z);
    }

    public void showNetRefreshView(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || isRefreshViewShowing()) {
            return;
        }
        if (this.n == null) {
            this.n = new h(getContext(), new d(this));
        }
        this.n.j(this.f51895f.getResources().getDimensionPixelSize(R.dimen.ds380));
        this.n.attachView(this, z);
        this.n.o();
        this.l.setVisibility(8);
    }
}
