package com.baidu.tieba.view.clipcover;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.VideoCoverSelectActivityConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class VideoCoverSelectActivity extends BaseActivity<VideoCoverSelectActivity> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View mBack;
    public CoverSelectLayout mCoverSelsctLayout;
    public String mImagePath;
    public NavigationBar mNavigationBar;
    public TextView mSave;
    public TextView mTitle;
    public int mType;

    public VideoCoverSelectActivity() {
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

    private void generateUriAndReturn() {
        Bitmap c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (c = this.mCoverSelsctLayout.c()) == null) {
            return;
        }
        String str = getIntent().getBooleanExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, false) ? "tbNewVideo/temp/" : "tbVideo/temp/";
        String saveBitmapByRelativelyPath = FileHelper.saveBitmapByRelativelyPath(str, System.currentTimeMillis() + ".jpg", c, 90);
        Intent intent = new Intent();
        intent.putExtra(VideoCoverSelectActivityConfig.KEY_VIDEO_COVER_IMAGE_PATH, saveBitmapByRelativelyPath);
        setResult(-1, intent);
        finish();
    }

    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mCoverSelsctLayout = (CoverSelectLayout) findViewById(R.id.obfuscated_res_0x7f09071b);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f092397);
            this.mNavigationBar = navigationBar;
            TextView centerTextTitle = navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0e41));
            this.mTitle = centerTextTitle;
            centerTextTitle.setTextColor(getResources().getColor(R.color.CAM_X0101));
            View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mBack = addSystemImageButton;
            ((ImageView) addSystemImageButton.findViewById(R.id.obfuscated_res_0x7f09244b)).setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809c8));
            TextView addTextButton = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.obfuscated_res_0x7f0f0c22));
            this.mSave = addTextButton;
            addTextButton.setTextColor(getResources().getColor(R.color.CAM_X0101));
            this.mBack.setOnClickListener(this);
            this.mSave.setOnClickListener(this);
            this.mCoverSelsctLayout.setVisibility(0);
            this.mCoverSelsctLayout.setClipType(this.mType);
            this.mCoverSelsctLayout.setImagSrc(this.mImagePath);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            if (view2 == this.mBack) {
                finish();
            } else if (view2 == this.mSave) {
                generateUriAndReturn();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            setContentView(R.layout.obfuscated_res_0x7f0d0030);
            if (getIntent() != null) {
                this.mType = getIntent().getIntExtra(VideoCoverSelectActivityConfig.KEY_VIDEO_COVER_TYPE, 1);
                this.mImagePath = getIntent().getStringExtra(VideoCoverSelectActivityConfig.KEY_VIDEO_COVER_IMAGE_PATH);
            }
            initView();
            this.mCoverSelsctLayout.setClipType(this.mType);
        }
    }
}
