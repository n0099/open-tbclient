package com.baidu.tieba.tbadkCore.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
    private e gsA;
    private a gsy;
    private c gsz;

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gsy = null;
        this.gsz = null;
        this.gsA = null;
    }

    public ForumManageModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gsy = null;
        this.gsz = null;
        this.gsA = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean Al;
        public boolean daT;
        public int fay;
        public int gsB;
        public String gsD;
        public int mErrCode;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean Al;
        public String gsD;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public boolean Al;
        public String gsD;
        public ArrayList<ad> gsF;

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
        if (this.gsy != null) {
            this.gsy.cancel();
            this.gsy = null;
        }
        if (this.gsz != null) {
            this.gsz.cancel();
            this.gsz = null;
        }
        if (this.gsA != null) {
            this.gsA.cancel();
            this.gsA = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.gsy != null) {
            this.gsy.cancel();
            this.gsy = null;
        }
        this.mLoadDataMode = 0;
        this.gsy = new a(str, str2, str3, str4, i, i2, z);
        this.gsy.setPriority(2);
        this.gsy.execute(new String[0]);
    }

    public boolean bvs() {
        return (this.gsy == null && this.gsz == null && this.gsA == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean daT;
        private int fay;
        private int gsB;
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
            this.gsB = i;
            this.fay = i2;
            this.daT = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.gsB == 0 || this.gsB == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new x(str);
            this.mNetwork.n(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n("z", this.mThreadId);
            if (this.gsB == 0) {
                if (this.fay == 0) {
                    this.mNetwork.n("delete_my_thread", "1");
                }
            } else if (this.gsB == 1) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "0");
                this.mNetwork.n("src", "1");
                if (this.fay == 0 && this.daT) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.gsB == 2) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "1");
                this.mNetwork.n("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                if (this.fay == 0 && this.daT) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.gsB == 3) {
                this.mNetwork.n("delete_my_thread", "1");
                this.mNetwork.n("is_story", "1");
            }
            if (this.fay == 0 && !this.daT) {
                this.mNetwork.n("is_vipdel", "1");
            } else {
                this.mNetwork.n("is_vipdel", "0");
            }
            this.mNetwork.uN().vK().mIsNeedTbs = true;
            this.mNetwork.up();
            if (this.mNetwork.uN().vL().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fo();
            }
            ForumManageModel.this.gsy = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.f(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.gsy = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.f(null);
                return;
            }
            b bVar = new b();
            bVar.gsB = this.gsB;
            bVar.mPostId = this.mPostId;
            bVar.daT = this.daT;
            bVar.fay = this.fay;
            bVar.gsD = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.uR();
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
        private String eEX;
        final /* synthetic */ ForumManageModel gsC;
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
            this.mNetwork.n("day", this.eEX);
            this.mNetwork.n("un", this.mUserName);
            this.mNetwork.n(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n("z", this.mThreadId);
            this.mNetwork.n("ntn", "banid");
            this.mNetwork.uN().vK().mIsNeedTbs = true;
            this.mNetwork.up();
            if (this.mNetwork.uN().vL().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fo();
            }
            this.gsC.gsz = null;
            super.cancel(true);
            this.gsC.mLoadDataCallBack.f(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.gsC.gsz = null;
            if (this.mNetwork == null) {
                this.gsC.mLoadDataCallBack.f(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.Al = true;
            } else {
                dVar.Al = false;
                dVar.gsD = str;
            }
            this.gsC.mLoadDataCallBack.f(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.gsA != null) {
            this.gsA.cancel();
            this.gsA = null;
        }
        this.mLoadDataMode = i;
        this.gsA = new e(str, str2, str3, i, str4);
        this.gsA.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.gsA.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<String, String, Boolean> {
        String eTd;
        ArrayList<ad> gsE;
        private String mForumId;
        private String mForumName;
        private x mNetwork = null;
        private String mThreadId;
        private int mType;

        public e(String str, String str2, String str3, int i, String str4) {
            this.gsE = null;
            this.eTd = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.eTd = str4;
            this.gsE = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            this.mNetwork = new x(strArr[0]);
            this.mNetwork.n("word", this.mForumName);
            if (this.mType != 6) {
                this.mNetwork.n(ImageViewerConfig.FORUM_ID, this.mForumId);
                this.mNetwork.n("z", this.mThreadId);
                if (this.mType == 4) {
                    this.mNetwork.n("ntn", "set");
                } else if (this.mType == 5) {
                    this.mNetwork.n("ntn", "");
                } else if (this.mType == 2) {
                    this.mNetwork.n("ntn", "set");
                    this.mNetwork.n("cid", this.eTd);
                } else {
                    this.mNetwork.n("ntn", "");
                }
            }
            this.mNetwork.uN().vK().mIsNeedTbs = true;
            String up = this.mNetwork.up();
            if (this.mNetwork.uN().vL().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(up).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            ad adVar = new ad();
                            adVar.parserJson(optJSONArray.optJSONObject(i));
                            this.gsE.add(adVar);
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
            ForumManageModel.this.gsA = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.f(null);
                return;
            }
            f fVar = new f();
            fVar.Al = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    fVar.gsF = this.gsE;
                }
            } else {
                fVar.gsD = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.f(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fo();
            }
            ForumManageModel.this.gsA = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.f(null);
        }
    }
}
