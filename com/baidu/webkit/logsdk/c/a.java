package com.baidu.webkit.logsdk.c;

import java.util.Collection;
import java.util.Vector;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f26677a;

    /* renamed from: b  reason: collision with root package name */
    public Vector<String> f26678b = new Vector<>();

    public a(String str) {
        this.f26677a = str;
    }

    public final int a(String str) {
        if (str != null) {
            this.f26678b.add(str);
        }
        return this.f26678b.size();
    }

    public final String a() {
        return new JSONArray((Collection) this.f26678b).toString();
    }
}
