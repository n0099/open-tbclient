package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.cjm = false;
        this.cjl = 3;
        this.ciu = new EditorInfoContainer(context, str);
        this.cjn = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.ciu instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.ciu).setFrom(str);
        }
    }

    public void bw(String str, int i) {
        if (this.ciu instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.ciu).bw(str, i);
        }
    }

    public void aWP() {
        if (this.ciu instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.ciu).aWP();
        }
    }

    public void cpi() {
        if (this.ciu instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.ciu).cpi();
        }
    }
}
