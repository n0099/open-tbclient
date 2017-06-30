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
    private com.baidu.tieba.write.a.a gmA;
    private ck gmB;
    private cq gmx;
    private com.baidu.tieba.write.model.a gmy;
    private WriteUrlModel gmz;
    private boolean isLoading = false;
    private Runnable gmC = new cf(this);
    private View.OnClickListener bkk = new cg(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.gmx = new cq(this, this.bkk);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gmy = new com.baidu.tieba.write.model.a(getUniqueId());
        this.gmy.a(new ch(this));
        this.gmz = new WriteUrlModel(getPageContext());
        this.gmz.ah(getIntent());
        this.gmB = new ck(getPageContext(), this.gmx, this.gmy, this.gmz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gmx != null) {
            this.gmx.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gmx != null && this.gmx.bvc() != null && this.gmx.bvc().getVisibility() == 0) {
                this.gmx.buZ();
                return true;
            } else if (this.gmA != null || (this.gmx != null && !StringUtils.isNull(this.gmx.buT()))) {
                bgT();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgT() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.bY(w.l.tip_draft_no_publish);
        aVar.b(w.l.cancel, new ci(this));
        aVar.a(w.l.confirm, new cj(this));
        aVar.b(getPageContext());
        aVar.ta();
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.gmB.a(this, i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gmB.destroy();
        if (this.gmx != null) {
            this.gmx.destroy();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(w.a.activity_open_from_bottom, w.a.activity_close_from_top);
    }
}
