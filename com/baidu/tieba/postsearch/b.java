package com.baidu.tieba.postsearch;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.az;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public List<a> mMM = new ArrayList();
    public az jbr = new az();

    /* loaded from: classes8.dex */
    public static class a {
        public String content;
        public String fname;
        public int is_floor;
        public int mMN;
        public String name;
        public String name_show;
        public long pid;
        public int thread_type;
        public long tid;
        public long time;
        public String title;
    }

    public boolean cXL() {
        return (this.mMM == null || this.mMM.size() == 0) ? false : true;
    }

    public boolean isHasMore() {
        return this.jbr != null && this.jbr.bmF() == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.jbr.parserJson(jSONObject.getJSONObject("page"));
                JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    this.mMM.clear();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            JSONObject jSONObject3 = jSONObject2.getJSONObject("author");
                            String optString = jSONObject3.optString("name_show", "");
                            String optString2 = jSONObject3.optString("name", "");
                            long optLong = jSONObject2.optLong("pid", 0L);
                            String optString3 = jSONObject2.optString("title", "");
                            long optLong2 = jSONObject2.optLong("time", 0L) * 1000;
                            String optString4 = jSONObject2.optString("content", "");
                            String optString5 = jSONObject2.optString("fname", "");
                            long optLong3 = jSONObject2.optLong("tid", 0L);
                            int optInt = jSONObject2.optInt("is_floor", 0);
                            int optInt2 = jSONObject2.optInt("is_replay", 0);
                            int optInt3 = jSONObject2.optInt("thread_type", 0);
                            if (optInt3 != 33) {
                                a aVar = new a();
                                aVar.pid = optLong;
                                aVar.title = optString3;
                                aVar.time = optLong2;
                                aVar.content = optString4;
                                aVar.fname = optString5;
                                aVar.tid = optLong3;
                                aVar.is_floor = optInt;
                                aVar.mMN = optInt2;
                                aVar.name = optString2;
                                aVar.name_show = optString;
                                aVar.thread_type = optInt3;
                                this.mMM.add(aVar);
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
