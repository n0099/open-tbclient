package com.baidu.tieba.write.write;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FeedBackModel extends BdBaseModel<TbPageContext> {
    private TbPageContext cfl;
    private a jTy;
    private ArrayList<bh> jTz;
    private int mErrCode;

    public FeedBackModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jTy = null;
        this.jTz = null;
        this.mErrCode = 0;
        this.cfl = tbPageContext;
        this.jTz = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<bh> czg() {
        return this.jTz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void FN(String str) {
        if (this.jTy == null) {
            this.jTy = new a();
            this.jTy.setPriority(3);
            this.jTy.execute(str);
        }
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<Object, FeedBackModel, FeedBackModel> {
        private x bVP;

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public FeedBackModel doInBackground(Object... objArr) {
            String obj = objArr[0].toString();
            this.bVP = new x(TbConfig.SERVER_ADDRESS + Config.FRS_TOP_LIST);
            this.bVP.addPostData("kw", obj);
            String postNetData = this.bVP.postNetData();
            if (!this.bVP.amr().amS().isRequestSuccess()) {
                return null;
            }
            FeedBackModel feedBackModel = new FeedBackModel(FeedBackModel.this.cfl);
            feedBackModel.parserJson(postNetData);
            return feedBackModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FeedBackModel feedBackModel) {
            super.onPostExecute(feedBackModel);
            FeedBackModel.this.jTy = null;
            FeedBackModel.this.mLoadDataCallBack.callback(feedBackModel);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            FeedBackModel.this.jTy = null;
            if (this.bVP != null) {
                this.bVP.cancelNetConnect();
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
                            bh bhVar = new bh();
                            bhVar.parserJson(jSONObject2);
                            this.jTz.add(bhVar);
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
        if (this.jTy != null) {
            this.jTy.cancel();
            return true;
        }
        return true;
    }
}
