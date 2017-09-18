package com.baidu.tieba.write.write;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FeedBackModel extends BdBaseModel<WriteActivity> {
    private a gGD;
    private ArrayList<bj> gGE;
    private WriteActivity gGF;
    private int mErrCode;

    public FeedBackModel(WriteActivity writeActivity) {
        super(writeActivity.getPageContext());
        this.gGD = null;
        this.gGE = null;
        this.mErrCode = 0;
        this.gGF = writeActivity;
        this.gGE = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<bj> bzI() {
        return this.gGE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tk(String str) {
        if (this.gGD == null) {
            this.gGD = new a();
            this.gGD.setPriority(3);
            this.gGD.execute(str);
        }
    }

    /* loaded from: classes2.dex */
    private class a extends BdAsyncTask<Object, FeedBackModel, FeedBackModel> {
        private x mNetWork;

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public FeedBackModel doInBackground(Object... objArr) {
            String obj = objArr[0].toString();
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + "c/f/frs/toplist");
            this.mNetWork.n("kw", obj);
            String uM = this.mNetWork.uM();
            if (!this.mNetWork.vj().wg().isRequestSuccess()) {
                return null;
            }
            FeedBackModel feedBackModel = new FeedBackModel(FeedBackModel.this.gGF);
            feedBackModel.parserJson(uM);
            return feedBackModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FeedBackModel feedBackModel) {
            super.onPostExecute(feedBackModel);
            FeedBackModel.this.gGD = null;
            FeedBackModel.this.mLoadDataCallBack.f(feedBackModel);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            FeedBackModel.this.gGD = null;
            if (this.mNetWork != null) {
                this.mNetWork.fp();
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
                this.mErrCode = jSONObject.optInt("error_code", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            bj bjVar = new bj();
                            bjVar.parserJson(jSONObject2);
                            this.gGE.add(bjVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.gGD != null) {
            this.gGD.cancel();
            return true;
        }
        return true;
    }
}
