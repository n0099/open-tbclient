package com.baidu.ubs.analytics.d;

import com.baidu.tbadk.TbConfig;
import com.baidu.ubs.analytics.b.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public final class k {
    public static void init() {
        c.a(new d() { // from class: com.baidu.ubs.analytics.d.k.1
            @Override // com.baidu.ubs.analytics.d.d
            public final void a() {
                if (g.Gj(a.jYH)) {
                    for (File file : k.Gn(a.jYH)) {
                        if (com.baidu.ubs.analytics.b.b.a(com.baidu.ubs.analytics.b.b.a(file, "http://absample.baidu.com/appabapp/appapi/sdkerrorlog"), (b.a) null)) {
                            g.Gk(file.getPath());
                        }
                    }
                }
                if (g.Gj(a.jYI)) {
                    for (File file2 : k.Gn(a.jYI)) {
                        if (!file2.getName().equals(b.cBE()) && com.baidu.ubs.analytics.b.b.a(com.baidu.ubs.analytics.b.b.a(file2, "http://absample.baidu.com/appabapp/appapi/sdklog"), (b.a) null)) {
                            g.Gk(file2.getPath());
                        }
                    }
                }
            }
        });
    }

    static /* synthetic */ List Gn(String str) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                String name = listFiles[i].getName();
                if (name.endsWith("txt") || name.endsWith(TbConfig.TMP_LOG_DIR_NAME)) {
                    arrayList.add(listFiles[i]);
                }
            }
        }
        return arrayList;
    }
}
