package com.baidu.tieba.write.b;

import android.content.Context;
import com.baidu.tbadk.editortools.x;
/* loaded from: classes.dex */
public class f extends x {
    public f(Context context, String str) {
        super(context, (String) null, 15);
        this.aAA = false;
        this.aAz = 3;
        this.azL = new a(context);
        ((a) this.azL).setCallFrom(str);
        this.aAB = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 50};
    }

    public void bsL() {
        if (this.azL instanceof a) {
            ((a) this.azL).bsL();
        }
    }
}
