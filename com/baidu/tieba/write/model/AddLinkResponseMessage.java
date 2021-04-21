package com.baidu.tieba.write.model;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import d.b.j0.v3.m.a;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AddLinkResponseMessage extends JsonHttpResponsedMessage {
    public static final int ERROR = -1;
    public static final int SUCCESS = 0;
    public a addLinkResponseData;
    public String errmsg;
    public int errno;

    public AddLinkResponseMessage(int i) {
        super(i);
        this.errno = -1;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        this.addLinkResponseData = new a();
        int optInt = jSONObject.optInt("errno", -1);
        this.errno = optInt;
        this.addLinkResponseData.f63799a = optInt == 0;
        if (this.errno == 0) {
            this.errmsg = jSONObject.optString("errmsg");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                return;
            }
            this.addLinkResponseData.f63800b = optJSONObject.optString("link_url");
            this.addLinkResponseData.f63801c = optJSONObject.optString("link_url_code");
            JSONArray optJSONArray = optJSONObject.optJSONArray("link_content");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return;
            }
            JSONObject jSONObject2 = (JSONObject) optJSONArray.get(0);
            this.addLinkResponseData.f63802d = jSONObject2.optInt("link_type");
            this.addLinkResponseData.f63803e = jSONObject2.optString("link_title");
            this.addLinkResponseData.f63804f = jSONObject2.optString("link_abstract");
            this.addLinkResponseData.f63805g = jSONObject2.optString("link_head_pic");
            this.addLinkResponseData.f63806h = jSONObject2.optString("link_head_small_pic");
            this.addLinkResponseData.i = jSONObject2.optString("link_head_big_pic");
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
