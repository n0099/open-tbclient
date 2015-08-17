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
    private a cTs;
    private ArrayList<com.baidu.tbadk.core.data.v> cTt;
    private WriteActivity cTu;
    private int mErrCode;

    public o(WriteActivity writeActivity) {
        super(writeActivity.getPageContext());
        this.cTs = null;
        this.cTt = null;
        this.mErrCode = 0;
        this.cTu = writeActivity;
        this.cTt = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<com.baidu.tbadk.core.data.v> auJ() {
        return this.cTt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ld(String str) {
        if (this.cTs == null) {
            this.cTs = new a(this, null);
            this.cTs.setPriority(3);
            this.cTs.execute(str);
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Object, o, o> {
        private com.baidu.tbadk.core.util.v Tu;

        private a() {
        }

        /* synthetic */ a(o oVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public o doInBackground(Object... objArr) {
            String obj = objArr[0].toString();
            this.Tu = new com.baidu.tbadk.core.util.v(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/frs/toplist");
            this.Tu.o("kw", obj);
            String tD = this.Tu.tD();
            if (!this.Tu.ue().uW().rb()) {
                return null;
            }
            o oVar = new o(o.this.cTu);
            oVar.parserJson(tD);
            return oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(o oVar) {
            super.onPostExecute(oVar);
            o.this.cTs = null;
            o.this.mLoadDataCallBack.d(oVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            o.this.cTs = null;
            if (this.Tu != null) {
                this.Tu.gM();
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
                            com.baidu.tbadk.core.data.v vVar = new com.baidu.tbadk.core.data.v();
                            vVar.parserJson(jSONObject2);
                            this.cTt.add(vVar);
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
        if (this.cTs != null) {
            this.cTs.cancel();
            return true;
        }
        return true;
    }
}
