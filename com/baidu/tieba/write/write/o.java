package com.baidu.tieba.write.write;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.e<WriteActivity> {
    private a dqv;
    private ArrayList<com.baidu.tbadk.core.data.w> dqw;
    private WriteActivity dqx;
    private int mErrCode;

    public o(WriteActivity writeActivity) {
        super(writeActivity.getPageContext());
        this.dqv = null;
        this.dqw = null;
        this.mErrCode = 0;
        this.dqx = writeActivity;
        this.dqw = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<com.baidu.tbadk.core.data.w> aDL() {
        return this.dqw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mz(String str) {
        if (this.dqv == null) {
            this.dqv = new a(this, null);
            this.dqv.setPriority(3);
            this.dqv.execute(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, o, o> {
        private com.baidu.tbadk.core.util.w Tj;

        private a() {
        }

        /* synthetic */ a(o oVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public o doInBackground(Object... objArr) {
            String obj = objArr[0].toString();
            this.Tj = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/frs/toplist");
            this.Tj.o("kw", obj);
            String tG = this.Tj.tG();
            if (!this.Tj.uh().va().qT()) {
                return null;
            }
            o oVar = new o(o.this.dqx);
            oVar.parserJson(tG);
            return oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(o oVar) {
            super.onPostExecute(oVar);
            o.this.dqv = null;
            o.this.mLoadDataCallBack.d(oVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            o.this.dqv = null;
            if (this.Tj != null) {
                this.Tj.gJ();
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
                            com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                            wVar.parserJson(jSONObject2);
                            this.dqw.add(wVar);
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
        if (this.dqv != null) {
            this.dqv.cancel();
            return true;
        }
        return true;
    }
}
