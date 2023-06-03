package com.baidu.tieba.video.editvideo;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ResponseGetVideoActivityMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<VideoTitleData> mAllVideoTitleList;
    public VideoTitleData mVideoTitleData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseGetVideoActivityMessage() {
        super(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public List<VideoTitleData> getAllVideoTitleList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mAllVideoTitleList;
        }
        return (List) invokeV.objValue;
    }

    public VideoTitleData getVideoTitleData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mVideoTitleData;
        }
        return (VideoTitleData) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("current_act_info");
                if (optJSONObject2 != null) {
                    this.mVideoTitleData = (VideoTitleData) OrmObject.objectWithJson(optJSONObject2, VideoTitleData.class);
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray("act_info_list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    if (this.mAllVideoTitleList == null) {
                        this.mAllVideoTitleList = new ArrayList();
                    }
                    this.mAllVideoTitleList.clear();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        if (optJSONArray.getJSONObject(i2) != null) {
                            this.mAllVideoTitleList.add((VideoTitleData) OrmObject.objectWithJson(optJSONArray.getJSONObject(i2), VideoTitleData.class));
                        }
                    }
                }
            }
        }
    }
}
