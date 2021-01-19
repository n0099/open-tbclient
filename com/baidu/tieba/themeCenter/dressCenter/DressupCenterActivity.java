package com.baidu.tieba.themeCenter.dressCenter;

import android.os.Bundle;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.dressCenter.DressupCenterModel;
import java.util.List;
/* loaded from: classes8.dex */
public class DressupCenterActivity extends BaseActivity<DressupCenterActivity> {
    private c nzb;
    private DressupCenterModel nzc;
    private DressupCenterModel.a nzd = new DressupCenterModel.a() { // from class: com.baidu.tieba.themeCenter.dressCenter.DressupCenterActivity.1
        @Override // com.baidu.tieba.themeCenter.dressCenter.DressupCenterModel.a
        public void a(int i, String str, List<a> list, e eVar, List<d> list2) {
            DressupCenterActivity.this.hideLoadingView(DressupCenterActivity.this.nzb.getRootView());
            if (i == 0) {
                DressupCenterActivity.this.nzb.a(list, eVar, list2, DressupCenterActivity.this.nzc.dIE());
                return;
            }
            DressupCenterActivity.this.showToast(str);
            DressupCenterActivity.this.nzb.czw();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nzc = new DressupCenterModel(this);
        this.nzc.a(this.nzd);
        this.nzb = new c(this);
        showLoadingView(this.nzb.getRootView());
        this.nzc.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nzb != null) {
            this.nzb.byV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nzc != null && this.nzb != null) {
            hideNetRefreshView(this.nzb.getRootView());
            showLoadingView(this.nzb.getRootView());
            this.nzc.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nzc != null) {
            this.nzc.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.THEME_CENTER;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.isRouteStat = true;
        }
        return pageStayDurationItem;
    }
}
