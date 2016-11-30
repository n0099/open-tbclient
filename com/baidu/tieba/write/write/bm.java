package com.baidu.tieba.write.write;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class bm {
    private BaseActivity<?> aTb;
    private com.baidu.tbadk.editortools.l auI;
    private com.baidu.tbadk.editortools.j gpu;
    private boolean gpv = false;
    private boolean gpw = false;

    public bm(BaseActivity<?> baseActivity, com.baidu.tbadk.editortools.l lVar) {
        this.aTb = baseActivity;
        this.auI = lVar;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gpv) {
            if (this.gpu != null) {
                this.gpu.CU();
                this.gpu = null;
            }
        } else if (!this.gpw && z) {
            this.gpw = true;
            this.gpu = new com.baidu.tbadk.editortools.j(this.aTb.getResources().getString(r.j.graffiti_write_tips), "graffiti_write_tip_show", 24, 24);
            this.aTb.getSafeHandler().postDelayed(new bn(this), 500L);
        }
    }
}
