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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
    private a iIj;
    private c iIk;
    private f iIl;
    private String iIm;

    /* loaded from: classes.dex */
    public static class e {
        public String forumId;
        public String forumName;
        public int iIp;
        public String threadId;
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iIj = null;
        this.iIk = null;
        this.iIl = null;
    }

    public ForumManageModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.iIj = null;
        this.iIk = null;
        this.iIl = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean Id;
        public int eFz;
        public boolean fCT;
        public int hCu;
        public String iIo;
        public int mErrCode;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean Id;
        public String iIo;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public boolean Id;
        public String iIo;
        public ArrayList<ac> iIr;

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
        if (this.iIj != null) {
            this.iIj.cancel();
            this.iIj = null;
        }
        if (this.iIk != null) {
            this.iIk.cancel();
            this.iIk = null;
        }
        if (this.iIl != null) {
            this.iIl.cancel();
            this.iIl = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.iIj != null) {
            this.iIj.cancel();
            this.iIj = null;
        }
        this.mLoadDataMode = 0;
        this.iIj = new a(str, str2, str3, str4, i, i2, z);
        this.iIj.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.iIj.setPriority(2);
        this.iIj.execute(new String[0]);
    }

    public boolean cfb() {
        return (this.iIj == null && this.iIk == null && this.iIl == null) ? false : true;
    }

    public void CE(String str) {
        this.iIm = str;
    }

    public String cfc() {
        return this.iIm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private int eFz;
        private boolean fCT;
        private int hCu;
        private String iIm;
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
            this.eFz = i;
            this.hCu = i2;
            this.fCT = z;
            this.iIm = ForumManageModel.this.cfc();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.eFz == 0 || this.eFz == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new x(str);
            this.mNetwork.x(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.x("word", this.mForumName);
            this.mNetwork.x("z", this.mThreadId);
            if (this.iIm != null) {
                this.mNetwork.x("reason", this.iIm);
            }
            if (this.eFz == 0) {
                if (this.hCu == 0) {
                    this.mNetwork.x("delete_my_thread", "1");
                }
            } else if (this.eFz == 1) {
                this.mNetwork.x(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.x("isfloor", "0");
                this.mNetwork.x("src", "1");
                if (this.hCu == 0 && this.fCT) {
                    this.mNetwork.x("delete_my_post", "1");
                }
            } else if (this.eFz == 2) {
                this.mNetwork.x(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.x("isfloor", "1");
                this.mNetwork.x("src", "3");
                if (this.hCu == 0 && this.fCT) {
                    this.mNetwork.x("delete_my_post", "1");
                }
            } else if (this.eFz == 3) {
                this.mNetwork.x("delete_my_thread", "1");
                this.mNetwork.x("is_story", "1");
            }
            if (this.hCu == 0 && !this.fCT) {
                this.mNetwork.x("is_vipdel", "1");
            } else {
                this.mNetwork.x("is_vipdel", "0");
            }
            this.mNetwork.acE().adC().mIsNeedTbs = true;
            this.mNetwork.acg();
            if (this.mNetwork.acE().adD().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ji();
            }
            ForumManageModel.this.iIj = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.m(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.iIj = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.m(null);
                return;
            }
            b bVar = new b();
            bVar.eFz = this.eFz;
            bVar.mPostId = this.mPostId;
            bVar.fCT = this.fCT;
            bVar.hCu = this.hCu;
            bVar.iIo = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.acI();
            if (bool.booleanValue()) {
                bVar.Id = true;
            } else {
                bVar.Id = false;
            }
            ForumManageModel.this.mLoadDataCallBack.m(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String hig;
        final /* synthetic */ ForumManageModel iIn;
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
            this.mNetwork.x(Config.TRACE_VISIT_RECENT_DAY, this.hig);
            this.mNetwork.x("un", this.mUserName);
            this.mNetwork.x(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.x("word", this.mForumName);
            this.mNetwork.x("z", this.mThreadId);
            this.mNetwork.x("ntn", "banid");
            this.mNetwork.acE().adC().mIsNeedTbs = true;
            this.mNetwork.acg();
            if (this.mNetwork.acE().adD().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ji();
            }
            this.iIn.iIk = null;
            super.cancel(true);
            this.iIn.mLoadDataCallBack.m(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.iIn.iIk = null;
            if (this.mNetwork == null) {
                this.iIn.mLoadDataCallBack.m(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.Id = true;
            } else {
                dVar.Id = false;
                dVar.iIo = str;
            }
            this.iIn.mLoadDataCallBack.m(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.iIl != null) {
            this.iIl.cancel();
            this.iIl = null;
        }
        this.mLoadDataMode = i;
        this.iIl = new f(str, str2, str3, i, str4);
        this.iIl.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.iIl.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        String hwF;
        ArrayList<ac> iIq;
        private String mForumId;
        private String mForumName;
        private x mNetwork = null;
        private String mThreadId;
        private int mType;

        public f(String str, String str2, String str3, int i, String str4) {
            this.iIq = null;
            this.hwF = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.hwF = str4;
            this.iIq = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            this.mNetwork = new x(strArr[0]);
            this.mNetwork.x("word", this.mForumName);
            if (this.mType != 6) {
                this.mNetwork.x(ImageViewerConfig.FORUM_ID, this.mForumId);
                this.mNetwork.x("z", this.mThreadId);
                if (this.mType == 4) {
                    this.mNetwork.x("ntn", "set");
                } else if (this.mType == 5) {
                    this.mNetwork.x("ntn", "");
                } else if (this.mType == 2) {
                    this.mNetwork.x("ntn", "set");
                    this.mNetwork.x("cid", this.hwF);
                } else {
                    this.mNetwork.x("ntn", "");
                }
                this.mNetwork.x("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            this.mNetwork.acE().adC().mIsNeedTbs = true;
            String acg = this.mNetwork.acg();
            if (this.mNetwork.acE().adD().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(acg).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            ac acVar = new ac();
                            acVar.parserJson(optJSONArray.optJSONObject(i));
                            this.iIq.add(acVar);
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
            ForumManageModel.this.iIl = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.m(null);
                return;
            }
            g gVar = new g();
            gVar.Id = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    gVar.iIr = this.iIq;
                }
            } else {
                gVar.iIo = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.m(gVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ji();
            }
            ForumManageModel.this.iIl = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.m(null);
        }
    }
}
