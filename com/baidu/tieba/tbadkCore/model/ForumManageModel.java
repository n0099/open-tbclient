package com.baidu.tieba.tbadkCore.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.util.y;
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
    private a gLm;
    private c gLn;
    private f gLo;

    /* loaded from: classes.dex */
    public static class e {
        public String forumId;
        public String forumName;
        public int gLs;
        public String threadId;
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gLm = null;
        this.gLn = null;
        this.gLo = null;
    }

    public ForumManageModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gLm = null;
        this.gLn = null;
        this.gLo = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean EY;
        public boolean dJI;
        public int fHh;
        public int gLp;
        public String gLr;
        public int mErrCode;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean EY;
        public String gLr;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public boolean EY;
        public String gLr;
        public ArrayList<ab> gLu;

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
        if (this.gLm != null) {
            this.gLm.cancel();
            this.gLm = null;
        }
        if (this.gLn != null) {
            this.gLn.cancel();
            this.gLn = null;
        }
        if (this.gLo != null) {
            this.gLo.cancel();
            this.gLo = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.gLm != null) {
            this.gLm.cancel();
            this.gLm = null;
        }
        this.mLoadDataMode = 0;
        this.gLm = new a(str, str2, str3, str4, i, i2, z);
        this.gLm.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.gLm.setPriority(2);
        this.gLm.execute(new String[0]);
    }

    public boolean bxN() {
        return (this.gLm == null && this.gLn == null && this.gLo == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean dJI;
        private int fHh;
        private int gLp;
        private String mForumId;
        private String mForumName;
        private y mNetwork = null;
        private String mPostId;
        private String mThreadId;

        public a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.gLp = i;
            this.fHh = i2;
            this.dJI = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.gLp == 0 || this.gLp == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new y(str);
            this.mNetwork.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.o("word", this.mForumName);
            this.mNetwork.o("z", this.mThreadId);
            if (this.gLp == 0) {
                if (this.fHh == 0) {
                    this.mNetwork.o("delete_my_thread", "1");
                }
            } else if (this.gLp == 1) {
                this.mNetwork.o(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.o("isfloor", "0");
                this.mNetwork.o("src", "1");
                if (this.fHh == 0 && this.dJI) {
                    this.mNetwork.o("delete_my_post", "1");
                }
            } else if (this.gLp == 2) {
                this.mNetwork.o(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.o("isfloor", "1");
                this.mNetwork.o("src", "3");
                if (this.fHh == 0 && this.dJI) {
                    this.mNetwork.o("delete_my_post", "1");
                }
            } else if (this.gLp == 3) {
                this.mNetwork.o("delete_my_thread", "1");
                this.mNetwork.o("is_story", "1");
            }
            if (this.fHh == 0 && !this.dJI) {
                this.mNetwork.o("is_vipdel", "1");
            } else {
                this.mNetwork.o("is_vipdel", "0");
            }
            this.mNetwork.yJ().zI().mIsNeedTbs = true;
            this.mNetwork.yl();
            if (this.mNetwork.yJ().zJ().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.hN();
            }
            ForumManageModel.this.gLm = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.i(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.gLm = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.i(null);
                return;
            }
            b bVar = new b();
            bVar.gLp = this.gLp;
            bVar.mPostId = this.mPostId;
            bVar.dJI = this.dJI;
            bVar.fHh = this.fHh;
            bVar.gLr = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.yN();
            if (bool.booleanValue()) {
                bVar.EY = true;
            } else {
                bVar.EY = false;
            }
            ForumManageModel.this.mLoadDataCallBack.i(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String fmP;
        final /* synthetic */ ForumManageModel gLq;
        private String mForumId;
        private String mForumName;
        private y mNetwork;
        private String mThreadId;
        private String mUserName;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            this.mNetwork = new y(strArr[0]);
            this.mNetwork.o("day", this.fmP);
            this.mNetwork.o("un", this.mUserName);
            this.mNetwork.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.o("word", this.mForumName);
            this.mNetwork.o("z", this.mThreadId);
            this.mNetwork.o("ntn", "banid");
            this.mNetwork.yJ().zI().mIsNeedTbs = true;
            this.mNetwork.yl();
            if (this.mNetwork.yJ().zJ().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.hN();
            }
            this.gLq.gLn = null;
            super.cancel(true);
            this.gLq.mLoadDataCallBack.i(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.gLq.gLn = null;
            if (this.mNetwork == null) {
                this.gLq.mLoadDataCallBack.i(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.EY = true;
            } else {
                dVar.EY = false;
                dVar.gLr = str;
            }
            this.gLq.mLoadDataCallBack.i(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.gLo != null) {
            this.gLo.cancel();
            this.gLo = null;
        }
        this.mLoadDataMode = i;
        this.gLo = new f(str, str2, str3, i, str4);
        this.gLo.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.gLo.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        String fBz;
        ArrayList<ab> gLt;
        private String mForumId;
        private String mForumName;
        private y mNetwork = null;
        private String mThreadId;
        private int mType;

        public f(String str, String str2, String str3, int i, String str4) {
            this.gLt = null;
            this.fBz = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.fBz = str4;
            this.gLt = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            this.mNetwork = new y(strArr[0]);
            this.mNetwork.o("word", this.mForumName);
            if (this.mType != 6) {
                this.mNetwork.o(ImageViewerConfig.FORUM_ID, this.mForumId);
                this.mNetwork.o("z", this.mThreadId);
                if (this.mType == 4) {
                    this.mNetwork.o("ntn", "set");
                } else if (this.mType == 5) {
                    this.mNetwork.o("ntn", "");
                } else if (this.mType == 2) {
                    this.mNetwork.o("ntn", "set");
                    this.mNetwork.o("cid", this.fBz);
                } else {
                    this.mNetwork.o("ntn", "");
                }
                this.mNetwork.o("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            this.mNetwork.yJ().zI().mIsNeedTbs = true;
            String yl = this.mNetwork.yl();
            if (this.mNetwork.yJ().zJ().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(yl).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            ab abVar = new ab();
                            abVar.parserJson(optJSONArray.optJSONObject(i));
                            this.gLt.add(abVar);
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
            ForumManageModel.this.gLo = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.i(null);
                return;
            }
            g gVar = new g();
            gVar.EY = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    gVar.gLu = this.gLt;
                }
            } else {
                gVar.gLr = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.i(gVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.hN();
            }
            ForumManageModel.this.gLo = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.i(null);
        }
    }
}
