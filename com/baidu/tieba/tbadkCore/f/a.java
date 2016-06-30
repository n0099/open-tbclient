package com.baidu.tieba.tbadkCore.f;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.util.ab;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e {
    private C0078a eZM;
    private c eZN;
    private e eZO;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eZM = null;
        this.eZN = null;
        this.eZO = null;
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.eZM = null;
        this.eZN = null;
        this.eZO = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public int eZP;
        public String eZR;
        public int mErrCode;
        public String mPostId;
        public boolean rg;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public String eZR;
        public boolean rg;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public String eZR;
        public ArrayList<v> eZT;
        public boolean rg;

        public f() {
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        bdb();
        return false;
    }

    public void bdb() {
        if (this.eZM != null) {
            this.eZM.cancel();
            this.eZM = null;
        }
        if (this.eZN != null) {
            this.eZN.cancel();
            this.eZN = null;
        }
        if (this.eZO != null) {
            this.eZO.cancel();
            this.eZO = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.eZM != null) {
            this.eZM.cancel();
            this.eZM = null;
        }
        this.mLoadDataMode = 0;
        this.eZM = new C0078a(str, str2, str3, str4, i, i2, z);
        this.eZM.setPriority(2);
        this.eZM.execute(new String[0]);
    }

    public boolean bdc() {
        return (this.eZM == null && this.eZN == null && this.eZO == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0078a extends BdAsyncTask<String, Integer, Boolean> {
        private ab afj = null;
        private boolean chd;
        private int dXD;
        private int eZP;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;

        public C0078a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.eZP = i;
            this.dXD = i2;
            this.chd = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.eZP == 0) {
                str = String.valueOf(str2) + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = String.valueOf(str2) + TbConfig.DEL_POST_ADDRESS;
            }
            this.afj = new ab(str);
            this.afj.n("fid", this.mForumId);
            this.afj.n("word", this.mForumName);
            this.afj.n("z", this.mThreadId);
            if (this.eZP == 0) {
                if (this.dXD == 0) {
                    this.afj.n("delete_my_thread", "1");
                }
            } else if (this.eZP == 1) {
                this.afj.n(Info.kBaiduPIDKey, this.mPostId);
                this.afj.n("isfloor", "0");
                this.afj.n("src", "1");
                if (this.dXD == 0 && this.chd) {
                    this.afj.n("delete_my_post", "1");
                }
            } else if (this.eZP == 2) {
                this.afj.n(Info.kBaiduPIDKey, this.mPostId);
                this.afj.n("isfloor", "1");
                this.afj.n("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                if (this.dXD == 0 && this.chd) {
                    this.afj.n("delete_my_post", "1");
                }
            }
            if (this.dXD == 0 && !this.chd) {
                this.afj.n("is_vipdel", "1");
            } else {
                this.afj.n("is_vipdel", "0");
            }
            this.afj.ty().uu().mIsNeedTbs = true;
            this.afj.ta();
            if (this.afj.ty().uv().nU()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afj != null) {
                this.afj.dm();
            }
            a.this.eZM = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            a.this.eZM = null;
            if (this.afj == null || bool == null) {
                a.this.mLoadDataCallBack.d(null);
                return;
            }
            b bVar = new b();
            bVar.eZP = this.eZP;
            bVar.mPostId = this.mPostId;
            bVar.eZR = this.afj.getErrorString();
            bVar.mErrCode = this.afj.tC();
            if (bool.booleanValue()) {
                bVar.rg = true;
            } else {
                bVar.rg = false;
            }
            a.this.mLoadDataCallBack.d(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private ab afj;
        private String dKg;
        final /* synthetic */ a eZQ;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private String mUserName;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            this.afj = new ab(strArr[0]);
            this.afj.n("day", this.dKg);
            this.afj.n("un", this.mUserName);
            this.afj.n("fid", this.mForumId);
            this.afj.n("word", this.mForumName);
            this.afj.n("z", this.mThreadId);
            this.afj.n("ntn", "banid");
            this.afj.ty().uu().mIsNeedTbs = true;
            this.afj.ta();
            if (this.afj.ty().uv().nU()) {
                return null;
            }
            return this.afj.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afj != null) {
                this.afj.dm();
            }
            this.eZQ.eZN = null;
            super.cancel(true);
            this.eZQ.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: es */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            this.eZQ.eZN = null;
            if (this.afj == null) {
                this.eZQ.mLoadDataCallBack.d(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.rg = true;
            } else {
                dVar.rg = false;
                dVar.eZR = str;
            }
            this.eZQ.mLoadDataCallBack.d(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.eZO != null) {
            this.eZO.cancel();
            this.eZO = null;
        }
        this.mLoadDataMode = i;
        this.eZO = new e(str, str2, str3, i, str4);
        this.eZO.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.eZO.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<String, String, Boolean> {
        private ab afj = null;
        String dUH;
        ArrayList<v> eZS;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private int mType;

        public e(String str, String str2, String str3, int i, String str4) {
            this.eZS = null;
            this.dUH = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.dUH = str4;
            this.eZS = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            this.afj = new ab(strArr[0]);
            this.afj.n("word", this.mForumName);
            if (this.mType != 6) {
                this.afj.n("fid", this.mForumId);
                this.afj.n("z", this.mThreadId);
                if (this.mType == 4) {
                    this.afj.n("ntn", "set");
                } else if (this.mType == 5) {
                    this.afj.n("ntn", "");
                } else if (this.mType == 2) {
                    this.afj.n("ntn", "set");
                    this.afj.n("cid", this.dUH);
                } else {
                    this.afj.n("ntn", "");
                }
            }
            this.afj.ty().uu().mIsNeedTbs = true;
            String ta = this.afj.ta();
            if (this.afj.ty().uv().nU()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(ta).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            v vVar = new v();
                            vVar.parserJson(optJSONArray.optJSONObject(i));
                            this.eZS.add(vVar);
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
            a.this.eZO = null;
            if (this.afj == null) {
                a.this.mLoadDataCallBack.d(null);
                return;
            }
            f fVar = new f();
            fVar.rg = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    fVar.eZT = this.eZS;
                }
            } else {
                fVar.eZR = this.afj.getErrorString();
            }
            a.this.mLoadDataCallBack.d(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afj != null) {
                this.afj.dm();
            }
            a.this.eZO = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.d(null);
        }
    }
}
