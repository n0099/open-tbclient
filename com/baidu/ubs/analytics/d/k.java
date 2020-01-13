package com.baidu.ubs.analytics.d;

import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.ubs.analytics.b.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class k {
    public static void init() {
        c.a(new d() { // from class: com.baidu.ubs.analytics.d.k.1
            @Override // com.baidu.ubs.analytics.d.d
            public final void a() {
                if (g.Lj(a.kVO)) {
                    for (File file : k.Ln(a.kVO)) {
                        if (com.baidu.ubs.analytics.b.b.a(com.baidu.ubs.analytics.b.b.a(file, "http://absample.baidu.com/appabapp/appapi/sdkerrorlog"), (b.a) null)) {
                            g.Lk(file.getPath());
                        }
                    }
                }
                if (g.Lj(a.kVP)) {
                    for (File file2 : k.Ln(a.kVP)) {
                        if (!file2.getName().equals(b.cWx()) && com.baidu.ubs.analytics.b.b.a(com.baidu.ubs.analytics.b.b.a(file2, "http://absample.baidu.com/appabapp/appapi/sdklog"), (b.a) null)) {
                            g.Lk(file2.getPath());
                        }
                    }
                }
            }
        });
    }

    static /* synthetic */ List Ln(String str) {
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
