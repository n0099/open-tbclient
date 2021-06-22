package com.baidu.tieba.newfaceshop;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.emotioncenter.CommonEmotionCenterFragment;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class CommonEmotionManagerActivity extends BaseFragmentActivity {
    public static final String FACE_SHOP_URL = "http://tieba.baidu.com/n/interact/emoticoncenter";
    public static final String KEY_LOAD_URL = "key_load_url";
    public CommonEmotionCenterFragment mFragment;
    public FrameLayout mRootView;
    public String mUrl;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CommonEmotionCenterFragment commonEmotionCenterFragment = this.mFragment;
        if (commonEmotionCenterFragment != null) {
            commonEmotionCenterFragment.onDestroy();
        }
        super.onDestroy();
    }
}
