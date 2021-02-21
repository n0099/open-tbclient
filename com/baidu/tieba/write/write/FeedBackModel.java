package com.baidu.tieba.write.write;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.aa;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class FeedBackModel extends BdBaseModel<TbPageContext> {
    private TbPageContext eUY;
    private int mErrCode;
    private a ojq;
    private ArrayList<cb> ojr;

    public FeedBackModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ojq = null;
        this.ojr = null;
        this.mErrCode = 0;
        this.eUY = tbPageContext;
        this.ojr = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<cb> dXS() {
        return this.ojr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Vx(String str) {
        if (this.ojq == null) {
            this.ojq = new a();
            this.ojq.setPriority(3);
            this.ojq.execute(str);
        }
    }

    /* loaded from: classes8.dex */
    private class a extends BdAsyncTask<Object, FeedBackModel, FeedBackModel> {
        private aa cml;

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: L */
        public FeedBackModel doInBackground(Object... objArr) {
            String obj = objArr[0].toString();
            this.cml = new aa(TbConfig.SERVER_ADDRESS + Config.FRS_TOP_LIST);
            this.cml.addPostData("kw", obj);
            String postNetData = this.cml.postNetData();
            if (!this.cml.bsr().btb().isRequestSuccess()) {
                return null;
            }
            FeedBackModel feedBackModel = new FeedBackModel(FeedBackModel.this.eUY);
            feedBackModel.parserJson(postNetData);
            return feedBackModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FeedBackModel feedBackModel) {
            super.onPostExecute(feedBackModel);
            FeedBackModel.this.ojq = null;
            FeedBackModel.this.mLoadDataCallBack.callback(feedBackModel);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            FeedBackModel.this.ojq = null;
            if (this.cml != null) {
                this.cml.cancelNetConnect();
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
                            cb cbVar = new cb();
                            cbVar.parserJson(jSONObject2);
                            this.ojr.add(cbVar);
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
        if (this.ojq != null) {
            this.ojq.cancel();
            return true;
        }
        return true;
    }
}
