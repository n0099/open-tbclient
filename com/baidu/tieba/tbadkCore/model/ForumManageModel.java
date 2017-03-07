package com.baidu.tieba.tbadkCore.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ae;
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
    private a fwl;
    private c fwm;
    private e fwn;

    public ForumManageModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fwl = null;
        this.fwm = null;
        this.fwn = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean Bi;
        public boolean cnh;
        public int evD;
        public int fwo;
        public String fwq;
        public int mErrCode;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean Bi;
        public String fwq;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public boolean Bi;
        public String fwq;
        public ArrayList<ae> fws;

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
        if (this.fwl != null) {
            this.fwl.cancel();
            this.fwl = null;
        }
        if (this.fwm != null) {
            this.fwm.cancel();
            this.fwm = null;
        }
        if (this.fwn != null) {
            this.fwn.cancel();
            this.fwn = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.fwl != null) {
            this.fwl.cancel();
            this.fwl = null;
        }
        this.mLoadDataMode = 0;
        this.fwl = new a(str, str2, str3, str4, i, i2, z);
        this.fwl.setPriority(2);
        this.fwl.execute(new String[0]);
    }

    public boolean bip() {
        return (this.fwl == null && this.fwm == null && this.fwn == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean cnh;
        private int evD;
        private int fwo;
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
            this.fwo = i;
            this.evD = i2;
            this.cnh = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.fwo == 0) {
                str = String.valueOf(str2) + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = String.valueOf(str2) + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new z(str);
            this.mNetwork.n("fid", this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n("z", this.mThreadId);
            if (this.fwo == 0) {
                if (this.evD == 0) {
                    this.mNetwork.n("delete_my_thread", "1");
                }
            } else if (this.fwo == 1) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "0");
                this.mNetwork.n("src", "1");
                if (this.evD == 0 && this.cnh) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.fwo == 2) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "1");
                this.mNetwork.n("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                if (this.evD == 0 && this.cnh) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            }
            if (this.evD == 0 && !this.cnh) {
                this.mNetwork.n("is_vipdel", "1");
            } else {
                this.mNetwork.n("is_vipdel", "0");
            }
            this.mNetwork.uZ().vS().mIsNeedTbs = true;
            this.mNetwork.uB();
            if (this.mNetwork.uZ().vT().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fm();
            }
            ForumManageModel.this.fwl = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.g(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            ForumManageModel.this.fwl = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.g(null);
                return;
            }
            b bVar = new b();
            bVar.fwo = this.fwo;
            bVar.mPostId = this.mPostId;
            bVar.cnh = this.cnh;
            bVar.evD = this.evD;
            bVar.fwq = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.vd();
            if (bool.booleanValue()) {
                bVar.Bi = true;
            } else {
                bVar.Bi = false;
            }
            ForumManageModel.this.mLoadDataCallBack.g(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String egl;
        final /* synthetic */ ForumManageModel fwp;
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
            this.mNetwork.n("day", this.egl);
            this.mNetwork.n("un", this.mUserName);
            this.mNetwork.n("fid", this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n("z", this.mThreadId);
            this.mNetwork.n("ntn", "banid");
            this.mNetwork.uZ().vS().mIsNeedTbs = true;
            this.mNetwork.uB();
            if (this.mNetwork.uZ().vT().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fm();
            }
            this.fwp.fwm = null;
            super.cancel(true);
            this.fwp.mLoadDataCallBack.g(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.fwp.fwm = null;
            if (this.mNetwork == null) {
                this.fwp.mLoadDataCallBack.g(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.Bi = true;
            } else {
                dVar.Bi = false;
                dVar.fwq = str;
            }
            this.fwp.mLoadDataCallBack.g(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.fwn != null) {
            this.fwn.cancel();
            this.fwn = null;
        }
        this.mLoadDataMode = i;
        this.fwn = new e(str, str2, str3, i, str4);
        this.fwn.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.fwn.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<String, String, Boolean> {
        String erZ;
        ArrayList<ae> fwr;
        private String mForumId;
        private String mForumName;
        private z mNetwork = null;
        private String mThreadId;
        private int mType;

        public e(String str, String str2, String str3, int i, String str4) {
            this.fwr = null;
            this.erZ = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.erZ = str4;
            this.fwr = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
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
                    this.mNetwork.n("cid", this.erZ);
                } else {
                    this.mNetwork.n("ntn", "");
                }
            }
            this.mNetwork.uZ().vS().mIsNeedTbs = true;
            String uB = this.mNetwork.uB();
            if (this.mNetwork.uZ().vT().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(uB).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            ae aeVar = new ae();
                            aeVar.parserJson(optJSONArray.optJSONObject(i));
                            this.fwr.add(aeVar);
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
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            ForumManageModel.this.fwn = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.g(null);
                return;
            }
            f fVar = new f();
            fVar.Bi = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    fVar.fws = this.fwr;
                }
            } else {
                fVar.fwq = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.g(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fm();
            }
            ForumManageModel.this.fwn = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.g(null);
        }
    }
}
