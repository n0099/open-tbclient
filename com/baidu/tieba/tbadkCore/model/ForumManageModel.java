package com.baidu.tieba.tbadkCore.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.util.z;
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
    public static final int DEL_TYPE_THREAD = 0;
    public static final int ERROR_CODE_PHOTO_LIVE_FORUM_LOCK = 224014;
    public static final int FORBID_USER = 1;
    public static final int GET_GOOD_LIST = 6;
    public static final int INTENT_TYPE_NONE = -1;
    private a fAl;
    private c fAm;
    private e fAn;

    public ForumManageModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fAl = null;
        this.fAm = null;
        this.fAn = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean AM;
        public boolean cnZ;
        public int evY;
        public int fAo;
        public String fAq;
        public int mErrCode;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean AM;
        public String fAq;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public boolean AM;
        public String fAq;
        public ArrayList<ad> fAs;

        public f() {
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
        if (this.fAl != null) {
            this.fAl.cancel();
            this.fAl = null;
        }
        if (this.fAm != null) {
            this.fAm.cancel();
            this.fAm = null;
        }
        if (this.fAn != null) {
            this.fAn.cancel();
            this.fAn = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.fAl != null) {
            this.fAl.cancel();
            this.fAl = null;
        }
        this.mLoadDataMode = 0;
        this.fAl = new a(str, str2, str3, str4, i, i2, z);
        this.fAl.setPriority(2);
        this.fAl.execute(new String[0]);
    }

    public boolean bkb() {
        return (this.fAl == null && this.fAm == null && this.fAn == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean cnZ;
        private int evY;
        private int fAo;
        private String mForumId;
        private String mForumName;
        private z mNetwork = null;
        private String mPostId;
        private String mThreadId;

        public a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.fAo = i;
            this.evY = i2;
            this.cnZ = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.fAo == 0) {
                str = String.valueOf(str2) + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = String.valueOf(str2) + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new z(str);
            this.mNetwork.n("fid", this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n("z", this.mThreadId);
            if (this.fAo == 0) {
                if (this.evY == 0) {
                    this.mNetwork.n("delete_my_thread", "1");
                }
            } else if (this.fAo == 1) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "0");
                this.mNetwork.n("src", "1");
                if (this.evY == 0 && this.cnZ) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.fAo == 2) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "1");
                this.mNetwork.n("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                if (this.evY == 0 && this.cnZ) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            }
            if (this.evY == 0 && !this.cnZ) {
                this.mNetwork.n("is_vipdel", "1");
            } else {
                this.mNetwork.n("is_vipdel", "0");
            }
            this.mNetwork.vw().wp().mIsNeedTbs = true;
            this.mNetwork.uY();
            if (this.mNetwork.vw().wq().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fs();
            }
            ForumManageModel.this.fAl = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.g(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.fAl = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.g(null);
                return;
            }
            b bVar = new b();
            bVar.fAo = this.fAo;
            bVar.mPostId = this.mPostId;
            bVar.cnZ = this.cnZ;
            bVar.evY = this.evY;
            bVar.fAq = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.vA();
            if (bool.booleanValue()) {
                bVar.AM = true;
            } else {
                bVar.AM = false;
            }
            ForumManageModel.this.mLoadDataCallBack.g(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String egI;
        final /* synthetic */ ForumManageModel fAp;
        private String mForumId;
        private String mForumName;
        private z mNetwork;
        private String mThreadId;
        private String mUserName;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            this.mNetwork = new z(strArr[0]);
            this.mNetwork.n("day", this.egI);
            this.mNetwork.n("un", this.mUserName);
            this.mNetwork.n("fid", this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n("z", this.mThreadId);
            this.mNetwork.n("ntn", "banid");
            this.mNetwork.vw().wp().mIsNeedTbs = true;
            this.mNetwork.uY();
            if (this.mNetwork.vw().wq().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fs();
            }
            this.fAp.fAm = null;
            super.cancel(true);
            this.fAp.mLoadDataCallBack.g(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.fAp.fAm = null;
            if (this.mNetwork == null) {
                this.fAp.mLoadDataCallBack.g(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.AM = true;
            } else {
                dVar.AM = false;
                dVar.fAq = str;
            }
            this.fAp.mLoadDataCallBack.g(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.fAn != null) {
            this.fAn.cancel();
            this.fAn = null;
        }
        this.mLoadDataMode = i;
        this.fAn = new e(str, str2, str3, i, str4);
        this.fAn.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.fAn.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<String, String, Boolean> {
        String esz;
        ArrayList<ad> fAr;
        private String mForumId;
        private String mForumName;
        private z mNetwork = null;
        private String mThreadId;
        private int mType;

        public e(String str, String str2, String str3, int i, String str4) {
            this.fAr = null;
            this.esz = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.esz = str4;
            this.fAr = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            this.mNetwork = new z(strArr[0]);
            this.mNetwork.n("word", this.mForumName);
            if (this.mType != 6) {
                this.mNetwork.n("fid", this.mForumId);
                this.mNetwork.n("z", this.mThreadId);
                if (this.mType == 4) {
                    this.mNetwork.n("ntn", "set");
                } else if (this.mType == 5) {
                    this.mNetwork.n("ntn", "");
                } else if (this.mType == 2) {
                    this.mNetwork.n("ntn", "set");
                    this.mNetwork.n("cid", this.esz);
                } else {
                    this.mNetwork.n("ntn", "");
                }
            }
            this.mNetwork.vw().wp().mIsNeedTbs = true;
            String uY = this.mNetwork.uY();
            if (this.mNetwork.vw().wq().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(uY).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            ad adVar = new ad();
                            adVar.parserJson(optJSONArray.optJSONObject(i));
                            this.fAr.add(adVar);
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
            super.onPostExecute((e) bool);
            ForumManageModel.this.fAn = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.g(null);
                return;
            }
            f fVar = new f();
            fVar.AM = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    fVar.fAs = this.fAr;
                }
            } else {
                fVar.fAq = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.g(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fs();
            }
            ForumManageModel.this.fAn = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.g(null);
        }
    }
}
