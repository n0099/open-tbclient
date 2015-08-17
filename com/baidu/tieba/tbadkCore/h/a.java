package com.baidu.tieba.tbadkCore.h;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e {
    private C0072a cKr;
    private c cKs;
    private e cKt;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cKr = null;
        this.cKs = null;
        this.cKt = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean Ao;
        public int cKu;
        public String cKw;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean Ao;
        public String cKw;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public boolean Ao;
        public String cKw;
        public ArrayList<k> cKy;

        public f() {
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        aqM();
        return false;
    }

    public void aqM() {
        if (this.cKr != null) {
            this.cKr.cancel();
            this.cKr = null;
        }
        if (this.cKs != null) {
            this.cKs.cancel();
            this.cKs = null;
        }
        if (this.cKt != null) {
            this.cKt.cancel();
            this.cKt = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.cKr != null) {
            this.cKr.cancel();
            this.cKr = null;
        }
        this.mLoadDataMode = 0;
        this.cKr = new C0072a(str, str2, str3, str4, i, i2, z);
        this.cKr.setPriority(2);
        this.cKr.execute(new String[0]);
    }

    public boolean aqN() {
        return (this.cKr == null && this.cKs == null && this.cKt == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0072a extends BdAsyncTask<String, Integer, Boolean> {
        private v afJ = null;
        private boolean bmc;
        private int cKu;
        private int cgy;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;

        public C0072a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.cKu = i;
            this.cgy = i2;
            this.bmc = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.cKu == 0) {
                str = String.valueOf(str2) + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = String.valueOf(str2) + TbConfig.DEL_POST_ADDRESS;
            }
            this.afJ = new v(str);
            this.afJ.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.afJ.o("word", this.mForumName);
            this.afJ.o("z", this.mThreadId);
            if (this.cKu == 0) {
                if (this.cgy == 0) {
                    this.afJ.o("delete_my_thread", "1");
                }
            } else if (this.cKu == 1) {
                this.afJ.o(Info.kBaiduPIDKey, this.mPostId);
                this.afJ.o("isfloor", "0");
                this.afJ.o("src", "1");
                if (this.cgy == 0 && this.bmc) {
                    this.afJ.o("delete_my_post", "1");
                }
            } else if (this.cKu == 2) {
                this.afJ.o(Info.kBaiduPIDKey, this.mPostId);
                this.afJ.o("isfloor", "1");
                this.afJ.o("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                if (this.cgy == 0 && this.bmc) {
                    this.afJ.o("delete_my_post", "1");
                }
            }
            if (this.cgy == 0 && !this.bmc) {
                this.afJ.o("is_vipdel", "1");
            } else {
                this.afJ.o("is_vipdel", "0");
            }
            this.afJ.ue().uV().mIsNeedTbs = true;
            this.afJ.tD();
            if (this.afJ.ue().uW().rb()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afJ != null) {
                this.afJ.gM();
            }
            a.this.cKr = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            a.this.cKr = null;
            if (this.afJ == null || bool == null) {
                a.this.mLoadDataCallBack.d(null);
                return;
            }
            b bVar = new b();
            bVar.cKu = this.cKu;
            bVar.mPostId = this.mPostId;
            bVar.cKw = this.afJ.getErrorString();
            if (bool.booleanValue()) {
                bVar.Ao = true;
            } else {
                bVar.Ao = false;
            }
            a.this.mLoadDataCallBack.d(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private v afJ;
        private String ajl;
        private String bYz;
        final /* synthetic */ a cKv;
        private String mForumId;
        private String mForumName;
        private String mThreadId;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            this.afJ = new v(strArr[0]);
            this.afJ.o("day", this.bYz);
            this.afJ.o("un", this.ajl);
            this.afJ.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.afJ.o("word", this.mForumName);
            this.afJ.o("z", this.mThreadId);
            this.afJ.o("ntn", "banid");
            this.afJ.ue().uV().mIsNeedTbs = true;
            this.afJ.tD();
            if (this.afJ.ue().uW().rb()) {
                return null;
            }
            return this.afJ.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afJ != null) {
                this.afJ.gM();
            }
            this.cKv.cKs = null;
            super.cancel(true);
            this.cKv.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.cKv.cKs = null;
            if (this.afJ == null) {
                this.cKv.mLoadDataCallBack.d(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.Ao = true;
            } else {
                dVar.Ao = false;
                dVar.cKw = str;
            }
            this.cKv.mLoadDataCallBack.d(dVar);
        }
    }

    public void b(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.cKt != null) {
            this.cKt.cancel();
            this.cKt = null;
        }
        this.mLoadDataMode = i;
        this.cKt = new e(str, str2, str3, i, str4);
        this.cKt.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.cKt.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<String, String, Boolean> {
        private v afJ = null;
        ArrayList<k> cKx;
        String ceH;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private int mType;

        public e(String str, String str2, String str3, int i, String str4) {
            this.cKx = null;
            this.ceH = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.ceH = str4;
            this.cKx = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public Boolean doInBackground(String... strArr) {
            this.afJ = new v(strArr[0]);
            this.afJ.o("word", this.mForumName);
            if (this.mType != 6) {
                this.afJ.o(ImageViewerConfig.FORUM_ID, this.mForumId);
                this.afJ.o("z", this.mThreadId);
                if (this.mType == 4) {
                    this.afJ.o("ntn", "set");
                } else if (this.mType == 5) {
                    this.afJ.o("ntn", "");
                } else if (this.mType == 2) {
                    this.afJ.o("ntn", "set");
                    this.afJ.o("cid", this.ceH);
                } else {
                    this.afJ.o("ntn", "");
                }
            }
            this.afJ.ue().uV().mIsNeedTbs = true;
            String tD = this.afJ.tD();
            if (this.afJ.ue().uW().rb()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(tD).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            k kVar = new k();
                            kVar.parserJson(optJSONArray.optJSONObject(i));
                            this.cKx.add(kVar);
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
            a.this.cKt = null;
            if (this.afJ == null) {
                a.this.mLoadDataCallBack.d(null);
                return;
            }
            f fVar = new f();
            fVar.Ao = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    fVar.cKy = this.cKx;
                }
            } else {
                fVar.cKw = this.afJ.getErrorString();
            }
            a.this.mLoadDataCallBack.d(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afJ != null) {
                this.afJ.gM();
            }
            a.this.cKt = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.d(null);
        }
    }
}
