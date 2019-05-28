package com.baidu.tieba.image;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.tencent.open.SocialConstants;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    private AgreeData agreeData;
    private boolean gRX;
    private boolean isBlockedPic;
    private boolean isFirstPost;
    private boolean isLongPic;
    private String gRV = null;
    private String imageUrl = null;
    private String cLb = null;
    private int width = 0;
    private int height = 0;
    private String gRW = null;
    private long originalSize = 0;
    private int picType = 0;
    private String tagName = "";
    private int index = -1;
    private long overAllIndex = 0;
    private String postId = null;
    private String commentNum = null;
    private JSONArray gRY = null;

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String bFX() {
        return this.gRV;
    }

    public String bFY() {
        return this.postId;
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

    public String axR() {
        return this.cLb;
    }

    public String axX() {
        return this.gRW;
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

    public boolean bFZ() {
        return this.gRX;
    }

    public boolean bGa() {
        return this.isBlockedPic;
    }

    public boolean isLongPic() {
        return this.isLongPic;
    }

    public long bGb() {
        return this.overAllIndex;
    }

    public String bGc() {
        return this.commentNum;
    }

    public AgreeData afl() {
        return this.agreeData;
    }

    public JSONArray bGd() {
        return this.gRY;
    }

    public boolean bGe() {
        return this.isFirstPost;
    }

    public void paserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            this.overAllIndex = jSONObject.optLong("overall_index", 0L);
            this.postId = jSONObject.optString("post_id");
            this.gRX = jSONObject.optInt("show_original_btn") == 1;
            this.isBlockedPic = jSONObject.optInt("is_blocked_pic") == 1;
            this.isLongPic = jSONObject.optInt("is_long_pic") == 1;
            this.index = jSONObject.optInt("index", -1);
            this.isFirstPost = jSONObject.optInt("is_first_post") == 1;
            this.commentNum = jSONObject.optString("comment_num");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("agree");
            if (optJSONObject2 != null) {
                int optInt = optJSONObject2.optInt("agree_num");
                int optInt2 = optJSONObject2.optInt("disagree_num");
                int optInt3 = optJSONObject2.optInt("agree_type");
                boolean z = optJSONObject2.optInt("has_agree") == 1;
                if (this.agreeData == null) {
                    this.agreeData = new AgreeData();
                }
                this.agreeData.agreeType = optInt3;
                this.agreeData.hasAgree = z;
                this.agreeData.diffAgreeNum = optInt - optInt2;
            }
            this.gRY = jSONObject.optJSONArray("post_content");
            JSONObject optJSONObject3 = jSONObject.optJSONObject(SocialConstants.PARAM_IMG_URL);
            if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("original")) != null) {
                this.gRV = optJSONObject.optString("id");
                this.imageUrl = optJSONObject.optString("url");
                this.width = optJSONObject.optInt("width", 0);
                this.height = optJSONObject.optInt("height", 0);
                this.cLb = optJSONObject.optString("big_cdn_src", null);
                this.gRW = optJSONObject.optString("original_src");
                this.originalSize = optJSONObject.optInt("size");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("pic_tagname");
            if (optJSONObject4 != null) {
                this.picType = optJSONObject4.optInt("pic_type", 0);
                this.tagName = optJSONObject4.optString("tag_name");
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
