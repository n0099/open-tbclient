package com.baidu.webkit.logsdk.c;

import java.util.Collection;
import java.util.Vector;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    String f6002a;

    /* renamed from: b  reason: collision with root package name */
    public Vector<String> f6003b = new Vector<>();

    public a(String str) {
        this.f6002a = str;
    }

    public final int a(String str) {
        if (str != null) {
            this.f6003b.add(str);
        }
        return this.f6003b.size();
    }

    public final String a() {
        return new JSONArray((Collection) this.f6003b).toString();
    }
}
