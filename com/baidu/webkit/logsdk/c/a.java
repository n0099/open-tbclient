package com.baidu.webkit.logsdk.c;

import java.util.Collection;
import java.util.Vector;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    String f3958a;
    public Vector<String> b = new Vector<>();

    public a(String str) {
        this.f3958a = str;
    }

    public final int a(String str) {
        if (str != null) {
            this.b.add(str);
        }
        return this.b.size();
    }

    public final String a() {
        return new JSONArray((Collection) this.b).toString();
    }
}
