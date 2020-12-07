package com.bun.miitmdid.supplier.h.a;

import android.database.ContentObserver;
/* loaded from: classes18.dex */
public class c extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private String f3997a;
    private int b;
    private b oYX;

    public c(b bVar, int i, String str) {
        super(null);
        this.oYX = bVar;
        this.b = i;
        this.f3997a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.oYX != null) {
            this.oYX.a(this.b, this.f3997a);
        } else {
            com.bun.miitmdid.utils.a.b("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
