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
    private a gXR;
    private c gXS;
    private f gXT;
    private String gXU;

    /* loaded from: classes.dex */
    public static class e {
        public String forumId;
        public String forumName;
        public int gXY;
        public String threadId;
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gXR = null;
        this.gXS = null;
        this.gXT = null;
    }

    public ForumManageModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gXR = null;
        this.gXS = null;
        this.gXT = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean Hs;
        public boolean dXb;
        public int fSV;
        public int gXV;
        public String gXX;
        public int mErrCode;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean Hs;
        public String gXX;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public boolean Hs;
        public String gXX;
        public ArrayList<aa> gYa;

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
        if (this.gXR != null) {
            this.gXR.cancel();
            this.gXR = null;
        }
        if (this.gXS != null) {
            this.gXS.cancel();
            this.gXS = null;
        }
        if (this.gXT != null) {
            this.gXT.cancel();
            this.gXT = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.gXR != null) {
            this.gXR.cancel();
            this.gXR = null;
        }
        this.mLoadDataMode = 0;
        this.gXR = new a(str, str2, str3, str4, i, i2, z);
        this.gXR.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.gXR.setPriority(2);
        this.gXR.execute(new String[0]);
    }

    public boolean bzy() {
        return (this.gXR == null && this.gXS == null && this.gXT == null) ? false : true;
    }

    public void uB(String str) {
        this.gXU = str;
    }

    public String bzz() {
        return this.gXU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean dXb;
        private int fSV;
        private String gXU;
        private int gXV;
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
            this.gXV = i;
            this.fSV = i2;
            this.dXb = z;
            this.gXU = ForumManageModel.this.bzz();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.gXV == 0 || this.gXV == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new x(str);
            this.mNetwork.u(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.u("word", this.mForumName);
            this.mNetwork.u("z", this.mThreadId);
            if (this.gXU != null) {
                this.mNetwork.u("reason", this.gXU);
            }
            if (this.gXV == 0) {
                if (this.fSV == 0) {
                    this.mNetwork.u("delete_my_thread", "1");
                }
            } else if (this.gXV == 1) {
                this.mNetwork.u(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.u("isfloor", "0");
                this.mNetwork.u("src", "1");
                if (this.fSV == 0 && this.dXb) {
                    this.mNetwork.u("delete_my_post", "1");
                }
            } else if (this.gXV == 2) {
                this.mNetwork.u(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.u("isfloor", "1");
                this.mNetwork.u("src", "3");
                if (this.fSV == 0 && this.dXb) {
                    this.mNetwork.u("delete_my_post", "1");
                }
            } else if (this.gXV == 3) {
                this.mNetwork.u("delete_my_thread", "1");
                this.mNetwork.u("is_story", "1");
            }
            if (this.fSV == 0 && !this.dXb) {
                this.mNetwork.u("is_vipdel", "1");
            } else {
                this.mNetwork.u("is_vipdel", "0");
            }
            this.mNetwork.zR().AP().mIsNeedTbs = true;
            this.mNetwork.zt();
            if (this.mNetwork.zR().AQ().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.iT();
            }
            ForumManageModel.this.gXR = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.j(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.gXR = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.j(null);
                return;
            }
            b bVar = new b();
            bVar.gXV = this.gXV;
            bVar.mPostId = this.mPostId;
            bVar.dXb = this.dXb;
            bVar.fSV = this.fSV;
            bVar.gXX = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.zV();
            if (bool.booleanValue()) {
                bVar.Hs = true;
            } else {
                bVar.Hs = false;
            }
            ForumManageModel.this.mLoadDataCallBack.j(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String fyy;
        final /* synthetic */ ForumManageModel gXW;
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
            this.mNetwork.u(Config.TRACE_VISIT_RECENT_DAY, this.fyy);
            this.mNetwork.u("un", this.mUserName);
            this.mNetwork.u(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.u("word", this.mForumName);
            this.mNetwork.u("z", this.mThreadId);
            this.mNetwork.u("ntn", "banid");
            this.mNetwork.zR().AP().mIsNeedTbs = true;
            this.mNetwork.zt();
            if (this.mNetwork.zR().AQ().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.iT();
            }
            this.gXW.gXS = null;
            super.cancel(true);
            this.gXW.mLoadDataCallBack.j(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.gXW.gXS = null;
            if (this.mNetwork == null) {
                this.gXW.mLoadDataCallBack.j(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.Hs = true;
            } else {
                dVar.Hs = false;
                dVar.gXX = str;
            }
            this.gXW.mLoadDataCallBack.j(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.gXT != null) {
            this.gXT.cancel();
            this.gXT = null;
        }
        this.mLoadDataMode = i;
        this.gXT = new f(str, str2, str3, i, str4);
        this.gXT.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.gXT.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        String fNf;
        ArrayList<aa> gXZ;
        private String mForumId;
        private String mForumName;
        private x mNetwork = null;
        private String mThreadId;
        private int mType;

        public f(String str, String str2, String str3, int i, String str4) {
            this.gXZ = null;
            this.fNf = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.fNf = str4;
            this.gXZ = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            this.mNetwork = new x(strArr[0]);
            this.mNetwork.u("word", this.mForumName);
            if (this.mType != 6) {
                this.mNetwork.u(ImageViewerConfig.FORUM_ID, this.mForumId);
                this.mNetwork.u("z", this.mThreadId);
                if (this.mType == 4) {
                    this.mNetwork.u("ntn", "set");
                } else if (this.mType == 5) {
                    this.mNetwork.u("ntn", "");
                } else if (this.mType == 2) {
                    this.mNetwork.u("ntn", "set");
                    this.mNetwork.u("cid", this.fNf);
                } else {
                    this.mNetwork.u("ntn", "");
                }
                this.mNetwork.u("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            this.mNetwork.zR().AP().mIsNeedTbs = true;
            String zt = this.mNetwork.zt();
            if (this.mNetwork.zR().AQ().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(zt).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            aa aaVar = new aa();
                            aaVar.parserJson(optJSONArray.optJSONObject(i));
                            this.gXZ.add(aaVar);
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
            ForumManageModel.this.gXT = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.j(null);
                return;
            }
            g gVar = new g();
            gVar.Hs = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    gVar.gYa = this.gXZ;
                }
            } else {
                gVar.gXX = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.j(gVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.iT();
            }
            ForumManageModel.this.gXT = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.j(null);
        }
    }
}
