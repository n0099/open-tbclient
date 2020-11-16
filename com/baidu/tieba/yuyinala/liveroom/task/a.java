package com.baidu.tieba.yuyinala.liveroom.task;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public int hsN;
    public String hsO;
    public int hsP;
    public int hsQ;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hsN = jSONObject.optInt("istip");
            this.tips = jSONObject.optString(TableDefine.MessageColumns.COLUME_TIPS);
            this.hsO = jSONObject.optString("righttips");
            this.hsP = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.hsQ = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
