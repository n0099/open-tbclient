package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.l;
/* loaded from: classes11.dex */
public class b extends l {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.dtl = false;
        this.dtk = 3;
        this.dss = new EditorInfoContainer(context, str);
        this.dtm = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57};
    }

    public void setFrom(String str) {
        if (this.dss instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dss).setFrom(str);
        }
    }

    public void bA(String str, int i) {
        if (this.dss instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dss).bA(str, i);
        }
    }

    public void tK(boolean z) {
        if (this.dss instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dss).tK(z);
        }
    }

    public void bxc() {
        if (this.dss instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dss).bxc();
        }
    }

    public void cTw() {
        if (this.dss instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dss).cTw();
        }
    }

    public void cTA() {
        if (this.dss instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dss).hide();
        }
    }
}
