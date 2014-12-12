package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private r bpZ;
    private ArrayList<com.baidu.tieba.tbadkCore.b.c> bqa;
    private Context mContext;
    private String bpY = null;
    private String imageUrl = null;
    private String ajw = null;
    private String ajx = null;
    private int width = 0;
    private int height = 0;
    private String bqb = null;
    private String bqc = null;
    private String userName = null;
    private String bqd = null;
    private int index = -1;

    public d(Context context) {
        this.bpZ = null;
        this.bqa = null;
        this.mContext = null;
        this.mContext = context;
        this.bpZ = new r();
        this.bqa = new ArrayList<>();
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getImageID() {
        return this.bpY;
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

    public String zW() {
        return this.ajx;
    }

    public void paserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            this.bqb = jSONObject.optString("post_id");
            this.userName = jSONObject.optString("user_name");
            this.bqd = jSONObject.optString("user_id");
            this.bqc = jSONObject.optString("comment_amount");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("img");
            this.index = jSONObject.optInt(ImageViewerConfig.INDEX, -1);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("original")) != null) {
                this.bpY = optJSONObject.optString("id");
                this.imageUrl = optJSONObject.optString(ImageViewerConfig.URL);
                this.width = optJSONObject.optInt("width", 0);
                this.height = optJSONObject.optInt("height", 0);
                this.ajw = optJSONObject.optString("cdn_src", "");
                if (this.ajw == null || this.ajw.length() == 0) {
                    this.ajw = this.imageUrl;
                }
                this.ajx = optJSONObject.optString("big_cdn_src", null);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("descr");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.tbadkCore.b.c cVar = new com.baidu.tieba.tbadkCore.b.c();
                    cVar.parserJson(optJSONArray.optJSONObject(i));
                    this.bqa.add(cVar);
                }
            }
            this.bpZ.setContent(this.bqa);
            if (this.mContext != null) {
                this.bpZ.as(this.mContext);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
