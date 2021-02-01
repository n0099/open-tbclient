package com.bun.miitmdid.supplier.h.a;

import android.database.ContentObserver;
/* loaded from: classes15.dex */
public class c extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private String f5760a;

    /* renamed from: b  reason: collision with root package name */
    private int f5761b;
    private b plZ;

    public c(b bVar, int i, String str) {
        super(null);
        this.plZ = bVar;
        this.f5761b = i;
        this.f5760a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.plZ != null) {
            this.plZ.a(this.f5761b, this.f5760a);
        } else {
            com.bun.miitmdid.utils.a.b("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
