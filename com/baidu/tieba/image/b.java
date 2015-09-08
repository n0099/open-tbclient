package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private n bLC;
    private ArrayList<com.baidu.tieba.tbadkCore.data.b> bLD;
    private Context mContext;
    private String bLB = null;
    private String imageUrl = null;
    private String aDf = null;
    private String aDg = null;
    private int width = 0;
    private int height = 0;
    private String bLE = null;
    private String bLF = null;
    private String userName = null;
    private String userID = null;
    private int index = -1;

    public b(Context context) {
        this.bLC = null;
        this.bLD = null;
        this.mContext = null;
        this.mContext = context;
        this.bLC = new n();
        this.bLD = new ArrayList<>();
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getImageID() {
        return this.bLB;
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

    public String Fs() {
        return this.aDg;
    }

    public void paserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            this.bLE = jSONObject.optString("post_id");
            this.userName = jSONObject.optString("user_name");
            this.userID = jSONObject.optString("user_id");
            this.bLF = jSONObject.optString("comment_amount");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("img");
            this.index = jSONObject.optInt(ImageViewerConfig.INDEX, -1);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("original")) != null) {
                this.bLB = optJSONObject.optString("id");
                this.imageUrl = optJSONObject.optString("url");
                this.width = optJSONObject.optInt("width", 0);
                this.height = optJSONObject.optInt("height", 0);
                this.aDf = optJSONObject.optString("cdn_src", "");
                if (this.aDf == null || this.aDf.length() == 0) {
                    this.aDf = this.imageUrl;
                }
                this.aDg = optJSONObject.optString("big_cdn_src", null);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("descr");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.tbadkCore.data.b bVar = new com.baidu.tieba.tbadkCore.data.b();
                    bVar.parserJson(optJSONArray.optJSONObject(i));
                    this.bLD.add(bVar);
                }
            }
            this.bLC.setContent(this.bLD);
            if (this.mContext != null) {
                this.bLC.aB(this.mContext);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
