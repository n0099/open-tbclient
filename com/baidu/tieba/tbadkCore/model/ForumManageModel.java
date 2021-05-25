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
import d.a.m0.r.q.a2;
import d.a.m0.r.q.l0;
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
    public a f20811e;

    /* renamed from: f  reason: collision with root package name */
    public c f20812f;

    /* renamed from: g  reason: collision with root package name */
    public f f20813g;

    /* renamed from: h  reason: collision with root package name */
    public String f20814h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20815i;
    public String j;
    public int k;
    public int l;
    public String m;
    public String n;
    public int o;

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f20816a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f20817b;

        /* renamed from: c  reason: collision with root package name */
        public String f20818c;

        /* renamed from: d  reason: collision with root package name */
        public String f20819d;

        /* renamed from: e  reason: collision with root package name */
        public String f20820e;

        /* renamed from: f  reason: collision with root package name */
        public int f20821f;

        /* renamed from: g  reason: collision with root package name */
        public int f20822g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f20823h;

        /* renamed from: i  reason: collision with root package name */
        public String f20824i;
        public BaijiahaoData j;

        public a(String str, String str2, String str3, String str4, int i2, int i3, boolean z, BaijiahaoData baijiahaoData) {
            this.f20817b = str;
            this.f20818c = str2;
            this.f20819d = str3;
            this.f20820e = str4;
            this.f20821f = i2;
            this.f20822g = i3;
            this.f20823h = z;
            this.f20824i = ForumManageModel.this.J();
            this.j = baijiahaoData;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NetWork netWork = this.f20816a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            ForumManageModel.this.f20811e = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.c(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            int i2 = this.f20821f;
            if (i2 != 0 && i2 != 3) {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            }
            NetWork netWork = new NetWork(str);
            this.f20816a = netWork;
            netWork.addPostData("fid", this.f20817b);
            this.f20816a.addPostData("word", this.f20818c);
            this.f20816a.addPostData("z", this.f20819d);
            String str3 = this.f20824i;
            if (str3 != null) {
                this.f20816a.addPostData("reason", str3);
            }
            int i3 = this.f20821f;
            if (i3 == 0) {
                if (this.f20822g == 0) {
                    this.f20816a.addPostData("delete_my_thread", "1");
                }
            } else if (i3 == 1) {
                this.f20816a.addPostData("pid", this.f20820e);
                this.f20816a.addPostData("isfloor", "0");
                this.f20816a.addPostData(UserAccountActionItem.KEY_SRC, "1");
                if (this.f20822g == 0 && this.f20823h) {
                    this.f20816a.addPostData("delete_my_post", "1");
                }
            } else if (i3 == 2) {
                this.f20816a.addPostData("pid", this.f20820e);
                this.f20816a.addPostData("isfloor", "1");
                this.f20816a.addPostData(UserAccountActionItem.KEY_SRC, "3");
                if (this.f20822g == 0 && this.f20823h) {
                    this.f20816a.addPostData("delete_my_post", "1");
                }
            } else if (i3 == 3) {
                this.f20816a.addPostData("delete_my_thread", "1");
                this.f20816a.addPostData("is_story", "1");
            }
            if (this.f20822g == 0 && !this.f20823h) {
                this.f20816a.addPostData("is_vipdel", "1");
            } else {
                this.f20816a.addPostData("is_vipdel", "0");
            }
            if (this.f20821f == 0 && ForumManageModel.this.f20815i) {
                ForumManageModel.this.f20815i = false;
                this.f20816a.addPostData("ori_ugc_nid", ForumManageModel.this.j);
                this.f20816a.addPostData("thread_type", String.valueOf(ForumManageModel.this.k));
                this.f20816a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(ForumManageModel.this.l));
                this.f20816a.addPostData("owner_uid", ForumManageModel.this.m);
                this.f20816a.addPostData("ori_ugc_vid", ForumManageModel.this.n);
                this.f20816a.addPostData("video_type", String.valueOf(ForumManageModel.this.o));
            } else {
                BaijiahaoData baijiahaoData = this.j;
                if (baijiahaoData != null) {
                    this.f20816a.addPostData("ori_ugc_nid", baijiahaoData.oriUgcNid);
                    this.f20816a.addPostData("ori_ugc_tid", this.j.oriUgcTid);
                    this.f20816a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.j.oriUgcType));
                    this.f20816a.addPostData("ori_ugc_vid", this.j.oriUgcVid);
                    this.f20816a.addPostData("owner_uid", TbadkCoreApplication.getCurrentAccount());
                }
            }
            this.f20816a.getNetContext().getRequest().mIsNeedTbs = true;
            this.f20816a.postNetData();
            if (this.f20816a.getNetContext().getResponse().isRequestSuccess()) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.f20811e = null;
            if (this.f20816a == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.c(null);
                return;
            }
            b bVar = new b(ForumManageModel.this);
            bVar.f20828d = this.f20821f;
            bVar.f20831g = this.f20820e;
            bVar.f20830f = this.f20823h;
            bVar.f20829e = this.f20822g;
            bVar.f20826b = this.f20816a.getErrorString();
            bVar.f20827c = this.f20816a.getServerErrorCode();
            bVar.f20825a = bool.booleanValue();
            ForumManageModel.this.mLoadDataCallBack.c(bVar);
        }
    }

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f20825a;

        /* renamed from: b  reason: collision with root package name */
        public String f20826b;

        /* renamed from: c  reason: collision with root package name */
        public int f20827c;

        /* renamed from: d  reason: collision with root package name */
        public int f20828d;

        /* renamed from: e  reason: collision with root package name */
        public int f20829e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f20830f;

        /* renamed from: g  reason: collision with root package name */
        public String f20831g;

        public b(ForumManageModel forumManageModel) {
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
    }

    /* loaded from: classes5.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f20832a;

        /* renamed from: b  reason: collision with root package name */
        public String f20833b;
    }

    /* loaded from: classes5.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public String f20834a;

        /* renamed from: b  reason: collision with root package name */
        public String f20835b;

        /* renamed from: c  reason: collision with root package name */
        public String f20836c;

        /* renamed from: d  reason: collision with root package name */
        public int f20837d;
    }

    /* loaded from: classes5.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f20838a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f20839b;

        /* renamed from: c  reason: collision with root package name */
        public String f20840c;

        /* renamed from: d  reason: collision with root package name */
        public String f20841d;

        /* renamed from: e  reason: collision with root package name */
        public int f20842e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<l0> f20843f;

        /* renamed from: g  reason: collision with root package name */
        public String f20844g;

        public f(String str, String str2, String str3, int i2, String str4) {
            this.f20843f = null;
            this.f20844g = null;
            this.f20839b = str;
            this.f20840c = str2;
            this.f20841d = str3;
            this.f20842e = i2;
            this.f20844g = str4;
            this.f20843f = new ArrayList<>();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NetWork netWork = this.f20838a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            ForumManageModel.this.f20813g = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.c(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            NetWork netWork = new NetWork(strArr[0]);
            this.f20838a = netWork;
            netWork.addPostData("word", this.f20840c);
            if (this.f20842e != 6) {
                this.f20838a.addPostData("fid", this.f20839b);
                this.f20838a.addPostData("z", this.f20841d);
                int i2 = this.f20842e;
                if (i2 == 4) {
                    this.f20838a.addPostData("ntn", "set");
                } else if (i2 == 5) {
                    this.f20838a.addPostData("ntn", "");
                } else if (i2 == 2) {
                    this.f20838a.addPostData("ntn", "set");
                    this.f20838a.addPostData(IAdRequestParam.CELL_ID, this.f20844g);
                } else {
                    this.f20838a.addPostData("ntn", "");
                }
                this.f20838a.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            this.f20838a.getNetContext().getRequest().mIsNeedTbs = true;
            String postNetData = this.f20838a.postNetData();
            if (this.f20838a.getNetContext().getResponse().isRequestSuccess()) {
                if (this.f20842e == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(postNetData).optJSONArray("cates");
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            l0 l0Var = new l0();
                            l0Var.c(optJSONArray.optJSONObject(i3));
                            this.f20843f.add(l0Var);
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
            ForumManageModel.this.f20813g = null;
            if (this.f20838a == null) {
                ForumManageModel.this.mLoadDataCallBack.c(null);
                return;
            }
            g gVar = new g(ForumManageModel.this);
            gVar.f20846a = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.f20842e == 6) {
                    gVar.f20848c = this.f20843f;
                }
            } else {
                gVar.f20847b = this.f20838a.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.c(gVar);
        }
    }

    /* loaded from: classes5.dex */
    public class g {

        /* renamed from: a  reason: collision with root package name */
        public boolean f20846a;

        /* renamed from: b  reason: collision with root package name */
        public String f20847b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<l0> f20848c;

        public g(ForumManageModel forumManageModel) {
        }
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f20811e = null;
        this.f20812f = null;
        this.f20813g = null;
        this.f20815i = false;
    }

    public void I() {
        a aVar = this.f20811e;
        if (aVar != null) {
            aVar.cancel();
            this.f20811e = null;
        }
        c cVar = this.f20812f;
        if (cVar != null) {
            cVar.cancel();
            this.f20812f = null;
        }
        f fVar = this.f20813g;
        if (fVar != null) {
            fVar.cancel();
            this.f20813g = null;
        }
    }

    public String J() {
        return this.f20814h;
    }

    public boolean K() {
        return (this.f20811e == null && this.f20812f == null && this.f20813g == null) ? false : true;
    }

    public void L(a2 a2Var) {
        if (a2Var == null || a2Var.V() == null) {
            return;
        }
        this.f20815i = true;
        this.j = a2Var.V().oriUgcNid;
        this.l = a2Var.V().oriUgcType;
        this.n = a2Var.V().oriUgcVid;
        this.k = a2Var.Z;
        this.m = TbadkCoreApplication.getCurrentAccount();
        this.o = a2Var.w1() != null ? a2Var.w1().video_type.intValue() : 0;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public void M(String str) {
        this.f20814h = str;
    }

    public void N(String str, String str2, String str3, String str4, int i2, int i3, boolean z, BaijiahaoData baijiahaoData) {
        a aVar = this.f20811e;
        if (aVar != null) {
            aVar.cancel();
            this.f20811e = null;
        }
        this.mLoadDataMode = 0;
        a aVar2 = new a(str, str2, str3, str4, i2, i3, z, baijiahaoData);
        this.f20811e = aVar2;
        aVar2.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.f20811e.setPriority(2);
        this.f20811e.execute(new String[0]);
    }

    public void O(String str, String str2, String str3, int i2, String str4) {
        String str5;
        f fVar = this.f20813g;
        if (fVar != null) {
            fVar.cancel();
            this.f20813g = null;
        }
        this.mLoadDataMode = i2;
        f fVar2 = new f(str, str2, str3, i2, str4);
        this.f20813g = fVar2;
        fVar2.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i2 == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i2 != 2 && i2 != 3) {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        }
        this.f20813g.execute(str5);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        I();
        return false;
    }

    public ForumManageModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.f20811e = null;
        this.f20812f = null;
        this.f20813g = null;
        this.f20815i = false;
    }
}
