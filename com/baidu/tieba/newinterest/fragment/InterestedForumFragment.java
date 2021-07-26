package com.baidu.tieba.newinterest.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.d2.b.a;
import d.a.q0.d2.c.b;
import java.util.List;
/* loaded from: classes4.dex */
public class InterestedForumFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f19120e;

    /* renamed from: f  reason: collision with root package name */
    public BdRecyclerView f19121f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f19122g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19123h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f19124i;
    public a j;
    public List<b> k;
    public FrameLayout l;
    public TBSpecificationBtn m;
    public int n;

    public InterestedForumFragment() {
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

    public static InterestedForumFragment M0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("scene", i2);
            InterestedForumFragment interestedForumFragment = new InterestedForumFragment();
            interestedForumFragment.setArguments(bundle);
            return interestedForumFragment;
        }
        return (InterestedForumFragment) invokeI.objValue;
    }

    public int N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.n : invokeV.intValue;
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f19124i = (TextView) this.f19120e.findViewById(R.id.interested_desc);
            TextView textView = (TextView) this.f19120e.findViewById(R.id.interested_title);
            this.f19123h = textView;
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            SkinManager.setViewTextColor(this.f19123h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f19124i, R.color.CAM_X0107);
            this.f19121f = (BdRecyclerView) this.f19120e.findViewById(R.id.interested_forum_list_view);
            this.l = (FrameLayout) this.f19120e.findViewById(R.id.bottom_select_layout);
            d.a.p0.s.f0.n.a aVar = new d.a.p0.s.f0.n.a();
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f19120e.findViewById(R.id.interest_forum_selected_btn);
            this.m = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds42);
            this.m.setConfig(aVar);
            this.m.setText(getResources().getString(R.string.try_to_select));
            this.m.setEnabled(false);
            this.m.setOnClickListener(this);
            TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) this.f19120e.findViewById(R.id.select_all_btn);
            this.f19122g = tBSpecificationBtn2;
            tBSpecificationBtn2.setText(getString(R.string.select_all));
            this.j = new a(this, this.f19121f, this.m, this.f19122g, getPageContext(), new d.a.q0.d2.e.b(getUniqueId()));
        }
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f19122g.setOnClickListener(this);
        }
    }

    public void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            hideLoadingView(this.f19120e);
        }
    }

    public void R0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            hideLoadingView(this.f19120e);
            showNetRefreshView(this.f19120e, str, false);
        }
    }

    public void S0(List<b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.k = list;
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.j.e(this.k);
            showLoadingView(this.f19120e);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setBackgroundColor(this.f19120e, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f19123h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f19124i, R.color.CAM_X0107);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) && view == this.f19122g) {
            this.j.h();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f19120e = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_layout, viewGroup, false);
            O0();
            P0();
            initData();
            if (getArguments() != null) {
                this.n = getArguments().getInt("scene");
            }
            return this.f19120e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            hideNetRefreshView(this.f19120e);
            this.j.e(this.k);
            showLoadingView(this.f19120e);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            if (getFragmentManager().getFragments().size() == 2) {
                d.a.q0.d2.d.a.b(2, this.n);
            }
        }
    }
}
