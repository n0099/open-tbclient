package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private r buw;
    private ArrayList<com.baidu.tieba.tbadkCore.c.c> bux;
    private Context mContext;
    private String buv = null;
    private String imageUrl = null;
    private String asD = null;
    private String asE = null;
    private int width = 0;
    private int height = 0;
    private String buy = null;
    private String buz = null;
    private String userName = null;
    private String buA = null;
    private int index = -1;

    public d(Context context) {
        this.buw = null;
        this.bux = null;
        this.mContext = null;
        this.mContext = context;
        this.buw = new r();
        this.bux = new ArrayList<>();
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getImageID() {
        return this.buv;
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

    public String DM() {
        return this.asE;
    }

    public void paserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            this.buy = jSONObject.optString("post_id");
            this.userName = jSONObject.optString("user_name");
            this.buA = jSONObject.optString("user_id");
            this.buz = jSONObject.optString("comment_amount");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("img");
            this.index = jSONObject.optInt(ImageViewerConfig.INDEX, -1);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("original")) != null) {
                this.buv = optJSONObject.optString("id");
                this.imageUrl = optJSONObject.optString(ImageViewerConfig.URL);
                this.width = optJSONObject.optInt("width", 0);
                this.height = optJSONObject.optInt("height", 0);
                this.asD = optJSONObject.optString("cdn_src", "");
                if (this.asD == null || this.asD.length() == 0) {
                    this.asD = this.imageUrl;
                }
                this.asE = optJSONObject.optString("big_cdn_src", null);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("descr");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.tbadkCore.c.c cVar = new com.baidu.tieba.tbadkCore.c.c();
                    cVar.parserJson(optJSONArray.optJSONObject(i));
                    this.bux.add(cVar);
                }
            }
            this.buw.setContent(this.bux);
            if (this.mContext != null) {
                this.buw.av(this.mContext);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
