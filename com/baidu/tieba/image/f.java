package com.baidu.tieba.image;

import com.baidu.adp.lib.util.BdLog;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    private boolean eGm;
    private boolean isBlockedPic;
    private boolean isLongPic;
    private String eGj = null;
    private String imageUrl = null;
    private String bfr = null;
    private int width = 0;
    private int height = 0;
    private String eGk = null;
    private long originalSize = 0;
    private int picType = 0;
    private String tagName = "";
    private int index = -1;
    private long overAllIndex = 0;
    private String eGl = null;

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String aOM() {
        return this.eGj;
    }

    public String aON() {
        return this.eGl;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getIndex() {
        return this.index;
    }

    public String NQ() {
        return this.bfr;
    }

    public String NV() {
        return this.eGk;
    }

    public long getOriginalSize() {
        return this.originalSize;
    }

    public int getPicType() {
        return this.picType;
    }

    public String getTagName() {
        return this.tagName;
    }

    public boolean aOO() {
        return this.eGm;
    }

    public boolean aOP() {
        return this.isBlockedPic;
    }

    public boolean isLongPic() {
        return this.isLongPic;
    }

    public long aOQ() {
        return this.overAllIndex;
    }

    public void paserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            this.overAllIndex = jSONObject.optLong("overall_index", 0L);
            this.eGl = jSONObject.optString("post_id");
            this.eGm = jSONObject.optInt("show_original_btn") == 1;
            this.isBlockedPic = jSONObject.optInt("is_blocked_pic") == 1;
            this.isLongPic = jSONObject.optInt("is_long_pic") == 1;
            this.index = jSONObject.optInt("index", -1);
            JSONObject optJSONObject2 = jSONObject.optJSONObject(SocialConstants.PARAM_IMG_URL);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("original")) != null) {
                this.eGj = optJSONObject.optString("id");
                this.imageUrl = optJSONObject.optString("url");
                this.width = optJSONObject.optInt("width", 0);
                this.height = optJSONObject.optInt("height", 0);
                this.bfr = optJSONObject.optString("big_cdn_src", null);
                this.eGk = optJSONObject.optString("original_src");
                this.originalSize = optJSONObject.optInt("size");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("pic_tagname");
            if (optJSONObject3 != null) {
                this.picType = optJSONObject3.optInt("pic_type", 0);
                this.tagName = optJSONObject3.optString("tag_name");
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
