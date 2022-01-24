package com.baidu.tieba.newinterest.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.t0.p2.a.a;
import c.a.t0.p2.b.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NoScrollGridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class InterestSelectionStyleAFragment extends BaseInterestSelectionFragment implements a.InterfaceC1314a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f46319e;

    /* renamed from: f  reason: collision with root package name */
    public View f46320f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f46321g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f46322h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f46323i;

    /* renamed from: j  reason: collision with root package name */
    public NoScrollGridView f46324j;
    public c k;

    public InterestSelectionStyleAFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static InterestSelectionStyleAFragment getInstance(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("scene", i2);
            InterestSelectionStyleAFragment interestSelectionStyleAFragment = new InterestSelectionStyleAFragment();
            interestSelectionStyleAFragment.setArguments(bundle);
            return interestSelectionStyleAFragment;
        }
        return (InterestSelectionStyleAFragment) invokeI.objValue;
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f46319e = this.mRootView.findViewById(R.id.interest_selected_btn_shade);
            this.f46320f = this.mRootView.findViewById(R.id.interest_selected_title_shade);
            this.f46321g = (LinearLayout) this.mRootView.findViewById(R.id.interest_selected_next_ll);
            this.f46324j = (NoScrollGridView) this.mRootView.findViewById(R.id.interest_selection_grid_view);
            this.mInterestSelectedButton = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_selected_btn);
            this.f46322h = (TextView) this.mRootView.findViewById(R.id.interest_selection_title);
            this.f46323i = (TextView) this.mRootView.findViewById(R.id.interest_selection_desc);
            c.a.s0.s.k0.n.a aVar = new c.a.s0.s.k0.n.a();
            this.mInterestSelectedButton.setTextSize(R.dimen.T_X06);
            this.mInterestSelectedButton.setConfig(aVar);
            this.mInterestSelectedButton.setText(getResources().getString(R.string.select_interest_introduce));
            this.mInterestSelectedButton.setEnabled(false);
            this.mInterestSelectedButton.setOnClickListener(this);
            this.f46324j.setColumnWidth(n.k(getContext()) / 5);
            this.f46324j.setAdapter((ListAdapter) this.mInterestSelectionAdapter);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.s0.s.u.c.d(this.mRootView).f(R.color.CAM_X0201);
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.f46322h);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X03);
            d2.A(R.string.F_X02);
            c.a.s0.s.u.c d3 = c.a.s0.s.u.c.d(this.f46323i);
            d3.v(R.color.CAM_X0108);
            d3.z(R.dimen.T_X07);
            d3.A(R.string.F_X01);
            c.a.s0.s.u.c.d(this.f46321g).f(R.color.CAM_X0201);
            c.a.s0.s.u.c.d(this.f46319e).o(new int[]{R.color.CAM_X0201, R.color.CAM_X0612});
            c.a.s0.s.u.c.d(this.f46320f).o(new int[]{R.color.CAM_X0612, R.color.CAM_X0201});
            this.mInterestSelectionAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            c.a.t0.p2.a.c cVar = new c.a.t0.p2.a.c(null, getContext());
            this.mInterestSelectionAdapter = cVar;
            this.k = new c(this, cVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, layoutInflater, viewGroup, bundle)) == null) {
            this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interest_selection_style_a, viewGroup, false);
            initUI();
            showLoadingView(this.mRootView);
            initUIListener();
            if (getArguments() != null) {
                this.mScene = getArguments().getInt("scene");
            }
            return this.mRootView;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            this.k.b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            hideNetRefreshView(this.mRootView);
            this.k.c();
            showLoadingView(this.mRootView);
        }
    }
}
