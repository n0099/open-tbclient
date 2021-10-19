package com.baidu.tieba.write.vcode.newVcode;

import android.content.Intent;
import android.os.Bundle;
import c.a.q0.t.c.l0;
import c.a.r0.d4.s.a.a.a;
import c.a.r0.d4.s.a.a.b;
import c.a.r0.d4.s.a.a.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class NewVcodeActivity extends BaseActivity<NewVcodeActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NewWriteModel.g mDragVcodePresenterCallback;
    public boolean mNeedFeedBackButton;
    public NewVcodeView mNewVcodeView;
    public int mPageType;
    public b mPresenter;
    public WriteData mWriteData;
    public NewWriteModel mWriteModel;

    public NewVcodeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mWriteData = null;
        this.mPageType = 0;
        this.mDragVcodePresenterCallback = new NewWriteModel.g(this) { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ NewVcodeActivity f58892a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f58892a = this;
            }

            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, l0 l0Var, WriteData writeData, AntiData antiData) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l0Var, writeData, antiData}) == null) || postWriteCallBackData == null || z) {
                    return;
                }
                if (postWriteCallBackData.getErrorCode() == 220015) {
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    this.f58892a.setResult(0, intent);
                    this.f58892a.finish();
                } else if (postWriteCallBackData.getErrorCode() == 220034) {
                    this.f58892a.showToast(postWriteCallBackData.getErrorString());
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    this.f58892a.setResult(0, intent2);
                    this.f58892a.finish();
                } else if (l0Var == null || writeData == null) {
                } else {
                    this.f58892a.mPageType = c.a.e.e.m.b.e("4", 0);
                    this.f58892a.mPresenter.d();
                    this.f58892a.mPresenter.onDestroy();
                    this.f58892a.mWriteData = writeData;
                    this.f58892a.mWriteData.setVcodeMD5(l0Var.b());
                    this.f58892a.mWriteData.setVcodeUrl(l0Var.c());
                    this.f58892a.mWriteData.setVcodeExtra(l0Var.a());
                    this.f58892a.mWriteModel.setWriteData(this.f58892a.mWriteData);
                    NewVcodeActivity newVcodeActivity = this.f58892a;
                    newVcodeActivity.mPresenter = newVcodeActivity.getVcodePresenterFromType();
                    this.f58892a.mPresenter.e(true, postWriteCallBackData.getErrorString());
                    this.f58892a.mNewVcodeView.setPresenter(this.f58892a.mPresenter);
                    this.f58892a.mPresenter.a(this.f58892a.mNeedFeedBackButton);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b getVcodePresenterFromType() {
        InterceptResult invokeV;
        b cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (this.mPageType == c.a.e.e.m.b.e("5", 0)) {
                cVar = new a(this.mNewVcodeView, this.mWriteModel);
            } else {
                cVar = new c(this.mNewVcodeView, this.mWriteModel);
            }
            cVar.c(this.mDragVcodePresenterCallback);
            return cVar;
        }
        return (b) invokeV.objValue;
    }

    private void gotoMainTab() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, this) == null) && (writeData = this.mWriteData) != null && writeData.getType() == 3) {
            c.a.q0.s.a0.b.g(getPageContext().getPageActivity(), 200, false);
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.mNewVcodeView = new NewVcodeView(this);
            if (bundle != null) {
                this.mWriteData = WriteData.fromDraftString(bundle.getString("model"));
                this.mNeedFeedBackButton = bundle.getBoolean(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON);
                this.mPageType = bundle.getInt("page_type");
            } else {
                Intent intent = getIntent();
                this.mWriteData = (WriteData) intent.getSerializableExtra("model");
                this.mNeedFeedBackButton = intent.getBooleanExtra(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON, true);
                this.mPageType = intent.getIntExtra("page_type", 0);
            }
            if (this.mWriteData == null) {
                finish();
                return;
            }
            NewWriteModel newWriteModel = new NewWriteModel(this);
            this.mWriteModel = newWriteModel;
            newWriteModel.setWriteData(this.mWriteData);
            if (this.mWriteData.getWriteImagesInfo() != null) {
                this.mWriteModel.d0(this.mWriteData.getWriteImagesInfo().size() > 0);
            }
            b vcodePresenterFromType = getVcodePresenterFromType();
            this.mPresenter = vcodePresenterFromType;
            this.mNewVcodeView.setPresenter(vcodePresenterFromType);
            this.mPresenter.a(this.mNeedFeedBackButton);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            gotoMainTab();
            this.mPresenter.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            WriteData writeData = this.mWriteData;
            if (writeData != null) {
                bundle.putString("model", writeData.toDraftString());
            }
            bundle.putBoolean(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON, this.mNeedFeedBackButton);
            bundle.putInt("page_type", this.mPageType);
            super.onSaveInstanceState(bundle);
        }
    }
}
