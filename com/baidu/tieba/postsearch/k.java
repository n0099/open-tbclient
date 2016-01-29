package com.baidu.tieba.postsearch;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    public List<a> daF = new ArrayList();
    public com.baidu.tbadk.core.data.u dxG = new com.baidu.tbadk.core.data.u();

    /* loaded from: classes.dex */
    public static class a {
        public String content;
        public int dxH;
        public String fname;
        public int is_floor;
        public String name;
        public String name_show;
        public long pid;
        public int thread_type;
        public long tid;
        public long time;
        public String title;
    }

    public boolean aeH() {
        return (this.daF == null || this.daF.size() == 0) ? false : true;
    }

    public boolean isHasMore() {
        return this.dxG != null && this.dxG.sv() == 1;
    }

    public int pf() {
        if (this.dxG != null) {
            return this.dxG.st();
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
                this.dxG.parserJson(jSONObject.getJSONObject("page"));
                JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    this.daF.clear();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            JSONObject jSONObject3 = jSONObject2.getJSONObject("author");
                            String optString = jSONObject3.optString(IntentConfig.NAME_SHOW, "");
                            String optString2 = jSONObject3.optString("name", "");
                            long optLong = jSONObject2.optLong(Info.kBaiduPIDKey, 0L);
                            String optString3 = jSONObject2.optString("title", "");
                            long optLong2 = jSONObject2.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                            String optString4 = jSONObject2.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, "");
                            String optString5 = jSONObject2.optString(ImageViewerConfig.FORUM_NAME, "");
                            long optLong3 = jSONObject2.optLong("tid", 0L);
                            int optInt = jSONObject2.optInt("is_floor", 0);
                            int optInt2 = jSONObject2.optInt("is_replay", 0);
                            int optInt3 = jSONObject2.optInt("thread_type", 0);
                            if (optInt3 != 33 || TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                a aVar = new a();
                                aVar.pid = optLong;
                                aVar.title = optString3;
                                aVar.time = optLong2;
                                aVar.content = optString4;
                                aVar.fname = optString5;
                                aVar.tid = optLong3;
                                aVar.is_floor = optInt;
                                aVar.dxH = optInt2;
                                aVar.name = optString2;
                                aVar.name_show = optString;
                                aVar.thread_type = optInt3;
                                this.daF.add(aVar);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.d(e.getMessage());
            }
        }
    }
}
