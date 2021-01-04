package com.baidu.ufosdk.ui;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class ex implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ev f5864a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ex(ev evVar) {
        this.f5864a = evVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        ArrayList arrayList;
        JSONArray jSONArray = null;
        i = this.f5864a.i;
        String trim = i != -1 ? this.f5864a.f5861b.getText().toString().trim() : null;
        i2 = this.f5864a.h;
        if (i2 != -1) {
            arrayList = this.f5864a.m;
            jSONArray = new JSONArray((Collection) arrayList);
        }
        ev.a(this.f5864a, trim, jSONArray);
    }
}
