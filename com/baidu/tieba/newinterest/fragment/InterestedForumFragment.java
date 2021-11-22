package com.baidu.tieba.newinterest.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.g2.b.a;
import b.a.r0.g2.g.b;
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
/* loaded from: classes9.dex */
public class InterestedForumFragment extends BaseInterestedForumFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f52909e;

    /* renamed from: f  reason: collision with root package name */
    public BdRecyclerView f52910f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f52911g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f52912h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f52913i;
    public a j;
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
            this.j.f(this.mSelectedInterest);
            showLoadingView(this.f52909e);
        }
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f52913i = (TextView) this.f52909e.findViewById(R.id.interested_desc);
            TextView textView = (TextView) this.f52909e.findViewById(R.id.interested_title);
            this.f52912h = textView;
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            SkinManager.setViewTextColor(this.f52912h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f52913i, R.color.CAM_X0107);
            this.f52910f = (BdRecyclerView) this.f52909e.findViewById(R.id.interested_forum_list_view);
            this.k = (FrameLayout) this.f52909e.findViewById(R.id.bottom_select_layout);
            b.a.q0.s.g0.n.a aVar = new b.a.q0.s.g0.n.a();
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f52909e.findViewById(R.id.interest_forum_selected_btn);
            this.l = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds42);
            this.l.setConfig(aVar);
            this.l.setText(getResources().getString(R.string.try_to_select));
            this.l.setEnabled(false);
            this.l.setOnClickListener(this);
            TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) this.f52909e.findViewById(R.id.select_all_btn);
            this.f52911g = tBSpecificationBtn2;
            tBSpecificationBtn2.setText(getString(R.string.select_all));
            this.j = new a(this, this.f52910f, this.l, this.f52911g, getPageContext(), new b(getUniqueId()), this.mScene);
        }
    }

    public final void initUIListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f52911g.setOnClickListener(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setBackgroundColor(this.f52909e, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f52912h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f52913i, R.color.CAM_X0107);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view) == null) && view == this.f52911g) {
            this.j.j();
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
            if (getArguments() != null) {
                this.mScene = getArguments().getInt("scene");
            }
            this.f52909e = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_layout, viewGroup, false);
            initUI();
            initUIListener();
            initData();
            return this.f52909e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.newinterest.fragment.BaseInterestedForumFragment
    public void onDataRes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            hideLoadingView(this.f52909e);
        }
    }

    @Override // com.baidu.tieba.newinterest.fragment.BaseInterestedForumFragment
    public void onError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            hideLoadingView(this.f52909e);
            showNetRefreshView(this.f52909e, str, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            hideNetRefreshView(this.f52909e);
            this.j.f(this.mSelectedInterest);
            showLoadingView(this.f52909e);
        }
    }
}
