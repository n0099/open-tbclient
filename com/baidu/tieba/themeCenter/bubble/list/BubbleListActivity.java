package com.baidu.tieba.themeCenter.bubble.list;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.list.BubbleListModel;
import d.a.m0.k0.d;
import d.a.m0.r.f0.f;
import d.a.n0.k3.h.e;
import java.util.List;
/* loaded from: classes5.dex */
public class BubbleListActivity extends BaseActivity<BubbleListActivity> {
    public d.a.n0.k3.f.a.a mItemController;
    public BubbleListModel mModel;
    public d.a.n0.k3.f.c.b mView;
    public BubbleListModel.c mCallback = new a();
    public BdListView.p mScrollToBottomListener = new b();
    public final f.g mOnPullRefreshListener = new c();

    /* loaded from: classes5.dex */
    public class a implements BubbleListModel.c {
        public a() {
        }

        @Override // com.baidu.tieba.themeCenter.bubble.list.BubbleListModel.c
        public void a(int i2, String str, e eVar, List<DressItemData> list) {
            BubbleListActivity.this.mView.j();
            BubbleListActivity bubbleListActivity = BubbleListActivity.this;
            bubbleListActivity.hideLoadingView(bubbleListActivity.mView.c());
            if (i2 == 0) {
                BubbleListActivity.this.mView.i(eVar, list, BubbleListActivity.this.mModel.H());
                return;
            }
            BubbleListActivity.this.showToast(str);
            BubbleListActivity.this.mView.h();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BdListView.p {
        public b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (BubbleListActivity.this.mModel != null) {
                BubbleListActivity.this.mModel.s();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements f.g {
        public c() {
        }

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (BubbleListActivity.this.mModel != null) {
                BubbleListActivity.this.mModel.LoadData();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.m0.k0.a
    public String getCurrentPageKey() {
        return "b011";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public d getPageStayDurationItem() {
        d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.f49436a = true;
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.n0.k3.f.c.b bVar = this.mView;
        if (bVar != null) {
            bVar.d();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BubbleListModel bubbleListModel = new BubbleListModel(this);
        this.mModel = bubbleListModel;
        bubbleListModel.J(this.mCallback);
        d.a.n0.k3.f.a.a aVar = new d.a.n0.k3.f.a.a(getPageContext());
        this.mItemController = aVar;
        d.a.n0.k3.f.c.b bVar = new d.a.n0.k3.f.c.b(this, aVar);
        this.mView = bVar;
        bVar.g(this.mScrollToBottomListener, this.mOnPullRefreshListener);
        showLoadingView(this.mView.c());
        this.mModel.LoadData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        d.a.n0.k3.f.c.b bVar;
        if (this.mModel == null || (bVar = this.mView) == null) {
            return;
        }
        showLoadingView(bVar.c());
        this.mModel.LoadData();
    }
}
