package com.baidu.tieba.tbadkCore.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.util.y;
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
    private a gQl;
    private c gQm;
    private f gQn;
    private String gQo;

    /* loaded from: classes.dex */
    public static class e {
        public String forumId;
        public String forumName;
        public int gQs;
        public String threadId;
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gQl = null;
        this.gQm = null;
        this.gQn = null;
    }

    public ForumManageModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gQl = null;
        this.gQm = null;
        this.gQn = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean EX;
        public boolean dPN;
        public int fLw;
        public int gQp;
        public String gQr;
        public int mErrCode;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean EX;
        public String gQr;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public boolean EX;
        public String gQr;
        public ArrayList<aa> gQu;

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
        if (this.gQl != null) {
            this.gQl.cancel();
            this.gQl = null;
        }
        if (this.gQm != null) {
            this.gQm.cancel();
            this.gQm = null;
        }
        if (this.gQn != null) {
            this.gQn.cancel();
            this.gQn = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.gQl != null) {
            this.gQl.cancel();
            this.gQl = null;
        }
        this.mLoadDataMode = 0;
        this.gQl = new a(str, str2, str3, str4, i, i2, z);
        this.gQl.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.gQl.setPriority(2);
        this.gQl.execute(new String[0]);
    }

    public boolean bwT() {
        return (this.gQl == null && this.gQm == null && this.gQn == null) ? false : true;
    }

    public void tQ(String str) {
        this.gQo = str;
    }

    public String bwU() {
        return this.gQo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean dPN;
        private int fLw;
        private String gQo;
        private int gQp;
        private String mForumId;
        private String mForumName;
        private y mNetwork = null;
        private String mPostId;
        private String mThreadId;

        public a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.gQp = i;
            this.fLw = i2;
            this.dPN = z;
            this.gQo = ForumManageModel.this.bwU();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.gQp == 0 || this.gQp == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new y(str);
            this.mNetwork.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.o("word", this.mForumName);
            this.mNetwork.o("z", this.mThreadId);
            if (this.gQo != null) {
                this.mNetwork.o("reason", this.gQo);
            }
            if (this.gQp == 0) {
                if (this.fLw == 0) {
                    this.mNetwork.o("delete_my_thread", "1");
                }
            } else if (this.gQp == 1) {
                this.mNetwork.o(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.o("isfloor", "0");
                this.mNetwork.o("src", "1");
                if (this.fLw == 0 && this.dPN) {
                    this.mNetwork.o("delete_my_post", "1");
                }
            } else if (this.gQp == 2) {
                this.mNetwork.o(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.o("isfloor", "1");
                this.mNetwork.o("src", "3");
                if (this.fLw == 0 && this.dPN) {
                    this.mNetwork.o("delete_my_post", "1");
                }
            } else if (this.gQp == 3) {
                this.mNetwork.o("delete_my_thread", "1");
                this.mNetwork.o("is_story", "1");
            }
            if (this.fLw == 0 && !this.dPN) {
                this.mNetwork.o("is_vipdel", "1");
            } else {
                this.mNetwork.o("is_vipdel", "0");
            }
            this.mNetwork.yO().zM().mIsNeedTbs = true;
            this.mNetwork.yq();
            if (this.mNetwork.yO().zN().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.hN();
            }
            ForumManageModel.this.gQl = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.i(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.gQl = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.i(null);
                return;
            }
            b bVar = new b();
            bVar.gQp = this.gQp;
            bVar.mPostId = this.mPostId;
            bVar.dPN = this.dPN;
            bVar.fLw = this.fLw;
            bVar.gQr = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.yS();
            if (bool.booleanValue()) {
                bVar.EX = true;
            } else {
                bVar.EX = false;
            }
            ForumManageModel.this.mLoadDataCallBack.i(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String fqU;
        final /* synthetic */ ForumManageModel gQq;
        private String mForumId;
        private String mForumName;
        private y mNetwork;
        private String mThreadId;
        private String mUserName;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            this.mNetwork = new y(strArr[0]);
            this.mNetwork.o("day", this.fqU);
            this.mNetwork.o("un", this.mUserName);
            this.mNetwork.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.o("word", this.mForumName);
            this.mNetwork.o("z", this.mThreadId);
            this.mNetwork.o("ntn", "banid");
            this.mNetwork.yO().zM().mIsNeedTbs = true;
            this.mNetwork.yq();
            if (this.mNetwork.yO().zN().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.hN();
            }
            this.gQq.gQm = null;
            super.cancel(true);
            this.gQq.mLoadDataCallBack.i(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.gQq.gQm = null;
            if (this.mNetwork == null) {
                this.gQq.mLoadDataCallBack.i(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.EX = true;
            } else {
                dVar.EX = false;
                dVar.gQr = str;
            }
            this.gQq.mLoadDataCallBack.i(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.gQn != null) {
            this.gQn.cancel();
            this.gQn = null;
        }
        this.mLoadDataMode = i;
        this.gQn = new f(str, str2, str3, i, str4);
        this.gQn.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.gQn.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        String fFN;
        ArrayList<aa> gQt;
        private String mForumId;
        private String mForumName;
        private y mNetwork = null;
        private String mThreadId;
        private int mType;

        public f(String str, String str2, String str3, int i, String str4) {
            this.gQt = null;
            this.fFN = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.fFN = str4;
            this.gQt = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            this.mNetwork = new y(strArr[0]);
            this.mNetwork.o("word", this.mForumName);
            if (this.mType != 6) {
                this.mNetwork.o(ImageViewerConfig.FORUM_ID, this.mForumId);
                this.mNetwork.o("z", this.mThreadId);
                if (this.mType == 4) {
                    this.mNetwork.o("ntn", "set");
                } else if (this.mType == 5) {
                    this.mNetwork.o("ntn", "");
                } else if (this.mType == 2) {
                    this.mNetwork.o("ntn", "set");
                    this.mNetwork.o("cid", this.fFN);
                } else {
                    this.mNetwork.o("ntn", "");
                }
                this.mNetwork.o("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            this.mNetwork.yO().zM().mIsNeedTbs = true;
            String yq = this.mNetwork.yq();
            if (this.mNetwork.yO().zN().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(yq).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            aa aaVar = new aa();
                            aaVar.parserJson(optJSONArray.optJSONObject(i));
                            this.gQt.add(aaVar);
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
            ForumManageModel.this.gQn = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.i(null);
                return;
            }
            g gVar = new g();
            gVar.EX = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    gVar.gQu = this.gQt;
                }
            } else {
                gVar.gQr = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.i(gVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.hN();
            }
            ForumManageModel.this.gQn = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.i(null);
        }
    }
}
