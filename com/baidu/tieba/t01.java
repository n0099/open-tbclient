package com.baidu.tieba;

import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class t01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(a11 mpdModel, JSONArray clarityUrlList) {
        ArrayList<w01> a;
        int i;
        boolean z;
        w01 w01Var;
        ArrayList<Object> d;
        ArrayList<w01> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, mpdModel, clarityUrlList) == null) {
            Intrinsics.checkNotNullParameter(mpdModel, "mpdModel");
            Intrinsics.checkNotNullParameter(clarityUrlList, "clarityUrlList");
            y01 a3 = mpdModel.a();
            if (a3 != null && (a = a3.a()) != null) {
                y01 a4 = mpdModel.a();
                if (a4 != null && (a2 = a4.a()) != null) {
                    i = a2.size();
                } else {
                    i = 0;
                }
                if (i > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    a = null;
                }
                if (a != null && (w01Var = a.get(0)) != null && (d = w01Var.d()) != null) {
                    int length = clarityUrlList.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        Object obj = clarityUrlList.get(i2);
                        if (!(obj instanceof JSONObject)) {
                            obj = null;
                        }
                        JSONObject jSONObject = (JSONObject) obj;
                        if (jSONObject != null) {
                            Object obj2 = d.get(0);
                            if (!(obj2 instanceof z01)) {
                                obj2 = null;
                            }
                            z01 z01Var = (z01) obj2;
                            if (z01Var != null) {
                                jSONObject.put("interact_url", z01Var.a());
                            }
                        }
                    }
                }
            }
        }
    }

    public static final void b(a11 mpdModel, JSONObject mpdJson) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, mpdModel, mpdJson) == null) {
            Intrinsics.checkNotNullParameter(mpdModel, "mpdModel");
            Intrinsics.checkNotNullParameter(mpdJson, "mpdJson");
            JSONObject optJSONObject = mpdJson.optJSONObject(BdVideoSeries.RESOURCE_TYPE_INTERACT);
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("adaptation_set")) != null) {
                ArrayList arrayList = new ArrayList();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    if (optJSONObject2 != null && (optJSONArray2 = optJSONObject2.optJSONArray("representation_list")) != null) {
                        ArrayList arrayList2 = new ArrayList();
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                            if (optJSONObject3 != null) {
                                arrayList2.add(new z01(optJSONObject3.optString("url")));
                            }
                        }
                        arrayList.add(new w01(arrayList2, optJSONObject2.optString("type"), null, null, null, null, 60, null));
                    }
                }
                mpdModel.c(new y01(arrayList));
            }
        }
    }
}
