package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private y cfR;
    private ArrayList<com.baidu.tieba.tbadkCore.data.h> cfS;
    private Context mContext;
    private String cfQ = null;
    private String imageUrl = null;
    private String aDk = null;
    private String aDl = null;
    private int width = 0;
    private int height = 0;
    private String cfT = null;
    private String cfU = null;
    private String userName = null;
    private String userID = null;
    private int index = -1;
    private String cfV = null;
    private long originalSize = 0;

    public l(Context context) {
        this.cfR = null;
        this.cfS = null;
        this.mContext = null;
        this.mContext = context;
        this.cfR = new y();
        this.cfS = new ArrayList<>();
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getImageID() {
        return this.cfQ;
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

    public String FZ() {
        return this.aDl;
    }

    public String Gd() {
        return this.cfV;
    }

    public long getOriginalSize() {
        return this.originalSize;
    }

    public void paserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            this.cfT = jSONObject.optString("post_id");
            this.userName = jSONObject.optString("user_name");
            this.userID = jSONObject.optString("user_id");
            this.cfU = jSONObject.optString("comment_amount");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("img");
            this.index = jSONObject.optInt(ImageViewerConfig.INDEX, -1);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("original")) != null) {
                this.cfQ = optJSONObject.optString("id");
                this.imageUrl = optJSONObject.optString("url");
                this.width = optJSONObject.optInt("width", 0);
                this.height = optJSONObject.optInt("height", 0);
                this.aDk = optJSONObject.optString("cdn_src", "");
                if (this.aDk == null || this.aDk.length() == 0) {
                    this.aDk = this.imageUrl;
                }
                this.aDl = optJSONObject.optString("big_cdn_src", null);
                this.cfV = optJSONObject.optString("original_src");
                this.originalSize = optJSONObject.optInt("size");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("descr");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.tbadkCore.data.h hVar = new com.baidu.tieba.tbadkCore.data.h();
                    hVar.parserJson(optJSONArray.optJSONObject(i));
                    this.cfS.add(hVar);
                }
            }
            this.cfR.setContent(this.cfS);
            if (this.mContext != null) {
                this.cfR.az(this.mContext);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
