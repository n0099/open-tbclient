package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* loaded from: classes.dex */
public class k {
    private EditorInfoContainer bTy;

    public k(EditorInfoContainer editorInfoContainer) {
        this.bTy = editorInfoContainer;
    }

    public void wc() {
        if (this.bTy != null) {
            this.bTy.wc();
        }
    }

    public void G(View.OnClickListener onClickListener) {
        if (this.bTy != null && this.bTy.bTr != null) {
            this.bTy.bTr.setOnClickListener(onClickListener);
        }
    }

    public void B(int i, String str) {
        if (this.bTy != null && this.bTy.bTr != null) {
            this.bTy.bTr.C(i, str);
        }
    }

    public void setLocationInfoViewState(int i) {
        B(i, null);
    }

    public int getLocationInfoViewState() {
        if (this.bTy == null || this.bTy.bTr == null) {
            return 0;
        }
        return this.bTy.bTr.getState();
    }

    public void destroy() {
        if (this.bTy != null) {
            this.bTy.setVisibility(8);
        }
    }
}
