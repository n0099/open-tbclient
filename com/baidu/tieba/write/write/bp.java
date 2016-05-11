package com.baidu.tieba.write.write;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class bp {
    private com.baidu.tbadk.editortools.l apy;
    private BaseActivity<?> bek;
    private com.baidu.tbadk.editortools.j fei;
    private boolean fej = false;
    private boolean fek = false;

    public bp(BaseActivity<?> baseActivity, com.baidu.tbadk.editortools.l lVar) {
        this.bek = baseActivity;
        this.apy = lVar;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fej) {
            if (this.fei != null) {
                this.fei.Bh();
                this.fei = null;
            }
        } else if (!this.fek && z) {
            this.fek = true;
            this.fei = new com.baidu.tbadk.editortools.j(this.bek.getResources().getString(t.j.graffiti_write_tips), "graffiti_write_tip_show", 24, 24);
            this.bek.getSafeHandler().postDelayed(new bq(this), 500L);
        }
    }
}
