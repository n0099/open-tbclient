package com.baidu.tieba.newfaceshop;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.emotioncenter.CommonEmotionCenterFragment;
/* loaded from: classes8.dex */
public class CommonEmotionManagerActivity extends BaseFragmentActivity {
    private FrameLayout akl;
    private CommonEmotionCenterFragment lBZ;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.common_emotion_manager_activity);
        this.akl = (FrameLayout) findViewById(R.id.container);
        if (isUseStyleImmersiveSticky()) {
            ((FrameLayout.LayoutParams) this.akl.getLayoutParams()).topMargin = l.getStatusBarHeight(getPageContext().getPageActivity());
        }
        this.mUrl = getIntent().getStringExtra("url");
        if (TextUtils.isEmpty(this.mUrl)) {
            this.mUrl = "http://tieba.baidu.com/n/interact/emoticoncenter";
        }
        this.lBZ = new CommonEmotionCenterFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("key_load_url", this.mUrl);
        this.lBZ.setArguments(bundle2);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, this.lBZ).commit();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.lBZ != null) {
            this.lBZ.onDestroy();
        }
        super.onDestroy();
    }
}
