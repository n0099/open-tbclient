package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface lt2 {

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b();
    }

    void a(Context context, JSONObject jSONObject, a aVar);

    void b(Context context, String str, Uri uri);
}
