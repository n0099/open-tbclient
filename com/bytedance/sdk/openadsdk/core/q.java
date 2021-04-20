package com.bytedance.sdk.openadsdk.core;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.r;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface q<T> {

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, long j, long j2);
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i, String str);

        void a(com.bytedance.sdk.openadsdk.core.d.a aVar);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(int i, String str);

        void a(r.c cVar);
    }

    com.bytedance.sdk.openadsdk.c.h a(List<T> list);

    com.bytedance.sdk.openadsdk.c.h a(JSONObject jSONObject);

    com.bytedance.sdk.openadsdk.core.d.s a();

    String a(AdSlot adSlot);

    String a(AdSlot adSlot, boolean z, int i);

    void a(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.d.m mVar, int i, b bVar);

    void a(com.bytedance.sdk.openadsdk.core.d.l lVar, List<FilterWord> list);

    void a(String str, String str2, a aVar);

    void a(JSONObject jSONObject, c cVar);

    boolean a(JSONObject jSONObject, int i);
}
