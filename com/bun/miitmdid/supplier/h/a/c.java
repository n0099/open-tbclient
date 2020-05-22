package com.bun.miitmdid.supplier.h.a;

import android.database.ContentObserver;
/* loaded from: classes6.dex */
public class c extends ContentObserver {
    private String a;
    private int b;
    private b mjH;

    public c(b bVar, int i, String str) {
        super(null);
        this.mjH = bVar;
        this.b = i;
        this.a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.mjH != null) {
            this.mjH.a(this.b, this.a);
        } else {
            com.bun.miitmdid.utils.a.b("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
