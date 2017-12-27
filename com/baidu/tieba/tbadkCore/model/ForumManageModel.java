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
    private a hkW;
    private c hkX;
    private f hkY;

    /* loaded from: classes.dex */
    public static class e {
        public String forumId;
        public String forumName;
        public int hlc;
        public String threadId;
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hkW = null;
        this.hkX = null;
        this.hkY = null;
    }

    public ForumManageModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hkW = null;
        this.hkX = null;
        this.hkY = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean aot;
        public boolean dWS;
        public int fVt;
        public int hkZ;
        public String hlb;
        public int mErrCode;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean aot;
        public String hlb;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public boolean aot;
        public String hlb;
        public ArrayList<aa> hle;

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
        if (this.hkW != null) {
            this.hkW.cancel();
            this.hkW = null;
        }
        if (this.hkX != null) {
            this.hkX.cancel();
            this.hkX = null;
        }
        if (this.hkY != null) {
            this.hkY.cancel();
            this.hkY = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.hkW != null) {
            this.hkW.cancel();
            this.hkW = null;
        }
        this.mLoadDataMode = 0;
        this.hkW = new a(str, str2, str3, str4, i, i2, z);
        this.hkW.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.hkW.setPriority(2);
        this.hkW.execute(new String[0]);
    }

    public boolean bCZ() {
        return (this.hkW == null && this.hkX == null && this.hkY == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean dWS;
        private int fVt;
        private int hkZ;
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
            this.hkZ = i;
            this.fVt = i2;
            this.dWS = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.hkZ == 0 || this.hkZ == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new x(str);
            this.mNetwork.n(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n("z", this.mThreadId);
            if (this.hkZ == 0) {
                if (this.fVt == 0) {
                    this.mNetwork.n("delete_my_thread", "1");
                }
            } else if (this.hkZ == 1) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "0");
                this.mNetwork.n("src", "1");
                if (this.fVt == 0 && this.dWS) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.hkZ == 2) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "1");
                this.mNetwork.n("src", "3");
                if (this.fVt == 0 && this.dWS) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.hkZ == 3) {
                this.mNetwork.n("delete_my_thread", "1");
                this.mNetwork.n("is_story", "1");
            }
            if (this.fVt == 0 && !this.dWS) {
                this.mNetwork.n("is_vipdel", "1");
            } else {
                this.mNetwork.n("is_vipdel", "0");
            }
            this.mNetwork.Cn().Dk().mIsNeedTbs = true;
            this.mNetwork.BP();
            if (this.mNetwork.Cn().Dl().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.mR();
            }
            ForumManageModel.this.hkW = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.ak(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.hkW = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.ak(null);
                return;
            }
            b bVar = new b();
            bVar.hkZ = this.hkZ;
            bVar.mPostId = this.mPostId;
            bVar.dWS = this.dWS;
            bVar.fVt = this.fVt;
            bVar.hlb = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.Cr();
            if (bool.booleanValue()) {
                bVar.aot = true;
            } else {
                bVar.aot = false;
            }
            ForumManageModel.this.mLoadDataCallBack.ak(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String fAk;
        final /* synthetic */ ForumManageModel hla;
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
            this.mNetwork.n("day", this.fAk);
            this.mNetwork.n("un", this.mUserName);
            this.mNetwork.n(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n("z", this.mThreadId);
            this.mNetwork.n("ntn", "banid");
            this.mNetwork.Cn().Dk().mIsNeedTbs = true;
            this.mNetwork.BP();
            if (this.mNetwork.Cn().Dl().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.mR();
            }
            this.hla.hkX = null;
            super.cancel(true);
            this.hla.mLoadDataCallBack.ak(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.hla.hkX = null;
            if (this.mNetwork == null) {
                this.hla.mLoadDataCallBack.ak(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.aot = true;
            } else {
                dVar.aot = false;
                dVar.hlb = str;
            }
            this.hla.mLoadDataCallBack.ak(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.hkY != null) {
            this.hkY.cancel();
            this.hkY = null;
        }
        this.mLoadDataMode = i;
        this.hkY = new f(str, str2, str3, i, str4);
        this.hkY.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.hkY.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        String fPK;
        ArrayList<aa> hld;
        private String mForumId;
        private String mForumName;
        private x mNetwork = null;
        private String mThreadId;
        private int mType;

        public f(String str, String str2, String str3, int i, String str4) {
            this.hld = null;
            this.fPK = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.fPK = str4;
            this.hld = new ArrayList<>();
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
                    this.mNetwork.n("cid", this.fPK);
                } else {
                    this.mNetwork.n("ntn", "");
                }
            }
            this.mNetwork.Cn().Dk().mIsNeedTbs = true;
            String BP = this.mNetwork.BP();
            if (this.mNetwork.Cn().Dl().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(BP).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            aa aaVar = new aa();
                            aaVar.parserJson(optJSONArray.optJSONObject(i));
                            this.hld.add(aaVar);
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
            ForumManageModel.this.hkY = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.ak(null);
                return;
            }
            g gVar = new g();
            gVar.aot = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    gVar.hle = this.hld;
                }
            } else {
                gVar.hlb = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.ak(gVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.mR();
            }
            ForumManageModel.this.hkY = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.ak(null);
        }
    }
}
