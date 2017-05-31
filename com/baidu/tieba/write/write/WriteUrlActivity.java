package com.baidu.tieba.write.write;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class WriteUrlActivity extends BaseActivity<WriteUrlActivity> {
    private com.baidu.tieba.write.model.a gbA;
    private WriteUrlModel gbB;
    private com.baidu.tieba.write.a.a gbC;
    private cm gbD;
    private cs gbz;
    private boolean isLoading = false;
    private Runnable gbE = new ch(this);
    private View.OnClickListener bhc = new ci(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.gbz = new cs(this, this.bhc);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gbA = new com.baidu.tieba.write.model.a(getUniqueId());
        this.gbA.a(new cj(this));
        this.gbB = new WriteUrlModel(getPageContext());
        this.gbB.af(getIntent());
        this.gbD = new cm(getPageContext(), this.gbz, this.gbA, this.gbB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gbz != null) {
            this.gbz.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gbz != null && this.gbz.bqB() != null && this.gbz.bqB().getVisibility() == 0) {
                this.gbz.bqy();
                return true;
            } else if (this.gbC != null || (this.gbz != null && !StringUtils.isNull(this.gbz.bqs()))) {
                bcE();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcE() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.bY(w.l.tip_draft_no_publish);
        aVar.b(w.l.cancel, new ck(this));
        aVar.a(w.l.confirm, new cl(this));
        aVar.b(getPageContext());
        aVar.tc();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.gbD.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gbD.destroy();
        if (this.gbz != null) {
            this.gbz.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(w.a.activity_open_from_bottom, w.a.activity_close_from_top);
    }
}
