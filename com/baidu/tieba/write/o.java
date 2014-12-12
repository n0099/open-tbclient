package com.baidu.tieba.write;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.f<WriteActivity> {
    private p ceg;
    private ArrayList<com.baidu.tbadk.core.data.w> ceh;
    private WriteActivity cei;
    private int mErrCode;

    public o(WriteActivity writeActivity) {
        super(writeActivity.getPageContext());
        this.ceg = null;
        this.ceh = null;
        this.mErrCode = 0;
        this.cei = writeActivity;
        this.ceh = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<com.baidu.tbadk.core.data.w> ajJ() {
        return this.ceh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iv(String str) {
        if (this.ceg == null) {
            this.ceg = new p(this, null);
            this.ceg.setPriority(3);
            this.ceg.execute(str);
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
                            this.ceh.add(wVar);
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
        if (this.ceg != null) {
            this.ceg.cancel();
            return true;
        }
        return true;
    }
}
