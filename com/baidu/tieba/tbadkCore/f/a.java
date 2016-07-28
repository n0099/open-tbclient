package com.baidu.tieba.tbadkCore.f;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.util.ab;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e {
    private C0077a fmP;
    private c fmQ;
    private e fmR;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fmP = null;
        this.fmQ = null;
        this.fmR = null;
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.fmP = null;
        this.fmQ = null;
        this.fmR = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public int fmS;
        public String fmU;
        public int mErrCode;
        public String mPostId;
        public boolean rJ;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public String fmU;
        public boolean rJ;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public String fmU;
        public ArrayList<y> fmW;
        public boolean rJ;

        public f() {
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        bgq();
        return false;
    }

    public void bgq() {
        if (this.fmP != null) {
            this.fmP.cancel();
            this.fmP = null;
        }
        if (this.fmQ != null) {
            this.fmQ.cancel();
            this.fmQ = null;
        }
        if (this.fmR != null) {
            this.fmR.cancel();
            this.fmR = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.fmP != null) {
            this.fmP.cancel();
            this.fmP = null;
        }
        this.mLoadDataMode = 0;
        this.fmP = new C0077a(str, str2, str3, str4, i, i2, z);
        this.fmP.setPriority(2);
        this.fmP.execute(new String[0]);
    }

    public boolean bgr() {
        return (this.fmP == null && this.fmQ == null && this.fmR == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0077a extends BdAsyncTask<String, Integer, Boolean> {
        private ab afX = null;
        private boolean cjo;
        private int ekf;
        private int fmS;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;

        public C0077a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.fmS = i;
            this.ekf = i2;
            this.cjo = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.fmS == 0) {
                str = String.valueOf(str2) + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = String.valueOf(str2) + TbConfig.DEL_POST_ADDRESS;
            }
            this.afX = new ab(str);
            this.afX.n("fid", this.mForumId);
            this.afX.n("word", this.mForumName);
            this.afX.n("z", this.mThreadId);
            if (this.fmS == 0) {
                if (this.ekf == 0) {
                    this.afX.n("delete_my_thread", "1");
                }
            } else if (this.fmS == 1) {
                this.afX.n(Info.kBaiduPIDKey, this.mPostId);
                this.afX.n("isfloor", "0");
                this.afX.n("src", "1");
                if (this.ekf == 0 && this.cjo) {
                    this.afX.n("delete_my_post", "1");
                }
            } else if (this.fmS == 2) {
                this.afX.n(Info.kBaiduPIDKey, this.mPostId);
                this.afX.n("isfloor", "1");
                this.afX.n("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                if (this.ekf == 0 && this.cjo) {
                    this.afX.n("delete_my_post", "1");
                }
            }
            if (this.ekf == 0 && !this.cjo) {
                this.afX.n("is_vipdel", "1");
            } else {
                this.afX.n("is_vipdel", "0");
            }
            this.afX.tx().uu().mIsNeedTbs = true;
            this.afX.sZ();
            if (this.afX.tx().uv().nJ()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afX != null) {
                this.afX.dl();
            }
            a.this.fmP = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.g(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            a.this.fmP = null;
            if (this.afX == null || bool == null) {
                a.this.mLoadDataCallBack.g(null);
                return;
            }
            b bVar = new b();
            bVar.fmS = this.fmS;
            bVar.mPostId = this.mPostId;
            bVar.fmU = this.afX.getErrorString();
            bVar.mErrCode = this.afX.tB();
            if (bool.booleanValue()) {
                bVar.rJ = true;
            } else {
                bVar.rJ = false;
            }
            a.this.mLoadDataCallBack.g(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private ab afX;
        private String dWp;
        final /* synthetic */ a fmT;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private String mUserName;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            this.afX = new ab(strArr[0]);
            this.afX.n("day", this.dWp);
            this.afX.n("un", this.mUserName);
            this.afX.n("fid", this.mForumId);
            this.afX.n("word", this.mForumName);
            this.afX.n("z", this.mThreadId);
            this.afX.n("ntn", "banid");
            this.afX.tx().uu().mIsNeedTbs = true;
            this.afX.sZ();
            if (this.afX.tx().uv().nJ()) {
                return null;
            }
            return this.afX.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afX != null) {
                this.afX.dl();
            }
            this.fmT.fmQ = null;
            super.cancel(true);
            this.fmT.mLoadDataCallBack.g(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: er */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            this.fmT.fmQ = null;
            if (this.afX == null) {
                this.fmT.mLoadDataCallBack.g(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.rJ = true;
            } else {
                dVar.rJ = false;
                dVar.fmU = str;
            }
            this.fmT.mLoadDataCallBack.g(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.fmR != null) {
            this.fmR.cancel();
            this.fmR = null;
        }
        this.mLoadDataMode = i;
        this.fmR = new e(str, str2, str3, i, str4);
        this.fmR.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.fmR.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<String, String, Boolean> {
        private ab afX = null;
        String ehi;
        ArrayList<y> fmV;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private int mType;

        public e(String str, String str2, String str3, int i, String str4) {
            this.fmV = null;
            this.ehi = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.ehi = str4;
            this.fmV = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            this.afX = new ab(strArr[0]);
            this.afX.n("word", this.mForumName);
            if (this.mType != 6) {
                this.afX.n("fid", this.mForumId);
                this.afX.n("z", this.mThreadId);
                if (this.mType == 4) {
                    this.afX.n("ntn", "set");
                } else if (this.mType == 5) {
                    this.afX.n("ntn", "");
                } else if (this.mType == 2) {
                    this.afX.n("ntn", "set");
                    this.afX.n("cid", this.ehi);
                } else {
                    this.afX.n("ntn", "");
                }
            }
            this.afX.tx().uu().mIsNeedTbs = true;
            String sZ = this.afX.sZ();
            if (this.afX.tx().uv().nJ()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(sZ).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            y yVar = new y();
                            yVar.parserJson(optJSONArray.optJSONObject(i));
                            this.fmV.add(yVar);
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
            a.this.fmR = null;
            if (this.afX == null) {
                a.this.mLoadDataCallBack.g(null);
                return;
            }
            f fVar = new f();
            fVar.rJ = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    fVar.fmW = this.fmV;
                }
            } else {
                fVar.fmU = this.afX.getErrorString();
            }
            a.this.mLoadDataCallBack.g(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afX != null) {
                this.afX.dl();
            }
            a.this.fmR = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.g(null);
        }
    }
}
