package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface zr2 {

    /* loaded from: classes7.dex */
    public interface a {
        void a();

        void b();
    }

    void a(Context context, JSONObject jSONObject, a aVar);

    void b(Context context, String str, Uri uri);
}
