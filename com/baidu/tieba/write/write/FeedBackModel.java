package com.baidu.tieba.write.write;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class FeedBackModel extends BdBaseModel<TbPageContext> {
    private TbPageContext cVv;
    private a kTx;
    private ArrayList<bj> kTy;
    private int mErrCode;

    public FeedBackModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kTx = null;
        this.kTy = null;
        this.mErrCode = 0;
        this.cVv = tbPageContext;
        this.kTy = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<bj> cVX() {
        return this.kTy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Lc(String str) {
        if (this.kTx == null) {
            this.kTx = new a();
            this.kTx.setPriority(3);
            this.kTx.execute(str);
        }
    }

    /* loaded from: classes13.dex */
    private class a extends BdAsyncTask<Object, FeedBackModel, FeedBackModel> {
        private x cLQ;

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public FeedBackModel doInBackground(Object... objArr) {
            String obj = objArr[0].toString();
            this.cLQ = new x(TbConfig.SERVER_ADDRESS + Config.FRS_TOP_LIST);
            this.cLQ.addPostData("kw", obj);
            String postNetData = this.cLQ.postNetData();
            if (!this.cLQ.aGk().aGM().isRequestSuccess()) {
                return null;
            }
            FeedBackModel feedBackModel = new FeedBackModel(FeedBackModel.this.cVv);
            feedBackModel.parserJson(postNetData);
            return feedBackModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FeedBackModel feedBackModel) {
            super.onPostExecute(feedBackModel);
            FeedBackModel.this.kTx = null;
            FeedBackModel.this.mLoadDataCallBack.callback(feedBackModel);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            FeedBackModel.this.kTx = null;
            if (this.cLQ != null) {
                this.cLQ.cancelNetConnect();
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
                            this.kTy.add(bjVar);
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
        if (this.kTx != null) {
            this.kTx.cancel();
            return true;
        }
        return true;
    }
}
