package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface zb1 {
    public static final ServiceReference a = new ServiceReference("nad.core", "crius");

    Object a(JSONObject jSONObject);

    nc1<View> b(@NonNull Context context);
}
