package com.baidu.tieba.themeCenter.background;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.themeCenter.background.BackgroundListModel;
import d.a.n0.r.f0.f;
import d.a.o0.k3.e.d;
import d.a.o0.k3.e.f;
import d.a.o0.k3.h.e;
import java.util.List;
/* loaded from: classes5.dex */
public class BackgroundListActivity extends BaseActivity<BackgroundListActivity> {
    public d mItemController;
    public BackgroundListModel mModel;
    public TbPageContext<?> mPageContext;
    public f mView;
    public BackgroundListModel.c mCallback = new a();
    public BdListView.p mScrollToBottomListener = new b();
    public final f.g mOnPullRefreshListener = new c();

    /* loaded from: classes5.dex */
    public class a implements BackgroundListModel.c {
        public a() {
        }

        @Override // com.baidu.tieba.themeCenter.background.BackgroundListModel.c
        public void a(int i2, String str, e eVar, List<DressItemData> list) {
            BackgroundListActivity.this.mView.j();
            BackgroundListActivity backgroundListActivity = BackgroundListActivity.this;
            backgroundListActivity.hideLoadingView(backgroundListActivity.mView.c());
            if (i2 == 0) {
                BackgroundListActivity.this.mView.i(eVar, list, BackgroundListActivity.this.mModel.P());
                return;
            }
            BackgroundListActivity.this.showToast(str);
            BackgroundListActivity.this.mView.h();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BdListView.p {
        public b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (BackgroundListActivity.this.mModel != null) {
                BackgroundListActivity.this.mModel.w();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements f.g {
        public c() {
        }

        @Override // d.a.n0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (BackgroundListActivity.this.mModel != null) {
                BackgroundListActivity.this.mModel.LoadData();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.n0.k0.a
    public String getCurrentPageKey() {
        return "b008";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public d.a.n0.k0.d getPageStayDurationItem() {
        d.a.n0.k0.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.f53217a = true;
        }
        return pageStayDurationItem;
    }

    public int getPropId() {
        return this.mItemController.a();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.o0.k3.e.f fVar = this.mView;
        if (fVar != null) {
            fVar.d();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
        this.mPageContext = getPageContext();
        BackgroundListModel backgroundListModel = new BackgroundListModel(this);
        this.mModel = backgroundListModel;
        backgroundListModel.R(this.mCallback);
        d dVar = new d(this.mPageContext, this.mModel.getUniqueId());
        this.mItemController = dVar;
        dVar.c(0);
        d.a.o0.k3.e.f fVar = new d.a.o0.k3.e.f(this, this.mItemController);
        this.mView = fVar;
        fVar.g(this.mScrollToBottomListener, this.mOnPullRefreshListener);
        showLoadingView(this.mView.c());
        this.mModel.LoadData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BackgroundListModel backgroundListModel = this.mModel;
        if (backgroundListModel != null) {
            backgroundListModel.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        d.a.o0.k3.e.f fVar;
        if (this.mModel == null || (fVar = this.mView) == null) {
            return;
        }
        showLoadingView(fVar.c());
        this.mModel.LoadData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
            showLoadingView(this.mView.c());
            this.mModel.LoadData();
        }
    }
}
