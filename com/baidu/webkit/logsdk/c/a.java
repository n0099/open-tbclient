package com.baidu.webkit.logsdk.c;

import java.util.Collection;
import java.util.Vector;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f26748a;

    /* renamed from: b  reason: collision with root package name */
    public Vector<String> f26749b = new Vector<>();

    public a(String str) {
        this.f26748a = str;
    }

    public final int a(String str) {
        if (str != null) {
            this.f26749b.add(str);
        }
        return this.f26749b.size();
    }

    public final String a() {
        return new JSONArray((Collection) this.f26749b).toString();
    }
}
