package com.baidu.tieba.play.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String EL;
    private List<String> ghI;
    private long ghJ;
    private long mStartTime = System.currentTimeMillis();

    public a si(String str) {
        JSONArray optJSONArray;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.ghJ = jSONObject.optLong("ttl");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.EL = optJSONObject.keys().next();
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(this.EL);
            if (optJSONObject2 != null && (optJSONArray = optJSONObject2.optJSONArray("ip")) != null && optJSONArray.length() > 0) {
                this.ghI = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < optJSONArray.length()) {
                        this.ghI.add((String) optJSONArray.get(i2));
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

    public List<String> bkV() {
        return this.ghI;
    }

    public String getHost() {
        return this.EL;
    }

    public boolean cN(long j) {
        return j - this.mStartTime > this.ghJ * 1000;
    }
}
