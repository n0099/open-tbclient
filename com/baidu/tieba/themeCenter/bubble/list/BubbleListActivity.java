package com.baidu.tieba.themeCenter.bubble.list;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.m.d;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.list.BubbleListModel;
import com.baidu.tieba.themeCenter.dressCenter.e;
import java.util.List;
/* loaded from: classes8.dex */
public class BubbleListActivity extends BaseActivity<BubbleListActivity> {
    private com.baidu.tieba.themeCenter.bubble.all.a nxO;
    private BubbleListModel nxY;
    private b nxZ;
    private BubbleListModel.a nya = new BubbleListModel.a() { // from class: com.baidu.tieba.themeCenter.bubble.list.BubbleListActivity.1
        @Override // com.baidu.tieba.themeCenter.bubble.list.BubbleListModel.a
        public void a(int i, String str, e eVar, List<DressItemData> list) {
            BubbleListActivity.this.nxZ.bQX();
            BubbleListActivity.this.hideLoadingView(BubbleListActivity.this.nxZ.getRootView());
            if (i == 0) {
                BubbleListActivity.this.nxZ.a(eVar, list, BubbleListActivity.this.nxY.dOU());
                return;
            }
            BubbleListActivity.this.showToast(str);
            BubbleListActivity.this.nxZ.czw();
        }
    };
    private BdListView.e gyE = new BdListView.e() { // from class: com.baidu.tieba.themeCenter.bubble.list.BubbleListActivity.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (BubbleListActivity.this.nxY != null) {
                BubbleListActivity.this.nxY.dOT();
            }
        }
    };
    private final f.c gEB = new f.c() { // from class: com.baidu.tieba.themeCenter.bubble.list.BubbleListActivity.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (BubbleListActivity.this.nxY != null) {
                BubbleListActivity.this.nxY.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nxY = new BubbleListModel(this);
        this.nxY.a(this.nya);
        this.nxO = new com.baidu.tieba.themeCenter.bubble.all.a(getPageContext());
        this.nxZ = new b(this, this.nxO);
        this.nxZ.a(this.gyE, this.gEB);
        showLoadingView(this.nxZ.getRootView());
        this.nxY.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nxZ != null) {
            this.nxZ.byV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nxY != null && this.nxZ != null) {
            showLoadingView(this.nxZ.getRootView());
            this.nxY.LoadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.BUBBLE_ALL;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public d getPageStayDurationItem() {
        d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.isRouteStat = true;
        }
        return pageStayDurationItem;
    }
}
