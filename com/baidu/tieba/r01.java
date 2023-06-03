package com.baidu.tieba;

import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class r01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(y01 mpdModel, JSONArray clarityUrlList) {
        ArrayList<u01> a;
        int i;
        boolean z;
        u01 u01Var;
        ArrayList<Object> d;
        ArrayList<u01> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, mpdModel, clarityUrlList) == null) {
            Intrinsics.checkNotNullParameter(mpdModel, "mpdModel");
            Intrinsics.checkNotNullParameter(clarityUrlList, "clarityUrlList");
            w01 a3 = mpdModel.a();
            if (a3 != null && (a = a3.a()) != null) {
                w01 a4 = mpdModel.a();
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
                if (a != null && (u01Var = a.get(0)) != null && (d = u01Var.d()) != null) {
                    int length = clarityUrlList.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        Object obj = clarityUrlList.get(i2);
                        if (!(obj instanceof JSONObject)) {
                            obj = null;
                        }
                        JSONObject jSONObject = (JSONObject) obj;
                        if (jSONObject != null) {
                            Object obj2 = d.get(0);
                            if (!(obj2 instanceof x01)) {
                                obj2 = null;
                            }
                            x01 x01Var = (x01) obj2;
                            if (x01Var != null) {
                                jSONObject.put("interact_url", x01Var.a());
                            }
                        }
                    }
                }
            }
        }
    }

    public static final void b(y01 mpdModel, JSONObject mpdJson) {
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
                                arrayList2.add(new x01(optJSONObject3.optString("url")));
                            }
                        }
                        arrayList.add(new u01(arrayList2, optJSONObject2.optString("type"), null, null, null, null, 60, null));
                    }
                }
                mpdModel.c(new w01(arrayList));
            }
        }
    }
}
