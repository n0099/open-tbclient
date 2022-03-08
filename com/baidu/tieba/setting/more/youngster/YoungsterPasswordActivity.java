package com.baidu.tieba.setting.more.youngster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import c.a.d.f.m.e;
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
/* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YoungsterPasswordActivity f46438e;

        public a(YoungsterPasswordActivity youngsterPasswordActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {youngsterPasswordActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46438e = youngsterPasswordActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46438e.finish();
            }
        }
    }

    public YoungsterPasswordActivity() {
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
        this.finishWithResult = new a(this);
    }

    private void initByType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, this, i2) == null) {
            switch (i2) {
                case 1:
                case 2:
                    this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.youngster_settings_open_title));
                    break;
                case 3:
                    this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.youngster_settings_close_title));
                    break;
                case 4:
                case 5:
                    this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.youngster_setting));
                    break;
                case 6:
                    this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.youngster_setting));
                    break;
            }
            this.mYoungsterPasswordView.initByType(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            this.mYoungsterPasswordView.onChangeSkinType();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            super.onClick(view);
            if (view == this.mBack) {
                this.mYoungsterPasswordView.hideSoftKeyboard();
                e.a().postDelayed(this.finishWithResult, 200L);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.activity_youngster);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mBack = addSystemImageButton;
            addSystemImageButton.setOnClickListener(this);
            YoungsterPasswordView youngsterPasswordView = new YoungsterPasswordView(getPageContext());
            this.mYoungsterPasswordView = youngsterPasswordView;
            ((FrameLayout) findViewById(R.id.youngster_content)).addView(youngsterPasswordView);
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
            e.a().removeCallbacks(this.finishWithResult);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            YoungsterPasswordView youngsterPasswordView = this.mYoungsterPasswordView;
            if (youngsterPasswordView != null) {
                youngsterPasswordView.showSoftKeyboard();
            }
        }
    }
}
