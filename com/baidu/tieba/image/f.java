package com.baidu.tieba.image;

import com.baidu.adp.lib.util.BdLog;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    private boolean eKg;
    private boolean isBlockedPic;
    private boolean isLongPic;
    private String eKd = null;
    private String imageUrl = null;
    private String bfC = null;
    private int width = 0;
    private int height = 0;
    private String eKe = null;
    private long originalSize = 0;
    private int picType = 0;
    private String tagName = "";
    private int index = -1;
    private long overAllIndex = 0;
    private String eKf = null;

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String aPM() {
        return this.eKd;
    }

    public String aPN() {
        return this.eKf;
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

    public String NO() {
        return this.bfC;
    }

    public String NV() {
        return this.eKe;
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

    public boolean aPO() {
        return this.eKg;
    }

    public boolean aPP() {
        return this.isBlockedPic;
    }

    public boolean isLongPic() {
        return this.isLongPic;
    }

    public long aPQ() {
        return this.overAllIndex;
    }

    public void paserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            this.overAllIndex = jSONObject.optLong("overall_index", 0L);
            this.eKf = jSONObject.optString("post_id");
            this.eKg = jSONObject.optInt("show_original_btn") == 1;
            this.isBlockedPic = jSONObject.optInt("is_blocked_pic") == 1;
            this.isLongPic = jSONObject.optInt("is_long_pic") == 1;
            this.index = jSONObject.optInt("index", -1);
            JSONObject optJSONObject2 = jSONObject.optJSONObject(SocialConstants.PARAM_IMG_URL);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("original")) != null) {
                this.eKd = optJSONObject.optString("id");
                this.imageUrl = optJSONObject.optString("url");
                this.width = optJSONObject.optInt("width", 0);
                this.height = optJSONObject.optInt("height", 0);
                this.bfC = optJSONObject.optString("big_cdn_src", null);
                this.eKe = optJSONObject.optString("original_src");
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
