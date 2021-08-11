package com.baidu.tieba.newfaceshop;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.emotioncenter.CommonEmotionCenterFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class CommonEmotionManagerActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FACE_SHOP_URL = "http://tieba.baidu.com/n/interact/emoticoncenter";
    public static final String KEY_LOAD_URL = "key_load_url";
    public transient /* synthetic */ FieldHolder $fh;
    public CommonEmotionCenterFragment mFragment;
    public FrameLayout mRootView;
    public String mUrl;

    public CommonEmotionManagerActivity() {
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            setContentView(R.layout.common_emotion_manager_activity);
            this.mRootView = (FrameLayout) findViewById(R.id.container);
            if (isUseStyleImmersiveSticky()) {
                ((FrameLayout.LayoutParams) this.mRootView.getLayoutParams()).topMargin = l.r(getPageContext().getPageActivity());
            }
            String stringExtra = getIntent().getStringExtra("url");
            this.mUrl = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                this.mUrl = FACE_SHOP_URL;
            }
            this.mFragment = new CommonEmotionCenterFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putString("key_load_url", this.mUrl);
            this.mFragment.setArguments(bundle2);
            getSupportFragmentManager().beginTransaction().replace(R.id.container, this.mFragment).commit();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            CommonEmotionCenterFragment commonEmotionCenterFragment = this.mFragment;
            if (commonEmotionCenterFragment != null) {
                commonEmotionCenterFragment.onDestroy();
            }
            super.onDestroy();
        }
    }
}
