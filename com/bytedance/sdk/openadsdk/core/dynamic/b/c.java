package com.bytedance.sdk.openadsdk.core.dynamic.b;

import android.text.TextUtils;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Integer> f27961a;

    /* renamed from: b  reason: collision with root package name */
    public String f27962b;

    /* renamed from: c  reason: collision with root package name */
    public String f27963c;

    /* renamed from: d  reason: collision with root package name */
    public d f27964d;

    static {
        HashMap hashMap = new HashMap();
        f27961a = hashMap;
        hashMap.put("title", 0);
        f27961a.put("subtitle", 0);
        f27961a.put("source", 0);
        f27961a.put("score-count", 0);
        f27961a.put("text_star", 0);
        f27961a.put("image", 1);
        f27961a.put("image-wide", 1);
        f27961a.put("image-square", 1);
        f27961a.put("image-long", 1);
        f27961a.put("image-splash", 1);
        f27961a.put("image-cover", 1);
        f27961a.put("app-icon", 1);
        f27961a.put("icon-download", 1);
        f27961a.put(AccountConstants.LOGIN_TYPE_NATIVE_SRC_STAR, 1);
        f27961a.put("logoad", 4);
        f27961a.put("logounion", 5);
        f27961a.put("logo-union", 6);
        f27961a.put("dislike", 3);
        f27961a.put(IntentConfig.CLOSE, 3);
        f27961a.put("close-fill", 3);
        f27961a.put("text", 2);
        f27961a.put("button", 2);
        f27961a.put("downloadWithIcon", 2);
        f27961a.put("downloadButton", 2);
        f27961a.put("fillButton", 2);
        f27961a.put("laceButton", 2);
        f27961a.put("cardButton", 2);
        f27961a.put("colourMixtureButton", 2);
        f27961a.put("arrowButton", 2);
        f27961a.put("vessel", 6);
        f27961a.put("video-hd", 7);
        f27961a.put("video-vd", 7);
    }

    public int a() {
        if (TextUtils.isEmpty(this.f27962b)) {
            return 0;
        }
        if (this.f27962b.equals("logo")) {
            this.f27962b += this.f27963c;
        }
        if (f27961a.get(this.f27962b) != null) {
            return f27961a.get(this.f27962b).intValue();
        }
        return 0;
    }

    public String b() {
        return this.f27963c;
    }

    public d c() {
        return this.f27964d;
    }

    public void b(String str) {
        this.f27963c = str;
    }

    public void a(String str) {
        this.f27962b = str;
    }

    public void a(d dVar) {
        this.f27964d = dVar;
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
