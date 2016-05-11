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
    private WriteActivity fcA;
    private a fcy;
    private ArrayList<com.baidu.tbadk.core.data.ax> fcz;
    private int mErrCode;

    public p(WriteActivity writeActivity) {
        super(writeActivity.getPageContext());
        this.fcy = null;
        this.fcz = null;
        this.mErrCode = 0;
        this.fcA = writeActivity;
        this.fcz = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<com.baidu.tbadk.core.data.ax> bdn() {
        return this.fcz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pn(String str) {
        if (this.fcy == null) {
            this.fcy = new a(this, null);
            this.fcy.setPriority(3);
            this.fcy.execute(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, p, p> {
        private com.baidu.tbadk.core.util.ab LL;

        private a() {
        }

        /* synthetic */ a(p pVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public p doInBackground(Object... objArr) {
            String obj = objArr[0].toString();
            this.LL = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/frs/toplist");
            this.LL.n("kw", obj);
            String tc = this.LL.tc();
            if (!this.LL.tA().uv().nZ()) {
                return null;
            }
            p pVar = new p(p.this.fcA);
            pVar.parserJson(tc);
            return pVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(p pVar) {
            super.onPostExecute(pVar);
            p.this.fcy = null;
            p.this.mLoadDataCallBack.d(pVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            p.this.fcy = null;
            if (this.LL != null) {
                this.LL.dl();
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
                            com.baidu.tbadk.core.data.ax axVar = new com.baidu.tbadk.core.data.ax();
                            axVar.parserJson(jSONObject2);
                            this.fcz.add(axVar);
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
        if (this.fcy != null) {
            this.fcy.cancel();
            return true;
        }
        return true;
    }
}
