package com.baidu.tieba.write;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.b {
    private ArrayList<com.baidu.tbadk.core.data.n> b;
    private t a = null;
    private int c = 0;

    public s() {
        this.b = null;
        this.b = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<com.baidu.tbadk.core.data.n> a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        if (this.a == null) {
            this.a = new t(this, null);
            this.a.setPriority(3);
            this.a.execute(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "parserJson", "error = " + e.getMessage());
        }
    }

    void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.c = jSONObject.optInt("error_code", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                            nVar.a(jSONObject2);
                            this.b.add(nVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.base.b
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.b
    public boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return true;
        }
        return true;
    }
}
