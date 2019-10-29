package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.cFX = false;
        this.cFW = 3;
        this.cFe = new EditorInfoContainer(context, str);
        this.cFY = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.cFe instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.cFe).setFrom(str);
        }
    }

    public void bq(String str, int i) {
        if (this.cFe instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.cFe).bq(str, i);
        }
    }

    public void beI() {
        if (this.cFe instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.cFe).beI();
        }
    }

    public void cyr() {
        if (this.cFe instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.cFe).cyr();
        }
    }

    public void cyv() {
        if (this.cFe instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.cFe).hide();
        }
    }
}
