package com.baidu.tieba.newinterest.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.f2.b.a;
import c.a.r0.f2.g.b;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class InterestedForumFragment extends BaseInterestedForumFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f54899e;

    /* renamed from: f  reason: collision with root package name */
    public BdRecyclerView f54900f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f54901g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f54902h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f54903i;

    /* renamed from: j  reason: collision with root package name */
    public a f54904j;
    public FrameLayout k;
    public TBSpecificationBtn l;

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

    public static InterestedForumFragment getInstance(int i2) {
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

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f54904j.f(this.mSelectedInterest);
            showLoadingView(this.f54899e);
        }
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f54903i = (TextView) this.f54899e.findViewById(R.id.interested_desc);
            TextView textView = (TextView) this.f54899e.findViewById(R.id.interested_title);
            this.f54902h = textView;
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            SkinManager.setViewTextColor(this.f54902h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f54903i, R.color.CAM_X0107);
            this.f54900f = (BdRecyclerView) this.f54899e.findViewById(R.id.interested_forum_list_view);
            this.k = (FrameLayout) this.f54899e.findViewById(R.id.bottom_select_layout);
            c.a.q0.s.f0.n.a aVar = new c.a.q0.s.f0.n.a();
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f54899e.findViewById(R.id.interest_forum_selected_btn);
            this.l = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds42);
            this.l.setConfig(aVar);
            this.l.setText(getResources().getString(R.string.try_to_select));
            this.l.setEnabled(false);
            this.l.setOnClickListener(this);
            TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) this.f54899e.findViewById(R.id.select_all_btn);
            this.f54901g = tBSpecificationBtn2;
            tBSpecificationBtn2.setText(getString(R.string.select_all));
            this.f54904j = new a(this, this.f54900f, this.l, this.f54901g, getPageContext(), new b(getUniqueId()));
        }
    }

    public final void initUIListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f54901g.setOnClickListener(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setBackgroundColor(this.f54899e, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f54902h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f54903i, R.color.CAM_X0107);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view) == null) && view == this.f54901g) {
            this.f54904j.j();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f54899e = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_layout, viewGroup, false);
            initUI();
            initUIListener();
            initData();
            if (getArguments() != null) {
                this.mScene = getArguments().getInt("scene");
            }
            return this.f54899e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.newinterest.fragment.BaseInterestedForumFragment
    public void onDataRes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            hideLoadingView(this.f54899e);
        }
    }

    @Override // com.baidu.tieba.newinterest.fragment.BaseInterestedForumFragment
    public void onError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            hideLoadingView(this.f54899e);
            showNetRefreshView(this.f54899e, str, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            hideNetRefreshView(this.f54899e);
            this.f54904j.f(this.mSelectedInterest);
            showLoadingView(this.f54899e);
        }
    }
}
