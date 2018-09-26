package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.aQl = false;
        this.aQk = 3;
        this.aPu = new EditorInfoContainer(context, str);
        this.aQm = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.aPu instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aPu).setFrom(str);
        }
    }

    public void aU(String str, int i) {
        if (this.aPu instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aPu).aU(str, i);
        }
    }

    public void aqM() {
        if (this.aPu instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aPu).aqM();
        }
    }

    public void bJm() {
        if (this.aPu instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aPu).bJm();
        }
    }
}
