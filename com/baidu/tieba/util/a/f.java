package com.baidu.tieba.util.a;

import com.baidu.adp.lib.e.g;
/* loaded from: classes.dex */
public class f implements com.baidu.adp.lib.e.a {
    private static f a = null;

    public static f a() {
        if (a == null) {
            a = new f();
        }
        return a;
    }

    private f() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.adp.lib.e.a
    public g a(int i) {
        com.baidu.tieba.voice.a.g gVar = null;
        switch (i) {
            case 1:
                return new d();
            case 2:
                return new c();
            case 273:
                gVar = new com.baidu.tieba.voice.a.g();
                break;
        }
        com.baidu.adp.lib.h.e.b("TiebaLoaderCreater", "getLoaderByType", "invalid type:" + i);
        return gVar;
    }
}
