package com.baidu.tieba.write;

import android.content.Context;
import com.baidu.tieba.write.e;
/* loaded from: classes.dex */
public class g {
    public static f a(int i, Context context, e.a aVar) {
        if (i == 1) {
            return new d(context, aVar);
        }
        if (i == 2) {
            return new c(context, aVar);
        }
        return new d(context, aVar);
    }
}
