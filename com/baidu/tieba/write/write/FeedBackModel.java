package com.baidu.tieba.write.write;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FeedBackModel extends BdBaseModel<TbPageContext> {
    private a hsR;
    private ArrayList<bd> hsS;
    private TbPageContext mContext;
    private int mErrCode;

    public FeedBackModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hsR = null;
        this.hsS = null;
        this.mErrCode = 0;
        this.mContext = tbPageContext;
        this.hsS = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<bd> bHS() {
        return this.hsS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void vR(String str) {
        if (this.hsR == null) {
            this.hsR = new a();
            this.hsR.setPriority(3);
            this.hsR.execute(str);
        }
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<Object, FeedBackModel, FeedBackModel> {
        private y mNetWork;

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public FeedBackModel doInBackground(Object... objArr) {
            String obj = objArr[0].toString();
            this.mNetWork = new y(TbConfig.SERVER_ADDRESS + "c/f/frs/toplist");
            this.mNetWork.o("kw", obj);
            String yl = this.mNetWork.yl();
            if (!this.mNetWork.yJ().zJ().isRequestSuccess()) {
                return null;
            }
            FeedBackModel feedBackModel = new FeedBackModel(FeedBackModel.this.mContext);
            feedBackModel.parserJson(yl);
            return feedBackModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FeedBackModel feedBackModel) {
            super.onPostExecute(feedBackModel);
            FeedBackModel.this.hsR = null;
            FeedBackModel.this.mLoadDataCallBack.i(feedBackModel);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            FeedBackModel.this.hsR = null;
            if (this.mNetWork != null) {
                this.mNetWork.hN();
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
                            bd bdVar = new bd();
                            bdVar.parserJson(jSONObject2);
                            this.hsS.add(bdVar);
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
        if (this.hsR != null) {
            this.hsR.cancel();
            return true;
        }
        return true;
    }
}
