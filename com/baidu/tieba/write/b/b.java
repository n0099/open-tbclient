package com.baidu.tieba.write.b;

import android.content.Context;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes2.dex */
public class b extends r {
    public b(Context context, String str) {
        super(context, (String) null, 15);
        this.aCg = false;
        this.aCf = 3;
        this.aBq = new a(context);
        ((a) this.aBq).setCallFrom(str);
        this.aCh = new int[]{9, 20, 19, 12, 13, 10, 11, 46, 49, 50};
    }

    public void aTe() {
        if (this.aBq instanceof a) {
            ((a) this.aBq).aTe();
        }
    }
}
