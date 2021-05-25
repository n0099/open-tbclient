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
    public static final Map<String, Integer> f27989a;

    /* renamed from: b  reason: collision with root package name */
    public String f27990b;

    /* renamed from: c  reason: collision with root package name */
    public String f27991c;

    /* renamed from: d  reason: collision with root package name */
    public d f27992d;

    static {
        HashMap hashMap = new HashMap();
        f27989a = hashMap;
        hashMap.put("title", 0);
        f27989a.put("subtitle", 0);
        f27989a.put("source", 0);
        f27989a.put("score-count", 0);
        f27989a.put("text_star", 0);
        f27989a.put("image", 1);
        f27989a.put("image-wide", 1);
        f27989a.put("image-square", 1);
        f27989a.put("image-long", 1);
        f27989a.put("image-splash", 1);
        f27989a.put("image-cover", 1);
        f27989a.put("app-icon", 1);
        f27989a.put("icon-download", 1);
        f27989a.put(AccountConstants.LOGIN_TYPE_NATIVE_SRC_STAR, 1);
        f27989a.put("logoad", 4);
        f27989a.put("logounion", 5);
        f27989a.put("logo-union", 6);
        f27989a.put("dislike", 3);
        f27989a.put(IntentConfig.CLOSE, 3);
        f27989a.put("close-fill", 3);
        f27989a.put("text", 2);
        f27989a.put("button", 2);
        f27989a.put("downloadWithIcon", 2);
        f27989a.put("downloadButton", 2);
        f27989a.put("fillButton", 2);
        f27989a.put("laceButton", 2);
        f27989a.put("cardButton", 2);
        f27989a.put("colourMixtureButton", 2);
        f27989a.put("arrowButton", 2);
        f27989a.put("vessel", 6);
        f27989a.put("video-hd", 7);
        f27989a.put("video-vd", 7);
    }

    public int a() {
        if (TextUtils.isEmpty(this.f27990b)) {
            return 0;
        }
        if (this.f27990b.equals("logo")) {
            this.f27990b += this.f27991c;
        }
        if (f27989a.get(this.f27990b) != null) {
            return f27989a.get(this.f27990b).intValue();
        }
        return 0;
    }

    public String b() {
        return this.f27991c;
    }

    public d c() {
        return this.f27992d;
    }

    public void b(String str) {
        this.f27991c = str;
    }

    public void a(String str) {
        this.f27990b = str;
    }

    public void a(d dVar) {
        this.f27992d = dVar;
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
