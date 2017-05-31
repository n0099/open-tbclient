package com.baidu.tieba.write.write;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class FeedBackModel extends BdBaseModel<WriteActivity> {
    private a fZh;
    private ArrayList<com.baidu.tbadk.core.data.bl> fZi;
    private WriteActivity fZj;
    private int mErrCode;

    public FeedBackModel(WriteActivity writeActivity) {
        super(writeActivity.getPageContext());
        this.fZh = null;
        this.fZi = null;
        this.mErrCode = 0;
        this.fZj = writeActivity;
        this.fZi = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<com.baidu.tbadk.core.data.bl> bpv() {
        return this.fZi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void rw(String str) {
        if (this.fZh == null) {
            this.fZh = new a(this, null);
            this.fZh.setPriority(3);
            this.fZh.execute(str);
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
        /* renamed from: D */
        public FeedBackModel doInBackground(Object... objArr) {
            String obj = objArr[0].toString();
            this.mNetWork = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/frs/toplist");
            this.mNetWork.n("kw", obj);
            String ug = this.mNetWork.ug();
            if (!this.mNetWork.uF().vB().isRequestSuccess()) {
                return null;
            }
            FeedBackModel feedBackModel = new FeedBackModel(FeedBackModel.this.fZj);
            feedBackModel.parserJson(ug);
            return feedBackModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FeedBackModel feedBackModel) {
            super.onPostExecute(feedBackModel);
            FeedBackModel.this.fZh = null;
            FeedBackModel.this.mLoadDataCallBack.g(feedBackModel);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            FeedBackModel.this.fZh = null;
            if (this.mNetWork != null) {
                this.mNetWork.fs();
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
                            com.baidu.tbadk.core.data.bl blVar = new com.baidu.tbadk.core.data.bl();
                            blVar.parserJson(jSONObject2);
                            this.fZi.add(blVar);
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
        if (this.fZh != null) {
            this.fZh.cancel();
            return true;
        }
        return true;
    }
}
