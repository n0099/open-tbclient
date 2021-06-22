package com.baidu.wallet.paysdk.presenter;

import com.baidu.wallet.paysdk.ui.AuthorizeSignActivity;
/* loaded from: classes5.dex */
public class d {

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static d f25581a = new d();
    }

    public static d a() {
        return a.f25581a;
    }

    public d() {
    }

    public e a(int i2, AuthorizeSignActivity authorizeSignActivity) {
        if (i2 != 1) {
            if (i2 != 2) {
                return null;
            }
            return new c(authorizeSignActivity);
        }
        return new b(authorizeSignActivity);
    }
}
