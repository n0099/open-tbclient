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
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class PersonImageActivity extends BaseActivity<PersonImageActivity> {
    private HashMap<String, ImageUrlData> bBP;
    private String brm;
    private Context mContext;
    private ProgressBar mProgress = null;
    private a crU = null;
    private MultiImageView brh = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener ajZ = null;
    private c.b bQn = null;
    private BaseViewPager.a bri = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(i.g.person_image_activity);
        initData(bundle);
        initUI();
        ArrayList<String> arrayList = new ArrayList<>();
        this.mContext = getPageContext().getPageActivity();
        arrayList.add(this.brm);
        this.brh.setIsFromCDN(true);
        this.brh.setAllowLocalUrl(true);
        this.brh.setAssistUrls(this.bBP);
        this.brh.setUrlData(arrayList);
        this.brh.setCurrentItem(0, false);
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
            this.brh.setBackgroundColor(com.baidu.tbadk.core.util.an.cu(i));
        } else {
            this.brh.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.brh.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.brh.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.brh.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
        this.brh.onDestroy();
        if (this.crU != null) {
            this.crU.cancel();
            this.crU = null;
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
        this.mOnClickListener = new bg(this);
        this.ajZ = new bh(this);
        this.bQn = new bi(this);
        this.bri = new bj(this);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
        this.brh = (MultiImageView) findViewById(i.f.viewpager);
        this.brh.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.brh.G(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.brh.setItemOnclickListener(this.mOnClickListener);
        this.brh.setItemOnLongClickListener(this.ajZ);
        this.brh.setCurrentItem(0, false);
        this.brh.setOnScrollOutListener(this.bri);
        this.brh.setHasNext(false);
        this.brh.setNextTitle("mNextTitle");
        this.brh.setHeadImage(true);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.brm = bundle.getString("curImgUrl");
            this.bBP = (HashMap) bundle.getSerializable("assistUrls");
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.brm = intent.getStringExtra("curImgUrl");
            this.bBP = (HashMap) intent.getSerializableExtra("assistUrls");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("curImgUrl", this.brm);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.brh.setCurrentItem(0, true);
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
                    return com.baidu.tbadk.core.util.n.tB();
                case -1:
                default:
                    return PersonImageActivity.this.getPageContext().getString(i.h.save_error);
                case 0:
                    return PersonImageActivity.this.getPageContext().getString(i.h.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            PersonImageActivity.this.showToast(str);
            PersonImageActivity.this.crU = null;
            PersonImageActivity.this.mProgress.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonImageActivity.this.crU = null;
            PersonImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }
    }
}
