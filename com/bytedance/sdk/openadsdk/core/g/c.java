package com.bytedance.sdk.openadsdk.core.g;

import com.bytedance.sdk.openadsdk.utils.l;
import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends com.bytedance.sdk.openadsdk.b.c {
    public c(int i, int i2) {
        super(i, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.b.c, com.bytedance.sdk.openadsdk.b.b
    public void a(List<File> list) {
        int size = list.size();
        if (a(0L, size)) {
            return;
        }
        for (File file : list) {
            l.c(file);
            size--;
            if (a(file, 0L, size)) {
                return;
            }
        }
    }
}
