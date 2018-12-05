package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.aYZ = false;
        this.aYY = 3;
        this.aYi = new EditorInfoContainer(context, str);
        this.aZa = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.aYi instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aYi).setFrom(str);
        }
    }

    public void aZ(String str, int i) {
        if (this.aYi instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aYi).aZ(str, i);
        }
    }

    public void bld() {
        if (this.aYi instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aYi).bld();
        }
    }

    public void bOd() {
        if (this.aYi instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aYi).bOd();
        }
    }
}
