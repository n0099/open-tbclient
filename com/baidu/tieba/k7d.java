package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.download.center.clearcache.controller.ClearCacheUbcController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.RecGuide;
/* loaded from: classes6.dex */
public class k7d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RecGuide recGuide) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, recGuide)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, ClearCacheUbcController.DOCUMENT, recGuide.document);
            ltc.a(jSONObject, "url", recGuide.url);
            ltc.a(jSONObject, pic.f, recGuide.pic);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
