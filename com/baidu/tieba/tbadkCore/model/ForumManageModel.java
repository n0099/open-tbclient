package com.baidu.tieba.tbadkCore.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.aa;
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
    private a hdo;
    private c hdp;
    private f hdq;

    /* loaded from: classes.dex */
    public static class e {
        public String forumId;
        public String forumName;
        public int hdu;
        public String threadId;
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hdo = null;
        this.hdp = null;
        this.hdq = null;
    }

    public ForumManageModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hdo = null;
        this.hdp = null;
        this.hdq = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean aoo;
        public boolean ecO;
        public int gaB;
        public int hdr;
        public String hdt;
        public int mErrCode;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean aoo;
        public String hdt;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public boolean aoo;
        public String hdt;
        public ArrayList<aa> hdw;

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
        if (this.hdo != null) {
            this.hdo.cancel();
            this.hdo = null;
        }
        if (this.hdp != null) {
            this.hdp.cancel();
            this.hdp = null;
        }
        if (this.hdq != null) {
            this.hdq.cancel();
            this.hdq = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.hdo != null) {
            this.hdo.cancel();
            this.hdo = null;
        }
        this.mLoadDataMode = 0;
        this.hdo = new a(str, str2, str3, str4, i, i2, z);
        this.hdo.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.hdo.setPriority(2);
        this.hdo.execute(new String[0]);
    }

    public boolean bxK() {
        return (this.hdo == null && this.hdp == null && this.hdq == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean ecO;
        private int gaB;
        private int hdr;
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
            this.hdr = i;
            this.gaB = i2;
            this.ecO = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.hdr == 0 || this.hdr == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new x(str);
            this.mNetwork.n(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n(Constants.MSG_SDK_LUA_BRIDGE_ACCELERATION_Z, this.mThreadId);
            if (this.hdr == 0) {
                if (this.gaB == 0) {
                    this.mNetwork.n("delete_my_thread", "1");
                }
            } else if (this.hdr == 1) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "0");
                this.mNetwork.n("src", "1");
                if (this.gaB == 0 && this.ecO) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.hdr == 2) {
                this.mNetwork.n(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.n("isfloor", "1");
                this.mNetwork.n("src", "3");
                if (this.gaB == 0 && this.ecO) {
                    this.mNetwork.n("delete_my_post", "1");
                }
            } else if (this.hdr == 3) {
                this.mNetwork.n("delete_my_thread", "1");
                this.mNetwork.n("is_story", "1");
            }
            if (this.gaB == 0 && !this.ecO) {
                this.mNetwork.n("is_vipdel", "1");
            } else {
                this.mNetwork.n("is_vipdel", "0");
            }
            this.mNetwork.Cz().Dw().mIsNeedTbs = true;
            this.mNetwork.Cb();
            if (this.mNetwork.Cz().Dx().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.mS();
            }
            ForumManageModel.this.hdo = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.ak(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.hdo = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.ak(null);
                return;
            }
            b bVar = new b();
            bVar.hdr = this.hdr;
            bVar.mPostId = this.mPostId;
            bVar.ecO = this.ecO;
            bVar.gaB = this.gaB;
            bVar.hdt = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.CD();
            if (bool.booleanValue()) {
                bVar.aoo = true;
            } else {
                bVar.aoo = false;
            }
            ForumManageModel.this.mLoadDataCallBack.ak(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String fFK;
        final /* synthetic */ ForumManageModel hds;
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
            this.mNetwork.n("day", this.fFK);
            this.mNetwork.n("un", this.mUserName);
            this.mNetwork.n(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.n("word", this.mForumName);
            this.mNetwork.n(Constants.MSG_SDK_LUA_BRIDGE_ACCELERATION_Z, this.mThreadId);
            this.mNetwork.n("ntn", "banid");
            this.mNetwork.Cz().Dw().mIsNeedTbs = true;
            this.mNetwork.Cb();
            if (this.mNetwork.Cz().Dx().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.mS();
            }
            this.hds.hdp = null;
            super.cancel(true);
            this.hds.mLoadDataCallBack.ak(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.hds.hdp = null;
            if (this.mNetwork == null) {
                this.hds.mLoadDataCallBack.ak(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.aoo = true;
            } else {
                dVar.aoo = false;
                dVar.hdt = str;
            }
            this.hds.mLoadDataCallBack.ak(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.hdq != null) {
            this.hdq.cancel();
            this.hdq = null;
        }
        this.mLoadDataMode = i;
        this.hdq = new f(str, str2, str3, i, str4);
        this.hdq.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.hdq.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        String fUX;
        ArrayList<aa> hdv;
        private String mForumId;
        private String mForumName;
        private x mNetwork = null;
        private String mThreadId;
        private int mType;

        public f(String str, String str2, String str3, int i, String str4) {
            this.hdv = null;
            this.fUX = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.fUX = str4;
            this.hdv = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            this.mNetwork = new x(strArr[0]);
            this.mNetwork.n("word", this.mForumName);
            if (this.mType != 6) {
                this.mNetwork.n(ImageViewerConfig.FORUM_ID, this.mForumId);
                this.mNetwork.n(Constants.MSG_SDK_LUA_BRIDGE_ACCELERATION_Z, this.mThreadId);
                if (this.mType == 4) {
                    this.mNetwork.n("ntn", "set");
                } else if (this.mType == 5) {
                    this.mNetwork.n("ntn", "");
                } else if (this.mType == 2) {
                    this.mNetwork.n("ntn", "set");
                    this.mNetwork.n("cid", this.fUX);
                } else {
                    this.mNetwork.n("ntn", "");
                }
            }
            this.mNetwork.Cz().Dw().mIsNeedTbs = true;
            String Cb = this.mNetwork.Cb();
            if (this.mNetwork.Cz().Dx().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(Cb).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            aa aaVar = new aa();
                            aaVar.parserJson(optJSONArray.optJSONObject(i));
                            this.hdv.add(aaVar);
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
            ForumManageModel.this.hdq = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.ak(null);
                return;
            }
            g gVar = new g();
            gVar.aoo = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    gVar.hdw = this.hdv;
                }
            } else {
                gVar.hdt = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.ak(gVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.mS();
            }
            ForumManageModel.this.hdq = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.ak(null);
        }
    }
}
