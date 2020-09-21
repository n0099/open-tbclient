package com.baidu.ufosdk.ui;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes21.dex */
public final class ex implements Runnable {
    final /* synthetic */ ev a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ex(ev evVar) {
        this.a = evVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        ArrayList arrayList;
        JSONArray jSONArray = null;
        i = this.a.i;
        String trim = i != -1 ? this.a.b.getText().toString().trim() : null;
        i2 = this.a.h;
        if (i2 != -1) {
            arrayList = this.a.m;
            jSONArray = new JSONArray((Collection) arrayList);
        }
        ev.a(this.a, trim, jSONArray);
    }
}
