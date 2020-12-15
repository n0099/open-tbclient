package com.baidu.tieba.yuyinala.liveroom.task;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public int hCt;
    public String hCu;
    public int hCv;
    public int hCw;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hCt = jSONObject.optInt("istip");
            this.tips = jSONObject.optString(TableDefine.MessageColumns.COLUME_TIPS);
            this.hCu = jSONObject.optString("righttips");
            this.hCv = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.hCw = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
