package com.bytedance.sdk.openadsdk.core.dynamic.b;

import android.text.TextUtils;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Integer> f28060a;

    /* renamed from: b  reason: collision with root package name */
    public String f28061b;

    /* renamed from: c  reason: collision with root package name */
    public String f28062c;

    /* renamed from: d  reason: collision with root package name */
    public d f28063d;

    static {
        HashMap hashMap = new HashMap();
        f28060a = hashMap;
        hashMap.put("title", 0);
        f28060a.put("subtitle", 0);
        f28060a.put("source", 0);
        f28060a.put("score-count", 0);
        f28060a.put("text_star", 0);
        f28060a.put("image", 1);
        f28060a.put("image-wide", 1);
        f28060a.put("image-square", 1);
        f28060a.put("image-long", 1);
        f28060a.put("image-splash", 1);
        f28060a.put("image-cover", 1);
        f28060a.put("app-icon", 1);
        f28060a.put("icon-download", 1);
        f28060a.put(AccountConstants.LOGIN_TYPE_NATIVE_SRC_STAR, 1);
        f28060a.put("logoad", 4);
        f28060a.put("logounion", 5);
        f28060a.put("logo-union", 6);
        f28060a.put("dislike", 3);
        f28060a.put(IntentConfig.CLOSE, 3);
        f28060a.put("close-fill", 3);
        f28060a.put("text", 2);
        f28060a.put("button", 2);
        f28060a.put("downloadWithIcon", 2);
        f28060a.put("downloadButton", 2);
        f28060a.put("fillButton", 2);
        f28060a.put("laceButton", 2);
        f28060a.put("cardButton", 2);
        f28060a.put("colourMixtureButton", 2);
        f28060a.put("arrowButton", 2);
        f28060a.put("vessel", 6);
        f28060a.put("video-hd", 7);
        f28060a.put("video-vd", 7);
    }

    public int a() {
        if (TextUtils.isEmpty(this.f28061b)) {
            return 0;
        }
        if (this.f28061b.equals("logo")) {
            this.f28061b += this.f28062c;
        }
        if (f28060a.get(this.f28061b) != null) {
            return f28060a.get(this.f28061b).intValue();
        }
        return 0;
    }

    public String b() {
        return this.f28062c;
    }

    public d c() {
        return this.f28063d;
    }

    public void b(String str) {
        this.f28062c = str;
    }

    public void a(String str) {
        this.f28061b = str;
    }

    public void a(d dVar) {
        this.f28063d = dVar;
    }

    public static void a(JSONObject jSONObject, c cVar) {
        if (jSONObject == null || cVar == null) {
            return;
        }
        cVar.a(jSONObject.optString("type", PrefetchEvent.EVENT_DATA_ROOT_PATH));
        cVar.b(jSONObject.optString("data"));
        cVar.a(d.a(jSONObject.optJSONObject(SavedStateHandle.VALUES)));
    }
}
