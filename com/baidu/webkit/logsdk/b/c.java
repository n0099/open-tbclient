package com.baidu.webkit.logsdk.b;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public String f27500a;

    /* renamed from: b  reason: collision with root package name */
    public HashSet<String> f27501b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f27502c = new HashSet<>();

    public c(String str) {
        this.f27500a = "full";
        this.f27500a = str;
    }

    public final void a(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String string = jSONArray.getString(i2);
            if (!TextUtils.isEmpty(string)) {
                this.f27501b.add(string);
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
                this.f27502c.add(string);
            }
        }
    }
}
