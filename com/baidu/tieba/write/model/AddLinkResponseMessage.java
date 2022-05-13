package com.baidu.tieba.write.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.uy8;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AddLinkResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR = -1;
    public static final int SUCCESS = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public uy8 addLinkResponseData;
    public String errmsg;
    public int errno;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddLinkResponseMessage(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.errno = -1;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.addLinkResponseData = new uy8();
        int optInt = jSONObject.optInt("errno", -1);
        this.errno = optInt;
        this.addLinkResponseData.a = optInt == 0;
        if (this.errno == 0) {
            this.errmsg = jSONObject.optString("errmsg");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                return;
            }
            this.addLinkResponseData.b = optJSONObject.optString("link_url");
            this.addLinkResponseData.c = optJSONObject.optString("link_url_code");
            JSONArray optJSONArray = optJSONObject.optJSONArray("link_content");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return;
            }
            JSONObject jSONObject2 = (JSONObject) optJSONArray.get(0);
            this.addLinkResponseData.d = jSONObject2.optInt("link_type");
            this.addLinkResponseData.e = jSONObject2.optString("link_title");
            this.addLinkResponseData.f = jSONObject2.optString("link_abstract");
            this.addLinkResponseData.g = jSONObject2.optString("link_head_pic");
            this.addLinkResponseData.h = jSONObject2.optString("link_head_small_pic");
            this.addLinkResponseData.i = jSONObject2.optString("link_head_big_pic");
            this.addLinkResponseData.j = jSONObject2.optString("video_url");
            this.addLinkResponseData.l = jSONObject2.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            this.addLinkResponseData.m = jSONObject2.optString("video_format");
            this.addLinkResponseData.n = jSONObject2.optInt("video_from", 0);
            this.addLinkResponseData.p = jSONObject2.optInt("video_height", 0);
            this.addLinkResponseData.o = jSONObject2.optInt("video_width", 0);
            this.addLinkResponseData.k = jSONObject2.optLong("video_size", 0L);
            this.addLinkResponseData.t = jSONObject2.optInt("thumbnail_height", 0);
            this.addLinkResponseData.s = jSONObject2.optInt("thumbnail_width", 0);
            this.addLinkResponseData.r = jSONObject2.optInt("thumbnail_pid", 0);
            this.addLinkResponseData.q = jSONObject2.optString("thumbnail_url");
        }
    }

    public uy8 getAddLinkResponseData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.addLinkResponseData : (uy8) invokeV.objValue;
    }

    public String getErrmsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.errmsg : (String) invokeV.objValue;
    }

    public int getErrno() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.errno : invokeV.intValue;
    }
}
