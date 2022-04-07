package com.baidu.tieba.majorsearch;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.R;
import com.baidu.tieba.majorsearch.model.SearchMajorModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gg7;
import java.util.List;
/* loaded from: classes3.dex */
public class SearchMajorActivity extends BaseActivity<SearchMajorActivity> implements SearchMajorModel.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gg7 mController;
    public SearchMajorModel mModel;

    public SearchMajorActivity() {
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

    public void finish(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, intent) == null) {
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            gg7 gg7Var = this.mController;
            if (gg7Var != null) {
                gg7Var.i(i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            this.mController = new gg7(this);
            this.mModel = new SearchMajorModel(getPageContext(), this);
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.b
    public void onError(ErrorData errorData) {
        gg7 gg7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, errorData) == null) || (gg7Var = this.mController) == null || gg7Var.g() == null) {
            return;
        }
        this.mController.m(errorData);
        getRefreshView().h(R.drawable.new_pic_emotion_07);
        showNetRefreshViewNoClick(this.mController.g().d(), null);
        getRefreshView().o(getString(R.string.obfuscated_res_0x7f0f10a4));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            this.mController.j();
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.b
    public void onSuccess(List<String> list) {
        gg7 gg7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || (gg7Var = this.mController) == null || gg7Var.g() == null) {
            return;
        }
        this.mController.l(list);
        hideNetRefreshView(this.mController.g().d());
    }
}
