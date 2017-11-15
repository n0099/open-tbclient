package com.baidu.tieba.write.b;

import android.content.Context;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes2.dex */
public class b extends r {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.aCc = false;
        this.aCb = 3;
        this.aBn = new a(context);
        ((a) this.aBn).setCallFrom(str);
        this.aCd = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 50};
    }

    public void aUG() {
        if (this.aBn instanceof a) {
            ((a) this.aBn).aUG();
        }
    }
}
