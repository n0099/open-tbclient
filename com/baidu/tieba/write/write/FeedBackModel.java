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
    private TbPageContext ceu;
    private a jSH;
    private ArrayList<bh> jSI;
    private int mErrCode;

    public FeedBackModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jSH = null;
        this.jSI = null;
        this.mErrCode = 0;
        this.ceu = tbPageContext;
        this.jSI = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<bh> cze() {
        return this.jSI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void FN(String str) {
        if (this.jSH == null) {
            this.jSH = new a();
            this.jSH.setPriority(3);
            this.jSH.execute(str);
        }
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<Object, FeedBackModel, FeedBackModel> {
        private x bUY;

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public FeedBackModel doInBackground(Object... objArr) {
            String obj = objArr[0].toString();
            this.bUY = new x(TbConfig.SERVER_ADDRESS + Config.FRS_TOP_LIST);
            this.bUY.addPostData("kw", obj);
            String postNetData = this.bUY.postNetData();
            if (!this.bUY.amp().amQ().isRequestSuccess()) {
                return null;
            }
            FeedBackModel feedBackModel = new FeedBackModel(FeedBackModel.this.ceu);
            feedBackModel.parserJson(postNetData);
            return feedBackModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FeedBackModel feedBackModel) {
            super.onPostExecute(feedBackModel);
            FeedBackModel.this.jSH = null;
            FeedBackModel.this.mLoadDataCallBack.callback(feedBackModel);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            FeedBackModel.this.jSH = null;
            if (this.bUY != null) {
                this.bUY.cancelNetConnect();
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
                            this.jSI.add(bhVar);
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
        if (this.jSH != null) {
            this.jSH.cancel();
            return true;
        }
        return true;
    }
}
