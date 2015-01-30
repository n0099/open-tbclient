package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* loaded from: classes.dex */
public class k {
    private EditorInfoContainer bVq;

    public k(EditorInfoContainer editorInfoContainer) {
        this.bVq = editorInfoContainer;
    }

    public void wu() {
        if (this.bVq != null) {
            this.bVq.wu();
        }
    }

    public void H(View.OnClickListener onClickListener) {
        if (this.bVq != null && this.bVq.bVk != null) {
            this.bVq.bVk.setOnClickListener(onClickListener);
        }
    }

    public void B(int i, String str) {
        if (this.bVq != null && this.bVq.bVk != null) {
            this.bVq.bVk.C(i, str);
        }
    }

    public void setLocationInfoViewState(int i) {
        B(i, null);
    }

    public int getLocationInfoViewState() {
        if (this.bVq == null || this.bVq.bVk == null) {
            return 0;
        }
        return this.bVq.bVk.getState();
    }

    public void destroy() {
        if (this.bVq != null) {
            this.bVq.setVisibility(8);
        }
    }
}
