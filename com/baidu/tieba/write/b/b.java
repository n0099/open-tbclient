package com.baidu.tieba.write.b;

import android.content.Context;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes2.dex */
public class b extends r {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.aBU = false;
        this.aBT = 3;
        this.aBf = new a(context);
        ((a) this.aBf).setCallFrom(str);
        this.aBV = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 50};
    }

    public void aUy() {
        if (this.aBf instanceof a) {
            ((a) this.aBf).aUy();
        }
    }
}
