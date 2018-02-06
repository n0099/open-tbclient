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
    private a hdf;
    private c hdg;
    private f hdh;

    /* loaded from: classes.dex */
    public static class e {
        public String forumId;
        public String forumName;
        public int hdl;
        public String threadId;
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hdf = null;
        this.hdg = null;
        this.hdh = null;
    }

    public ForumManageModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hdf = null;
        this.hdg = null;
        this.hdh = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean aou;
        public boolean ecK;
        public int gaw;
        public int hdi;
        public String hdk;
        public int mErrCode;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean aou;
        public String hdk;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public boolean aou;
        public String hdk;
        public ArrayList<aa> hdn;

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
        if (this.hdf != null) {
            this.hdf.cancel();
            this.hdf = null;
        }
        if (this.hdg != null) {
            this.hdg.cancel();
            this.hdg = null;
        }
        if (this.hdh != null) {
            this.hdh.cancel();
            this.hdh = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.hdf != null) {
            this.hdf.cancel();
            this.hdf = null;
        }
        this.mLoadDataMode = 0;
        this.hdf = new a(str, str2, str3, str4, i, i2, z);
        this.hdf.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.hdf.setPriority(2);
        this.hdf.execute(new String[0]);
    }

    public boolean bxG() {
        return (this.hdf == null && this.hdg == null && this.hdh == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean ecK;
        private int gaw;
        private int hdi;
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
            this.hdi = i;
            this.gaw = i2;
            this.ecK = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.hdi == 0 || this.hdi == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new x(str);
            this.mNetwork.n(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n(Constants.MSG_SDK_LUA_BRIDGE_ACCELERATION_Z, this.mThreadId);
            if (this.hdi == 0) {
                if (this.gaw == 0) {
                    this.mNetwork.n("delete_my_thread", "1");
                }
            } else if (this.hdi == 1) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "0");
                this.mNetwork.n("src", "1");
                if (this.gaw == 0 && this.ecK) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.hdi == 2) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "1");
                this.mNetwork.n("src", "3");
                if (this.gaw == 0 && this.ecK) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.hdi == 3) {
                this.mNetwork.n("delete_my_thread", "1");
                this.mNetwork.n("is_story", "1");
            }
            if (this.gaw == 0 && !this.ecK) {
                this.mNetwork.n("is_vipdel", "1");
            } else {
                this.mNetwork.n("is_vipdel", "0");
            }
            this.mNetwork.Cz().Dw().mIsNeedTbs = true;
            this.mNetwork.Cb();
            if (this.mNetwork.Cz().Dx().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.mS();
            }
            ForumManageModel.this.hdf = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.ak(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.hdf = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.ak(null);
                return;
            }
            b bVar = new b();
            bVar.hdi = this.hdi;
            bVar.mPostId = this.mPostId;
            bVar.ecK = this.ecK;
            bVar.gaw = this.gaw;
            bVar.hdk = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.CD();
            if (bool.booleanValue()) {
                bVar.aou = true;
            } else {
                bVar.aou = false;
            }
            ForumManageModel.this.mLoadDataCallBack.ak(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String fFF;
        final /* synthetic */ ForumManageModel hdj;
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
            this.mNetwork.n("day", this.fFF);
            this.mNetwork.n("un", this.mUserName);
            this.mNetwork.n(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n(Constants.MSG_SDK_LUA_BRIDGE_ACCELERATION_Z, this.mThreadId);
            this.mNetwork.n("ntn", "banid");
            this.mNetwork.Cz().Dw().mIsNeedTbs = true;
            this.mNetwork.Cb();
            if (this.mNetwork.Cz().Dx().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.mS();
            }
            this.hdj.hdg = null;
            super.cancel(true);
            this.hdj.mLoadDataCallBack.ak(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.hdj.hdg = null;
            if (this.mNetwork == null) {
                this.hdj.mLoadDataCallBack.ak(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.aou = true;
            } else {
                dVar.aou = false;
                dVar.hdk = str;
            }
            this.hdj.mLoadDataCallBack.ak(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.hdh != null) {
            this.hdh.cancel();
            this.hdh = null;
        }
        this.mLoadDataMode = i;
        this.hdh = new f(str, str2, str3, i, str4);
        this.hdh.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.hdh.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        String fUS;
        ArrayList<aa> hdm;
        private String mForumId;
        private String mForumName;
        private x mNetwork = null;
        private String mThreadId;
        private int mType;

        public f(String str, String str2, String str3, int i, String str4) {
            this.hdm = null;
            this.fUS = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.fUS = str4;
            this.hdm = new ArrayList<>();
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
                    this.mNetwork.n("cid", this.fUS);
                } else {
                    this.mNetwork.n("ntn", "");
                }
            }
            this.mNetwork.Cz().Dw().mIsNeedTbs = true;
            String Cb = this.mNetwork.Cb();
            if (this.mNetwork.Cz().Dx().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(Cb).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            aa aaVar = new aa();
                            aaVar.parserJson(optJSONArray.optJSONObject(i));
                            this.hdm.add(aaVar);
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
            ForumManageModel.this.hdh = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.ak(null);
                return;
            }
            g gVar = new g();
            gVar.aou = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    gVar.hdn = this.hdm;
                }
            } else {
                gVar.hdk = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.ak(gVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.mS();
            }
            ForumManageModel.this.hdh = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.ak(null);
        }
    }
}
