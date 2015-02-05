package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* loaded from: classes.dex */
public class k {
    private EditorInfoContainer bVp;

    public k(EditorInfoContainer editorInfoContainer) {
        this.bVp = editorInfoContainer;
    }

    public void wo() {
        if (this.bVp != null) {
            this.bVp.wo();
        }
    }

    public void H(View.OnClickListener onClickListener) {
        if (this.bVp != null && this.bVp.bVj != null) {
            this.bVp.bVj.setOnClickListener(onClickListener);
        }
    }

    public void B(int i, String str) {
        if (this.bVp != null && this.bVp.bVj != null) {
            this.bVp.bVj.C(i, str);
        }
    }

    public void setLocationInfoViewState(int i) {
        B(i, null);
    }

    public int getLocationInfoViewState() {
        if (this.bVp == null || this.bVp.bVj == null) {
            return 0;
        }
        return this.bVp.bVj.getState();
    }

    public void destroy() {
        if (this.bVp != null) {
            this.bVp.setVisibility(8);
        }
    }
}
