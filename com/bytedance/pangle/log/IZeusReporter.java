package com.bytedance.pangle.log;

import androidx.annotation.Keep;
import org.json.JSONObject;
@Keep
/* loaded from: classes8.dex */
public interface IZeusReporter {
    void report(String str, JSONObject jSONObject);
}
