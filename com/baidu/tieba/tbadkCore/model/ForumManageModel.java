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
    private c noA;
    private f noB;
    private String noC;
    private boolean noD;
    private String noE;
    private int noF;
    private String noG;
    private String noH;
    private int noI;
    private a noz;

    /* loaded from: classes.dex */
    public static class e {
        public String forumId;
        public String forumName;
        public int noL;
        public String threadId;
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.noz = null;
        this.noA = null;
        this.noB = null;
        this.noD = false;
    }

    public ForumManageModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.noz = null;
        this.noA = null;
        this.noB = null;
        this.noD = false;
    }

    public void aZ(by byVar) {
        if (byVar != null && byVar.getBaijiahaoData() != null) {
            this.noD = true;
            this.noE = byVar.getBaijiahaoData().oriUgcNid;
            this.noF = byVar.getBaijiahaoData().oriUgcType;
            this.noH = byVar.getBaijiahaoData().oriUgcVid;
            this.mThreadType = byVar.threadType;
            this.noG = TbadkCoreApplication.getCurrentAccount();
            this.noI = byVar.bph() != null ? byVar.bph().video_type.intValue() : 0;
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean gZt;
        public int izQ;
        public int lXy;
        public int mErrCode;
        public String mPostId;
        public boolean mSuccess;
        public String noK;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean mSuccess;
        public String noK;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public boolean mSuccess;
        public String noK;
        public ArrayList<ak> noN;

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
        if (this.noz != null) {
            this.noz.cancel();
            this.noz = null;
        }
        if (this.noA != null) {
            this.noA.cancel();
            this.noA = null;
        }
        if (this.noB != null) {
            this.noB.cancel();
            this.noB = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z, BaijiahaoData baijiahaoData) {
        if (this.noz != null) {
            this.noz.cancel();
            this.noz = null;
        }
        this.mLoadDataMode = 0;
        this.noz = new a(str, str2, str3, str4, i, i2, z, baijiahaoData);
        this.noz.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.noz.setPriority(2);
        this.noz.execute(new String[0]);
    }

    public boolean dQc() {
        return (this.noz == null && this.noA == null && this.noB == null) ? false : true;
    }

    public void TT(String str) {
        this.noC = str;
    }

    public String dQd() {
        return this.noC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean gZt;
        private int izQ;
        private int lXy;
        private BaijiahaoData mBaijiahaoData;
        private String mForumId;
        private String mForumName;
        private aa mNetwork = null;
        private String mPostId;
        private String mThreadId;
        private String noC;

        public a(String str, String str2, String str3, String str4, int i, int i2, boolean z, BaijiahaoData baijiahaoData) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.izQ = i;
            this.lXy = i2;
            this.gZt = z;
            this.noC = ForumManageModel.this.dQd();
            this.mBaijiahaoData = baijiahaoData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.izQ == 0 || this.izQ == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new aa(str);
            this.mNetwork.addPostData("fid", this.mForumId);
            this.mNetwork.addPostData("word", this.mForumName);
            this.mNetwork.addPostData(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, this.mThreadId);
            if (this.noC != null) {
                this.mNetwork.addPostData(TiebaInitialize.LogFields.REASON, this.noC);
            }
            if (this.izQ == 0) {
                if (this.lXy == 0) {
                    this.mNetwork.addPostData("delete_my_thread", "1");
                }
            } else if (this.izQ == 1) {
                this.mNetwork.addPostData("pid", this.mPostId);
                this.mNetwork.addPostData("isfloor", "0");
                this.mNetwork.addPostData("src", "1");
                if (this.lXy == 0 && this.gZt) {
                    this.mNetwork.addPostData("delete_my_post", "1");
                }
            } else if (this.izQ == 2) {
                this.mNetwork.addPostData("pid", this.mPostId);
                this.mNetwork.addPostData("isfloor", "1");
                this.mNetwork.addPostData("src", "3");
                if (this.lXy == 0 && this.gZt) {
                    this.mNetwork.addPostData("delete_my_post", "1");
                }
            } else if (this.izQ == 3) {
                this.mNetwork.addPostData("delete_my_thread", "1");
                this.mNetwork.addPostData("is_story", "1");
            }
            if (this.lXy == 0 && !this.gZt) {
                this.mNetwork.addPostData("is_vipdel", "1");
            } else {
                this.mNetwork.addPostData("is_vipdel", "0");
            }
            if (this.izQ == 0 && ForumManageModel.this.noD) {
                ForumManageModel.this.noD = false;
                this.mNetwork.addPostData("ori_ugc_nid", ForumManageModel.this.noE);
                this.mNetwork.addPostData("thread_type", String.valueOf(ForumManageModel.this.mThreadType));
                this.mNetwork.addPostData("ori_ugc_type", String.valueOf(ForumManageModel.this.noF));
                this.mNetwork.addPostData("owner_uid", ForumManageModel.this.noG);
                this.mNetwork.addPostData("ori_ugc_vid", ForumManageModel.this.noH);
                this.mNetwork.addPostData(LogConfig.LOG_VIDEO_TYPE, String.valueOf(ForumManageModel.this.noI));
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
            ForumManageModel.this.noz = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.callback(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.noz = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.callback(null);
                return;
            }
            b bVar = new b();
            bVar.izQ = this.izQ;
            bVar.mPostId = this.mPostId;
            bVar.gZt = this.gZt;
            bVar.lXy = this.lXy;
            bVar.noK = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.getServerErrorCode();
            bVar.mSuccess = bool.booleanValue();
            ForumManageModel.this.mLoadDataCallBack.callback(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String lze;
        private String mForumId;
        private String mForumName;
        private aa mNetwork;
        private String mThreadId;
        private String mUserName;
        final /* synthetic */ ForumManageModel noJ;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            this.mNetwork = new aa(strArr[0]);
            this.mNetwork.addPostData("day", this.lze);
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
            this.noJ.noA = null;
            super.cancel(true);
            this.noJ.mLoadDataCallBack.callback(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.noJ.noA = null;
            if (this.mNetwork == null) {
                this.noJ.mLoadDataCallBack.callback(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.mSuccess = true;
            } else {
                dVar.mSuccess = false;
                dVar.noK = str;
            }
            this.noJ.mLoadDataCallBack.callback(dVar);
        }
    }

    public void c(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.noB != null) {
            this.noB.cancel();
            this.noB = null;
        }
        this.mLoadDataMode = i;
        this.noB = new f(str, str2, str3, i, str4);
        this.noB.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.noB.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        String lPI;
        private String mForumId;
        private String mForumName;
        private aa mNetwork = null;
        private String mThreadId;
        private int mType;
        ArrayList<ak> noM;

        public f(String str, String str2, String str3, int i, String str4) {
            this.noM = null;
            this.lPI = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.lPI = str4;
            this.noM = new ArrayList<>();
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
                    this.mNetwork.addPostData(IXAdRequestInfo.CELL_ID, this.lPI);
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
                            this.noM.add(akVar);
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
            ForumManageModel.this.noB = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.callback(null);
                return;
            }
            g gVar = new g();
            gVar.mSuccess = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    gVar.noN = this.noM;
                }
            } else {
                gVar.noK = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.callback(gVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            ForumManageModel.this.noB = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.callback(null);
        }
    }
}
