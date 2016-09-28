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
    private a ggg;
    private ArrayList<com.baidu.tbadk.core.data.bi> ggh;
    private WriteActivity ggi;
    private int mErrCode;

    public p(WriteActivity writeActivity) {
        super(writeActivity.getPageContext());
        this.ggg = null;
        this.ggh = null;
        this.mErrCode = 0;
        this.ggi = writeActivity;
        this.ggh = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<com.baidu.tbadk.core.data.bi> btG() {
        return this.ggh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sI(String str) {
        if (this.ggg == null) {
            this.ggg = new a(this, null);
            this.ggg.setPriority(3);
            this.ggg.execute(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, p, p> {
        private com.baidu.tbadk.core.util.ab NY;

        private a() {
        }

        /* synthetic */ a(p pVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public p doInBackground(Object... objArr) {
            String obj = objArr[0].toString();
            this.NY = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/frs/toplist");
            this.NY.n("kw", obj);
            String uu = this.NY.uu();
            if (!this.NY.uS().vO().oF()) {
                return null;
            }
            p pVar = new p(p.this.ggi);
            pVar.parserJson(uu);
            return pVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(p pVar) {
            super.onPostExecute(pVar);
            p.this.ggg = null;
            p.this.mLoadDataCallBack.g(pVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            p.this.ggg = null;
            if (this.NY != null) {
                this.NY.eg();
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
                            com.baidu.tbadk.core.data.bi biVar = new com.baidu.tbadk.core.data.bi();
                            biVar.parserJson(jSONObject2);
                            this.ggh.add(biVar);
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
        if (this.ggg != null) {
            this.ggg.cancel();
            return true;
        }
        return true;
    }
}
