package com.baidu.tieba.write;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class s extends com.baidu.adp.a.e {
    private ArrayList<com.baidu.tbadk.core.data.o> b;
    private t a = null;
    private int c = 0;

    public s() {
        this.b = null;
        this.b = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ArrayList<com.baidu.tbadk.core.data.o> a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int b() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str) {
        if (this.a == null) {
            this.a = new t(this, (byte) 0);
            this.a.setPriority(3);
            this.a.execute(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.c = jSONObject.optInt("error_code", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
                            oVar.a(jSONObject2);
                            this.b.add(oVar);
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return true;
        }
        return true;
    }
}
