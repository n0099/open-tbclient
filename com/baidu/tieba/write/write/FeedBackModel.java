package com.baidu.tieba.write.write;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.h0.r.q.a2;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class FeedBackModel extends BdBaseModel<TbPageContext> {

    /* renamed from: e  reason: collision with root package name */
    public b f22418e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<a2> f22419f;

    /* renamed from: g  reason: collision with root package name */
    public int f22420g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext f22421h;

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Object, FeedBackModel, FeedBackModel> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f22422a;

        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FeedBackModel doInBackground(Object... objArr) {
            String obj = objArr[0].toString();
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/frs/toplist");
            this.f22422a = netWork;
            netWork.addPostData(TiebaStatic.Params.H5_FORUM_NAME, obj);
            String postNetData = this.f22422a.postNetData();
            if (this.f22422a.getNetContext().getResponse().isRequestSuccess()) {
                FeedBackModel feedBackModel = new FeedBackModel(FeedBackModel.this.f22421h);
                feedBackModel.parserJson(postNetData);
                return feedBackModel;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FeedBackModel feedBackModel) {
            super.onPostExecute(feedBackModel);
            FeedBackModel.this.f22418e = null;
            FeedBackModel.this.mLoadDataCallBack.c(feedBackModel);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            FeedBackModel.this.f22418e = null;
            NetWork netWork = this.f22422a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
        }
    }

    public FeedBackModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f22418e = null;
        this.f22419f = null;
        this.f22420g = 0;
        this.f22421h = tbPageContext;
        this.f22419f = new ArrayList<>();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f22418e;
        if (bVar != null) {
            bVar.cancel();
            return true;
        }
        return true;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void v(String str) {
        if (this.f22418e == null) {
            b bVar = new b();
            this.f22418e = bVar;
            bVar.setPriority(3);
            this.f22418e.execute(str);
        }
    }

    public int w() {
        return this.f22420g;
    }

    public ArrayList<a2> x() {
        return this.f22419f;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f22420g = jSONObject.optInt("error_code", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a2 a2Var = new a2();
                        a2Var.P2(jSONObject2);
                        this.f22419f.add(a2Var);
                    }
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
