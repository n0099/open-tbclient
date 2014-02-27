package com.baidu.tieba.write;

import com.baidu.cloudsdk.social.core.SocialConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class s extends com.baidu.adp.a.d {
    private ArrayList<com.baidu.tieba.data.az> b;
    private t a = null;
    private int c = 0;

    public s() {
        this.b = null;
        this.b = new ArrayList<>();
    }

    public final ArrayList<com.baidu.tieba.data.az> a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public final void a(String str) {
        if (this.a == null) {
            this.a = new t(this, (byte) 0);
            this.a.setPriority(3);
            this.a.execute(str);
        }
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.c = jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE, 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            com.baidu.tieba.data.az azVar = new com.baidu.tieba.data.az();
                            azVar.a(jSONObject2);
                            this.b.add(azVar);
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.a.d
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return true;
        }
        return true;
    }
}
