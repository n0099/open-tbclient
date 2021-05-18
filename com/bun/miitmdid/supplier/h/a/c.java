package com.bun.miitmdid.supplier.h.a;

import android.database.ContentObserver;
/* loaded from: classes5.dex */
public class c extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f26886a;

    /* renamed from: b  reason: collision with root package name */
    public int f26887b;

    /* renamed from: c  reason: collision with root package name */
    public b f26888c;

    public c(b bVar, int i2, String str) {
        super(null);
        this.f26888c = bVar;
        this.f26887b = i2;
        this.f26886a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        b bVar = this.f26888c;
        if (bVar != null) {
            bVar.a(this.f26887b, this.f26886a);
        } else {
            com.bun.miitmdid.utils.a.b("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
