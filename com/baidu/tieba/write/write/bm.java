package com.baidu.tieba.write.write;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class bm {
    private com.baidu.tbadk.editortools.l atG;
    private BaseActivity<?> bix;
    private com.baidu.tbadk.editortools.j eNi;
    private boolean eNj = false;
    private boolean eNk = false;

    public bm(BaseActivity<?> baseActivity, com.baidu.tbadk.editortools.l lVar) {
        this.bix = baseActivity;
        this.atG = lVar;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.eNj) {
            if (this.eNi != null) {
                this.eNi.Dn();
                this.eNi = null;
            }
        } else if (!this.eNk && z) {
            this.eNk = true;
            this.eNi = new com.baidu.tbadk.editortools.j(this.bix.getResources().getString(t.j.graffiti_write_tips), "graffiti_write_tip_show", 24, 24);
            this.bix.getSafeHandler().postDelayed(new bn(this), 500L);
        }
    }
}
