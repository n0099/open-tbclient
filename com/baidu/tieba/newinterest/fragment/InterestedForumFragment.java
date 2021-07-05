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
import d.a.s0.d2.b.a;
import d.a.s0.d2.c.b;
import java.util.List;
/* loaded from: classes5.dex */
public class InterestedForumFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f18995e;

    /* renamed from: f  reason: collision with root package name */
    public BdRecyclerView f18996f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f18997g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18998h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f18999i;
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

    public static InterestedForumFragment G0(int i2) {
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

    public int H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.n : invokeV.intValue;
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f18999i = (TextView) this.f18995e.findViewById(R.id.interested_desc);
            TextView textView = (TextView) this.f18995e.findViewById(R.id.interested_title);
            this.f18998h = textView;
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            SkinManager.setViewTextColor(this.f18998h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f18999i, R.color.CAM_X0107);
            this.f18996f = (BdRecyclerView) this.f18995e.findViewById(R.id.interested_forum_list_view);
            this.l = (FrameLayout) this.f18995e.findViewById(R.id.bottom_select_layout);
            d.a.r0.r.f0.m.a aVar = new d.a.r0.r.f0.m.a();
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f18995e.findViewById(R.id.interest_forum_selected_btn);
            this.m = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds42);
            this.m.setConfig(aVar);
            this.m.setText(getResources().getString(R.string.try_to_select));
            this.m.setEnabled(false);
            this.m.setOnClickListener(this);
            TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) this.f18995e.findViewById(R.id.select_all_btn);
            this.f18997g = tBSpecificationBtn2;
            tBSpecificationBtn2.setText(getString(R.string.select_all));
            this.j = new a(this, this.f18996f, this.m, this.f18997g, getPageContext(), new d.a.s0.d2.e.b(getUniqueId()));
        }
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f18997g.setOnClickListener(this);
        }
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            hideLoadingView(this.f18995e);
        }
    }

    public void L0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            hideLoadingView(this.f18995e);
            showNetRefreshView(this.f18995e, str, false);
        }
    }

    public void M0(List<b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.k = list;
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.j.e(this.k);
            showLoadingView(this.f18995e);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setBackgroundColor(this.f18995e, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f18998h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f18999i, R.color.CAM_X0107);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) && view == this.f18997g) {
            this.j.i();
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
            this.f18995e = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_layout, viewGroup, false);
            I0();
            J0();
            initData();
            if (getArguments() != null) {
                this.n = getArguments().getInt("scene");
            }
            return this.f18995e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            hideNetRefreshView(this.f18995e);
            this.j.e(this.k);
            showLoadingView(this.f18995e);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            if (getFragmentManager().getFragments().size() == 2) {
                d.a.s0.d2.d.a.b(2, this.n);
            }
        }
    }
}
