package com.bun.miitmdid.supplier.h.a;

import android.database.ContentObserver;
/* loaded from: classes5.dex */
public class c extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private String f6058a;

    /* renamed from: b  reason: collision with root package name */
    private int f6059b;
    private b pgm;

    public c(b bVar, int i, String str) {
        super(null);
        this.pgm = bVar;
        this.f6059b = i;
        this.f6058a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.pgm != null) {
            this.pgm.a(this.f6059b, this.f6058a);
        } else {
            com.bun.miitmdid.utils.a.b("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
