package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.f<WriteActivity> {
    private t cwP;
    private ArrayList<com.baidu.tbadk.core.data.w> cwQ;
    private WriteActivity cwR;
    private int mErrCode;

    public s(WriteActivity writeActivity) {
        super(writeActivity.getPageContext());
        this.cwP = null;
        this.cwQ = null;
        this.mErrCode = 0;
        this.cwR = writeActivity;
        this.cwQ = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<com.baidu.tbadk.core.data.w> aqM() {
        return this.cwQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jh(String str) {
        if (this.cwP == null) {
            this.cwP = new t(this, null);
            this.cwP.setPriority(3);
            this.cwP.execute(str);
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
                            this.cwQ.add(wVar);
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
        if (this.cwP != null) {
            this.cwP.cancel();
            return true;
        }
        return true;
    }
}
