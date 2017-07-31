package com.baidu.tieba.play.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String Ca;
    private List<String> fAB;
    private long fAC;
    private long mStartTime = System.currentTimeMillis();

    public a qJ(String str) {
        JSONArray optJSONArray;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.fAC = jSONObject.optLong("ttl");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.Ca = optJSONObject.keys().next();
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(this.Ca);
            if (optJSONObject2 != null && (optJSONArray = optJSONObject2.optJSONArray("ip")) != null && optJSONArray.length() > 0) {
                this.fAB = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < optJSONArray.length()) {
                        this.fAB.add((String) optJSONArray.get(i2));
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

    public List<String> bga() {
        return this.fAB;
    }

    public String getHost() {
        return this.Ca;
    }

    public boolean cE(long j) {
        return j - this.mStartTime > this.fAC * 1000;
    }
}
