package com.baidu.tieba.videoplay;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ResponseGetNaniVideoMessage extends JsonHttpResponsedMessage {
    private boolean mHasMore;
    private List<VideoItemData> mVideoItemDatas;

    public ResponseGetNaniVideoMessage() {
        super(CmdConfigHttp.CMD_GET_NANI_VIDEO);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0) {
            this.mHasMore = jSONObject.optInt("has_more") == 1;
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.mVideoItemDatas = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    VideoItemData videoItemData = new VideoItemData();
                    videoItemData.parseJson(optJSONArray.optString(i2));
                    this.mVideoItemDatas.add(videoItemData);
                }
            }
        }
    }

    public List<VideoItemData> getVideoItemDatas() {
        return this.mVideoItemDatas;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }
}
