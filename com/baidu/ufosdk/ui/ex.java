package com.baidu.ufosdk.ui;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public final class ex implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ev f22945a;

    public ex(ev evVar) {
        this.f22945a = evVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        ArrayList arrayList;
        i = this.f22945a.i;
        JSONArray jSONArray = null;
        String trim = i != -1 ? this.f22945a.f22936b.getText().toString().trim() : null;
        i2 = this.f22945a.f22942h;
        if (i2 != -1) {
            arrayList = this.f22945a.m;
            jSONArray = new JSONArray((Collection) arrayList);
        }
        ev.a(this.f22945a, trim, jSONArray);
    }
}
