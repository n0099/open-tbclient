package com.baidu.tieba.postsearch;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {
    public List<a> cmT = new ArrayList();
    public com.baidu.tbadk.core.data.p coL = new com.baidu.tbadk.core.data.p();

    /* loaded from: classes.dex */
    public static class a {
        public int coM;
        public String content;
        public String fname;
        public int is_floor;
        public String name;
        public String name_show;
        public long pid;
        public long tid;
        public long time;
        public String title;
    }

    public boolean Wl() {
        return (this.cmT == null || this.cmT.size() == 0) ? false : true;
    }

    public boolean isHasMore() {
        return this.coL != null && this.coL.rT() == 1;
    }

    public int getCurrentPage() {
        if (this.coL != null) {
            return this.coL.rR();
        }
        return 0;
    }

    public void parseJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                parseJson(new JSONObject(str));
            } catch (Exception e) {
            }
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.coL.parserJson(jSONObject.getJSONObject("page"));
                JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    this.cmT.clear();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            JSONObject jSONObject3 = jSONObject2.getJSONObject("author");
                            String optString = jSONObject3.optString(IntentConfig.NAME_SHOW, "");
                            String optString2 = jSONObject3.optString("name", "");
                            long optLong = jSONObject2.optLong(Info.kBaiduPIDKey, 0L);
                            String optString3 = jSONObject2.optString("title", "");
                            String optString4 = jSONObject2.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, "");
                            String optString5 = jSONObject2.optString(ImageViewerConfig.FORUM_NAME, "");
                            long optLong2 = jSONObject2.optLong("tid", 0L);
                            int optInt = jSONObject2.optInt("is_floor", 0);
                            int optInt2 = jSONObject2.optInt("is_replay", 0);
                            a aVar = new a();
                            aVar.pid = optLong;
                            aVar.title = optString3;
                            aVar.time = jSONObject2.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                            aVar.content = optString4;
                            aVar.fname = optString5;
                            aVar.tid = optLong2;
                            aVar.is_floor = optInt;
                            aVar.coM = optInt2;
                            aVar.name = optString2;
                            aVar.name_show = optString;
                            this.cmT.add(aVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.d(e.getMessage());
            }
        }
    }
}
