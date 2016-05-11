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
    private C0076a euW;
    private c euX;
    private e euY;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.euW = null;
        this.euX = null;
        this.euY = null;
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.euW = null;
        this.euX = null;
        this.euY = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public int euZ;
        public String evb;
        public int mErrCode;
        public String mPostId;
        public boolean rg;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public String evb;
        public boolean rg;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public String evb;
        public ArrayList<t> evd;
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
        aUH();
        return false;
    }

    public void aUH() {
        if (this.euW != null) {
            this.euW.cancel();
            this.euW = null;
        }
        if (this.euX != null) {
            this.euX.cancel();
            this.euX = null;
        }
        if (this.euY != null) {
            this.euY.cancel();
            this.euY = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.euW != null) {
            this.euW.cancel();
            this.euW = null;
        }
        this.mLoadDataMode = 0;
        this.euW = new C0076a(str, str2, str3, str4, i, i2, z);
        this.euW.setPriority(2);
        this.euW.execute(new String[0]);
    }

    public boolean aUI() {
        return (this.euW == null && this.euX == null && this.euY == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0076a extends BdAsyncTask<String, Integer, Boolean> {
        private ab aeI = null;
        private boolean bJq;
        private int dqS;
        private int euZ;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;

        public C0076a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.euZ = i;
            this.dqS = i2;
            this.bJq = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.euZ == 0) {
                str = String.valueOf(str2) + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = String.valueOf(str2) + TbConfig.DEL_POST_ADDRESS;
            }
            this.aeI = new ab(str);
            this.aeI.n("fid", this.mForumId);
            this.aeI.n("word", this.mForumName);
            this.aeI.n("z", this.mThreadId);
            if (this.euZ == 0) {
                if (this.dqS == 0) {
                    this.aeI.n("delete_my_thread", "1");
                }
            } else if (this.euZ == 1) {
                this.aeI.n(Info.kBaiduPIDKey, this.mPostId);
                this.aeI.n("isfloor", "0");
                this.aeI.n("src", "1");
                if (this.dqS == 0 && this.bJq) {
                    this.aeI.n("delete_my_post", "1");
                }
            } else if (this.euZ == 2) {
                this.aeI.n(Info.kBaiduPIDKey, this.mPostId);
                this.aeI.n("isfloor", "1");
                this.aeI.n("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                if (this.dqS == 0 && this.bJq) {
                    this.aeI.n("delete_my_post", "1");
                }
            }
            if (this.dqS == 0 && !this.bJq) {
                this.aeI.n("is_vipdel", "1");
            } else {
                this.aeI.n("is_vipdel", "0");
            }
            this.aeI.tA().uu().mIsNeedTbs = true;
            this.aeI.tc();
            if (this.aeI.tA().uv().nZ()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aeI != null) {
                this.aeI.dl();
            }
            a.this.euW = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            a.this.euW = null;
            if (this.aeI == null || bool == null) {
                a.this.mLoadDataCallBack.d(null);
                return;
            }
            b bVar = new b();
            bVar.euZ = this.euZ;
            bVar.mPostId = this.mPostId;
            bVar.evb = this.aeI.getErrorString();
            bVar.mErrCode = this.aeI.tE();
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
        private ab aeI;
        private String ddE;
        final /* synthetic */ a eva;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private String mUserName;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            this.aeI = new ab(strArr[0]);
            this.aeI.n("day", this.ddE);
            this.aeI.n("un", this.mUserName);
            this.aeI.n("fid", this.mForumId);
            this.aeI.n("word", this.mForumName);
            this.aeI.n("z", this.mThreadId);
            this.aeI.n("ntn", "banid");
            this.aeI.tA().uu().mIsNeedTbs = true;
            this.aeI.tc();
            if (this.aeI.tA().uv().nZ()) {
                return null;
            }
            return this.aeI.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aeI != null) {
                this.aeI.dl();
            }
            this.eva.euX = null;
            super.cancel(true);
            this.eva.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: eo */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            this.eva.euX = null;
            if (this.aeI == null) {
                this.eva.mLoadDataCallBack.d(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.rg = true;
            } else {
                dVar.rg = false;
                dVar.evb = str;
            }
            this.eva.mLoadDataCallBack.d(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.euY != null) {
            this.euY.cancel();
            this.euY = null;
        }
        this.mLoadDataMode = i;
        this.euY = new e(str, str2, str3, i, str4);
        this.euY.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.euY.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<String, String, Boolean> {
        private ab aeI = null;
        String dok;
        ArrayList<t> evc;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private int mType;

        public e(String str, String str2, String str3, int i, String str4) {
            this.evc = null;
            this.dok = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.dok = str4;
            this.evc = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            this.aeI = new ab(strArr[0]);
            this.aeI.n("word", this.mForumName);
            if (this.mType != 6) {
                this.aeI.n("fid", this.mForumId);
                this.aeI.n("z", this.mThreadId);
                if (this.mType == 4) {
                    this.aeI.n("ntn", "set");
                } else if (this.mType == 5) {
                    this.aeI.n("ntn", "");
                } else if (this.mType == 2) {
                    this.aeI.n("ntn", "set");
                    this.aeI.n("cid", this.dok);
                } else {
                    this.aeI.n("ntn", "");
                }
            }
            this.aeI.tA().uu().mIsNeedTbs = true;
            String tc = this.aeI.tc();
            if (this.aeI.tA().uv().nZ()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(tc).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            t tVar = new t();
                            tVar.parserJson(optJSONArray.optJSONObject(i));
                            this.evc.add(tVar);
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
            a.this.euY = null;
            if (this.aeI == null) {
                a.this.mLoadDataCallBack.d(null);
                return;
            }
            f fVar = new f();
            fVar.rg = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    fVar.evd = this.evc;
                }
            } else {
                fVar.evb = this.aeI.getErrorString();
            }
            a.this.mLoadDataCallBack.d(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aeI != null) {
                this.aeI.dl();
            }
            a.this.euY = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.d(null);
        }
    }
}
