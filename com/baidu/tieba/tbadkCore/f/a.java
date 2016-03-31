package com.baidu.tieba.tbadkCore.f;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.t;
import com.baidu.tbadk.core.util.ab;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e {
    private C0084a erN;
    private c erO;
    private e erP;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.erN = null;
        this.erO = null;
        this.erP = null;
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.erN = null;
        this.erO = null;
        this.erP = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean AU;
        public int erQ;
        public String erS;
        public int mErrCode;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean AU;
        public String erS;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public boolean AU;
        public String erS;
        public ArrayList<t> erU;

        public f() {
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        aUm();
        return false;
    }

    public void aUm() {
        if (this.erN != null) {
            this.erN.cancel();
            this.erN = null;
        }
        if (this.erO != null) {
            this.erO.cancel();
            this.erO = null;
        }
        if (this.erP != null) {
            this.erP.cancel();
            this.erP = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.erN != null) {
            this.erN.cancel();
            this.erN = null;
        }
        this.mLoadDataMode = 0;
        this.erN = new C0084a(str, str2, str3, str4, i, i2, z);
        this.erN.setPriority(2);
        this.erN.execute(new String[0]);
    }

    public boolean aUn() {
        return (this.erN == null && this.erO == null && this.erP == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0084a extends BdAsyncTask<String, Integer, Boolean> {
        private ab aiW = null;
        private boolean bJj;
        private int dpl;
        private int erQ;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;

        public C0084a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.erQ = i;
            this.dpl = i2;
            this.bJj = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.erQ == 0) {
                str = String.valueOf(str2) + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = String.valueOf(str2) + TbConfig.DEL_POST_ADDRESS;
            }
            this.aiW = new ab(str);
            this.aiW.p("fid", this.mForumId);
            this.aiW.p("word", this.mForumName);
            this.aiW.p("z", this.mThreadId);
            if (this.erQ == 0) {
                if (this.dpl == 0) {
                    this.aiW.p("delete_my_thread", "1");
                }
            } else if (this.erQ == 1) {
                this.aiW.p(Info.kBaiduPIDKey, this.mPostId);
                this.aiW.p("isfloor", "0");
                this.aiW.p("src", "1");
                if (this.dpl == 0 && this.bJj) {
                    this.aiW.p("delete_my_post", "1");
                }
            } else if (this.erQ == 2) {
                this.aiW.p(Info.kBaiduPIDKey, this.mPostId);
                this.aiW.p("isfloor", "1");
                this.aiW.p("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                if (this.dpl == 0 && this.bJj) {
                    this.aiW.p("delete_my_post", "1");
                }
            }
            if (this.dpl == 0 && !this.bJj) {
                this.aiW.p("is_vipdel", "1");
            } else {
                this.aiW.p("is_vipdel", "0");
            }
            this.aiW.vU().wO().mIsNeedTbs = true;
            this.aiW.vw();
            if (this.aiW.vU().wP().qC()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiW != null) {
                this.aiW.gX();
            }
            a.this.erN = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            a.this.erN = null;
            if (this.aiW == null || bool == null) {
                a.this.mLoadDataCallBack.d(null);
                return;
            }
            b bVar = new b();
            bVar.erQ = this.erQ;
            bVar.mPostId = this.mPostId;
            bVar.erS = this.aiW.getErrorString();
            bVar.mErrCode = this.aiW.vY();
            if (bool.booleanValue()) {
                bVar.AU = true;
            } else {
                bVar.AU = false;
            }
            a.this.mLoadDataCallBack.d(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private ab aiW;
        private String dbi;
        final /* synthetic */ a erR;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private String mUserName;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public String doInBackground(String... strArr) {
            this.aiW = new ab(strArr[0]);
            this.aiW.p("day", this.dbi);
            this.aiW.p("un", this.mUserName);
            this.aiW.p("fid", this.mForumId);
            this.aiW.p("word", this.mForumName);
            this.aiW.p("z", this.mThreadId);
            this.aiW.p("ntn", "banid");
            this.aiW.vU().wO().mIsNeedTbs = true;
            this.aiW.vw();
            if (this.aiW.vU().wP().qC()) {
                return null;
            }
            return this.aiW.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiW != null) {
                this.aiW.gX();
            }
            this.erR.erO = null;
            super.cancel(true);
            this.erR.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: er */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            this.erR.erO = null;
            if (this.aiW == null) {
                this.erR.mLoadDataCallBack.d(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.AU = true;
            } else {
                dVar.AU = false;
                dVar.erS = str;
            }
            this.erR.mLoadDataCallBack.d(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.erP != null) {
            this.erP.cancel();
            this.erP = null;
        }
        this.mLoadDataMode = i;
        this.erP = new e(str, str2, str3, i, str4);
        this.erP.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.erP.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<String, String, Boolean> {
        private ab aiW = null;
        String dlP;
        ArrayList<t> erT;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private int mType;

        public e(String str, String str2, String str3, int i, String str4) {
            this.erT = null;
            this.dlP = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.dlP = str4;
            this.erT = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public Boolean doInBackground(String... strArr) {
            this.aiW = new ab(strArr[0]);
            this.aiW.p("word", this.mForumName);
            if (this.mType != 6) {
                this.aiW.p("fid", this.mForumId);
                this.aiW.p("z", this.mThreadId);
                if (this.mType == 4) {
                    this.aiW.p("ntn", "set");
                } else if (this.mType == 5) {
                    this.aiW.p("ntn", "");
                } else if (this.mType == 2) {
                    this.aiW.p("ntn", "set");
                    this.aiW.p("cid", this.dlP);
                } else {
                    this.aiW.p("ntn", "");
                }
            }
            this.aiW.vU().wO().mIsNeedTbs = true;
            String vw = this.aiW.vw();
            if (this.aiW.vU().wP().qC()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(vw).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            t tVar = new t();
                            tVar.parserJson(optJSONArray.optJSONObject(i));
                            this.erT.add(tVar);
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
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            a.this.erP = null;
            if (this.aiW == null) {
                a.this.mLoadDataCallBack.d(null);
                return;
            }
            f fVar = new f();
            fVar.AU = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    fVar.erU = this.erT;
                }
            } else {
                fVar.erS = this.aiW.getErrorString();
            }
            a.this.mLoadDataCallBack.d(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiW != null) {
                this.aiW.gX();
            }
            a.this.erP = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.d(null);
        }
    }
}
