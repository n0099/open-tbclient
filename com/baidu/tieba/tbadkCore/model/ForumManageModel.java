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
    private a gzK;
    private c gzL;
    private f gzM;

    /* loaded from: classes.dex */
    public static class e {
        public String forumId;
        public String forumName;
        public int gzQ;
        public String threadId;
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gzK = null;
        this.gzL = null;
        this.gzM = null;
    }

    public ForumManageModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gzK = null;
        this.gzL = null;
        this.gzM = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean dyy;
        public int fvM;
        public int gzN;
        public String gzP;
        public int mErrCode;
        public String mPostId;
        public boolean yQ;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public String gzP;
        public boolean yQ;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public String gzP;
        public ArrayList<ab> gzS;
        public boolean yQ;

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
        if (this.gzK != null) {
            this.gzK.cancel();
            this.gzK = null;
        }
        if (this.gzL != null) {
            this.gzL.cancel();
            this.gzL = null;
        }
        if (this.gzM != null) {
            this.gzM.cancel();
            this.gzM = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.gzK != null) {
            this.gzK.cancel();
            this.gzK = null;
        }
        this.mLoadDataMode = 0;
        this.gzK = new a(str, str2, str3, str4, i, i2, z);
        this.gzK.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.gzK.setPriority(2);
        this.gzK.execute(new String[0]);
    }

    public boolean bsI() {
        return (this.gzK == null && this.gzL == null && this.gzM == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean dyy;
        private int fvM;
        private int gzN;
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
            this.gzN = i;
            this.fvM = i2;
            this.dyy = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.gzN == 0 || this.gzN == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new x(str);
            this.mNetwork.n(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n(Constants.MSG_SDK_LUA_BRIDGE_ACCELERATION_Z, this.mThreadId);
            if (this.gzN == 0) {
                if (this.fvM == 0) {
                    this.mNetwork.n("delete_my_thread", "1");
                }
            } else if (this.gzN == 1) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "0");
                this.mNetwork.n("src", "1");
                if (this.fvM == 0 && this.dyy) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.gzN == 2) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "1");
                this.mNetwork.n("src", "3");
                if (this.fvM == 0 && this.dyy) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.gzN == 3) {
                this.mNetwork.n("delete_my_thread", "1");
                this.mNetwork.n("is_story", "1");
            }
            if (this.fvM == 0 && !this.dyy) {
                this.mNetwork.n("is_vipdel", "1");
            } else {
                this.mNetwork.n("is_vipdel", "0");
            }
            this.mNetwork.vi().wh().mIsNeedTbs = true;
            this.mNetwork.uK();
            if (this.mNetwork.vi().wi().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.eW();
            }
            ForumManageModel.this.gzK = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.f(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.gzK = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.f(null);
                return;
            }
            b bVar = new b();
            bVar.gzN = this.gzN;
            bVar.mPostId = this.mPostId;
            bVar.dyy = this.dyy;
            bVar.fvM = this.fvM;
            bVar.gzP = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.vm();
            if (bool.booleanValue()) {
                bVar.yQ = true;
            } else {
                bVar.yQ = false;
            }
            ForumManageModel.this.mLoadDataCallBack.f(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String fbu;
        final /* synthetic */ ForumManageModel gzO;
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
            this.mNetwork.n("day", this.fbu);
            this.mNetwork.n("un", this.mUserName);
            this.mNetwork.n(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n(Constants.MSG_SDK_LUA_BRIDGE_ACCELERATION_Z, this.mThreadId);
            this.mNetwork.n("ntn", "banid");
            this.mNetwork.vi().wh().mIsNeedTbs = true;
            this.mNetwork.uK();
            if (this.mNetwork.vi().wi().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.eW();
            }
            this.gzO.gzL = null;
            super.cancel(true);
            this.gzO.mLoadDataCallBack.f(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.gzO.gzL = null;
            if (this.mNetwork == null) {
                this.gzO.mLoadDataCallBack.f(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.yQ = true;
            } else {
                dVar.yQ = false;
                dVar.gzP = str;
            }
            this.gzO.mLoadDataCallBack.f(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.gzM != null) {
            this.gzM.cancel();
            this.gzM = null;
        }
        this.mLoadDataMode = i;
        this.gzM = new f(str, str2, str3, i, str4);
        this.gzM.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.gzM.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        String fqh;
        ArrayList<ab> gzR;
        private String mForumId;
        private String mForumName;
        private x mNetwork = null;
        private String mThreadId;
        private int mType;

        public f(String str, String str2, String str3, int i, String str4) {
            this.gzR = null;
            this.fqh = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.fqh = str4;
            this.gzR = new ArrayList<>();
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
                    this.mNetwork.n("cid", this.fqh);
                } else {
                    this.mNetwork.n("ntn", "");
                }
            }
            this.mNetwork.vi().wh().mIsNeedTbs = true;
            String uK = this.mNetwork.uK();
            if (this.mNetwork.vi().wi().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(uK).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            ab abVar = new ab();
                            abVar.parserJson(optJSONArray.optJSONObject(i));
                            this.gzR.add(abVar);
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
            ForumManageModel.this.gzM = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.f(null);
                return;
            }
            g gVar = new g();
            gVar.yQ = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    gVar.gzS = this.gzR;
                }
            } else {
                gVar.gzP = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.f(gVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.eW();
            }
            ForumManageModel.this.gzM = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.f(null);
        }
    }
}
