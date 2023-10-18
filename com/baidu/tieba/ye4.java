package com.baidu.tieba;

import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public interface ye4 {

    /* loaded from: classes9.dex */
    public interface a {
        void b(String str, String str2, JSONObject jSONObject);

        void onFail(Exception exc);

        void onStart();

        void onSuccess(String str, int i);
    }

    void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, a aVar);

    void z(String str, Map<String, String> map, Map<String, String> map2, a aVar);
}
