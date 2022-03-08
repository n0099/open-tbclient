package com.baidu.tieba.newinterest.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.r0.q2.a.a;
import c.a.r0.q2.b.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NoScrollGridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class InterestSelectionStyleAFragment extends BaseInterestSelectionFragment implements a.InterfaceC1320a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f44869e;

    /* renamed from: f  reason: collision with root package name */
    public View f44870f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f44871g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f44872h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f44873i;

    /* renamed from: j  reason: collision with root package name */
    public NoScrollGridView f44874j;
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

    public static InterestSelectionStyleAFragment getInstance(int i2, String[] strArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i2, strArr)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("scene", i2);
            bundle.putStringArray("key_custom_title", strArr);
            InterestSelectionStyleAFragment interestSelectionStyleAFragment = new InterestSelectionStyleAFragment();
            interestSelectionStyleAFragment.setArguments(bundle);
            return interestSelectionStyleAFragment;
        }
        return (InterestSelectionStyleAFragment) invokeIL.objValue;
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f44869e = this.mRootView.findViewById(R.id.interest_selected_btn_shade);
            this.f44870f = this.mRootView.findViewById(R.id.interest_selected_title_shade);
            this.f44871g = (LinearLayout) this.mRootView.findViewById(R.id.interest_selected_next_ll);
            this.f44874j = (NoScrollGridView) this.mRootView.findViewById(R.id.interest_selection_grid_view);
            this.mInterestSelectedButton = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_selected_btn);
            this.f44872h = (TextView) this.mRootView.findViewById(R.id.interest_selection_title);
            this.f44873i = (TextView) this.mRootView.findViewById(R.id.interest_selection_desc);
            String[] strArr = this.mCustomTitle;
            if (strArr != null && strArr.length == 3) {
                this.f44872h.setText(strArr[0]);
                this.f44873i.setText(this.mCustomTitle[1]);
            }
            c.a.q0.r.l0.n.a aVar = new c.a.q0.r.l0.n.a();
            this.mInterestSelectedButton.setTextSize(R.dimen.T_X06);
            this.mInterestSelectedButton.setConfig(aVar);
            this.mInterestSelectedButton.setText(getResources().getString(R.string.select_interest_introduce));
            this.mInterestSelectedButton.setEnabled(false);
            this.mInterestSelectedButton.setOnClickListener(this);
            this.f44874j.setColumnWidth(n.k(getContext()) / 5);
            this.f44874j.setAdapter((ListAdapter) this.mInterestSelectionAdapter);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.q0.r.v.c.d(this.mRootView).f(R.color.CAM_X0201);
            c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(this.f44872h);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X03);
            d2.A(R.string.F_X02);
            c.a.q0.r.v.c d3 = c.a.q0.r.v.c.d(this.f44873i);
            d3.v(R.color.CAM_X0108);
            d3.z(R.dimen.T_X07);
            d3.A(R.string.F_X01);
            c.a.q0.r.v.c.d(this.f44871g).f(R.color.CAM_X0201);
            c.a.q0.r.v.c.d(this.f44869e).o(new int[]{R.color.CAM_X0201, R.color.CAM_X0612});
            c.a.q0.r.v.c.d(this.f44870f).o(new int[]{R.color.CAM_X0612, R.color.CAM_X0201});
            this.mInterestSelectionAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            c.a.r0.q2.a.c cVar = new c.a.r0.q2.a.c(null, getContext());
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
            if (getArguments() != null) {
                this.mScene = getArguments().getInt("scene");
                this.mCustomTitle = getArguments().getStringArray("key_custom_title");
            }
            initUI();
            showLoadingView(this.mRootView);
            initUIListener();
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
