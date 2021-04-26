package com.bytedance.sdk.openadsdk.core.dynamic.b;

import android.text.TextUtils;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Integer> f28815a;

    /* renamed from: b  reason: collision with root package name */
    public String f28816b;

    /* renamed from: c  reason: collision with root package name */
    public String f28817c;

    /* renamed from: d  reason: collision with root package name */
    public d f28818d;

    static {
        HashMap hashMap = new HashMap();
        f28815a = hashMap;
        hashMap.put("title", 0);
        f28815a.put("subtitle", 0);
        f28815a.put("source", 0);
        f28815a.put("score-count", 0);
        f28815a.put("text_star", 0);
        f28815a.put("image", 1);
        f28815a.put("image-wide", 1);
        f28815a.put("image-square", 1);
        f28815a.put("image-long", 1);
        f28815a.put("image-splash", 1);
        f28815a.put("image-cover", 1);
        f28815a.put("app-icon", 1);
        f28815a.put("icon-download", 1);
        f28815a.put(AccountConstants.LOGIN_TYPE_NATIVE_SRC_STAR, 1);
        f28815a.put("logoad", 4);
        f28815a.put("logounion", 5);
        f28815a.put("logo-union", 6);
        f28815a.put("dislike", 3);
        f28815a.put(IntentConfig.CLOSE, 3);
        f28815a.put("close-fill", 3);
        f28815a.put("text", 2);
        f28815a.put("button", 2);
        f28815a.put("downloadWithIcon", 2);
        f28815a.put("downloadButton", 2);
        f28815a.put("fillButton", 2);
        f28815a.put("laceButton", 2);
        f28815a.put("cardButton", 2);
        f28815a.put("colourMixtureButton", 2);
        f28815a.put("arrowButton", 2);
        f28815a.put("vessel", 6);
        f28815a.put("video-hd", 7);
        f28815a.put("video-vd", 7);
    }

    public int a() {
        if (TextUtils.isEmpty(this.f28816b)) {
            return 0;
        }
        if (this.f28816b.equals("logo")) {
            this.f28816b += this.f28817c;
        }
        if (f28815a.get(this.f28816b) != null) {
            return f28815a.get(this.f28816b).intValue();
        }
        return 0;
    }

    public String b() {
        return this.f28817c;
    }

    public d c() {
        return this.f28818d;
    }

    public void b(String str) {
        this.f28817c = str;
    }

    public void a(String str) {
        this.f28816b = str;
    }

    public void a(d dVar) {
        this.f28818d = dVar;
    }

    public static void a(JSONObject jSONObject, c cVar) {
        if (jSONObject == null || cVar == null) {
            return;
        }
        cVar.a(jSONObject.optString("type", "root"));
        cVar.b(jSONObject.optString("data"));
        cVar.a(d.a(jSONObject.optJSONObject(SavedStateHandle.VALUES)));
    }
}
