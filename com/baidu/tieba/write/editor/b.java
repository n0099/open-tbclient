package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.l;
/* loaded from: classes2.dex */
public class b extends l {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.dXz = false;
        this.dXy = 3;
        this.dWH = new EditorInfoContainer(context, str);
        this.dXA = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57};
    }

    public void setFrom(String str) {
        if (this.dWH instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dWH).setFrom(str);
        }
    }

    public void bJ(String str, int i) {
        if (this.dWH instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dWH).bJ(str, i);
        }
    }

    public void uV(boolean z) {
        if (this.dWH instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dWH).uV(z);
        }
    }

    public void bIN() {
        if (this.dWH instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dWH).bIN();
        }
    }

    public void dfE() {
        if (this.dWH instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dWH).dfE();
        }
    }

    public void dfI() {
        if (this.dWH instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dWH).hide();
        }
    }
}
