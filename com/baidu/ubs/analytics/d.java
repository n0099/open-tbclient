package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.ubs.analytics.a.g;
import com.baidu.ubs.analytics.d.i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class d {
    private Context g;
    private String h;
    private String i;
    private boolean j;
    private Map<String, g> k;
    private JSONArray nqa;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        public static final d nqb = new d((byte) 0);
    }

    /* synthetic */ d(byte b) {
        this();
    }

    public final Map<String, g> dQo() {
        return this.k;
    }

    public final boolean i() {
        return this.j;
    }

    public final synchronized void a(boolean z) {
        this.j = z;
    }

    public static d dQp() {
        return a.nqb;
    }

    public final void a(Context context) {
        this.g = context;
    }

    public final Context getContext() {
        return this.g;
    }

    public final String k() {
        return this.h;
    }

    public final void a(String str) {
        this.h = str;
    }

    public final String l() {
        return this.i;
    }

    public final void b(String str) {
        this.i = str;
    }

    public final synchronized void a(List<g> list) {
        this.k = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (list.get(i2) != null) {
                    this.k.put(list.get(i2).getId(), list.get(i2));
                }
                i = i2 + 1;
            }
        }
    }

    private d() {
        this.j = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SampleResult Uq(String str) {
        if (this.nqa == null) {
            if (str == null || this.k == null) {
                return SampleResult.OTHERE;
            }
            if (this.k.containsKey(str)) {
                return i.Uy(this.k.get(str).getGroup());
            }
            return SampleResult.OTHERE;
        }
        for (int i = 0; i < this.nqa.length(); i++) {
            JSONObject optJSONObject = this.nqa.optJSONObject(i);
            if (optJSONObject != null && str.equals(optJSONObject.optString("exid"))) {
                return i.Uy(optJSONObject.optString(TbEnum.ParamKey.GROUP));
            }
        }
        return SampleResult.OTHERE;
    }
}
