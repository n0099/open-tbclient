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
    private BubbleGroupModel.a nHA = new BubbleGroupModel.a() { // from class: com.baidu.tieba.themeCenter.bubble.group.BubbleGroupActivity.1
        @Override // com.baidu.tieba.themeCenter.bubble.group.BubbleGroupModel.a
        public void a(int i, String str, e eVar, List<b> list) {
            BubbleGroupActivity.this.hideLoadingView(BubbleGroupActivity.this.nHy.getRootView());
            BubbleGroupActivity.this.nHy.cOA();
            if (i == 0) {
                BubbleGroupActivity.this.nHy.a(eVar, list, BubbleGroupActivity.this.nHx.dKP());
                return;
            }
            BubbleGroupActivity.this.showToast(str);
            BubbleGroupActivity.this.nHy.cAH();
        }
    };
    private BubbleGroupModel nHx;
    private c nHy;
    private com.baidu.tieba.themeCenter.bubble.all.a nHz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nHx = new BubbleGroupModel(this);
        this.nHx.a(this.nHA);
        this.nHz = new com.baidu.tieba.themeCenter.bubble.all.a(getPageContext());
        this.nHy = new c(this, this.nHz);
        this.nHy.cOz();
        showLoadingView(this.nHy.getRootView());
        this.nHx.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nHy != null) {
            this.nHy.bzn();
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
        if (this.nHx != null && this.nHy != null) {
            showLoadingView(this.nHy.getRootView());
            this.nHx.LoadData();
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
