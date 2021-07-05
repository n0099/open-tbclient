package com.baidu.tieba.setting.more.youngster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.youngster.view.YoungsterIntroduceView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class YoungsterIntroduceActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mFrom;
    public NavigationBar mNavigationBar;
    public YoungsterIntroduceView mYoungsterIntroduceView;
    public View vBack;

    public YoungsterIntroduceActivity() {
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
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            this.mYoungsterIntroduceView.b();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            super.onClick(view);
            if (view == this.vBack) {
                finish();
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
            this.vBack = addSystemImageButton;
            addSystemImageButton.setOnClickListener(this);
            this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.youngster_settings_open_title));
            Intent intent = getIntent();
            if (intent != null) {
                this.mFrom = intent.getIntExtra(YoungsterPasswordActivityConfig.KEY_YOUNGSTER_PASSWORD_FROM, 0);
            }
            YoungsterIntroduceView youngsterIntroduceView = new YoungsterIntroduceView(getPageContext().getPageActivity());
            this.mYoungsterIntroduceView = youngsterIntroduceView;
            youngsterIntroduceView.setFrom(this.mFrom);
            ((FrameLayout) findViewById(R.id.youngster_content)).addView(this.mYoungsterIntroduceView);
        }
    }
}
