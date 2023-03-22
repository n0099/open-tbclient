package com.baidu.tieba.themeCenter.dressCenter;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.ik5;
import com.baidu.tieba.ni9;
import com.baidu.tieba.pi9;
import com.baidu.tieba.qi9;
import com.baidu.tieba.ri9;
import com.baidu.tieba.themeCenter.dressCenter.DressupCenterModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class DressupCenterActivity extends BaseActivity<DressupCenterActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pi9 a;
    public DressupCenterModel b;
    public DressupCenterModel.b c;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tieba.fk5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "b003" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements DressupCenterModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DressupCenterActivity a;

        public a(DressupCenterActivity dressupCenterActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dressupCenterActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dressupCenterActivity;
        }

        @Override // com.baidu.tieba.themeCenter.dressCenter.DressupCenterModel.b
        public void a(int i, String str, List<ni9> list, ri9 ri9Var, List<qi9> list2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, list, ri9Var, list2}) == null) {
                DressupCenterActivity dressupCenterActivity = this.a;
                dressupCenterActivity.hideLoadingView(dressupCenterActivity.a.e());
                if (i != 0) {
                    this.a.showToast(str);
                    this.a.a.n();
                    return;
                }
                this.a.a.o(list, ri9Var, list2, this.a.b.Y());
            }
        }
    }

    public DressupCenterActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new a(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public ik5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ik5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.a = true;
            }
            return pageStayDurationItem;
        }
        return (ik5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            DressupCenterModel dressupCenterModel = this.b;
            if (dressupCenterModel != null) {
                dressupCenterModel.destroy();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        pi9 pi9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.b != null && (pi9Var = this.a) != null) {
            hideNetRefreshView(pi9Var.e());
            showLoadingView(this.a.e());
            this.b.loadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPause();
            pi9 pi9Var = this.a;
            if (pi9Var != null) {
                pi9Var.g();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            pi9 pi9Var = this.a;
            if (pi9Var != null) {
                pi9Var.h();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            pi9 pi9Var = this.a;
            if (pi9Var != null) {
                pi9Var.f();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            DressupCenterModel dressupCenterModel = new DressupCenterModel(this);
            this.b = dressupCenterModel;
            dressupCenterModel.Z(this.c);
            pi9 pi9Var = new pi9(this);
            this.a = pi9Var;
            showLoadingView(pi9Var.e());
            this.b.loadData();
        }
    }
}
