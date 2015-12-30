package com.baidu.tieba.tbadkCore.f;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.util.ab;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e {
    private C0082a dIV;
    private c dIW;
    private e dIX;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.dIV = null;
        this.dIW = null;
        this.dIX = null;
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.dIV = null;
        this.dIW = null;
        this.dIX = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean Av;
        public int dIY;
        public String dJa;
        public int mErrCode;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean Av;
        public String dJa;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public boolean Av;
        public String dJa;
        public ArrayList<m> dJc;

        public f() {
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        aGf();
        return false;
    }

    public void aGf() {
        if (this.dIV != null) {
            this.dIV.cancel();
            this.dIV = null;
        }
        if (this.dIW != null) {
            this.dIW.cancel();
            this.dIW = null;
        }
        if (this.dIX != null) {
            this.dIX.cancel();
            this.dIX = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.dIV != null) {
            this.dIV.cancel();
            this.dIV = null;
        }
        this.mLoadDataMode = 0;
        this.dIV = new C0082a(str, str2, str3, str4, i, i2, z);
        this.dIV.setPriority(2);
        this.dIV.execute(new String[0]);
    }

    public boolean aGg() {
        return (this.dIV == null && this.dIW == null && this.dIX == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0082a extends BdAsyncTask<String, Integer, Boolean> {
        private ab ahV = null;
        private boolean bAA;
        private int cLH;
        private int dIY;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;

        public C0082a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.dIY = i;
            this.cLH = i2;
            this.bAA = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.dIY == 0) {
                str = String.valueOf(str2) + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = String.valueOf(str2) + TbConfig.DEL_POST_ADDRESS;
            }
            this.ahV = new ab(str);
            this.ahV.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.ahV.o("word", this.mForumName);
            this.ahV.o("z", this.mThreadId);
            if (this.dIY == 0) {
                if (this.cLH == 0) {
                    this.ahV.o("delete_my_thread", "1");
                }
            } else if (this.dIY == 1) {
                this.ahV.o(Info.kBaiduPIDKey, this.mPostId);
                this.ahV.o("isfloor", "0");
                this.ahV.o("src", "1");
                if (this.cLH == 0 && this.bAA) {
                    this.ahV.o("delete_my_post", "1");
                }
            } else if (this.dIY == 2) {
                this.ahV.o(Info.kBaiduPIDKey, this.mPostId);
                this.ahV.o("isfloor", "1");
                this.ahV.o("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                if (this.cLH == 0 && this.bAA) {
                    this.ahV.o("delete_my_post", "1");
                }
            }
            if (this.cLH == 0 && !this.bAA) {
                this.ahV.o("is_vipdel", "1");
            } else {
                this.ahV.o("is_vipdel", "0");
            }
            this.ahV.uw().vp().mIsNeedTbs = true;
            this.ahV.tV();
            if (this.ahV.uw().vq().qO()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.ahV != null) {
                this.ahV.gL();
            }
            a.this.dIV = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            a.this.dIV = null;
            if (this.ahV == null || bool == null) {
                a.this.mLoadDataCallBack.d(null);
                return;
            }
            b bVar = new b();
            bVar.dIY = this.dIY;
            bVar.mPostId = this.mPostId;
            bVar.dJa = this.ahV.getErrorString();
            bVar.mErrCode = this.ahV.uA();
            if (bool.booleanValue()) {
                bVar.Av = true;
            } else {
                bVar.Av = false;
            }
            a.this.mLoadDataCallBack.d(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private ab ahV;
        private String cBu;
        final /* synthetic */ a dIZ;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private String mUserName;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            this.ahV = new ab(strArr[0]);
            this.ahV.o("day", this.cBu);
            this.ahV.o("un", this.mUserName);
            this.ahV.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.ahV.o("word", this.mForumName);
            this.ahV.o("z", this.mThreadId);
            this.ahV.o("ntn", "banid");
            this.ahV.uw().vp().mIsNeedTbs = true;
            this.ahV.tV();
            if (this.ahV.uw().vq().qO()) {
                return null;
            }
            return this.ahV.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.ahV != null) {
                this.ahV.gL();
            }
            this.dIZ.dIW = null;
            super.cancel(true);
            this.dIZ.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.dIZ.dIW = null;
            if (this.ahV == null) {
                this.dIZ.mLoadDataCallBack.d(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.Av = true;
            } else {
                dVar.Av = false;
                dVar.dJa = str;
            }
            this.dIZ.mLoadDataCallBack.d(dVar);
        }
    }

    public void b(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.dIX != null) {
            this.dIX.cancel();
            this.dIX = null;
        }
        this.mLoadDataMode = i;
        this.dIX = new e(str, str2, str3, i, str4);
        this.dIX.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.dIX.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<String, String, Boolean> {
        private ab ahV = null;
        String cJm;
        ArrayList<m> dJb;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private int mType;

        public e(String str, String str2, String str3, int i, String str4) {
            this.dJb = null;
            this.cJm = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.cJm = str4;
            this.dJb = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            this.ahV = new ab(strArr[0]);
            this.ahV.o("word", this.mForumName);
            if (this.mType != 6) {
                this.ahV.o(ImageViewerConfig.FORUM_ID, this.mForumId);
                this.ahV.o("z", this.mThreadId);
                if (this.mType == 4) {
                    this.ahV.o("ntn", "set");
                } else if (this.mType == 5) {
                    this.ahV.o("ntn", "");
                } else if (this.mType == 2) {
                    this.ahV.o("ntn", "set");
                    this.ahV.o("cid", this.cJm);
                } else {
                    this.ahV.o("ntn", "");
                }
            }
            this.ahV.uw().vp().mIsNeedTbs = true;
            String tV = this.ahV.tV();
            if (this.ahV.uw().vq().qO()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(tV).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            m mVar = new m();
                            mVar.parserJson(optJSONArray.optJSONObject(i));
                            this.dJb.add(mVar);
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
            a.this.dIX = null;
            if (this.ahV == null) {
                a.this.mLoadDataCallBack.d(null);
                return;
            }
            f fVar = new f();
            fVar.Av = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    fVar.dJc = this.dJb;
                }
            } else {
                fVar.dJa = this.ahV.getErrorString();
            }
            a.this.mLoadDataCallBack.d(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.ahV != null) {
                this.ahV.gL();
            }
            a.this.dIX = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.d(null);
        }
    }
}
