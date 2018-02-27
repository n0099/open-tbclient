package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes2.dex */
public class d extends r {
    public d(Context context, String str) {
        super(context, (String) null, 15);
        this.bta = false;
        this.bsZ = 3;
        this.bsj = new a(context, str);
        this.btb = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.bsj instanceof a) {
            ((a) this.bsj).setFrom(str);
        }
    }

    public void aO(String str, int i) {
        if (this.bsj instanceof a) {
            ((a) this.bsj).aO(str, i);
        }
    }

    public void bfl() {
        if (this.bsj instanceof a) {
            ((a) this.bsj).bfl();
        }
    }

    public void bGK() {
        if (this.bsj instanceof a) {
            ((a) this.bsj).bGK();
        }
    }
}
