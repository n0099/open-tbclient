package com.baidu.tieba.write.write;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.e<WriteActivity> {
    private a eLK;
    private ArrayList<com.baidu.tbadk.core.data.as> eLL;
    private WriteActivity eLM;
    private int mErrCode;

    public p(WriteActivity writeActivity) {
        super(writeActivity.getPageContext());
        this.eLK = null;
        this.eLL = null;
        this.mErrCode = 0;
        this.eLM = writeActivity;
        this.eLL = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<com.baidu.tbadk.core.data.as> bba() {
        return this.eLL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void oZ(String str) {
        if (this.eLK == null) {
            this.eLK = new a(this, null);
            this.eLK.setPriority(3);
            this.eLK.execute(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, p, p> {
        private com.baidu.tbadk.core.util.ab QV;

        private a() {
        }

        /* synthetic */ a(p pVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public p doInBackground(Object... objArr) {
            String obj = objArr[0].toString();
            this.QV = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/frs/toplist");
            this.QV.p("kw", obj);
            String vw = this.QV.vw();
            if (!this.QV.vU().wP().qC()) {
                return null;
            }
            p pVar = new p(p.this.eLM);
            pVar.parserJson(vw);
            return pVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(p pVar) {
            super.onPostExecute(pVar);
            p.this.eLK = null;
            p.this.mLoadDataCallBack.d(pVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            p.this.eLK = null;
            if (this.QV != null) {
                this.QV.gX();
            }
        }
    }

    void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mErrCode = jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE, 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            com.baidu.tbadk.core.data.as asVar = new com.baidu.tbadk.core.data.as();
                            asVar.parserJson(jSONObject2);
                            this.eLL.add(asVar);
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
        if (this.eLK != null) {
            this.eLK.cancel();
            return true;
        }
        return true;
    }
}
