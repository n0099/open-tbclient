package com.baidu.ubs.analytics.d;

import com.baidu.tbadk.TbConfig;
import com.baidu.ubs.analytics.b.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class k {
    public static void init() {
        c.a(new d() { // from class: com.baidu.ubs.analytics.d.k.1
            @Override // com.baidu.ubs.analytics.d.d
            public final void a() {
                if (g.wm(a.hCZ)) {
                    for (File file : k.wq(a.hCZ)) {
                        if (com.baidu.ubs.analytics.b.b.a(com.baidu.ubs.analytics.b.b.a(file, "http://absample.baidu.com/appabapp/appapi/sdkerrorlog"), (b.a) null)) {
                            g.wn(file.getPath());
                        }
                    }
                }
                if (g.wm(a.hDa)) {
                    for (File file2 : k.wq(a.hDa)) {
                        if (!file2.getName().equals(b.bJu()) && com.baidu.ubs.analytics.b.b.a(com.baidu.ubs.analytics.b.b.a(file2, "http://absample.baidu.com/appabapp/appapi/sdklog"), (b.a) null)) {
                            g.wn(file2.getPath());
                        }
                    }
                }
            }
        });
    }

    static /* synthetic */ List wq(String str) {
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
