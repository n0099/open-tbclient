package com.baidu.webkit.logsdk.c;

import java.util.Collection;
import java.util.Vector;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    String f5705a;

    /* renamed from: b  reason: collision with root package name */
    public Vector<String> f5706b = new Vector<>();

    public a(String str) {
        this.f5705a = str;
    }

    public final int a(String str) {
        if (str != null) {
            this.f5706b.add(str);
        }
        return this.f5706b.size();
    }

    public final String a() {
        return new JSONArray((Collection) this.f5706b).toString();
    }
}
