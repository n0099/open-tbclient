package com.baidu.tieba.tbadkCore.g;

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
    private C0077a daW;
    private c daX;
    private e daY;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.daW = null;
        this.daX = null;
        this.daY = null;
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.daW = null;
        this.daX = null;
        this.daY = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean An;
        public int daZ;
        public String dbb;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean An;
        public String dbb;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public boolean An;
        public String dbb;
        public ArrayList<k> dbd;

        public f() {
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        axv();
        return false;
    }

    public void axv() {
        if (this.daW != null) {
            this.daW.cancel();
            this.daW = null;
        }
        if (this.daX != null) {
            this.daX.cancel();
            this.daX = null;
        }
        if (this.daY != null) {
            this.daY.cancel();
            this.daY = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.daW != null) {
            this.daW.cancel();
            this.daW = null;
        }
        this.mLoadDataMode = 0;
        this.daW = new C0077a(str, str2, str3, str4, i, i2, z);
        this.daW.setPriority(2);
        this.daW.execute(new String[0]);
    }

    public boolean axw() {
        return (this.daW == null && this.daX == null && this.daY == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0077a extends BdAsyncTask<String, Integer, Boolean> {
        private w afh = null;
        private boolean bnk;
        private int cnc;
        private int daZ;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;

        public C0077a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.daZ = i;
            this.cnc = i2;
            this.bnk = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.daZ == 0) {
                str = String.valueOf(str2) + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = String.valueOf(str2) + TbConfig.DEL_POST_ADDRESS;
            }
            this.afh = new w(str);
            this.afh.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.afh.o("word", this.mForumName);
            this.afh.o("z", this.mThreadId);
            if (this.daZ == 0) {
                if (this.cnc == 0) {
                    this.afh.o("delete_my_thread", "1");
                }
            } else if (this.daZ == 1) {
                this.afh.o(Info.kBaiduPIDKey, this.mPostId);
                this.afh.o("isfloor", "0");
                this.afh.o("src", "1");
                if (this.cnc == 0 && this.bnk) {
                    this.afh.o("delete_my_post", "1");
                }
            } else if (this.daZ == 2) {
                this.afh.o(Info.kBaiduPIDKey, this.mPostId);
                this.afh.o("isfloor", "1");
                this.afh.o("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                if (this.cnc == 0 && this.bnk) {
                    this.afh.o("delete_my_post", "1");
                }
            }
            if (this.cnc == 0 && !this.bnk) {
                this.afh.o("is_vipdel", "1");
            } else {
                this.afh.o("is_vipdel", "0");
            }
            this.afh.uh().uY().mIsNeedTbs = true;
            this.afh.tG();
            if (this.afh.uh().uZ().qV()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afh != null) {
                this.afh.gJ();
            }
            a.this.daW = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            a.this.daW = null;
            if (this.afh == null || bool == null) {
                a.this.mLoadDataCallBack.d(null);
                return;
            }
            b bVar = new b();
            bVar.daZ = this.daZ;
            bVar.mPostId = this.mPostId;
            bVar.dbb = this.afh.getErrorString();
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
        private w afh;
        private String air;
        private String ceM;
        final /* synthetic */ a dba;
        private String mForumId;
        private String mForumName;
        private String mThreadId;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            this.afh = new w(strArr[0]);
            this.afh.o("day", this.ceM);
            this.afh.o("un", this.air);
            this.afh.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.afh.o("word", this.mForumName);
            this.afh.o("z", this.mThreadId);
            this.afh.o("ntn", "banid");
            this.afh.uh().uY().mIsNeedTbs = true;
            this.afh.tG();
            if (this.afh.uh().uZ().qV()) {
                return null;
            }
            return this.afh.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afh != null) {
                this.afh.gJ();
            }
            this.dba.daX = null;
            super.cancel(true);
            this.dba.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.dba.daX = null;
            if (this.afh == null) {
                this.dba.mLoadDataCallBack.d(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.An = true;
            } else {
                dVar.An = false;
                dVar.dbb = str;
            }
            this.dba.mLoadDataCallBack.d(dVar);
        }
    }

    public void b(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.daY != null) {
            this.daY.cancel();
            this.daY = null;
        }
        this.mLoadDataMode = i;
        this.daY = new e(str, str2, str3, i, str4);
        this.daY.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.daY.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<String, String, Boolean> {
        private w afh = null;
        String cli;
        ArrayList<k> dbc;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private int mType;

        public e(String str, String str2, String str3, int i, String str4) {
            this.dbc = null;
            this.cli = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.cli = str4;
            this.dbc = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            this.afh = new w(strArr[0]);
            this.afh.o("word", this.mForumName);
            if (this.mType != 6) {
                this.afh.o(ImageViewerConfig.FORUM_ID, this.mForumId);
                this.afh.o("z", this.mThreadId);
                if (this.mType == 4) {
                    this.afh.o("ntn", "set");
                } else if (this.mType == 5) {
                    this.afh.o("ntn", "");
                } else if (this.mType == 2) {
                    this.afh.o("ntn", "set");
                    this.afh.o("cid", this.cli);
                } else {
                    this.afh.o("ntn", "");
                }
            }
            this.afh.uh().uY().mIsNeedTbs = true;
            String tG = this.afh.tG();
            if (this.afh.uh().uZ().qV()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(tG).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            k kVar = new k();
                            kVar.parserJson(optJSONArray.optJSONObject(i));
                            this.dbc.add(kVar);
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
            a.this.daY = null;
            if (this.afh == null) {
                a.this.mLoadDataCallBack.d(null);
                return;
            }
            f fVar = new f();
            fVar.An = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    fVar.dbd = this.dbc;
                }
            } else {
                fVar.dbb = this.afh.getErrorString();
            }
            a.this.mLoadDataCallBack.d(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afh != null) {
                this.afh.gJ();
            }
            a.this.daY = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.d(null);
        }
    }
}
