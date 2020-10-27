package com.baidu.tieba.tbadkCore.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.aa;
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
    private boolean mTA;
    private String mTB;
    private int mTC;
    private String mTD;
    private String mTE;
    private int mThreadType;
    private a mTw;
    private c mTx;
    private f mTy;
    private String mTz;
    private int mVideoType;

    /* loaded from: classes.dex */
    public static class e {
        public String forumId;
        public String forumName;
        public int mTH;
        public String threadId;
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mTw = null;
        this.mTx = null;
        this.mTy = null;
        this.mTA = false;
    }

    public ForumManageModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.mTw = null;
        this.mTx = null;
        this.mTy = null;
        this.mTA = false;
    }

    public void aX(bw bwVar) {
        if (bwVar != null && bwVar.getBaijiahaoData() != null) {
            this.mTA = true;
            this.mTB = bwVar.getBaijiahaoData().oriUgcNid;
            this.mTC = bwVar.getBaijiahaoData().oriUgcType;
            this.mTE = bwVar.getBaijiahaoData().oriUgcVid;
            this.mThreadType = bwVar.threadType;
            this.mTD = TbadkCoreApplication.getCurrentAccount();
            this.mVideoType = bwVar.bks() != null ? bwVar.bks().video_type.intValue() : 0;
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean QP;
        public boolean gKL;
        public int iij;
        public int lDo;
        public int mErrCode;
        public String mPostId;
        public String mTG;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean QP;
        public String mTG;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public boolean QP;
        public String mTG;
        public ArrayList<aj> mTJ;

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
        if (this.mTw != null) {
            this.mTw.cancel();
            this.mTw = null;
        }
        if (this.mTx != null) {
            this.mTx.cancel();
            this.mTx = null;
        }
        if (this.mTy != null) {
            this.mTy.cancel();
            this.mTy = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z, BaijiahaoData baijiahaoData) {
        if (this.mTw != null) {
            this.mTw.cancel();
            this.mTw = null;
        }
        this.mLoadDataMode = 0;
        this.mTw = new a(str, str2, str3, str4, i, i2, z, baijiahaoData);
        this.mTw.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.mTw.setPriority(2);
        this.mTw.execute(new String[0]);
    }

    public boolean dIi() {
        return (this.mTw == null && this.mTx == null && this.mTy == null) ? false : true;
    }

    public void SC(String str) {
        this.mTz = str;
    }

    public String dIj() {
        return this.mTz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean gKL;
        private int iij;
        private int lDo;
        private BaijiahaoData mBaijiahaoData;
        private String mForumId;
        private String mForumName;
        private aa mNetwork = null;
        private String mPostId;
        private String mThreadId;
        private String mTz;

        public a(String str, String str2, String str3, String str4, int i, int i2, boolean z, BaijiahaoData baijiahaoData) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.iij = i;
            this.lDo = i2;
            this.gKL = z;
            this.mTz = ForumManageModel.this.dIj();
            this.mBaijiahaoData = baijiahaoData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.iij == 0 || this.iij == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new aa(str);
            this.mNetwork.addPostData("fid", this.mForumId);
            this.mNetwork.addPostData("word", this.mForumName);
            this.mNetwork.addPostData(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, this.mThreadId);
            if (this.mTz != null) {
                this.mNetwork.addPostData(TiebaInitialize.LogFields.REASON, this.mTz);
            }
            if (this.iij == 0) {
                if (this.lDo == 0) {
                    this.mNetwork.addPostData("delete_my_thread", "1");
                }
            } else if (this.iij == 1) {
                this.mNetwork.addPostData("pid", this.mPostId);
                this.mNetwork.addPostData("isfloor", "0");
                this.mNetwork.addPostData("src", "1");
                if (this.lDo == 0 && this.gKL) {
                    this.mNetwork.addPostData("delete_my_post", "1");
                }
            } else if (this.iij == 2) {
                this.mNetwork.addPostData("pid", this.mPostId);
                this.mNetwork.addPostData("isfloor", "1");
                this.mNetwork.addPostData("src", "3");
                if (this.lDo == 0 && this.gKL) {
                    this.mNetwork.addPostData("delete_my_post", "1");
                }
            } else if (this.iij == 3) {
                this.mNetwork.addPostData("delete_my_thread", "1");
                this.mNetwork.addPostData("is_story", "1");
            }
            if (this.lDo == 0 && !this.gKL) {
                this.mNetwork.addPostData("is_vipdel", "1");
            } else {
                this.mNetwork.addPostData("is_vipdel", "0");
            }
            if (this.iij == 0 && ForumManageModel.this.mTA) {
                ForumManageModel.this.mTA = false;
                this.mNetwork.addPostData("ori_ugc_nid", ForumManageModel.this.mTB);
                this.mNetwork.addPostData("thread_type", String.valueOf(ForumManageModel.this.mThreadType));
                this.mNetwork.addPostData("ori_ugc_type", String.valueOf(ForumManageModel.this.mTC));
                this.mNetwork.addPostData("owner_uid", ForumManageModel.this.mTD);
                this.mNetwork.addPostData("ori_ugc_vid", ForumManageModel.this.mTE);
                this.mNetwork.addPostData(LogConfig.LOG_VIDEO_TYPE, String.valueOf(ForumManageModel.this.mVideoType));
            } else if (this.mBaijiahaoData != null) {
                this.mNetwork.addPostData("ori_ugc_nid", this.mBaijiahaoData.oriUgcNid);
                this.mNetwork.addPostData("ori_ugc_tid", this.mBaijiahaoData.oriUgcTid);
                this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.mBaijiahaoData.oriUgcType));
                this.mNetwork.addPostData("ori_ugc_vid", this.mBaijiahaoData.oriUgcVid);
                this.mNetwork.addPostData("owner_uid", TbadkCoreApplication.getCurrentAccount());
            }
            this.mNetwork.bon().boT().mIsNeedTbs = true;
            this.mNetwork.postNetData();
            if (this.mNetwork.bon().boU().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            ForumManageModel.this.mTw = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.callback(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.mTw = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.callback(null);
                return;
            }
            b bVar = new b();
            bVar.iij = this.iij;
            bVar.mPostId = this.mPostId;
            bVar.gKL = this.gKL;
            bVar.lDo = this.lDo;
            bVar.mTG = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.getServerErrorCode();
            bVar.QP = bool.booleanValue();
            ForumManageModel.this.mLoadDataCallBack.callback(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String lfq;
        private String mForumId;
        private String mForumName;
        private aa mNetwork;
        final /* synthetic */ ForumManageModel mTF;
        private String mThreadId;
        private String mUserName;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            this.mNetwork = new aa(strArr[0]);
            this.mNetwork.addPostData("day", this.lfq);
            this.mNetwork.addPostData("un", this.mUserName);
            this.mNetwork.addPostData("fid", this.mForumId);
            this.mNetwork.addPostData("word", this.mForumName);
            this.mNetwork.addPostData(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, this.mThreadId);
            this.mNetwork.addPostData("ntn", "banid");
            this.mNetwork.bon().boT().mIsNeedTbs = true;
            this.mNetwork.postNetData();
            if (this.mNetwork.bon().boU().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            this.mTF.mTx = null;
            super.cancel(true);
            this.mTF.mLoadDataCallBack.callback(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.mTF.mTx = null;
            if (this.mNetwork == null) {
                this.mTF.mLoadDataCallBack.callback(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.QP = true;
            } else {
                dVar.QP = false;
                dVar.mTG = str;
            }
            this.mTF.mLoadDataCallBack.callback(dVar);
        }
    }

    public void b(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.mTy != null) {
            this.mTy.cancel();
            this.mTy = null;
        }
        this.mLoadDataMode = i;
        this.mTy = new f(str, str2, str3, i, str4);
        this.mTy.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.mTy.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        String lvE;
        private String mForumId;
        private String mForumName;
        private aa mNetwork = null;
        ArrayList<aj> mTI;
        private String mThreadId;
        private int mType;

        public f(String str, String str2, String str3, int i, String str4) {
            this.mTI = null;
            this.lvE = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.lvE = str4;
            this.mTI = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            this.mNetwork = new aa(strArr[0]);
            this.mNetwork.addPostData("word", this.mForumName);
            if (this.mType != 6) {
                this.mNetwork.addPostData("fid", this.mForumId);
                this.mNetwork.addPostData(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, this.mThreadId);
                if (this.mType == 4) {
                    this.mNetwork.addPostData("ntn", "set");
                } else if (this.mType == 5) {
                    this.mNetwork.addPostData("ntn", "");
                } else if (this.mType == 2) {
                    this.mNetwork.addPostData("ntn", "set");
                    this.mNetwork.addPostData(IXAdRequestInfo.CELL_ID, this.lvE);
                } else {
                    this.mNetwork.addPostData("ntn", "");
                }
                this.mNetwork.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            this.mNetwork.bon().boT().mIsNeedTbs = true;
            String postNetData = this.mNetwork.postNetData();
            if (this.mNetwork.bon().boU().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(postNetData).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            aj ajVar = new aj();
                            ajVar.parserJson(optJSONArray.optJSONObject(i));
                            this.mTI.add(ajVar);
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
            ForumManageModel.this.mTy = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.callback(null);
                return;
            }
            g gVar = new g();
            gVar.QP = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    gVar.mTJ = this.mTI;
                }
            } else {
                gVar.mTG = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.callback(gVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            ForumManageModel.this.mTy = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.callback(null);
        }
    }
}
