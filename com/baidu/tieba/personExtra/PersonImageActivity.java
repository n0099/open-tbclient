package com.baidu.tieba.personExtra;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class PersonImageActivity extends BaseActivity<PersonImageActivity> {
    private String eJF;
    private HashMap<String, ImageUrlData> eVB;
    private Context mContext;
    private ProgressBar mProgress = null;
    private a gyA = null;
    private MultiImageView eJA = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener aTr = null;
    private b.InterfaceC0158b gyB = null;
    private BaseViewPager.a eJB = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(e.h.person_image_activity);
        initData(bundle);
        initUI();
        ArrayList<String> arrayList = new ArrayList<>();
        this.mContext = getPageContext().getPageActivity();
        arrayList.add(this.eJF);
        this.eJA.setIsFromCDN(true);
        this.eJA.setAllowLocalUrl(true);
        this.eJA.setAssistUrls(this.eVB);
        this.eJA.setUrlData(arrayList);
        this.eJA.setCurrentItem(0, false);
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
            this.eJA.setBackgroundColor(al.dM(i));
        } else {
            this.eJA.setBackgroundColor(-16777216);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eJA.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eJA.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eJA.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        this.eJA.onDestroy();
        if (this.gyA != null) {
            this.gyA.cancel();
            this.gyA = null;
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
        this.aTr = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.PersonImageActivity.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                PersonImageActivity.this.createListMenu(new String[]{PersonImageActivity.this.getPageContext().getString(e.j.save)}, PersonImageActivity.this.gyB);
                PersonImageActivity.this.showListMenu();
                return false;
            }
        };
        this.gyB = new b.InterfaceC0158b() { // from class: com.baidu.tieba.personExtra.PersonImageActivity.3
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == PersonImageActivity.this.getListMenu()) {
                    if (i == 0) {
                        try {
                            byte[] currentImageData = PersonImageActivity.this.eJA.getCurrentImageData();
                            if (currentImageData != null) {
                                String currentImageUrl = PersonImageActivity.this.eJA.getCurrentImageUrl();
                                PersonImageActivity.this.gyA = new a(currentImageUrl, currentImageData);
                                PersonImageActivity.this.gyA.execute(new String[0]);
                                PersonImageActivity.this.mProgress.setVisibility(0);
                            } else {
                                PersonImageActivity.this.showToast(PersonImageActivity.this.getPageContext().getString(e.j.no_data));
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                    bVar.dismiss();
                }
            }
        };
        this.eJB = new BaseViewPager.a() { // from class: com.baidu.tieba.personExtra.PersonImageActivity.4
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void eb(int i) {
                if (i == 0) {
                }
            }
        };
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        this.eJA = (MultiImageView) findViewById(e.g.viewpager);
        this.eJA.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.eJA.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eJA.setItemOnclickListener(this.mOnClickListener);
        this.eJA.setItemOnLongClickListener(this.aTr);
        this.eJA.setCurrentItem(0, false);
        this.eJA.setOnScrollOutListener(this.eJB);
        this.eJA.setHasNext(false);
        this.eJA.setNextTitle("mNextTitle");
        this.eJA.setHeadImage(true);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.eJF = bundle.getString("curImgUrl");
            this.eVB = (HashMap) bundle.getSerializable("assistUrls");
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.eJF = intent.getStringExtra("curImgUrl");
            this.eVB = (HashMap) intent.getSerializableExtra("assistUrls");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("curImgUrl", this.eJF);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eJA.setCurrentItem(0, true);
    }

    /* loaded from: classes3.dex */
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
            switch (com.baidu.tbadk.core.util.l.a(this.mUrl, this.mData, PersonImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.l.CH();
                case -1:
                default:
                    return PersonImageActivity.this.getPageContext().getString(e.j.save_fail);
                case 0:
                    return PersonImageActivity.this.getPageContext().getString(e.j.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            PersonImageActivity.this.showToast(str);
            PersonImageActivity.this.gyA = null;
            PersonImageActivity.this.mProgress.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonImageActivity.this.gyA = null;
            PersonImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }
    }
}
