package com.bun.miitmdid.supplier.h.a;

import android.database.ContentObserver;
/* loaded from: classes11.dex */
public class c extends ContentObserver {
    private String a;
    private int b;
    private b nhO;

    public c(b bVar, int i, String str) {
        super(null);
        this.nhO = bVar;
        this.b = i;
        this.a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.nhO != null) {
            this.nhO.a(this.b, this.a);
        } else {
            com.bun.miitmdid.utils.a.b("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
