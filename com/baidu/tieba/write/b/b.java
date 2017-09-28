package com.baidu.tieba.write.b;

import android.content.Context;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes2.dex */
public class b extends r {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.aBx = false;
        this.aBw = 3;
        this.aAH = new a(context);
        ((a) this.aAH).setCallFrom(str);
        this.aBy = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 50};
    }

    public void aRv() {
        if (this.aAH instanceof a) {
            ((a) this.aAH).aRv();
        }
    }
}
