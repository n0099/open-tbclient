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
import com.baidu.tbadk.core.data.ab;
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
    private a gPn;
    private c gPo;
    private f gPp;
    private String gPq;

    /* loaded from: classes.dex */
    public static class e {
        public String forumId;
        public String forumName;
        public int gPu;
        public String threadId;
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gPn = null;
        this.gPo = null;
        this.gPp = null;
    }

    public ForumManageModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gPn = null;
        this.gPo = null;
        this.gPp = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean Fa;
        public boolean dNa;
        public int fLi;
        public int gPr;
        public String gPt;
        public int mErrCode;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean Fa;
        public String gPt;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public boolean Fa;
        public String gPt;
        public ArrayList<ab> gPw;

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
        if (this.gPn != null) {
            this.gPn.cancel();
            this.gPn = null;
        }
        if (this.gPo != null) {
            this.gPo.cancel();
            this.gPo = null;
        }
        if (this.gPp != null) {
            this.gPp.cancel();
            this.gPp = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.gPn != null) {
            this.gPn.cancel();
            this.gPn = null;
        }
        this.mLoadDataMode = 0;
        this.gPn = new a(str, str2, str3, str4, i, i2, z);
        this.gPn.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.gPn.setPriority(2);
        this.gPn.execute(new String[0]);
    }

    public boolean byq() {
        return (this.gPn == null && this.gPo == null && this.gPp == null) ? false : true;
    }

    public void tS(String str) {
        this.gPq = str;
    }

    public String byr() {
        return this.gPq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean dNa;
        private int fLi;
        private String gPq;
        private int gPr;
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
            this.gPr = i;
            this.fLi = i2;
            this.dNa = z;
            this.gPq = ForumManageModel.this.byr();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.gPr == 0 || this.gPr == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new y(str);
            this.mNetwork.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.o("word", this.mForumName);
            this.mNetwork.o("z", this.mThreadId);
            if (this.gPq != null) {
                this.mNetwork.o("reason", this.gPq);
            }
            if (this.gPr == 0) {
                if (this.fLi == 0) {
                    this.mNetwork.o("delete_my_thread", "1");
                }
            } else if (this.gPr == 1) {
                this.mNetwork.o(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.o("isfloor", "0");
                this.mNetwork.o("src", "1");
                if (this.fLi == 0 && this.dNa) {
                    this.mNetwork.o("delete_my_post", "1");
                }
            } else if (this.gPr == 2) {
                this.mNetwork.o(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.o("isfloor", "1");
                this.mNetwork.o("src", "3");
                if (this.fLi == 0 && this.dNa) {
                    this.mNetwork.o("delete_my_post", "1");
                }
            } else if (this.gPr == 3) {
                this.mNetwork.o("delete_my_thread", "1");
                this.mNetwork.o("is_story", "1");
            }
            if (this.fLi == 0 && !this.dNa) {
                this.mNetwork.o("is_vipdel", "1");
            } else {
                this.mNetwork.o("is_vipdel", "0");
            }
            this.mNetwork.yX().zX().mIsNeedTbs = true;
            this.mNetwork.yz();
            if (this.mNetwork.yX().zY().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.hN();
            }
            ForumManageModel.this.gPn = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.i(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.gPn = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.i(null);
                return;
            }
            b bVar = new b();
            bVar.gPr = this.gPr;
            bVar.mPostId = this.mPostId;
            bVar.dNa = this.dNa;
            bVar.fLi = this.fLi;
            bVar.gPt = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.zb();
            if (bool.booleanValue()) {
                bVar.Fa = true;
            } else {
                bVar.Fa = false;
            }
            ForumManageModel.this.mLoadDataCallBack.i(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String fqI;
        final /* synthetic */ ForumManageModel gPs;
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
            this.mNetwork.o("day", this.fqI);
            this.mNetwork.o("un", this.mUserName);
            this.mNetwork.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.o("word", this.mForumName);
            this.mNetwork.o("z", this.mThreadId);
            this.mNetwork.o("ntn", "banid");
            this.mNetwork.yX().zX().mIsNeedTbs = true;
            this.mNetwork.yz();
            if (this.mNetwork.yX().zY().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.hN();
            }
            this.gPs.gPo = null;
            super.cancel(true);
            this.gPs.mLoadDataCallBack.i(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.gPs.gPo = null;
            if (this.mNetwork == null) {
                this.gPs.mLoadDataCallBack.i(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.Fa = true;
            } else {
                dVar.Fa = false;
                dVar.gPt = str;
            }
            this.gPs.mLoadDataCallBack.i(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.gPp != null) {
            this.gPp.cancel();
            this.gPp = null;
        }
        this.mLoadDataMode = i;
        this.gPp = new f(str, str2, str3, i, str4);
        this.gPp.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.gPp.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        String fFA;
        ArrayList<ab> gPv;
        private String mForumId;
        private String mForumName;
        private y mNetwork = null;
        private String mThreadId;
        private int mType;

        public f(String str, String str2, String str3, int i, String str4) {
            this.gPv = null;
            this.fFA = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.fFA = str4;
            this.gPv = new ArrayList<>();
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
                    this.mNetwork.o("cid", this.fFA);
                } else {
                    this.mNetwork.o("ntn", "");
                }
                this.mNetwork.o("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            this.mNetwork.yX().zX().mIsNeedTbs = true;
            String yz = this.mNetwork.yz();
            if (this.mNetwork.yX().zY().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(yz).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            ab abVar = new ab();
                            abVar.parserJson(optJSONArray.optJSONObject(i));
                            this.gPv.add(abVar);
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
            ForumManageModel.this.gPp = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.i(null);
                return;
            }
            g gVar = new g();
            gVar.Fa = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    gVar.gPw = this.gPv;
                }
            } else {
                gVar.gPt = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.i(gVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.hN();
            }
            ForumManageModel.this.gPp = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.i(null);
        }
    }
}
