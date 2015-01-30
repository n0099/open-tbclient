package com.baidu.tieba.person;

import android.content.DialogInterface;
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
import com.baidu.tbadk.core.atomData.PersonImageActivityConfig;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PersonImageActivity extends BaseActivity<PersonImageActivity> {
    private String aRd;
    private ProgressBar mProgress = null;
    private ba bIg = null;
    private MultiImageView aQZ = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener Uq = null;
    private DialogInterface.OnClickListener brY = null;
    private com.baidu.tbadk.core.view.a aRa = null;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(PersonImageActivityConfig.class, PersonImageActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.m255getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.x.person_image_activity);
        initData(bundle);
        initUI();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.aRd);
        this.aQZ.setIsFromCDN(true);
        this.aQZ.setAllowLocalUrl(true);
        this.aQZ.setUrlData(arrayList);
        this.aQZ.setCurrentItem(0, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.aQZ.setBackgroundColor(com.baidu.tbadk.core.util.bc.cc(i));
        } else {
            this.aQZ.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aQZ.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aQZ.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.aQZ.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m255getInst().delRemoteActivity(this);
        this.aQZ.onDestroy();
        if (this.bIg != null) {
            this.bIg.cancel();
            this.bIg = null;
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
        this.mOnClickListener = new aw(this);
        this.Uq = new ax(this);
        this.brY = new ay(this);
        this.aRa = new az(this);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.w.progress);
        this.aQZ = (MultiImageView) findViewById(com.baidu.tieba.w.viewpager);
        this.aQZ.setPageMargin(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.aQZ.x(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.aQZ.setItemOnclickListener(this.mOnClickListener);
        this.aQZ.setItemOnLongClickListener(this.Uq);
        this.aQZ.setCurrentItem(0, false);
        this.aQZ.setOnScrollOutListener(this.aRa);
        this.aQZ.setHasNext(false);
        this.aQZ.setNextTitle("mNextTitle");
        this.aQZ.setHeadImage(true);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.aRd = bundle.getString("curImgUrl");
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.aRd = intent.getStringExtra("curImgUrl");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("curImgUrl", this.aRd);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aQZ.setCurrentItem(0, true);
    }
}
