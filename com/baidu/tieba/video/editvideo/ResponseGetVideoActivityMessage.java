package com.baidu.tieba.video.editvideo;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.video.VideoTitleData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ResponseGetVideoActivityMessage extends JsonHttpResponsedMessage {
    private List<VideoTitleData> mAllVideoTitleList;
    private VideoTitleData mVideoTitleData;

    public ResponseGetVideoActivityMessage() {
        super(1003376);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
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
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < optJSONArray.length()) {
                        if (optJSONArray.getJSONObject(i3) != null) {
                            this.mAllVideoTitleList.add((VideoTitleData) OrmObject.objectWithJson(optJSONArray.getJSONObject(i3), VideoTitleData.class));
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public VideoTitleData getVideoTitleData() {
        return this.mVideoTitleData;
    }

    public List<VideoTitleData> getAllVideoTitleList() {
        return this.mAllVideoTitleList;
    }
}
