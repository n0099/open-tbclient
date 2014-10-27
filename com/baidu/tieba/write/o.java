package com.baidu.tieba.write;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.e {
    private p bSL;
    private ArrayList<com.baidu.tbadk.core.data.q> bSM;
    private Context mContext;
    private int mErrCode;

    public o(Context context) {
        super(context);
        this.bSL = null;
        this.bSM = null;
        this.mErrCode = 0;
        this.mContext = context;
        this.bSM = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<com.baidu.tbadk.core.data.q> afc() {
        return this.bSM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hJ(String str) {
        if (this.bSL == null) {
            this.bSL = new p(this, null);
            this.bSL.setPriority(3);
            this.bSL.execute(str);
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
                            com.baidu.tbadk.core.data.q qVar = new com.baidu.tbadk.core.data.q();
                            qVar.parserJson(jSONObject2);
                            this.bSM.add(qVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.bSL != null) {
            this.bSL.cancel();
            return true;
        }
        return true;
    }
}
