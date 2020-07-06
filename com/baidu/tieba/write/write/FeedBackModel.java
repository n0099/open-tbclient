package com.baidu.tieba.write.write;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FeedBackModel extends BdBaseModel<TbPageContext> {
    private TbPageContext dPv;
    private int mErrCode;
    private a msK;
    private ArrayList<bu> msL;

    public FeedBackModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.msK = null;
        this.msL = null;
        this.mErrCode = 0;
        this.dPv = tbPageContext;
        this.msL = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<bu> dsB() {
        return this.msL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Pk(String str) {
        if (this.msK == null) {
            this.msK = new a();
            this.msK.setPriority(3);
            this.msK.execute(str);
        }
    }

    /* loaded from: classes2.dex */
    private class a extends BdAsyncTask<Object, FeedBackModel, FeedBackModel> {
        private y byb;

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: L */
        public FeedBackModel doInBackground(Object... objArr) {
            String obj = objArr[0].toString();
            this.byb = new y(TbConfig.SERVER_ADDRESS + Config.FRS_TOP_LIST);
            this.byb.addPostData("kw", obj);
            String postNetData = this.byb.postNetData();
            if (!this.byb.aWu().aWW().isRequestSuccess()) {
                return null;
            }
            FeedBackModel feedBackModel = new FeedBackModel(FeedBackModel.this.dPv);
            feedBackModel.parserJson(postNetData);
            return feedBackModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FeedBackModel feedBackModel) {
            super.onPostExecute(feedBackModel);
            FeedBackModel.this.msK = null;
            FeedBackModel.this.mLoadDataCallBack.callback(feedBackModel);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            FeedBackModel.this.msK = null;
            if (this.byb != null) {
                this.byb.cancelNetConnect();
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
                            bu buVar = new bu();
                            buVar.parserJson(jSONObject2);
                            this.msL.add(buVar);
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
        if (this.msK != null) {
            this.msK.cancel();
            return true;
        }
        return true;
    }
}
