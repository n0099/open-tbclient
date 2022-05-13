package com.baidu.tieba.setting.more.youngster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.youngster.YoungsterPasswordView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ng;
/* loaded from: classes4.dex */
public class YoungsterPasswordActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable finishWithResult;
    public View mBack;
    public int mFrom;
    public NavigationBar mNavigationBar;
    public int mPageType;
    public String mPassword;
    public YoungsterPasswordView mYoungsterPasswordView;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YoungsterPasswordActivity a;

        public a(YoungsterPasswordActivity youngsterPasswordActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {youngsterPasswordActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = youngsterPasswordActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.finish();
            }
        }
    }

    public YoungsterPasswordActivity() {
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
        this.finishWithResult = new a(this);
    }

    private void initByType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, this, i) == null) {
            switch (i) {
                case 1:
                case 2:
                    this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f1602));
                    break;
                case 3:
                    this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f15fc));
                    break;
                case 4:
                case 5:
                    this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f15fb));
                    break;
                case 6:
                    this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f15fb));
                    break;
            }
            this.mYoungsterPasswordView.i(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            this.mYoungsterPasswordView.j();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.mBack) {
                this.mYoungsterPasswordView.g();
                ng.a().postDelayed(this.finishWithResult, 200L);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0062);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923fd);
            this.mNavigationBar = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mBack = addSystemImageButton;
            addSystemImageButton.setOnClickListener(this);
            YoungsterPasswordView youngsterPasswordView = new YoungsterPasswordView(getPageContext());
            this.mYoungsterPasswordView = youngsterPasswordView;
            ((FrameLayout) findViewById(R.id.obfuscated_res_0x7f0924ee)).addView(youngsterPasswordView);
            Intent intent = getIntent();
            if (intent != null) {
                int intExtra = intent.getIntExtra(YoungsterPasswordActivityConfig.KEY_YOUNGSTER_PASSWORD_PAGE_TYPE, 0);
                this.mPageType = intExtra;
                initByType(intExtra);
                String stringExtra = intent.getStringExtra(YoungsterPasswordActivityConfig.KEY_YOUNGSTER_PASSWORD_INPUT);
                this.mPassword = stringExtra;
                this.mYoungsterPasswordView.setPrePassword(stringExtra);
                int intExtra2 = intent.getIntExtra(YoungsterPasswordActivityConfig.KEY_YOUNGSTER_PASSWORD_FROM, 0);
                this.mFrom = intExtra2;
                this.mYoungsterPasswordView.setFrom(intExtra2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            ng.a().removeCallbacks(this.finishWithResult);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            YoungsterPasswordView youngsterPasswordView = this.mYoungsterPasswordView;
            if (youngsterPasswordView != null) {
                youngsterPasswordView.k();
            }
        }
    }
}
