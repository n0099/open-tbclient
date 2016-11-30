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
    private a gnK;
    private ArrayList<com.baidu.tbadk.core.data.bk> gnL;
    private WriteActivity gnM;
    private int mErrCode;

    public p(WriteActivity writeActivity) {
        super(writeActivity.getPageContext());
        this.gnK = null;
        this.gnL = null;
        this.mErrCode = 0;
        this.gnM = writeActivity;
        this.gnL = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<com.baidu.tbadk.core.data.bk> bwb() {
        return this.gnL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void te(String str) {
        if (this.gnK == null) {
            this.gnK = new a(this, null);
            this.gnK.setPriority(3);
            this.gnK.execute(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, p, p> {
        private com.baidu.tbadk.core.util.z Ob;

        private a() {
        }

        /* synthetic */ a(p pVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: K */
        public p doInBackground(Object... objArr) {
            String obj = objArr[0].toString();
            this.Ob = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/frs/toplist");
            this.Ob.n("kw", obj);
            String uy = this.Ob.uy();
            if (!this.Ob.uW().vS().oH()) {
                return null;
            }
            p pVar = new p(p.this.gnM);
            pVar.parserJson(uy);
            return pVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(p pVar) {
            super.onPostExecute(pVar);
            p.this.gnK = null;
            p.this.mLoadDataCallBack.g(pVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            p.this.gnK = null;
            if (this.Ob != null) {
                this.Ob.eg();
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
                            com.baidu.tbadk.core.data.bk bkVar = new com.baidu.tbadk.core.data.bk();
                            bkVar.parserJson(jSONObject2);
                            this.gnL.add(bkVar);
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
        if (this.gnK != null) {
            this.gnK.cancel();
            return true;
        }
        return true;
    }
}
