package com.baidu.tieba.themeCenter.bubble.group;

import android.os.Bundle;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.m.d;
import com.baidu.tieba.themeCenter.bubble.group.BubbleGroupModel;
import com.baidu.tieba.themeCenter.dressCenter.e;
import java.util.List;
/* loaded from: classes8.dex */
public class BubbleGroupActivity extends BaseActivity<BubbleGroupActivity> {
    private BubbleGroupModel nxN;
    private c nxO;
    private com.baidu.tieba.themeCenter.bubble.all.a nxP;
    private BubbleGroupModel.a nxQ = new BubbleGroupModel.a() { // from class: com.baidu.tieba.themeCenter.bubble.group.BubbleGroupActivity.1
        @Override // com.baidu.tieba.themeCenter.bubble.group.BubbleGroupModel.a
        public void a(int i, String str, e eVar, List<b> list) {
            BubbleGroupActivity.this.hideLoadingView(BubbleGroupActivity.this.nxO.getRootView());
            BubbleGroupActivity.this.nxO.cMD();
            if (i == 0) {
                BubbleGroupActivity.this.nxO.a(eVar, list, BubbleGroupActivity.this.nxN.dIE());
                return;
            }
            BubbleGroupActivity.this.showToast(str);
            BubbleGroupActivity.this.nxO.czw();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nxN = new BubbleGroupModel(this);
        this.nxN.a(this.nxQ);
        this.nxP = new com.baidu.tieba.themeCenter.bubble.all.a(getPageContext());
        this.nxO = new c(this, this.nxP);
        this.nxO.cMC();
        showLoadingView(this.nxO.getRootView());
        this.nxN.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nxO != null) {
            this.nxO.byV();
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
        if (this.nxN != null && this.nxO != null) {
            showLoadingView(this.nxO.getRootView());
            this.nxN.LoadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.BUBBLE_LIST;
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
