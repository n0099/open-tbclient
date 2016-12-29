package com.baidu.tieba.tbadkCore.f;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.util.z;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e {
    private C0075a fiC;
    private c fiD;
    private e fiE;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fiC = null;
        this.fiD = null;
        this.fiE = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean cfs;
        public int ejf;
        public int fiF;
        public String fiH;
        public int mErrCode;
        public String mPostId;
        public boolean uc;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public String fiH;
        public boolean uc;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public String fiH;
        public ArrayList<ac> fiJ;
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
        bgN();
        return false;
    }

    public void bgN() {
        if (this.fiC != null) {
            this.fiC.cancel();
            this.fiC = null;
        }
        if (this.fiD != null) {
            this.fiD.cancel();
            this.fiD = null;
        }
        if (this.fiE != null) {
            this.fiE.cancel();
            this.fiE = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.fiC != null) {
            this.fiC.cancel();
            this.fiC = null;
        }
        this.mLoadDataMode = 0;
        this.fiC = new C0075a(str, str2, str3, str4, i, i2, z);
        this.fiC.setPriority(2);
        this.fiC.execute(new String[0]);
    }

    public boolean bgO() {
        return (this.fiC == null && this.fiD == null && this.fiE == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0075a extends BdAsyncTask<String, Integer, Boolean> {
        private z aiN = null;
        private boolean cfs;
        private int ejf;
        private int fiF;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;

        public C0075a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.fiF = i;
            this.ejf = i2;
            this.cfs = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.fiF == 0) {
                str = String.valueOf(str2) + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = String.valueOf(str2) + TbConfig.DEL_POST_ADDRESS;
            }
            this.aiN = new z(str);
            this.aiN.n("fid", this.mForumId);
            this.aiN.n("word", this.mForumName);
            this.aiN.n("z", this.mThreadId);
            if (this.fiF == 0) {
                if (this.ejf == 0) {
                    this.aiN.n("delete_my_thread", "1");
                }
            } else if (this.fiF == 1) {
                this.aiN.n(Info.kBaiduPIDKey, this.mPostId);
                this.aiN.n("isfloor", "0");
                this.aiN.n("src", "1");
                if (this.ejf == 0 && this.cfs) {
                    this.aiN.n("delete_my_post", "1");
                }
            } else if (this.fiF == 2) {
                this.aiN.n(Info.kBaiduPIDKey, this.mPostId);
                this.aiN.n("isfloor", "1");
                this.aiN.n("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                if (this.ejf == 0 && this.cfs) {
                    this.aiN.n("delete_my_post", "1");
                }
            }
            if (this.ejf == 0 && !this.cfs) {
                this.aiN.n("is_vipdel", "1");
            } else {
                this.aiN.n("is_vipdel", "0");
            }
            this.aiN.uI().vB().mIsNeedTbs = true;
            this.aiN.uk();
            if (this.aiN.uI().vC().oH()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiN != null) {
                this.aiN.eg();
            }
            a.this.fiC = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.g(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            a.this.fiC = null;
            if (this.aiN == null || bool == null) {
                a.this.mLoadDataCallBack.g(null);
                return;
            }
            b bVar = new b();
            bVar.fiF = this.fiF;
            bVar.mPostId = this.mPostId;
            bVar.cfs = this.cfs;
            bVar.ejf = this.ejf;
            bVar.fiH = this.aiN.getErrorString();
            bVar.mErrCode = this.aiN.uM();
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
        private z aiN;
        private String dUX;
        final /* synthetic */ a fiG;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private String mUserName;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            this.aiN = new z(strArr[0]);
            this.aiN.n("day", this.dUX);
            this.aiN.n("un", this.mUserName);
            this.aiN.n("fid", this.mForumId);
            this.aiN.n("word", this.mForumName);
            this.aiN.n("z", this.mThreadId);
            this.aiN.n("ntn", "banid");
            this.aiN.uI().vB().mIsNeedTbs = true;
            this.aiN.uk();
            if (this.aiN.uI().vC().oH()) {
                return null;
            }
            return this.aiN.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiN != null) {
                this.aiN.eg();
            }
            this.fiG.fiD = null;
            super.cancel(true);
            this.fiG.mLoadDataCallBack.g(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ew */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            this.fiG.fiD = null;
            if (this.aiN == null) {
                this.fiG.mLoadDataCallBack.g(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.uc = true;
            } else {
                dVar.uc = false;
                dVar.fiH = str;
            }
            this.fiG.mLoadDataCallBack.g(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.fiE != null) {
            this.fiE.cancel();
            this.fiE = null;
        }
        this.mLoadDataMode = i;
        this.fiE = new e(str, str2, str3, i, str4);
        this.fiE.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.fiE.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<String, String, Boolean> {
        private z aiN = null;
        String efP;
        ArrayList<ac> fiI;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private int mType;

        public e(String str, String str2, String str3, int i, String str4) {
            this.fiI = null;
            this.efP = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.efP = str4;
            this.fiI = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            this.aiN = new z(strArr[0]);
            this.aiN.n("word", this.mForumName);
            if (this.mType != 6) {
                this.aiN.n("fid", this.mForumId);
                this.aiN.n("z", this.mThreadId);
                if (this.mType == 4) {
                    this.aiN.n("ntn", "set");
                } else if (this.mType == 5) {
                    this.aiN.n("ntn", "");
                } else if (this.mType == 2) {
                    this.aiN.n("ntn", "set");
                    this.aiN.n("cid", this.efP);
                } else {
                    this.aiN.n("ntn", "");
                }
            }
            this.aiN.uI().vB().mIsNeedTbs = true;
            String uk = this.aiN.uk();
            if (this.aiN.uI().vC().oH()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(uk).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            ac acVar = new ac();
                            acVar.parserJson(optJSONArray.optJSONObject(i));
                            this.fiI.add(acVar);
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
            a.this.fiE = null;
            if (this.aiN == null) {
                a.this.mLoadDataCallBack.g(null);
                return;
            }
            f fVar = new f();
            fVar.uc = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    fVar.fiJ = this.fiI;
                }
            } else {
                fVar.fiH = this.aiN.getErrorString();
            }
            a.this.mLoadDataCallBack.g(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiN != null) {
                this.aiN.eg();
            }
            a.this.fiE = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.g(null);
        }
    }
}
