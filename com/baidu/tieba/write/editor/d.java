package com.baidu.tieba.write.editor;

import android.content.Context;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes2.dex */
public class d extends r {
    public d(Context context, String str) {
        super(context, (String) null, 15);
        this.bqR = false;
        this.bqQ = 3;
        this.bqa = new a(context, str);
        this.bqS = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 54};
    }

    public void setFrom(String str) {
        if (this.bqa instanceof a) {
            ((a) this.bqa).setFrom(str);
        }
    }

    public void aN(String str, int i) {
        if (this.bqa instanceof a) {
            ((a) this.bqa).aN(str, i);
        }
    }

    public void bdG() {
        if (this.bqa instanceof a) {
            ((a) this.bqa).bdG();
        }
    }

    public void bFV() {
        if (this.bqa instanceof a) {
            ((a) this.bqa).bFV();
        }
    }
}
