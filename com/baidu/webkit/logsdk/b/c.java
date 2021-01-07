package com.baidu.webkit.logsdk.b;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes15.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public String f6001a;

    /* renamed from: b  reason: collision with root package name */
    public HashSet<String> f6002b = new HashSet<>();
    public HashSet<String> c = new HashSet<>();

    public c(String str) {
        this.f6001a = "full";
        this.f6001a = str;
    }

    public final void a(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            String string = jSONArray.getString(i);
            if (!TextUtils.isEmpty(string)) {
                this.f6002b.add(string);
            }
        }
    }

    public final void b(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            String string = jSONArray.getString(i);
            if (!TextUtils.isEmpty(string)) {
                this.c.add(string);
            }
        }
    }
}
