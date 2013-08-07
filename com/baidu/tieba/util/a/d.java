package com.baidu.tieba.util.a;

import com.baidu.adp.lib.c.g;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.lib.c.a {

    /* renamed from: a  reason: collision with root package name */
    private static d f1743a = null;

    public static d a() {
        if (f1743a == null) {
            f1743a = new d();
        }
        return f1743a;
    }

    private d() {
    }

    @Override // com.baidu.adp.lib.c.a
    public g a(int i) {
        switch (i) {
            case 1:
                return new c();
            case 2:
                return new b();
            default:
                com.baidu.adp.lib.e.d.b("TiebaLoaderCreater", "getLoaderByType", "invalid type:" + i);
                return null;
        }
    }
}
