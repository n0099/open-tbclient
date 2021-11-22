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
import b.a.e.f.p.l;
import b.a.q0.b.d;
import b.a.q0.s.g0.n.a;
import b.a.q0.s.g0.n.c;
import b.a.r0.g2.b.b;
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
/* loaded from: classes9.dex */
public class InterestedForumStyleAFragment extends BaseInterestedForumFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeRecyclerView f52914e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f52915f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f52916g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f52917h;

    /* renamed from: i  reason: collision with root package name */
    public TBSpecificationBtn f52918i;
    public View j;
    public LinearLayout k;
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
            return l.g(context, i2);
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
            this.f52917h = (TextView) this.mRootView.findViewById(R.id.interested_desc);
            this.f52916g = (TextView) this.mRootView.findViewById(R.id.interested_title);
            a aVar = new a();
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_forum_selected_btn);
            this.f52918i = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.T_X06);
            this.f52918i.setConfig(aVar);
            this.f52918i.setText(getResources().getString(R.string.interested_forum_attention_hint));
            this.f52918i.setEnabled(false);
            c cVar = new c();
            TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) this.mRootView.findViewById(R.id.select_all_btn);
            this.f52915f = tBSpecificationBtn2;
            tBSpecificationBtn2.setTextSize(R.dimen.T_X06);
            cVar.r(R.color.CAM_X0105);
            this.f52915f.setConfig(cVar);
            this.f52915f.setText(getString(R.string.interested_forum_unselect_all));
            this.j = this.mRootView.findViewById(R.id.interest_forum_selected_btn_shade);
            this.k = (LinearLayout) this.mRootView.findViewById(R.id.interest_forum_selected_next_ll);
            this.l = this.mRootView.findViewById(R.id.interest_forum_selected_title_shade);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.interested_forum_list_view);
            this.f52914e = bdTypeRecyclerView;
            bdTypeRecyclerView.getRecycledViewPool().setMaxRecycledViews(1, 12);
            ((DefaultItemAnimator) this.f52914e.getItemAnimator()).setSupportsChangeAnimations(false);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.f52914e;
            bdTypeRecyclerView2.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView2.getContext()));
            View view = new View(this.f52914e.getContext());
            view.setLayoutParams(new LinearLayout.LayoutParams(-2, b(R.dimen.tbds78)));
            this.f52914e.addHeaderView(view);
            this.m = new b(this, this.f52914e, this.f52918i, this.f52915f, getPageContext(), new b.a.r0.g2.g.b(getUniqueId()), this.mScene);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.f52916g);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X03);
            d2.A(R.string.F_X02);
            b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(this.f52917h);
            d3.v(R.color.CAM_X0108);
            d3.z(R.dimen.T_X07);
            d3.A(R.string.F_X01);
            if (d.z()) {
                SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
                b.a.q0.s.u.c.d(this.k).f(R.color.CAM_X0201);
                b.a.q0.s.u.c.d(this.j).o(new int[]{R.color.CAM_X0201, R.color.CAM_X0612});
                b.a.q0.s.u.c.d(this.l).o(new int[]{R.color.CAM_X0612, R.color.CAM_X0201});
            } else if (d.B()) {
                SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
                b.a.q0.s.u.c.d(this.k).f(R.color.CAM_X0206);
                b.a.q0.s.u.c.d(this.j).o(new int[]{R.color.CAM_X0206, R.color.CAM_X0612});
                b.a.q0.s.u.c.d(this.l).o(new int[]{R.color.CAM_X0612, R.color.CAM_X0206});
            }
            this.f52915f.changeSkinType();
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
            if (d.z()) {
                this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_style_a_layout, viewGroup, false);
            } else if (d.B()) {
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
