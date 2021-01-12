package com.baidu.ufosdk.ui;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class ex implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ev f5582a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ex(ev evVar) {
        this.f5582a = evVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        ArrayList arrayList;
        JSONArray jSONArray = null;
        i = this.f5582a.i;
        String trim = i != -1 ? this.f5582a.f5579b.getText().toString().trim() : null;
        i2 = this.f5582a.h;
        if (i2 != -1) {
            arrayList = this.f5582a.m;
            jSONArray = new JSONArray((Collection) arrayList);
        }
        ev.a(this.f5582a, trim, jSONArray);
    }
}
