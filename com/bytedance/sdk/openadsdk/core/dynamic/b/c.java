package com.bytedance.sdk.openadsdk.core.dynamic.b;

import android.text.TextUtils;
import com.baidu.searchbox.account.contants.AccountConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Integer> f4413a = new HashMap();
    private String b;
    private String c;
    private d d;

    static {
        f4413a.put("title", 0);
        f4413a.put("subtitle", 0);
        f4413a.put("source", 0);
        f4413a.put("score-count", 0);
        f4413a.put("text_star", 0);
        f4413a.put("image", 1);
        f4413a.put("image-wide", 1);
        f4413a.put("image-square", 1);
        f4413a.put("image-long", 1);
        f4413a.put("image-splash", 1);
        f4413a.put("image-cover", 1);
        f4413a.put("app-icon", 1);
        f4413a.put("icon-download", 1);
        f4413a.put(AccountConstants.LOGIN_TYPE_NATIVE_SRC_STAR, 1);
        f4413a.put("logoad", 4);
        f4413a.put("logounion", 5);
        f4413a.put("logo-union", 6);
        f4413a.put("dislike", 3);
        f4413a.put("close", 3);
        f4413a.put("close-fill", 3);
        f4413a.put("text", 2);
        f4413a.put("button", 2);
        f4413a.put("downloadWithIcon", 2);
        f4413a.put("downloadButton", 2);
        f4413a.put("fillButton", 2);
        f4413a.put("laceButton", 2);
        f4413a.put("cardButton", 2);
        f4413a.put("colourMixtureButton", 2);
        f4413a.put("arrowButton", 2);
        f4413a.put("vessel", 6);
        f4413a.put("video-hd", 7);
        f4413a.put("video-vd", 7);
    }

    public int a() {
        if (TextUtils.isEmpty(this.b)) {
            return 0;
        }
        if (this.b.equals("logo")) {
            this.b += this.c;
        }
        if (f4413a.get(this.b) != null) {
            return f4413a.get(this.b).intValue();
        }
        return 0;
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }

    public d c() {
        return this.d;
    }

    public void a(d dVar) {
        this.d = dVar;
    }

    public static void a(JSONObject jSONObject, c cVar) {
        if (jSONObject != null && cVar != null) {
            cVar.a(jSONObject.optString("type", "root"));
            cVar.b(jSONObject.optString("data"));
            cVar.a(d.a(jSONObject.optJSONObject("values")));
        }
    }
}
