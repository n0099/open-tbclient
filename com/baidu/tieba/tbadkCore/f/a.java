package com.baidu.tieba.tbadkCore.f;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ab;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e {
    private C0080a fxq;
    private c fxr;
    private e fxs;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fxq = null;
        this.fxr = null;
        this.fxs = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean cuW;
        public int eyv;
        public int fxt;
        public String fxv;
        public int mErrCode;
        public String mPostId;
        public boolean ub;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public String fxv;
        public boolean ub;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public String fxv;
        public ArrayList<ab> fxx;
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
        bkD();
        return false;
    }

    public void bkD() {
        if (this.fxq != null) {
            this.fxq.cancel();
            this.fxq = null;
        }
        if (this.fxr != null) {
            this.fxr.cancel();
            this.fxr = null;
        }
        if (this.fxs != null) {
            this.fxs.cancel();
            this.fxs = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.fxq != null) {
            this.fxq.cancel();
            this.fxq = null;
        }
        this.mLoadDataMode = 0;
        this.fxq = new C0080a(str, str2, str3, str4, i, i2, z);
        this.fxq.setPriority(2);
        this.fxq.execute(new String[0]);
    }

    public boolean bkE() {
        return (this.fxq == null && this.fxr == null && this.fxs == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0080a extends BdAsyncTask<String, Integer, Boolean> {
        private com.baidu.tbadk.core.util.ab aiu = null;
        private boolean cuW;
        private int eyv;
        private int fxt;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;

        public C0080a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.fxt = i;
            this.eyv = i2;
            this.cuW = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.fxt == 0) {
                str = String.valueOf(str2) + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = String.valueOf(str2) + TbConfig.DEL_POST_ADDRESS;
            }
            this.aiu = new com.baidu.tbadk.core.util.ab(str);
            this.aiu.n("fid", this.mForumId);
            this.aiu.n("word", this.mForumName);
            this.aiu.n("z", this.mThreadId);
            if (this.fxt == 0) {
                if (this.eyv == 0) {
                    this.aiu.n("delete_my_thread", "1");
                }
            } else if (this.fxt == 1) {
                this.aiu.n(Info.kBaiduPIDKey, this.mPostId);
                this.aiu.n("isfloor", "0");
                this.aiu.n("src", "1");
                if (this.eyv == 0 && this.cuW) {
                    this.aiu.n("delete_my_post", "1");
                }
            } else if (this.fxt == 2) {
                this.aiu.n(Info.kBaiduPIDKey, this.mPostId);
                this.aiu.n("isfloor", "1");
                this.aiu.n("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                if (this.eyv == 0 && this.cuW) {
                    this.aiu.n("delete_my_post", "1");
                }
            }
            if (this.eyv == 0 && !this.cuW) {
                this.aiu.n("is_vipdel", "1");
            } else {
                this.aiu.n("is_vipdel", "0");
            }
            this.aiu.uS().vN().mIsNeedTbs = true;
            this.aiu.uu();
            if (this.aiu.uS().vO().oF()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiu != null) {
                this.aiu.eg();
            }
            a.this.fxq = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.g(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            a.this.fxq = null;
            if (this.aiu == null || bool == null) {
                a.this.mLoadDataCallBack.g(null);
                return;
            }
            b bVar = new b();
            bVar.fxt = this.fxt;
            bVar.mPostId = this.mPostId;
            bVar.cuW = this.cuW;
            bVar.eyv = this.eyv;
            bVar.fxv = this.aiu.getErrorString();
            bVar.mErrCode = this.aiu.uW();
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
        private com.baidu.tbadk.core.util.ab aiu;
        private String eks;
        final /* synthetic */ a fxu;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private String mUserName;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            this.aiu = new com.baidu.tbadk.core.util.ab(strArr[0]);
            this.aiu.n("day", this.eks);
            this.aiu.n("un", this.mUserName);
            this.aiu.n("fid", this.mForumId);
            this.aiu.n("word", this.mForumName);
            this.aiu.n("z", this.mThreadId);
            this.aiu.n("ntn", "banid");
            this.aiu.uS().vN().mIsNeedTbs = true;
            this.aiu.uu();
            if (this.aiu.uS().vO().oF()) {
                return null;
            }
            return this.aiu.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiu != null) {
                this.aiu.eg();
            }
            this.fxu.fxr = null;
            super.cancel(true);
            this.fxu.mLoadDataCallBack.g(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ex */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            this.fxu.fxr = null;
            if (this.aiu == null) {
                this.fxu.mLoadDataCallBack.g(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.ub = true;
            } else {
                dVar.ub = false;
                dVar.fxv = str;
            }
            this.fxu.mLoadDataCallBack.g(dVar);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.fxs != null) {
            this.fxs.cancel();
            this.fxs = null;
        }
        this.mLoadDataMode = i;
        this.fxs = new e(str, str2, str3, i, str4);
        this.fxs.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.fxs.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<String, String, Boolean> {
        private com.baidu.tbadk.core.util.ab aiu = null;
        String evx;
        ArrayList<ab> fxw;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private int mType;

        public e(String str, String str2, String str3, int i, String str4) {
            this.fxw = null;
            this.evx = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.evx = str4;
            this.fxw = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            this.aiu = new com.baidu.tbadk.core.util.ab(strArr[0]);
            this.aiu.n("word", this.mForumName);
            if (this.mType != 6) {
                this.aiu.n("fid", this.mForumId);
                this.aiu.n("z", this.mThreadId);
                if (this.mType == 4) {
                    this.aiu.n("ntn", "set");
                } else if (this.mType == 5) {
                    this.aiu.n("ntn", "");
                } else if (this.mType == 2) {
                    this.aiu.n("ntn", "set");
                    this.aiu.n("cid", this.evx);
                } else {
                    this.aiu.n("ntn", "");
                }
            }
            this.aiu.uS().vN().mIsNeedTbs = true;
            String uu = this.aiu.uu();
            if (this.aiu.uS().vO().oF()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(uu).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            ab abVar = new ab();
                            abVar.parserJson(optJSONArray.optJSONObject(i));
                            this.fxw.add(abVar);
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
            a.this.fxs = null;
            if (this.aiu == null) {
                a.this.mLoadDataCallBack.g(null);
                return;
            }
            f fVar = new f();
            fVar.ub = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    fVar.fxx = this.fxw;
                }
            } else {
                fVar.fxv = this.aiu.getErrorString();
            }
            a.this.mLoadDataCallBack.g(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiu != null) {
                this.aiu.eg();
            }
            a.this.fxs = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.g(null);
        }
    }
}
