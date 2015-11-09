package com.baidu.tieba.tbadkCore.h;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e {
    private C0077a ddh;
    private c ddi;
    private e ddj;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.ddh = null;
        this.ddi = null;
        this.ddj = null;
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.ddh = null;
        this.ddi = null;
        this.ddj = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean An;
        public int ddk;
        public String ddm;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean An;
        public String ddm;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public boolean An;
        public String ddm;
        public ArrayList<k> ddo;

        public f() {
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        ayA();
        return false;
    }

    public void ayA() {
        if (this.ddh != null) {
            this.ddh.cancel();
            this.ddh = null;
        }
        if (this.ddi != null) {
            this.ddi.cancel();
            this.ddi = null;
        }
        if (this.ddj != null) {
            this.ddj.cancel();
            this.ddj = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.ddh != null) {
            this.ddh.cancel();
            this.ddh = null;
        }
        this.mLoadDataMode = 0;
        this.ddh = new C0077a(str, str2, str3, str4, i, i2, z);
        this.ddh.setPriority(2);
        this.ddh.execute(new String[0]);
    }

    public boolean ayB() {
        return (this.ddh == null && this.ddi == null && this.ddj == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0077a extends BdAsyncTask<String, Integer, Boolean> {
        private w afm = null;
        private boolean bnO;
        private int cot;
        private int ddk;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;

        public C0077a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.ddk = i;
            this.cot = i2;
            this.bnO = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.ddk == 0) {
                str = String.valueOf(str2) + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = String.valueOf(str2) + TbConfig.DEL_POST_ADDRESS;
            }
            this.afm = new w(str);
            this.afm.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.afm.o("word", this.mForumName);
            this.afm.o("z", this.mThreadId);
            if (this.ddk == 0) {
                if (this.cot == 0) {
                    this.afm.o("delete_my_thread", "1");
                }
            } else if (this.ddk == 1) {
                this.afm.o(Info.kBaiduPIDKey, this.mPostId);
                this.afm.o("isfloor", "0");
                this.afm.o("src", "1");
                if (this.cot == 0 && this.bnO) {
                    this.afm.o("delete_my_post", "1");
                }
            } else if (this.ddk == 2) {
                this.afm.o(Info.kBaiduPIDKey, this.mPostId);
                this.afm.o("isfloor", "1");
                this.afm.o("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                if (this.cot == 0 && this.bnO) {
                    this.afm.o("delete_my_post", "1");
                }
            }
            if (this.cot == 0 && !this.bnO) {
                this.afm.o("is_vipdel", "1");
            } else {
                this.afm.o("is_vipdel", "0");
            }
            this.afm.uh().uZ().mIsNeedTbs = true;
            this.afm.tG();
            if (this.afm.uh().va().qT()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afm != null) {
                this.afm.gJ();
            }
            a.this.ddh = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            a.this.ddh = null;
            if (this.afm == null || bool == null) {
                a.this.mLoadDataCallBack.d(null);
                return;
            }
            b bVar = new b();
            bVar.ddk = this.ddk;
            bVar.mPostId = this.mPostId;
            bVar.ddm = this.afm.getErrorString();
            if (bool.booleanValue()) {
                bVar.An = true;
            } else {
                bVar.An = false;
            }
            a.this.mLoadDataCallBack.d(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private w afm;
        private String cfn;
        final /* synthetic */ a ddl;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private String mUserName;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            this.afm = new w(strArr[0]);
            this.afm.o("day", this.cfn);
            this.afm.o("un", this.mUserName);
            this.afm.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.afm.o("word", this.mForumName);
            this.afm.o("z", this.mThreadId);
            this.afm.o("ntn", "banid");
            this.afm.uh().uZ().mIsNeedTbs = true;
            this.afm.tG();
            if (this.afm.uh().va().qT()) {
                return null;
            }
            return this.afm.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afm != null) {
                this.afm.gJ();
            }
            this.ddl.ddi = null;
            super.cancel(true);
            this.ddl.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.ddl.ddi = null;
            if (this.afm == null) {
                this.ddl.mLoadDataCallBack.d(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.An = true;
            } else {
                dVar.An = false;
                dVar.ddm = str;
            }
            this.ddl.mLoadDataCallBack.d(dVar);
        }
    }

    public void b(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.ddj != null) {
            this.ddj.cancel();
            this.ddj = null;
        }
        this.mLoadDataMode = i;
        this.ddj = new e(str, str2, str3, i, str4);
        this.ddj.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.ddj.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<String, String, Boolean> {
        private w afm = null;
        String cmw;
        ArrayList<k> ddn;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private int mType;

        public e(String str, String str2, String str3, int i, String str4) {
            this.ddn = null;
            this.cmw = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.cmw = str4;
            this.ddn = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            this.afm = new w(strArr[0]);
            this.afm.o("word", this.mForumName);
            if (this.mType != 6) {
                this.afm.o(ImageViewerConfig.FORUM_ID, this.mForumId);
                this.afm.o("z", this.mThreadId);
                if (this.mType == 4) {
                    this.afm.o("ntn", "set");
                } else if (this.mType == 5) {
                    this.afm.o("ntn", "");
                } else if (this.mType == 2) {
                    this.afm.o("ntn", "set");
                    this.afm.o("cid", this.cmw);
                } else {
                    this.afm.o("ntn", "");
                }
            }
            this.afm.uh().uZ().mIsNeedTbs = true;
            String tG = this.afm.tG();
            if (this.afm.uh().va().qT()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(tG).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            k kVar = new k();
                            kVar.parserJson(optJSONArray.optJSONObject(i));
                            this.ddn.add(kVar);
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
            a.this.ddj = null;
            if (this.afm == null) {
                a.this.mLoadDataCallBack.d(null);
                return;
            }
            f fVar = new f();
            fVar.An = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    fVar.ddo = this.ddn;
                }
            } else {
                fVar.ddm = this.afm.getErrorString();
            }
            a.this.mLoadDataCallBack.d(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afm != null) {
                this.afm.gJ();
            }
            a.this.ddj = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.d(null);
        }
    }
}
