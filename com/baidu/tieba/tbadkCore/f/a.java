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
    private C0086a dBs;
    private c dBt;
    private e dBu;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.dBs = null;
        this.dBt = null;
        this.dBu = null;
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.dBs = null;
        this.dBt = null;
        this.dBu = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean At;
        public int dBv;
        public String dBx;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean At;
        public String dBx;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public boolean At;
        public String dBx;
        public ArrayList<m> dBz;

        public f() {
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        aDS();
        return false;
    }

    public void aDS() {
        if (this.dBs != null) {
            this.dBs.cancel();
            this.dBs = null;
        }
        if (this.dBt != null) {
            this.dBt.cancel();
            this.dBt = null;
        }
        if (this.dBu != null) {
            this.dBu.cancel();
            this.dBu = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.dBs != null) {
            this.dBs.cancel();
            this.dBs = null;
        }
        this.mLoadDataMode = 0;
        this.dBs = new C0086a(str, str2, str3, str4, i, i2, z);
        this.dBs.setPriority(2);
        this.dBs.execute(new String[0]);
    }

    public boolean aDT() {
        return (this.dBs == null && this.dBt == null && this.dBu == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0086a extends BdAsyncTask<String, Integer, Boolean> {
        private ab agS = null;
        private boolean bwJ;
        private int cHF;
        private int dBv;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;

        public C0086a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.dBv = i;
            this.cHF = i2;
            this.bwJ = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.dBv == 0) {
                str = String.valueOf(str2) + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = String.valueOf(str2) + TbConfig.DEL_POST_ADDRESS;
            }
            this.agS = new ab(str);
            this.agS.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.agS.o("word", this.mForumName);
            this.agS.o("z", this.mThreadId);
            if (this.dBv == 0) {
                if (this.cHF == 0) {
                    this.agS.o("delete_my_thread", "1");
                }
            } else if (this.dBv == 1) {
                this.agS.o(Info.kBaiduPIDKey, this.mPostId);
                this.agS.o("isfloor", "0");
                this.agS.o("src", "1");
                if (this.cHF == 0 && this.bwJ) {
                    this.agS.o("delete_my_post", "1");
                }
            } else if (this.dBv == 2) {
                this.agS.o(Info.kBaiduPIDKey, this.mPostId);
                this.agS.o("isfloor", "1");
                this.agS.o("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                if (this.cHF == 0 && this.bwJ) {
                    this.agS.o("delete_my_post", "1");
                }
            }
            if (this.cHF == 0 && !this.bwJ) {
                this.agS.o("is_vipdel", "1");
            } else {
                this.agS.o("is_vipdel", "0");
            }
            this.agS.uM().vF().mIsNeedTbs = true;
            this.agS.ul();
            if (this.agS.uM().vG().rf()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.agS != null) {
                this.agS.gL();
            }
            a.this.dBs = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            a.this.dBs = null;
            if (this.agS == null || bool == null) {
                a.this.mLoadDataCallBack.d(null);
                return;
            }
            b bVar = new b();
            bVar.dBv = this.dBv;
            bVar.mPostId = this.mPostId;
            bVar.dBx = this.agS.getErrorString();
            if (bool.booleanValue()) {
                bVar.At = true;
            } else {
                bVar.At = false;
            }
            a.this.mLoadDataCallBack.d(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private ab agS;
        private String cxN;
        final /* synthetic */ a dBw;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private String mUserName;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            this.agS = new ab(strArr[0]);
            this.agS.o("day", this.cxN);
            this.agS.o("un", this.mUserName);
            this.agS.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.agS.o("word", this.mForumName);
            this.agS.o("z", this.mThreadId);
            this.agS.o("ntn", "banid");
            this.agS.uM().vF().mIsNeedTbs = true;
            this.agS.ul();
            if (this.agS.uM().vG().rf()) {
                return null;
            }
            return this.agS.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.agS != null) {
                this.agS.gL();
            }
            this.dBw.dBt = null;
            super.cancel(true);
            this.dBw.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.dBw.dBt = null;
            if (this.agS == null) {
                this.dBw.mLoadDataCallBack.d(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.At = true;
            } else {
                dVar.At = false;
                dVar.dBx = str;
            }
            this.dBw.mLoadDataCallBack.d(dVar);
        }
    }

    public void b(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.dBu != null) {
            this.dBu.cancel();
            this.dBu = null;
        }
        this.mLoadDataMode = i;
        this.dBu = new e(str, str2, str3, i, str4);
        this.dBu.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.dBu.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<String, String, Boolean> {
        private ab agS = null;
        String cFn;
        ArrayList<m> dBy;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private int mType;

        public e(String str, String str2, String str3, int i, String str4) {
            this.dBy = null;
            this.cFn = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.cFn = str4;
            this.dBy = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            this.agS = new ab(strArr[0]);
            this.agS.o("word", this.mForumName);
            if (this.mType != 6) {
                this.agS.o(ImageViewerConfig.FORUM_ID, this.mForumId);
                this.agS.o("z", this.mThreadId);
                if (this.mType == 4) {
                    this.agS.o("ntn", "set");
                } else if (this.mType == 5) {
                    this.agS.o("ntn", "");
                } else if (this.mType == 2) {
                    this.agS.o("ntn", "set");
                    this.agS.o("cid", this.cFn);
                } else {
                    this.agS.o("ntn", "");
                }
            }
            this.agS.uM().vF().mIsNeedTbs = true;
            String ul = this.agS.ul();
            if (this.agS.uM().vG().rf()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(ul).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            m mVar = new m();
                            mVar.parserJson(optJSONArray.optJSONObject(i));
                            this.dBy.add(mVar);
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
            a.this.dBu = null;
            if (this.agS == null) {
                a.this.mLoadDataCallBack.d(null);
                return;
            }
            f fVar = new f();
            fVar.At = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    fVar.dBz = this.dBy;
                }
            } else {
                fVar.dBx = this.agS.getErrorString();
            }
            a.this.mLoadDataCallBack.d(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.agS != null) {
                this.agS.gL();
            }
            a.this.dBu = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.d(null);
        }
    }
}
