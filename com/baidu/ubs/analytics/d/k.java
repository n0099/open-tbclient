package com.baidu.ubs.analytics.d;

import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.ubs.analytics.b.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class k {
    public static void init() {
        c.a(new d() { // from class: com.baidu.ubs.analytics.d.k.1
            @Override // com.baidu.ubs.analytics.d.d
            public final void a() {
                if (g.Xb(a.aQ)) {
                    for (File file : k.Xe(a.aQ)) {
                        if (com.baidu.ubs.analytics.b.b.a(com.baidu.ubs.analytics.b.b.a(file, "http://absample.baidu.com/appabapp/appapi/sdkerrorlog"), (b.a) null)) {
                            g.Xc(file.getPath());
                        }
                    }
                }
                if (g.Xb(a.aR)) {
                    for (File file2 : k.Xe(a.aR)) {
                        if (!file2.getName().equals(b.edX()) && com.baidu.ubs.analytics.b.b.a(com.baidu.ubs.analytics.b.b.a(file2, "http://absample.baidu.com/appabapp/appapi/sdklog"), (b.a) null)) {
                            g.Xc(file2.getPath());
                        }
                    }
                }
            }
        });
    }

    static /* synthetic */ List Xe(String str) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                String name = listFiles[i].getName();
                if (name.endsWith(DocumentOpenUtil.TXT) || name.endsWith(TbConfig.TMP_LOG_DIR_NAME)) {
                    arrayList.add(listFiles[i]);
                }
            }
        }
        return arrayList;
    }
}
