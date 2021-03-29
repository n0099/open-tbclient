package com.baidu.webkit.logsdk.b;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public String f26997a;

    /* renamed from: b  reason: collision with root package name */
    public HashSet<String> f26998b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f26999c = new HashSet<>();

    public c(String str) {
        this.f26997a = "full";
        this.f26997a = str;
    }

    public final void a(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            String string = jSONArray.getString(i);
            if (!TextUtils.isEmpty(string)) {
                this.f26998b.add(string);
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
                this.f26999c.add(string);
            }
        }
    }
}
