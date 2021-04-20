package com.baidu.ufosdk.ui;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public final class ex implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ev f22937a;

    public ex(ev evVar) {
        this.f22937a = evVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        ArrayList arrayList;
        i = this.f22937a.i;
        JSONArray jSONArray = null;
        String trim = i != -1 ? this.f22937a.f22928b.getText().toString().trim() : null;
        i2 = this.f22937a.f22934h;
        if (i2 != -1) {
            arrayList = this.f22937a.m;
            jSONArray = new JSONArray((Collection) arrayList);
        }
        ev.a(this.f22937a, trim, jSONArray);
    }
}
