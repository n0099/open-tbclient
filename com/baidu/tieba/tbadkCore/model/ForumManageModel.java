package com.baidu.tieba.tbadkCore.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.util.w;
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
    private a gkb;
    private c gkc;
    private e gkd;

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gkb = null;
        this.gkc = null;
        this.gkd = null;
    }

    public ForumManageModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gkb = null;
        this.gkc = null;
        this.gkd = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean Cm;
        public boolean cHN;
        public int eWc;
        public int gke;
        public String gkg;
        public int mErrCode;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean Cm;
        public String gkg;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public boolean Cm;
        public String gkg;
        public ArrayList<ad> gki;

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
        if (this.gkb != null) {
            this.gkb.cancel();
            this.gkb = null;
        }
        if (this.gkc != null) {
            this.gkc.cancel();
            this.gkc = null;
        }
        if (this.gkd != null) {
            this.gkd.cancel();
            this.gkd = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.gkb != null) {
            this.gkb.cancel();
            this.gkb = null;
        }
        this.mLoadDataMode = 0;
        this.gkb = new a(str, str2, str3, str4, i, i2, z);
        this.gkb.setPriority(2);
        this.gkb.execute(new String[0]);
    }

    public boolean btk() {
        return (this.gkb == null && this.gkc == null && this.gkd == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean cHN;
        private int eWc;
        private int gke;
        private String mForumId;
        private String mForumName;
        private w mNetwork = null;
        private String mPostId;
        private String mThreadId;

        public a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.gke = i;
            this.eWc = i2;
            this.cHN = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.gke == 0 || this.gke == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new w(str);
            this.mNetwork.n("fid", this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n("z", this.mThreadId);
            if (this.gke == 0) {
                if (this.eWc == 0) {
                    this.mNetwork.n("delete_my_thread", "1");
                }
            } else if (this.gke == 1) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "0");
                this.mNetwork.n("src", "1");
                if (this.eWc == 0 && this.cHN) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.gke == 2) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "1");
                this.mNetwork.n("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                if (this.eWc == 0 && this.cHN) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.gke == 3) {
                this.mNetwork.n("delete_my_thread", "1");
                this.mNetwork.n("is_story", "1");
            }
            if (this.eWc == 0 && !this.cHN) {
                this.mNetwork.n("is_vipdel", "1");
            } else {
                this.mNetwork.n("is_vipdel", "0");
            }
            this.mNetwork.vl().wh().mIsNeedTbs = true;
            this.mNetwork.uO();
            if (this.mNetwork.vl().wi().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fA();
            }
            ForumManageModel.this.gkb = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.g(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.gkb = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.g(null);
                return;
            }
            b bVar = new b();
            bVar.gke = this.gke;
            bVar.mPostId = this.mPostId;
            bVar.cHN = this.cHN;
            bVar.eWc = this.eWc;
            bVar.gkg = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.vp();
            if (bool.booleanValue()) {
                bVar.Cm = true;
            } else {
                bVar.Cm = false;
            }
            ForumManageModel.this.mLoadDataCallBack.g(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String eCh;
        final /* synthetic */ ForumManageModel gkf;
        private String mForumId;
        private String mForumName;
        private w mNetwork;
        private String mThreadId;
        private String mUserName;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            this.mNetwork = new w(strArr[0]);
            this.mNetwork.n("day", this.eCh);
            this.mNetwork.n("un", this.mUserName);
            this.mNetwork.n("fid", this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n("z", this.mThreadId);
            this.mNetwork.n("ntn", "banid");
            this.mNetwork.vl().wh().mIsNeedTbs = true;
            this.mNetwork.uO();
            if (this.mNetwork.vl().wi().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fA();
            }
            this.gkf.gkc = null;
            super.cancel(true);
            this.gkf.mLoadDataCallBack.g(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.gkf.gkc = null;
            if (this.mNetwork == null) {
                this.gkf.mLoadDataCallBack.g(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.Cm = true;
            } else {
                dVar.Cm = false;
                dVar.gkg = str;
            }
            this.gkf.mLoadDataCallBack.g(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.gkd != null) {
            this.gkd.cancel();
            this.gkd = null;
        }
        this.mLoadDataMode = i;
        this.gkd = new e(str, str2, str3, i, str4);
        this.gkd.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.gkd.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<String, String, Boolean> {
        String ePB;
        ArrayList<ad> gkh;
        private String mForumId;
        private String mForumName;
        private w mNetwork = null;
        private String mThreadId;
        private int mType;

        public e(String str, String str2, String str3, int i, String str4) {
            this.gkh = null;
            this.ePB = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.ePB = str4;
            this.gkh = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            this.mNetwork = new w(strArr[0]);
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
                    this.mNetwork.n("cid", this.ePB);
                } else {
                    this.mNetwork.n("ntn", "");
                }
            }
            this.mNetwork.vl().wh().mIsNeedTbs = true;
            String uO = this.mNetwork.uO();
            if (this.mNetwork.vl().wi().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(uO).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            ad adVar = new ad();
                            adVar.parserJson(optJSONArray.optJSONObject(i));
                            this.gkh.add(adVar);
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
            ForumManageModel.this.gkd = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.g(null);
                return;
            }
            f fVar = new f();
            fVar.Cm = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    fVar.gki = this.gkh;
                }
            } else {
                fVar.gkg = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.g(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fA();
            }
            ForumManageModel.this.gkd = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.g(null);
        }
    }
}
