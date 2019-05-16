package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.crx = false;
        this.crw = 3;
        this.cqE = new EditorInfoContainer(context, str);
        this.cry = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.cqE instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.cqE).setFrom(str);
        }
    }

    public void bs(String str, int i) {
        if (this.cqE instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.cqE).bs(str, i);
        }
    }

    public void bea() {
        if (this.cqE instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.cqE).bea();
        }
    }

    public void cxy() {
        if (this.cqE instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.cqE).cxy();
        }
    }

    public void cxC() {
        if (this.cqE instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.cqE).hide();
        }
    }
}
