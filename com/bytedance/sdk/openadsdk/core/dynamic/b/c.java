package com.bytedance.sdk.openadsdk.core.dynamic.b;

import android.text.TextUtils;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Integer> f28268a;

    /* renamed from: b  reason: collision with root package name */
    public String f28269b;

    /* renamed from: c  reason: collision with root package name */
    public String f28270c;

    /* renamed from: d  reason: collision with root package name */
    public d f28271d;

    static {
        HashMap hashMap = new HashMap();
        f28268a = hashMap;
        hashMap.put("title", 0);
        f28268a.put("subtitle", 0);
        f28268a.put("source", 0);
        f28268a.put("score-count", 0);
        f28268a.put("text_star", 0);
        f28268a.put("image", 1);
        f28268a.put("image-wide", 1);
        f28268a.put("image-square", 1);
        f28268a.put("image-long", 1);
        f28268a.put("image-splash", 1);
        f28268a.put("image-cover", 1);
        f28268a.put("app-icon", 1);
        f28268a.put("icon-download", 1);
        f28268a.put(AccountConstants.LOGIN_TYPE_NATIVE_SRC_STAR, 1);
        f28268a.put("logoad", 4);
        f28268a.put("logounion", 5);
        f28268a.put("logo-union", 6);
        f28268a.put("dislike", 3);
        f28268a.put(IntentConfig.CLOSE, 3);
        f28268a.put("close-fill", 3);
        f28268a.put("text", 2);
        f28268a.put("button", 2);
        f28268a.put("downloadWithIcon", 2);
        f28268a.put("downloadButton", 2);
        f28268a.put("fillButton", 2);
        f28268a.put("laceButton", 2);
        f28268a.put("cardButton", 2);
        f28268a.put("colourMixtureButton", 2);
        f28268a.put("arrowButton", 2);
        f28268a.put("vessel", 6);
        f28268a.put("video-hd", 7);
        f28268a.put("video-vd", 7);
    }

    public int a() {
        if (TextUtils.isEmpty(this.f28269b)) {
            return 0;
        }
        if (this.f28269b.equals("logo")) {
            this.f28269b += this.f28270c;
        }
        if (f28268a.get(this.f28269b) != null) {
            return f28268a.get(this.f28269b).intValue();
        }
        return 0;
    }

    public String b() {
        return this.f28270c;
    }

    public d c() {
        return this.f28271d;
    }

    public void b(String str) {
        this.f28270c = str;
    }

    public void a(String str) {
        this.f28269b = str;
    }

    public void a(d dVar) {
        this.f28271d = dVar;
    }

    public static void a(JSONObject jSONObject, c cVar) {
        if (jSONObject == null || cVar == null) {
            return;
        }
        cVar.a(jSONObject.optString("type", "root"));
        cVar.b(jSONObject.optString("data"));
        cVar.a(d.a(jSONObject.optJSONObject("values")));
    }
}
