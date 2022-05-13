package com.baidu.tieba.themeCenter.background;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.themeCenter.background.BackgroundGroupModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jq8;
import com.repackage.mp8;
import com.repackage.np8;
import com.repackage.op8;
import com.repackage.p85;
import java.util.List;
/* loaded from: classes4.dex */
public class BackgroundGroupActivity extends BaseActivity<BackgroundGroupActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BackgroundGroupModel.c mCallback;
    public op8 mItemController;
    public BackgroundGroupModel mModel;
    public TbPageContext<?> mPageContext;
    public np8 mView;

    /* loaded from: classes4.dex */
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
        public void a(int i, String str, jq8 jq8Var, List<mp8> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, jq8Var, list}) == null) {
                BackgroundGroupActivity backgroundGroupActivity = this.a;
                backgroundGroupActivity.hideLoadingView(backgroundGroupActivity.mView.d());
                this.a.mView.i();
                if (i == 0) {
                    this.a.mView.k(jq8Var, list, this.a.mModel.H());
                    return;
                }
                this.a.showToast(str);
                this.a.mView.j();
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
        this.mCallback = new a(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.m85
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "b007" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public p85 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            p85 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.a = true;
            }
            return pageStayDurationItem;
        }
        return (p85) invokeV.objValue;
    }

    public int getPropId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mItemController.a() : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            np8 np8Var = this.mView;
            if (np8Var != null) {
                np8Var.f();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
            this.mPageContext = getPageContext();
            BackgroundGroupModel backgroundGroupModel = new BackgroundGroupModel(this);
            this.mModel = backgroundGroupModel;
            backgroundGroupModel.K(this.mCallback);
            op8 op8Var = new op8(this.mPageContext, this.mModel.getUniqueId());
            this.mItemController = op8Var;
            op8Var.c(1);
            np8 np8Var = new np8(this, this.mItemController);
            this.mView = np8Var;
            np8Var.e();
            showLoadingView(this.mView.d());
            this.mModel.loadData();
        }
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
        np8 np8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.mModel == null || (np8Var = this.mView) == null) {
            return;
        }
        showLoadingView(np8Var.d());
        this.mModel.loadData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            if (TbadkCoreApplication.getInst().getThemeWebviewOpen()) {
                TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
                showLoadingView(this.mView.d());
                this.mModel.loadData();
            }
        }
    }
}
