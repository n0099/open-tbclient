package com.baidu.tieba.tbadkCore.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ab;
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
    private a gyJ;
    private c gyK;
    private f gyL;

    /* loaded from: classes.dex */
    public static class e {
        public String forumId;
        public String forumName;
        public int gyP;
        public String threadId;
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gyJ = null;
        this.gyK = null;
        this.gyL = null;
    }

    public ForumManageModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gyJ = null;
        this.gyK = null;
        this.gyL = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean dxu;
        public int fuJ;
        public int gyM;
        public String gyO;
        public int mErrCode;
        public String mPostId;
        public boolean yR;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public String gyO;
        public boolean yR;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public String gyO;
        public ArrayList<ab> gyR;
        public boolean yR;

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
        if (this.gyJ != null) {
            this.gyJ.cancel();
            this.gyJ = null;
        }
        if (this.gyK != null) {
            this.gyK.cancel();
            this.gyK = null;
        }
        if (this.gyL != null) {
            this.gyL.cancel();
            this.gyL = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.gyJ != null) {
            this.gyJ.cancel();
            this.gyJ = null;
        }
        this.mLoadDataMode = 0;
        this.gyJ = new a(str, str2, str3, str4, i, i2, z);
        this.gyJ.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.gyJ.setPriority(2);
        this.gyJ.execute(new String[0]);
    }

    public boolean bsK() {
        return (this.gyJ == null && this.gyK == null && this.gyL == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean dxu;
        private int fuJ;
        private int gyM;
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
            this.gyM = i;
            this.fuJ = i2;
            this.dxu = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.gyM == 0 || this.gyM == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new x(str);
            this.mNetwork.n(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n(Constants.MSG_SDK_LUA_BRIDGE_ACCELERATION_Z, this.mThreadId);
            if (this.gyM == 0) {
                if (this.fuJ == 0) {
                    this.mNetwork.n("delete_my_thread", "1");
                }
            } else if (this.gyM == 1) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "0");
                this.mNetwork.n("src", "1");
                if (this.fuJ == 0 && this.dxu) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.gyM == 2) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "1");
                this.mNetwork.n("src", "3");
                if (this.fuJ == 0 && this.dxu) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.gyM == 3) {
                this.mNetwork.n("delete_my_thread", "1");
                this.mNetwork.n("is_story", "1");
            }
            if (this.fuJ == 0 && !this.dxu) {
                this.mNetwork.n("is_vipdel", "1");
            } else {
                this.mNetwork.n("is_vipdel", "0");
            }
            this.mNetwork.vj().wi().mIsNeedTbs = true;
            this.mNetwork.uL();
            if (this.mNetwork.vj().wj().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.eW();
            }
            ForumManageModel.this.gyJ = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.f(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.gyJ = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.f(null);
                return;
            }
            b bVar = new b();
            bVar.gyM = this.gyM;
            bVar.mPostId = this.mPostId;
            bVar.dxu = this.dxu;
            bVar.fuJ = this.fuJ;
            bVar.gyO = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.vn();
            if (bool.booleanValue()) {
                bVar.yR = true;
            } else {
                bVar.yR = false;
            }
            ForumManageModel.this.mLoadDataCallBack.f(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String faq;
        final /* synthetic */ ForumManageModel gyN;
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
            this.mNetwork.n("day", this.faq);
            this.mNetwork.n("un", this.mUserName);
            this.mNetwork.n(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n(Constants.MSG_SDK_LUA_BRIDGE_ACCELERATION_Z, this.mThreadId);
            this.mNetwork.n("ntn", "banid");
            this.mNetwork.vj().wi().mIsNeedTbs = true;
            this.mNetwork.uL();
            if (this.mNetwork.vj().wj().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.eW();
            }
            this.gyN.gyK = null;
            super.cancel(true);
            this.gyN.mLoadDataCallBack.f(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.gyN.gyK = null;
            if (this.mNetwork == null) {
                this.gyN.mLoadDataCallBack.f(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.yR = true;
            } else {
                dVar.yR = false;
                dVar.gyO = str;
            }
            this.gyN.mLoadDataCallBack.f(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.gyL != null) {
            this.gyL.cancel();
            this.gyL = null;
        }
        this.mLoadDataMode = i;
        this.gyL = new f(str, str2, str3, i, str4);
        this.gyL.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.gyL.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        String fpc;
        ArrayList<ab> gyQ;
        private String mForumId;
        private String mForumName;
        private x mNetwork = null;
        private String mThreadId;
        private int mType;

        public f(String str, String str2, String str3, int i, String str4) {
            this.gyQ = null;
            this.fpc = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.fpc = str4;
            this.gyQ = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            this.mNetwork = new x(strArr[0]);
            this.mNetwork.n("word", this.mForumName);
            if (this.mType != 6) {
                this.mNetwork.n(ImageViewerConfig.FORUM_ID, this.mForumId);
                this.mNetwork.n(Constants.MSG_SDK_LUA_BRIDGE_ACCELERATION_Z, this.mThreadId);
                if (this.mType == 4) {
                    this.mNetwork.n("ntn", "set");
                } else if (this.mType == 5) {
                    this.mNetwork.n("ntn", "");
                } else if (this.mType == 2) {
                    this.mNetwork.n("ntn", "set");
                    this.mNetwork.n("cid", this.fpc);
                } else {
                    this.mNetwork.n("ntn", "");
                }
            }
            this.mNetwork.vj().wi().mIsNeedTbs = true;
            String uL = this.mNetwork.uL();
            if (this.mNetwork.vj().wj().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(uL).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            ab abVar = new ab();
                            abVar.parserJson(optJSONArray.optJSONObject(i));
                            this.gyQ.add(abVar);
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
            ForumManageModel.this.gyL = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.f(null);
                return;
            }
            g gVar = new g();
            gVar.yR = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    gVar.gyR = this.gyQ;
                }
            } else {
                gVar.gyO = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.f(gVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.eW();
            }
            ForumManageModel.this.gyL = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.f(null);
        }
    }
}
