package com.baidu.tieba.videoplay.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class VideoChannelHttpResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<VideoItemData> mVideoItemDatas;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoChannelHttpResponseMessage() {
        super(CmdConfigHttp.CMD_HTTP_VIDEO_CHANNEL_FEED);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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
        this.mVideoItemDatas = new ArrayList<>();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) || getError() != 0 || jSONObject == null || (optJSONArray = jSONObject.optJSONArray("thread_list")) == null || optJSONArray.length() <= 0) {
            return;
        }
        this.mVideoItemDatas = new ArrayList<>();
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.parseFeedJson(optJSONArray.optString(i3), "");
            this.mVideoItemDatas.add(videoItemData);
        }
    }

    public List<VideoItemData> getVideoItemDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mVideoItemDatas : (List) invokeV.objValue;
    }
}
