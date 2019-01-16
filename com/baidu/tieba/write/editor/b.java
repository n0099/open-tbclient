package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes3.dex */
public class b extends k {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.aZM = false;
        this.aZL = 3;
        this.aYV = new EditorInfoContainer(context, str);
        this.aZN = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.aYV instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aYV).setFrom(str);
        }
    }

    public void ba(String str, int i) {
        if (this.aYV instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aYV).ba(str, i);
        }
    }

    public void bmw() {
        if (this.aYV instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aYV).bmw();
        }
    }

    public void bPB() {
        if (this.aYV instanceof EditorInfoContainer) {
            ((EditorInfoContainer) this.aYV).bPB();
        }
    }
}
