package com.baidu.tieba.write;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.e {
    private p bTa;
    private ArrayList<com.baidu.tbadk.core.data.q> bTb;
    private Context mContext;
    private int mErrCode;

    public o(Context context) {
        super(context);
        this.bTa = null;
        this.bTb = null;
        this.mErrCode = 0;
        this.mContext = context;
        this.bTb = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<com.baidu.tbadk.core.data.q> aff() {
        return this.bTb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hJ(String str) {
        if (this.bTa == null) {
            this.bTa = new p(this, null);
            this.bTa.setPriority(3);
            this.bTa.execute(str);
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
                            this.bTb.add(qVar);
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
        if (this.bTa != null) {
            this.bTa.cancel();
            return true;
        }
        return true;
    }
}
