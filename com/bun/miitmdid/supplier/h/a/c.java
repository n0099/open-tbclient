package com.bun.miitmdid.supplier.h.a;

import android.database.ContentObserver;
/* loaded from: classes4.dex */
public class c extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private String f3889a;
    private int b;
    private b poH;

    public c(b bVar, int i, String str) {
        super(null);
        this.poH = bVar;
        this.b = i;
        this.f3889a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.poH != null) {
            this.poH.a(this.b, this.f3889a);
        } else {
            com.bun.miitmdid.utils.a.b("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
