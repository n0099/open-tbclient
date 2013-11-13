package com.baidu.tieba.util.a;

import com.baidu.adp.lib.e.g;
/* loaded from: classes.dex */
public class e implements com.baidu.adp.lib.e.a {

    /* renamed from: a  reason: collision with root package name */
    private static e f2474a = null;

    public static e a() {
        if (f2474a == null) {
            f2474a = new e();
        }
        return f2474a;
    }

    private e() {
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
        com.baidu.adp.lib.h.d.b("TiebaLoaderCreater", "getLoaderByType", "invalid type:" + i);
        return gVar;
    }
}
