package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private y bPE;
    private ArrayList<com.baidu.tieba.tbadkCore.data.h> bPF;
    private Context mContext;
    private String bPD = null;
    private String imageUrl = null;
    private String aAA = null;
    private String aAB = null;
    private int width = 0;
    private int height = 0;
    private String bPG = null;
    private String bPH = null;
    private String userName = null;
    private String userID = null;
    private int index = -1;
    private String bPI = null;
    private long originalSize = 0;

    public l(Context context) {
        this.bPE = null;
        this.bPF = null;
        this.mContext = null;
        this.mContext = context;
        this.bPE = new y();
        this.bPF = new ArrayList<>();
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getImageID() {
        return this.bPD;
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

    public String EW() {
        return this.aAB;
    }

    public String Fa() {
        return this.bPI;
    }

    public long getOriginalSize() {
        return this.originalSize;
    }

    public void paserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            this.bPG = jSONObject.optString("post_id");
            this.userName = jSONObject.optString("user_name");
            this.userID = jSONObject.optString("user_id");
            this.bPH = jSONObject.optString("comment_amount");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("img");
            this.index = jSONObject.optInt(ImageViewerConfig.INDEX, -1);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("original")) != null) {
                this.bPD = optJSONObject.optString("id");
                this.imageUrl = optJSONObject.optString("url");
                this.width = optJSONObject.optInt("width", 0);
                this.height = optJSONObject.optInt("height", 0);
                this.aAA = optJSONObject.optString("cdn_src", "");
                if (this.aAA == null || this.aAA.length() == 0) {
                    this.aAA = this.imageUrl;
                }
                this.aAB = optJSONObject.optString("big_cdn_src", null);
                this.bPI = optJSONObject.optString("original_src");
                this.originalSize = optJSONObject.optInt("size");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("descr");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.tbadkCore.data.h hVar = new com.baidu.tieba.tbadkCore.data.h();
                    hVar.parserJson(optJSONArray.optJSONObject(i));
                    this.bPF.add(hVar);
                }
            }
            this.bPE.setContent(this.bPF);
            if (this.mContext != null) {
                this.bPE.az(this.mContext);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
