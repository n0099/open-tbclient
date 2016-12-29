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
    private a fCn;
    private ArrayList<com.baidu.tbadk.core.data.bg> fCo;
    private WriteActivity fCp;
    private int mErrCode;

    public p(WriteActivity writeActivity) {
        super(writeActivity.getPageContext());
        this.fCn = null;
        this.fCo = null;
        this.mErrCode = 0;
        this.fCp = writeActivity;
        this.fCo = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<com.baidu.tbadk.core.data.bg> bmZ() {
        return this.fCo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void rr(String str) {
        if (this.fCn == null) {
            this.fCn = new a(this, null);
            this.fCn.setPriority(3);
            this.fCn.execute(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, p, p> {
        private com.baidu.tbadk.core.util.z NX;

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
            this.NX = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/frs/toplist");
            this.NX.n("kw", obj);
            String uk = this.NX.uk();
            if (!this.NX.uI().vC().oH()) {
                return null;
            }
            p pVar = new p(p.this.fCp);
            pVar.parserJson(uk);
            return pVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(p pVar) {
            super.onPostExecute(pVar);
            p.this.fCn = null;
            p.this.mLoadDataCallBack.g(pVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            p.this.fCn = null;
            if (this.NX != null) {
                this.NX.eg();
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
                            com.baidu.tbadk.core.data.bg bgVar = new com.baidu.tbadk.core.data.bg();
                            bgVar.parserJson(jSONObject2);
                            this.fCo.add(bgVar);
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
        if (this.fCn != null) {
            this.fCn.cancel();
            return true;
        }
        return true;
    }
}
