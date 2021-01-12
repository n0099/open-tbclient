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
    private BubbleGroupModel nxM;
    private c nxN;
    private com.baidu.tieba.themeCenter.bubble.all.a nxO;
    private BubbleGroupModel.a nxP = new BubbleGroupModel.a() { // from class: com.baidu.tieba.themeCenter.bubble.group.BubbleGroupActivity.1
        @Override // com.baidu.tieba.themeCenter.bubble.group.BubbleGroupModel.a
        public void a(int i, String str, e eVar, List<b> list) {
            BubbleGroupActivity.this.hideLoadingView(BubbleGroupActivity.this.nxN.getRootView());
            BubbleGroupActivity.this.nxN.cMD();
            if (i == 0) {
                BubbleGroupActivity.this.nxN.a(eVar, list, BubbleGroupActivity.this.nxM.dIE());
                return;
            }
            BubbleGroupActivity.this.showToast(str);
            BubbleGroupActivity.this.nxN.czw();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nxM = new BubbleGroupModel(this);
        this.nxM.a(this.nxP);
        this.nxO = new com.baidu.tieba.themeCenter.bubble.all.a(getPageContext());
        this.nxN = new c(this, this.nxO);
        this.nxN.cMC();
        showLoadingView(this.nxN.getRootView());
        this.nxM.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nxN != null) {
            this.nxN.byV();
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
        if (this.nxM != null && this.nxN != null) {
            showLoadingView(this.nxN.getRootView());
            this.nxM.LoadData();
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
