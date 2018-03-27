package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes2.dex */
public class d extends r {
    public d(Context context, String str) {
        super(context, (String) null, 15);
        this.btd = false;
        this.btc = 3;
        this.bsm = new a(context, str);
        this.bte = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.bsm instanceof a) {
            ((a) this.bsm).setFrom(str);
        }
    }

    public void aO(String str, int i) {
        if (this.bsm instanceof a) {
            ((a) this.bsm).aO(str, i);
        }
    }

    public void bfm() {
        if (this.bsm instanceof a) {
            ((a) this.bsm).bfm();
        }
    }

    public void bGP() {
        if (this.bsm instanceof a) {
            ((a) this.bsm).bGP();
        }
    }
}
