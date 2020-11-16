package com.bun.miitmdid.supplier.h.a;

import android.database.ContentObserver;
/* loaded from: classes5.dex */
public class c extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private String f3994a;
    private int b;
    private b oJR;

    public c(b bVar, int i, String str) {
        super(null);
        this.oJR = bVar;
        this.b = i;
        this.f3994a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.oJR != null) {
            this.oJR.a(this.b, this.f3994a);
        } else {
            com.bun.miitmdid.utils.a.b("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
