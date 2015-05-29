package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.f<WriteActivity> {
    private u cBA;
    private ArrayList<com.baidu.tbadk.core.data.w> cBB;
    private WriteActivity cBC;
    private int mErrCode;

    public t(WriteActivity writeActivity) {
        super(writeActivity.getPageContext());
        this.cBA = null;
        this.cBB = null;
        this.mErrCode = 0;
        this.cBC = writeActivity;
        this.cBB = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<com.baidu.tbadk.core.data.w> asR() {
        return this.cBB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kd(String str) {
        if (this.cBA == null) {
            this.cBA = new u(this, null);
            this.cBA.setPriority(3);
            this.cBA.execute(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mErrCode = jSONObject.optInt("error_code", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                            wVar.parserJson(jSONObject2);
                            this.cBB.add(wVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.cBA != null) {
            this.cBA.cancel();
            return true;
        }
        return true;
    }
}
