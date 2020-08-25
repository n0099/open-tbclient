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
/* loaded from: classes2.dex */
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
    private a mhp;
    private c mhq;
    private f mhr;
    private String mhs;
    private boolean mht;
    private String mhu;
    private int mhv;
    private String mhw;
    private String mhx;

    /* loaded from: classes2.dex */
    public static class e {
        public String forumId;
        public String forumName;
        public int mhA;
        public String threadId;
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mhp = null;
        this.mhq = null;
        this.mhr = null;
        this.mht = false;
    }

    public ForumManageModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.mhp = null;
        this.mhq = null;
        this.mhr = null;
        this.mht = false;
    }

    public void aW(bw bwVar) {
        if (bwVar != null && bwVar.getBaijiahaoData() != null) {
            this.mht = true;
            this.mhu = bwVar.getBaijiahaoData().oriUgcNid;
            this.mhv = bwVar.getBaijiahaoData().oriUgcType;
            this.mhx = bwVar.getBaijiahaoData().oriUgcVid;
            this.mThreadType = bwVar.threadType;
            this.mhw = TbadkCoreApplication.getCurrentAccount();
            this.mVideoType = bwVar.beW() != null ? bwVar.beW().video_type.intValue() : 0;
        }
    }

    /* loaded from: classes2.dex */
    public class b {
        public boolean Qf;
        public boolean ghr;
        public int hzG;
        public int kSN;
        public int mErrCode;
        public String mPostId;
        public String mhz;

        public b() {
        }
    }

    /* loaded from: classes2.dex */
    public class d {
        public boolean Qf;
        public String mhz;

        public d() {
        }
    }

    /* loaded from: classes2.dex */
    public class g {
        public boolean Qf;
        public ArrayList<aj> mhC;
        public String mhz;

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
        if (this.mhp != null) {
            this.mhp.cancel();
            this.mhp = null;
        }
        if (this.mhq != null) {
            this.mhq.cancel();
            this.mhq = null;
        }
        if (this.mhr != null) {
            this.mhr.cancel();
            this.mhr = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z, BaijiahaoData baijiahaoData) {
        if (this.mhp != null) {
            this.mhp.cancel();
            this.mhp = null;
        }
        this.mLoadDataMode = 0;
        this.mhp = new a(str, str2, str3, str4, i, i2, z, baijiahaoData);
        this.mhp.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.mhp.setPriority(2);
        this.mhp.execute(new String[0]);
    }

    public boolean dxq() {
        return (this.mhp == null && this.mhq == null && this.mhr == null) ? false : true;
    }

    public void QP(String str) {
        this.mhs = str;
    }

    public String dxr() {
        return this.mhs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean ghr;
        private int hzG;
        private int kSN;
        private BaijiahaoData mBaijiahaoData;
        private String mForumId;
        private String mForumName;
        private aa mNetwork = null;
        private String mPostId;
        private String mThreadId;
        private String mhs;

        public a(String str, String str2, String str3, String str4, int i, int i2, boolean z, BaijiahaoData baijiahaoData) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.hzG = i;
            this.kSN = i2;
            this.ghr = z;
            this.mhs = ForumManageModel.this.dxr();
            this.mBaijiahaoData = baijiahaoData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.hzG == 0 || this.hzG == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new aa(str);
            this.mNetwork.addPostData("fid", this.mForumId);
            this.mNetwork.addPostData("word", this.mForumName);
            this.mNetwork.addPostData(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, this.mThreadId);
            if (this.mhs != null) {
                this.mNetwork.addPostData(TiebaInitialize.LogFields.REASON, this.mhs);
            }
            if (this.hzG == 0) {
                if (this.kSN == 0) {
                    this.mNetwork.addPostData("delete_my_thread", "1");
                }
            } else if (this.hzG == 1) {
                this.mNetwork.addPostData("pid", this.mPostId);
                this.mNetwork.addPostData("isfloor", "0");
                this.mNetwork.addPostData("src", "1");
                if (this.kSN == 0 && this.ghr) {
                    this.mNetwork.addPostData("delete_my_post", "1");
                }
            } else if (this.hzG == 2) {
                this.mNetwork.addPostData("pid", this.mPostId);
                this.mNetwork.addPostData("isfloor", "1");
                this.mNetwork.addPostData("src", "3");
                if (this.kSN == 0 && this.ghr) {
                    this.mNetwork.addPostData("delete_my_post", "1");
                }
            } else if (this.hzG == 3) {
                this.mNetwork.addPostData("delete_my_thread", "1");
                this.mNetwork.addPostData("is_story", "1");
            }
            if (this.kSN == 0 && !this.ghr) {
                this.mNetwork.addPostData("is_vipdel", "1");
            } else {
                this.mNetwork.addPostData("is_vipdel", "0");
            }
            if (this.hzG == 0 && ForumManageModel.this.mht) {
                ForumManageModel.this.mht = false;
                this.mNetwork.addPostData("ori_ugc_nid", ForumManageModel.this.mhu);
                this.mNetwork.addPostData("thread_type", String.valueOf(ForumManageModel.this.mThreadType));
                this.mNetwork.addPostData("ori_ugc_type", String.valueOf(ForumManageModel.this.mhv));
                this.mNetwork.addPostData("owner_uid", ForumManageModel.this.mhw);
                this.mNetwork.addPostData("ori_ugc_vid", ForumManageModel.this.mhx);
                this.mNetwork.addPostData(LogConfig.LOG_VIDEO_TYPE, String.valueOf(ForumManageModel.this.mVideoType));
            } else if (this.mBaijiahaoData != null) {
                this.mNetwork.addPostData("ori_ugc_nid", this.mBaijiahaoData.oriUgcNid);
                this.mNetwork.addPostData("ori_ugc_tid", this.mBaijiahaoData.oriUgcTid);
                this.mNetwork.addPostData("ori_ugc_type", String.valueOf(this.mBaijiahaoData.oriUgcType));
                this.mNetwork.addPostData("ori_ugc_vid", this.mBaijiahaoData.oriUgcVid);
                this.mNetwork.addPostData("owner_uid", TbadkCoreApplication.getCurrentAccount());
            }
            this.mNetwork.biQ().bjv().mIsNeedTbs = true;
            this.mNetwork.postNetData();
            if (this.mNetwork.biQ().bjw().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            ForumManageModel.this.mhp = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.callback(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.mhp = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.callback(null);
                return;
            }
            b bVar = new b();
            bVar.hzG = this.hzG;
            bVar.mPostId = this.mPostId;
            bVar.ghr = this.ghr;
            bVar.kSN = this.kSN;
            bVar.mhz = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.getServerErrorCode();
            bVar.Qf = bool.booleanValue();
            ForumManageModel.this.mLoadDataCallBack.callback(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String kva;
        private String mForumId;
        private String mForumName;
        private aa mNetwork;
        private String mThreadId;
        private String mUserName;
        final /* synthetic */ ForumManageModel mhy;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            this.mNetwork = new aa(strArr[0]);
            this.mNetwork.addPostData("day", this.kva);
            this.mNetwork.addPostData("un", this.mUserName);
            this.mNetwork.addPostData("fid", this.mForumId);
            this.mNetwork.addPostData("word", this.mForumName);
            this.mNetwork.addPostData(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, this.mThreadId);
            this.mNetwork.addPostData("ntn", "banid");
            this.mNetwork.biQ().bjv().mIsNeedTbs = true;
            this.mNetwork.postNetData();
            if (this.mNetwork.biQ().bjw().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            this.mhy.mhq = null;
            super.cancel(true);
            this.mhy.mLoadDataCallBack.callback(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.mhy.mhq = null;
            if (this.mNetwork == null) {
                this.mhy.mLoadDataCallBack.callback(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.Qf = true;
            } else {
                dVar.Qf = false;
                dVar.mhz = str;
            }
            this.mhy.mLoadDataCallBack.callback(dVar);
        }
    }

    public void b(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.mhr != null) {
            this.mhr.cancel();
            this.mhr = null;
        }
        this.mLoadDataMode = i;
        this.mhr = new f(str, str2, str3, i, str4);
        this.mhr.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.mhr.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        String kLh;
        private String mForumId;
        private String mForumName;
        private aa mNetwork = null;
        private String mThreadId;
        private int mType;
        ArrayList<aj> mhB;

        public f(String str, String str2, String str3, int i, String str4) {
            this.mhB = null;
            this.kLh = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.kLh = str4;
            this.mhB = new ArrayList<>();
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
                    this.mNetwork.addPostData(IXAdRequestInfo.CELL_ID, this.kLh);
                } else {
                    this.mNetwork.addPostData("ntn", "");
                }
                this.mNetwork.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            this.mNetwork.biQ().bjv().mIsNeedTbs = true;
            String postNetData = this.mNetwork.postNetData();
            if (this.mNetwork.biQ().bjw().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(postNetData).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            aj ajVar = new aj();
                            ajVar.parserJson(optJSONArray.optJSONObject(i));
                            this.mhB.add(ajVar);
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
            ForumManageModel.this.mhr = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.callback(null);
                return;
            }
            g gVar = new g();
            gVar.Qf = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    gVar.mhC = this.mhB;
                }
            } else {
                gVar.mhz = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.callback(gVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            ForumManageModel.this.mhr = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.callback(null);
        }
    }
}
