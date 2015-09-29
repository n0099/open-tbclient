package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private y bOY;
    private ArrayList<com.baidu.tieba.tbadkCore.data.d> bOZ;
    private Context mContext;
    private String bOX = null;
    private String imageUrl = null;
    private String aBy = null;
    private String aBz = null;
    private int width = 0;
    private int height = 0;
    private String bPa = null;
    private String bPb = null;
    private String userName = null;
    private String userID = null;
    private int index = -1;
    private String bPc = null;
    private long originalSize = 0;

    public l(Context context) {
        this.bOY = null;
        this.bOZ = null;
        this.mContext = null;
        this.mContext = context;
        this.bOY = new y();
        this.bOZ = new ArrayList<>();
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getImageID() {
        return this.bOX;
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

    public String Ff() {
        return this.aBz;
    }

    public String Fj() {
        return this.bPc;
    }

    public long getOriginalSize() {
        return this.originalSize;
    }

    public void paserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            this.bPa = jSONObject.optString("post_id");
            this.userName = jSONObject.optString("user_name");
            this.userID = jSONObject.optString("user_id");
            this.bPb = jSONObject.optString("comment_amount");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("img");
            this.index = jSONObject.optInt(ImageViewerConfig.INDEX, -1);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("original")) != null) {
                this.bOX = optJSONObject.optString("id");
                this.imageUrl = optJSONObject.optString("url");
                this.width = optJSONObject.optInt("width", 0);
                this.height = optJSONObject.optInt("height", 0);
                this.aBy = optJSONObject.optString("cdn_src", "");
                if (this.aBy == null || this.aBy.length() == 0) {
                    this.aBy = this.imageUrl;
                }
                this.aBz = optJSONObject.optString("big_cdn_src", null);
                this.bPc = optJSONObject.optString("original_src");
                this.originalSize = optJSONObject.optInt("size");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("descr");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.tbadkCore.data.d dVar = new com.baidu.tieba.tbadkCore.data.d();
                    dVar.parserJson(optJSONArray.optJSONObject(i));
                    this.bOZ.add(dVar);
                }
            }
            this.bOY.setContent(this.bOZ);
            if (this.mContext != null) {
                this.bOY.aA(this.mContext);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
