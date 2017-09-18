package com.baidu.tieba.tbadkCore.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ad;
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
    private a glp;
    private c glq;
    private e glr;

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.glp = null;
        this.glq = null;
        this.glr = null;
    }

    public ForumManageModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.glp = null;
        this.glq = null;
        this.glr = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean Ai;
        public boolean cQT;
        public int eXA;
        public int gls;
        public String glu;
        public int mErrCode;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean Ai;
        public String glu;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public boolean Ai;
        public String glu;
        public ArrayList<ad> glw;

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
        if (this.glp != null) {
            this.glp.cancel();
            this.glp = null;
        }
        if (this.glq != null) {
            this.glq.cancel();
            this.glq = null;
        }
        if (this.glr != null) {
            this.glr.cancel();
            this.glr = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.glp != null) {
            this.glp.cancel();
            this.glp = null;
        }
        this.mLoadDataMode = 0;
        this.glp = new a(str, str2, str3, str4, i, i2, z);
        this.glp.setPriority(2);
        this.glp.execute(new String[0]);
    }

    public boolean btl() {
        return (this.glp == null && this.glq == null && this.glr == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean cQT;
        private int eXA;
        private int gls;
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
            this.gls = i;
            this.eXA = i2;
            this.cQT = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.gls == 0 || this.gls == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new x(str);
            this.mNetwork.n("fid", this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n("z", this.mThreadId);
            if (this.gls == 0) {
                if (this.eXA == 0) {
                    this.mNetwork.n("delete_my_thread", "1");
                }
            } else if (this.gls == 1) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "0");
                this.mNetwork.n("src", "1");
                if (this.eXA == 0 && this.cQT) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.gls == 2) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "1");
                this.mNetwork.n("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                if (this.eXA == 0 && this.cQT) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.gls == 3) {
                this.mNetwork.n("delete_my_thread", "1");
                this.mNetwork.n("is_story", "1");
            }
            if (this.eXA == 0 && !this.cQT) {
                this.mNetwork.n("is_vipdel", "1");
            } else {
                this.mNetwork.n("is_vipdel", "0");
            }
            this.mNetwork.vj().wf().mIsNeedTbs = true;
            this.mNetwork.uM();
            if (this.mNetwork.vj().wg().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fp();
            }
            ForumManageModel.this.glp = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.f(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.glp = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.f(null);
                return;
            }
            b bVar = new b();
            bVar.gls = this.gls;
            bVar.mPostId = this.mPostId;
            bVar.cQT = this.cQT;
            bVar.eXA = this.eXA;
            bVar.glu = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.vn();
            if (bool.booleanValue()) {
                bVar.Ai = true;
            } else {
                bVar.Ai = false;
            }
            ForumManageModel.this.mLoadDataCallBack.f(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String eDq;
        final /* synthetic */ ForumManageModel glt;
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
            this.mNetwork.n("day", this.eDq);
            this.mNetwork.n("un", this.mUserName);
            this.mNetwork.n("fid", this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n("z", this.mThreadId);
            this.mNetwork.n("ntn", "banid");
            this.mNetwork.vj().wf().mIsNeedTbs = true;
            this.mNetwork.uM();
            if (this.mNetwork.vj().wg().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fp();
            }
            this.glt.glq = null;
            super.cancel(true);
            this.glt.mLoadDataCallBack.f(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.glt.glq = null;
            if (this.mNetwork == null) {
                this.glt.mLoadDataCallBack.f(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.Ai = true;
            } else {
                dVar.Ai = false;
                dVar.glu = str;
            }
            this.glt.mLoadDataCallBack.f(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.glr != null) {
            this.glr.cancel();
            this.glr = null;
        }
        this.mLoadDataMode = i;
        this.glr = new e(str, str2, str3, i, str4);
        this.glr.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.glr.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<String, String, Boolean> {
        String eQx;
        ArrayList<ad> glv;
        private String mForumId;
        private String mForumName;
        private x mNetwork = null;
        private String mThreadId;
        private int mType;

        public e(String str, String str2, String str3, int i, String str4) {
            this.glv = null;
            this.eQx = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.eQx = str4;
            this.glv = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            this.mNetwork = new x(strArr[0]);
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
                    this.mNetwork.n("cid", this.eQx);
                } else {
                    this.mNetwork.n("ntn", "");
                }
            }
            this.mNetwork.vj().wf().mIsNeedTbs = true;
            String uM = this.mNetwork.uM();
            if (this.mNetwork.vj().wg().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(uM).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            ad adVar = new ad();
                            adVar.parserJson(optJSONArray.optJSONObject(i));
                            this.glv.add(adVar);
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
            ForumManageModel.this.glr = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.f(null);
                return;
            }
            f fVar = new f();
            fVar.Ai = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    fVar.glw = this.glv;
                }
            } else {
                fVar.glu = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.f(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fp();
            }
            ForumManageModel.this.glr = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.f(null);
        }
    }
}
