package com.baidu.tieba.write.model;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import d.a.n0.w3.l.a;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AddLinkResponseMessage extends JsonHttpResponsedMessage {
    public static final int ERROR = -1;
    public static final int SUCCESS = 0;
    public a addLinkResponseData;
    public String errmsg;
    public int errno;

    public AddLinkResponseMessage(int i2) {
        super(i2);
        this.errno = -1;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        this.addLinkResponseData = new a();
        int optInt = jSONObject.optInt("errno", -1);
        this.errno = optInt;
        this.addLinkResponseData.f62866a = optInt == 0;
        if (this.errno == 0) {
            this.errmsg = jSONObject.optString("errmsg");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                return;
            }
            this.addLinkResponseData.f62867b = optJSONObject.optString("link_url");
            this.addLinkResponseData.f62868c = optJSONObject.optString("link_url_code");
            JSONArray optJSONArray = optJSONObject.optJSONArray("link_content");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return;
            }
            JSONObject jSONObject2 = (JSONObject) optJSONArray.get(0);
            this.addLinkResponseData.f62869d = jSONObject2.optInt("link_type");
            this.addLinkResponseData.f62870e = jSONObject2.optString("link_title");
            this.addLinkResponseData.f62871f = jSONObject2.optString("link_abstract");
            this.addLinkResponseData.f62872g = jSONObject2.optString("link_head_pic");
            this.addLinkResponseData.f62873h = jSONObject2.optString("link_head_small_pic");
            this.addLinkResponseData.f62874i = jSONObject2.optString("link_head_big_pic");
            this.addLinkResponseData.j = jSONObject2.optString("video_url");
            this.addLinkResponseData.l = jSONObject2.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
            this.addLinkResponseData.m = jSONObject2.optString("video_format");
            this.addLinkResponseData.n = jSONObject2.optInt("video_from", 0);
            this.addLinkResponseData.p = jSONObject2.optInt("video_height", 0);
            this.addLinkResponseData.o = jSONObject2.optInt("video_width", 0);
            this.addLinkResponseData.k = jSONObject2.optLong("video_size", 0L);
            this.addLinkResponseData.t = jSONObject2.optInt("thumbnail_height", 0);
            this.addLinkResponseData.s = jSONObject2.optInt("thumbnail_width", 0);
            this.addLinkResponseData.r = jSONObject2.optInt("thumbnail_pid", 0);
            this.addLinkResponseData.q = jSONObject2.optString("thumbnail_url");
        }
    }

    public a getAddLinkResponseData() {
        return this.addLinkResponseData;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public int getErrno() {
        return this.errno;
    }
}
