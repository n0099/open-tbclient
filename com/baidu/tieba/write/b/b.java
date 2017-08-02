package com.baidu.tieba.write.b;

import android.content.Context;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes.dex */
public class b extends r {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.aBA = false;
        this.aBz = 3;
        this.aAL = new a(context);
        ((a) this.aAL).setCallFrom(str);
        this.aBB = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 50};
    }

    public void byu() {
        if (this.aAL instanceof a) {
            ((a) this.aAL).byu();
        }
    }
}
