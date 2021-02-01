package com.bytedance.sdk.openadsdk.core.g;

import com.bytedance.sdk.openadsdk.utils.l;
import java.io.File;
import java.util.List;
/* loaded from: classes6.dex */
public class c extends com.bytedance.sdk.openadsdk.b.c {
    public c(int i, int i2) {
        super(i, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.b.c, com.bytedance.sdk.openadsdk.b.b
    protected void a(List<File> list) {
        int size = list.size();
        if (!a(0L, size)) {
            int i = size;
            for (File file : list) {
                l.c(file);
                i--;
                if (a(file, 0L, i)) {
                    return;
                }
            }
        }
    }
}
