package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.aUM = false;
        this.aUL = 3;
        this.aTV = new EditorInfoContainer(context, str);
        this.aUN = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.aTV instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aTV).setFrom(str);
        }
    }

    public void aY(String str, int i) {
        if (this.aTV instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aTV).aY(str, i);
        }
    }

    public void auj() {
        if (this.aTV instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aTV).auj();
        }
    }

    public void bMy() {
        if (this.aTV instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aTV).bMy();
        }
    }
}
