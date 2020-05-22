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

    public void vt(boolean z) {
        if (this.ekV instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.ekV).vt(z);
        }
    }

    public void bPf() {
        if (this.ekV instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.ekV).bPf();
        }
    }

    public void dmS() {
        if (this.ekV instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.ekV).dmS();
        }
    }

    public void dmW() {
        if (this.ekV instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.ekV).hide();
        }
    }
}
