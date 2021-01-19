package com.baidu.tieba.tbadkCore.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bz;
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
    public static final int DEL_TYPE_STORY = 3;
    public static final int DEL_TYPE_THREAD = 0;
    public static final int ERROR_CODE_PHOTO_LIVE_FORUM_LOCK = 224014;
    public static final int FORBID_USER = 1;
    public static final int GET_GOOD_LIST = 6;
    public static final int INTENT_TYPE_NONE = -1;
    public static final BdUniqueId UNIQUE_ID_DEL_POST_TASK = BdUniqueId.gen();
    private int mThreadType;
    private a npD;
    private c npE;
    private f npF;
    private String npG;
    private boolean npH;
    private String npI;
    private int npJ;
    private String npK;
    private String npL;
    private int npM;

    /* loaded from: classes.dex */
    public static class e {
        public String forumId;
        public String forumName;
        public int npP;
        public String threadId;
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.npD = null;
        this.npE = null;
        this.npF = null;
        this.npH = false;
    }

    public ForumManageModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.npD = null;
        this.npE = null;
        this.npF = null;
        this.npH = false;
    }

    public void ba(bz bzVar) {
        if (bzVar != null && bzVar.getBaijiahaoData() != null) {
            this.npH = true;
            this.npI = bzVar.getBaijiahaoData().oriUgcNid;
            this.npJ = bzVar.getBaijiahaoData().oriUgcType;
            this.npL = bzVar.getBaijiahaoData().oriUgcVid;
            this.mThreadType = bzVar.threadType;
            this.npK = TbadkCoreApplication.getCurrentAccount();
            this.npM = bzVar.bnO() != null ? bzVar.bnO().video_type.intValue() : 0;
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean hgB;
        public int iHw;
        public int lYg;
        public int mErrCode;
        public String mPostId;
        public boolean mSuccess;
        public String npO;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean mSuccess;
        public String npO;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public boolean mSuccess;
        public String npO;
        public ArrayList<ak> npR;

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
        if (this.npD != null) {
            this.npD.cancel();
            this.npD = null;
        }
        if (this.npE != null) {
            this.npE.cancel();
            this.npE = null;
        }
        if (this.npF != null) {
            this.npF.cancel();
            this.npF = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z, BaijiahaoData baijiahaoData) {
        if (this.npD != null) {
            this.npD.cancel();
            this.npD = null;
        }
        this.mLoadDataMode = 0;
        this.npD = new a(str, str2, str3, str4, i, i2, z, baijiahaoData);
        this.npD.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.npD.setPriority(2);
        this.npD.execute(new String[0]);
    }

    public boolean dMh() {
        return (this.npD == null && this.npE == null && this.npF == null) ? false : true;
    }

    public void Sv(String str) {
        this.npG = str;
    }

    public String dMi() {
        return this.npG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean hgB;
        private int iHw;
        private int lYg;
        private BaijiahaoData mBaijiahaoData;
        private String mForumId;
        private String mForumName;
        private z mNetwork = null;
        private String mPostId;
        private String mThreadId;
        private String npG;

        public a(String str, String str2, String str3, String str4, int i, int i2, boolean z, BaijiahaoData baijiahaoData) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.iHw = i;
            this.lYg = i2;
            this.hgB = z;
            this.npG = ForumManageModel.this.dMi();
            this.mBaijiahaoData = baijiahaoData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.iHw == 0 || this.iHw == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new z(str);
            this.mNetwork.addPostData("fid", this.mForumId);
            this.mNetwork.addPostData("word", this.mForumName);
            this.mNetwork.addPostData("z", this.mThreadId);
            if (this.npG != null) {
                this.mNetwork.addPostData(TiebaInitialize.LogFields.REASON, this.npG);
            }
            if (this.iHw == 0) {
                if (this.lYg == 0) {
                    this.mNetwork.addPostData("delete_my_thread", "1");
                }
            } else if (this.iHw == 1) {
                this.mNetwork.addPostData("pid", this.mPostId);
                this.mNetwork.addPostData("isfloor", "0");
                this.mNetwork.addPostData(UserAccountActionItem.KEY_SRC, "1");
                if (this.lYg == 0 && this.hgB) {
                    this.mNetwork.addPostData("delete_my_post", "1");
                }
            } else if (this.iHw == 2) {
                this.mNetwork.addPostData("pid", this.mPostId);
                this.mNetwork.addPostData("isfloor", "1");
                this.mNetwork.addPostData(UserAccountActionItem.KEY_SRC, "3");
                if (this.lYg == 0 && this.hgB) {
                    this.mNetwork.addPostData("delete_my_post", "1");
                }
            } else if (this.iHw == 3) {
                this.mNetwork.addPostData("delete_my_thread", "1");
                this.mNetwork.addPostData("is_story", "1");
            }
            if (this.lYg == 0 && !this.hgB) {
                this.mNetwork.addPostData("is_vipdel", "1");
            } else {
                this.mNetwork.addPostData("is_vipdel", "0");
            }
            if (this.iHw == 0 && ForumManageModel.this.npH) {
                ForumManageModel.this.npH = false;
                this.mNetwork.addPostData("ori_ugc_nid", ForumManageModel.this.npI);
                this.mNetwork.addPostData("thread_type", String.valueOf(ForumManageModel.this.mThreadType));
                this.mNetwork.addPostData("ori_ugc_type", String.valueOf(ForumManageModel.this.npJ));
                this.mNetwork.addPostData("owner_uid", ForumManageModel.this.npK);
                this.mNetwork.addPostData("ori_ugc_vid", ForumManageModel.this.npL);
                this.mNetwork.addPostData(LogConfig.LOG_VIDEO_TYPE, String.valueOf(ForumManageModel.this.npM));
            } else if (this.mBaijiahaoData != null) {
                this.mNetwork.addPostData("ori_ugc_nid", this.mBaijiahaoData.oriUgcNid);
                this.mNetwork.addPostData("ori_ugc_tid", this.mBaijiahaoData.oriUgcTid);
                this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.mBaijiahaoData.oriUgcType));
                this.mNetwork.addPostData("ori_ugc_vid", this.mBaijiahaoData.oriUgcVid);
                this.mNetwork.addPostData("owner_uid", TbadkCoreApplication.getCurrentAccount());
            }
            this.mNetwork.brX().bsG().mIsNeedTbs = true;
            this.mNetwork.postNetData();
            if (this.mNetwork.brX().bsH().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            ForumManageModel.this.npD = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.callback(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.npD = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.callback(null);
                return;
            }
            b bVar = new b();
            bVar.iHw = this.iHw;
            bVar.mPostId = this.mPostId;
            bVar.hgB = this.hgB;
            bVar.lYg = this.lYg;
            bVar.npO = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.getServerErrorCode();
            bVar.mSuccess = bool.booleanValue();
            ForumManageModel.this.mLoadDataCallBack.callback(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String lzE;
        private String mForumId;
        private String mForumName;
        private z mNetwork;
        private String mThreadId;
        private String mUserName;
        final /* synthetic */ ForumManageModel npN;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            this.mNetwork = new z(strArr[0]);
            this.mNetwork.addPostData(Config.TRACE_VISIT_RECENT_DAY, this.lzE);
            this.mNetwork.addPostData("un", this.mUserName);
            this.mNetwork.addPostData("fid", this.mForumId);
            this.mNetwork.addPostData("word", this.mForumName);
            this.mNetwork.addPostData("z", this.mThreadId);
            this.mNetwork.addPostData("ntn", "banid");
            this.mNetwork.brX().bsG().mIsNeedTbs = true;
            this.mNetwork.postNetData();
            if (this.mNetwork.brX().bsH().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            this.npN.npE = null;
            super.cancel(true);
            this.npN.mLoadDataCallBack.callback(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.npN.npE = null;
            if (this.mNetwork == null) {
                this.npN.mLoadDataCallBack.callback(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.mSuccess = true;
            } else {
                dVar.mSuccess = false;
                dVar.npO = str;
            }
            this.npN.mLoadDataCallBack.callback(dVar);
        }
    }

    public void c(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.npF != null) {
            this.npF.cancel();
            this.npF = null;
        }
        this.mLoadDataMode = i;
        this.npF = new f(str, str2, str3, i, str4);
        this.npF.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.npF.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        String lQq;
        private String mForumId;
        private String mForumName;
        private z mNetwork = null;
        private String mThreadId;
        private int mType;
        ArrayList<ak> npQ;

        public f(String str, String str2, String str3, int i, String str4) {
            this.npQ = null;
            this.lQq = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.lQq = str4;
            this.npQ = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            this.mNetwork = new z(strArr[0]);
            this.mNetwork.addPostData("word", this.mForumName);
            if (this.mType != 6) {
                this.mNetwork.addPostData("fid", this.mForumId);
                this.mNetwork.addPostData("z", this.mThreadId);
                if (this.mType == 4) {
                    this.mNetwork.addPostData("ntn", "set");
                } else if (this.mType == 5) {
                    this.mNetwork.addPostData("ntn", "");
                } else if (this.mType == 2) {
                    this.mNetwork.addPostData("ntn", "set");
                    this.mNetwork.addPostData(IXAdRequestInfo.CELL_ID, this.lQq);
                } else {
                    this.mNetwork.addPostData("ntn", "");
                }
                this.mNetwork.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            this.mNetwork.brX().bsG().mIsNeedTbs = true;
            String postNetData = this.mNetwork.postNetData();
            if (this.mNetwork.brX().bsH().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(postNetData).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            ak akVar = new ak();
                            akVar.parserJson(optJSONArray.optJSONObject(i));
                            this.npQ.add(akVar);
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
            ForumManageModel.this.npF = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.callback(null);
                return;
            }
            g gVar = new g();
            gVar.mSuccess = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    gVar.npR = this.npQ;
                }
            } else {
                gVar.npO = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.callback(gVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            ForumManageModel.this.npF = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.callback(null);
        }
    }
}
