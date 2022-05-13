package com.baidu.tieba.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.lg7;
/* loaded from: classes4.dex */
public class NpsPluginLoadingDialogActivity extends BaseActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView mCancel;
    public long mDialogId;
    public PluginRoundProgressBar mRoundProgressBar;
    public boolean showHideView;

    public NpsPluginLoadingDialogActivity() {
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

    private void hideDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            lg7.j().n();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            clearAnimatable();
            clearAnimation();
            overridePendingTransition(0, 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            clearAnimatable();
            clearAnimation();
            overridePendingTransition(0, 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.finish();
            overridePendingTransition(0, 0);
        }
    }

    public long getDialogId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mDialogId : invokeV.longValue;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onBackPressed();
            hideDialog();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f091312) {
            finish();
            hideDialog();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            requestWindowFeature(1);
            overridePendingTransition(0, 0);
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            setActivityBgTransparent();
            setContentView(R.layout.obfuscated_res_0x7f0d08b3);
            Intent intent = getIntent();
            this.showHideView = intent.getBooleanExtra("showHideView", false);
            this.mDialogId = intent.getLongExtra("dialogId", -1L);
            PluginRoundProgressBar pluginRoundProgressBar = (PluginRoundProgressBar) findViewById(R.id.obfuscated_res_0x7f09197a);
            this.mRoundProgressBar = pluginRoundProgressBar;
            pluginRoundProgressBar.setMax(100);
            this.mRoundProgressBar.setRoundColor(0);
            this.mRoundProgressBar.setTextColor(-1);
            this.mRoundProgressBar.setRoundProgressColor(-1);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091312);
            this.mCancel = textView;
            if (this.showHideView) {
                textView.setVisibility(8);
            }
            this.mCancel.setOnClickListener(this);
            if (!lg7.j().m()) {
                finish();
            } else {
                lg7.j().o(this);
            }
        }
    }

    public void setRoundProgress(int i) {
        PluginRoundProgressBar pluginRoundProgressBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (pluginRoundProgressBar = this.mRoundProgressBar) == null || pluginRoundProgressBar.getProgress() == i) {
            return;
        }
        this.mRoundProgressBar.setProgress(i);
    }
}
