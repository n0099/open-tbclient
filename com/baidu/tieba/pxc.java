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
/* loaded from: classes7.dex */
public class pxc extends ltc {
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
                ltc.a(jSONObject, "icon", nxc.b(feedHeadIcon));
            }
            ltc.a(jSONObject, "type", feedHeadSymbol.type);
            FeedHeadText feedHeadText = feedHeadSymbol.text;
            if (feedHeadText != null) {
                ltc.a(jSONObject, "text", qxc.b(feedHeadText));
            }
            ltc.a(jSONObject, "schema", feedHeadSymbol.schema);
            if (feedHeadSymbol.log_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedKV feedKV : feedHeadSymbol.log_info) {
                    jSONArray.put(sxc.b(feedKV));
                }
                ltc.a(jSONObject, "log_info", jSONArray);
            }
            FeedContentCustom feedContentCustom = feedHeadSymbol.custom;
            if (feedContentCustom != null) {
                ltc.a(jSONObject, ExceptionHandlerImpl.KEY_CUSTOM, bxc.b(feedContentCustom));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
