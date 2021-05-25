package com.baidu.wallet.lightapp.multipage;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.wallet.core.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public String f24922a;

    /* renamed from: b  reason: collision with root package name */
    public LangbridgeSettings f24923b;

    /* renamed from: c  reason: collision with root package name */
    public b f24924c;

    /* renamed from: d  reason: collision with root package name */
    public Set<WeakReference<a>> f24925d;

    /* loaded from: classes5.dex */
    public interface a {
        void onSettingUpdated(LangbridgeSettings langbridgeSettings);
    }

    /* loaded from: classes5.dex */
    public interface b {
        LangbridgeSettings a(Context context, LangbridgeSettings langbridgeSettings);
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static h f24926a = new h();
    }

    public static h a() {
        return c.f24926a;
    }

    public void b(@NonNull Context context) {
        if (this.f24923b != null) {
            LogUtil.d("LangbridgeSettings", "");
            for (WeakReference<a> weakReference : this.f24925d) {
                if (weakReference != null && weakReference.get() != null) {
                    a aVar = weakReference.get();
                    b bVar = this.f24924c;
                    aVar.onSettingUpdated(bVar != null ? bVar.a(context, this.f24923b) : this.f24923b);
                }
            }
        }
    }

    public h() {
        this.f24925d = new CopyOnWriteArraySet();
        this.f24924c = e.a();
    }

    public LangbridgeSettings a(@NonNull Context context) {
        if (this.f24923b == null) {
            this.f24923b = a(this.f24922a);
        }
        if (this.f24923b == null) {
            this.f24923b = new LangbridgeSettings();
        }
        LogUtil.d("LangbridgeSettings", "");
        b bVar = this.f24924c;
        return bVar != null ? bVar.a(context, this.f24923b) : this.f24923b;
    }

    public void a(@NonNull Context context, String str) {
        if (this.f24923b == null) {
            this.f24923b = new LangbridgeSettings();
        }
        if (TextUtils.isEmpty(str)) {
            this.f24923b = new LangbridgeSettings();
            if (!TextUtils.isEmpty(this.f24922a)) {
                this.f24922a = JsonUtils.toJson(this.f24923b);
            }
            LogUtil.d("WebViewCacheManager", "updateSettings CLEAR mSettings = " + this.f24923b.toString());
            return;
        }
        LangbridgeSettings a2 = a(str);
        StringBuilder sb = new StringBuilder();
        sb.append("updateSettings oldSettings = ");
        LangbridgeSettings langbridgeSettings = this.f24923b;
        String str2 = langbridgeSettings;
        if (langbridgeSettings != null) {
            str2 = langbridgeSettings.toString();
        }
        sb.append((Object) str2);
        sb.append("\nnewSettings = ");
        sb.append((Object) (a2 != null ? a2.toString() : a2));
        LogUtil.d("WebViewCacheManager", sb.toString());
        if (a2 != null && !a2.MW_USE_OLD && a2.MW_ON && !TextUtils.isEmpty(this.f24922a)) {
            LangbridgeSettings langbridgeSettings2 = this.f24923b;
            if (langbridgeSettings2.MW_USE_OLD || !langbridgeSettings2.MW_ON) {
                LogUtil.d("WebViewCacheManager", "updateSettings CANCEL mSettings = " + this.f24923b.toString());
                return;
            }
        }
        if (a2 != null) {
            this.f24923b = a2;
            LogUtil.d("LangbridgeSettings", "");
            this.f24922a = str;
            for (WeakReference<a> weakReference : this.f24925d) {
                if (weakReference != null && weakReference.get() != null) {
                    a aVar = weakReference.get();
                    b bVar = this.f24924c;
                    aVar.onSettingUpdated(bVar != null ? bVar.a(context, this.f24923b) : this.f24923b);
                }
            }
        }
        LogUtil.d("WebViewCacheManager", "updateSettings SUCCESS mSettings = " + this.f24923b.toString());
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.f24925d.add(new WeakReference<>(aVar));
        }
    }

    private LangbridgeSettings a(String str) {
        LangbridgeSettings langbridgeSettings;
        if (!TextUtils.isEmpty(str)) {
            try {
                langbridgeSettings = (LangbridgeSettings) JsonUtils.fromJson(str, LangbridgeSettings.class);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (langbridgeSettings == null && langbridgeSettings.isValid()) {
                return langbridgeSettings;
            }
            return null;
        }
        langbridgeSettings = null;
        if (langbridgeSettings == null) {
        }
        return null;
    }

    public String a(String str, String str2) {
        String a2 = com.baidu.wallet.lightapp.business.a.a(str);
        if (!TextUtils.isEmpty(a2)) {
            str2 = a2;
        }
        LogUtil.d("WebViewCacheManager", "LangbridgeSettingManager获取注入js文件：" + str2);
        return str2;
    }
}
