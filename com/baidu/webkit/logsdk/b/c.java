package com.baidu.webkit.logsdk.b;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public String f26859a;

    /* renamed from: b  reason: collision with root package name */
    public HashSet<String> f26860b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f26861c = new HashSet<>();

    public c(String str) {
        this.f26859a = "full";
        this.f26859a = str;
    }

    public final void a(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String string = jSONArray.getString(i2);
            if (!TextUtils.isEmpty(string)) {
                this.f26860b.add(string);
            }
        }
    }

    public final void b(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String string = jSONArray.getString(i2);
            if (!TextUtils.isEmpty(string)) {
                this.f26861c.add(string);
            }
        }
    }
}
