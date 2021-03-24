package com.baidu.tieba.themeCenter.background;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.themeCenter.background.BackgroundGroupModel;
import d.b.i0.i3.e.b;
import d.b.i0.i3.e.c;
import d.b.i0.i3.e.d;
import d.b.i0.i3.h.e;
import java.util.List;
/* loaded from: classes5.dex */
public class BackgroundGroupActivity extends BaseActivity<BackgroundGroupActivity> {
    public BackgroundGroupModel.c mCallback = new a();
    public d mItemController;
    public BackgroundGroupModel mModel;
    public TbPageContext<?> mPageContext;
    public c mView;

    /* loaded from: classes5.dex */
    public class a implements BackgroundGroupModel.c {
        public a() {
        }

        @Override // com.baidu.tieba.themeCenter.background.BackgroundGroupModel.c
        public void a(int i, String str, e eVar, List<b> list) {
            BackgroundGroupActivity backgroundGroupActivity = BackgroundGroupActivity.this;
            backgroundGroupActivity.hideLoadingView(backgroundGroupActivity.mView.d());
            BackgroundGroupActivity.this.mView.i();
            if (i == 0) {
                BackgroundGroupActivity.this.mView.k(eVar, list, BackgroundGroupActivity.this.mModel.B());
                return;
            }
            BackgroundGroupActivity.this.showToast(str);
            BackgroundGroupActivity.this.mView.j();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return "b007";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public d.b.h0.k0.d getPageStayDurationItem() {
        d.b.h0.k0.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.f50238a = true;
        }
        return pageStayDurationItem;
    }

    public int getPropId() {
        return this.mItemController.a();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        c cVar = this.mView;
        if (cVar != null) {
            cVar.f();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
        this.mPageContext = getPageContext();
        BackgroundGroupModel backgroundGroupModel = new BackgroundGroupModel(this);
        this.mModel = backgroundGroupModel;
        backgroundGroupModel.E(this.mCallback);
        d dVar = new d(this.mPageContext, this.mModel.getUniqueId());
        this.mItemController = dVar;
        dVar.c(1);
        c cVar = new c(this, this.mItemController);
        this.mView = cVar;
        cVar.e();
        showLoadingView(this.mView.d());
        this.mModel.LoadData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        c cVar;
        if (this.mModel == null || (cVar = this.mView) == null) {
            return;
        }
        showLoadingView(cVar.d());
        this.mModel.LoadData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
            showLoadingView(this.mView.d());
            this.mModel.LoadData();
        }
    }
}
