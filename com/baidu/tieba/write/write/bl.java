package com.baidu.tieba.write.write;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class bl {
    private com.baidu.tbadk.editortools.l aqo;
    private BaseActivity<?> bkc;
    private com.baidu.tbadk.editortools.j fJC;
    private boolean fJD = false;
    private boolean fJE = false;

    public bl(BaseActivity<?> baseActivity, com.baidu.tbadk.editortools.l lVar) {
        this.bkc = baseActivity;
        this.aqo = lVar;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fJD) {
            if (this.fJC != null) {
                this.fJC.Br();
                this.fJC = null;
            }
        } else if (!this.fJE && z) {
            this.fJE = true;
            this.fJC = new com.baidu.tbadk.editortools.j(this.bkc.getResources().getString(u.j.graffiti_write_tips), "graffiti_write_tip_show", 24, 24);
            this.bkc.getSafeHandler().postDelayed(new bm(this), 500L);
        }
    }
}
