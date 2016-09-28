package com.baidu.tieba.write.write;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class bl {
    private BaseActivity<?> aRd;
    private com.baidu.tbadk.editortools.l atO;
    private com.baidu.tbadk.editortools.j ghI;
    private boolean ghJ = false;
    private boolean ghK = false;

    public bl(BaseActivity<?> baseActivity, com.baidu.tbadk.editortools.l lVar) {
        this.aRd = baseActivity;
        this.atO = lVar;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.ghJ) {
            if (this.ghI != null) {
                this.ghI.CM();
                this.ghI = null;
            }
        } else if (!this.ghK && z) {
            this.ghK = true;
            this.ghI = new com.baidu.tbadk.editortools.j(this.aRd.getResources().getString(r.j.graffiti_write_tips), "graffiti_write_tip_show", 24, 24);
            this.aRd.getSafeHandler().postDelayed(new bm(this), 500L);
        }
    }
}
