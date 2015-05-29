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
    private String aZe;
    private HashMap<String, ImageUrlData> bjP;
    private Context mContext;
    private ProgressBar mProgress = null;
    private br bTi = null;
    private MultiImageView aYZ = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener afC = null;
    private com.baidu.tbadk.core.dialog.h bxH = null;
    private com.baidu.tbadk.core.view.a aZa = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.r.person_image_activity);
        initData(bundle);
        initUI();
        ArrayList<String> arrayList = new ArrayList<>();
        this.mContext = getPageContext().getPageActivity();
        arrayList.add(this.aZe);
        this.aYZ.setIsFromCDN(true);
        this.aYZ.setAllowLocalUrl(true);
        this.aYZ.setAssistUrls(this.bjP);
        this.aYZ.setUrlData(arrayList);
        this.aYZ.setCurrentItem(0, false);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        overridePendingTransition(com.baidu.tieba.k.big_imageview_in, com.baidu.tieba.k.fade_out);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        overridePendingTransition(com.baidu.tieba.k.fade_in, com.baidu.tieba.k.big_imageview_out);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.aYZ.setBackgroundColor(com.baidu.tbadk.core.util.ay.ci(i));
        } else {
            this.aYZ.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aYZ.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aYZ.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.aYZ.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
        this.aYZ.onDestroy();
        if (this.bTi != null) {
            this.bTi.cancel();
            this.bTi = null;
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
        this.mOnClickListener = new bn(this);
        this.afC = new bo(this);
        this.bxH = new bp(this);
        this.aZa = new bq(this);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.q.progress);
        this.aYZ = (MultiImageView) findViewById(com.baidu.tieba.q.viewpager);
        this.aYZ.setPageMargin(com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.aYZ.w(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.aYZ.setItemOnclickListener(this.mOnClickListener);
        this.aYZ.setItemOnLongClickListener(this.afC);
        this.aYZ.setCurrentItem(0, false);
        this.aYZ.setOnScrollOutListener(this.aZa);
        this.aYZ.setHasNext(false);
        this.aYZ.setNextTitle("mNextTitle");
        this.aYZ.setHeadImage(true);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.aZe = bundle.getString("curImgUrl");
            this.bjP = (HashMap) bundle.getSerializable("assistUrls");
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.aZe = intent.getStringExtra("curImgUrl");
            this.bjP = (HashMap) intent.getSerializableExtra("assistUrls");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("curImgUrl", this.aZe);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aYZ.setCurrentItem(0, true);
    }
}
