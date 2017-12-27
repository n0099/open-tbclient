package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes2.dex */
public class d extends r {
    public d(Context context, String str) {
        super(context, (String) null, 15);
        this.bqI = false;
        this.bqH = 3;
        this.bpR = new a(context, str);
        this.bqJ = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.bpR instanceof a) {
            ((a) this.bpR).setFrom(str);
        }
    }

    public void aL(String str, int i) {
        if (this.bpR instanceof a) {
            ((a) this.bpR).aL(str, i);
        }
    }

    public void bdC() {
        if (this.bpR instanceof a) {
            ((a) this.bpR).bdC();
        }
    }

    public void bMv() {
        if (this.bpR instanceof a) {
            ((a) this.bpR).bMv();
        }
    }
}
