package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.l;
/* loaded from: classes13.dex */
public class b extends l {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.dxF = false;
        this.dxE = 3;
        this.dwN = new EditorInfoContainer(context, str);
        this.dxG = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54, 57};
    }

    public void setFrom(String str) {
        if (this.dwN instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dwN).setFrom(str);
        }
    }

    public void bz(String str, int i) {
        if (this.dwN instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dwN).bz(str, i);
        }
    }

    public void tO(boolean z) {
        if (this.dwN instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dwN).tO(z);
        }
    }

    public void byK() {
        if (this.dwN instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dwN).byK();
        }
    }

    public void cUN() {
        if (this.dwN instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dwN).cUN();
        }
    }

    public void cUR() {
        if (this.dwN instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.dwN).hide();
        }
    }
}
