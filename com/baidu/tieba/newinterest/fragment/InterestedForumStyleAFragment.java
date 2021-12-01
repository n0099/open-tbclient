package com.baidu.tieba.newinterest.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.d.f.p.l;
import c.a.q0.b.d;
import c.a.q0.s.g0.n.a;
import c.a.q0.s.g0.n.c;
import c.a.r0.m2.b.b;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class InterestedForumStyleAFragment extends BaseInterestedForumFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeRecyclerView f47376e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f47377f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f47378g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f47379h;

    /* renamed from: i  reason: collision with root package name */
    public TBSpecificationBtn f47380i;

    /* renamed from: j  reason: collision with root package name */
    public View f47381j;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayout f47382k;
    public View l;
    public b m;

    public InterestedForumStyleAFragment() {
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

    public static InterestedForumStyleAFragment getInstance(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("scene", i2);
            InterestedForumStyleAFragment interestedForumStyleAFragment = new InterestedForumStyleAFragment();
            interestedForumStyleAFragment.setArguments(bundle);
            return interestedForumStyleAFragment;
        }
        return (InterestedForumStyleAFragment) invokeI.objValue;
    }

    public final int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            Context context = getContext();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            return l.f(context, i2);
        }
        return invokeI.intValue;
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.m.g(this.mSelectedInterest);
            showLoadingView(this.mRootView);
        }
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f47379h = (TextView) this.mRootView.findViewById(R.id.interested_desc);
            this.f47378g = (TextView) this.mRootView.findViewById(R.id.interested_title);
            a aVar = new a();
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_forum_selected_btn);
            this.f47380i = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.T_X06);
            this.f47380i.setConfig(aVar);
            this.f47380i.setText(getResources().getString(R.string.interested_forum_attention_hint));
            this.f47380i.setEnabled(false);
            c cVar = new c();
            TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) this.mRootView.findViewById(R.id.select_all_btn);
            this.f47377f = tBSpecificationBtn2;
            tBSpecificationBtn2.setTextSize(R.dimen.T_X06);
            cVar.r(R.color.CAM_X0105);
            this.f47377f.setConfig(cVar);
            this.f47377f.setText(getString(R.string.interested_forum_unselect_all));
            this.f47381j = this.mRootView.findViewById(R.id.interest_forum_selected_btn_shade);
            this.f47382k = (LinearLayout) this.mRootView.findViewById(R.id.interest_forum_selected_next_ll);
            this.l = this.mRootView.findViewById(R.id.interest_forum_selected_title_shade);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.interested_forum_list_view);
            this.f47376e = bdTypeRecyclerView;
            bdTypeRecyclerView.getRecycledViewPool().setMaxRecycledViews(1, 12);
            ((DefaultItemAnimator) this.f47376e.getItemAnimator()).setSupportsChangeAnimations(false);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.f47376e;
            bdTypeRecyclerView2.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView2.getContext()));
            View view = new View(this.f47376e.getContext());
            view.setLayoutParams(new LinearLayout.LayoutParams(-2, b(R.dimen.tbds78)));
            this.f47376e.addHeaderView(view);
            this.m = new b(this, this.f47376e, this.f47380i, this.f47377f, getPageContext(), new c.a.r0.m2.g.b(getUniqueId()), this.mScene);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f47378g);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X03);
            d2.A(R.string.F_X02);
            c.a.q0.s.u.c d3 = c.a.q0.s.u.c.d(this.f47379h);
            d3.v(R.color.CAM_X0108);
            d3.z(R.dimen.T_X07);
            d3.A(R.string.F_X01);
            if (d.B()) {
                SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
                c.a.q0.s.u.c.d(this.f47382k).f(R.color.CAM_X0201);
                c.a.q0.s.u.c.d(this.f47381j).o(new int[]{R.color.CAM_X0201, R.color.CAM_X0612});
                c.a.q0.s.u.c.d(this.l).o(new int[]{R.color.CAM_X0612, R.color.CAM_X0201});
            } else if (d.D()) {
                SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
                c.a.q0.s.u.c.d(this.f47382k).f(R.color.CAM_X0206);
                c.a.q0.s.u.c.d(this.f47381j).o(new int[]{R.color.CAM_X0206, R.color.CAM_X0612});
                c.a.q0.s.u.c.d(this.l).o(new int[]{R.color.CAM_X0612, R.color.CAM_X0206});
            }
            this.f47377f.changeSkinType();
            b bVar = this.m;
            if (bVar != null) {
                bVar.k(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            if (getArguments() != null) {
                this.mScene = getArguments().getInt("scene");
            }
            if (d.B()) {
                this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_style_a_layout, viewGroup, false);
            } else if (d.D()) {
                this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_style_b_layout, viewGroup, false);
            }
            initUI();
            initData();
            return this.mRootView;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            hideNetRefreshView(this.mRootView);
            this.m.g(this.mSelectedInterest);
            showLoadingView(this.mRootView);
        }
    }
}
