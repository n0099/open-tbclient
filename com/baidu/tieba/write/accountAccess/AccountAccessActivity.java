package com.baidu.tieba.write.accountAccess;

import android.content.Intent;
import android.os.Bundle;
import c.a.s0.n4.t.a;
import c.a.s0.n4.t.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class AccountAccessActivity extends BaseActivity<AccountAccessActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACCOUNT_ACCESS_CANCEL = "http://tieba.baidu.com/account/access/cancel";
    public static final String ACCOUNT_ACCESS_FEEDBACK_HTTP = "http://tieba.baidu.com/account/access/feedback";
    public static final String ACCOUNT_ACCESS_FEEDBACK_HTTPS = "https://tieba.baidu.com/account/access/feedback";
    public static final String ACCOUNT_ACCESS_INPUT_FOCUS = "http://tieba.baidu.com/account/access/input_focus";
    public static final String ACCOUNT_ACCESS_URL = "http://tieba.baidu.com/mo/q/account/access";
    public static final String ACCOUNT_ACCESS_VALID_SUCCESS = "http://tieba.baidu.com/account/access/valid_success";
    public transient /* synthetic */ FieldHolder $fh;
    public AccessState mAccessState;
    public a mPresenter;
    public b mView;
    public WriteData mWriteData;
    public NewWriteModel mWriteModel;

    public AccountAccessActivity() {
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

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    public String joinStrsForH5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AccessState accessState = this.mAccessState;
            if (accessState == null || accessState.getUserInfo() == null) {
                return null;
            }
            return String.format("%s?token=%s&type=%s&strMobile=%s&strEmail=%s", ACCOUNT_ACCESS_URL, this.mAccessState.getToken(), this.mAccessState.getType(), this.mAccessState.getUserInfo().strMobile, this.mAccessState.getUserInfo().strEmail);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                if (i2 == 12006) {
                    setResult(-1, intent);
                }
            } else if (i3 == 0 && i2 == 12006) {
                setResult(0, intent);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            this.mView = new b(this);
            Intent intent = getIntent();
            if (intent == null) {
                return;
            }
            this.mAccessState = (AccessState) intent.getSerializableExtra(AccountAccessActivityConfig.KEY_ACCESS_STATE);
            WriteData writeData = (WriteData) intent.getSerializableExtra(AccountAccessActivityConfig.KEY_WRITE_DATA);
            this.mWriteData = writeData;
            if (writeData != null && this.mAccessState != null) {
                NewWriteModel newWriteModel = new NewWriteModel(this);
                this.mWriteModel = newWriteModel;
                newWriteModel.setWriteData(this.mWriteData);
                if (this.mWriteData.getWriteImagesInfo() != null) {
                    this.mWriteModel.e0(this.mWriteData.getWriteImagesInfo().size() > 0);
                }
                a aVar = new a(this.mView, this.mWriteModel);
                this.mPresenter = aVar;
                this.mView.l(aVar);
                this.mPresenter.h(joinStrsForH5());
                return;
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            this.mView.k();
        }
    }
}
