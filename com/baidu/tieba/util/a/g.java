package com.baidu.tieba.util.a;

import com.baidu.adp.lib.e.i;
/* loaded from: classes.dex */
public class g implements com.baidu.adp.lib.e.a {
    private static g a = null;

    public static g a() {
        if (a == null) {
            a = new g();
        }
        return a;
    }

    private g() {
    }

    @Override // com.baidu.adp.lib.e.a
    public i a(int i) {
        switch (i) {
            case 1:
                return new e();
            case 2:
                return new d();
            case 3:
                return new b();
            case 273:
                return new com.baidu.tieba.voice.a.g();
            default:
                com.baidu.adp.lib.util.f.b("TiebaLoaderCreater", "getLoaderByType", "invalid type:" + i);
                return null;
        }
    }
}
