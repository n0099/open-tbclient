package com.baidu.ubc;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tieba.dga;
import com.baidu.tieba.hga;
import com.baidu.tieba.xfa;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public interface UBCManager {
    public static final String CONTENT_KEY_DURATION = "duration";
    public static final String CONTENT_KEY_EXT = "ext";
    public static final String CONTENT_KEY_FROM = "from";
    public static final String CONTENT_KEY_PAGE = "page";
    public static final String CONTENT_KEY_SOURCE = "source";
    public static final String CONTENT_KEY_TYPE = "type";
    public static final String CONTENT_KEY_VALUE = "value";
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference("ubc", UBC.TAG);

    Flow beginFlow(String str);

    Flow beginFlow(String str, int i);

    Flow beginFlow(String str, String str2);

    Flow beginFlow(String str, String str2, int i);

    Flow beginFlow(String str, Map<String, String> map);

    Flow beginFlow(String str, Map<String, String> map, int i);

    Flow beginFlow(String str, JSONObject jSONObject);

    Flow beginFlow(String str, JSONObject jSONObject, int i);

    void flowAddEvent(Flow flow, String str);

    void flowAddEvent(Flow flow, String str, String str2);

    void flowAddEventWithDate(Flow flow, String str, String str2, long j);

    void flowCancel(Flow flow);

    void flowEnd(Flow flow);

    void flowEndSlot(Flow flow, String str);

    void flowSetValue(Flow flow, String str);

    void flowSetValue(Flow flow, Map<String, String> map);

    void flowSetValueWithDuration(Flow flow, String str);

    void flowStartSlot(Flow flow, String str, JSONObject jSONObject);

    void flush();

    String getUploadType(String str);

    boolean isUBCDebug();

    boolean isUBCSample();

    void onEvent(String str);

    void onEvent(String str, int i);

    void onEvent(String str, String str2);

    void onEvent(String str, String str2, int i);

    void onEvent(String str, Map<String, String> map);

    void onEvent(String str, Map<String, String> map, int i);

    void onEvent(String str, JSONObject jSONObject);

    void onEvent(String str, JSONObject jSONObject, int i);

    void registerConfig(hga hgaVar);

    void registerConfig(hga hgaVar, boolean z, dga dgaVar);

    void setDefaultConfig(xfa xfaVar);

    void setUBCDebug(boolean z);

    void setUBCSample(boolean z);

    void upload();

    void uploadFailedData();

    void uploadLocalDatas();
}
