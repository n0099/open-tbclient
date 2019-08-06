package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.csS = false;
        this.csR = 3;
        this.csa = new EditorInfoContainer(context, str);
        this.csT = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.csa instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.csa).setFrom(str);
        }
    }

    public void bt(String str, int i) {
        if (this.csa instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.csa).bt(str, i);
        }
    }

    public void bgj() {
        if (this.csa instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.csa).bgj();
        }
    }

    public void cAT() {
        if (this.csa instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.csa).cAT();
        }
    }

    public void cAX() {
        if (this.csa instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.csa).hide();
        }
    }
}
