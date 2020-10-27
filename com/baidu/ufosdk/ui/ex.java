package com.baidu.ufosdk.ui;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class ex implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ev f3867a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ex(ev evVar) {
        this.f3867a = evVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        ArrayList arrayList;
        JSONArray jSONArray = null;
        i = this.f3867a.i;
        String trim = i != -1 ? this.f3867a.b.getText().toString().trim() : null;
        i2 = this.f3867a.h;
        if (i2 != -1) {
            arrayList = this.f3867a.m;
            jSONArray = new JSONArray((Collection) arrayList);
        }
        ev.a(this.f3867a, trim, jSONArray);
    }
}
