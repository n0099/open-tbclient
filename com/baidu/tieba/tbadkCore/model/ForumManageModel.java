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
    private a glT;
    private c glU;
    private e glV;

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.glT = null;
        this.glU = null;
        this.glV = null;
    }

    public ForumManageModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.glT = null;
        this.glU = null;
        this.glV = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean Co;
        public boolean cJK;
        public int eXX;
        public int glW;
        public String glY;
        public int mErrCode;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean Co;
        public String glY;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public boolean Co;
        public String glY;
        public ArrayList<ad> gma;

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
        if (this.glT != null) {
            this.glT.cancel();
            this.glT = null;
        }
        if (this.glU != null) {
            this.glU.cancel();
            this.glU = null;
        }
        if (this.glV != null) {
            this.glV.cancel();
            this.glV = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.glT != null) {
            this.glT.cancel();
            this.glT = null;
        }
        this.mLoadDataMode = 0;
        this.glT = new a(str, str2, str3, str4, i, i2, z);
        this.glT.setPriority(2);
        this.glT.execute(new String[0]);
    }

    public boolean btL() {
        return (this.glT == null && this.glU == null && this.glV == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean cJK;
        private int eXX;
        private int glW;
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
            this.glW = i;
            this.eXX = i2;
            this.cJK = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.glW == 0 || this.glW == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new w(str);
            this.mNetwork.n("fid", this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n("z", this.mThreadId);
            if (this.glW == 0) {
                if (this.eXX == 0) {
                    this.mNetwork.n("delete_my_thread", "1");
                }
            } else if (this.glW == 1) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "0");
                this.mNetwork.n("src", "1");
                if (this.eXX == 0 && this.cJK) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.glW == 2) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "1");
                this.mNetwork.n("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                if (this.eXX == 0 && this.cJK) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.glW == 3) {
                this.mNetwork.n("delete_my_thread", "1");
                this.mNetwork.n("is_story", "1");
            }
            if (this.eXX == 0 && !this.cJK) {
                this.mNetwork.n("is_vipdel", "1");
            } else {
                this.mNetwork.n("is_vipdel", "0");
            }
            this.mNetwork.vm().wi().mIsNeedTbs = true;
            this.mNetwork.uP();
            if (this.mNetwork.vm().wj().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fA();
            }
            ForumManageModel.this.glT = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.g(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.glT = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.g(null);
                return;
            }
            b bVar = new b();
            bVar.glW = this.glW;
            bVar.mPostId = this.mPostId;
            bVar.cJK = this.cJK;
            bVar.eXX = this.eXX;
            bVar.glY = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.vq();
            if (bool.booleanValue()) {
                bVar.Co = true;
            } else {
                bVar.Co = false;
            }
            ForumManageModel.this.mLoadDataCallBack.g(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String eEd;
        final /* synthetic */ ForumManageModel glX;
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
            this.mNetwork.n("day", this.eEd);
            this.mNetwork.n("un", this.mUserName);
            this.mNetwork.n("fid", this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n("z", this.mThreadId);
            this.mNetwork.n("ntn", "banid");
            this.mNetwork.vm().wi().mIsNeedTbs = true;
            this.mNetwork.uP();
            if (this.mNetwork.vm().wj().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fA();
            }
            this.glX.glU = null;
            super.cancel(true);
            this.glX.mLoadDataCallBack.g(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.glX.glU = null;
            if (this.mNetwork == null) {
                this.glX.mLoadDataCallBack.g(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.Co = true;
            } else {
                dVar.Co = false;
                dVar.glY = str;
            }
            this.glX.mLoadDataCallBack.g(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.glV != null) {
            this.glV.cancel();
            this.glV = null;
        }
        this.mLoadDataMode = i;
        this.glV = new e(str, str2, str3, i, str4);
        this.glV.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.glV.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<String, String, Boolean> {
        String eRw;
        ArrayList<ad> glZ;
        private String mForumId;
        private String mForumName;
        private w mNetwork = null;
        private String mThreadId;
        private int mType;

        public e(String str, String str2, String str3, int i, String str4) {
            this.glZ = null;
            this.eRw = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.eRw = str4;
            this.glZ = new ArrayList<>();
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
                    this.mNetwork.n("cid", this.eRw);
                } else {
                    this.mNetwork.n("ntn", "");
                }
            }
            this.mNetwork.vm().wi().mIsNeedTbs = true;
            String uP = this.mNetwork.uP();
            if (this.mNetwork.vm().wj().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(uP).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            ad adVar = new ad();
                            adVar.parserJson(optJSONArray.optJSONObject(i));
                            this.glZ.add(adVar);
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
            ForumManageModel.this.glV = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.g(null);
                return;
            }
            f fVar = new f();
            fVar.Co = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    fVar.gma = this.glZ;
                }
            } else {
                fVar.glY = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.g(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fA();
            }
            ForumManageModel.this.glV = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.g(null);
        }
    }
}
