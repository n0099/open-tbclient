package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes2.dex */
public class c extends r {
    public c(Context context, String str) {
        super(context, (String) null, 15);
        this.aCF = false;
        this.aCE = 3;
        this.aBO = new a(context, str);
        this.aCG = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.aBO instanceof a) {
            ((a) this.aBO).setFrom(str);
        }
    }

    public void aWg() {
        if (this.aBO instanceof a) {
            ((a) this.aBO).aWg();
        }
    }

    public void bFW() {
        if (this.aBO instanceof a) {
            ((a) this.aBO).bFW();
        }
    }
}
