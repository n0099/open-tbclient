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
import com.bytedance.sdk.openadsdk.utils.aj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.d.l f6651a;

    /* renamed from: b  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.downloadnew.core.a f6652b;
    private final Context c;
    private final TTNativeAd d;
    private List<View> e = new ArrayList();
    private String f;
    private TTNativeAd.AdInteractionListener g;

    public o(Context context, TTNativeAd tTNativeAd, com.bytedance.sdk.openadsdk.core.d.l lVar, String str) {
        this.f = "embeded_ad";
        this.d = tTNativeAd;
        this.f6651a = lVar;
        this.c = context;
        this.f = str;
        if (this.f6651a.H() == 4) {
            this.f6652b = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.c, this.f6651a, this.f);
        }
    }

    public void a(@NonNull Activity activity) {
        if (this.f6652b != null) {
            this.f6652b.a(activity);
        }
    }

    public void a(View view, int i) {
        if (this.g != null) {
            this.g.onAdCreativeClick(view, this.d);
        }
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.a a() {
        return this.f6652b;
    }

    public void a(@NonNull final ViewGroup viewGroup, List<View> list, List<View> list2, @Nullable List<View> list3, @Nullable View view, final TTNativeAd.AdInteractionListener adInteractionListener) {
        this.g = adInteractionListener;
        if (this.f6652b != null) {
            this.f6652b.b();
        }
        com.bytedance.sdk.openadsdk.c.d.a(this.f6651a);
        EmptyView a2 = a(viewGroup);
        if (a2 == null) {
            a2 = new EmptyView(this.c, viewGroup);
            viewGroup.addView(a2);
        }
        a2.a();
        a2.setRefClickViews(list2);
        a2.setRefCreativeViews(list3);
        if (this.f6652b != null) {
            this.f6652b.a(a2);
        }
        this.e = list;
        com.bytedance.sdk.openadsdk.core.a.b bVar = new com.bytedance.sdk.openadsdk.core.a.b(this.c, this.f6651a, this.f, aj.a(this.f));
        bVar.a(viewGroup);
        bVar.b(view);
        bVar.a(this.f6652b);
        bVar.a(this.d);
        bVar.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.core.o.1
            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view2, int i) {
                if (adInteractionListener != null) {
                    adInteractionListener.onAdClicked(view2, o.this.d);
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.a.a aVar = new com.bytedance.sdk.openadsdk.core.a.a(this.c, this.f6651a, this.f, aj.a(this.f));
        aVar.a(viewGroup);
        aVar.b(view);
        aVar.a(this.f6652b);
        aVar.a(this.d);
        aVar.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.core.o.2
            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view2, int i) {
                if (adInteractionListener != null) {
                    adInteractionListener.onAdCreativeClick(view2, o.this.d);
                }
            }
        });
        a2.a(list2, bVar);
        a2.a(list3, aVar);
        a2.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.core.o.3
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                if (o.this.f6652b != null) {
                    if (z) {
                        o.this.f6652b.b();
                    } else {
                        o.this.f6652b.c();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
                if (o.this.f6652b != null) {
                    o.this.f6652b.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
                if (o.this.f6652b != null) {
                    o.this.f6652b.d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view2) {
                HashMap hashMap = new HashMap();
                if (o.this.e != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (View view3 : o.this.e) {
                        if (view3 != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("width", view3.getWidth());
                                jSONObject.put("height", view3.getHeight());
                                jSONObject.put("alpha", view3.getAlpha());
                            } catch (Throwable th) {
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
                    } catch (Throwable th2) {
                    }
                    hashMap.put("root_view", jSONObject2.toString());
                }
                com.bytedance.sdk.openadsdk.c.d.a(o.this.c, o.this.f6651a, o.this.f, hashMap);
                if (adInteractionListener != null) {
                    adInteractionListener.onAdShow(o.this.d);
                }
                if (o.this.f6651a.ab()) {
                    aj.a(o.this.f6651a, view2);
                }
            }
        });
        a2.setNeedCheckingShow(true);
    }

    private EmptyView a(ViewGroup viewGroup) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < viewGroup.getChildCount()) {
                View childAt = viewGroup.getChildAt(i2);
                if (!(childAt instanceof EmptyView)) {
                    i = i2 + 1;
                } else {
                    return (EmptyView) childAt;
                }
            } else {
                return null;
            }
        }
    }

    public void a(TTAppDownloadListener tTAppDownloadListener) {
        if (this.f6652b != null) {
            this.f6652b.a(tTAppDownloadListener);
        }
    }
}
