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
/* loaded from: classes9.dex */
public class BubbleListActivity extends BaseActivity<BubbleListActivity> {
    private com.baidu.tieba.themeCenter.bubble.all.a nHZ;
    private BubbleListModel nIj;
    private b nIk;
    private BubbleListModel.a nIl = new BubbleListModel.a() { // from class: com.baidu.tieba.themeCenter.bubble.list.BubbleListActivity.1
        @Override // com.baidu.tieba.themeCenter.bubble.list.BubbleListModel.a
        public void a(int i, String str, e eVar, List<DressItemData> list) {
            BubbleListActivity.this.nIk.bRI();
            BubbleListActivity.this.hideLoadingView(BubbleListActivity.this.nIk.getRootView());
            if (i == 0) {
                BubbleListActivity.this.nIk.a(eVar, list, BubbleListActivity.this.nIj.dRn());
                return;
            }
            BubbleListActivity.this.showToast(str);
            BubbleListActivity.this.nIk.cAO();
        }
    };
    private BdListView.e gBC = new BdListView.e() { // from class: com.baidu.tieba.themeCenter.bubble.list.BubbleListActivity.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (BubbleListActivity.this.nIj != null) {
                BubbleListActivity.this.nIj.dRm();
            }
        }
    };
    private final f.c gHz = new f.c() { // from class: com.baidu.tieba.themeCenter.bubble.list.BubbleListActivity.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (BubbleListActivity.this.nIj != null) {
                BubbleListActivity.this.nIj.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nIj = new BubbleListModel(this);
        this.nIj.a(this.nIl);
        this.nHZ = new com.baidu.tieba.themeCenter.bubble.all.a(getPageContext());
        this.nIk = new b(this, this.nHZ);
        this.nIk.a(this.gBC, this.gHz);
        showLoadingView(this.nIk.getRootView());
        this.nIj.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nIk != null) {
            this.nIk.bzn();
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
        if (this.nIj != null && this.nIk != null) {
            showLoadingView(this.nIk.getRootView());
            this.nIj.LoadData();
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
