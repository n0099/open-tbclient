package com.baidu.tieba.write.write;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class bl {
    private BaseActivity<?> aPR;
    private com.baidu.tbadk.editortools.l auk;
    private com.baidu.tbadk.editortools.j gfy;
    private boolean gfz = false;
    private boolean gfA = false;

    public bl(BaseActivity<?> baseActivity, com.baidu.tbadk.editortools.l lVar) {
        this.aPR = baseActivity;
        this.auk = lVar;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gfz) {
            if (this.gfy != null) {
                this.gfy.CM();
                this.gfy = null;
            }
        } else if (!this.gfA && z) {
            this.gfA = true;
            this.gfy = new com.baidu.tbadk.editortools.j(this.aPR.getResources().getString(t.j.graffiti_write_tips), "graffiti_write_tip_show", 24, 24);
            this.aPR.getSafeHandler().postDelayed(new bm(this), 500L);
        }
    }
}
