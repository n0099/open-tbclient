package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.aMW = false;
        this.aMV = 3;
        this.aMf = new EditorInfoContainer(context, str);
        this.aMX = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.aMf instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aMf).setFrom(str);
        }
    }

    public void aT(String str, int i) {
        if (this.aMf instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aMf).aT(str, i);
        }
    }

    public void aox() {
        if (this.aMf instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aMf).aox();
        }
    }

    public void bHH() {
        if (this.aMf instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aMf).bHH();
        }
    }
}
