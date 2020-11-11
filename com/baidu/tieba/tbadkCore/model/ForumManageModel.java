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
    private int mThreadType;
    private int mVideoType;
    private int mZA;
    private String mZB;
    private String mZC;
    private a mZu;
    private c mZv;
    private f mZw;
    private String mZx;
    private boolean mZy;
    private String mZz;

    /* loaded from: classes.dex */
    public static class e {
        public String forumId;
        public String forumName;
        public int mZF;
        public String threadId;
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mZu = null;
        this.mZv = null;
        this.mZw = null;
        this.mZy = false;
    }

    public ForumManageModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.mZu = null;
        this.mZv = null;
        this.mZw = null;
        this.mZy = false;
    }

    public void aX(bw bwVar) {
        if (bwVar != null && bwVar.getBaijiahaoData() != null) {
            this.mZy = true;
            this.mZz = bwVar.getBaijiahaoData().oriUgcNid;
            this.mZA = bwVar.getBaijiahaoData().oriUgcType;
            this.mZC = bwVar.getBaijiahaoData().oriUgcVid;
            this.mThreadType = bwVar.threadType;
            this.mZB = TbadkCoreApplication.getCurrentAccount();
            this.mVideoType = bwVar.bmS() != null ? bwVar.bmS().video_type.intValue() : 0;
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean QP;
        public boolean gQx;
        public int ioi;
        public int lJk;
        public int mErrCode;
        public String mPostId;
        public String mZE;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean QP;
        public String mZE;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public boolean QP;
        public String mZE;
        public ArrayList<aj> mZH;

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
        if (this.mZu != null) {
            this.mZu.cancel();
            this.mZu = null;
        }
        if (this.mZv != null) {
            this.mZv.cancel();
            this.mZv = null;
        }
        if (this.mZw != null) {
            this.mZw.cancel();
            this.mZw = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z, BaijiahaoData baijiahaoData) {
        if (this.mZu != null) {
            this.mZu.cancel();
            this.mZu = null;
        }
        this.mLoadDataMode = 0;
        this.mZu = new a(str, str2, str3, str4, i, i2, z, baijiahaoData);
        this.mZu.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.mZu.setPriority(2);
        this.mZu.execute(new String[0]);
    }

    public boolean dKK() {
        return (this.mZu == null && this.mZv == null && this.mZw == null) ? false : true;
    }

    public void ST(String str) {
        this.mZx = str;
    }

    public String dKL() {
        return this.mZx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean gQx;
        private int ioi;
        private int lJk;
        private BaijiahaoData mBaijiahaoData;
        private String mForumId;
        private String mForumName;
        private aa mNetwork = null;
        private String mPostId;
        private String mThreadId;
        private String mZx;

        public a(String str, String str2, String str3, String str4, int i, int i2, boolean z, BaijiahaoData baijiahaoData) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.ioi = i;
            this.lJk = i2;
            this.gQx = z;
            this.mZx = ForumManageModel.this.dKL();
            this.mBaijiahaoData = baijiahaoData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.ioi == 0 || this.ioi == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new aa(str);
            this.mNetwork.addPostData("fid", this.mForumId);
            this.mNetwork.addPostData("word", this.mForumName);
            this.mNetwork.addPostData(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, this.mThreadId);
            if (this.mZx != null) {
                this.mNetwork.addPostData(TiebaInitialize.LogFields.REASON, this.mZx);
            }
            if (this.ioi == 0) {
                if (this.lJk == 0) {
                    this.mNetwork.addPostData("delete_my_thread", "1");
                }
            } else if (this.ioi == 1) {
                this.mNetwork.addPostData("pid", this.mPostId);
                this.mNetwork.addPostData("isfloor", "0");
                this.mNetwork.addPostData("src", "1");
                if (this.lJk == 0 && this.gQx) {
                    this.mNetwork.addPostData("delete_my_post", "1");
                }
            } else if (this.ioi == 2) {
                this.mNetwork.addPostData("pid", this.mPostId);
                this.mNetwork.addPostData("isfloor", "1");
                this.mNetwork.addPostData("src", "3");
                if (this.lJk == 0 && this.gQx) {
                    this.mNetwork.addPostData("delete_my_post", "1");
                }
            } else if (this.ioi == 3) {
                this.mNetwork.addPostData("delete_my_thread", "1");
                this.mNetwork.addPostData("is_story", "1");
            }
            if (this.lJk == 0 && !this.gQx) {
                this.mNetwork.addPostData("is_vipdel", "1");
            } else {
                this.mNetwork.addPostData("is_vipdel", "0");
            }
            if (this.ioi == 0 && ForumManageModel.this.mZy) {
                ForumManageModel.this.mZy = false;
                this.mNetwork.addPostData("ori_ugc_nid", ForumManageModel.this.mZz);
                this.mNetwork.addPostData("thread_type", String.valueOf(ForumManageModel.this.mThreadType));
                this.mNetwork.addPostData("ori_ugc_type", String.valueOf(ForumManageModel.this.mZA));
                this.mNetwork.addPostData("owner_uid", ForumManageModel.this.mZB);
                this.mNetwork.addPostData("ori_ugc_vid", ForumManageModel.this.mZC);
                this.mNetwork.addPostData(LogConfig.LOG_VIDEO_TYPE, String.valueOf(ForumManageModel.this.mVideoType));
            } else if (this.mBaijiahaoData != null) {
                this.mNetwork.addPostData("ori_ugc_nid", this.mBaijiahaoData.oriUgcNid);
                this.mNetwork.addPostData("ori_ugc_tid", this.mBaijiahaoData.oriUgcTid);
                this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.mBaijiahaoData.oriUgcType));
                this.mNetwork.addPostData("ori_ugc_vid", this.mBaijiahaoData.oriUgcVid);
                this.mNetwork.addPostData("owner_uid", TbadkCoreApplication.getCurrentAccount());
            }
            this.mNetwork.bqN().brt().mIsNeedTbs = true;
            this.mNetwork.postNetData();
            if (this.mNetwork.bqN().bru().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            ForumManageModel.this.mZu = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.callback(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.mZu = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.callback(null);
                return;
            }
            b bVar = new b();
            bVar.ioi = this.ioi;
            bVar.mPostId = this.mPostId;
            bVar.gQx = this.gQx;
            bVar.lJk = this.lJk;
            bVar.mZE = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.getServerErrorCode();
            bVar.QP = bool.booleanValue();
            ForumManageModel.this.mLoadDataCallBack.callback(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String llm;
        private String mForumId;
        private String mForumName;
        private aa mNetwork;
        private String mThreadId;
        private String mUserName;
        final /* synthetic */ ForumManageModel mZD;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            this.mNetwork = new aa(strArr[0]);
            this.mNetwork.addPostData("day", this.llm);
            this.mNetwork.addPostData("un", this.mUserName);
            this.mNetwork.addPostData("fid", this.mForumId);
            this.mNetwork.addPostData("word", this.mForumName);
            this.mNetwork.addPostData(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, this.mThreadId);
            this.mNetwork.addPostData("ntn", "banid");
            this.mNetwork.bqN().brt().mIsNeedTbs = true;
            this.mNetwork.postNetData();
            if (this.mNetwork.bqN().bru().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            this.mZD.mZv = null;
            super.cancel(true);
            this.mZD.mLoadDataCallBack.callback(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.mZD.mZv = null;
            if (this.mNetwork == null) {
                this.mZD.mLoadDataCallBack.callback(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.QP = true;
            } else {
                dVar.QP = false;
                dVar.mZE = str;
            }
            this.mZD.mLoadDataCallBack.callback(dVar);
        }
    }

    public void b(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.mZw != null) {
            this.mZw.cancel();
            this.mZw = null;
        }
        this.mLoadDataMode = i;
        this.mZw = new f(str, str2, str3, i, str4);
        this.mZw.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.mZw.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        String lBB;
        private String mForumId;
        private String mForumName;
        private aa mNetwork = null;
        private String mThreadId;
        private int mType;
        ArrayList<aj> mZG;

        public f(String str, String str2, String str3, int i, String str4) {
            this.mZG = null;
            this.lBB = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.lBB = str4;
            this.mZG = new ArrayList<>();
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
                    this.mNetwork.addPostData(IXAdRequestInfo.CELL_ID, this.lBB);
                } else {
                    this.mNetwork.addPostData("ntn", "");
                }
                this.mNetwork.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            this.mNetwork.bqN().brt().mIsNeedTbs = true;
            String postNetData = this.mNetwork.postNetData();
            if (this.mNetwork.bqN().bru().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(postNetData).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            aj ajVar = new aj();
                            ajVar.parserJson(optJSONArray.optJSONObject(i));
                            this.mZG.add(ajVar);
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
            ForumManageModel.this.mZw = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.callback(null);
                return;
            }
            g gVar = new g();
            gVar.QP = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    gVar.mZH = this.mZG;
                }
            } else {
                gVar.mZE = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.callback(gVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            ForumManageModel.this.mZw = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.callback(null);
        }
    }
}
