package com.baidu.tieba.yuyinala.liveroom.task;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public int hQj;
    public String hQk;
    public int hQl;
    public int hQm;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hQj = jSONObject.optInt("istip");
            this.tips = jSONObject.optString(TableDefine.MessageColumns.COLUME_TIPS);
            this.hQk = jSONObject.optString("righttips");
            this.hQl = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.hQm = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
