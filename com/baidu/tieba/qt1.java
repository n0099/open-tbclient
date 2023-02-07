package com.baidu.tieba;

import android.content.Context;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface qt1 {
    void a(Context context, JSONObject jSONObject);

    void b(Context context, JSONObject jSONObject);

    void c(GenericDraweeHierarchy genericDraweeHierarchy, boolean z);

    void d(Context context, String[] strArr, int i);

    ImageRequestBuilder e(ImageRequestBuilder imageRequestBuilder, Map<String, String> map);

    void f(Context context, JSONObject jSONObject);
}
