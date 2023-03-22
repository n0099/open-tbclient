package com.baidu.tieba.themeCenter.background;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ik5;
import com.baidu.tieba.ri9;
import com.baidu.tieba.themeCenter.background.BackgroundGroupModel;
import com.baidu.tieba.uh9;
import com.baidu.tieba.vh9;
import com.baidu.tieba.wh9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class BackgroundGroupActivity extends BaseActivity<BackgroundGroupActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BackgroundGroupModel b;
    public vh9 c;
    public wh9 d;
    public BackgroundGroupModel.c e;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tieba.fk5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "b007" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements BackgroundGroupModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BackgroundGroupActivity a;

        public a(BackgroundGroupActivity backgroundGroupActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {backgroundGroupActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = backgroundGroupActivity;
        }

        @Override // com.baidu.tieba.themeCenter.background.BackgroundGroupModel.c
        public void a(int i, String str, ri9 ri9Var, List<uh9> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, ri9Var, list}) == null) {
                BackgroundGroupActivity backgroundGroupActivity = this.a;
                backgroundGroupActivity.hideLoadingView(backgroundGroupActivity.c.d());
                this.a.c.i();
                if (i != 0) {
                    this.a.showToast(str);
                    this.a.c.j();
                    return;
                }
                this.a.c.k(ri9Var, list, this.a.b.a0());
            }
        }
    }

    public BackgroundGroupActivity() {
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
        this.e = new a(this);
    }

    public int B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d.a();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public ik5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        vh9 vh9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.b != null && (vh9Var = this.c) != null) {
            showLoadingView(vh9Var.d());
            this.b.loadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            vh9 vh9Var = this.c;
            if (vh9Var != null) {
                vh9Var.f();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
            this.a = getPageContext();
            BackgroundGroupModel backgroundGroupModel = new BackgroundGroupModel(this);
            this.b = backgroundGroupModel;
            backgroundGroupModel.d0(this.e);
            wh9 wh9Var = new wh9(this.a, this.b.getUniqueId());
            this.d = wh9Var;
            wh9Var.c(1);
            vh9 vh9Var = new vh9(this, this.d);
            this.c = vh9Var;
            vh9Var.e();
            showLoadingView(this.c.d());
            this.b.loadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            if (TbadkCoreApplication.getInst().getThemeWebviewOpen()) {
                TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
                showLoadingView(this.c.d());
                this.b.loadData();
            }
        }
    }
}
