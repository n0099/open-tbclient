package com.baidu.tieba.videoplay;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ResponseGetNaniVideoMessage extends JsonHttpResponsedMessage {
    public boolean mHasMore;
    public List<VideoItemData> mVideoItemDatas;

    public ResponseGetNaniVideoMessage() {
        super(CmdConfigHttp.CMD_GET_NANI_VIDEO);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i2, jSONObject);
        if (getError() != 0) {
            return;
        }
        this.mHasMore = jSONObject.optInt("has_more") == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray("list");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        this.mVideoItemDatas = new ArrayList();
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.parseJson(optJSONArray.optString(i3));
            this.mVideoItemDatas.add(videoItemData);
        }
    }

    public List<VideoItemData> getVideoItemDatas() {
        return this.mVideoItemDatas;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }
}
