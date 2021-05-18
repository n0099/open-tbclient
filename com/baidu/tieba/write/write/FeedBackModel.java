package com.baidu.tieba.write.write;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.j0.r.q.a2;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class FeedBackModel extends BdBaseModel<TbPageContext> {

    /* renamed from: e  reason: collision with root package name */
    public b f22044e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<a2> f22045f;

    /* renamed from: g  reason: collision with root package name */
    public int f22046g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext f22047h;

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Object, FeedBackModel, FeedBackModel> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f22048a;

        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FeedBackModel doInBackground(Object... objArr) {
            String obj = objArr[0].toString();
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/frs/toplist");
            this.f22048a = netWork;
            netWork.addPostData(TiebaStatic.Params.H5_FORUM_NAME, obj);
            String postNetData = this.f22048a.postNetData();
            if (this.f22048a.getNetContext().getResponse().isRequestSuccess()) {
                FeedBackModel feedBackModel = new FeedBackModel(FeedBackModel.this.f22047h);
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
            FeedBackModel.this.f22044e = null;
            FeedBackModel.this.mLoadDataCallBack.c(feedBackModel);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            FeedBackModel.this.f22044e = null;
            NetWork netWork = this.f22048a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
        }
    }

    public FeedBackModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f22044e = null;
        this.f22045f = null;
        this.f22046g = 0;
        this.f22047h = tbPageContext;
        this.f22045f = new ArrayList<>();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f22044e;
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
        if (this.f22044e == null) {
            b bVar = new b();
            this.f22044e = bVar;
            bVar.setPriority(3);
            this.f22044e.execute(str);
        }
    }

    public int w() {
        return this.f22046g;
    }

    public ArrayList<a2> x() {
        return this.f22045f;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f22046g = jSONObject.optInt("error_code", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    if (jSONObject2 != null) {
                        a2 a2Var = new a2();
                        a2Var.S2(jSONObject2);
                        this.f22045f.add(a2Var);
                    }
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
