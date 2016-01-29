package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    private x cou;
    private ArrayList<com.baidu.tieba.tbadkCore.data.k> cov;
    private Context mContext;
    private String cot = null;
    private String imageUrl = null;
    private String aFz = null;
    private String aFA = null;
    private int width = 0;
    private int height = 0;
    private String cow = null;
    private String cox = null;
    private String userName = null;
    private String userID = null;
    private int index = -1;
    private String coy = null;
    private long originalSize = 0;
    private long overAllIndex = 0;

    public k(Context context) {
        this.cou = null;
        this.cov = null;
        this.mContext = null;
        this.mContext = context;
        this.cou = new x();
        this.cov = new ArrayList<>();
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getImageID() {
        return this.cot;
    }

    public String aiu() {
        return this.cow;
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

    public String Hg() {
        return this.aFA;
    }

    public String Hk() {
        return this.coy;
    }

    public long getOriginalSize() {
        return this.originalSize;
    }

    public void paserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            this.overAllIndex = com.baidu.adp.lib.h.b.c(jSONObject.optString("overall_index"), 0L);
            this.cow = jSONObject.optString("post_id");
            this.userName = jSONObject.optString("user_name");
            this.userID = jSONObject.optString("user_id");
            this.cox = jSONObject.optString("comment_amount");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("img");
            this.index = jSONObject.optInt(ImageViewerConfig.INDEX, -1);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("original")) != null) {
                this.cot = optJSONObject.optString("id");
                this.imageUrl = optJSONObject.optString("url");
                this.width = optJSONObject.optInt("width", 0);
                this.height = optJSONObject.optInt("height", 0);
                this.aFz = optJSONObject.optString("cdn_src", "");
                if (this.aFz == null || this.aFz.length() == 0) {
                    this.aFz = this.imageUrl;
                }
                this.aFA = optJSONObject.optString("big_cdn_src", null);
                this.coy = optJSONObject.optString("original_src");
                this.originalSize = optJSONObject.optInt("size");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("descr");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.tbadkCore.data.k kVar = new com.baidu.tieba.tbadkCore.data.k();
                    kVar.parserJson(optJSONArray.optJSONObject(i));
                    this.cov.add(kVar);
                }
            }
            this.cou.setContent(this.cov);
            if (this.mContext != null) {
                this.cou.aA(this.mContext);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public long aiv() {
        return this.overAllIndex;
    }
}
