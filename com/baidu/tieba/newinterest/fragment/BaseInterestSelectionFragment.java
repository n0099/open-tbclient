package com.baidu.tieba.newinterest.fragment;

import android.view.View;
import c.a.q0.e2.a.a;
import c.a.q0.e2.c.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class BaseInterestSelectionFragment extends BaseFragment implements a.InterfaceC0821a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SCENE = "scene";
    public transient /* synthetic */ FieldHolder $fh;
    public TBSpecificationBtn mInterestSelectedButton;
    public c.a.q0.e2.a.a mInterestSelectionAdapter;
    public a mNextStepClickListener;
    public View mRootView;
    public int mScene;

    /* loaded from: classes7.dex */
    public interface a {
        void a(List<b> list);
    }

    public BaseInterestSelectionFragment() {
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

    public void initUIListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mInterestSelectionAdapter.b(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || (aVar = this.mNextStepClickListener) == null) {
            return;
        }
        aVar.a(this.mInterestSelectionAdapter.a());
        StatisticItem statisticItem = new StatisticItem("c13682");
        statisticItem.param("obj_type", 2);
        statisticItem.param("obj_locate", 5);
        TiebaStatic.log(statisticItem);
    }

    public void onDataRes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            hideLoadingView(this.mRootView);
        }
    }

    public void onError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            hideLoadingView(this.mRootView);
            showNetRefreshView(this.mRootView, str, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            if (getFragmentManager().getFragments().size() == 1) {
                c.a.q0.e2.e.a.c(1, this.mScene);
            }
        }
    }

    @Override // c.a.q0.e2.a.a.InterfaceC0821a
    public void onSelectCountChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (i2 > 0 && !this.mInterestSelectedButton.isEnabled()) {
                this.mInterestSelectedButton.setEnabled(true);
                this.mInterestSelectedButton.setText(getString(R.string.next_step));
            } else if (i2 == 0) {
                this.mInterestSelectedButton.setEnabled(false);
                this.mInterestSelectedButton.setText(getResources().getString(R.string.select_interest_introduce));
            }
        }
    }

    public void setNextStepClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.mNextStepClickListener = aVar;
        }
    }
}
