package com.baidu.tieba.write.b;

import android.content.Context;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes.dex */
public class b extends r {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.aCS = false;
        this.aCR = 3;
        this.aCd = new a(context);
        ((a) this.aCd).setCallFrom(str);
        this.aCT = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 50};
    }

    public void bzi() {
        if (this.aCd instanceof a) {
            ((a) this.aCd).bzi();
        }
    }
}
