package com.baidu.tieba.newinterest.fragment;

import android.view.View;
import c.a.p0.s2.a.a;
import c.a.p0.s2.c.b;
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
/* loaded from: classes5.dex */
public abstract class BaseInterestSelectionFragment extends BaseFragment implements a.InterfaceC1374a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* renamed from: b  reason: collision with root package name */
    public TBSpecificationBtn f34755b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.s2.a.a f34756c;

    /* renamed from: d  reason: collision with root package name */
    public View f34757d;

    /* renamed from: e  reason: collision with root package name */
    public int f34758e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f34759f;

    /* loaded from: classes5.dex */
    public interface a {
        void a(List<b> list);
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

    @Override // c.a.p0.s2.a.a.InterfaceC1374a
    public void B0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (i > 0 && !this.f34755b.isEnabled()) {
                this.f34755b.setEnabled(true);
                this.f34755b.setText(getString(R.string.obfuscated_res_0x7f0f0c20));
            } else if (i == 0) {
                this.f34755b.setEnabled(false);
                this.f34755b.setText(getResources().getString(R.string.obfuscated_res_0x7f0f10c8));
            }
        }
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f34756c.b(this);
        }
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            hideLoadingView(this.f34757d);
        }
    }

    public void E0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            hideLoadingView(this.f34757d);
            showNetRefreshView(this.f34757d, str, false);
        }
    }

    public void F0(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.a = aVar;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || (aVar = this.a) == null) {
            return;
        }
        aVar.a(this.f34756c.a());
        StatisticItem statisticItem = new StatisticItem("c13682");
        statisticItem.param("obj_type", 2);
        statisticItem.param("obj_locate", 5);
        TiebaStatic.log(statisticItem);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            if (getFragmentManager().getFragments().size() == 1) {
                c.a.p0.s2.e.a.c(1, this.f34758e);
            }
        }
    }
}
