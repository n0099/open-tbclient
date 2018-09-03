package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.aMT = false;
        this.aMS = 3;
        this.aMc = new EditorInfoContainer(context, str);
        this.aMU = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.aMc instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aMc).setFrom(str);
        }
    }

    public void aP(String str, int i) {
        if (this.aMc instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aMc).aP(str, i);
        }
    }

    public void aoX() {
        if (this.aMc instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aMc).aoX();
        }
    }

    public void bGw() {
        if (this.aMc instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aMc).bGw();
        }
    }
}
