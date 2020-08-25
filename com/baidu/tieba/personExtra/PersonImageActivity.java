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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes18.dex */
public class PersonImageActivity extends BaseActivity<PersonImageActivity> {
    private String jeA;
    private HashMap<String, ImageUrlData> jsB;
    private Context mContext;
    private ProgressBar mProgress = null;
    private a ljH = null;
    private MultiImageView jev = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private b.InterfaceC0538b ljI = null;
    private BaseViewPager.a jew = null;

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
        arrayList.add(this.jeA);
        this.jev.setIsFromCDN(true);
        this.jev.setAllowLocalUrl(true);
        this.jev.setAssistUrls(this.jsB);
        this.jev.setUrlData(arrayList);
        this.jev.setCurrentItem(0, false);
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
            this.jev.setBackgroundColor(ap.getBgColor(i));
        } else {
            this.jev.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.jev.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jev.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.jev.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        this.jev.onDestroy();
        if (this.ljH != null) {
            this.ljH.cancel();
            this.ljH = null;
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
                PersonImageActivity.this.createListMenu(new String[]{PersonImageActivity.this.getPageContext().getString(R.string.save)}, PersonImageActivity.this.ljI);
                PersonImageActivity.this.showListMenu();
                return false;
            }
        };
        this.ljI = new b.InterfaceC0538b() { // from class: com.baidu.tieba.personExtra.PersonImageActivity.3
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar == PersonImageActivity.this.getListMenu()) {
                    if (i == 0) {
                        try {
                            byte[] currentImageData = PersonImageActivity.this.jev.getCurrentImageData();
                            if (currentImageData != null) {
                                String currentImageUrl = PersonImageActivity.this.jev.getCurrentImageUrl();
                                PersonImageActivity.this.ljH = new a(currentImageUrl, currentImageData);
                                PersonImageActivity.this.ljH.execute(new String[0]);
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
        this.jew = new BaseViewPager.a() { // from class: com.baidu.tieba.personExtra.PersonImageActivity.4
            @Override // com.baidu.tbadk.core.view.BaseViewPager.a
            public void onScrollOut(int i) {
                if (i == 0) {
                }
            }
        };
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.jev = (MultiImageView) findViewById(R.id.viewpager);
        this.jev.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.jev.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.jev.setItemOnclickListener(this.mOnClickListener);
        this.jev.setItemOnLongClickListener(this.mOnLongClickListener);
        this.jev.setCurrentItem(0, false);
        this.jev.setOnScrollOutListener(this.jew);
        this.jev.setHasNext(false);
        this.jev.setNextTitle("mNextTitle");
        this.jev.setHeadImage(true);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.jeA = bundle.getString("curImgUrl");
            this.jsB = (HashMap) bundle.getSerializable("assistUrls");
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.jeA = intent.getStringExtra("curImgUrl");
            this.jsB = (HashMap) intent.getSerializableExtra("assistUrls");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("curImgUrl", this.jeA);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.jev.setCurrentItem(0, true);
    }

    /* loaded from: classes18.dex */
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
            switch (n.saveImageFileByUser(this.mUrl, this.mData, PersonImageActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return n.getSdErrorString();
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
            PersonImageActivity.this.ljH = null;
            PersonImageActivity.this.mProgress.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonImageActivity.this.ljH = null;
            PersonImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }
    }
}
