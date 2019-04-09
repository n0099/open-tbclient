package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.cjp = false;
        this.cjo = 3;
        this.cix = new EditorInfoContainer(context, str);
        this.cjq = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.cix instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.cix).setFrom(str);
        }
    }

    public void bw(String str, int i) {
        if (this.cix instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.cix).bw(str, i);
        }
    }

    public void aWN() {
        if (this.cix instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.cix).aWN();
        }
    }

    public void cpt() {
        if (this.cix instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.cix).cpt();
        }
    }
}
