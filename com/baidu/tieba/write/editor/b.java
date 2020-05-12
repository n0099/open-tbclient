package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.l;
/* loaded from: classes2.dex */
public class b extends l {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.dXE = false;
        this.dXD = 3;
        this.dWM = new EditorInfoContainer(context, str);
        this.dXF = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57};
    }

    public void setFrom(String str) {
        if (this.dWM instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dWM).setFrom(str);
        }
    }

    public void bJ(String str, int i) {
        if (this.dWM instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dWM).bJ(str, i);
        }
    }

    public void uV(boolean z) {
        if (this.dWM instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dWM).uV(z);
        }
    }

    public void bIM() {
        if (this.dWM instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dWM).bIM();
        }
    }

    public void dfC() {
        if (this.dWM instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dWM).dfC();
        }
    }

    public void dfG() {
        if (this.dWM instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dWM).hide();
        }
    }
}
