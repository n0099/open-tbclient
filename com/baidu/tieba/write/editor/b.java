package com.baidu.tieba.write.editor;

import android.view.View;
/* loaded from: classes.dex */
public class b {
    private EditorInfoContainer cvi;

    public b(EditorInfoContainer editorInfoContainer) {
        this.cvi = editorInfoContainer;
    }

    public void rk() {
        if (this.cvi != null) {
            this.cvi.rk();
        }
    }

    public void C(View.OnClickListener onClickListener) {
        if (this.cvi != null && this.cvi.cvc != null) {
            this.cvi.cvc.setOnClickListener(onClickListener);
        }
    }

    public void B(int i, String str) {
        if (this.cvi != null && this.cvi.cvc != null) {
            this.cvi.cvc.A(i, str);
        }
    }

    public void setLocationInfoViewState(int i) {
        B(i, null);
    }

    public int getLocationInfoViewState() {
        if (this.cvi == null || this.cvi.cvc == null) {
            return 0;
        }
        return this.cvi.cvc.getState();
    }

    public void destroy() {
        if (this.cvi != null) {
            this.cvi.setVisibility(8);
        }
    }
}
