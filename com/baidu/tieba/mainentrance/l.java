package com.baidu.tieba.mainentrance;

import android.graphics.Color;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bd;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private String bul;
    private String tid = null;
    private String aaR = null;
    private String title = null;
    private boolean byL = false;
    private long time = 0;
    private final UserData byK = new UserData();
    private String content = null;
    private boolean byM = true;

    public boolean WG() {
        return this.byM;
    }

    public String getPid() {
        return this.aaR;
    }

    public String getTid() {
        return this.tid;
    }

    public String WH() {
        return this.bul;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public long getTime() {
        return this.time;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.tid = jSONObject.optString("tid");
                this.title = jSONObject.optString("title");
                this.aaR = jSONObject.optString("pid");
                this.byL = jSONObject.optInt("is_floor", 0) != 0;
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.byK.parserJson(jSONObject.optJSONObject("author"));
                this.content = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
                this.bul = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.title = bd.a(this.title, (Color) null);
                String a = bd.a(this.content, (Color) null);
                if (!a.equals(this.content)) {
                    this.content = a;
                    this.byM = false;
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
