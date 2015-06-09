package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private r bxf;
    private ArrayList<com.baidu.tieba.tbadkCore.data.c> bxg;
    private Context mContext;
    private String bxe = null;
    private String imageUrl = null;
    private String auj = null;
    private String auk = null;
    private int width = 0;
    private int height = 0;
    private String bxh = null;
    private String bxi = null;
    private String userName = null;
    private String bxj = null;
    private int index = -1;

    public d(Context context) {
        this.bxf = null;
        this.bxg = null;
        this.mContext = null;
        this.mContext = context;
        this.bxf = new r();
        this.bxg = new ArrayList<>();
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getImageID() {
        return this.bxe;
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

    public String Ex() {
        return this.auk;
    }

    public void paserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            this.bxh = jSONObject.optString("post_id");
            this.userName = jSONObject.optString("user_name");
            this.bxj = jSONObject.optString("user_id");
            this.bxi = jSONObject.optString("comment_amount");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("img");
            this.index = jSONObject.optInt(ImageViewerConfig.INDEX, -1);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("original")) != null) {
                this.bxe = optJSONObject.optString("id");
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
                    this.bxg.add(cVar);
                }
            }
            this.bxf.setContent(this.bxg);
            if (this.mContext != null) {
                this.bxf.aA(this.mContext);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
