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
/* loaded from: classes11.dex */
public class FeedBackModel extends BdBaseModel<TbPageContext> {
    private TbPageContext cRe;
    private a kQV;
    private ArrayList<bj> kQW;
    private int mErrCode;

    public FeedBackModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kQV = null;
        this.kQW = null;
        this.mErrCode = 0;
        this.cRe = tbPageContext;
        this.kQW = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<bj> cUh() {
        return this.kQW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void KP(String str) {
        if (this.kQV == null) {
            this.kQV = new a();
            this.kQV.setPriority(3);
            this.kQV.execute(str);
        }
    }

    /* loaded from: classes11.dex */
    private class a extends BdAsyncTask<Object, FeedBackModel, FeedBackModel> {
        private x cHA;

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public FeedBackModel doInBackground(Object... objArr) {
            String obj = objArr[0].toString();
            this.cHA = new x(TbConfig.SERVER_ADDRESS + Config.FRS_TOP_LIST);
            this.cHA.addPostData("kw", obj);
            String postNetData = this.cHA.postNetData();
            if (!this.cHA.aDU().aEv().isRequestSuccess()) {
                return null;
            }
            FeedBackModel feedBackModel = new FeedBackModel(FeedBackModel.this.cRe);
            feedBackModel.parserJson(postNetData);
            return feedBackModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FeedBackModel feedBackModel) {
            super.onPostExecute(feedBackModel);
            FeedBackModel.this.kQV = null;
            FeedBackModel.this.mLoadDataCallBack.callback(feedBackModel);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            FeedBackModel.this.kQV = null;
            if (this.cHA != null) {
                this.cHA.cancelNetConnect();
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
                            this.kQW.add(bjVar);
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
        if (this.kQV != null) {
            this.kQV.cancel();
            return true;
        }
        return true;
    }
}
