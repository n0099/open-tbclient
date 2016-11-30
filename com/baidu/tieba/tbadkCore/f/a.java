package com.baidu.tieba.tbadkCore.f;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.util.z;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e {
    private C0081a fEv;
    private c fEw;
    private e fEx;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fEv = null;
        this.fEw = null;
        this.fEx = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean cAf;
        public int eFf;
        public String fEA;
        public int fEy;
        public int mErrCode;
        public String mPostId;
        public boolean uc;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public String fEA;
        public boolean uc;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public String fEA;
        public ArrayList<ad> fEC;
        public boolean uc;

        public f() {
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        bmT();
        return false;
    }

    public void bmT() {
        if (this.fEv != null) {
            this.fEv.cancel();
            this.fEv = null;
        }
        if (this.fEw != null) {
            this.fEw.cancel();
            this.fEw = null;
        }
        if (this.fEx != null) {
            this.fEx.cancel();
            this.fEx = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.fEv != null) {
            this.fEv.cancel();
            this.fEv = null;
        }
        this.mLoadDataMode = 0;
        this.fEv = new C0081a(str, str2, str3, str4, i, i2, z);
        this.fEv.setPriority(2);
        this.fEv.execute(new String[0]);
    }

    public boolean bmU() {
        return (this.fEv == null && this.fEw == null && this.fEx == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0081a extends BdAsyncTask<String, Integer, Boolean> {
        private z ajm = null;
        private boolean cAf;
        private int eFf;
        private int fEy;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;

        public C0081a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.fEy = i;
            this.eFf = i2;
            this.cAf = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.fEy == 0) {
                str = String.valueOf(str2) + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = String.valueOf(str2) + TbConfig.DEL_POST_ADDRESS;
            }
            this.ajm = new z(str);
            this.ajm.n("fid", this.mForumId);
            this.ajm.n("word", this.mForumName);
            this.ajm.n("z", this.mThreadId);
            if (this.fEy == 0) {
                if (this.eFf == 0) {
                    this.ajm.n("delete_my_thread", "1");
                }
            } else if (this.fEy == 1) {
                this.ajm.n(Info.kBaiduPIDKey, this.mPostId);
                this.ajm.n("isfloor", "0");
                this.ajm.n("src", "1");
                if (this.eFf == 0 && this.cAf) {
                    this.ajm.n("delete_my_post", "1");
                }
            } else if (this.fEy == 2) {
                this.ajm.n(Info.kBaiduPIDKey, this.mPostId);
                this.ajm.n("isfloor", "1");
                this.ajm.n("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                if (this.eFf == 0 && this.cAf) {
                    this.ajm.n("delete_my_post", "1");
                }
            }
            if (this.eFf == 0 && !this.cAf) {
                this.ajm.n("is_vipdel", "1");
            } else {
                this.ajm.n("is_vipdel", "0");
            }
            this.ajm.uW().vR().mIsNeedTbs = true;
            this.ajm.uy();
            if (this.ajm.uW().vS().oH()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.ajm != null) {
                this.ajm.eg();
            }
            a.this.fEv = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.g(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            a.this.fEv = null;
            if (this.ajm == null || bool == null) {
                a.this.mLoadDataCallBack.g(null);
                return;
            }
            b bVar = new b();
            bVar.fEy = this.fEy;
            bVar.mPostId = this.mPostId;
            bVar.cAf = this.cAf;
            bVar.eFf = this.eFf;
            bVar.fEA = this.ajm.getErrorString();
            bVar.mErrCode = this.ajm.va();
            if (bool.booleanValue()) {
                bVar.uc = true;
            } else {
                bVar.uc = false;
            }
            a.this.mLoadDataCallBack.g(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private z ajm;
        private String eqq;
        final /* synthetic */ a fEz;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private String mUserName;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            this.ajm = new z(strArr[0]);
            this.ajm.n("day", this.eqq);
            this.ajm.n("un", this.mUserName);
            this.ajm.n("fid", this.mForumId);
            this.ajm.n("word", this.mForumName);
            this.ajm.n("z", this.mThreadId);
            this.ajm.n("ntn", "banid");
            this.ajm.uW().vR().mIsNeedTbs = true;
            this.ajm.uy();
            if (this.ajm.uW().vS().oH()) {
                return null;
            }
            return this.ajm.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.ajm != null) {
                this.ajm.eg();
            }
            this.fEz.fEw = null;
            super.cancel(true);
            this.fEz.mLoadDataCallBack.g(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ez */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            this.fEz.fEw = null;
            if (this.ajm == null) {
                this.fEz.mLoadDataCallBack.g(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.uc = true;
            } else {
                dVar.uc = false;
                dVar.fEA = str;
            }
            this.fEz.mLoadDataCallBack.g(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.fEx != null) {
            this.fEx.cancel();
            this.fEx = null;
        }
        this.mLoadDataMode = i;
        this.fEx = new e(str, str2, str3, i, str4);
        this.fEx.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.fEx.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<String, String, Boolean> {
        private z ajm = null;
        String eBJ;
        ArrayList<ad> fEB;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private int mType;

        public e(String str, String str2, String str3, int i, String str4) {
            this.fEB = null;
            this.eBJ = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.eBJ = str4;
            this.fEB = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            this.ajm = new z(strArr[0]);
            this.ajm.n("word", this.mForumName);
            if (this.mType != 6) {
                this.ajm.n("fid", this.mForumId);
                this.ajm.n("z", this.mThreadId);
                if (this.mType == 4) {
                    this.ajm.n("ntn", "set");
                } else if (this.mType == 5) {
                    this.ajm.n("ntn", "");
                } else if (this.mType == 2) {
                    this.ajm.n("ntn", "set");
                    this.ajm.n("cid", this.eBJ);
                } else {
                    this.ajm.n("ntn", "");
                }
            }
            this.ajm.uW().vR().mIsNeedTbs = true;
            String uy = this.ajm.uy();
            if (this.ajm.uW().vS().oH()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(uy).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            ad adVar = new ad();
                            adVar.parserJson(optJSONArray.optJSONObject(i));
                            this.fEB.add(adVar);
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
            a.this.fEx = null;
            if (this.ajm == null) {
                a.this.mLoadDataCallBack.g(null);
                return;
            }
            f fVar = new f();
            fVar.uc = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    fVar.fEC = this.fEB;
                }
            } else {
                fVar.fEA = this.ajm.getErrorString();
            }
            a.this.mLoadDataCallBack.g(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.ajm != null) {
                this.ajm.eg();
            }
            a.this.fEx = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.g(null);
        }
    }
}
