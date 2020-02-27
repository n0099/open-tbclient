package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.l;
/* loaded from: classes13.dex */
public class b extends l {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.dxr = false;
        this.dxq = 3;
        this.dwz = new EditorInfoContainer(context, str);
        this.dxs = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57};
    }

    public void setFrom(String str) {
        if (this.dwz instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dwz).setFrom(str);
        }
    }

    public void bz(String str, int i) {
        if (this.dwz instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dwz).bz(str, i);
        }
    }

    public void tO(boolean z) {
        if (this.dwz instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dwz).tO(z);
        }
    }

    public void byH() {
        if (this.dwz instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dwz).byH();
        }
    }

    public void cUK() {
        if (this.dwz instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dwz).cUK();
        }
    }

    public void cUO() {
        if (this.dwz instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dwz).hide();
        }
    }
}
