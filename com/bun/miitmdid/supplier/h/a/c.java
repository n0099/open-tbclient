package com.bun.miitmdid.supplier.h.a;

import android.database.ContentObserver;
/* loaded from: classes5.dex */
public class c extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private String f5758a;

    /* renamed from: b  reason: collision with root package name */
    private int f5759b;
    private b pbJ;

    public c(b bVar, int i, String str) {
        super(null);
        this.pbJ = bVar;
        this.f5759b = i;
        this.f5758a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.pbJ != null) {
            this.pbJ.a(this.f5759b, this.f5758a);
        } else {
            com.bun.miitmdid.utils.a.b("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
