package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.aDD = false;
        this.aDC = 3;
        this.aCM = new EditorInfoContainer(context, str);
        this.aDE = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.aCM instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aCM).setFrom(str);
        }
    }

    public void aP(String str, int i) {
        if (this.aCM instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aCM).aP(str, i);
        }
    }

    public void akW() {
        if (this.aCM instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aCM).akW();
        }
    }

    public void bCc() {
        if (this.aCM instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aCM).bCc();
        }
    }
}
