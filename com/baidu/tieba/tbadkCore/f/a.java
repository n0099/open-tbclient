package com.baidu.tieba.tbadkCore.f;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.util.ab;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e {
    private C0077a fuJ;
    private c fuK;
    private e fuL;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fuJ = null;
        this.fuK = null;
        this.fuL = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean cuz;
        public int ewn;
        public int fuM;
        public String fuO;
        public int mErrCode;
        public String mPostId;
        public boolean ub;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public String fuO;
        public boolean ub;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public String fuO;
        public ArrayList<z> fuQ;
        public boolean ub;

        public f() {
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        bjR();
        return false;
    }

    public void bjR() {
        if (this.fuJ != null) {
            this.fuJ.cancel();
            this.fuJ = null;
        }
        if (this.fuK != null) {
            this.fuK.cancel();
            this.fuK = null;
        }
        if (this.fuL != null) {
            this.fuL.cancel();
            this.fuL = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.fuJ != null) {
            this.fuJ.cancel();
            this.fuJ = null;
        }
        this.mLoadDataMode = 0;
        this.fuJ = new C0077a(str, str2, str3, str4, i, i2, z);
        this.fuJ.setPriority(2);
        this.fuJ.execute(new String[0]);
    }

    public boolean bjS() {
        return (this.fuJ == null && this.fuK == null && this.fuL == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0077a extends BdAsyncTask<String, Integer, Boolean> {
        private ab aiS = null;
        private boolean cuz;
        private int ewn;
        private int fuM;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;

        public C0077a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.fuM = i;
            this.ewn = i2;
            this.cuz = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.fuM == 0) {
                str = String.valueOf(str2) + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = String.valueOf(str2) + TbConfig.DEL_POST_ADDRESS;
            }
            this.aiS = new ab(str);
            this.aiS.n("fid", this.mForumId);
            this.aiS.n("word", this.mForumName);
            this.aiS.n("z", this.mThreadId);
            if (this.fuM == 0) {
                if (this.ewn == 0) {
                    this.aiS.n("delete_my_thread", "1");
                }
            } else if (this.fuM == 1) {
                this.aiS.n(Info.kBaiduPIDKey, this.mPostId);
                this.aiS.n("isfloor", "0");
                this.aiS.n("src", "1");
                if (this.ewn == 0 && this.cuz) {
                    this.aiS.n("delete_my_post", "1");
                }
            } else if (this.fuM == 2) {
                this.aiS.n(Info.kBaiduPIDKey, this.mPostId);
                this.aiS.n("isfloor", "1");
                this.aiS.n("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                if (this.ewn == 0 && this.cuz) {
                    this.aiS.n("delete_my_post", "1");
                }
            }
            if (this.ewn == 0 && !this.cuz) {
                this.aiS.n("is_vipdel", "1");
            } else {
                this.aiS.n("is_vipdel", "0");
            }
            this.aiS.uD().vz().mIsNeedTbs = true;
            this.aiS.ue();
            if (this.aiS.uD().vA().oE()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiS != null) {
                this.aiS.eg();
            }
            a.this.fuJ = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.g(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            a.this.fuJ = null;
            if (this.aiS == null || bool == null) {
                a.this.mLoadDataCallBack.g(null);
                return;
            }
            b bVar = new b();
            bVar.fuM = this.fuM;
            bVar.mPostId = this.mPostId;
            bVar.cuz = this.cuz;
            bVar.ewn = this.ewn;
            bVar.fuO = this.aiS.getErrorString();
            bVar.mErrCode = this.aiS.uH();
            if (bool.booleanValue()) {
                bVar.ub = true;
            } else {
                bVar.ub = false;
            }
            a.this.mLoadDataCallBack.g(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private ab aiS;
        private String eiu;
        final /* synthetic */ a fuN;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private String mUserName;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            this.aiS = new ab(strArr[0]);
            this.aiS.n("day", this.eiu);
            this.aiS.n("un", this.mUserName);
            this.aiS.n("fid", this.mForumId);
            this.aiS.n("word", this.mForumName);
            this.aiS.n("z", this.mThreadId);
            this.aiS.n("ntn", "banid");
            this.aiS.uD().vz().mIsNeedTbs = true;
            this.aiS.ue();
            if (this.aiS.uD().vA().oE()) {
                return null;
            }
            return this.aiS.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiS != null) {
                this.aiS.eg();
            }
            this.fuN.fuK = null;
            super.cancel(true);
            this.fuN.mLoadDataCallBack.g(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: eu */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            this.fuN.fuK = null;
            if (this.aiS == null) {
                this.fuN.mLoadDataCallBack.g(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.ub = true;
            } else {
                dVar.ub = false;
                dVar.fuO = str;
            }
            this.fuN.mLoadDataCallBack.g(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.fuL != null) {
            this.fuL.cancel();
            this.fuL = null;
        }
        this.mLoadDataMode = i;
        this.fuL = new e(str, str2, str3, i, str4);
        this.fuL.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.fuL.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<String, String, Boolean> {
        private ab aiS = null;
        String etp;
        ArrayList<z> fuP;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private int mType;

        public e(String str, String str2, String str3, int i, String str4) {
            this.fuP = null;
            this.etp = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.etp = str4;
            this.fuP = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            this.aiS = new ab(strArr[0]);
            this.aiS.n("word", this.mForumName);
            if (this.mType != 6) {
                this.aiS.n("fid", this.mForumId);
                this.aiS.n("z", this.mThreadId);
                if (this.mType == 4) {
                    this.aiS.n("ntn", "set");
                } else if (this.mType == 5) {
                    this.aiS.n("ntn", "");
                } else if (this.mType == 2) {
                    this.aiS.n("ntn", "set");
                    this.aiS.n("cid", this.etp);
                } else {
                    this.aiS.n("ntn", "");
                }
            }
            this.aiS.uD().vz().mIsNeedTbs = true;
            String ue = this.aiS.ue();
            if (this.aiS.uD().vA().oE()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(ue).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            z zVar = new z();
                            zVar.parserJson(optJSONArray.optJSONObject(i));
                            this.fuP.add(zVar);
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
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            a.this.fuL = null;
            if (this.aiS == null) {
                a.this.mLoadDataCallBack.g(null);
                return;
            }
            f fVar = new f();
            fVar.ub = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    fVar.fuQ = this.fuP;
                }
            } else {
                fVar.fuO = this.aiS.getErrorString();
            }
            a.this.mLoadDataCallBack.g(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiS != null) {
                this.aiS.eg();
            }
            a.this.fuL = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.g(null);
        }
    }
}
