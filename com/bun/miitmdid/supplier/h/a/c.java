package com.bun.miitmdid.supplier.h.a;

import android.database.ContentObserver;
/* loaded from: classes6.dex */
public class c extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f26918a;

    /* renamed from: b  reason: collision with root package name */
    public int f26919b;

    /* renamed from: c  reason: collision with root package name */
    public b f26920c;

    public c(b bVar, int i2, String str) {
        super(null);
        this.f26920c = bVar;
        this.f26919b = i2;
        this.f26918a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        b bVar = this.f26920c;
        if (bVar != null) {
            bVar.a(this.f26919b, this.f26918a);
        } else {
            com.bun.miitmdid.utils.a.b("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
