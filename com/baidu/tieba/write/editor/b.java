package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.cFg = false;
        this.cFf = 3;
        this.cEn = new EditorInfoContainer(context, str);
        this.cFh = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.cEn instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.cEn).setFrom(str);
        }
    }

    public void bq(String str, int i) {
        if (this.cEn instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.cEn).bq(str, i);
        }
    }

    public void beG() {
        if (this.cEn instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.cEn).beG();
        }
    }

    public void cyp() {
        if (this.cEn instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.cEn).cyp();
        }
    }

    public void cyt() {
        if (this.cEn instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.cEn).hide();
        }
    }
}
