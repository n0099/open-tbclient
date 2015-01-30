package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private r brx;
    private ArrayList<com.baidu.tieba.tbadkCore.b.c> bry;
    private Context mContext;
    private String brw = null;
    private String imageUrl = null;
    private String ajZ = null;
    private String aka = null;
    private int width = 0;
    private int height = 0;
    private String brz = null;
    private String brA = null;
    private String userName = null;
    private String brB = null;
    private int index = -1;

    public d(Context context) {
        this.brx = null;
        this.bry = null;
        this.mContext = null;
        this.mContext = context;
        this.brx = new r();
        this.bry = new ArrayList<>();
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getImageID() {
        return this.brw;
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

    public String Aq() {
        return this.aka;
    }

    public void paserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            this.brz = jSONObject.optString("post_id");
            this.userName = jSONObject.optString("user_name");
            this.brB = jSONObject.optString("user_id");
            this.brA = jSONObject.optString("comment_amount");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("img");
            this.index = jSONObject.optInt(ImageViewerConfig.INDEX, -1);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("original")) != null) {
                this.brw = optJSONObject.optString("id");
                this.imageUrl = optJSONObject.optString(ImageViewerConfig.URL);
                this.width = optJSONObject.optInt("width", 0);
                this.height = optJSONObject.optInt("height", 0);
                this.ajZ = optJSONObject.optString("cdn_src", "");
                if (this.ajZ == null || this.ajZ.length() == 0) {
                    this.ajZ = this.imageUrl;
                }
                this.aka = optJSONObject.optString("big_cdn_src", null);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("descr");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.tbadkCore.b.c cVar = new com.baidu.tieba.tbadkCore.b.c();
                    cVar.parserJson(optJSONArray.optJSONObject(i));
                    this.bry.add(cVar);
                }
            }
            this.brx.setContent(this.bry);
            if (this.mContext != null) {
                this.brx.as(this.mContext);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
