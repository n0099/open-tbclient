package com.baidu.tieba;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceReference;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface q71 {
    public static final ServiceReference a = new ServiceReference("nad.core", "crius");

    Object a(JSONObject jSONObject);

    e81 b(Context context);
}
