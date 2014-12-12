package com.baidu.tieba.person;

import android.content.Context;
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
    private String aPY;
    private Context mContext;
    private ProgressBar mProgress = null;
    private bb bGu = null;
    private MultiImageView aPU = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener TL = null;
    private DialogInterface.OnClickListener bqA = null;
    private com.baidu.tbadk.core.view.a aPV = null;

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
        this.mContext = getPageContext().getPageActivity();
        arrayList.add(this.aPY);
        this.aPU.setIsFromCDN(true);
        this.aPU.setAllowLocalUrl(true);
        this.aPU.setUrlData(arrayList);
        this.aPU.setCurrentItem(0, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.aPU.setBackgroundColor(com.baidu.tbadk.core.util.ax.bV(i));
        } else {
            this.aPU.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aPU.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aPU.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.aPU.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m255getInst().delRemoteActivity(this);
        this.aPU.onDestroy();
        if (this.bGu != null) {
            this.bGu.cancel();
            this.bGu = null;
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
        this.mOnClickListener = new ax(this);
        this.TL = new ay(this);
        this.bqA = new az(this);
        this.aPV = new ba(this);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.w.progress);
        this.aPU = (MultiImageView) findViewById(com.baidu.tieba.w.viewpager);
        this.aPU.setPageMargin(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.aPU.x(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.aPU.setItemOnclickListener(this.mOnClickListener);
        this.aPU.setItemOnLongClickListener(this.TL);
        this.aPU.setCurrentItem(0, false);
        this.aPU.setOnScrollOutListener(this.aPV);
        this.aPU.setHasNext(false);
        this.aPU.setNextTitle("mNextTitle");
        this.aPU.setHeadImage(true);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.aPY = bundle.getString("curImgUrl");
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.aPY = intent.getStringExtra("curImgUrl");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("curImgUrl", this.aPY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aPU.setCurrentItem(0, true);
    }
}
