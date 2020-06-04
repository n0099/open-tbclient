package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.l;
/* loaded from: classes2.dex */
public class b extends l {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.elN = false;
        this.elM = 3;
        this.ekV = new EditorInfoContainer(context, str);
        this.elO = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57};
    }

    public void setFrom(String str) {
        if (this.ekV instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.ekV).setFrom(str);
        }
    }

    public void bK(String str, int i) {
        if (this.ekV instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.ekV).bK(str, i);
        }
    }

    public void vv(boolean z) {
        if (this.ekV instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.ekV).vv(z);
        }
    }

    public void bPh() {
        if (this.ekV instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.ekV).bPh();
        }
    }

    public void dni() {
        if (this.ekV instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.ekV).dni();
        }
    }

    public void dnm() {
        if (this.ekV instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.ekV).hide();
        }
    }
}
