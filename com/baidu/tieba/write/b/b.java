package com.baidu.tieba.write.b;

import android.content.Context;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes.dex */
public class b extends r {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.aCT = false;
        this.aCS = 3;
        this.aCe = new a(context);
        ((a) this.aCe).setCallFrom(str);
        this.aCU = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 50};
    }

    public void bza() {
        if (this.aCe instanceof a) {
            ((a) this.aCe).bza();
        }
    }
}
