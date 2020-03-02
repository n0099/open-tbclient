package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.l;
/* loaded from: classes13.dex */
public class b extends l {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.dxs = false;
        this.dxr = 3;
        this.dwA = new EditorInfoContainer(context, str);
        this.dxt = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57};
    }

    public void setFrom(String str) {
        if (this.dwA instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dwA).setFrom(str);
        }
    }

    public void bz(String str, int i) {
        if (this.dwA instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dwA).bz(str, i);
        }
    }

    public void tO(boolean z) {
        if (this.dwA instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dwA).tO(z);
        }
    }

    public void byJ() {
        if (this.dwA instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dwA).byJ();
        }
    }

    public void cUM() {
        if (this.dwA instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dwA).cUM();
        }
    }

    public void cUQ() {
        if (this.dwA instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dwA).hide();
        }
    }
}
