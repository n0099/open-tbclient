package com.baidu.tieba.play.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private List<String> clp;
    private long clq;
    private long mStartTime = System.currentTimeMillis();
    private String sT;

    public a BT(String str) {
        JSONArray optJSONArray;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.clq = jSONObject.optLong("ttl");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.sT = optJSONObject.keys().next();
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(this.sT);
            if (optJSONObject2 != null && (optJSONArray = optJSONObject2.optJSONArray(TableDefine.UserInfoColumns.COLUMN_IP)) != null && optJSONArray.length() > 0) {
                this.clp = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < optJSONArray.length()) {
                        this.clp.add((String) optJSONArray.get(i2));
                        i = i2 + 1;
                    } else {
                        return this;
                    }
                }
            } else {
                return this;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public List<String> anc() {
        return this.clp;
    }

    public String getHost() {
        return this.sT;
    }

    public boolean aW(long j) {
        return j - this.mStartTime > this.clq * 1000;
    }
}
