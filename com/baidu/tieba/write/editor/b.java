package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.cry = false;
        this.crx = 3;
        this.cqF = new EditorInfoContainer(context, str);
        this.crz = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.cqF instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.cqF).setFrom(str);
        }
    }

    public void bs(String str, int i) {
        if (this.cqF instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.cqF).bs(str, i);
        }
    }

    public void bed() {
        if (this.cqF instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.cqF).bed();
        }
    }

    public void cxz() {
        if (this.cqF instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.cqF).cxz();
        }
    }

    public void cxD() {
        if (this.cqF instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.cqF).hide();
        }
    }
}
