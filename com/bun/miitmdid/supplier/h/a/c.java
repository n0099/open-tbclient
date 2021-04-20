package com.bun.miitmdid.supplier.h.a;

import android.database.ContentObserver;
/* loaded from: classes5.dex */
public class c extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f26819a;

    /* renamed from: b  reason: collision with root package name */
    public int f26820b;

    /* renamed from: c  reason: collision with root package name */
    public b f26821c;

    public c(b bVar, int i, String str) {
        super(null);
        this.f26821c = bVar;
        this.f26820b = i;
        this.f26819a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        b bVar = this.f26821c;
        if (bVar != null) {
            bVar.a(this.f26820b, this.f26819a);
        } else {
            com.bun.miitmdid.utils.a.b("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
