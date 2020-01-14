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
    private a khU;
    private c khV;
    private f khW;
    private String khX;
    private boolean khY;
    private String khZ;
    private int kia;
    private String kib;
    private String kic;
    private int mThreadType;
    private int mVideoType;

    /* loaded from: classes.dex */
    public static class e {
        public String forumId;
        public String forumName;
        public int kig;
        public String threadId;
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.khU = null;
        this.khV = null;
        this.khW = null;
        this.khY = false;
    }

    public ForumManageModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.khU = null;
        this.khV = null;
        this.khW = null;
        this.khY = false;
    }

    public void aT(bj bjVar) {
        if (bjVar != null && bjVar.getBaijiahaoData() != null) {
            this.khY = true;
            this.khZ = bjVar.getBaijiahaoData().oriUgcNid;
            this.kia = bjVar.getBaijiahaoData().oriUgcType;
            this.kic = bjVar.getBaijiahaoData().oriUgcVid;
            this.mThreadType = bjVar.threadType;
            this.kib = TbadkCoreApplication.getCurrentAccount();
            this.mVideoType = bjVar.aAo() != null ? bjVar.aAo().video_type.intValue() : 0;
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean eHK;
        public int fVU;
        public int iUh;
        public String kif;
        public int mErrCode;
        public String mPostId;
        public boolean mSuccess;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public String kif;
        public boolean mSuccess;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public String kif;
        public ArrayList<ad> kii;
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
        if (this.khU != null) {
            this.khU.cancel();
            this.khU = null;
        }
        if (this.khV != null) {
            this.khV.cancel();
            this.khV = null;
        }
        if (this.khW != null) {
            this.khW.cancel();
            this.khW = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z, BaijiahaoData baijiahaoData) {
        if (this.khU != null) {
            this.khU.cancel();
            this.khU = null;
        }
        this.mLoadDataMode = 0;
        this.khU = new a(str, str2, str3, str4, i, i2, z, baijiahaoData);
        this.khU.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.khU.setPriority(2);
        this.khU.execute(new String[0]);
    }

    public boolean cKo() {
        return (this.khU == null && this.khV == null && this.khW == null) ? false : true;
    }

    public void IT(String str) {
        this.khX = str;
    }

    public String cKp() {
        return this.khX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean eHK;
        private int fVU;
        private int iUh;
        private String khX;
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
            this.fVU = i;
            this.iUh = i2;
            this.eHK = z;
            this.khX = ForumManageModel.this.cKp();
            this.mBaijiahaoData = baijiahaoData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.fVU == 0 || this.fVU == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new x(str);
            this.mNetwork.addPostData("fid", this.mForumId);
            this.mNetwork.addPostData("word", this.mForumName);
            this.mNetwork.addPostData("z", this.mThreadId);
            if (this.khX != null) {
                this.mNetwork.addPostData(TiebaInitialize.LogFields.REASON, this.khX);
            }
            if (this.fVU == 0) {
                if (this.iUh == 0) {
                    this.mNetwork.addPostData("delete_my_thread", "1");
                }
            } else if (this.fVU == 1) {
                this.mNetwork.addPostData("pid", this.mPostId);
                this.mNetwork.addPostData("isfloor", "0");
                this.mNetwork.addPostData(UserAccountActionItem.KEY_SRC, "1");
                if (this.iUh == 0 && this.eHK) {
                    this.mNetwork.addPostData("delete_my_post", "1");
                }
            } else if (this.fVU == 2) {
                this.mNetwork.addPostData("pid", this.mPostId);
                this.mNetwork.addPostData("isfloor", "1");
                this.mNetwork.addPostData(UserAccountActionItem.KEY_SRC, "3");
                if (this.iUh == 0 && this.eHK) {
                    this.mNetwork.addPostData("delete_my_post", "1");
                }
            } else if (this.fVU == 3) {
                this.mNetwork.addPostData("delete_my_thread", "1");
                this.mNetwork.addPostData("is_story", "1");
            }
            if (this.iUh == 0 && !this.eHK) {
                this.mNetwork.addPostData("is_vipdel", "1");
            } else {
                this.mNetwork.addPostData("is_vipdel", "0");
            }
            if (this.fVU == 0 && ForumManageModel.this.khY) {
                ForumManageModel.this.khY = false;
                this.mNetwork.addPostData("ori_ugc_nid", ForumManageModel.this.khZ);
                this.mNetwork.addPostData("thread_type", String.valueOf(ForumManageModel.this.mThreadType));
                this.mNetwork.addPostData("ori_ugc_type", String.valueOf(ForumManageModel.this.kia));
                this.mNetwork.addPostData("owner_uid", ForumManageModel.this.kib);
                this.mNetwork.addPostData("ori_ugc_vid", ForumManageModel.this.kic);
                this.mNetwork.addPostData(LogConfig.LOG_VIDEO_TYPE, String.valueOf(ForumManageModel.this.mVideoType));
            } else if (this.mBaijiahaoData != null) {
                this.mNetwork.addPostData("ori_ugc_nid", this.mBaijiahaoData.oriUgcNid);
                this.mNetwork.addPostData("ori_ugc_tid", this.mBaijiahaoData.oriUgcTid);
                this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.mBaijiahaoData.oriUgcType));
                this.mNetwork.addPostData("ori_ugc_vid", this.mBaijiahaoData.oriUgcVid);
                this.mNetwork.addPostData("owner_uid", TbadkCoreApplication.getCurrentAccount());
            }
            this.mNetwork.aDU().aEu().mIsNeedTbs = true;
            this.mNetwork.postNetData();
            if (this.mNetwork.aDU().aEv().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            ForumManageModel.this.khU = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.callback(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.khU = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.callback(null);
                return;
            }
            b bVar = new b();
            bVar.fVU = this.fVU;
            bVar.mPostId = this.mPostId;
            bVar.eHK = this.eHK;
            bVar.iUh = this.iUh;
            bVar.kif = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.getServerErrorCode();
            bVar.mSuccess = bool.booleanValue();
            ForumManageModel.this.mLoadDataCallBack.callback(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String iya;
        final /* synthetic */ ForumManageModel kie;
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
            this.mNetwork.addPostData("day", this.iya);
            this.mNetwork.addPostData("un", this.mUserName);
            this.mNetwork.addPostData("fid", this.mForumId);
            this.mNetwork.addPostData("word", this.mForumName);
            this.mNetwork.addPostData("z", this.mThreadId);
            this.mNetwork.addPostData("ntn", "banid");
            this.mNetwork.aDU().aEu().mIsNeedTbs = true;
            this.mNetwork.postNetData();
            if (this.mNetwork.aDU().aEv().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            this.kie.khV = null;
            super.cancel(true);
            this.kie.mLoadDataCallBack.callback(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.kie.khV = null;
            if (this.mNetwork == null) {
                this.kie.mLoadDataCallBack.callback(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.mSuccess = true;
            } else {
                dVar.mSuccess = false;
                dVar.kif = str;
            }
            this.kie.mLoadDataCallBack.callback(dVar);
        }
    }

    public void b(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.khW != null) {
            this.khW.cancel();
            this.khW = null;
        }
        this.mLoadDataMode = i;
        this.khW = new f(str, str2, str3, i, str4);
        this.khW.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.khW.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        String iMS;
        ArrayList<ad> kih;
        private String mForumId;
        private String mForumName;
        private x mNetwork = null;
        private String mThreadId;
        private int mType;

        public f(String str, String str2, String str3, int i, String str4) {
            this.kih = null;
            this.iMS = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.iMS = str4;
            this.kih = new ArrayList<>();
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
                    this.mNetwork.addPostData(IXAdRequestInfo.CELL_ID, this.iMS);
                } else {
                    this.mNetwork.addPostData("ntn", "");
                }
                this.mNetwork.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            this.mNetwork.aDU().aEu().mIsNeedTbs = true;
            String postNetData = this.mNetwork.postNetData();
            if (this.mNetwork.aDU().aEv().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(postNetData).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            ad adVar = new ad();
                            adVar.parserJson(optJSONArray.optJSONObject(i));
                            this.kih.add(adVar);
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
            ForumManageModel.this.khW = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.callback(null);
                return;
            }
            g gVar = new g();
            gVar.mSuccess = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    gVar.kii = this.kih;
                }
            } else {
                gVar.kif = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.callback(gVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            ForumManageModel.this.khW = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.callback(null);
        }
    }
}
