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
    private a giK;
    private c giL;
    private e giM;

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.giK = null;
        this.giL = null;
        this.giM = null;
    }

    public ForumManageModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.giK = null;
        this.giL = null;
        this.giM = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean Al;
        public boolean cRI;
        public int eRv;
        public int giN;
        public String giP;
        public int mErrCode;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean Al;
        public String giP;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public boolean Al;
        public String giP;
        public ArrayList<ad> giR;

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
        if (this.giK != null) {
            this.giK.cancel();
            this.giK = null;
        }
        if (this.giL != null) {
            this.giL.cancel();
            this.giL = null;
        }
        if (this.giM != null) {
            this.giM.cancel();
            this.giM = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.giK != null) {
            this.giK.cancel();
            this.giK = null;
        }
        this.mLoadDataMode = 0;
        this.giK = new a(str, str2, str3, str4, i, i2, z);
        this.giK.setPriority(2);
        this.giK.execute(new String[0]);
    }

    public boolean bsc() {
        return (this.giK == null && this.giL == null && this.giM == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean cRI;
        private int eRv;
        private int giN;
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
            this.giN = i;
            this.eRv = i2;
            this.cRI = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.giN == 0 || this.giN == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new x(str);
            this.mNetwork.n("fid", this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n("z", this.mThreadId);
            if (this.giN == 0) {
                if (this.eRv == 0) {
                    this.mNetwork.n("delete_my_thread", "1");
                }
            } else if (this.giN == 1) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "0");
                this.mNetwork.n("src", "1");
                if (this.eRv == 0 && this.cRI) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.giN == 2) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "1");
                this.mNetwork.n("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                if (this.eRv == 0 && this.cRI) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.giN == 3) {
                this.mNetwork.n("delete_my_thread", "1");
                this.mNetwork.n("is_story", "1");
            }
            if (this.eRv == 0 && !this.cRI) {
                this.mNetwork.n("is_vipdel", "1");
            } else {
                this.mNetwork.n("is_vipdel", "0");
            }
            this.mNetwork.uG().vC().mIsNeedTbs = true;
            this.mNetwork.ui();
            if (this.mNetwork.uG().vD().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fo();
            }
            ForumManageModel.this.giK = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.f(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.giK = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.f(null);
                return;
            }
            b bVar = new b();
            bVar.giN = this.giN;
            bVar.mPostId = this.mPostId;
            bVar.cRI = this.cRI;
            bVar.eRv = this.eRv;
            bVar.giP = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.uK();
            if (bool.booleanValue()) {
                bVar.Al = true;
            } else {
                bVar.Al = false;
            }
            ForumManageModel.this.mLoadDataCallBack.f(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String ewu;
        final /* synthetic */ ForumManageModel giO;
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
            this.mNetwork.n("day", this.ewu);
            this.mNetwork.n("un", this.mUserName);
            this.mNetwork.n("fid", this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n("z", this.mThreadId);
            this.mNetwork.n("ntn", "banid");
            this.mNetwork.uG().vC().mIsNeedTbs = true;
            this.mNetwork.ui();
            if (this.mNetwork.uG().vD().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fo();
            }
            this.giO.giL = null;
            super.cancel(true);
            this.giO.mLoadDataCallBack.f(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.giO.giL = null;
            if (this.mNetwork == null) {
                this.giO.mLoadDataCallBack.f(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.Al = true;
            } else {
                dVar.Al = false;
                dVar.giP = str;
            }
            this.giO.mLoadDataCallBack.f(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.giM != null) {
            this.giM.cancel();
            this.giM = null;
        }
        this.mLoadDataMode = i;
        this.giM = new e(str, str2, str3, i, str4);
        this.giM.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.giM.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<String, String, Boolean> {
        String eJU;
        ArrayList<ad> giQ;
        private String mForumId;
        private String mForumName;
        private x mNetwork = null;
        private String mThreadId;
        private int mType;

        public e(String str, String str2, String str3, int i, String str4) {
            this.giQ = null;
            this.eJU = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.eJU = str4;
            this.giQ = new ArrayList<>();
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
                    this.mNetwork.n("cid", this.eJU);
                } else {
                    this.mNetwork.n("ntn", "");
                }
            }
            this.mNetwork.uG().vC().mIsNeedTbs = true;
            String ui = this.mNetwork.ui();
            if (this.mNetwork.uG().vD().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(ui).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            ad adVar = new ad();
                            adVar.parserJson(optJSONArray.optJSONObject(i));
                            this.giQ.add(adVar);
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
            ForumManageModel.this.giM = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.f(null);
                return;
            }
            f fVar = new f();
            fVar.Al = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    fVar.giR = this.giQ;
                }
            } else {
                fVar.giP = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.f(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fo();
            }
            ForumManageModel.this.giM = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.f(null);
        }
    }
}
