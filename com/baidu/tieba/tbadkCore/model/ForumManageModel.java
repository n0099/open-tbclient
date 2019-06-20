package com.baidu.tieba.tbadkCore.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
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
    private a jbi;
    private c jbj;
    private f jbk;
    private String jbl;

    /* loaded from: classes.dex */
    public static class e {
        public String forumId;
        public String forumName;
        public int jbo;
        public String threadId;
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jbi = null;
        this.jbj = null;
        this.jbk = null;
    }

    public ForumManageModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jbi = null;
        this.jbj = null;
        this.jbk = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean FM;
        public int eVt;
        public boolean fTT;
        public int hUy;
        public String jbn;
        public int mErrCode;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean FM;
        public String jbn;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public boolean FM;
        public String jbn;
        public ArrayList<ac> jbq;

        public g() {
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelAllTask();
        return false;
    }

    public void cancelAllTask() {
        if (this.jbi != null) {
            this.jbi.cancel();
            this.jbi = null;
        }
        if (this.jbj != null) {
            this.jbj.cancel();
            this.jbj = null;
        }
        if (this.jbk != null) {
            this.jbk.cancel();
            this.jbk = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.jbi != null) {
            this.jbi.cancel();
            this.jbi = null;
        }
        this.mLoadDataMode = 0;
        this.jbi = new a(str, str2, str3, str4, i, i2, z);
        this.jbi.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.jbi.setPriority(2);
        this.jbi.execute(new String[0]);
    }

    public boolean cni() {
        return (this.jbi == null && this.jbj == null && this.jbk == null) ? false : true;
    }

    public void Ec(String str) {
        this.jbl = str;
    }

    public String cnj() {
        return this.jbl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private int eVt;
        private boolean fTT;
        private int hUy;
        private String jbl;
        private String mForumId;
        private String mForumName;
        private x mNetwork = null;
        private String mPostId;
        private String mThreadId;

        public a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.eVt = i;
            this.hUy = i2;
            this.fTT = z;
            this.jbl = ForumManageModel.this.cnj();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.eVt == 0 || this.eVt == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new x(str);
            this.mNetwork.o("fid", this.mForumId);
            this.mNetwork.o("word", this.mForumName);
            this.mNetwork.o("z", this.mThreadId);
            if (this.jbl != null) {
                this.mNetwork.o("reason", this.jbl);
            }
            if (this.eVt == 0) {
                if (this.hUy == 0) {
                    this.mNetwork.o("delete_my_thread", "1");
                }
            } else if (this.eVt == 1) {
                this.mNetwork.o(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.o("isfloor", "0");
                this.mNetwork.o("src", "1");
                if (this.hUy == 0 && this.fTT) {
                    this.mNetwork.o("delete_my_post", "1");
                }
            } else if (this.eVt == 2) {
                this.mNetwork.o(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.o("isfloor", "1");
                this.mNetwork.o("src", "3");
                if (this.hUy == 0 && this.fTT) {
                    this.mNetwork.o("delete_my_post", "1");
                }
            } else if (this.eVt == 3) {
                this.mNetwork.o("delete_my_thread", "1");
                this.mNetwork.o("is_story", "1");
            }
            if (this.hUy == 0 && !this.fTT) {
                this.mNetwork.o("is_vipdel", "1");
            } else {
                this.mNetwork.o("is_vipdel", "0");
            }
            this.mNetwork.ahC().aiB().mIsNeedTbs = true;
            this.mNetwork.ahe();
            if (this.mNetwork.ahC().aiC().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ia();
            }
            ForumManageModel.this.jbi = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.m(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.jbi = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.m(null);
                return;
            }
            b bVar = new b();
            bVar.eVt = this.eVt;
            bVar.mPostId = this.mPostId;
            bVar.fTT = this.fTT;
            bVar.hUy = this.hUy;
            bVar.jbn = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.ahG();
            if (bool.booleanValue()) {
                bVar.FM = true;
            } else {
                bVar.FM = false;
            }
            ForumManageModel.this.mLoadDataCallBack.m(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String hzC;
        final /* synthetic */ ForumManageModel jbm;
        private String mForumId;
        private String mForumName;
        private x mNetwork;
        private String mThreadId;
        private String mUserName;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            this.mNetwork = new x(strArr[0]);
            this.mNetwork.o(Config.TRACE_VISIT_RECENT_DAY, this.hzC);
            this.mNetwork.o("un", this.mUserName);
            this.mNetwork.o("fid", this.mForumId);
            this.mNetwork.o("word", this.mForumName);
            this.mNetwork.o("z", this.mThreadId);
            this.mNetwork.o("ntn", "banid");
            this.mNetwork.ahC().aiB().mIsNeedTbs = true;
            this.mNetwork.ahe();
            if (this.mNetwork.ahC().aiC().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ia();
            }
            this.jbm.jbj = null;
            super.cancel(true);
            this.jbm.mLoadDataCallBack.m(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.jbm.jbj = null;
            if (this.mNetwork == null) {
                this.jbm.mLoadDataCallBack.m(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.FM = true;
            } else {
                dVar.FM = false;
                dVar.jbn = str;
            }
            this.jbm.mLoadDataCallBack.m(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.jbk != null) {
            this.jbk.cancel();
            this.jbk = null;
        }
        this.mLoadDataMode = i;
        this.jbk = new f(str, str2, str3, i, str4);
        this.jbk.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.jbk.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        String hOr;
        ArrayList<ac> jbp;
        private String mForumId;
        private String mForumName;
        private x mNetwork = null;
        private String mThreadId;
        private int mType;

        public f(String str, String str2, String str3, int i, String str4) {
            this.jbp = null;
            this.hOr = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.hOr = str4;
            this.jbp = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            this.mNetwork = new x(strArr[0]);
            this.mNetwork.o("word", this.mForumName);
            if (this.mType != 6) {
                this.mNetwork.o("fid", this.mForumId);
                this.mNetwork.o("z", this.mThreadId);
                if (this.mType == 4) {
                    this.mNetwork.o("ntn", "set");
                } else if (this.mType == 5) {
                    this.mNetwork.o("ntn", "");
                } else if (this.mType == 2) {
                    this.mNetwork.o("ntn", "set");
                    this.mNetwork.o("cid", this.hOr);
                } else {
                    this.mNetwork.o("ntn", "");
                }
                this.mNetwork.o("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            this.mNetwork.ahC().aiB().mIsNeedTbs = true;
            String ahe = this.mNetwork.ahe();
            if (this.mNetwork.ahC().aiC().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(ahe).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            ac acVar = new ac();
                            acVar.parserJson(optJSONArray.optJSONObject(i));
                            this.jbp.add(acVar);
                        }
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                        return false;
                    }
                }
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((f) bool);
            ForumManageModel.this.jbk = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.m(null);
                return;
            }
            g gVar = new g();
            gVar.FM = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    gVar.jbq = this.jbp;
                }
            } else {
                gVar.jbn = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.m(gVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ia();
            }
            ForumManageModel.this.jbk = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.m(null);
        }
    }
}
