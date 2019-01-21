package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.aZN = false;
        this.aZM = 3;
        this.aYW = new EditorInfoContainer(context, str);
        this.aZO = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.aYW instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aYW).setFrom(str);
        }
    }

    public void ba(String str, int i) {
        if (this.aYW instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aYW).ba(str, i);
        }
    }

    public void bmw() {
        if (this.aYW instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aYW).bmw();
        }
    }

    public void bPB() {
        if (this.aYW instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aYW).bPB();
        }
    }
}
