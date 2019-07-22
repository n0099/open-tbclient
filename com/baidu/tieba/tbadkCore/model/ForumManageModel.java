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
    private c jhA;
    private f jhB;
    private String jhC;
    private a jhz;

    /* loaded from: classes.dex */
    public static class e {
        public String forumId;
        public String forumName;
        public int jhF;
        public String threadId;
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jhz = null;
        this.jhA = null;
        this.jhB = null;
    }

    public ForumManageModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jhz = null;
        this.jhA = null;
        this.jhB = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean FU;
        public boolean fYQ;
        public int fau;
        public int iaL;
        public String jhE;
        public int mErrCode;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean FU;
        public String jhE;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public boolean FU;
        public String jhE;
        public ArrayList<ac> jhH;

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
        if (this.jhz != null) {
            this.jhz.cancel();
            this.jhz = null;
        }
        if (this.jhA != null) {
            this.jhA.cancel();
            this.jhA = null;
        }
        if (this.jhB != null) {
            this.jhB.cancel();
            this.jhB = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.jhz != null) {
            this.jhz.cancel();
            this.jhz = null;
        }
        this.mLoadDataMode = 0;
        this.jhz = new a(str, str2, str3, str4, i, i2, z);
        this.jhz.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.jhz.setPriority(2);
        this.jhz.execute(new String[0]);
    }

    public boolean cqb() {
        return (this.jhz == null && this.jhA == null && this.jhB == null) ? false : true;
    }

    public void EP(String str) {
        this.jhC = str;
    }

    public String cqc() {
        return this.jhC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean fYQ;
        private int fau;
        private int iaL;
        private String jhC;
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
            this.fau = i;
            this.iaL = i2;
            this.fYQ = z;
            this.jhC = ForumManageModel.this.cqc();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.fau == 0 || this.fau == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new x(str);
            this.mNetwork.o("fid", this.mForumId);
            this.mNetwork.o("word", this.mForumName);
            this.mNetwork.o("z", this.mThreadId);
            if (this.jhC != null) {
                this.mNetwork.o("reason", this.jhC);
            }
            if (this.fau == 0) {
                if (this.iaL == 0) {
                    this.mNetwork.o("delete_my_thread", "1");
                }
            } else if (this.fau == 1) {
                this.mNetwork.o(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.o("isfloor", "0");
                this.mNetwork.o("src", "1");
                if (this.iaL == 0 && this.fYQ) {
                    this.mNetwork.o("delete_my_post", "1");
                }
            } else if (this.fau == 2) {
                this.mNetwork.o(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.o("isfloor", "1");
                this.mNetwork.o("src", "3");
                if (this.iaL == 0 && this.fYQ) {
                    this.mNetwork.o("delete_my_post", "1");
                }
            } else if (this.fau == 3) {
                this.mNetwork.o("delete_my_thread", "1");
                this.mNetwork.o("is_story", "1");
            }
            if (this.iaL == 0 && !this.fYQ) {
                this.mNetwork.o("is_vipdel", "1");
            } else {
                this.mNetwork.o("is_vipdel", "0");
            }
            this.mNetwork.aiE().ajE().mIsNeedTbs = true;
            this.mNetwork.aig();
            if (this.mNetwork.aiE().ajF().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ik();
            }
            ForumManageModel.this.jhz = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.m(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.jhz = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.m(null);
                return;
            }
            b bVar = new b();
            bVar.fau = this.fau;
            bVar.mPostId = this.mPostId;
            bVar.fYQ = this.fYQ;
            bVar.iaL = this.iaL;
            bVar.jhE = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.aiI();
            if (bool.booleanValue()) {
                bVar.FU = true;
            } else {
                bVar.FU = false;
            }
            ForumManageModel.this.mLoadDataCallBack.m(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String hFP;
        final /* synthetic */ ForumManageModel jhD;
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
            this.mNetwork.o(Config.TRACE_VISIT_RECENT_DAY, this.hFP);
            this.mNetwork.o("un", this.mUserName);
            this.mNetwork.o("fid", this.mForumId);
            this.mNetwork.o("word", this.mForumName);
            this.mNetwork.o("z", this.mThreadId);
            this.mNetwork.o("ntn", "banid");
            this.mNetwork.aiE().ajE().mIsNeedTbs = true;
            this.mNetwork.aig();
            if (this.mNetwork.aiE().ajF().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ik();
            }
            this.jhD.jhA = null;
            super.cancel(true);
            this.jhD.mLoadDataCallBack.m(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.jhD.jhA = null;
            if (this.mNetwork == null) {
                this.jhD.mLoadDataCallBack.m(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.FU = true;
            } else {
                dVar.FU = false;
                dVar.jhE = str;
            }
            this.jhD.mLoadDataCallBack.m(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.jhB != null) {
            this.jhB.cancel();
            this.jhB = null;
        }
        this.mLoadDataMode = i;
        this.jhB = new f(str, str2, str3, i, str4);
        this.jhB.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.jhB.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        String hUE;
        ArrayList<ac> jhG;
        private String mForumId;
        private String mForumName;
        private x mNetwork = null;
        private String mThreadId;
        private int mType;

        public f(String str, String str2, String str3, int i, String str4) {
            this.jhG = null;
            this.hUE = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.hUE = str4;
            this.jhG = new ArrayList<>();
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
                    this.mNetwork.o("cid", this.hUE);
                } else {
                    this.mNetwork.o("ntn", "");
                }
                this.mNetwork.o("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            this.mNetwork.aiE().ajE().mIsNeedTbs = true;
            String aig = this.mNetwork.aig();
            if (this.mNetwork.aiE().ajF().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(aig).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            ac acVar = new ac();
                            acVar.parserJson(optJSONArray.optJSONObject(i));
                            this.jhG.add(acVar);
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
            ForumManageModel.this.jhB = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.m(null);
                return;
            }
            g gVar = new g();
            gVar.FU = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    gVar.jhH = this.jhG;
                }
            } else {
                gVar.jhE = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.m(gVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ik();
            }
            ForumManageModel.this.jhB = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.m(null);
        }
    }
}
