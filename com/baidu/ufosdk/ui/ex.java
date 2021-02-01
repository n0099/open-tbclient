package com.baidu.ufosdk.ui;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class ex implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ev f5584a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ex(ev evVar) {
        this.f5584a = evVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        ArrayList arrayList;
        JSONArray jSONArray = null;
        i = this.f5584a.i;
        String trim = i != -1 ? this.f5584a.f5581b.getText().toString().trim() : null;
        i2 = this.f5584a.h;
        if (i2 != -1) {
            arrayList = this.f5584a.m;
            jSONArray = new JSONArray((Collection) arrayList);
        }
        ev.a(this.f5584a, trim, jSONArray);
    }
}
