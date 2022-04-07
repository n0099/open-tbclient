package com.baidu.tieba.videoplay.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.data.VideoAttentionPersonListData;
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
public class VideoAttentionHttpResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long mFeedId;
    public int mHasMore;
    public String mShowWord;
    public ArrayList<VideoAttentionPersonListData> mVideoAttentionPersonListData;
    public ArrayList<VideoItemData> mVideoItemDatasVideo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoAttentionHttpResponseMessage() {
        super(CmdConfigHttp.CMD_HTTP_VIDEO_ATTENTION_FEED);
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
        this.mVideoItemDatasVideo = new ArrayList<>();
        this.mVideoAttentionPersonListData = new ArrayList<>();
        this.mShowWord = "";
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (jSONObject == null) {
                return;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("concern_list");
            JSONArray jSONArray = jSONObject.getJSONArray("forum_friends");
            JSONArray jSONArray2 = jSONObject2.getJSONArray("thread_list");
            this.mFeedId = jSONObject2.getLong("feed_id");
            this.mShowWord = jSONObject2.getString("show_word");
            this.mHasMore = jSONObject2.getInt("has_more");
            if (jSONArray2 != null && jSONArray2.length() > 0) {
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    VideoItemData videoItemData = new VideoItemData();
                    videoItemData.parseFeedJson(jSONArray2.getString(i2), "");
                    this.mVideoItemDatasVideo.add(videoItemData);
                }
            }
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                VideoAttentionPersonListData videoAttentionPersonListData = new VideoAttentionPersonListData();
                videoAttentionPersonListData.parseJson(jSONArray.getJSONObject(i3).getJSONArray("thread_list"), jSONArray.getJSONObject(i3).getJSONObject("user_info"));
                this.mVideoAttentionPersonListData.add(videoAttentionPersonListData);
            }
        }
    }

    public long getFeedId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mFeedId : invokeV.longValue;
    }

    public int getHasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mHasMore : invokeV.intValue;
    }

    public String getShowWord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mShowWord : (String) invokeV.objValue;
    }

    public List<VideoAttentionPersonListData> getVideoAttentionPersonListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mVideoAttentionPersonListData : (List) invokeV.objValue;
    }

    public List<VideoItemData> getVideoItemDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mVideoItemDatasVideo : (List) invokeV.objValue;
    }
}
