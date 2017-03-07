package com.baidu.tieba.write.write;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class FeedBackModel extends BdBaseModel<WriteActivity> {
    private a fPb;
    private ArrayList<com.baidu.tbadk.core.data.bj> fPc;
    private WriteActivity fPd;
    private int mErrCode;

    public FeedBackModel(WriteActivity writeActivity) {
        super(writeActivity.getPageContext());
        this.fPb = null;
        this.fPc = null;
        this.mErrCode = 0;
        this.fPd = writeActivity;
        this.fPc = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<com.baidu.tbadk.core.data.bj> bok() {
        return this.fPc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void qS(String str) {
        if (this.fPb == null) {
            this.fPb = new a(this, null);
            this.fPb.setPriority(3);
            this.fPb.execute(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, FeedBackModel, FeedBackModel> {
        private com.baidu.tbadk.core.util.z mNetWork;

        private a() {
        }

        /* synthetic */ a(FeedBackModel feedBackModel, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public FeedBackModel doInBackground(Object... objArr) {
            String obj = objArr[0].toString();
            this.mNetWork = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/frs/toplist");
            this.mNetWork.n("kw", obj);
            String uB = this.mNetWork.uB();
            if (!this.mNetWork.uZ().vT().isRequestSuccess()) {
                return null;
            }
            FeedBackModel feedBackModel = new FeedBackModel(FeedBackModel.this.fPd);
            feedBackModel.parserJson(uB);
            return feedBackModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FeedBackModel feedBackModel) {
            super.onPostExecute(feedBackModel);
            FeedBackModel.this.fPb = null;
            FeedBackModel.this.mLoadDataCallBack.g(feedBackModel);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            FeedBackModel.this.fPb = null;
            if (this.mNetWork != null) {
                this.mNetWork.fm();
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
                            com.baidu.tbadk.core.data.bj bjVar = new com.baidu.tbadk.core.data.bj();
                            bjVar.parserJson(jSONObject2);
                            this.fPc.add(bjVar);
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
        if (this.fPb != null) {
            this.fPb.cancel();
            return true;
        }
        return true;
    }
}
