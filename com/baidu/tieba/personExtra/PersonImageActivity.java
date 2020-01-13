package com.baidu.tieba.personExtra;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class PersonImageActivity extends BaseActivity<PersonImageActivity> {
    private HashMap<String, ImageUrlData> hBj;
    private String hpn;
    private Context mContext;
    private ProgressBar mProgress = null;
    private a jkN = null;
    private MultiImageView hpi = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private b.a jkO = null;
    private BaseViewPager.a hpj = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(R.layout.person_image_activity);
        initData(bundle);
        initUI();
        ArrayList<String> arrayList = new ArrayList<>();
        this.mContext = getPageContext().getPageActivity();
        arrayList.add(this.hpn);
        this.hpi.setIsFromCDN(true);
        this.hpi.setAllowLocalUrl(true);
        this.hpi.setAssistUrls(this.hBj);
        this.hpi.setUrlData(arrayList);
        this.hpi.setCurrentItem(0, false);
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
        if (i == 1 || i == 4) {
            this.hpi.setBackgroundColor(am.getBgColor(i));
        } else {
            this.hpi.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hpi.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hpi.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.hpi.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        this.hpi.onDestroy();
        if (this.jkN != null) {
            this.jkN.cancel();
            this.jkN = null;
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
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonImageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonImageActivity.this.finish();
            }
        };
        this.mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.PersonImageActivity.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                PersonImageActivity.this.createListMenu(new String[]{PersonImageActivity.this.getPageContext().getString(R.string.save)}, PersonImageActivity.this.jkO);
                PersonImageActivity.this.showListMenu();
                return false;
            }
        };
        this.jkO = new b.a() { // from class: com.baidu.tieba.personExtra.PersonImageActivity.3
            @Override // com.baidu.tbadk.core.dialog.b.a
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == PersonImageActivity.this.getListMenu()) {
                    if (i == 0) {
                        try {
                            byte[] currentImageData = PersonImageActivity.this.hpi.getCurrentImageData();
                            if (currentImageData != null) {
                                String currentImageUrl = PersonImageActivity.this.hpi.getCurrentImageUrl();
                                PersonImageActivity.this.jkN = new a(currentImageUrl, currentImageData);
                                PersonImageActivity.this.jkN.execute(new String[0]);
                                PersonImageActivity.this.mProgress.setVisibility(0);
                            } else {
                                PersonImageActivity.this.showToast(PersonImageActivity.this.getPageContext().getString(R.string.no_data));
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                    bVar.dismiss();
                }
            }
        };
        this.hpj = new BaseViewPager.a() { // from class: com.baidu.tieba.personExtra.PersonImageActivity.4
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void onScrollOut(int i) {
                if (i == 0) {
                }
            }
        };
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.hpi = (MultiImageView) findViewById(R.id.viewpager);
        this.hpi.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.hpi.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.hpi.setItemOnclickListener(this.mOnClickListener);
        this.hpi.setItemOnLongClickListener(this.mOnLongClickListener);
        this.hpi.setCurrentItem(0, false);
        this.hpi.setOnScrollOutListener(this.hpj);
        this.hpi.setHasNext(false);
        this.hpi.setNextTitle("mNextTitle");
        this.hpi.setHeadImage(true);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.hpn = bundle.getString("curImgUrl");
            this.hBj = (HashMap) bundle.getSerializable("assistUrls");
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.hpn = intent.getStringExtra("curImgUrl");
            this.hBj = (HashMap) intent.getSerializableExtra("assistUrls");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("curImgUrl", this.hpn);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.hpi.setCurrentItem(0, true);
    }

    /* loaded from: classes9.dex */
    private class a extends BdAsyncTask<String, Integer, String> {
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
            switch (m.saveImageFileByUser(this.mUrl, this.mData, PersonImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return m.getSdErrorString();
                case -1:
                default:
                    return PersonImageActivity.this.getPageContext().getString(R.string.save_fail);
                case 0:
                    return PersonImageActivity.this.getPageContext().getString(R.string.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            PersonImageActivity.this.showToast(str);
            PersonImageActivity.this.jkN = null;
            PersonImageActivity.this.mProgress.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonImageActivity.this.jkN = null;
            PersonImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }
    }
}
