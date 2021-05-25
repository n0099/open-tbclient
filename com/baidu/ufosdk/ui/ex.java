package com.baidu.ufosdk.ui;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public final class ex implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ev f22832a;

    public ex(ev evVar) {
        this.f22832a = evVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2;
        int i3;
        ArrayList arrayList;
        i2 = this.f22832a.f22829i;
        JSONArray jSONArray = null;
        String trim = i2 != -1 ? this.f22832a.f22822b.getText().toString().trim() : null;
        i3 = this.f22832a.f22828h;
        if (i3 != -1) {
            arrayList = this.f22832a.m;
            jSONArray = new JSONArray((Collection) arrayList);
        }
        ev.a(this.f22832a, trim, jSONArray);
    }
}
