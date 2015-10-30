package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private y bPj;
    private ArrayList<com.baidu.tieba.tbadkCore.data.d> bPk;
    private Context mContext;
    private String bPi = null;
    private String imageUrl = null;
    private String aBJ = null;
    private String aBK = null;
    private int width = 0;
    private int height = 0;
    private String bPl = null;
    private String bPm = null;
    private String userName = null;
    private String userID = null;
    private int index = -1;
    private String bPn = null;
    private long originalSize = 0;

    public l(Context context) {
        this.bPj = null;
        this.bPk = null;
        this.mContext = null;
        this.mContext = context;
        this.bPj = new y();
        this.bPk = new ArrayList<>();
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getImageID() {
        return this.bPi;
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

    public String Fb() {
        return this.aBK;
    }

    public String Ff() {
        return this.bPn;
    }

    public long getOriginalSize() {
        return this.originalSize;
    }

    public void paserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            this.bPl = jSONObject.optString("post_id");
            this.userName = jSONObject.optString("user_name");
            this.userID = jSONObject.optString("user_id");
            this.bPm = jSONObject.optString("comment_amount");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("img");
            this.index = jSONObject.optInt(ImageViewerConfig.INDEX, -1);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("original")) != null) {
                this.bPi = optJSONObject.optString("id");
                this.imageUrl = optJSONObject.optString("url");
                this.width = optJSONObject.optInt("width", 0);
                this.height = optJSONObject.optInt("height", 0);
                this.aBJ = optJSONObject.optString("cdn_src", "");
                if (this.aBJ == null || this.aBJ.length() == 0) {
                    this.aBJ = this.imageUrl;
                }
                this.aBK = optJSONObject.optString("big_cdn_src", null);
                this.bPn = optJSONObject.optString("original_src");
                this.originalSize = optJSONObject.optInt("size");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("descr");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.tbadkCore.data.d dVar = new com.baidu.tieba.tbadkCore.data.d();
                    dVar.parserJson(optJSONArray.optJSONObject(i));
                    this.bPk.add(dVar);
                }
            }
            this.bPj.setContent(this.bPk);
            if (this.mContext != null) {
                this.bPj.aA(this.mContext);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
