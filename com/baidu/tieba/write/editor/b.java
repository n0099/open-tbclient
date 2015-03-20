package com.baidu.tieba.write.editor;

import android.view.View;
/* loaded from: classes.dex */
public class b {
    private EditorInfoContainer cuS;

    public b(EditorInfoContainer editorInfoContainer) {
        this.cuS = editorInfoContainer;
    }

    public void rk() {
        if (this.cuS != null) {
            this.cuS.rk();
        }
    }

    public void B(View.OnClickListener onClickListener) {
        if (this.cuS != null && this.cuS.cuM != null) {
            this.cuS.cuM.setOnClickListener(onClickListener);
        }
    }

    public void B(int i, String str) {
        if (this.cuS != null && this.cuS.cuM != null) {
            this.cuS.cuM.A(i, str);
        }
    }

    public void setLocationInfoViewState(int i) {
        B(i, null);
    }

    public int getLocationInfoViewState() {
        if (this.cuS == null || this.cuS.cuM == null) {
            return 0;
        }
        return this.cuS.cuM.getState();
    }

    public void destroy() {
        if (this.cuS != null) {
            this.cuS.setVisibility(8);
        }
    }
}
