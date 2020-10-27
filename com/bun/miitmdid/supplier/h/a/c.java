package com.bun.miitmdid.supplier.h.a;

import android.database.ContentObserver;
/* loaded from: classes11.dex */
public class c extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private String f3992a;
    private int b;
    private b oyU;

    public c(b bVar, int i, String str) {
        super(null);
        this.oyU = bVar;
        this.b = i;
        this.f3992a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.oyU != null) {
            this.oyU.a(this.b, this.f3992a);
        } else {
            com.bun.miitmdid.utils.a.b("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
