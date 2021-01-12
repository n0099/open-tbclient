package com.baidu.webkit.logsdk.c;

import java.util.Collection;
import java.util.Vector;
import org.json.JSONArray;
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    String f5703a;

    /* renamed from: b  reason: collision with root package name */
    public Vector<String> f5704b = new Vector<>();

    public a(String str) {
        this.f5703a = str;
    }

    public final int a(String str) {
        if (str != null) {
            this.f5704b.add(str);
        }
        return this.f5704b.size();
    }

    public final String a() {
        return new JSONArray((Collection) this.f5704b).toString();
    }
}
