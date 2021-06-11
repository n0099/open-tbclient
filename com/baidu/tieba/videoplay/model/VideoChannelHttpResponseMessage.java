package com.baidu.tieba.videoplay.model;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Feed.FeedResIdl;
/* loaded from: classes5.dex */
public class VideoChannelHttpResponseMessage extends JsonHttpResponsedMessage {
    public FeedResIdl idl;
    public ArrayList<VideoItemData> mVideoItemDatas;

    public VideoChannelHttpResponseMessage() {
        super(CmdConfigHttp.CMD_HTTP_VIDEO_CHANNEL_FEED);
        this.mVideoItemDatas = new ArrayList<>();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        if (getError() != 0 || jSONObject == null) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("thread_personalized");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        this.mVideoItemDatas = new ArrayList<>();
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.parseFeedJson(optJSONArray.optString(i3), optJSONArray2.optString(i3));
            this.mVideoItemDatas.add(videoItemData);
        }
    }

    public List<VideoItemData> getVideoItemDatas() {
        return this.mVideoItemDatas;
    }
}
