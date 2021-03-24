package com.bun.miitmdid.supplier.h.a;

import android.database.ContentObserver;
/* loaded from: classes5.dex */
public class c extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f27133a;

    /* renamed from: b  reason: collision with root package name */
    public int f27134b;

    /* renamed from: c  reason: collision with root package name */
    public b f27135c;

    public c(b bVar, int i, String str) {
        super(null);
        this.f27135c = bVar;
        this.f27134b = i;
        this.f27133a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        b bVar = this.f27135c;
        if (bVar != null) {
            bVar.a(this.f27134b, this.f27133a);
        } else {
            com.bun.miitmdid.utils.a.b("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
