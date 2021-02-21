package com.baidu.tieba.themeCenter.bubble.group;

import android.os.Bundle;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.m.d;
import com.baidu.tieba.themeCenter.bubble.group.BubbleGroupModel;
import com.baidu.tieba.themeCenter.dressCenter.e;
import java.util.List;
/* loaded from: classes9.dex */
public class BubbleGroupActivity extends BaseActivity<BubbleGroupActivity> {
    private BubbleGroupModel nHX;
    private c nHY;
    private com.baidu.tieba.themeCenter.bubble.all.a nHZ;
    private BubbleGroupModel.a nIa = new BubbleGroupModel.a() { // from class: com.baidu.tieba.themeCenter.bubble.group.BubbleGroupActivity.1
        @Override // com.baidu.tieba.themeCenter.bubble.group.BubbleGroupModel.a
        public void a(int i, String str, e eVar, List<b> list) {
            BubbleGroupActivity.this.hideLoadingView(BubbleGroupActivity.this.nHY.getRootView());
            BubbleGroupActivity.this.nHY.cOH();
            if (i == 0) {
                BubbleGroupActivity.this.nHY.a(eVar, list, BubbleGroupActivity.this.nHX.dKX());
                return;
            }
            BubbleGroupActivity.this.showToast(str);
            BubbleGroupActivity.this.nHY.cAO();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nHX = new BubbleGroupModel(this);
        this.nHX.a(this.nIa);
        this.nHZ = new com.baidu.tieba.themeCenter.bubble.all.a(getPageContext());
        this.nHY = new c(this, this.nHZ);
        this.nHY.cOG();
        showLoadingView(this.nHY.getRootView());
        this.nHX.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nHY != null) {
            this.nHY.bzn();
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
        if (this.nHX != null && this.nHY != null) {
            showLoadingView(this.nHY.getRootView());
            this.nHX.LoadData();
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
