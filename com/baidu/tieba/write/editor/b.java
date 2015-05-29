package com.baidu.tieba.write.editor;

import android.view.View;
/* loaded from: classes.dex */
public class b {
    private EditorInfoContainer czA;

    public b(EditorInfoContainer editorInfoContainer) {
        this.czA = editorInfoContainer;
    }

    public void rU() {
        if (this.czA != null) {
            this.czA.rU();
        }
    }

    public void A(View.OnClickListener onClickListener) {
        if (this.czA != null && this.czA.czu != null) {
            this.czA.czu.setOnClickListener(onClickListener);
        }
    }

    public void D(int i, String str) {
        if (this.czA != null && this.czA.czu != null) {
            this.czA.czu.C(i, str);
        }
    }

    public void setLocationInfoViewState(int i) {
        D(i, null);
    }

    public int getLocationInfoViewState() {
        if (this.czA == null || this.czA.czu == null) {
            return 0;
        }
        return this.czA.czu.getState();
    }

    public void destroy() {
        if (this.czA != null) {
            this.czA.setVisibility(8);
        }
    }
}
