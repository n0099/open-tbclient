package com.baidu.tieba.write;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.f<WriteActivity> {
    private p cfE;
    private ArrayList<com.baidu.tbadk.core.data.x> cfF;
    private WriteActivity cfG;
    private int mErrCode;

    public o(WriteActivity writeActivity) {
        super(writeActivity.getPageContext());
        this.cfE = null;
        this.cfF = null;
        this.mErrCode = 0;
        this.cfG = writeActivity;
        this.cfF = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<com.baidu.tbadk.core.data.x> akb() {
        return this.cfF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iB(String str) {
        if (this.cfE == null) {
            this.cfE = new p(this, null);
            this.cfE.setPriority(3);
            this.cfE.execute(str);
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
                            com.baidu.tbadk.core.data.x xVar = new com.baidu.tbadk.core.data.x();
                            xVar.parserJson(jSONObject2);
                            this.cfF.add(xVar);
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
        if (this.cfE != null) {
            this.cfE.cancel();
            return true;
        }
        return true;
    }
}
