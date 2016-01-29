package com.baidu.tieba.tbadkCore.f;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.p;
import com.baidu.tbadk.core.util.aa;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e {
    private C0086a dYV;
    private c dYW;
    private e dYX;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.dYV = null;
        this.dYW = null;
        this.dYX = null;
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.dYV = null;
        this.dYW = null;
        this.dYX = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean AD;
        public int dYY;
        public String dZa;
        public int mErrCode;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean AD;
        public String dZa;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public boolean AD;
        public String dZa;
        public ArrayList<p> dZc;

        public f() {
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        aNk();
        return false;
    }

    public void aNk() {
        if (this.dYV != null) {
            this.dYV.cancel();
            this.dYV = null;
        }
        if (this.dYW != null) {
            this.dYW.cancel();
            this.dYW = null;
        }
        if (this.dYX != null) {
            this.dYX.cancel();
            this.dYX = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.dYV != null) {
            this.dYV.cancel();
            this.dYV = null;
        }
        this.mLoadDataMode = 0;
        this.dYV = new C0086a(str, str2, str3, str4, i, i2, z);
        this.dYV.setPriority(2);
        this.dYV.execute(new String[0]);
    }

    public boolean aNl() {
        return (this.dYV == null && this.dYW == null && this.dYX == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0086a extends BdAsyncTask<String, Integer, Boolean> {
        private aa aiG = null;
        private boolean bDM;
        private int cUq;
        private int dYY;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;

        public C0086a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.dYY = i;
            this.cUq = i2;
            this.bDM = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.dYY == 0) {
                str = String.valueOf(str2) + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = String.valueOf(str2) + TbConfig.DEL_POST_ADDRESS;
            }
            this.aiG = new aa(str);
            this.aiG.p(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.aiG.p("word", this.mForumName);
            this.aiG.p("z", this.mThreadId);
            if (this.dYY == 0) {
                if (this.cUq == 0) {
                    this.aiG.p("delete_my_thread", "1");
                }
            } else if (this.dYY == 1) {
                this.aiG.p(Info.kBaiduPIDKey, this.mPostId);
                this.aiG.p("isfloor", "0");
                this.aiG.p("src", "1");
                if (this.cUq == 0 && this.bDM) {
                    this.aiG.p("delete_my_post", "1");
                }
            } else if (this.dYY == 2) {
                this.aiG.p(Info.kBaiduPIDKey, this.mPostId);
                this.aiG.p("isfloor", "1");
                this.aiG.p("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                if (this.cUq == 0 && this.bDM) {
                    this.aiG.p("delete_my_post", "1");
                }
            }
            if (this.cUq == 0 && !this.bDM) {
                this.aiG.p("is_vipdel", "1");
            } else {
                this.aiG.p("is_vipdel", "0");
            }
            this.aiG.vB().wv().mIsNeedTbs = true;
            this.aiG.uZ();
            if (this.aiG.vB().ww().rl()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiG != null) {
                this.aiG.gT();
            }
            a.this.dYV = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            a.this.dYV = null;
            if (this.aiG == null || bool == null) {
                a.this.mLoadDataCallBack.d(null);
                return;
            }
            b bVar = new b();
            bVar.dYY = this.dYY;
            bVar.mPostId = this.mPostId;
            bVar.dZa = this.aiG.getErrorString();
            bVar.mErrCode = this.aiG.vF();
            if (bool.booleanValue()) {
                bVar.AD = true;
            } else {
                bVar.AD = false;
            }
            a.this.mLoadDataCallBack.d(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private aa aiG;
        private String cIa;
        final /* synthetic */ a dYZ;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private String mUserName;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public String doInBackground(String... strArr) {
            this.aiG = new aa(strArr[0]);
            this.aiG.p("day", this.cIa);
            this.aiG.p("un", this.mUserName);
            this.aiG.p(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.aiG.p("word", this.mForumName);
            this.aiG.p("z", this.mThreadId);
            this.aiG.p("ntn", "banid");
            this.aiG.vB().wv().mIsNeedTbs = true;
            this.aiG.uZ();
            if (this.aiG.vB().ww().rl()) {
                return null;
            }
            return this.aiG.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiG != null) {
                this.aiG.gT();
            }
            this.dYZ.dYW = null;
            super.cancel(true);
            this.dYZ.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ek */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            this.dYZ.dYW = null;
            if (this.aiG == null) {
                this.dYZ.mLoadDataCallBack.d(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.AD = true;
            } else {
                dVar.AD = false;
                dVar.dZa = str;
            }
            this.dYZ.mLoadDataCallBack.d(dVar);
        }
    }

    public void b(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.dYX != null) {
            this.dYX.cancel();
            this.dYX = null;
        }
        this.mLoadDataMode = i;
        this.dYX = new e(str, str2, str3, i, str4);
        this.dYX.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.dYX.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<String, String, Boolean> {
        private aa aiG = null;
        String cRr;
        ArrayList<p> dZb;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private int mType;

        public e(String str, String str2, String str3, int i, String str4) {
            this.dZb = null;
            this.cRr = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.cRr = str4;
            this.dZb = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public Boolean doInBackground(String... strArr) {
            this.aiG = new aa(strArr[0]);
            this.aiG.p("word", this.mForumName);
            if (this.mType != 6) {
                this.aiG.p(ImageViewerConfig.FORUM_ID, this.mForumId);
                this.aiG.p("z", this.mThreadId);
                if (this.mType == 4) {
                    this.aiG.p("ntn", "set");
                } else if (this.mType == 5) {
                    this.aiG.p("ntn", "");
                } else if (this.mType == 2) {
                    this.aiG.p("ntn", "set");
                    this.aiG.p("cid", this.cRr);
                } else {
                    this.aiG.p("ntn", "");
                }
            }
            this.aiG.vB().wv().mIsNeedTbs = true;
            String uZ = this.aiG.uZ();
            if (this.aiG.vB().ww().rl()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(uZ).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            p pVar = new p();
                            pVar.parserJson(optJSONArray.optJSONObject(i));
                            this.dZb.add(pVar);
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
            a.this.dYX = null;
            if (this.aiG == null) {
                a.this.mLoadDataCallBack.d(null);
                return;
            }
            f fVar = new f();
            fVar.AD = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    fVar.dZc = this.dZb;
                }
            } else {
                fVar.dZa = this.aiG.getErrorString();
            }
            a.this.mLoadDataCallBack.d(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiG != null) {
                this.aiG.gT();
            }
            a.this.dYX = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.d(null);
        }
    }
}
