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
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.by;
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
    private int mThreadType;
    private String noA;
    private boolean noB;
    private String noC;
    private int noD;
    private String noE;
    private String noF;
    private int noG;
    private a nox;
    private c noy;
    private f noz;

    /* loaded from: classes.dex */
    public static class e {
        public String forumId;
        public String forumName;
        public int noJ;
        public String threadId;
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.nox = null;
        this.noy = null;
        this.noz = null;
        this.noB = false;
    }

    public ForumManageModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.nox = null;
        this.noy = null;
        this.noz = null;
        this.noB = false;
    }

    public void aZ(by byVar) {
        if (byVar != null && byVar.getBaijiahaoData() != null) {
            this.noB = true;
            this.noC = byVar.getBaijiahaoData().oriUgcNid;
            this.noD = byVar.getBaijiahaoData().oriUgcType;
            this.noF = byVar.getBaijiahaoData().oriUgcVid;
            this.mThreadType = byVar.threadType;
            this.noE = TbadkCoreApplication.getCurrentAccount();
            this.noG = byVar.bph() != null ? byVar.bph().video_type.intValue() : 0;
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean gZr;
        public int izO;
        public int lXw;
        public int mErrCode;
        public String mPostId;
        public boolean mSuccess;
        public String noI;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean mSuccess;
        public String noI;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public boolean mSuccess;
        public String noI;
        public ArrayList<ak> noL;

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
        if (this.nox != null) {
            this.nox.cancel();
            this.nox = null;
        }
        if (this.noy != null) {
            this.noy.cancel();
            this.noy = null;
        }
        if (this.noz != null) {
            this.noz.cancel();
            this.noz = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z, BaijiahaoData baijiahaoData) {
        if (this.nox != null) {
            this.nox.cancel();
            this.nox = null;
        }
        this.mLoadDataMode = 0;
        this.nox = new a(str, str2, str3, str4, i, i2, z, baijiahaoData);
        this.nox.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.nox.setPriority(2);
        this.nox.execute(new String[0]);
    }

    public boolean dQb() {
        return (this.nox == null && this.noy == null && this.noz == null) ? false : true;
    }

    public void TT(String str) {
        this.noA = str;
    }

    public String dQc() {
        return this.noA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean gZr;
        private int izO;
        private int lXw;
        private BaijiahaoData mBaijiahaoData;
        private String mForumId;
        private String mForumName;
        private aa mNetwork = null;
        private String mPostId;
        private String mThreadId;
        private String noA;

        public a(String str, String str2, String str3, String str4, int i, int i2, boolean z, BaijiahaoData baijiahaoData) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.izO = i;
            this.lXw = i2;
            this.gZr = z;
            this.noA = ForumManageModel.this.dQc();
            this.mBaijiahaoData = baijiahaoData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.izO == 0 || this.izO == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new aa(str);
            this.mNetwork.addPostData("fid", this.mForumId);
            this.mNetwork.addPostData("word", this.mForumName);
            this.mNetwork.addPostData(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, this.mThreadId);
            if (this.noA != null) {
                this.mNetwork.addPostData(TiebaInitialize.LogFields.REASON, this.noA);
            }
            if (this.izO == 0) {
                if (this.lXw == 0) {
                    this.mNetwork.addPostData("delete_my_thread", "1");
                }
            } else if (this.izO == 1) {
                this.mNetwork.addPostData("pid", this.mPostId);
                this.mNetwork.addPostData("isfloor", "0");
                this.mNetwork.addPostData("src", "1");
                if (this.lXw == 0 && this.gZr) {
                    this.mNetwork.addPostData("delete_my_post", "1");
                }
            } else if (this.izO == 2) {
                this.mNetwork.addPostData("pid", this.mPostId);
                this.mNetwork.addPostData("isfloor", "1");
                this.mNetwork.addPostData("src", "3");
                if (this.lXw == 0 && this.gZr) {
                    this.mNetwork.addPostData("delete_my_post", "1");
                }
            } else if (this.izO == 3) {
                this.mNetwork.addPostData("delete_my_thread", "1");
                this.mNetwork.addPostData("is_story", "1");
            }
            if (this.lXw == 0 && !this.gZr) {
                this.mNetwork.addPostData("is_vipdel", "1");
            } else {
                this.mNetwork.addPostData("is_vipdel", "0");
            }
            if (this.izO == 0 && ForumManageModel.this.noB) {
                ForumManageModel.this.noB = false;
                this.mNetwork.addPostData("ori_ugc_nid", ForumManageModel.this.noC);
                this.mNetwork.addPostData("thread_type", String.valueOf(ForumManageModel.this.mThreadType));
                this.mNetwork.addPostData("ori_ugc_type", String.valueOf(ForumManageModel.this.noD));
                this.mNetwork.addPostData("owner_uid", ForumManageModel.this.noE);
                this.mNetwork.addPostData("ori_ugc_vid", ForumManageModel.this.noF);
                this.mNetwork.addPostData(LogConfig.LOG_VIDEO_TYPE, String.valueOf(ForumManageModel.this.noG));
            } else if (this.mBaijiahaoData != null) {
                this.mNetwork.addPostData("ori_ugc_nid", this.mBaijiahaoData.oriUgcNid);
                this.mNetwork.addPostData("ori_ugc_tid", this.mBaijiahaoData.oriUgcTid);
                this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.mBaijiahaoData.oriUgcType));
                this.mNetwork.addPostData("ori_ugc_vid", this.mBaijiahaoData.oriUgcVid);
                this.mNetwork.addPostData("owner_uid", TbadkCoreApplication.getCurrentAccount());
            }
            this.mNetwork.btv().bue().mIsNeedTbs = true;
            this.mNetwork.postNetData();
            if (this.mNetwork.btv().buf().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            ForumManageModel.this.nox = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.callback(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.nox = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.callback(null);
                return;
            }
            b bVar = new b();
            bVar.izO = this.izO;
            bVar.mPostId = this.mPostId;
            bVar.gZr = this.gZr;
            bVar.lXw = this.lXw;
            bVar.noI = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.getServerErrorCode();
            bVar.mSuccess = bool.booleanValue();
            ForumManageModel.this.mLoadDataCallBack.callback(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String lzc;
        private String mForumId;
        private String mForumName;
        private aa mNetwork;
        private String mThreadId;
        private String mUserName;
        final /* synthetic */ ForumManageModel noH;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            this.mNetwork = new aa(strArr[0]);
            this.mNetwork.addPostData("day", this.lzc);
            this.mNetwork.addPostData("un", this.mUserName);
            this.mNetwork.addPostData("fid", this.mForumId);
            this.mNetwork.addPostData("word", this.mForumName);
            this.mNetwork.addPostData(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, this.mThreadId);
            this.mNetwork.addPostData("ntn", "banid");
            this.mNetwork.btv().bue().mIsNeedTbs = true;
            this.mNetwork.postNetData();
            if (this.mNetwork.btv().buf().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            this.noH.noy = null;
            super.cancel(true);
            this.noH.mLoadDataCallBack.callback(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.noH.noy = null;
            if (this.mNetwork == null) {
                this.noH.mLoadDataCallBack.callback(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.mSuccess = true;
            } else {
                dVar.mSuccess = false;
                dVar.noI = str;
            }
            this.noH.mLoadDataCallBack.callback(dVar);
        }
    }

    public void c(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.noz != null) {
            this.noz.cancel();
            this.noz = null;
        }
        this.mLoadDataMode = i;
        this.noz = new f(str, str2, str3, i, str4);
        this.noz.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.noz.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        String lPG;
        private String mForumId;
        private String mForumName;
        private aa mNetwork = null;
        private String mThreadId;
        private int mType;
        ArrayList<ak> noK;

        public f(String str, String str2, String str3, int i, String str4) {
            this.noK = null;
            this.lPG = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.lPG = str4;
            this.noK = new ArrayList<>();
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
                    this.mNetwork.addPostData(IXAdRequestInfo.CELL_ID, this.lPG);
                } else {
                    this.mNetwork.addPostData("ntn", "");
                }
                this.mNetwork.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            this.mNetwork.btv().bue().mIsNeedTbs = true;
            String postNetData = this.mNetwork.postNetData();
            if (this.mNetwork.btv().buf().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(postNetData).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            ak akVar = new ak();
                            akVar.parserJson(optJSONArray.optJSONObject(i));
                            this.noK.add(akVar);
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
            ForumManageModel.this.noz = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.callback(null);
                return;
            }
            g gVar = new g();
            gVar.mSuccess = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    gVar.noL = this.noK;
                }
            } else {
                gVar.noI = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.callback(gVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            ForumManageModel.this.noz = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.callback(null);
        }
    }
}
