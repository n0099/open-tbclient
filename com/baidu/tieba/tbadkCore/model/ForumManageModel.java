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
import com.baidu.tbadk.core.data.aa;
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
    private a hax;
    private c hay;
    private f haz;

    /* loaded from: classes.dex */
    public static class e {
        public String forumId;
        public String forumName;
        public int haD;
        public String threadId;
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hax = null;
        this.hay = null;
        this.haz = null;
    }

    public ForumManageModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hax = null;
        this.hay = null;
        this.haz = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean aos;
        public boolean dYd;
        public int fWT;
        public int haA;
        public String haC;
        public int mErrCode;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean aos;
        public String haC;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public boolean aos;
        public String haC;
        public ArrayList<aa> haF;

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
        if (this.hax != null) {
            this.hax.cancel();
            this.hax = null;
        }
        if (this.hay != null) {
            this.hay.cancel();
            this.hay = null;
        }
        if (this.haz != null) {
            this.haz.cancel();
            this.haz = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.hax != null) {
            this.hax.cancel();
            this.hax = null;
        }
        this.mLoadDataMode = 0;
        this.hax = new a(str, str2, str3, str4, i, i2, z);
        this.hax.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.hax.setPriority(2);
        this.hax.execute(new String[0]);
    }

    public boolean bwv() {
        return (this.hax == null && this.hay == null && this.haz == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean dYd;
        private int fWT;
        private int haA;
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
            this.haA = i;
            this.fWT = i2;
            this.dYd = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.haA == 0 || this.haA == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new x(str);
            this.mNetwork.n(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n("z", this.mThreadId);
            if (this.haA == 0) {
                if (this.fWT == 0) {
                    this.mNetwork.n("delete_my_thread", "1");
                }
            } else if (this.haA == 1) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "0");
                this.mNetwork.n("src", "1");
                if (this.fWT == 0 && this.dYd) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.haA == 2) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "1");
                this.mNetwork.n("src", "3");
                if (this.fWT == 0 && this.dYd) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.haA == 3) {
                this.mNetwork.n("delete_my_thread", "1");
                this.mNetwork.n("is_story", "1");
            }
            if (this.fWT == 0 && !this.dYd) {
                this.mNetwork.n("is_vipdel", "1");
            } else {
                this.mNetwork.n("is_vipdel", "0");
            }
            this.mNetwork.Cf().Db().mIsNeedTbs = true;
            this.mNetwork.BH();
            if (this.mNetwork.Cf().Dc().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.mR();
            }
            ForumManageModel.this.hax = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.ak(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.hax = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.ak(null);
                return;
            }
            b bVar = new b();
            bVar.haA = this.haA;
            bVar.mPostId = this.mPostId;
            bVar.dYd = this.dYd;
            bVar.fWT = this.fWT;
            bVar.haC = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.Cj();
            if (bool.booleanValue()) {
                bVar.aos = true;
            } else {
                bVar.aos = false;
            }
            ForumManageModel.this.mLoadDataCallBack.ak(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String fBK;
        final /* synthetic */ ForumManageModel haB;
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
            this.mNetwork.n("day", this.fBK);
            this.mNetwork.n("un", this.mUserName);
            this.mNetwork.n(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n("z", this.mThreadId);
            this.mNetwork.n("ntn", "banid");
            this.mNetwork.Cf().Db().mIsNeedTbs = true;
            this.mNetwork.BH();
            if (this.mNetwork.Cf().Dc().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.mR();
            }
            this.haB.hay = null;
            super.cancel(true);
            this.haB.mLoadDataCallBack.ak(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.haB.hay = null;
            if (this.mNetwork == null) {
                this.haB.mLoadDataCallBack.ak(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.aos = true;
            } else {
                dVar.aos = false;
                dVar.haC = str;
            }
            this.haB.mLoadDataCallBack.ak(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.haz != null) {
            this.haz.cancel();
            this.haz = null;
        }
        this.mLoadDataMode = i;
        this.haz = new f(str, str2, str3, i, str4);
        this.haz.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.haz.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        String fRk;
        ArrayList<aa> haE;
        private String mForumId;
        private String mForumName;
        private x mNetwork = null;
        private String mThreadId;
        private int mType;

        public f(String str, String str2, String str3, int i, String str4) {
            this.haE = null;
            this.fRk = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.fRk = str4;
            this.haE = new ArrayList<>();
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
                    this.mNetwork.n("cid", this.fRk);
                } else {
                    this.mNetwork.n("ntn", "");
                }
            }
            this.mNetwork.Cf().Db().mIsNeedTbs = true;
            String BH = this.mNetwork.BH();
            if (this.mNetwork.Cf().Dc().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(BH).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            aa aaVar = new aa();
                            aaVar.parserJson(optJSONArray.optJSONObject(i));
                            this.haE.add(aaVar);
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
            ForumManageModel.this.haz = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.ak(null);
                return;
            }
            g gVar = new g();
            gVar.aos = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    gVar.haF = this.haE;
                }
            } else {
                gVar.haC = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.ak(gVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.mR();
            }
            ForumManageModel.this.haz = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.ak(null);
        }
    }
}
