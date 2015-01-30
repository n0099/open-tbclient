package com.baidu.tieba.mainentrance;

import android.graphics.Color;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bf;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    private String atD;
    private String tid = null;
    private String Ri = null;
    private String title = null;
    private boolean atF = false;
    private long time = 0;
    private final UserData atE = new UserData();
    private String content = null;
    private boolean atG = true;

    public boolean Uc() {
        return this.atG;
    }

    public String getPid() {
        return this.Ri;
    }

    public String getTid() {
        return this.tid;
    }

    public String Ud() {
        return this.atD;
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
                this.Ri = jSONObject.optString("pid");
                this.atF = jSONObject.optInt("is_floor", 0) != 0;
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.atE.parserJson(jSONObject.optJSONObject("author"));
                this.content = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
                this.atD = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.title = bf.a(this.title, (Color) null);
                String a = bf.a(this.content, (Color) null);
                if (!a.equals(this.content)) {
                    this.content = a;
                    this.atG = false;
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
