package com.baidu.tieba.newinterest.fragment;

import android.view.View;
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
import com.repackage.iq7;
import com.repackage.rq7;
import com.repackage.yq7;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class BaseInterestSelectionFragment extends BaseFragment implements iq7.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public TBSpecificationBtn b;
    public iq7 c;
    public View d;
    public int e;
    public String[] f;

    /* loaded from: classes3.dex */
    public interface a {
        void a(List<rq7> list);
    }

    public BaseInterestSelectionFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (aVar = this.a) == null) {
            return;
        }
        aVar.a(this.c.a());
        StatisticItem statisticItem = new StatisticItem("c13682");
        statisticItem.param("obj_type", 2);
        statisticItem.param("obj_locate", 5);
        TiebaStatic.log(statisticItem);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onResume();
            if (getFragmentManager().getFragments().size() == 1) {
                yq7.c(1, this.e);
            }
        }
    }

    @Override // com.repackage.iq7.a
    public void p1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (i > 0 && !this.b.isEnabled()) {
                this.b.setEnabled(true);
                this.b.setText(getString(R.string.obfuscated_res_0x7f0f0c48));
            } else if (i == 0) {
                this.b.setEnabled(false);
                this.b.setText(getResources().getString(R.string.obfuscated_res_0x7f0f10f0));
            }
        }
    }

    public void r1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c.b(this);
        }
    }

    public void s1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            hideLoadingView(this.d);
        }
    }

    public void t1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            hideLoadingView(this.d);
            showNetRefreshView(this.d, str, false);
        }
    }

    public void u1(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.a = aVar;
        }
    }
}
