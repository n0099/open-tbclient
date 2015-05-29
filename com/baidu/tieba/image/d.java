package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private r bxe;
    private ArrayList<com.baidu.tieba.tbadkCore.data.c> bxf;
    private Context mContext;
    private String bxd = null;
    private String imageUrl = null;
    private String auj = null;
    private String auk = null;
    private int width = 0;
    private int height = 0;
    private String bxg = null;
    private String bxh = null;
    private String userName = null;
    private String bxi = null;
    private int index = -1;

    public d(Context context) {
        this.bxe = null;
        this.bxf = null;
        this.mContext = null;
        this.mContext = context;
        this.bxe = new r();
        this.bxf = new ArrayList<>();
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getImageID() {
        return this.bxd;
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

    public String Ew() {
        return this.auk;
    }

    public void paserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            this.bxg = jSONObject.optString("post_id");
            this.userName = jSONObject.optString("user_name");
            this.bxi = jSONObject.optString("user_id");
            this.bxh = jSONObject.optString("comment_amount");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("img");
            this.index = jSONObject.optInt(ImageViewerConfig.INDEX, -1);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("original")) != null) {
                this.bxd = optJSONObject.optString("id");
                this.imageUrl = optJSONObject.optString(ImageViewerConfig.URL);
                this.width = optJSONObject.optInt("width", 0);
                this.height = optJSONObject.optInt("height", 0);
                this.auj = optJSONObject.optString("cdn_src", "");
                if (this.auj == null || this.auj.length() == 0) {
                    this.auj = this.imageUrl;
                }
                this.auk = optJSONObject.optString("big_cdn_src", null);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("descr");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.tbadkCore.data.c cVar = new com.baidu.tieba.tbadkCore.data.c();
                    cVar.parserJson(optJSONArray.optJSONObject(i));
                    this.bxf.add(cVar);
                }
            }
            this.bxe.setContent(this.bxf);
            if (this.mContext != null) {
                this.bxe.aA(this.mContext);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
