package com.baidu.tieba.write.editor;

import android.view.View;
/* loaded from: classes.dex */
public class b {
    private EditorInfoContainer czB;

    public b(EditorInfoContainer editorInfoContainer) {
        this.czB = editorInfoContainer;
    }

    public void rU() {
        if (this.czB != null) {
            this.czB.rU();
        }
    }

    public void A(View.OnClickListener onClickListener) {
        if (this.czB != null && this.czB.czv != null) {
            this.czB.czv.setOnClickListener(onClickListener);
        }
    }

    public void D(int i, String str) {
        if (this.czB != null && this.czB.czv != null) {
            this.czB.czv.C(i, str);
        }
    }

    public void setLocationInfoViewState(int i) {
        D(i, null);
    }

    public int getLocationInfoViewState() {
        if (this.czB == null || this.czB.czv == null) {
            return 0;
        }
        return this.czB.czv.getState();
    }

    public void destroy() {
        if (this.czB != null) {
            this.czB.setVisibility(8);
        }
    }
}
