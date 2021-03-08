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
    private com.baidu.tieba.themeCenter.bubble.all.a nKf;
    private BubbleListModel nKp;
    private b nKq;
    private BubbleListModel.a nKr = new BubbleListModel.a() { // from class: com.baidu.tieba.themeCenter.bubble.list.BubbleListActivity.1
        @Override // com.baidu.tieba.themeCenter.bubble.list.BubbleListModel.a
        public void a(int i, String str, e eVar, List<DressItemData> list) {
            BubbleListActivity.this.nKq.bRO();
            BubbleListActivity.this.hideLoadingView(BubbleListActivity.this.nKq.getRootView());
            if (i == 0) {
                BubbleListActivity.this.nKq.a(eVar, list, BubbleListActivity.this.nKp.dRw());
                return;
            }
            BubbleListActivity.this.showToast(str);
            BubbleListActivity.this.nKq.cAU();
        }
    };
    private BdListView.e gDl = new BdListView.e() { // from class: com.baidu.tieba.themeCenter.bubble.list.BubbleListActivity.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (BubbleListActivity.this.nKp != null) {
                BubbleListActivity.this.nKp.dRv();
            }
        }
    };
    private final f.c gJi = new f.c() { // from class: com.baidu.tieba.themeCenter.bubble.list.BubbleListActivity.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (BubbleListActivity.this.nKp != null) {
                BubbleListActivity.this.nKp.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nKp = new BubbleListModel(this);
        this.nKp.a(this.nKr);
        this.nKf = new com.baidu.tieba.themeCenter.bubble.all.a(getPageContext());
        this.nKq = new b(this, this.nKf);
        this.nKq.a(this.gDl, this.gJi);
        showLoadingView(this.nKq.getRootView());
        this.nKp.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nKq != null) {
            this.nKq.bzq();
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
        if (this.nKp != null && this.nKq != null) {
            showLoadingView(this.nKq.getRootView());
            this.nKp.LoadData();
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
