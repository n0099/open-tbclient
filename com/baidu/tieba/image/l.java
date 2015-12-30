package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private y cjU;
    private ArrayList<com.baidu.tieba.tbadkCore.data.k> cjV;
    private Context mContext;
    private String cjT = null;
    private String imageUrl = null;
    private String aEJ = null;
    private String aEK = null;
    private int width = 0;
    private int height = 0;
    private String cjW = null;
    private String cjX = null;
    private String userName = null;
    private String userID = null;
    private int index = -1;
    private String cjY = null;
    private long originalSize = 0;
    private long overAllIndex = 0;

    public l(Context context) {
        this.cjU = null;
        this.cjV = null;
        this.mContext = null;
        this.mContext = context;
        this.cjU = new y();
        this.cjV = new ArrayList<>();
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getImageID() {
        return this.cjT;
    }

    public String afk() {
        return this.cjW;
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

    public String FO() {
        return this.aEK;
    }

    public String FS() {
        return this.cjY;
    }

    public long getOriginalSize() {
        return this.originalSize;
    }

    public void paserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            this.overAllIndex = com.baidu.adp.lib.h.b.c(jSONObject.optString("overall_index"), 0L);
            this.cjW = jSONObject.optString("post_id");
            this.userName = jSONObject.optString("user_name");
            this.userID = jSONObject.optString("user_id");
            this.cjX = jSONObject.optString("comment_amount");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("img");
            this.index = jSONObject.optInt(ImageViewerConfig.INDEX, -1);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("original")) != null) {
                this.cjT = optJSONObject.optString("id");
                this.imageUrl = optJSONObject.optString("url");
                this.width = optJSONObject.optInt("width", 0);
                this.height = optJSONObject.optInt("height", 0);
                this.aEJ = optJSONObject.optString("cdn_src", "");
                if (this.aEJ == null || this.aEJ.length() == 0) {
                    this.aEJ = this.imageUrl;
                }
                this.aEK = optJSONObject.optString("big_cdn_src", null);
                this.cjY = optJSONObject.optString("original_src");
                this.originalSize = optJSONObject.optInt("size");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("descr");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.tbadkCore.data.k kVar = new com.baidu.tieba.tbadkCore.data.k();
                    kVar.parserJson(optJSONArray.optJSONObject(i));
                    this.cjV.add(kVar);
                }
            }
            this.cjU.setContent(this.cjV);
            if (this.mContext != null) {
                this.cjU.az(this.mContext);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public long afl() {
        return this.overAllIndex;
    }
}
