package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private r brw;
    private ArrayList<com.baidu.tieba.tbadkCore.b.c> brx;
    private Context mContext;
    private String brv = null;
    private String imageUrl = null;
    private String ajW = null;
    private String ajX = null;
    private int width = 0;
    private int height = 0;
    private String bry = null;
    private String brz = null;
    private String userName = null;
    private String brA = null;
    private int index = -1;

    public d(Context context) {
        this.brw = null;
        this.brx = null;
        this.mContext = null;
        this.mContext = context;
        this.brw = new r();
        this.brx = new ArrayList<>();
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getImageID() {
        return this.brv;
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

    public String Ak() {
        return this.ajX;
    }

    public void paserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            this.bry = jSONObject.optString("post_id");
            this.userName = jSONObject.optString("user_name");
            this.brA = jSONObject.optString("user_id");
            this.brz = jSONObject.optString("comment_amount");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("img");
            this.index = jSONObject.optInt(ImageViewerConfig.INDEX, -1);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("original")) != null) {
                this.brv = optJSONObject.optString("id");
                this.imageUrl = optJSONObject.optString(ImageViewerConfig.URL);
                this.width = optJSONObject.optInt("width", 0);
                this.height = optJSONObject.optInt("height", 0);
                this.ajW = optJSONObject.optString("cdn_src", "");
                if (this.ajW == null || this.ajW.length() == 0) {
                    this.ajW = this.imageUrl;
                }
                this.ajX = optJSONObject.optString("big_cdn_src", null);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("descr");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.tbadkCore.b.c cVar = new com.baidu.tieba.tbadkCore.b.c();
                    cVar.parserJson(optJSONArray.optJSONObject(i));
                    this.brx.add(cVar);
                }
            }
            this.brw.setContent(this.brx);
            if (this.mContext != null) {
                this.brw.as(this.mContext);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
