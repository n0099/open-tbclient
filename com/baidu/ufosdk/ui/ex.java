package com.baidu.ufosdk.ui;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public final class ex implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ev f23658a;

    public ex(ev evVar) {
        this.f23658a = evVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2;
        int i3;
        ArrayList arrayList;
        i2 = this.f23658a.f23655i;
        JSONArray jSONArray = null;
        String trim = i2 != -1 ? this.f23658a.f23648b.getText().toString().trim() : null;
        i3 = this.f23658a.f23654h;
        if (i3 != -1) {
            arrayList = this.f23658a.m;
            jSONArray = new JSONArray((Collection) arrayList);
        }
        ev.a(this.f23658a, trim, jSONArray);
    }
}
