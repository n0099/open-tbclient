package com.baidu.ubc;

import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public interface aa {
    public static final com.baidu.pyramid.runtime.service.d SERVICE_REFERENCE = new com.baidu.pyramid.runtime.service.d("ubc", UBC.TAG);

    void a(Flow flow, String str, String str2, long j);

    void a(Flow flow, String str, JSONObject jSONObject);

    void a(Flow flow, Map<String, String> map);

    void b(v vVar, boolean z, s sVar);

    Flow beginFlow(String str);

    Flow beginFlow(String str, JSONObject jSONObject);

    void flowAddEvent(Flow flow, String str, String str2);

    void flowCancel(Flow flow);

    void flowEnd(Flow flow);

    void flowEndSlot(Flow flow, String str);

    void flowSetValue(Flow flow, String str);

    void flowSetValueWithDuration(Flow flow, String str);

    void onEvent(String str);

    void onEvent(String str, String str2);

    void onEvent(String str, JSONObject jSONObject);
}
