package com.baidu.tieba.tbadkCore.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.l0;
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
    public a f20970e;

    /* renamed from: f  reason: collision with root package name */
    public c f20971f;

    /* renamed from: g  reason: collision with root package name */
    public f f20972g;

    /* renamed from: h  reason: collision with root package name */
    public String f20973h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20974i;
    public String j;
    public int k;
    public int l;
    public String m;
    public String n;
    public int o;

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f20975a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f20976b;

        /* renamed from: c  reason: collision with root package name */
        public String f20977c;

        /* renamed from: d  reason: collision with root package name */
        public String f20978d;

        /* renamed from: e  reason: collision with root package name */
        public String f20979e;

        /* renamed from: f  reason: collision with root package name */
        public int f20980f;

        /* renamed from: g  reason: collision with root package name */
        public int f20981g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f20982h;

        /* renamed from: i  reason: collision with root package name */
        public String f20983i;
        public BaijiahaoData j;

        public a(String str, String str2, String str3, String str4, int i2, int i3, boolean z, BaijiahaoData baijiahaoData) {
            this.f20976b = str;
            this.f20977c = str2;
            this.f20978d = str3;
            this.f20979e = str4;
            this.f20980f = i2;
            this.f20981g = i3;
            this.f20982h = z;
            this.f20983i = ForumManageModel.this.N();
            this.j = baijiahaoData;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NetWork netWork = this.f20975a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            ForumManageModel.this.f20970e = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.c(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            int i2 = this.f20980f;
            if (i2 != 0 && i2 != 3) {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            }
            NetWork netWork = new NetWork(str);
            this.f20975a = netWork;
            netWork.addPostData("fid", this.f20976b);
            this.f20975a.addPostData("word", this.f20977c);
            this.f20975a.addPostData("z", this.f20978d);
            String str3 = this.f20983i;
            if (str3 != null) {
                this.f20975a.addPostData("reason", str3);
            }
            int i3 = this.f20980f;
            if (i3 == 0) {
                if (this.f20981g == 0) {
                    this.f20975a.addPostData("delete_my_thread", "1");
                }
            } else if (i3 == 1) {
                this.f20975a.addPostData("pid", this.f20979e);
                this.f20975a.addPostData("isfloor", "0");
                this.f20975a.addPostData("src", "1");
                if (this.f20981g == 0 && this.f20982h) {
                    this.f20975a.addPostData("delete_my_post", "1");
                }
            } else if (i3 == 2) {
                this.f20975a.addPostData("pid", this.f20979e);
                this.f20975a.addPostData("isfloor", "1");
                this.f20975a.addPostData("src", "3");
                if (this.f20981g == 0 && this.f20982h) {
                    this.f20975a.addPostData("delete_my_post", "1");
                }
            } else if (i3 == 3) {
                this.f20975a.addPostData("delete_my_thread", "1");
                this.f20975a.addPostData("is_story", "1");
            }
            if (this.f20981g == 0 && !this.f20982h) {
                this.f20975a.addPostData("is_vipdel", "1");
            } else {
                this.f20975a.addPostData("is_vipdel", "0");
            }
            if (this.f20980f == 0 && ForumManageModel.this.f20974i) {
                ForumManageModel.this.f20974i = false;
                this.f20975a.addPostData("ori_ugc_nid", ForumManageModel.this.j);
                this.f20975a.addPostData("thread_type", String.valueOf(ForumManageModel.this.k));
                this.f20975a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(ForumManageModel.this.l));
                this.f20975a.addPostData("owner_uid", ForumManageModel.this.m);
                this.f20975a.addPostData("ori_ugc_vid", ForumManageModel.this.n);
                this.f20975a.addPostData("video_type", String.valueOf(ForumManageModel.this.o));
            } else {
                BaijiahaoData baijiahaoData = this.j;
                if (baijiahaoData != null) {
                    this.f20975a.addPostData("ori_ugc_nid", baijiahaoData.oriUgcNid);
                    this.f20975a.addPostData("ori_ugc_tid", this.j.oriUgcTid);
                    this.f20975a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.j.oriUgcType));
                    this.f20975a.addPostData("ori_ugc_vid", this.j.oriUgcVid);
                    this.f20975a.addPostData("owner_uid", TbadkCoreApplication.getCurrentAccount());
                }
            }
            this.f20975a.getNetContext().getRequest().mIsNeedTbs = true;
            this.f20975a.postNetData();
            if (this.f20975a.getNetContext().getResponse().isRequestSuccess()) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.f20970e = null;
            if (this.f20975a == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.c(null);
                return;
            }
            b bVar = new b(ForumManageModel.this);
            bVar.f20987d = this.f20980f;
            bVar.f20990g = this.f20979e;
            bVar.f20989f = this.f20982h;
            bVar.f20988e = this.f20981g;
            bVar.f20985b = this.f20975a.getErrorString();
            bVar.f20986c = this.f20975a.getServerErrorCode();
            bVar.f20984a = bool.booleanValue();
            ForumManageModel.this.mLoadDataCallBack.c(bVar);
        }
    }

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f20984a;

        /* renamed from: b  reason: collision with root package name */
        public String f20985b;

        /* renamed from: c  reason: collision with root package name */
        public int f20986c;

        /* renamed from: d  reason: collision with root package name */
        public int f20987d;

        /* renamed from: e  reason: collision with root package name */
        public int f20988e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f20989f;

        /* renamed from: g  reason: collision with root package name */
        public String f20990g;

        public b(ForumManageModel forumManageModel) {
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
    }

    /* loaded from: classes5.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f20991a;

        /* renamed from: b  reason: collision with root package name */
        public String f20992b;
    }

    /* loaded from: classes5.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public String f20993a;

        /* renamed from: b  reason: collision with root package name */
        public String f20994b;

        /* renamed from: c  reason: collision with root package name */
        public String f20995c;

        /* renamed from: d  reason: collision with root package name */
        public int f20996d;
    }

    /* loaded from: classes5.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f20997a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f20998b;

        /* renamed from: c  reason: collision with root package name */
        public String f20999c;

        /* renamed from: d  reason: collision with root package name */
        public String f21000d;

        /* renamed from: e  reason: collision with root package name */
        public int f21001e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<l0> f21002f;

        /* renamed from: g  reason: collision with root package name */
        public String f21003g;

        public f(String str, String str2, String str3, int i2, String str4) {
            this.f21002f = null;
            this.f21003g = null;
            this.f20998b = str;
            this.f20999c = str2;
            this.f21000d = str3;
            this.f21001e = i2;
            this.f21003g = str4;
            this.f21002f = new ArrayList<>();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NetWork netWork = this.f20997a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            ForumManageModel.this.f20972g = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.c(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            NetWork netWork = new NetWork(strArr[0]);
            this.f20997a = netWork;
            netWork.addPostData("word", this.f20999c);
            if (this.f21001e != 6) {
                this.f20997a.addPostData("fid", this.f20998b);
                this.f20997a.addPostData("z", this.f21000d);
                int i2 = this.f21001e;
                if (i2 == 4) {
                    this.f20997a.addPostData("ntn", "set");
                } else if (i2 == 5) {
                    this.f20997a.addPostData("ntn", "");
                } else if (i2 == 2) {
                    this.f20997a.addPostData("ntn", "set");
                    this.f20997a.addPostData(IAdRequestParam.CELL_ID, this.f21003g);
                } else {
                    this.f20997a.addPostData("ntn", "");
                }
                this.f20997a.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            this.f20997a.getNetContext().getRequest().mIsNeedTbs = true;
            String postNetData = this.f20997a.postNetData();
            if (this.f20997a.getNetContext().getResponse().isRequestSuccess()) {
                if (this.f21001e == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(postNetData).optJSONArray("cates");
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            l0 l0Var = new l0();
                            l0Var.c(optJSONArray.optJSONObject(i3));
                            this.f21002f.add(l0Var);
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
            ForumManageModel.this.f20972g = null;
            if (this.f20997a == null) {
                ForumManageModel.this.mLoadDataCallBack.c(null);
                return;
            }
            g gVar = new g(ForumManageModel.this);
            gVar.f21005a = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.f21001e == 6) {
                    gVar.f21007c = this.f21002f;
                }
            } else {
                gVar.f21006b = this.f20997a.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.c(gVar);
        }
    }

    /* loaded from: classes5.dex */
    public class g {

        /* renamed from: a  reason: collision with root package name */
        public boolean f21005a;

        /* renamed from: b  reason: collision with root package name */
        public String f21006b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<l0> f21007c;

        public g(ForumManageModel forumManageModel) {
        }
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f20970e = null;
        this.f20971f = null;
        this.f20972g = null;
        this.f20974i = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public void M() {
        a aVar = this.f20970e;
        if (aVar != null) {
            aVar.cancel();
            this.f20970e = null;
        }
        c cVar = this.f20971f;
        if (cVar != null) {
            cVar.cancel();
            this.f20971f = null;
        }
        f fVar = this.f20972g;
        if (fVar != null) {
            fVar.cancel();
            this.f20972g = null;
        }
    }

    public String N() {
        return this.f20973h;
    }

    public boolean O() {
        return (this.f20970e == null && this.f20971f == null && this.f20972g == null) ? false : true;
    }

    public void P(a2 a2Var) {
        if (a2Var == null || a2Var.V() == null) {
            return;
        }
        this.f20974i = true;
        this.j = a2Var.V().oriUgcNid;
        this.l = a2Var.V().oriUgcType;
        this.n = a2Var.V().oriUgcVid;
        this.k = a2Var.Z;
        this.m = TbadkCoreApplication.getCurrentAccount();
        this.o = a2Var.x1() != null ? a2Var.x1().video_type.intValue() : 0;
    }

    public void Q(String str) {
        this.f20973h = str;
    }

    public void R(String str, String str2, String str3, String str4, int i2, int i3, boolean z, BaijiahaoData baijiahaoData) {
        a aVar = this.f20970e;
        if (aVar != null) {
            aVar.cancel();
            this.f20970e = null;
        }
        this.mLoadDataMode = 0;
        a aVar2 = new a(str, str2, str3, str4, i2, i3, z, baijiahaoData);
        this.f20970e = aVar2;
        aVar2.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.f20970e.setPriority(2);
        this.f20970e.execute(new String[0]);
    }

    public void S(String str, String str2, String str3, int i2, String str4) {
        String str5;
        f fVar = this.f20972g;
        if (fVar != null) {
            fVar.cancel();
            this.f20972g = null;
        }
        this.mLoadDataMode = i2;
        f fVar2 = new f(str, str2, str3, i2, str4);
        this.f20972g = fVar2;
        fVar2.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i2 == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i2 != 2 && i2 != 3) {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        }
        this.f20972g.execute(str5);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        M();
        return false;
    }

    public ForumManageModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.f20970e = null;
        this.f20971f = null;
        this.f20972g = null;
        this.f20974i = false;
    }
}
