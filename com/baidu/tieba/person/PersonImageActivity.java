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
    private String aRc;
    private ProgressBar mProgress = null;
    private ba bIf = null;
    private MultiImageView aQY = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener Un = null;
    private DialogInterface.OnClickListener brX = null;
    private com.baidu.tbadk.core.view.a aQZ = null;

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
        arrayList.add(this.aRc);
        this.aQY.setIsFromCDN(true);
        this.aQY.setAllowLocalUrl(true);
        this.aQY.setUrlData(arrayList);
        this.aQY.setCurrentItem(0, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.aQY.setBackgroundColor(com.baidu.tbadk.core.util.bc.cc(i));
        } else {
            this.aQY.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aQY.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aQY.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.aQY.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m255getInst().delRemoteActivity(this);
        this.aQY.onDestroy();
        if (this.bIf != null) {
            this.bIf.cancel();
            this.bIf = null;
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
        this.Un = new ax(this);
        this.brX = new ay(this);
        this.aQZ = new az(this);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.w.progress);
        this.aQY = (MultiImageView) findViewById(com.baidu.tieba.w.viewpager);
        this.aQY.setPageMargin(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.aQY.x(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.aQY.setItemOnclickListener(this.mOnClickListener);
        this.aQY.setItemOnLongClickListener(this.Un);
        this.aQY.setCurrentItem(0, false);
        this.aQY.setOnScrollOutListener(this.aQZ);
        this.aQY.setHasNext(false);
        this.aQY.setNextTitle("mNextTitle");
        this.aQY.setHeadImage(true);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.aRc = bundle.getString("curImgUrl");
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.aRc = intent.getStringExtra("curImgUrl");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("curImgUrl", this.aRc);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aQY.setCurrentItem(0, true);
    }
}
