package com.baidu.tieba.write.vcode.newVcode;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.h95;
import com.baidu.tieba.iab;
import com.baidu.tieba.jab;
import com.baidu.tieba.kab;
import com.baidu.tieba.lab;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class NewVcodeActivity extends BaseActivity<NewVcodeActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NewWriteModel a;
    public NewVcodeView b;
    public jab c;
    public WriteData d;
    public int e;
    public NewWriteModel.d f;
    public boolean g;

    public NewVcodeActivity() {
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
        this.d = null;
        this.e = 0;
        this.f = new NewWriteModel.d(this) { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NewVcodeActivity a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, h95 h95Var, WriteData writeData, AntiData antiData) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, h95Var, writeData, antiData}) == null) && postWriteCallBackData != null && !z) {
                    if (postWriteCallBackData.getErrorCode() == 220015) {
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                        intent.putExtras(bundle);
                        this.a.setResult(0, intent);
                        this.a.finish();
                    } else if (postWriteCallBackData.getErrorCode() == 220034) {
                        this.a.showToast(postWriteCallBackData.getErrorString());
                        Intent intent2 = new Intent();
                        Bundle bundle2 = new Bundle();
                        bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                        intent2.putExtras(bundle2);
                        this.a.setResult(0, intent2);
                        this.a.finish();
                    } else if (h95Var != null && writeData != null) {
                        this.a.e = JavaTypesHelper.toInt("4", 0);
                        this.a.c.d();
                        this.a.c.onDestroy();
                        this.a.d = writeData;
                        this.a.d.setVcodeMD5(h95Var.b());
                        this.a.d.setVcodeUrl(h95Var.c());
                        this.a.d.setVcodeExtra(h95Var.a());
                        this.a.a.setWriteData(this.a.d);
                        NewVcodeActivity newVcodeActivity = this.a;
                        newVcodeActivity.c = newVcodeActivity.V0();
                        this.a.c.e(true, postWriteCallBackData.getErrorString());
                        this.a.b.setPresenter(this.a.c);
                        this.a.c.a(this.a.g);
                    }
                }
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            this.c.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            WriteData writeData = this.d;
            if (writeData != null) {
                bundle.putString("model", writeData.toDraftString());
            }
            bundle.putBoolean(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON, this.g);
            bundle.putInt("page_type", this.e);
            super.onSaveInstanceState(bundle);
        }
    }

    public final jab V0() {
        InterceptResult invokeV;
        jab kabVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.e == JavaTypesHelper.toInt("5", 0)) {
                kabVar = new iab(this.b, this.a);
            } else if (this.e == JavaTypesHelper.toInt("4", 0)) {
                kabVar = new lab(this.b, this.a);
            } else {
                kabVar = new kab(this.b, this.a);
            }
            kabVar.c(this.f);
            return kabVar;
        }
        return (jab) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                if (i == 12006) {
                    setResult(-1, intent);
                }
            } else if (i2 == 0 && i == 12006) {
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
            boolean z = false;
            if (bundle != null) {
                this.d = WriteData.fromDraftString(bundle.getString("model"));
                this.g = bundle.getBoolean(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON);
                this.e = bundle.getInt("page_type");
            } else {
                Intent intent = getIntent();
                this.d = (WriteData) intent.getSerializableExtra("model");
                this.g = intent.getBooleanExtra(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON, true);
                this.e = intent.getIntExtra("page_type", 0);
            }
            this.b = new NewVcodeView(this, this.e);
            if (this.d == null) {
                finish();
                return;
            }
            NewWriteModel newWriteModel = new NewWriteModel(this);
            this.a = newWriteModel;
            newWriteModel.setWriteData(this.d);
            if (this.d.getWriteImagesInfo() != null) {
                NewWriteModel newWriteModel2 = this.a;
                if (this.d.getWriteImagesInfo().size() > 0) {
                    z = true;
                }
                newWriteModel2.k0(z);
            }
            jab V0 = V0();
            this.c = V0;
            this.b.setPresenter(V0);
            this.c.a(this.g);
        }
    }
}
