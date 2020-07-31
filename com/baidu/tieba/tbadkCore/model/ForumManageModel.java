package com.baidu.tieba.tbadkCore.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.bv;
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
    private a lPE;
    private c lPF;
    private f lPG;
    private String lPH;
    private boolean lPI;
    private String lPJ;
    private int lPK;
    private String lPL;
    private String lPM;
    private int mThreadType;
    private int mVideoType;

    /* loaded from: classes.dex */
    public static class e {
        public String forumId;
        public String forumName;
        public int lPP;
        public String threadId;
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lPE = null;
        this.lPF = null;
        this.lPG = null;
        this.lPI = false;
    }

    public ForumManageModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.lPE = null;
        this.lPF = null;
        this.lPG = null;
        this.lPI = false;
    }

    public void aV(bv bvVar) {
        if (bvVar != null && bvVar.getBaijiahaoData() != null) {
            this.lPI = true;
            this.lPJ = bvVar.getBaijiahaoData().oriUgcNid;
            this.lPK = bvVar.getBaijiahaoData().oriUgcType;
            this.lPM = bvVar.getBaijiahaoData().oriUgcVid;
            this.mThreadType = bvVar.threadType;
            this.lPL = TbadkCoreApplication.getCurrentAccount();
            this.mVideoType = bvVar.aWD() != null ? bvVar.aWD().video_type.intValue() : 0;
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean Pv;
        public boolean fVs;
        public int hmP;
        public int kDf;
        public String lPO;
        public int mErrCode;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean Pv;
        public String lPO;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public boolean Pv;
        public String lPO;
        public ArrayList<ai> lPR;

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
        if (this.lPE != null) {
            this.lPE.cancel();
            this.lPE = null;
        }
        if (this.lPF != null) {
            this.lPF.cancel();
            this.lPF = null;
        }
        if (this.lPG != null) {
            this.lPG.cancel();
            this.lPG = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z, BaijiahaoData baijiahaoData) {
        if (this.lPE != null) {
            this.lPE.cancel();
            this.lPE = null;
        }
        this.mLoadDataMode = 0;
        this.lPE = new a(str, str2, str3, str4, i, i2, z, baijiahaoData);
        this.lPE.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.lPE.setPriority(2);
        this.lPE.execute(new String[0]);
    }

    public boolean dlU() {
        return (this.lPE == null && this.lPF == null && this.lPG == null) ? false : true;
    }

    public void NR(String str) {
        this.lPH = str;
    }

    public String dlV() {
        return this.lPH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean fVs;
        private int hmP;
        private int kDf;
        private String lPH;
        private BaijiahaoData mBaijiahaoData;
        private String mForumId;
        private String mForumName;
        private z mNetwork = null;
        private String mPostId;
        private String mThreadId;

        public a(String str, String str2, String str3, String str4, int i, int i2, boolean z, BaijiahaoData baijiahaoData) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.hmP = i;
            this.kDf = i2;
            this.fVs = z;
            this.lPH = ForumManageModel.this.dlV();
            this.mBaijiahaoData = baijiahaoData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.hmP == 0 || this.hmP == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new z(str);
            this.mNetwork.addPostData("fid", this.mForumId);
            this.mNetwork.addPostData("word", this.mForumName);
            this.mNetwork.addPostData("z", this.mThreadId);
            if (this.lPH != null) {
                this.mNetwork.addPostData(TiebaInitialize.LogFields.REASON, this.lPH);
            }
            if (this.hmP == 0) {
                if (this.kDf == 0) {
                    this.mNetwork.addPostData("delete_my_thread", "1");
                }
            } else if (this.hmP == 1) {
                this.mNetwork.addPostData("pid", this.mPostId);
                this.mNetwork.addPostData("isfloor", "0");
                this.mNetwork.addPostData(UserAccountActionItem.KEY_SRC, "1");
                if (this.kDf == 0 && this.fVs) {
                    this.mNetwork.addPostData("delete_my_post", "1");
                }
            } else if (this.hmP == 2) {
                this.mNetwork.addPostData("pid", this.mPostId);
                this.mNetwork.addPostData("isfloor", "1");
                this.mNetwork.addPostData(UserAccountActionItem.KEY_SRC, "3");
                if (this.kDf == 0 && this.fVs) {
                    this.mNetwork.addPostData("delete_my_post", "1");
                }
            } else if (this.hmP == 3) {
                this.mNetwork.addPostData("delete_my_thread", "1");
                this.mNetwork.addPostData("is_story", "1");
            }
            if (this.kDf == 0 && !this.fVs) {
                this.mNetwork.addPostData("is_vipdel", "1");
            } else {
                this.mNetwork.addPostData("is_vipdel", "0");
            }
            if (this.hmP == 0 && ForumManageModel.this.lPI) {
                ForumManageModel.this.lPI = false;
                this.mNetwork.addPostData("ori_ugc_nid", ForumManageModel.this.lPJ);
                this.mNetwork.addPostData("thread_type", String.valueOf(ForumManageModel.this.mThreadType));
                this.mNetwork.addPostData("ori_ugc_type", String.valueOf(ForumManageModel.this.lPK));
                this.mNetwork.addPostData("owner_uid", ForumManageModel.this.lPL);
                this.mNetwork.addPostData("ori_ugc_vid", ForumManageModel.this.lPM);
                this.mNetwork.addPostData(LogConfig.LOG_VIDEO_TYPE, String.valueOf(ForumManageModel.this.mVideoType));
            } else if (this.mBaijiahaoData != null) {
                this.mNetwork.addPostData("ori_ugc_nid", this.mBaijiahaoData.oriUgcNid);
                this.mNetwork.addPostData("ori_ugc_tid", this.mBaijiahaoData.oriUgcTid);
                this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.mBaijiahaoData.oriUgcType));
                this.mNetwork.addPostData("ori_ugc_vid", this.mBaijiahaoData.oriUgcVid);
                this.mNetwork.addPostData("owner_uid", TbadkCoreApplication.getCurrentAccount());
            }
            this.mNetwork.bav().baW().mIsNeedTbs = true;
            this.mNetwork.postNetData();
            if (this.mNetwork.bav().baX().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            ForumManageModel.this.lPE = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.callback(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.lPE = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.callback(null);
                return;
            }
            b bVar = new b();
            bVar.hmP = this.hmP;
            bVar.mPostId = this.mPostId;
            bVar.fVs = this.fVs;
            bVar.kDf = this.kDf;
            bVar.lPO = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.getServerErrorCode();
            bVar.Pv = bool.booleanValue();
            ForumManageModel.this.mLoadDataCallBack.callback(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String kfF;
        final /* synthetic */ ForumManageModel lPN;
        private String mForumId;
        private String mForumName;
        private z mNetwork;
        private String mThreadId;
        private String mUserName;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            this.mNetwork = new z(strArr[0]);
            this.mNetwork.addPostData("day", this.kfF);
            this.mNetwork.addPostData("un", this.mUserName);
            this.mNetwork.addPostData("fid", this.mForumId);
            this.mNetwork.addPostData("word", this.mForumName);
            this.mNetwork.addPostData("z", this.mThreadId);
            this.mNetwork.addPostData("ntn", "banid");
            this.mNetwork.bav().baW().mIsNeedTbs = true;
            this.mNetwork.postNetData();
            if (this.mNetwork.bav().baX().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            this.lPN.lPF = null;
            super.cancel(true);
            this.lPN.mLoadDataCallBack.callback(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.lPN.lPF = null;
            if (this.mNetwork == null) {
                this.lPN.mLoadDataCallBack.callback(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.Pv = true;
            } else {
                dVar.Pv = false;
                dVar.lPO = str;
            }
            this.lPN.mLoadDataCallBack.callback(dVar);
        }
    }

    public void b(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.lPG != null) {
            this.lPG.cancel();
            this.lPG = null;
        }
        this.mLoadDataMode = i;
        this.lPG = new f(str, str2, str3, i, str4);
        this.lPG.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.lPG.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        String kvA;
        ArrayList<ai> lPQ;
        private String mForumId;
        private String mForumName;
        private z mNetwork = null;
        private String mThreadId;
        private int mType;

        public f(String str, String str2, String str3, int i, String str4) {
            this.lPQ = null;
            this.kvA = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.kvA = str4;
            this.lPQ = new ArrayList<>();
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
                    this.mNetwork.addPostData(IXAdRequestInfo.CELL_ID, this.kvA);
                } else {
                    this.mNetwork.addPostData("ntn", "");
                }
                this.mNetwork.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            this.mNetwork.bav().baW().mIsNeedTbs = true;
            String postNetData = this.mNetwork.postNetData();
            if (this.mNetwork.bav().baX().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(postNetData).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            ai aiVar = new ai();
                            aiVar.parserJson(optJSONArray.optJSONObject(i));
                            this.lPQ.add(aiVar);
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
            ForumManageModel.this.lPG = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.callback(null);
                return;
            }
            g gVar = new g();
            gVar.Pv = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    gVar.lPR = this.lPQ;
                }
            } else {
                gVar.lPO = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.callback(gVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            ForumManageModel.this.lPG = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.callback(null);
        }
    }
}
