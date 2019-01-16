package com.baidu.tieba.write.model;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AddLinkResponseMessage extends JsonHttpResponsedMessage {
    public static final int ERROR = -1;
    public static final int SUCCESS = 0;
    private com.baidu.tieba.write.a.a addLinkResponseData;
    private String errmsg;
    private int errno;

    public AddLinkResponseMessage(int i) {
        super(i);
        this.errno = -1;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.addLinkResponseData = new com.baidu.tieba.write.a.a();
            this.errno = jSONObject.optInt("errno", -1);
            this.addLinkResponseData.hXL = this.errno == 0;
            if (this.errno == 0) {
                this.errmsg = jSONObject.optString("errmsg");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    this.addLinkResponseData.linkUrl = optJSONObject.optString("link_url");
                    this.addLinkResponseData.linkUrlCode = optJSONObject.optString("link_url_code");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("link_content");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.get(0);
                        this.addLinkResponseData.hXM = jSONObject2.optInt("link_type");
                        this.addLinkResponseData.asr = jSONObject2.optString("link_title");
                        this.addLinkResponseData.ass = jSONObject2.optString("link_abstract");
                        this.addLinkResponseData.hXN = jSONObject2.optString("link_head_pic");
                        this.addLinkResponseData.hXO = jSONObject2.optString("link_head_small_pic");
                        this.addLinkResponseData.hXP = jSONObject2.optString("link_head_big_pic");
                        this.addLinkResponseData.videoUrl = jSONObject2.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                        this.addLinkResponseData.videoDuration = jSONObject2.optInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
                        this.addLinkResponseData.videoFormat = jSONObject2.optString("video_format");
                        this.addLinkResponseData.hXQ = jSONObject2.optInt("video_from", 0);
                        this.addLinkResponseData.videoHeight = jSONObject2.optInt("video_height", 0);
                        this.addLinkResponseData.videoWidth = jSONObject2.optInt("video_width", 0);
                        this.addLinkResponseData.videoSize = jSONObject2.optLong("video_size", 0L);
                        this.addLinkResponseData.hXU = jSONObject2.optInt("thumbnail_height", 0);
                        this.addLinkResponseData.hXT = jSONObject2.optInt("thumbnail_width", 0);
                        this.addLinkResponseData.hXS = jSONObject2.optInt("thumbnail_pid", 0);
                        this.addLinkResponseData.hXR = jSONObject2.optString("thumbnail_url");
                    }
                }
            }
        }
    }

    public int getErrno() {
        return this.errno;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public com.baidu.tieba.write.a.a getAddLinkResponseData() {
        return this.addLinkResponseData;
    }
}
