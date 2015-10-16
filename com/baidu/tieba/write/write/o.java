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
    private a doG;
    private ArrayList<com.baidu.tbadk.core.data.w> doH;
    private WriteActivity doI;
    private int mErrCode;

    public o(WriteActivity writeActivity) {
        super(writeActivity.getPageContext());
        this.doG = null;
        this.doH = null;
        this.mErrCode = 0;
        this.doI = writeActivity;
        this.doH = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<com.baidu.tbadk.core.data.w> aCX() {
        return this.doH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mv(String str) {
        if (this.doG == null) {
            this.doG = new a(this, null);
            this.doG.setPriority(3);
            this.doG.execute(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, o, o> {
        private com.baidu.tbadk.core.util.w Ti;

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
            this.Ti = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/frs/toplist");
            this.Ti.o("kw", obj);
            String tG = this.Ti.tG();
            if (!this.Ti.uh().uZ().qV()) {
                return null;
            }
            o oVar = new o(o.this.doI);
            oVar.parserJson(tG);
            return oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(o oVar) {
            super.onPostExecute(oVar);
            o.this.doG = null;
            o.this.mLoadDataCallBack.d(oVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            o.this.doG = null;
            if (this.Ti != null) {
                this.Ti.gJ();
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
                            this.doH.add(wVar);
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
        if (this.doG != null) {
            this.doG.cancel();
            return true;
        }
        return true;
    }
}
