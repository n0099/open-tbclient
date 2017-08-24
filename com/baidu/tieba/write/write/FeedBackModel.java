package com.baidu.tieba.write.write;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class FeedBackModel extends BdBaseModel<WriteActivity> {
    private a gHf;
    private ArrayList<bl> gHg;
    private WriteActivity gHh;
    private int mErrCode;

    public FeedBackModel(WriteActivity writeActivity) {
        super(writeActivity.getPageContext());
        this.gHf = null;
        this.gHg = null;
        this.mErrCode = 0;
        this.gHh = writeActivity;
        this.gHg = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<bl> bAh() {
        return this.gHg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void to(String str) {
        if (this.gHf == null) {
            this.gHf = new a();
            this.gHf.setPriority(3);
            this.gHf.execute(str);
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Object, FeedBackModel, FeedBackModel> {
        private w mNetWork;

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public FeedBackModel doInBackground(Object... objArr) {
            String obj = objArr[0].toString();
            this.mNetWork = new w(TbConfig.SERVER_ADDRESS + "c/f/frs/toplist");
            this.mNetWork.n("kw", obj);
            String uP = this.mNetWork.uP();
            if (!this.mNetWork.vm().wj().isRequestSuccess()) {
                return null;
            }
            FeedBackModel feedBackModel = new FeedBackModel(FeedBackModel.this.gHh);
            feedBackModel.parserJson(uP);
            return feedBackModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FeedBackModel feedBackModel) {
            super.onPostExecute(feedBackModel);
            FeedBackModel.this.gHf = null;
            FeedBackModel.this.mLoadDataCallBack.g(feedBackModel);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            FeedBackModel.this.gHf = null;
            if (this.mNetWork != null) {
                this.mNetWork.fA();
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
                            bl blVar = new bl();
                            blVar.parserJson(jSONObject2);
                            this.gHg.add(blVar);
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
        if (this.gHf != null) {
            this.gHf.cancel();
            return true;
        }
        return true;
    }
}
