package com.baidu.tieba.tbadkCore.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.z;
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
    private a gEd;
    private c gEe;
    private f gEf;

    /* loaded from: classes.dex */
    public static class e {
        public String forumId;
        public String forumName;
        public int gEj;
        public String threadId;
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gEd = null;
        this.gEe = null;
        this.gEf = null;
    }

    public ForumManageModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gEd = null;
        this.gEe = null;
        this.gEf = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean Ai;
        public boolean dkF;
        public int fip;
        public int gEg;
        public String gEi;
        public int mErrCode;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean Ai;
        public String gEi;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public boolean Ai;
        public String gEi;
        public ArrayList<z> gEl;

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
        if (this.gEd != null) {
            this.gEd.cancel();
            this.gEd = null;
        }
        if (this.gEe != null) {
            this.gEe.cancel();
            this.gEe = null;
        }
        if (this.gEf != null) {
            this.gEf.cancel();
            this.gEf = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.gEd != null) {
            this.gEd.cancel();
            this.gEd = null;
        }
        this.mLoadDataMode = 0;
        this.gEd = new a(str, str2, str3, str4, i, i2, z);
        this.gEd.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.gEd.setPriority(2);
        this.gEd.execute(new String[0]);
    }

    public boolean bxI() {
        return (this.gEd == null && this.gEe == null && this.gEf == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean dkF;
        private int fip;
        private int gEg;
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
            this.gEg = i;
            this.fip = i2;
            this.dkF = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.gEg == 0 || this.gEg == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new x(str);
            this.mNetwork.n(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n("z", this.mThreadId);
            if (this.gEg == 0) {
                if (this.fip == 0) {
                    this.mNetwork.n("delete_my_thread", "1");
                }
            } else if (this.gEg == 1) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "0");
                this.mNetwork.n("src", "1");
                if (this.fip == 0 && this.dkF) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.gEg == 2) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "1");
                this.mNetwork.n("src", "3");
                if (this.fip == 0 && this.dkF) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.gEg == 3) {
                this.mNetwork.n("delete_my_thread", "1");
                this.mNetwork.n("is_story", "1");
            }
            if (this.fip == 0 && !this.dkF) {
                this.mNetwork.n("is_vipdel", "1");
            } else {
                this.mNetwork.n("is_vipdel", "0");
            }
            this.mNetwork.uN().vK().mIsNeedTbs = true;
            this.mNetwork.up();
            if (this.mNetwork.uN().vL().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fo();
            }
            ForumManageModel.this.gEd = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.f(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.gEd = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.f(null);
                return;
            }
            b bVar = new b();
            bVar.gEg = this.gEg;
            bVar.mPostId = this.mPostId;
            bVar.dkF = this.dkF;
            bVar.fip = this.fip;
            bVar.gEi = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.uR();
            if (bool.booleanValue()) {
                bVar.Ai = true;
            } else {
                bVar.Ai = false;
            }
            ForumManageModel.this.mLoadDataCallBack.f(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String eNJ;
        final /* synthetic */ ForumManageModel gEh;
        private String mForumId;
        private String mForumName;
        private x mNetwork;
        private String mThreadId;
        private String mUserName;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            this.mNetwork = new x(strArr[0]);
            this.mNetwork.n("day", this.eNJ);
            this.mNetwork.n("un", this.mUserName);
            this.mNetwork.n(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n("z", this.mThreadId);
            this.mNetwork.n("ntn", "banid");
            this.mNetwork.uN().vK().mIsNeedTbs = true;
            this.mNetwork.up();
            if (this.mNetwork.uN().vL().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fo();
            }
            this.gEh.gEe = null;
            super.cancel(true);
            this.gEh.mLoadDataCallBack.f(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.gEh.gEe = null;
            if (this.mNetwork == null) {
                this.gEh.mLoadDataCallBack.f(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.Ai = true;
            } else {
                dVar.Ai = false;
                dVar.gEi = str;
            }
            this.gEh.mLoadDataCallBack.f(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.gEf != null) {
            this.gEf.cancel();
            this.gEf = null;
        }
        this.mLoadDataMode = i;
        this.gEf = new f(str, str2, str3, i, str4);
        this.gEf.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.gEf.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        String fcO;
        ArrayList<z> gEk;
        private String mForumId;
        private String mForumName;
        private x mNetwork = null;
        private String mThreadId;
        private int mType;

        public f(String str, String str2, String str3, int i, String str4) {
            this.gEk = null;
            this.fcO = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.fcO = str4;
            this.gEk = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            this.mNetwork = new x(strArr[0]);
            this.mNetwork.n("word", this.mForumName);
            if (this.mType != 6) {
                this.mNetwork.n(ImageViewerConfig.FORUM_ID, this.mForumId);
                this.mNetwork.n("z", this.mThreadId);
                if (this.mType == 4) {
                    this.mNetwork.n("ntn", "set");
                } else if (this.mType == 5) {
                    this.mNetwork.n("ntn", "");
                } else if (this.mType == 2) {
                    this.mNetwork.n("ntn", "set");
                    this.mNetwork.n("cid", this.fcO);
                } else {
                    this.mNetwork.n("ntn", "");
                }
            }
            this.mNetwork.uN().vK().mIsNeedTbs = true;
            String up = this.mNetwork.up();
            if (this.mNetwork.uN().vL().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(up).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            z zVar = new z();
                            zVar.parserJson(optJSONArray.optJSONObject(i));
                            this.gEk.add(zVar);
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
            ForumManageModel.this.gEf = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.f(null);
                return;
            }
            g gVar = new g();
            gVar.Ai = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    gVar.gEl = this.gEk;
                }
            } else {
                gVar.gEi = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.f(gVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fo();
            }
            ForumManageModel.this.gEf = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.f(null);
        }
    }
}
