package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes2.dex */
public class d extends r {
    public d(Context context, String str) {
        super(context, (String) null, 15);
        this.bto = false;
        this.btm = 3;
        this.bsw = new a(context, str);
        this.btp = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.bsw instanceof a) {
            ((a) this.bsw).setFrom(str);
        }
    }

    public void aO(String str, int i) {
        if (this.bsw instanceof a) {
            ((a) this.bsw).aO(str, i);
        }
    }

    public void bfm() {
        if (this.bsw instanceof a) {
            ((a) this.bsw).bfm();
        }
    }

    public void bGL() {
        if (this.bsw instanceof a) {
            ((a) this.bsw).bGL();
        }
    }
}
