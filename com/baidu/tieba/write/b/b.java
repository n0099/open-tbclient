package com.baidu.tieba.write.b;

import android.content.Context;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes2.dex */
public class b extends r {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.aBl = false;
        this.aBk = 3;
        this.aAv = new a(context);
        ((a) this.aAv).setCallFrom(str);
        this.aBm = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 50};
    }

    public void aRq() {
        if (this.aAv instanceof a) {
            ((a) this.aAv).aRq();
        }
    }
}
