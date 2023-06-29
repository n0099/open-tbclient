package com.baidu.tieba;

import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.game.ad.entity.AdResponseInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface t04 {
    void a(String str, JSONObject jSONObject, ResponseCallback<AdResponseInfo> responseCallback);

    void b(String str, JSONObject jSONObject, ResponseCallback<l04> responseCallback);

    void c(String str, ResponseCallback<uz3> responseCallback);

    void d(String str);

    void e(String str);

    void f(String str, ResponseCallback<AdResponseInfo> responseCallback);
}
