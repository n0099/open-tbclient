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
    public static final Map<String, Integer> f27953a;

    /* renamed from: b  reason: collision with root package name */
    public String f27954b;

    /* renamed from: c  reason: collision with root package name */
    public String f27955c;

    /* renamed from: d  reason: collision with root package name */
    public d f27956d;

    static {
        HashMap hashMap = new HashMap();
        f27953a = hashMap;
        hashMap.put("title", 0);
        f27953a.put("subtitle", 0);
        f27953a.put("source", 0);
        f27953a.put("score-count", 0);
        f27953a.put("text_star", 0);
        f27953a.put("image", 1);
        f27953a.put("image-wide", 1);
        f27953a.put("image-square", 1);
        f27953a.put("image-long", 1);
        f27953a.put("image-splash", 1);
        f27953a.put("image-cover", 1);
        f27953a.put("app-icon", 1);
        f27953a.put("icon-download", 1);
        f27953a.put(AccountConstants.LOGIN_TYPE_NATIVE_SRC_STAR, 1);
        f27953a.put("logoad", 4);
        f27953a.put("logounion", 5);
        f27953a.put("logo-union", 6);
        f27953a.put("dislike", 3);
        f27953a.put(IntentConfig.CLOSE, 3);
        f27953a.put("close-fill", 3);
        f27953a.put("text", 2);
        f27953a.put("button", 2);
        f27953a.put("downloadWithIcon", 2);
        f27953a.put("downloadButton", 2);
        f27953a.put("fillButton", 2);
        f27953a.put("laceButton", 2);
        f27953a.put("cardButton", 2);
        f27953a.put("colourMixtureButton", 2);
        f27953a.put("arrowButton", 2);
        f27953a.put("vessel", 6);
        f27953a.put("video-hd", 7);
        f27953a.put("video-vd", 7);
    }

    public int a() {
        if (TextUtils.isEmpty(this.f27954b)) {
            return 0;
        }
        if (this.f27954b.equals("logo")) {
            this.f27954b += this.f27955c;
        }
        if (f27953a.get(this.f27954b) != null) {
            return f27953a.get(this.f27954b).intValue();
        }
        return 0;
    }

    public String b() {
        return this.f27955c;
    }

    public d c() {
        return this.f27956d;
    }

    public void b(String str) {
        this.f27955c = str;
    }

    public void a(String str) {
        this.f27954b = str;
    }

    public void a(d dVar) {
        this.f27956d = dVar;
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
