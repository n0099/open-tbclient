package com.baidu.tieba.write.write;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class bl {
    private com.baidu.tbadk.editortools.l ard;
    private BaseActivity<?> bem;
    private com.baidu.tbadk.editortools.j fVt;
    private boolean fVu = false;
    private boolean fVv = false;

    public bl(BaseActivity<?> baseActivity, com.baidu.tbadk.editortools.l lVar) {
        this.bem = baseActivity;
        this.ard = lVar;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fVu) {
            if (this.fVt != null) {
                this.fVt.Br();
                this.fVt = null;
            }
        } else if (!this.fVv && z) {
            this.fVv = true;
            this.fVt = new com.baidu.tbadk.editortools.j(this.bem.getResources().getString(u.j.graffiti_write_tips), "graffiti_write_tip_show", 24, 24);
            this.bem.getSafeHandler().postDelayed(new bm(this), 500L);
        }
    }
}
