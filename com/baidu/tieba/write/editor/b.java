package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.ctO = false;
        this.ctN = 3;
        this.csV = new EditorInfoContainer(context, str);
        this.ctP = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.csV instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.csV).setFrom(str);
        }
    }

    public void bv(String str, int i) {
        if (this.csV instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.csV).bv(str, i);
        }
    }

    public void bgP() {
        if (this.csV instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.csV).bgP();
        }
    }

    public void cBH() {
        if (this.csV instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.csV).cBH();
        }
    }

    public void cBL() {
        if (this.csV instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.csV).hide();
        }
    }
}
