package com.baidu.tieba.tbadkCore.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.searchbox.ng.ai.apps.network.WebSocketAction;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.ImageCoverViewModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
    private a hqO;
    private c hqP;
    private f hqQ;
    private String hqR;

    /* loaded from: classes.dex */
    public static class e {
        public String forumId;
        public String forumName;
        public int hqV;
        public String threadId;
    }

    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hqO = null;
        this.hqP = null;
        this.hqQ = null;
    }

    public ForumManageModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hqO = null;
        this.hqP = null;
        this.hqQ = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean HZ;
        public boolean epZ;
        public int glB;
        public int hqS;
        public String hqU;
        public int mErrCode;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean HZ;
        public String hqU;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public boolean HZ;
        public String hqU;
        public ArrayList<aa> hqX;

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
        if (this.hqO != null) {
            this.hqO.cancel();
            this.hqO = null;
        }
        if (this.hqP != null) {
            this.hqP.cancel();
            this.hqP = null;
        }
        if (this.hqQ != null) {
            this.hqQ.cancel();
            this.hqQ = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.hqO != null) {
            this.hqO.cancel();
            this.hqO = null;
        }
        this.mLoadDataMode = 0;
        this.hqO = new a(str, str2, str3, str4, i, i2, z);
        this.hqO.setTag(UNIQUE_ID_DEL_POST_TASK);
        this.hqO.setPriority(2);
        this.hqO.execute(new String[0]);
    }

    public boolean bEU() {
        return (this.hqO == null && this.hqP == null && this.hqQ == null) ? false : true;
    }

    public void vM(String str) {
        this.hqR = str;
    }

    public String bEV() {
        return this.hqR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private boolean epZ;
        private int glB;
        private String hqR;
        private int hqS;
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
            this.hqS = i;
            this.glB = i2;
            this.epZ = z;
            this.hqR = ForumManageModel.this.bEV();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.hqS == 0 || this.hqS == 3) {
                str = str2 + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = str2 + TbConfig.DEL_POST_ADDRESS;
            }
            this.mNetwork = new x(str);
            this.mNetwork.x(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.x("word", this.mForumName);
            this.mNetwork.x("z", this.mThreadId);
            if (this.hqR != null) {
                this.mNetwork.x(WebSocketAction.PARAM_KEY_REASON, this.hqR);
            }
            if (this.hqS == 0) {
                if (this.glB == 0) {
                    this.mNetwork.x("delete_my_thread", "1");
                }
            } else if (this.hqS == 1) {
                this.mNetwork.x(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.x("isfloor", "0");
                this.mNetwork.x(ImageCoverViewModel.KEY_SRC, "1");
                if (this.glB == 0 && this.epZ) {
                    this.mNetwork.x("delete_my_post", "1");
                }
            } else if (this.hqS == 2) {
                this.mNetwork.x(Info.kBaiduPIDKey, this.mPostId);
                this.mNetwork.x("isfloor", "1");
                this.mNetwork.x(ImageCoverViewModel.KEY_SRC, "3");
                if (this.glB == 0 && this.epZ) {
                    this.mNetwork.x("delete_my_post", "1");
                }
            } else if (this.hqS == 3) {
                this.mNetwork.x("delete_my_thread", "1");
                this.mNetwork.x("is_story", "1");
            }
            if (this.glB == 0 && !this.epZ) {
                this.mNetwork.x("is_vipdel", "1");
            } else {
                this.mNetwork.x("is_vipdel", "0");
            }
            this.mNetwork.Dj().Eh().mIsNeedTbs = true;
            this.mNetwork.CL();
            if (this.mNetwork.Dj().Ei().isRequestSuccess()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.jg();
            }
            ForumManageModel.this.hqO = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.m(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            ForumManageModel.this.hqO = null;
            if (this.mNetwork == null || bool == null) {
                ForumManageModel.this.mLoadDataCallBack.m(null);
                return;
            }
            b bVar = new b();
            bVar.hqS = this.hqS;
            bVar.mPostId = this.mPostId;
            bVar.epZ = this.epZ;
            bVar.glB = this.glB;
            bVar.hqU = this.mNetwork.getErrorString();
            bVar.mErrCode = this.mNetwork.Dn();
            if (bool.booleanValue()) {
                bVar.HZ = true;
            } else {
                bVar.HZ = false;
            }
            ForumManageModel.this.mLoadDataCallBack.m(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private String fRh;
        final /* synthetic */ ForumManageModel hqT;
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
            this.mNetwork.x("day", this.fRh);
            this.mNetwork.x("un", this.mUserName);
            this.mNetwork.x(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.mNetwork.x("word", this.mForumName);
            this.mNetwork.x("z", this.mThreadId);
            this.mNetwork.x("ntn", "banid");
            this.mNetwork.Dj().Eh().mIsNeedTbs = true;
            this.mNetwork.CL();
            if (this.mNetwork.Dj().Ei().isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.jg();
            }
            this.hqT.hqP = null;
            super.cancel(true);
            this.hqT.mLoadDataCallBack.m(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.hqT.hqP = null;
            if (this.mNetwork == null) {
                this.hqT.mLoadDataCallBack.m(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.HZ = true;
            } else {
                dVar.HZ = false;
                dVar.hqU = str;
            }
            this.hqT.mLoadDataCallBack.m(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.hqQ != null) {
            this.hqQ.cancel();
            this.hqQ = null;
        }
        this.mLoadDataMode = i;
        this.hqQ = new f(str, str2, str3, i, str4);
        this.hqQ.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.hqQ.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        String gfP;
        ArrayList<aa> hqW;
        private String mForumId;
        private String mForumName;
        private x mNetwork = null;
        private String mThreadId;
        private int mType;

        public f(String str, String str2, String str3, int i, String str4) {
            this.hqW = null;
            this.gfP = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.gfP = str4;
            this.hqW = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            this.mNetwork = new x(strArr[0]);
            this.mNetwork.x("word", this.mForumName);
            if (this.mType != 6) {
                this.mNetwork.x(ImageViewerConfig.FORUM_ID, this.mForumId);
                this.mNetwork.x("z", this.mThreadId);
                if (this.mType == 4) {
                    this.mNetwork.x("ntn", "set");
                } else if (this.mType == 5) {
                    this.mNetwork.x("ntn", "");
                } else if (this.mType == 2) {
                    this.mNetwork.x("ntn", "set");
                    this.mNetwork.x("cid", this.gfP);
                } else {
                    this.mNetwork.x("ntn", "");
                }
                this.mNetwork.x("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            this.mNetwork.Dj().Eh().mIsNeedTbs = true;
            String CL = this.mNetwork.CL();
            if (this.mNetwork.Dj().Ei().isRequestSuccess()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(CL).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            aa aaVar = new aa();
                            aaVar.parserJson(optJSONArray.optJSONObject(i));
                            this.hqW.add(aaVar);
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
            ForumManageModel.this.hqQ = null;
            if (this.mNetwork == null) {
                ForumManageModel.this.mLoadDataCallBack.m(null);
                return;
            }
            g gVar = new g();
            gVar.HZ = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    gVar.hqX = this.hqW;
                }
            } else {
                gVar.hqU = this.mNetwork.getErrorString();
            }
            ForumManageModel.this.mLoadDataCallBack.m(gVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.jg();
            }
            ForumManageModel.this.hqQ = null;
            super.cancel(true);
            ForumManageModel.this.mLoadDataCallBack.m(null);
        }
    }
}
