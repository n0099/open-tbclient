package com.baidu.tieba;

import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class t66 extends ShareItem {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public t66() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.cmdContent;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.cmdKey;
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mediaType;
        }
        return (String) invokeV.objValue;
    }

    public JSONArray d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.cmdPannel;
        }
        return (JSONArray) invokeV.objValue;
    }

    public void e(JSONObject jSONObject) throws JSONException {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
            int i = 1;
            this.isAiApps = true;
            this.title = jSONObject.getString("title");
            this.linkUrl = jSONObject.getString(GameAssistConstKt.KEY_LINKURL);
            this.content = jSONObject.optString("content");
            this.imageUrl = jSONObject.optString("imageUrl");
            this.mediaType = jSONObject.optString("mediaType");
            if (StringUtils.isNull(this.imageUrl)) {
                str = jSONObject.optString(GameAssistConstKt.KEY_ICONURL);
            } else {
                str = this.imageUrl;
            }
            this.imageUrl = str;
            this.imageUri = Uri.parse(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
            if (optJSONObject != null) {
                this.aiAppId = optJSONObject.optString("source2");
                this.aiAppSource = optJSONObject.optString("source3");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("command");
            if (optJSONObject2 != null) {
                this.aiAppType = 2;
                this.cmdPannel = optJSONObject2.optJSONArray("cmd_pannel");
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("info");
                this.commandInfo = optJSONObject3;
                if (optJSONObject3 != null) {
                    this.cmdKey = optJSONObject3.optString("key");
                    this.cmdContent = this.commandInfo.optString("content");
                    return;
                }
                return;
            }
            if (!"url".equals(jSONObject.optString("type"))) {
                i = 3;
            }
            this.aiAppType = i;
        }
    }
}
