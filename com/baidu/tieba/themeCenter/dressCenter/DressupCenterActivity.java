package com.baidu.tieba.themeCenter.dressCenter;

import android.os.Bundle;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.dressCenter.DressupCenterModel;
import java.util.List;
/* loaded from: classes8.dex */
public class DressupCenterActivity extends BaseActivity<DressupCenterActivity> {
    private c nLr;
    private DressupCenterModel nLs;
    private DressupCenterModel.a nLt = new DressupCenterModel.a() { // from class: com.baidu.tieba.themeCenter.dressCenter.DressupCenterActivity.1
        @Override // com.baidu.tieba.themeCenter.dressCenter.DressupCenterModel.a
        public void a(int i, String str, List<a> list, e eVar, List<d> list2) {
            DressupCenterActivity.this.hideLoadingView(DressupCenterActivity.this.nLr.getRootView());
            if (i == 0) {
                DressupCenterActivity.this.nLr.a(list, eVar, list2, DressupCenterActivity.this.nLs.dLf());
                return;
            }
            DressupCenterActivity.this.showToast(str);
            DressupCenterActivity.this.nLr.cAU();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nLs = new DressupCenterModel(this);
        this.nLs.a(this.nLt);
        this.nLr = new c(this);
        showLoadingView(this.nLr.getRootView());
        this.nLs.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nLr != null) {
            this.nLr.bzq();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nLs != null && this.nLr != null) {
            hideNetRefreshView(this.nLr.getRootView());
            showLoadingView(this.nLr.getRootView());
            this.nLs.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nLs != null) {
            this.nLs.destroy();
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
