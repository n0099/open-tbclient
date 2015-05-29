package com.baidu.tieba.postsearch;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {
    public List<k> bWB = new ArrayList();
    public com.baidu.tbadk.core.data.q bXR = new com.baidu.tbadk.core.data.q();

    public boolean UD() {
        return (this.bWB == null || this.bWB.size() == 0) ? false : true;
    }

    public boolean isHasMore() {
        return this.bXR != null && this.bXR.qR() == 1;
    }

    public int getCurrentPage() {
        if (this.bXR != null) {
            return this.bXR.qP();
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
                this.bXR.parserJson(jSONObject.getJSONObject("page"));
                JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    this.bWB.clear();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            JSONObject jSONObject3 = jSONObject2.getJSONObject("author");
                            String optString = jSONObject3.optString(com.baidu.tbadk.core.frameworkData.c.NAME_SHOW, "");
                            String optString2 = jSONObject3.optString("name", "");
                            long optLong = jSONObject2.optLong(Info.kBaiduPIDKey, 0L);
                            String optString3 = jSONObject2.optString("title", "");
                            String optString4 = jSONObject2.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, "");
                            String optString5 = jSONObject2.optString(ImageViewerConfig.FORUM_NAME, "");
                            long optLong2 = jSONObject2.optLong("tid", 0L);
                            int optInt = jSONObject2.optInt("is_floor", 0);
                            int optInt2 = jSONObject2.optInt("is_replay", 0);
                            k kVar = new k();
                            kVar.pid = optLong;
                            kVar.title = optString3;
                            kVar.time = jSONObject2.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                            kVar.content = optString4;
                            kVar.fname = optString5;
                            kVar.tid = optLong2;
                            kVar.is_floor = optInt;
                            kVar.bXS = optInt2;
                            kVar.name = optString2;
                            kVar.name_show = optString;
                            this.bWB.add(kVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.d(e.getMessage());
            }
        }
    }
}
