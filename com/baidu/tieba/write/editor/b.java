package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.aVC = false;
        this.aVB = 3;
        this.aUL = new EditorInfoContainer(context, str);
        this.aVD = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.aUL instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aUL).setFrom(str);
        }
    }

    public void aY(String str, int i) {
        if (this.aUL instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aUL).aY(str, i);
        }
    }

    public void atH() {
        if (this.aUL instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aUL).atH();
        }
    }

    public void bLX() {
        if (this.aUL instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aUL).bLX();
        }
    }
}
