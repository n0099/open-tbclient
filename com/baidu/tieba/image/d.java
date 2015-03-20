package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private r bug;
    private ArrayList<com.baidu.tieba.tbadkCore.c.c> buh;
    private Context mContext;
    private String bue = null;
    private String imageUrl = null;
    private String asv = null;
    private String asw = null;
    private int width = 0;
    private int height = 0;
    private String bui = null;
    private String buj = null;
    private String userName = null;
    private String buk = null;
    private int index = -1;

    public d(Context context) {
        this.bug = null;
        this.buh = null;
        this.mContext = null;
        this.mContext = context;
        this.bug = new r();
        this.buh = new ArrayList<>();
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getImageID() {
        return this.bue;
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

    public String DG() {
        return this.asw;
    }

    public void paserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            this.bui = jSONObject.optString("post_id");
            this.userName = jSONObject.optString("user_name");
            this.buk = jSONObject.optString("user_id");
            this.buj = jSONObject.optString("comment_amount");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("img");
            this.index = jSONObject.optInt(ImageViewerConfig.INDEX, -1);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("original")) != null) {
                this.bue = optJSONObject.optString("id");
                this.imageUrl = optJSONObject.optString(ImageViewerConfig.URL);
                this.width = optJSONObject.optInt("width", 0);
                this.height = optJSONObject.optInt("height", 0);
                this.asv = optJSONObject.optString("cdn_src", "");
                if (this.asv == null || this.asv.length() == 0) {
                    this.asv = this.imageUrl;
                }
                this.asw = optJSONObject.optString("big_cdn_src", null);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("descr");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.tbadkCore.c.c cVar = new com.baidu.tieba.tbadkCore.c.c();
                    cVar.parserJson(optJSONArray.optJSONObject(i));
                    this.buh.add(cVar);
                }
            }
            this.bug.setContent(this.buh);
            if (this.mContext != null) {
                this.bug.av(this.mContext);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
