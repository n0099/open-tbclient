package com.baidu.tieba.newinterest.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NoScrollGridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.d2.a.a;
import d.a.s0.d2.c.b;
import java.util.List;
/* loaded from: classes5.dex */
public class InterestSelectionFragment extends BaseFragment implements a.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f18990e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f18991f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f18992g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18993h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f18994i;
    public d.a.s0.d2.e.a j;
    public NoScrollGridView k;
    public d.a.s0.d2.a.a l;
    public a m;
    public int n;

    /* loaded from: classes5.dex */
    public interface a {
        void a(List<b> list);
    }

    public InterestSelectionFragment() {
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

    public static InterestSelectionFragment G0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("scene", i2);
            InterestSelectionFragment interestSelectionFragment = new InterestSelectionFragment();
            interestSelectionFragment.setArguments(bundle);
            return interestSelectionFragment;
        }
        return (InterestSelectionFragment) invokeI.objValue;
    }

    @Override // d.a.s0.d2.a.a.c
    public void F0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (i2 > 0 && !this.f18991f.isEnabled()) {
                this.f18991f.setEnabled(true);
                this.f18991f.setText(getString(R.string.next_step));
            } else if (i2 == 0) {
                this.f18991f.setEnabled(false);
                this.f18991f.setText(getResources().getString(R.string.select_interest_introduce));
            }
        }
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.k = (NoScrollGridView) this.f18990e.findViewById(R.id.interest_selection_grid_view);
            this.f18991f = (TBSpecificationBtn) this.f18990e.findViewById(R.id.interest_selected_btn);
            TextView textView = (TextView) this.f18990e.findViewById(R.id.interest_selection_title);
            this.f18993h = textView;
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            this.f18994i = (TextView) this.f18990e.findViewById(R.id.interest_selection_desc);
            this.f18992g = (FrameLayout) this.f18990e.findViewById(R.id.bottom_select_layout);
            d.a.r0.r.f0.m.a aVar = new d.a.r0.r.f0.m.a();
            this.f18991f.setTextSize(R.dimen.tbds42);
            this.f18991f.setConfig(aVar);
            this.f18991f.setText(getResources().getString(R.string.select_interest_introduce));
            this.f18991f.setEnabled(false);
            this.f18991f.setOnClickListener(this);
            d.a.s0.d2.a.a aVar2 = new d.a.s0.d2.a.a(this.j.c(), getContext());
            this.l = aVar2;
            this.k.setAdapter((ListAdapter) aVar2);
        }
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.l.g(this);
        }
    }

    public void J0(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.m = aVar;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setBackgroundColor(this.f18990e, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f18993h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f18994i, R.color.CAM_X0107);
            SkinManager.setBackgroundColor(this.f18992g, R.color.CAM_X0201);
            this.l.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || (aVar = this.m) == null) {
            return;
        }
        aVar.a(this.l.f());
        StatisticItem statisticItem = new StatisticItem("c13682");
        statisticItem.param("obj_type", 2);
        statisticItem.param("obj_locate", 5);
        TiebaStatic.log(statisticItem);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            this.j = new d.a.s0.d2.e.a();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f18990e = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interest_selection_layout, viewGroup, false);
            H0();
            I0();
            if (getArguments() != null) {
                this.n = getArguments().getInt("scene");
            }
            return this.f18990e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            if (getFragmentManager().getFragments().size() == 1) {
                d.a.s0.d2.d.a.b(1, this.n);
            }
        }
    }
}
