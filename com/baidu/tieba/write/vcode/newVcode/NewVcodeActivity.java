package com.baidu.tieba.write.vcode.newVcode;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.dz4;
import com.baidu.tieba.ou4;
import com.baidu.tieba.pg;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.v09;
import com.baidu.tieba.w09;
import com.baidu.tieba.x09;
import com.baidu.tieba.y09;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class NewVcodeActivity extends BaseActivity<NewVcodeActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NewWriteModel a;
    public NewVcodeView b;
    public w09 c;
    public WriteData d;
    public int e;
    public NewWriteModel.e f;
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
        this.f = new NewWriteModel.e(this) { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity.1
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

            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, dz4 dz4Var, WriteData writeData, AntiData antiData) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, dz4Var, writeData, antiData}) == null) || postWriteCallBackData == null || z) {
                    return;
                }
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
                } else if (dz4Var == null || writeData == null) {
                } else {
                    this.a.e = pg.e("4", 0);
                    this.a.c.d();
                    this.a.c.onDestroy();
                    this.a.d = writeData;
                    this.a.d.setVcodeMD5(dz4Var.b());
                    this.a.d.setVcodeUrl(dz4Var.c());
                    this.a.d.setVcodeExtra(dz4Var.a());
                    this.a.a.setWriteData(this.a.d);
                    NewVcodeActivity newVcodeActivity = this.a;
                    newVcodeActivity.c = newVcodeActivity.I1();
                    this.a.c.e(true, postWriteCallBackData.getErrorString());
                    this.a.b.setPresenter(this.a.c);
                    this.a.c.a(this.a.g);
                }
            }
        };
    }

    public final w09 I1() {
        InterceptResult invokeV;
        w09 x09Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.e == pg.e("5", 0)) {
                x09Var = new v09(this.b, this.a);
            } else if (this.e == pg.e("4", 0)) {
                x09Var = new y09(this.b, this.a);
            } else {
                x09Var = new x09(this.b, this.a);
            }
            x09Var.c(this.f);
            return x09Var;
        }
        return (w09) invokeV.objValue;
    }

    public final void J1() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (writeData = this.d) != null && writeData.getType() == 3) {
            ou4.g(getPageContext().getPageActivity(), 200, false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048580, this, i, i2, intent) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
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
                this.a.b0(this.d.getWriteImagesInfo().size() > 0);
            }
            w09 I1 = I1();
            this.c = I1;
            this.b.setPresenter(I1);
            this.c.a(this.g);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            J1();
            this.c.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            WriteData writeData = this.d;
            if (writeData != null) {
                bundle.putString("model", writeData.toDraftString());
            }
            bundle.putBoolean(NewVcodeActivityConfig.NEED_FEED_BACK_BUTTON, this.g);
            bundle.putInt("page_type", this.e);
            super.onSaveInstanceState(bundle);
        }
    }
}
