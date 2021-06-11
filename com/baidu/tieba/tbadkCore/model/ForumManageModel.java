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
    public a f20888e;

    /* renamed from: f  reason: collision with root package name */
    public c f20889f;

    /* renamed from: g  reason: collision with root package name */
    public f f20890g;

    /* renamed from: h  reason: collision with root package name */
    public String f20891h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20892i;
    public String j;
    public int k;
    public int l;
    public String m;
    public String n;
    public int o;

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f20893a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f20894b;

        /* renamed from: c  reason: collision with root package name */
        public String f20895c;

        /* renamed from: d  reason: collision with root package name */
        public String f20896d;

        /* renamed from: e  reason: collision with root package name */
        public String f20897e;

        /* renamed from: f  reason: collision with root package name */
        public int f20898f;

        /* renamed from: g  reason: collision with root package name */
        public int f20899g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f20900h;

        /* renamed from: i  reason: collision with root package name */
        public String f20901i;
        public BaijiahaoData j;

        public a(String str, String str2, String str3, String str4, int i2, int i3, boolean z, BaijiahaoData baijiahaoData) {
            this.f20894b = str;
            this.f20895c = str2;
            this.f20896d = str3;
            this.f20897e = str4;
            this.f20898f = i2;
            this.f20899g = i3;
            this.f20900h = z;
            this.f20901i = ForumManageModel.this.N();
            this.j = baijiahaoData;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NetWork netWork = this.f20893a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            ForumManageModel.this.f20888e = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.c(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            int i2 = this.f20898f;
            if (i2 != 0 && i2 != 3) {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            }
            NetWork netWork = new NetWork(str);
            this.f20893a = netWork;
            netWork.addPostData("fid", this.f20894b);
            this.f20893a.addPostData("word", this.f20895c);
            this.f20893a.addPostData("z", this.f20896d);
            String str3 = this.f20901i;
            if (str3 != null) {
                this.f20893a.addPostData("reason", str3);
            }
            int i3 = this.f20898f;
            if (i3 == 0) {
                if (this.f20899g == 0) {
                    this.f20893a.addPostData("delete_my_thread", "1");
                }
            } else if (i3 == 1) {
                this.f20893a.addPostData("pid", this.f20897e);
                this.f20893a.addPostData("isfloor", "0");
                this.f20893a.addPostData("src", "1");
                if (this.f20899g == 0 && this.f20900h) {
                    this.f20893a.addPostData("delete_my_post", "1");
                }
            } else if (i3 == 2) {
                this.f20893a.addPostData("pid", this.f20897e);
                this.f20893a.addPostData("isfloor", "1");
                this.f20893a.addPostData("src", "3");
                if (this.f20899g == 0 && this.f20900h) {
                    this.f20893a.addPostData("delete_my_post", "1");
                }
            } else if (i3 == 3) {
                this.f20893a.addPostData("delete_my_thread", "1");
                this.f20893a.addPostData("is_story", "1");
            }
            if (this.f20899g == 0 && !this.f20900h) {
                this.f20893a.addPostData("is_vipdel", "1");
            } else {
                this.f20893a.addPostData("is_vipdel", "0");
            }
            if (this.f20898f == 0 && ForumManageModel.this.f20892i) {
                ForumManageModel.this.f20892i = false;
                this.f20893a.addPostData("ori_ugc_nid", ForumManageModel.this.j);
                this.f20893a.addPostData("thread_type", String.valueOf(ForumManageModel.this.k));
                this.f20893a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(ForumManageModel.this.l));
                this.f20893a.addPostData("owner_uid", ForumManageModel.this.m);
                this.f20893a.addPostData("ori_ugc_vid", ForumManageModel.this.n);
                this.f20893a.addPostData("video_type", String.valueOf(ForumManageModel.this.o));
            } else {
                BaijiahaoData baijiahaoData = this.j;
                if (baijiahaoData != null) {
                    this.f20893a.addPostData("ori_ugc_nid", baijiahaoData.oriUgcNid);
                    this.f20893a.addPostData("ori_ugc_tid", this.j.oriUgcTid);
                    this.f20893a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.j.oriUgcType));
                    this.f20893a.addPostData("ori_ugc_vid", this.j.oriUgcVid);
                    this.f20893a.addPostData("owner_uid", TbadkCoreApplication.getCurrentAccount());
                }
            }
            this.f20893a.getNetContext().getRequest().mIsNeedTbs = true;
            this.f20893a.postNetData();
            if (this.f20893a.getNetContext().getResponse().isRequestSuccess()) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.f20888e = null;
            if (this.f20893a == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.c(null);
                return;
            }
            b bVar = new b(ForumManageModel.this);
            bVar.f20905d = this.f20898f;
            bVar.f20908g = this.f20897e;
            bVar.f20907f = this.f20900h;
            bVar.f20906e = this.f20899g;
            bVar.f20903b = this.f20893a.getErrorString();
            bVar.f20904c = this.f20893a.getServerErrorCode();
            bVar.f20902a = bool.booleanValue();
            ForumManageModel.this.mLoadDataCallBack.c(bVar);
        }
    }

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f20902a;

        /* renamed from: b  reason: collision with root package name */
        public String f20903b;

        /* renamed from: c  reason: collision with root package name */
        public int f20904c;

        /* renamed from: d  reason: collision with root package name */
        public int f20905d;

        /* renamed from: e  reason: collision with root package name */
        public int f20906e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f20907f;

        /* renamed from: g  reason: collision with root package name */
        public String f20908g;

        public b(ForumManageModel forumManageModel) {
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
    }

    /* loaded from: classes5.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f20909a;

        /* renamed from: b  reason: collision with root package name */
        public String f20910b;
    }

    /* loaded from: classes5.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public String f20911a;

        /* renamed from: b  reason: collision with root package name */
        public String f20912b;

        /* renamed from: c  reason: collision with root package name */
        public String f20913c;

        /* renamed from: d  reason: collision with root package name */
        public int f20914d;
    }

    /* loaded from: classes5.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f20915a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f20916b;

        /* renamed from: c  reason: collision with root package name */
        public String f20917c;

        /* renamed from: d  reason: collision with root package name */
        public String f20918d;

        /* renamed from: e  reason: collision with root package name */
        public int f20919e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<l0> f20920f;

        /* renamed from: g  reason: collision with root package name */
        public String f20921g;

        public f(String str, String str2, String str3, int i2, String str4) {
            this.f20920f = null;
            this.f20921g = null;
            this.f20916b = str;
            this.f20917c = str2;
            this.f20918d = str3;
            this.f20919e = i2;
            this.f20921g = str4;
            this.f20920f = new ArrayList<>();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NetWork netWork = this.f20915a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            ForumManageModel.this.f20890g = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.c(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            NetWork netWork = new NetWork(strArr[0]);
            this.f20915a = netWork;
            netWork.addPostData("word", this.f20917c);
            if (this.f20919e != 6) {
                this.f20915a.addPostData("fid", this.f20916b);
                this.f20915a.addPostData("z", this.f20918d);
                int i2 = this.f20919e;
                if (i2 == 4) {
                    this.f20915a.addPostData("ntn", "set");
                } else if (i2 == 5) {
                    this.f20915a.addPostData("ntn", "");
                } else if (i2 == 2) {
                    this.f20915a.addPostData("ntn", "set");
                    this.f20915a.addPostData(IAdRequestParam.CELL_ID, this.f20921g);
                } else {
                    this.f20915a.addPostData("ntn", "");
                }
                this.f20915a.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            this.f20915a.getNetContext().getRequest().mIsNeedTbs = true;
            String postNetData = this.f20915a.postNetData();
            if (this.f20915a.getNetContext().getResponse().isRequestSuccess()) {
                if (this.f20919e == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(postNetData).optJSONArray("cates");
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            l0 l0Var = new l0();
                            l0Var.c(optJSONArray.optJSONObject(i3));
                            this.f20920f.add(l0Var);
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
            ForumManageModel.this.f20890g = null;
            if (this.f20915a == null) {
                ForumManageModel.this.mLoadDataCallBack.c(null);
                return;
            }
            g gVar = new g(ForumManageModel.this);
            gVar.f20923a = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.f20919e == 6) {
                    gVar.f20925c = this.f20920f;
                }
            } else {
                gVar.f20924b = this.f20915a.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.c(gVar);
        }
    }

    /* loaded from: classes5.dex */
    public class g {

        /* renamed from: a  reason: collision with root package name */
        public boolean f20923a;

        /* renamed from: b  reason: collision with root package name */
        public String f20924b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<l0> f20925c;

        public g(ForumManageModel forumManageModel) {
        }
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f20888e = null;
        this.f20889f = null;
        this.f20890g = null;
        this.f20892i = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public void M() {
        a aVar = this.f20888e;
        if (aVar != null) {
            aVar.cancel();
            this.f20888e = null;
        }
        c cVar = this.f20889f;
        if (cVar != null) {
            cVar.cancel();
            this.f20889f = null;
        }
        f fVar = this.f20890g;
        if (fVar != null) {
            fVar.cancel();
            this.f20890g = null;
        }
    }

    public String N() {
        return this.f20891h;
    }

    public boolean O() {
        return (this.f20888e == null && this.f20889f == null && this.f20890g == null) ? false : true;
    }

    public void P(a2 a2Var) {
        if (a2Var == null || a2Var.V() == null) {
            return;
        }
        this.f20892i = true;
        this.j = a2Var.V().oriUgcNid;
        this.l = a2Var.V().oriUgcType;
        this.n = a2Var.V().oriUgcVid;
        this.k = a2Var.Z;
        this.m = TbadkCoreApplication.getCurrentAccount();
        this.o = a2Var.x1() != null ? a2Var.x1().video_type.intValue() : 0;
    }

    public void Q(String str) {
        this.f20891h = str;
    }

    public void R(String str, String str2, String str3, String str4, int i2, int i3, boolean z, BaijiahaoData baijiahaoData) {
        a aVar = this.f20888e;
        if (aVar != null) {
            aVar.cancel();
            this.f20888e = null;
        }
        this.mLoadDataMode = 0;
        a aVar2 = new a(str, str2, str3, str4, i2, i3, z, baijiahaoData);
        this.f20888e = aVar2;
        aVar2.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.f20888e.setPriority(2);
        this.f20888e.execute(new String[0]);
    }

    public void S(String str, String str2, String str3, int i2, String str4) {
        String str5;
        f fVar = this.f20890g;
        if (fVar != null) {
            fVar.cancel();
            this.f20890g = null;
        }
        this.mLoadDataMode = i2;
        f fVar2 = new f(str, str2, str3, i2, str4);
        this.f20890g = fVar2;
        fVar2.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i2 == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i2 != 2 && i2 != 3) {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        }
        this.f20890g.execute(str5);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        M();
        return false;
    }

    public ForumManageModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.f20888e = null;
        this.f20889f = null;
        this.f20890g = null;
        this.f20892i = false;
    }
}
