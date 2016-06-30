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
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class PersonImageActivity extends BaseActivity<PersonImageActivity> {
    private String cDP;
    private HashMap<String, ImageUrlData> cPv;
    private Context mContext;
    private ProgressBar cbl = null;
    private a efm = null;
    private MultiImageView cDK = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener aku = null;
    private c.b dgf = null;
    private BaseViewPager.a cDL = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m9getInst().addRemoteActivity(this);
        setContentView(u.h.person_image_activity);
        initData(bundle);
        nl();
        ArrayList<String> arrayList = new ArrayList<>();
        this.mContext = getPageContext().getPageActivity();
        arrayList.add(this.cDP);
        this.cDK.setIsFromCDN(true);
        this.cDK.setAllowLocalUrl(true);
        this.cDK.setAssistUrls(this.cPv);
        this.cDK.setUrlData(arrayList);
        this.cDK.setCurrentItem(0, false);
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
            this.cDK.setBackgroundColor(com.baidu.tbadk.core.util.av.cy(i));
        } else {
            this.cDK.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cDK.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cDK.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.cDK.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m9getInst().delRemoteActivity(this);
        this.cDK.onDestroy();
        if (this.efm != null) {
            this.efm.cancel();
            this.efm = null;
        }
        if (this.cbl != null) {
            this.cbl.setVisibility(8);
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

    private void nl() {
        this.mOnClickListener = new bj(this);
        this.aku = new bk(this);
        this.dgf = new bl(this);
        this.cDL = new bm(this);
        this.cbl = (ProgressBar) findViewById(u.g.progress);
        this.cDK = (MultiImageView) findViewById(u.g.viewpager);
        this.cDK.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.cDK.A(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.cDK.setItemOnclickListener(this.mOnClickListener);
        this.cDK.setItemOnLongClickListener(this.aku);
        this.cDK.setCurrentItem(0, false);
        this.cDK.setOnScrollOutListener(this.cDL);
        this.cDK.setHasNext(false);
        this.cDK.setNextTitle("mNextTitle");
        this.cDK.setHeadImage(true);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.cDP = bundle.getString("curImgUrl");
            this.cPv = (HashMap) bundle.getSerializable("assistUrls");
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.cDP = intent.getStringExtra("curImgUrl");
            this.cPv = (HashMap) intent.getSerializableExtra("assistUrls");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("curImgUrl", this.cDP);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.cDK.setCurrentItem(0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        byte[] hw;
        String mUrl;

        public a(String str, byte[] bArr) {
            this.mUrl = null;
            this.hw = null;
            this.mUrl = str;
            this.hw = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.m.a(this.mUrl, this.hw, PersonImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.m.sV();
                case -1:
                default:
                    return PersonImageActivity.this.getPageContext().getString(u.j.save_error);
                case 0:
                    return PersonImageActivity.this.getPageContext().getString(u.j.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: es */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            PersonImageActivity.this.showToast(str);
            PersonImageActivity.this.efm = null;
            PersonImageActivity.this.cbl.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonImageActivity.this.efm = null;
            PersonImageActivity.this.cbl.setVisibility(8);
            super.cancel(true);
        }
    }
}
