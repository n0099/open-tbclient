package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.csL = false;
        this.csK = 3;
        this.crT = new EditorInfoContainer(context, str);
        this.csM = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.crT instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.crT).setFrom(str);
        }
    }

    public void bt(String str, int i) {
        if (this.crT instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.crT).bt(str, i);
        }
    }

    public void bgg() {
        if (this.crT instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.crT).bgg();
        }
    }

    public void cAy() {
        if (this.crT instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.crT).cAy();
        }
    }

    public void cAC() {
        if (this.crT instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.crT).hide();
        }
    }
}
