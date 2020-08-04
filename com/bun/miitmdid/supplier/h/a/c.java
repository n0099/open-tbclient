package com.bun.miitmdid.supplier.h.a;

import android.database.ContentObserver;
/* loaded from: classes19.dex */
public class c extends ContentObserver {
    private String a;
    private int b;
    private b mOW;

    public c(b bVar, int i, String str) {
        super(null);
        this.mOW = bVar;
        this.b = i;
        this.a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.mOW != null) {
            this.mOW.a(this.b, this.a);
        } else {
            com.bun.miitmdid.utils.a.b("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
