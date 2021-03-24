package com.baidu.tieba.video.editvideo;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.video.VideoTitleData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ResponseGetVideoActivityMessage extends JsonHttpResponsedMessage {
    public List<VideoTitleData> mAllVideoTitleList;
    public VideoTitleData mVideoTitleData;

    public ResponseGetVideoActivityMessage() {
        super(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
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
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
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

    public List<VideoTitleData> getAllVideoTitleList() {
        return this.mAllVideoTitleList;
    }

    public VideoTitleData getVideoTitleData() {
        return this.mVideoTitleData;
    }
}
