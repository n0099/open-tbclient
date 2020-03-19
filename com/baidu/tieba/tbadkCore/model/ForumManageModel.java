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
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.bj;
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
    private a kkM;
    private c kkN;
    private f kkO;
    private String kkP;
    private boolean kkQ;
    private String kkR;
    private int kkS;
    private String kkT;
    private String kkU;
    private int mThreadType;
    private int mVideoType;

    /* loaded from: classes.dex */
    public static class e {
        public String forumId;
        public String forumName;
        public int kkX;
        public String threadId;
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kkM = null;
        this.kkN = null;
        this.kkO = null;
        this.kkQ = false;
    }

    public ForumManageModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.kkM = null;
        this.kkN = null;
        this.kkO = null;
        this.kkQ = false;
    }

    public void aX(bj bjVar) {
        if (bjVar != null && bjVar.getBaijiahaoData() != null) {
            this.kkQ = true;
            this.kkR = bjVar.getBaijiahaoData().oriUgcNid;
            this.kkS = bjVar.getBaijiahaoData().oriUgcType;
            this.kkU = bjVar.getBaijiahaoData().oriUgcVid;
            this.mThreadType = bjVar.threadType;
            this.kkT = TbadkCoreApplication.getCurrentAccount();
            this.mVideoType = bjVar.aCI() != null ? bjVar.aCI().video_type.intValue() : 0;
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean eMo;
        public int fYS;
        public int iXu;
        public String kkW;
        public int mErrCode;
        public String mPostId;
        public boolean mSuccess;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public String kkW;
        public boolean mSuccess;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public String kkW;
        public ArrayList<ad> kkZ;
        public boolean mSuccess;

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
        if (this.kkM != null) {
            this.kkM.cancel();
            this.kkM = null;
        }
        if (this.kkN != null) {
            this.kkN.cancel();
            this.kkN = null;
        }
        if (this.kkO != null) {
            this.kkO.cancel();
            this.kkO = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z, BaijiahaoData baijiahaoData) {
        if (this.kkM != null) {
            this.kkM.cancel();
            this.kkM = null;
        }
        this.mLoadDataMode = 0;
        this.kkM = new a(str, str2, str3, str4, i, i2, z, baijiahaoData);
        this.kkM.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.kkM.setPriority(2);
        this.kkM.execute(new String[0]);
    }

    public boolean cMj() {
        return (this.kkM == null && this.kkN == null && this.kkO == null) ? false : true;
    }

    public void Jh(String str) {
        this.kkP = str;
    }

    public String cMk() {
        return this.kkP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean eMo;
        private int fYS;
        private int iXu;
        private String kkP;
        private BaijiahaoData mBaijiahaoData;
        private String mForumId;
        private String mForumName;
        private x mNetwork = null;
        private String mPostId;
        private String mThreadId;

        public a(String str, String str2, String str3, String str4, int i, int i2, boolean z, BaijiahaoData baijiahaoData) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.fYS = i;
            this.iXu = i2;
            this.eMo = z;
            this.kkP = ForumManageModel.this.cMk();
            this.mBaijiahaoData = baijiahaoData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.fYS == 0 || this.fYS == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new x(str);
            this.mNetwork.addPostData("fid", this.mForumId);
            this.mNetwork.addPostData("word", this.mForumName);
            this.mNetwork.addPostData("z", this.mThreadId);
            if (this.kkP != null) {
                this.mNetwork.addPostData(TiebaInitialize.LogFields.REASON, this.kkP);
            }
            if (this.fYS == 0) {
                if (this.iXu == 0) {
                    this.mNetwork.addPostData("delete_my_thread", "1");
                }
            } else if (this.fYS == 1) {
                this.mNetwork.addPostData("pid", this.mPostId);
                this.mNetwork.addPostData("isfloor", "0");
                this.mNetwork.addPostData(UserAccountActionItem.KEY_SRC, "1");
                if (this.iXu == 0 && this.eMo) {
                    this.mNetwork.addPostData("delete_my_post", "1");
                }
            } else if (this.fYS == 2) {
                this.mNetwork.addPostData("pid", this.mPostId);
                this.mNetwork.addPostData("isfloor", "1");
                this.mNetwork.addPostData(UserAccountActionItem.KEY_SRC, "3");
                if (this.iXu == 0 && this.eMo) {
                    this.mNetwork.addPostData("delete_my_post", "1");
                }
            } else if (this.fYS == 3) {
                this.mNetwork.addPostData("delete_my_thread", "1");
                this.mNetwork.addPostData("is_story", "1");
            }
            if (this.iXu == 0 && !this.eMo) {
                this.mNetwork.addPostData("is_vipdel", "1");
            } else {
                this.mNetwork.addPostData("is_vipdel", "0");
            }
            if (this.fYS == 0 && ForumManageModel.this.kkQ) {
                ForumManageModel.this.kkQ = false;
                this.mNetwork.addPostData("ori_ugc_nid", ForumManageModel.this.kkR);
                this.mNetwork.addPostData("thread_type", String.valueOf(ForumManageModel.this.mThreadType));
                this.mNetwork.addPostData("ori_ugc_type", String.valueOf(ForumManageModel.this.kkS));
                this.mNetwork.addPostData("owner_uid", ForumManageModel.this.kkT);
                this.mNetwork.addPostData("ori_ugc_vid", ForumManageModel.this.kkU);
                this.mNetwork.addPostData(LogConfig.LOG_VIDEO_TYPE, String.valueOf(ForumManageModel.this.mVideoType));
            } else if (this.mBaijiahaoData != null) {
                this.mNetwork.addPostData("ori_ugc_nid", this.mBaijiahaoData.oriUgcNid);
                this.mNetwork.addPostData("ori_ugc_tid", this.mBaijiahaoData.oriUgcTid);
                this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.mBaijiahaoData.oriUgcType));
                this.mNetwork.addPostData("ori_ugc_vid", this.mBaijiahaoData.oriUgcVid);
                this.mNetwork.addPostData("owner_uid", TbadkCoreApplication.getCurrentAccount());
            }
            this.mNetwork.aGk().aGL().mIsNeedTbs = true;
            this.mNetwork.postNetData();
            if (this.mNetwork.aGk().aGM().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            ForumManageModel.this.kkM = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.callback(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.kkM = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.callback(null);
                return;
            }
            b bVar = new b();
            bVar.fYS = this.fYS;
            bVar.mPostId = this.mPostId;
            bVar.eMo = this.eMo;
            bVar.iXu = this.iXu;
            bVar.kkW = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.getServerErrorCode();
            bVar.mSuccess = bool.booleanValue();
            ForumManageModel.this.mLoadDataCallBack.callback(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String iBJ;
        final /* synthetic */ ForumManageModel kkV;
        private String mForumId;
        private String mForumName;
        private x mNetwork;
        private String mThreadId;
        private String mUserName;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            this.mNetwork = new x(strArr[0]);
            this.mNetwork.addPostData("day", this.iBJ);
            this.mNetwork.addPostData("un", this.mUserName);
            this.mNetwork.addPostData("fid", this.mForumId);
            this.mNetwork.addPostData("word", this.mForumName);
            this.mNetwork.addPostData("z", this.mThreadId);
            this.mNetwork.addPostData("ntn", "banid");
            this.mNetwork.aGk().aGL().mIsNeedTbs = true;
            this.mNetwork.postNetData();
            if (this.mNetwork.aGk().aGM().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            this.kkV.kkN = null;
            super.cancel(true);
            this.kkV.mLoadDataCallBack.callback(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.kkV.kkN = null;
            if (this.mNetwork == null) {
                this.kkV.mLoadDataCallBack.callback(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.mSuccess = true;
            } else {
                dVar.mSuccess = false;
                dVar.kkW = str;
            }
            this.kkV.mLoadDataCallBack.callback(dVar);
        }
    }

    public void b(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.kkO != null) {
            this.kkO.cancel();
            this.kkO = null;
        }
        this.mLoadDataMode = i;
        this.kkO = new f(str, str2, str3, i, str4);
        this.kkO.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.kkO.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        String iQb;
        ArrayList<ad> kkY;
        private String mForumId;
        private String mForumName;
        private x mNetwork = null;
        private String mThreadId;
        private int mType;

        public f(String str, String str2, String str3, int i, String str4) {
            this.kkY = null;
            this.iQb = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.iQb = str4;
            this.kkY = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            this.mNetwork = new x(strArr[0]);
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
                    this.mNetwork.addPostData(IXAdRequestInfo.CELL_ID, this.iQb);
                } else {
                    this.mNetwork.addPostData("ntn", "");
                }
                this.mNetwork.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            this.mNetwork.aGk().aGL().mIsNeedTbs = true;
            String postNetData = this.mNetwork.postNetData();
            if (this.mNetwork.aGk().aGM().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(postNetData).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            ad adVar = new ad();
                            adVar.parserJson(optJSONArray.optJSONObject(i));
                            this.kkY.add(adVar);
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
            ForumManageModel.this.kkO = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.callback(null);
                return;
            }
            g gVar = new g();
            gVar.mSuccess = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    gVar.kkZ = this.kkY;
                }
            } else {
                gVar.kkW = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.callback(gVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            ForumManageModel.this.kkO = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.callback(null);
        }
    }
}
