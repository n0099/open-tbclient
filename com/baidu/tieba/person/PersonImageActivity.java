package com.baidu.tieba.person;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class PersonImageActivity extends BaseActivity<PersonImageActivity> {
    private String aWi;
    private HashMap<String, ImageUrlData> bgT;
    private Context mContext;
    private ProgressBar mProgress = null;
    private ay bQn = null;
    private MultiImageView aWe = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener aeq = null;
    private com.baidu.tbadk.core.dialog.h buJ = null;
    private com.baidu.tbadk.core.view.a aWf = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.w.person_image_activity);
        initData(bundle);
        initUI();
        ArrayList<String> arrayList = new ArrayList<>();
        this.mContext = getPageContext().getPageActivity();
        arrayList.add(this.aWi);
        this.aWe.setIsFromCDN(true);
        this.aWe.setAllowLocalUrl(true);
        this.aWe.setAssistUrls(this.bgT);
        this.aWe.setUrlData(arrayList);
        this.aWe.setCurrentItem(0, false);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        overridePendingTransition(com.baidu.tieba.p.big_imageview_in, com.baidu.tieba.p.fade_out);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        overridePendingTransition(com.baidu.tieba.p.fade_in, com.baidu.tieba.p.big_imageview_out);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.aWe.setBackgroundColor(com.baidu.tbadk.core.util.ba.ce(i));
        } else {
            this.aWe.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aWe.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aWe.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.aWe.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
        this.aWe.onDestroy();
        if (this.bQn != null) {
            this.bQn.cancel();
            this.bQn = null;
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void initUI() {
        this.mOnClickListener = new au(this);
        this.aeq = new av(this);
        this.buJ = new aw(this);
        this.aWf = new ax(this);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.aWe = (MultiImageView) findViewById(com.baidu.tieba.v.viewpager);
        this.aWe.setPageMargin(com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.aWe.v(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.aWe.setItemOnclickListener(this.mOnClickListener);
        this.aWe.setItemOnLongClickListener(this.aeq);
        this.aWe.setCurrentItem(0, false);
        this.aWe.setOnScrollOutListener(this.aWf);
        this.aWe.setHasNext(false);
        this.aWe.setNextTitle("mNextTitle");
        this.aWe.setHeadImage(true);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.aWi = bundle.getString("curImgUrl");
            this.bgT = (HashMap) bundle.getSerializable("assistUrls");
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.aWi = intent.getStringExtra("curImgUrl");
            this.bgT = (HashMap) intent.getSerializableExtra("assistUrls");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("curImgUrl", this.aWi);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aWe.setCurrentItem(0, true);
    }
}
