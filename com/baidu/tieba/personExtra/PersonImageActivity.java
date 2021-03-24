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
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.h0.r.s.b;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class PersonImageActivity extends BaseActivity<PersonImageActivity> {
    public static final int PAGE_LIMIT = 2;
    public HashMap<String, ImageUrlData> assistUrls;
    public String curImgUrl;
    public Context mContext;
    public ProgressBar mProgress = null;
    public e mSaveImageTask = null;
    public MultiImageView mMultiImageView = null;
    public View.OnClickListener mOnClickListener = null;
    public View.OnLongClickListener mOnLongClickListener = null;
    public b.c mDialogClickListener = null;
    public BaseViewPager.a mOnscOnScrollOutListener = null;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonImageActivity.this.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnLongClickListener {
        public b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            String[] strArr = {PersonImageActivity.this.getPageContext().getString(R.string.save)};
            PersonImageActivity personImageActivity = PersonImageActivity.this;
            personImageActivity.createListMenu(strArr, personImageActivity.mDialogClickListener);
            PersonImageActivity.this.showListMenu();
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements b.c {
        public c() {
        }

        @Override // d.b.h0.r.s.b.c
        public void a(d.b.h0.r.s.b bVar, int i, View view) {
            if (bVar == PersonImageActivity.this.getListMenu()) {
                if (i == 0) {
                    try {
                        byte[] currentImageData = PersonImageActivity.this.mMultiImageView.getCurrentImageData();
                        if (currentImageData != null) {
                            String currentImageUrl = PersonImageActivity.this.mMultiImageView.getCurrentImageUrl();
                            PersonImageActivity.this.mSaveImageTask = new e(currentImageUrl, currentImageData);
                            PersonImageActivity.this.mSaveImageTask.execute(new String[0]);
                            PersonImageActivity.this.mProgress.setVisibility(0);
                        } else {
                            PersonImageActivity.this.showToast(PersonImageActivity.this.getPageContext().getString(R.string.no_data));
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
                bVar.e();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements BaseViewPager.a {
        public d() {
        }

        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void a(int i) {
        }
    }

    /* loaded from: classes5.dex */
    public class e extends BdAsyncTask<String, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public String f20379a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f20380b;

        public e(String str, byte[] bArr) {
            this.f20379a = null;
            this.f20380b = null;
            this.f20379a = str;
            this.f20380b = bArr;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonImageActivity.this.mSaveImageTask = null;
            PersonImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            int saveImageFileByUser = FileHelper.saveImageFileByUser(this.f20379a, this.f20380b, PersonImageActivity.this.getPageContext().getPageActivity());
            if (saveImageFileByUser != -2) {
                if (saveImageFileByUser != 0) {
                    return PersonImageActivity.this.getPageContext().getString(R.string.save_fail);
                }
                return PersonImageActivity.this.getPageContext().getString(R.string.save_image_to_album);
            }
            return FileHelper.getSdErrorString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((e) str);
            PersonImageActivity.this.showToast(str);
            PersonImageActivity.this.mSaveImageTask = null;
            PersonImageActivity.this.mProgress.setVisibility(8);
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.curImgUrl = bundle.getString("curImgUrl");
            this.assistUrls = (HashMap) bundle.getSerializable("assistUrls");
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.curImgUrl = intent.getStringExtra("curImgUrl");
            this.assistUrls = (HashMap) intent.getSerializableExtra("assistUrls");
        }
    }

    private void initUI() {
        this.mOnClickListener = new a();
        this.mOnLongClickListener = new b();
        this.mDialogClickListener = new c();
        this.mOnscOnScrollOutListener = new d();
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        MultiImageView multiImageView = (MultiImageView) findViewById(R.id.viewpager);
        this.mMultiImageView = multiImageView;
        multiImageView.setPageMargin(l.e(getPageContext().getPageActivity(), 8.0f));
        this.mMultiImageView.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.mMultiImageView.setItemOnclickListener(this.mOnClickListener);
        this.mMultiImageView.setItemOnLongClickListener(this.mOnLongClickListener);
        this.mMultiImageView.setCurrentItem(0, false);
        this.mMultiImageView.setOnScrollOutListener(this.mOnscOnScrollOutListener);
        this.mMultiImageView.setHasNext(false);
        this.mMultiImageView.setNextTitle("mNextTitle");
        this.mMultiImageView.setHeadImage(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i != 1 && i != 4) {
            this.mMultiImageView.setBackgroundColor(-16777216);
        } else {
            this.mMultiImageView.setBackgroundColor(SkinManager.getBgColor(i));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mMultiImageView.setCurrentItem(0, true);
    }

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
        arrayList.add(this.curImgUrl);
        this.mMultiImageView.setIsFromCDN(true);
        this.mMultiImageView.setAllowLocalUrl(true);
        this.mMultiImageView.setAssistUrls(this.assistUrls);
        this.mMultiImageView.setUrlData(arrayList);
        this.mMultiImageView.setCurrentItem(0, false);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        this.mMultiImageView.v();
        e eVar = this.mSaveImageTask;
        if (eVar != null) {
            eVar.cancel();
            this.mSaveImageTask = null;
        }
        ProgressBar progressBar = this.mProgress;
        if (progressBar != null) {
            progressBar.setVisibility(8);
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mMultiImageView.w();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mMultiImageView.x();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("curImgUrl", this.curImgUrl);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.mMultiImageView.v();
    }
}
