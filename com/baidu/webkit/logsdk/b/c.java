package com.baidu.webkit.logsdk.b;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes14.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public String f5701a;

    /* renamed from: b  reason: collision with root package name */
    public HashSet<String> f5702b = new HashSet<>();
    public HashSet<String> c = new HashSet<>();

    public c(String str) {
        this.f5701a = "full";
        this.f5701a = str;
    }

    public final void a(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            String string = jSONArray.getString(i);
            if (!TextUtils.isEmpty(string)) {
                this.f5702b.add(string);
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
