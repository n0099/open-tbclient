package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.l;
/* loaded from: classes10.dex */
public class b extends l {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.dta = false;
        this.dsZ = 3;
        this.dsh = new EditorInfoContainer(context, str);
        this.dtb = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57};
    }

    public void setFrom(String str) {
        if (this.dsh instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dsh).setFrom(str);
        }
    }

    public void bz(String str, int i) {
        if (this.dsh instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dsh).bz(str, i);
        }
    }

    public void ty(boolean z) {
        if (this.dsh instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dsh).ty(z);
        }
    }

    public void bwa() {
        if (this.dsh instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dsh).bwa();
        }
    }

    public void cSr() {
        if (this.dsh instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dsh).cSr();
        }
    }

    public void cSv() {
        if (this.dsh instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dsh).hide();
        }
    }
}
