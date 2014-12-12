package com.baidu.tieba.mainentrance;

import android.graphics.Color;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ba;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    private String asx;
    private String tid = null;
    private String QH = null;
    private String title = null;
    private boolean asz = false;
    private long time = 0;
    private final UserData asy = new UserData();
    private String content = null;
    private boolean asA = true;

    public boolean TG() {
        return this.asA;
    }

    public String getPid() {
        return this.QH;
    }

    public String getTid() {
        return this.tid;
    }

    public String TH() {
        return this.asx;
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
                this.QH = jSONObject.optString("pid");
                this.asz = jSONObject.optInt("is_floor", 0) != 0;
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.asy.parserJson(jSONObject.optJSONObject("author"));
                this.content = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
                this.asx = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.title = ba.a(this.title, (Color) null);
                String a = ba.a(this.content, (Color) null);
                if (!a.equals(this.content)) {
                    this.content = a;
                    this.asA = false;
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
