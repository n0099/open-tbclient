package com.baidu.tieba.util.a;

import com.baidu.adp.lib.c.g;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.lib.c.a {

    /* renamed from: a  reason: collision with root package name */
    private static d f1890a = null;

    public static d a() {
        if (f1890a == null) {
            f1890a = new d();
        }
        return f1890a;
    }

    private d() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.adp.lib.c.a
    public g a(int i) {
        com.baidu.tieba.voice.a.g gVar = null;
        switch (i) {
            case 1:
                return new c();
            case 2:
                return new b();
            case 273:
                gVar = new com.baidu.tieba.voice.a.g();
                break;
        }
        com.baidu.adp.lib.f.d.b("TiebaLoaderCreater", "getLoaderByType", "invalid type:" + i);
        return gVar;
    }
}
