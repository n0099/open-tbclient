package com.baidu.tieba.write.model;

import com.baidu.android.util.io.BaseJsonData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes13.dex */
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
            this.addLinkResponseData.kOf = this.errno == 0;
            if (this.errno == 0) {
                this.errmsg = jSONObject.optString(BaseJsonData.TAG_ERRMSG);
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    this.addLinkResponseData.linkUrl = optJSONObject.optString("link_url");
                    this.addLinkResponseData.linkUrlCode = optJSONObject.optString("link_url_code");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("link_content");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.get(0);
                        this.addLinkResponseData.kOg = jSONObject2.optInt("link_type");
                        this.addLinkResponseData.linkTitle = jSONObject2.optString("link_title");
                        this.addLinkResponseData.cPr = jSONObject2.optString("link_abstract");
                        this.addLinkResponseData.kOh = jSONObject2.optString("link_head_pic");
                        this.addLinkResponseData.kOi = jSONObject2.optString("link_head_small_pic");
                        this.addLinkResponseData.kOj = jSONObject2.optString("link_head_big_pic");
                        this.addLinkResponseData.videoUrl = jSONObject2.optString("video_url");
                        this.addLinkResponseData.videoDuration = jSONObject2.optInt("video_duration", 0);
                        this.addLinkResponseData.videoFormat = jSONObject2.optString("video_format");
                        this.addLinkResponseData.kOk = jSONObject2.optInt("video_from", 0);
                        this.addLinkResponseData.videoHeight = jSONObject2.optInt("video_height", 0);
                        this.addLinkResponseData.videoWidth = jSONObject2.optInt("video_width", 0);
                        this.addLinkResponseData.videoSize = jSONObject2.optLong("video_size", 0L);
                        this.addLinkResponseData.kOo = jSONObject2.optInt("thumbnail_height", 0);
                        this.addLinkResponseData.kOn = jSONObject2.optInt("thumbnail_width", 0);
                        this.addLinkResponseData.kOm = jSONObject2.optInt("thumbnail_pid", 0);
                        this.addLinkResponseData.kOl = jSONObject2.optString("thumbnail_url");
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
