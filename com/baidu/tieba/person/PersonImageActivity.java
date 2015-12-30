package com.baidu.tieba.person;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class PersonImageActivity extends BaseActivity<PersonImageActivity> {
    private String bJZ;
    private HashMap<String, ImageUrlData> bUB;
    private Context mContext;
    private ProgressBar mProgress = null;
    private a cPE = null;
    private MultiImageView bJU = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener amQ = null;
    private c.b ckG = null;
    private BaseViewPager.a bJV = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(n.h.person_image_activity);
        initData(bundle);
        initUI();
        ArrayList<String> arrayList = new ArrayList<>();
        this.mContext = getPageContext().getPageActivity();
        arrayList.add(this.bJZ);
        this.bJU.setIsFromCDN(true);
        this.bJU.setAllowLocalUrl(true);
        this.bJU.setAssistUrls(this.bUB);
        this.bJU.setUrlData(arrayList);
        this.bJU.setCurrentItem(0, false);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.bJU.setBackgroundColor(com.baidu.tbadk.core.util.as.cv(i));
        } else {
            this.bJU.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bJU.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bJU.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.bJU.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
        this.bJU.onDestroy();
        if (this.cPE != null) {
            this.cPE.cancel();
            this.cPE = null;
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
        this.mOnClickListener = new bh(this);
        this.amQ = new bi(this);
        this.ckG = new bj(this);
        this.bJV = new bk(this);
        this.mProgress = (ProgressBar) findViewById(n.g.progress);
        this.bJU = (MultiImageView) findViewById(n.g.viewpager);
        this.bJU.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.bJU.H(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.bJU.setItemOnclickListener(this.mOnClickListener);
        this.bJU.setItemOnLongClickListener(this.amQ);
        this.bJU.setCurrentItem(0, false);
        this.bJU.setOnScrollOutListener(this.bJV);
        this.bJU.setHasNext(false);
        this.bJU.setNextTitle("mNextTitle");
        this.bJU.setHeadImage(true);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.bJZ = bundle.getString("curImgUrl");
            this.bUB = (HashMap) bundle.getSerializable("assistUrls");
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.bJZ = intent.getStringExtra("curImgUrl");
            this.bUB = (HashMap) intent.getSerializableExtra("assistUrls");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("curImgUrl", this.bJZ);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bJU.setCurrentItem(0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        byte[] mData;
        String mUrl;

        public a(String str, byte[] bArr) {
            this.mUrl = null;
            this.mData = null;
            this.mUrl = str;
            this.mData = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.n.a(this.mUrl, this.mData, PersonImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.n.tQ();
                case -1:
                default:
                    return PersonImageActivity.this.getPageContext().getString(n.j.save_error);
                case 0:
                    return PersonImageActivity.this.getPageContext().getString(n.j.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            PersonImageActivity.this.showToast(str);
            PersonImageActivity.this.cPE = null;
            PersonImageActivity.this.mProgress.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonImageActivity.this.cPE = null;
            PersonImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }
    }
}
