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
    private BubbleGroupModel nKd;
    private c nKe;
    private com.baidu.tieba.themeCenter.bubble.all.a nKf;
    private BubbleGroupModel.a nKg = new BubbleGroupModel.a() { // from class: com.baidu.tieba.themeCenter.bubble.group.BubbleGroupActivity.1
        @Override // com.baidu.tieba.themeCenter.bubble.group.BubbleGroupModel.a
        public void a(int i, String str, e eVar, List<b> list) {
            BubbleGroupActivity.this.hideLoadingView(BubbleGroupActivity.this.nKe.getRootView());
            BubbleGroupActivity.this.nKe.cOO();
            if (i == 0) {
                BubbleGroupActivity.this.nKe.a(eVar, list, BubbleGroupActivity.this.nKd.dLf());
                return;
            }
            BubbleGroupActivity.this.showToast(str);
            BubbleGroupActivity.this.nKe.cAU();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nKd = new BubbleGroupModel(this);
        this.nKd.a(this.nKg);
        this.nKf = new com.baidu.tieba.themeCenter.bubble.all.a(getPageContext());
        this.nKe = new c(this, this.nKf);
        this.nKe.cON();
        showLoadingView(this.nKe.getRootView());
        this.nKd.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nKe != null) {
            this.nKe.bzq();
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
        if (this.nKd != null && this.nKe != null) {
            showLoadingView(this.nKe.getRootView());
            this.nKd.LoadData();
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
