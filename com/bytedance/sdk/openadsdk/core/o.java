package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.utils.ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.d.l f28289a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f28290b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f28291c;

    /* renamed from: d  reason: collision with root package name */
    public final TTNativeAd f28292d;

    /* renamed from: e  reason: collision with root package name */
    public List<View> f28293e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public String f28294f;

    /* renamed from: g  reason: collision with root package name */
    public TTNativeAd.AdInteractionListener f28295g;

    public o(Context context, TTNativeAd tTNativeAd, com.bytedance.sdk.openadsdk.core.d.l lVar, String str) {
        this.f28294f = "embeded_ad";
        this.f28292d = tTNativeAd;
        this.f28289a = lVar;
        this.f28291c = context;
        this.f28294f = str;
        if (lVar.Z() == 4) {
            this.f28290b = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f28291c, this.f28289a, this.f28294f);
        }
    }

    public void a(@NonNull Activity activity) {
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.f28290b;
        if (aVar != null) {
            aVar.a(activity);
        }
    }

    public void a(View view, int i2) {
        TTNativeAd.AdInteractionListener adInteractionListener = this.f28295g;
        if (adInteractionListener != null) {
            adInteractionListener.onAdCreativeClick(view, this.f28292d);
        }
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.a a() {
        return this.f28290b;
    }

    public void a(@NonNull final ViewGroup viewGroup, List<View> list, List<View> list2, @Nullable List<View> list3, @Nullable View view, final TTNativeAd.AdInteractionListener adInteractionListener) {
        this.f28295g = adInteractionListener;
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.f28290b;
        if (aVar != null) {
            aVar.b();
        }
        com.bytedance.sdk.openadsdk.c.d.a(this.f28289a);
        EmptyView a2 = a(viewGroup);
        if (a2 == null) {
            a2 = new EmptyView(this.f28291c, viewGroup);
            viewGroup.addView(a2);
        }
        a2.a();
        a2.setRefClickViews(list2);
        a2.setRefCreativeViews(list3);
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar2 = this.f28290b;
        if (aVar2 != null) {
            aVar2.a(a2);
        }
        this.f28293e = list;
        Context context = this.f28291c;
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.f28289a;
        String str = this.f28294f;
        com.bytedance.sdk.openadsdk.core.a.b bVar = new com.bytedance.sdk.openadsdk.core.a.b(context, lVar, str, ak.a(str));
        bVar.a(viewGroup);
        bVar.b(view);
        bVar.a(this.f28290b);
        bVar.a(this.f28292d);
        bVar.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.core.o.1
            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view2, int i2) {
                TTNativeAd.AdInteractionListener adInteractionListener2 = adInteractionListener;
                if (adInteractionListener2 != null) {
                    adInteractionListener2.onAdClicked(view2, o.this.f28292d);
                }
            }
        });
        Context context2 = this.f28291c;
        com.bytedance.sdk.openadsdk.core.d.l lVar2 = this.f28289a;
        String str2 = this.f28294f;
        com.bytedance.sdk.openadsdk.core.a.a aVar3 = new com.bytedance.sdk.openadsdk.core.a.a(context2, lVar2, str2, ak.a(str2));
        aVar3.a(viewGroup);
        aVar3.b(view);
        aVar3.a(this.f28290b);
        aVar3.a(this.f28292d);
        aVar3.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.core.o.2
            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view2, int i2) {
                TTNativeAd.AdInteractionListener adInteractionListener2 = adInteractionListener;
                if (adInteractionListener2 != null) {
                    adInteractionListener2.onAdCreativeClick(view2, o.this.f28292d);
                }
            }
        });
        a2.a(list2, bVar);
        a2.a(list3, aVar3);
        a2.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.core.o.3
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                if (o.this.f28290b != null) {
                    if (z) {
                        o.this.f28290b.b();
                    } else {
                        o.this.f28290b.c();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
                if (o.this.f28290b != null) {
                    o.this.f28290b.d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
                if (o.this.f28290b != null) {
                    o.this.f28290b.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view2) {
                HashMap hashMap = new HashMap();
                if (o.this.f28293e != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (View view3 : o.this.f28293e) {
                        if (view3 != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("width", view3.getWidth());
                                jSONObject.put("height", view3.getHeight());
                                jSONObject.put("alpha", view3.getAlpha());
                            } catch (Throwable unused) {
                            }
                            jSONArray.put(jSONObject);
                        }
                    }
                    hashMap.put("image_view", jSONArray.toString());
                }
                if (viewGroup != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("width", viewGroup.getWidth());
                        jSONObject2.put("height", viewGroup.getHeight());
                        jSONObject2.put("alpha", viewGroup.getAlpha());
                    } catch (Throwable unused2) {
                    }
                    hashMap.put("root_view", jSONObject2.toString());
                }
                com.bytedance.sdk.openadsdk.c.d.a(o.this.f28291c, o.this.f28289a, o.this.f28294f, hashMap);
                com.bytedance.sdk.openadsdk.utils.u.e("AdEvent", "pangolin ad show " + ak.a(o.this.f28289a, view2));
                TTNativeAd.AdInteractionListener adInteractionListener2 = adInteractionListener;
                if (adInteractionListener2 != null) {
                    adInteractionListener2.onAdShow(o.this.f28292d);
                }
            }
        });
        a2.setNeedCheckingShow(true);
    }

    private EmptyView a(ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    public void a(TTAppDownloadListener tTAppDownloadListener) {
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.f28290b;
        if (aVar != null) {
            aVar.a(tTAppDownloadListener);
        }
    }
}
