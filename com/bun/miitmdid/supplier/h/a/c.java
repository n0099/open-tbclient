package com.bun.miitmdid.supplier.h.a;

import android.database.ContentObserver;
/* loaded from: classes5.dex */
public class c extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f27641a;

    /* renamed from: b  reason: collision with root package name */
    public int f27642b;

    /* renamed from: c  reason: collision with root package name */
    public b f27643c;

    public c(b bVar, int i2, String str) {
        super(null);
        this.f27643c = bVar;
        this.f27642b = i2;
        this.f27641a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        b bVar = this.f27643c;
        if (bVar != null) {
            bVar.a(this.f27642b, this.f27641a);
        } else {
            com.bun.miitmdid.utils.a.b("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
