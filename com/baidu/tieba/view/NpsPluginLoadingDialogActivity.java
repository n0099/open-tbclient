package com.baidu.tieba.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import c.a.t0.b2.e;
import c.a.t0.b2.f;
import c.a.t0.f2.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void hideDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            a.j().n();
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
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view) == null) && view.getId() == e.loading_cancel_text) {
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
            setContentView(f.widget_loading_plugin);
            Intent intent = getIntent();
            this.showHideView = intent.getBooleanExtra("showHideView", false);
            this.mDialogId = intent.getLongExtra("dialogId", -1L);
            PluginRoundProgressBar pluginRoundProgressBar = (PluginRoundProgressBar) findViewById(e.progress_bar);
            this.mRoundProgressBar = pluginRoundProgressBar;
            pluginRoundProgressBar.setMax(100);
            this.mRoundProgressBar.setRoundColor(0);
            this.mRoundProgressBar.setTextColor(-1);
            this.mRoundProgressBar.setRoundProgressColor(-1);
            TextView textView = (TextView) findViewById(e.loading_cancel_text);
            this.mCancel = textView;
            if (this.showHideView) {
                textView.setVisibility(8);
            }
            this.mCancel.setOnClickListener(this);
            if (!a.j().m()) {
                finish();
            } else {
                a.j().o(this);
            }
        }
    }

    public void setRoundProgress(int i2) {
        PluginRoundProgressBar pluginRoundProgressBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (pluginRoundProgressBar = this.mRoundProgressBar) == null || pluginRoundProgressBar.getProgress() == i2) {
            return;
        }
        this.mRoundProgressBar.setProgress(i2);
    }
}
