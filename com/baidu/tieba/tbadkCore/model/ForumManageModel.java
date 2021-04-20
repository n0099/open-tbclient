package com.baidu.tieba.tbadkCore.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.l0;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ForumManageModel extends BdBaseModel {
    public static final int CANCEL_GOOD = 3;
    public static final int CANCEL_TOP = 5;
    public static final int COMMIT_GOOD = 2;
    public static final int COMMIT_TOP = 4;
    public static final int DEL_POST = 0;
    public static final int DEL_TYPE_FLOOR = 2;
    public static final int DEL_TYPE_POST = 1;
    public static final int DEL_TYPE_STORY = 3;
    public static final int DEL_TYPE_THREAD = 0;
    public static final int ERROR_CODE_PHOTO_LIVE_FORUM_LOCK = 224014;
    public static final int FORBID_USER = 1;
    public static final int GET_GOOD_LIST = 6;
    public static final int INTENT_TYPE_NONE = -1;
    public static final BdUniqueId UNIQUE_ID_DEL_POST_TASK = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public a f21053e;

    /* renamed from: f  reason: collision with root package name */
    public c f21054f;

    /* renamed from: g  reason: collision with root package name */
    public f f21055g;

    /* renamed from: h  reason: collision with root package name */
    public String f21056h;
    public boolean i;
    public String j;
    public int k;
    public int l;
    public String m;
    public String n;
    public int o;

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f21057a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f21058b;

        /* renamed from: c  reason: collision with root package name */
        public String f21059c;

        /* renamed from: d  reason: collision with root package name */
        public String f21060d;

        /* renamed from: e  reason: collision with root package name */
        public String f21061e;

        /* renamed from: f  reason: collision with root package name */
        public int f21062f;

        /* renamed from: g  reason: collision with root package name */
        public int f21063g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f21064h;
        public String i;
        public BaijiahaoData j;

        public a(String str, String str2, String str3, String str4, int i, int i2, boolean z, BaijiahaoData baijiahaoData) {
            this.f21058b = str;
            this.f21059c = str2;
            this.f21060d = str3;
            this.f21061e = str4;
            this.f21062f = i;
            this.f21063g = i2;
            this.f21064h = z;
            this.i = ForumManageModel.this.J();
            this.j = baijiahaoData;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NetWork netWork = this.f21057a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            ForumManageModel.this.f21053e = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.c(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            int i = this.f21062f;
            if (i != 0 && i != 3) {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            }
            NetWork netWork = new NetWork(str);
            this.f21057a = netWork;
            netWork.addPostData("fid", this.f21058b);
            this.f21057a.addPostData("word", this.f21059c);
            this.f21057a.addPostData("z", this.f21060d);
            String str3 = this.i;
            if (str3 != null) {
                this.f21057a.addPostData("reason", str3);
            }
            int i2 = this.f21062f;
            if (i2 == 0) {
                if (this.f21063g == 0) {
                    this.f21057a.addPostData("delete_my_thread", "1");
                }
            } else if (i2 == 1) {
                this.f21057a.addPostData("pid", this.f21061e);
                this.f21057a.addPostData("isfloor", "0");
                this.f21057a.addPostData(UserAccountActionItem.KEY_SRC, "1");
                if (this.f21063g == 0 && this.f21064h) {
                    this.f21057a.addPostData("delete_my_post", "1");
                }
            } else if (i2 == 2) {
                this.f21057a.addPostData("pid", this.f21061e);
                this.f21057a.addPostData("isfloor", "1");
                this.f21057a.addPostData(UserAccountActionItem.KEY_SRC, "3");
                if (this.f21063g == 0 && this.f21064h) {
                    this.f21057a.addPostData("delete_my_post", "1");
                }
            } else if (i2 == 3) {
                this.f21057a.addPostData("delete_my_thread", "1");
                this.f21057a.addPostData("is_story", "1");
            }
            if (this.f21063g == 0 && !this.f21064h) {
                this.f21057a.addPostData("is_vipdel", "1");
            } else {
                this.f21057a.addPostData("is_vipdel", "0");
            }
            if (this.f21062f == 0 && ForumManageModel.this.i) {
                ForumManageModel.this.i = false;
                this.f21057a.addPostData("ori_ugc_nid", ForumManageModel.this.j);
                this.f21057a.addPostData("thread_type", String.valueOf(ForumManageModel.this.k));
                this.f21057a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(ForumManageModel.this.l));
                this.f21057a.addPostData("owner_uid", ForumManageModel.this.m);
                this.f21057a.addPostData("ori_ugc_vid", ForumManageModel.this.n);
                this.f21057a.addPostData("video_type", String.valueOf(ForumManageModel.this.o));
            } else {
                BaijiahaoData baijiahaoData = this.j;
                if (baijiahaoData != null) {
                    this.f21057a.addPostData("ori_ugc_nid", baijiahaoData.oriUgcNid);
                    this.f21057a.addPostData("ori_ugc_tid", this.j.oriUgcTid);
                    this.f21057a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.j.oriUgcType));
                    this.f21057a.addPostData("ori_ugc_vid", this.j.oriUgcVid);
                    this.f21057a.addPostData("owner_uid", TbadkCoreApplication.getCurrentAccount());
                }
            }
            this.f21057a.getNetContext().getRequest().mIsNeedTbs = true;
            this.f21057a.postNetData();
            if (this.f21057a.getNetContext().getResponse().isRequestSuccess()) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.f21053e = null;
            if (this.f21057a == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.c(null);
                return;
            }
            b bVar = new b(ForumManageModel.this);
            bVar.f21068d = this.f21062f;
            bVar.f21071g = this.f21061e;
            bVar.f21070f = this.f21064h;
            bVar.f21069e = this.f21063g;
            bVar.f21066b = this.f21057a.getErrorString();
            bVar.f21067c = this.f21057a.getServerErrorCode();
            bVar.f21065a = bool.booleanValue();
            ForumManageModel.this.mLoadDataCallBack.c(bVar);
        }
    }

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f21065a;

        /* renamed from: b  reason: collision with root package name */
        public String f21066b;

        /* renamed from: c  reason: collision with root package name */
        public int f21067c;

        /* renamed from: d  reason: collision with root package name */
        public int f21068d;

        /* renamed from: e  reason: collision with root package name */
        public int f21069e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f21070f;

        /* renamed from: g  reason: collision with root package name */
        public String f21071g;

        public b(ForumManageModel forumManageModel) {
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
    }

    /* loaded from: classes5.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f21072a;

        /* renamed from: b  reason: collision with root package name */
        public String f21073b;
    }

    /* loaded from: classes5.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public String f21074a;

        /* renamed from: b  reason: collision with root package name */
        public String f21075b;

        /* renamed from: c  reason: collision with root package name */
        public String f21076c;

        /* renamed from: d  reason: collision with root package name */
        public int f21077d;
    }

    /* loaded from: classes5.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f21078a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f21079b;

        /* renamed from: c  reason: collision with root package name */
        public String f21080c;

        /* renamed from: d  reason: collision with root package name */
        public String f21081d;

        /* renamed from: e  reason: collision with root package name */
        public int f21082e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<l0> f21083f;

        /* renamed from: g  reason: collision with root package name */
        public String f21084g;

        public f(String str, String str2, String str3, int i, String str4) {
            this.f21083f = null;
            this.f21084g = null;
            this.f21079b = str;
            this.f21080c = str2;
            this.f21081d = str3;
            this.f21082e = i;
            this.f21084g = str4;
            this.f21083f = new ArrayList<>();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NetWork netWork = this.f21078a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            ForumManageModel.this.f21055g = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.c(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            NetWork netWork = new NetWork(strArr[0]);
            this.f21078a = netWork;
            netWork.addPostData("word", this.f21080c);
            if (this.f21082e != 6) {
                this.f21078a.addPostData("fid", this.f21079b);
                this.f21078a.addPostData("z", this.f21081d);
                int i = this.f21082e;
                if (i == 4) {
                    this.f21078a.addPostData("ntn", "set");
                } else if (i == 5) {
                    this.f21078a.addPostData("ntn", "");
                } else if (i == 2) {
                    this.f21078a.addPostData("ntn", "set");
                    this.f21078a.addPostData(IAdRequestParam.CELL_ID, this.f21084g);
                } else {
                    this.f21078a.addPostData("ntn", "");
                }
                this.f21078a.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            this.f21078a.getNetContext().getRequest().mIsNeedTbs = true;
            String postNetData = this.f21078a.postNetData();
            if (this.f21078a.getNetContext().getResponse().isRequestSuccess()) {
                if (this.f21082e == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(postNetData).optJSONArray("cates");
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            l0 l0Var = new l0();
                            l0Var.c(optJSONArray.optJSONObject(i2));
                            this.f21083f.add(l0Var);
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                        return Boolean.FALSE;
                    }
                }
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((f) bool);
            ForumManageModel.this.f21055g = null;
            if (this.f21078a == null) {
                ForumManageModel.this.mLoadDataCallBack.c(null);
                return;
            }
            g gVar = new g(ForumManageModel.this);
            gVar.f21086a = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.f21082e == 6) {
                    gVar.f21088c = this.f21083f;
                }
            } else {
                gVar.f21087b = this.f21078a.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.c(gVar);
        }
    }

    /* loaded from: classes5.dex */
    public class g {

        /* renamed from: a  reason: collision with root package name */
        public boolean f21086a;

        /* renamed from: b  reason: collision with root package name */
        public String f21087b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<l0> f21088c;

        public g(ForumManageModel forumManageModel) {
        }
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f21053e = null;
        this.f21054f = null;
        this.f21055g = null;
        this.i = false;
    }

    public void I() {
        a aVar = this.f21053e;
        if (aVar != null) {
            aVar.cancel();
            this.f21053e = null;
        }
        c cVar = this.f21054f;
        if (cVar != null) {
            cVar.cancel();
            this.f21054f = null;
        }
        f fVar = this.f21055g;
        if (fVar != null) {
            fVar.cancel();
            this.f21055g = null;
        }
    }

    public String J() {
        return this.f21056h;
    }

    public boolean K() {
        return (this.f21053e == null && this.f21054f == null && this.f21055g == null) ? false : true;
    }

    public void L(a2 a2Var) {
        if (a2Var == null || a2Var.V() == null) {
            return;
        }
        this.i = true;
        this.j = a2Var.V().oriUgcNid;
        this.l = a2Var.V().oriUgcType;
        this.n = a2Var.V().oriUgcVid;
        this.k = a2Var.Z;
        this.m = TbadkCoreApplication.getCurrentAccount();
        this.o = a2Var.u1() != null ? a2Var.u1().video_type.intValue() : 0;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public void M(String str) {
        this.f21056h = str;
    }

    public void N(String str, String str2, String str3, String str4, int i, int i2, boolean z, BaijiahaoData baijiahaoData) {
        a aVar = this.f21053e;
        if (aVar != null) {
            aVar.cancel();
            this.f21053e = null;
        }
        this.mLoadDataMode = 0;
        a aVar2 = new a(str, str2, str3, str4, i, i2, z, baijiahaoData);
        this.f21053e = aVar2;
        aVar2.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.f21053e.setPriority(2);
        this.f21053e.execute(new String[0]);
    }

    public void O(String str, String str2, String str3, int i, String str4) {
        String str5;
        f fVar = this.f21055g;
        if (fVar != null) {
            fVar.cancel();
            this.f21055g = null;
        }
        this.mLoadDataMode = i;
        f fVar2 = new f(str, str2, str3, i, str4);
        this.f21055g = fVar2;
        fVar2.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i != 2 && i != 3) {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        }
        this.f21055g.execute(str5);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        I();
        return false;
    }

    public ForumManageModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.f21053e = null;
        this.f21054f = null;
        this.f21055g = null;
        this.i = false;
    }
}
