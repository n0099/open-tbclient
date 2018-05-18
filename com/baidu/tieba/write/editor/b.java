package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.aDE = false;
        this.aDD = 3;
        this.aCN = new EditorInfoContainer(context, str);
        this.aDF = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.aCN instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aCN).setFrom(str);
        }
    }

    public void aP(String str, int i) {
        if (this.aCN instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aCN).aP(str, i);
        }
    }

    public void akW() {
        if (this.aCN instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aCN).akW();
        }
    }

    public void bCa() {
        if (this.aCN instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aCN).bCa();
        }
    }
}
