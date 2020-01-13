package com.baidu.ubc;

import com.baidu.pyramid.runtime.service.d;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public interface a {
    public static final d SERVICE_REFERENCE = new d("ubc", "UBC");

    Flow Hd(String str);

    void a(Flow flow);

    void a(Flow flow, String str);

    void a(Flow flow, String str, String str2);

    void a(Flow flow, String str, String str2, long j);

    void a(Flow flow, String str, JSONObject jSONObject);

    void a(Flow flow, Map<String, String> map);

    void b(Flow flow);

    void b(Flow flow, String str);

    void c(Flow flow, String str);

    void k(String str, JSONObject jSONObject);

    void onEvent(String str);

    void onEvent(String str, String str2);

    Flow p(String str, JSONObject jSONObject);
}
