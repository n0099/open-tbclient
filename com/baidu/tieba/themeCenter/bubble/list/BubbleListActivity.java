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
    private BubbleListModel nHJ;
    private b nHK;
    private com.baidu.tieba.themeCenter.bubble.all.a nHz;
    private BubbleListModel.a nHL = new BubbleListModel.a() { // from class: com.baidu.tieba.themeCenter.bubble.list.BubbleListActivity.1
        @Override // com.baidu.tieba.themeCenter.bubble.list.BubbleListModel.a
        public void a(int i, String str, e eVar, List<DressItemData> list) {
            BubbleListActivity.this.nHK.bRB();
            BubbleListActivity.this.hideLoadingView(BubbleListActivity.this.nHK.getRootView());
            if (i == 0) {
                BubbleListActivity.this.nHK.a(eVar, list, BubbleListActivity.this.nHJ.dRf());
                return;
            }
            BubbleListActivity.this.showToast(str);
            BubbleListActivity.this.nHK.cAH();
        }
    };
    private BdListView.e gBo = new BdListView.e() { // from class: com.baidu.tieba.themeCenter.bubble.list.BubbleListActivity.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (BubbleListActivity.this.nHJ != null) {
                BubbleListActivity.this.nHJ.dRe();
            }
        }
    };
    private final f.c gHl = new f.c() { // from class: com.baidu.tieba.themeCenter.bubble.list.BubbleListActivity.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (BubbleListActivity.this.nHJ != null) {
                BubbleListActivity.this.nHJ.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nHJ = new BubbleListModel(this);
        this.nHJ.a(this.nHL);
        this.nHz = new com.baidu.tieba.themeCenter.bubble.all.a(getPageContext());
        this.nHK = new b(this, this.nHz);
        this.nHK.a(this.gBo, this.gHl);
        showLoadingView(this.nHK.getRootView());
        this.nHJ.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nHK != null) {
            this.nHK.bzn();
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
        if (this.nHJ != null && this.nHK != null) {
            showLoadingView(this.nHK.getRootView());
            this.nHJ.LoadData();
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
