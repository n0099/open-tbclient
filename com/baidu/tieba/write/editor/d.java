package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes2.dex */
public class d extends r {
    public d(Context context, String str) {
        super(context, (String) null, 15);
        this.bra = false;
        this.bqZ = 3;
        this.bqj = new a(context, str);
        this.brb = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.bqj instanceof a) {
            ((a) this.bqj).setFrom(str);
        }
    }

    public void aN(String str, int i) {
        if (this.bqj instanceof a) {
            ((a) this.bqj).aN(str, i);
        }
    }

    public void bdL() {
        if (this.bqj instanceof a) {
            ((a) this.bqj).bdL();
        }
    }

    public void bFX() {
        if (this.bqj instanceof a) {
            ((a) this.bqj).bFX();
        }
    }
}
