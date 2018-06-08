package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.aMa = false;
        this.aLZ = 3;
        this.aLj = new EditorInfoContainer(context, str);
        this.aMb = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.aLj instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aLj).setFrom(str);
        }
    }

    public void aS(String str, int i) {
        if (this.aLj instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aLj).aS(str, i);
        }
    }

    public void apc() {
        if (this.aLj instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aLj).apc();
        }
    }

    public void bHg() {
        if (this.aLj instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aLj).bHg();
        }
    }
}
