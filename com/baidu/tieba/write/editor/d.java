package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes2.dex */
public class d extends r {
    public d(Context context, String str) {
        super(context, (String) null, 15);
        this.aCN = false;
        this.aCM = 3;
        this.aBW = new a(context, str);
        this.aCO = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.aBW instanceof a) {
            ((a) this.aBW).setFrom(str);
        }
    }

    public void aL(String str, int i) {
        if (this.aBW instanceof a) {
            ((a) this.aBW).aL(str, i);
        }
    }

    public void aWp() {
        if (this.aBW instanceof a) {
            ((a) this.aBW).aWp();
        }
    }

    public void bGI() {
        if (this.aBW instanceof a) {
            ((a) this.aBW).bGI();
        }
    }
}
