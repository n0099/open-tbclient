package com.baidu.tieba.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.m59;
import com.baidu.tieba.ox7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class NpsPluginLoadingDialogActivity extends BaseActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PluginRoundProgressBar a;
    public TextView b;
    public boolean c;
    public String d;
    public boolean e;

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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onBackPressed();
            s1();
        }
    }

    public final void s1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.e) {
                ox7.i().l();
            } else {
                m59.j().n();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f091649) {
            finish();
            s1();
        }
    }

    public void u1(int i) {
        PluginRoundProgressBar pluginRoundProgressBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (pluginRoundProgressBar = this.a) != null && pluginRoundProgressBar.getProgress() != i) {
            this.a.setProgress(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            boolean z = true;
            requestWindowFeature(1);
            overridePendingTransition(0, 0);
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            setActivityBgTransparent();
            setContentView(R.layout.obfuscated_res_0x7f0d0a2d);
            Intent intent = getIntent();
            this.c = intent.getBooleanExtra("showHideView", false);
            intent.getLongExtra("dialogId", -1L);
            String stringExtra = intent.getStringExtra("tag");
            this.d = stringExtra;
            this.e = (stringExtra == null || !stringExtra.equals("gameAssistTag")) ? false : false;
            PluginRoundProgressBar pluginRoundProgressBar = (PluginRoundProgressBar) findViewById(R.id.obfuscated_res_0x7f091d8e);
            this.a = pluginRoundProgressBar;
            pluginRoundProgressBar.setMax(100);
            this.a.setRoundColor(0);
            this.a.setTextColor(-1);
            this.a.setRoundProgressColor(-1);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091649);
            this.b = textView;
            if (this.c) {
                textView.setVisibility(8);
            }
            this.b.setOnClickListener(this);
            if (this.e) {
                if (!ox7.i().k()) {
                    finish();
                } else {
                    ox7.i().m(this);
                }
            } else if (!m59.j().m()) {
                finish();
            } else {
                m59.j().o(this);
            }
        }
    }
}
