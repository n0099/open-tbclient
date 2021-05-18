package com.baidu.tieba.themeCenter.background;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.widget.ListView.BdExpandListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tieba.themeCenter.background.BackgroundPreviewModel;
import d.a.j0.k0.d;
import d.a.k0.j3.e.j;
/* loaded from: classes5.dex */
public class BackgroundPreviewActivity extends BaseActivity<BackgroundPreviewActivity> {
    public BackgroundPreviewModel.b mCallback = new a();
    public int mFrom;
    public int mInUse;
    public BackgroundPreviewModel mModel;
    public int mPropId;
    public j mView;

    /* loaded from: classes5.dex */
    public class a implements BackgroundPreviewModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.themeCenter.background.BackgroundPreviewModel.b
        public void a(int i2, String str, DressItemData dressItemData) {
            BackgroundPreviewActivity backgroundPreviewActivity = BackgroundPreviewActivity.this;
            backgroundPreviewActivity.hideLoadingView(backgroundPreviewActivity.mView.f());
            if (i2 == 0) {
                BackgroundPreviewActivity.this.mView.l(dressItemData);
                return;
            }
            BackgroundPreviewActivity.this.showToast(str);
            BackgroundPreviewActivity.this.mView.k();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BdExpandListView.b {
        public b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdExpandListView.b
        public void a(float f2) {
        }

        @Override // com.baidu.adp.widget.ListView.BdExpandListView.b
        public void b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdExpandListView.b
        public void onRefresh() {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.j0.k0.a
    public String getCurrentPageKey() {
        return "b009";
    }

    public int getFrom() {
        return this.mFrom;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public d getPageStayDurationItem() {
        d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.f49392a = true;
            pageStayDurationItem.f49400i = String.valueOf(this.mPropId);
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        j jVar = this.mView;
        if (jVar != null) {
            jVar.g();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.mPropId = intent.getIntExtra(PersonalBackgroundPreviewActivityConfig.PROPID, 0);
            this.mInUse = intent.getIntExtra(PersonalBackgroundPreviewActivityConfig.INUSE, 0);
            this.mFrom = intent.getIntExtra("from", -1);
        }
        BackgroundPreviewModel backgroundPreviewModel = new BackgroundPreviewModel(this.mPropId, this.mInUse);
        this.mModel = backgroundPreviewModel;
        backgroundPreviewModel.x(this.mCallback);
        j jVar = new j(this);
        this.mView = jVar;
        showLoadingView(jVar.f());
        this.mView.j(new b());
        this.mModel.LoadData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BackgroundPreviewModel backgroundPreviewModel = this.mModel;
        if (backgroundPreviewModel != null) {
            backgroundPreviewModel.destroy();
        }
        j jVar = this.mView;
        if (jVar != null) {
            jVar.h();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        j jVar;
        if (this.mModel == null || (jVar = this.mView) == null) {
            return;
        }
        showLoadingView(jVar.f());
        this.mModel.LoadData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
            showLoadingView(this.mView.f());
            this.mModel.LoadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            d.a.j0.z.b.a().d();
        }
    }
}
