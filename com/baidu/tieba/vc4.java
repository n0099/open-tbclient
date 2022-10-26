package com.baidu.tieba;

import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface vc4 {

    /* loaded from: classes6.dex */
    public interface a {
        void b(String str, String str2, JSONObject jSONObject);

        void c(String str, int i);

        void onFail(Exception exc);

        void onStart();
    }

    void b(String str, Map map, Map map2, JSONObject jSONObject, a aVar);

    void z(String str, Map map, Map map2, a aVar);
}
