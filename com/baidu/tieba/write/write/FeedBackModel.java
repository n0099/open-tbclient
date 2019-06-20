package com.baidu.tieba.write.write;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FeedBackModel extends BdBaseModel<TbPageContext> {
    private a jKX;
    private ArrayList<bg> jKY;
    private TbPageContext mContext;
    private int mErrCode;

    public FeedBackModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jKX = null;
        this.jKY = null;
        this.mErrCode = 0;
        this.mContext = tbPageContext;
        this.jKY = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<bg> cyp() {
        return this.jKY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getErrCode() {
        return this.mErrCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Gb(String str) {
        if (this.jKX == null) {
            this.jKX = new a();
            this.jKX.setPriority(3);
            this.jKX.execute(str);
        }
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<Object, FeedBackModel, FeedBackModel> {
        private x mNetWork;

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: K */
        public FeedBackModel doInBackground(Object... objArr) {
            String obj = objArr[0].toString();
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + "c/f/frs/toplist");
            this.mNetWork.o("kw", obj);
            String ahe = this.mNetWork.ahe();
            if (!this.mNetWork.ahC().aiC().isRequestSuccess()) {
                return null;
            }
            FeedBackModel feedBackModel = new FeedBackModel(FeedBackModel.this.mContext);
            feedBackModel.parserJson(ahe);
            return feedBackModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FeedBackModel feedBackModel) {
            super.onPostExecute(feedBackModel);
            FeedBackModel.this.jKX = null;
            FeedBackModel.this.mLoadDataCallBack.m(feedBackModel);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            FeedBackModel.this.jKX = null;
            if (this.mNetWork != null) {
                this.mNetWork.ia();
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
                            bg bgVar = new bg();
                            bgVar.parserJson(jSONObject2);
                            this.jKY.add(bgVar);
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
        if (this.jKX != null) {
            this.jKX.cancel();
            return true;
        }
        return true;
    }
}
