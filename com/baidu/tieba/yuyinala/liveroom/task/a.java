package com.baidu.tieba.yuyinala.liveroom.task;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public int hJO;
    public String hJP;
    public int hJQ;
    public int hJR;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hJO = jSONObject.optInt("istip");
            this.tips = jSONObject.optString(TableDefine.MessageColumns.COLUME_TIPS);
            this.hJP = jSONObject.optString("righttips");
            this.hJQ = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.hJR = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
