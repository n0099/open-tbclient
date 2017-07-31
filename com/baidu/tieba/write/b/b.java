package com.baidu.tieba.write.b;

import android.content.Context;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes.dex */
public class b extends r {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.aCR = false;
        this.aCQ = 3;
        this.aCc = new a(context);
        ((a) this.aCc).setCallFrom(str);
        this.aCS = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 50};
    }

    public void byB() {
        if (this.aCc instanceof a) {
            ((a) this.aCc).byB();
        }
    }
}
