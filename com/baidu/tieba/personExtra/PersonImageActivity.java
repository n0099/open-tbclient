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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class PersonImageActivity extends BaseActivity<PersonImageActivity> {
    private String dPz;
    private HashMap<String, ImageUrlData> ebz;
    private Context mContext;
    private ProgressBar mProgress = null;
    private a fHK = null;
    private MultiImageView dPu = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener axW = null;
    private b.InterfaceC0086b eqz = null;
    private BaseViewPager.a dPv = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(d.i.person_image_activity);
        initData(bundle);
        initUI();
        ArrayList<String> arrayList = new ArrayList<>();
        this.mContext = getPageContext().getPageActivity();
        arrayList.add(this.dPz);
        this.dPu.setIsFromCDN(true);
        this.dPu.setAllowLocalUrl(true);
        this.dPu.setAssistUrls(this.ebz);
        this.dPu.setUrlData(arrayList);
        this.dPu.setCurrentItem(0, false);
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
            this.dPu.setBackgroundColor(ak.cL(i));
        } else {
            this.dPu.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.dPu.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dPu.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.dPu.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        this.dPu.onDestroy();
        if (this.fHK != null) {
            this.fHK.cancel();
            this.fHK = null;
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
            public void onClick(View view2) {
                PersonImageActivity.this.finish();
            }
        };
        this.axW = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.PersonImageActivity.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                PersonImageActivity.this.createListMenu(new String[]{PersonImageActivity.this.getPageContext().getString(d.k.save)}, PersonImageActivity.this.eqz);
                PersonImageActivity.this.showListMenu();
                return false;
            }
        };
        this.eqz = new b.InterfaceC0086b() { // from class: com.baidu.tieba.personExtra.PersonImageActivity.3
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                if (bVar == PersonImageActivity.this.getListMenu()) {
                    if (i == 0) {
                        try {
                            byte[] currentImageData = PersonImageActivity.this.dPu.getCurrentImageData();
                            if (currentImageData != null) {
                                String currentImageUrl = PersonImageActivity.this.dPu.getCurrentImageUrl();
                                PersonImageActivity.this.fHK = new a(currentImageUrl, currentImageData);
                                PersonImageActivity.this.fHK.execute(new String[0]);
                                PersonImageActivity.this.mProgress.setVisibility(0);
                            } else {
                                PersonImageActivity.this.showToast(PersonImageActivity.this.getPageContext().getString(d.k.no_data));
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                    bVar.dismiss();
                }
            }
        };
        this.dPv = new BaseViewPager.a() { // from class: com.baidu.tieba.personExtra.PersonImageActivity.4
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void cY(int i) {
                if (i == 0) {
                }
            }
        };
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.dPu = (MultiImageView) findViewById(d.g.viewpager);
        this.dPu.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.dPu.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.dPu.setItemOnclickListener(this.mOnClickListener);
        this.dPu.setItemOnLongClickListener(this.axW);
        this.dPu.setCurrentItem(0, false);
        this.dPu.setOnScrollOutListener(this.dPv);
        this.dPu.setHasNext(false);
        this.dPu.setNextTitle("mNextTitle");
        this.dPu.setHeadImage(true);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.dPz = bundle.getString("curImgUrl");
            this.ebz = (HashMap) bundle.getSerializable("assistUrls");
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.dPz = intent.getStringExtra("curImgUrl");
            this.ebz = (HashMap) intent.getSerializableExtra("assistUrls");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("curImgUrl", this.dPz);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.dPu.setCurrentItem(0, true);
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
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            switch (k.a(this.mUrl, this.mData, PersonImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return k.uD();
                case -1:
                default:
                    return PersonImageActivity.this.getPageContext().getString(d.k.save_fail);
                case 0:
                    return PersonImageActivity.this.getPageContext().getString(d.k.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            PersonImageActivity.this.showToast(str);
            PersonImageActivity.this.fHK = null;
            PersonImageActivity.this.mProgress.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonImageActivity.this.fHK = null;
            PersonImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }
    }
}
