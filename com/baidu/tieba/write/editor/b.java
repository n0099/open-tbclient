package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.l;
/* loaded from: classes13.dex */
public class b extends l {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.dxS = false;
        this.dxR = 3;
        this.dxa = new EditorInfoContainer(context, str);
        this.dxT = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57};
    }

    public void setFrom(String str) {
        if (this.dxa instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dxa).setFrom(str);
        }
    }

    public void bz(String str, int i) {
        if (this.dxa instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dxa).bz(str, i);
        }
    }

    public void tV(boolean z) {
        if (this.dxa instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dxa).tV(z);
        }
    }

    public void byQ() {
        if (this.dxa instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dxa).byQ();
        }
    }

    public void cVi() {
        if (this.dxa instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dxa).cVi();
        }
    }

    public void cVm() {
        if (this.dxa instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dxa).hide();
        }
    }
}
