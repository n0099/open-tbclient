package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.aZc = false;
        this.aZb = 3;
        this.aYl = new EditorInfoContainer(context, str);
        this.aZd = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.aYl instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aYl).setFrom(str);
        }
    }

    public void ba(String str, int i) {
        if (this.aYl instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aYl).ba(str, i);
        }
    }

    public void blO() {
        if (this.aYl instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aYl).blO();
        }
    }

    public void bOT() {
        if (this.aYl instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aYl).bOT();
        }
    }
}
