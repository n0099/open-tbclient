package com.baidu.wallet.paysdk.presenter;

import com.baidu.wallet.paysdk.ui.AuthorizeSignActivity;
/* loaded from: classes5.dex */
public class d {

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static d f25755a = new d();
    }

    public static d a() {
        return a.f25755a;
    }

    public d() {
    }

    public e a(int i, AuthorizeSignActivity authorizeSignActivity) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return new c(authorizeSignActivity);
        }
        return new b(authorizeSignActivity);
    }
}
