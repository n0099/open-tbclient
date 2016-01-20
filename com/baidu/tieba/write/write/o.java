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
    private a dWX;
    private ArrayList<com.baidu.tbadk.core.data.z> dWY;
    private WriteActivity dWZ;
    private int mErrCode;

    public o(WriteActivity writeActivity) {
        super(writeActivity.getPageContext());
        this.dWX = null;
        this.dWY = null;
        this.mErrCode = 0;
        this.dWZ = writeActivity;
        this.dWY = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<com.baidu.tbadk.core.data.z> aLD() {
        return this.dWY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nt(String str) {
        if (this.dWX == null) {
            this.dWX = new a(this, null);
            this.dWX.setPriority(3);
            this.dWX.execute(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, o, o> {
        private com.baidu.tbadk.core.util.ab Ua;

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
            this.Ua = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/frs/toplist");
            this.Ua.o("kw", obj);
            String tV = this.Ua.tV();
            if (!this.Ua.uw().vq().qO()) {
                return null;
            }
            o oVar = new o(o.this.dWZ);
            oVar.parserJson(tV);
            return oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(o oVar) {
            super.onPostExecute(oVar);
            o.this.dWX = null;
            o.this.mLoadDataCallBack.d(oVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            o.this.dWX = null;
            if (this.Ua != null) {
                this.Ua.gL();
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
                            com.baidu.tbadk.core.data.z zVar = new com.baidu.tbadk.core.data.z();
                            zVar.parserJson(jSONObject2);
                            this.dWY.add(zVar);
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
        if (this.dWX != null) {
            this.dWX.cancel();
            return true;
        }
        return true;
    }
}
