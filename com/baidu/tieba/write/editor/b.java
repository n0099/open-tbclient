package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.cjo = false;
        this.cjn = 3;
        this.ciw = new EditorInfoContainer(context, str);
        this.cjp = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.ciw instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.ciw).setFrom(str);
        }
    }

    public void bw(String str, int i) {
        if (this.ciw instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.ciw).bw(str, i);
        }
    }

    public void aWN() {
        if (this.ciw instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.ciw).aWN();
        }
    }

    public void cpt() {
        if (this.ciw instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.ciw).cpt();
        }
    }
}
