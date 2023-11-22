package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerImpl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FeedContentCustom;
import tbclient.FeedHeadIcon;
import tbclient.FeedHeadSymbol;
import tbclient.FeedHeadText;
import tbclient.FeedKV;
/* loaded from: classes8.dex */
public class rsc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedHeadSymbol feedHeadSymbol) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedHeadSymbol)) == null) {
            JSONObject jSONObject = new JSONObject();
            FeedHeadIcon feedHeadIcon = feedHeadSymbol.icon;
            if (feedHeadIcon != null) {
                qoc.a(jSONObject, "icon", psc.b(feedHeadIcon));
            }
            qoc.a(jSONObject, "type", feedHeadSymbol.type);
            FeedHeadText feedHeadText = feedHeadSymbol.text;
            if (feedHeadText != null) {
                qoc.a(jSONObject, "text", ssc.b(feedHeadText));
            }
            qoc.a(jSONObject, "schema", feedHeadSymbol.schema);
            if (feedHeadSymbol.log_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedKV feedKV : feedHeadSymbol.log_info) {
                    jSONArray.put(usc.b(feedKV));
                }
                qoc.a(jSONObject, "log_info", jSONArray);
            }
            FeedContentCustom feedContentCustom = feedHeadSymbol.custom;
            if (feedContentCustom != null) {
                qoc.a(jSONObject, ExceptionHandlerImpl.KEY_CUSTOM, dsc.b(feedContentCustom));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
