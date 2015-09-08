package com.baidu.tieba.tbadkCore.h;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e {
    private C0074a cSR;
    private c cSS;
    private e cST;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cSR = null;
        this.cSS = null;
        this.cST = null;
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.cSR = null;
        this.cSS = null;
        this.cST = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean Am;
        public int cSU;
        public String cSW;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean Am;
        public String cSW;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public boolean Am;
        public String cSW;
        public ArrayList<k> cSY;

        public f() {
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        ava();
        return false;
    }

    public void ava() {
        if (this.cSR != null) {
            this.cSR.cancel();
            this.cSR = null;
        }
        if (this.cSS != null) {
            this.cSS.cancel();
            this.cSS = null;
        }
        if (this.cST != null) {
            this.cST.cancel();
            this.cST = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.cSR != null) {
            this.cSR.cancel();
            this.cSR = null;
        }
        this.mLoadDataMode = 0;
        this.cSR = new C0074a(str, str2, str3, str4, i, i2, z);
        this.cSR.setPriority(2);
        this.cSR.execute(new String[0]);
    }

    public boolean avb() {
        return (this.cSR == null && this.cSS == null && this.cST == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0074a extends BdAsyncTask<String, Integer, Boolean> {
        private v afT = null;
        private boolean bmy;
        private int cSU;
        private int chv;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;

        public C0074a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.cSU = i;
            this.chv = i2;
            this.bmy = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.cSU == 0) {
                str = String.valueOf(str2) + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = String.valueOf(str2) + TbConfig.DEL_POST_ADDRESS;
            }
            this.afT = new v(str);
            this.afT.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.afT.o("word", this.mForumName);
            this.afT.o("z", this.mThreadId);
            if (this.cSU == 0) {
                if (this.chv == 0) {
                    this.afT.o("delete_my_thread", "1");
                }
            } else if (this.cSU == 1) {
                this.afT.o(Info.kBaiduPIDKey, this.mPostId);
                this.afT.o("isfloor", "0");
                this.afT.o("src", "1");
                if (this.chv == 0 && this.bmy) {
                    this.afT.o("delete_my_post", "1");
                }
            } else if (this.cSU == 2) {
                this.afT.o(Info.kBaiduPIDKey, this.mPostId);
                this.afT.o("isfloor", "1");
                this.afT.o("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                if (this.chv == 0 && this.bmy) {
                    this.afT.o("delete_my_post", "1");
                }
            }
            if (this.chv == 0 && !this.bmy) {
                this.afT.o("is_vipdel", "1");
            } else {
                this.afT.o("is_vipdel", "0");
            }
            this.afT.uj().uZ().mIsNeedTbs = true;
            this.afT.tI();
            if (this.afT.uj().va().qZ()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afT != null) {
                this.afT.gJ();
            }
            a.this.cSR = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            a.this.cSR = null;
            if (this.afT == null || bool == null) {
                a.this.mLoadDataCallBack.d(null);
                return;
            }
            b bVar = new b();
            bVar.cSU = this.cSU;
            bVar.mPostId = this.mPostId;
            bVar.cSW = this.afT.getErrorString();
            if (bool.booleanValue()) {
                bVar.Am = true;
            } else {
                bVar.Am = false;
            }
            a.this.mLoadDataCallBack.d(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private v afT;
        private String aju;
        private String bZt;
        final /* synthetic */ a cSV;
        private String mForumId;
        private String mForumName;
        private String mThreadId;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            this.afT = new v(strArr[0]);
            this.afT.o("day", this.bZt);
            this.afT.o("un", this.aju);
            this.afT.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.afT.o("word", this.mForumName);
            this.afT.o("z", this.mThreadId);
            this.afT.o("ntn", "banid");
            this.afT.uj().uZ().mIsNeedTbs = true;
            this.afT.tI();
            if (this.afT.uj().va().qZ()) {
                return null;
            }
            return this.afT.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afT != null) {
                this.afT.gJ();
            }
            this.cSV.cSS = null;
            super.cancel(true);
            this.cSV.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.cSV.cSS = null;
            if (this.afT == null) {
                this.cSV.mLoadDataCallBack.d(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.Am = true;
            } else {
                dVar.Am = false;
                dVar.cSW = str;
            }
            this.cSV.mLoadDataCallBack.d(dVar);
        }
    }

    public void b(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.cST != null) {
            this.cST.cancel();
            this.cST = null;
        }
        this.mLoadDataMode = i;
        this.cST = new e(str, str2, str3, i, str4);
        this.cST.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.cST.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<String, String, Boolean> {
        private v afT = null;
        ArrayList<k> cSX;
        String cfE;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private int mType;

        public e(String str, String str2, String str3, int i, String str4) {
            this.cSX = null;
            this.cfE = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.cfE = str4;
            this.cSX = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            this.afT = new v(strArr[0]);
            this.afT.o("word", this.mForumName);
            if (this.mType != 6) {
                this.afT.o(ImageViewerConfig.FORUM_ID, this.mForumId);
                this.afT.o("z", this.mThreadId);
                if (this.mType == 4) {
                    this.afT.o("ntn", "set");
                } else if (this.mType == 5) {
                    this.afT.o("ntn", "");
                } else if (this.mType == 2) {
                    this.afT.o("ntn", "set");
                    this.afT.o("cid", this.cfE);
                } else {
                    this.afT.o("ntn", "");
                }
            }
            this.afT.uj().uZ().mIsNeedTbs = true;
            String tI = this.afT.tI();
            if (this.afT.uj().va().qZ()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(tI).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            k kVar = new k();
                            kVar.parserJson(optJSONArray.optJSONObject(i));
                            this.cSX.add(kVar);
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
            a.this.cST = null;
            if (this.afT == null) {
                a.this.mLoadDataCallBack.d(null);
                return;
            }
            f fVar = new f();
            fVar.Am = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    fVar.cSY = this.cSX;
                }
            } else {
                fVar.cSW = this.afT.getErrorString();
            }
            a.this.mLoadDataCallBack.d(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afT != null) {
                this.afT.gJ();
            }
            a.this.cST = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.d(null);
        }
    }
}
