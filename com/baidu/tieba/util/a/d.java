package com.baidu.tieba.util.a;

import com.baidu.adp.lib.c.g;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.lib.c.a {

    /* renamed from: a  reason: collision with root package name */
    private static d f1774a = null;

    public static d a() {
        if (f1774a == null) {
            f1774a = new d();
        }
        return f1774a;
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
