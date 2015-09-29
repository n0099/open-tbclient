package com.baidu.tieba.tbadkCore.g;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.j;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e {
    private C0077a dav;
    private c daw;
    private e dax;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.dav = null;
        this.daw = null;
        this.dax = null;
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.dav = null;
        this.daw = null;
        this.dax = null;
    }

    /* loaded from: classes.dex */
    public class b {
        public boolean An;
        public String daB;
        public int daz;
        public String mPostId;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public boolean An;
        public String daB;

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public boolean An;
        public String daB;
        public ArrayList<j> daD;

        public f() {
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        axl();
        return false;
    }

    public void axl() {
        if (this.dav != null) {
            this.dav.cancel();
            this.dav = null;
        }
        if (this.daw != null) {
            this.daw.cancel();
            this.daw = null;
        }
        if (this.dax != null) {
            this.dax.cancel();
            this.dax = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.dav != null) {
            this.dav.cancel();
            this.dav = null;
        }
        this.mLoadDataMode = 0;
        this.dav = new C0077a(str, str2, str3, str4, i, i2, z);
        this.dav.setPriority(2);
        this.dav.execute(new String[0]);
    }

    public boolean axm() {
        return (this.dav == null && this.daw == null && this.dax == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0077a extends BdAsyncTask<String, Integer, Boolean> {
        private w afg = null;
        private boolean bmZ;
        private int cmR;
        private int daz;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;

        public C0077a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mPostId = str4;
            this.daz = i;
            this.cmR = i2;
            this.bmZ = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            String str;
            String str2 = TbConfig.SERVER_ADDRESS;
            if (this.daz == 0) {
                str = String.valueOf(str2) + TbConfig.DEL_THREAD_ADDRESS;
            } else {
                str = String.valueOf(str2) + TbConfig.DEL_POST_ADDRESS;
            }
            this.afg = new w(str);
            this.afg.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.afg.o("word", this.mForumName);
            this.afg.o("z", this.mThreadId);
            if (this.daz == 0) {
                if (this.cmR == 0) {
                    this.afg.o("delete_my_thread", "1");
                }
            } else if (this.daz == 1) {
                this.afg.o(Info.kBaiduPIDKey, this.mPostId);
                this.afg.o("isfloor", "0");
                this.afg.o("src", "1");
                if (this.cmR == 0 && this.bmZ) {
                    this.afg.o("delete_my_post", "1");
                }
            } else if (this.daz == 2) {
                this.afg.o(Info.kBaiduPIDKey, this.mPostId);
                this.afg.o("isfloor", "1");
                this.afg.o("src", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                if (this.cmR == 0 && this.bmZ) {
                    this.afg.o("delete_my_post", "1");
                }
            }
            if (this.cmR == 0 && !this.bmZ) {
                this.afg.o("is_vipdel", "1");
            } else {
                this.afg.o("is_vipdel", "0");
            }
            this.afg.uh().uX().mIsNeedTbs = true;
            this.afg.tG();
            if (this.afg.uh().uY().qV()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afg != null) {
                this.afg.gJ();
            }
            a.this.dav = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            a.this.dav = null;
            if (this.afg == null || bool == null) {
                a.this.mLoadDataCallBack.d(null);
                return;
            }
            b bVar = new b();
            bVar.daz = this.daz;
            bVar.mPostId = this.mPostId;
            bVar.daB = this.afg.getErrorString();
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
        private w afg;
        private String aiq;
        private String ceB;
        final /* synthetic */ a daA;
        private String mForumId;
        private String mForumName;
        private String mThreadId;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            this.afg = new w(strArr[0]);
            this.afg.o("day", this.ceB);
            this.afg.o("un", this.aiq);
            this.afg.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.afg.o("word", this.mForumName);
            this.afg.o("z", this.mThreadId);
            this.afg.o("ntn", "banid");
            this.afg.uh().uX().mIsNeedTbs = true;
            this.afg.tG();
            if (this.afg.uh().uY().qV()) {
                return null;
            }
            return this.afg.getErrorString();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afg != null) {
                this.afg.gJ();
            }
            this.daA.daw = null;
            super.cancel(true);
            this.daA.mLoadDataCallBack.d(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            this.daA.daw = null;
            if (this.afg == null) {
                this.daA.mLoadDataCallBack.d(null);
                return;
            }
            d dVar = new d();
            if (str == null) {
                dVar.An = true;
            } else {
                dVar.An = false;
                dVar.daB = str;
            }
            this.daA.mLoadDataCallBack.d(dVar);
        }
    }

    public void b(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.dax != null) {
            this.dax.cancel();
            this.dax = null;
        }
        this.mLoadDataMode = i;
        this.dax = new e(str, str2, str3, i, str4);
        this.dax.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + TbConfig.GOOD_LIST_ADDRESS;
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_GOOD_ADDRESS;
        } else {
            str5 = String.valueOf(str6) + TbConfig.COMMIT_TOP_ADDRESS;
        }
        this.dax.execute(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<String, String, Boolean> {
        private w afg = null;
        String ckX;
        ArrayList<j> daC;
        private String mForumId;
        private String mForumName;
        private String mThreadId;
        private int mType;

        public e(String str, String str2, String str3, int i, String str4) {
            this.daC = null;
            this.ckX = null;
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mType = i;
            this.ckX = str4;
            this.daC = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            this.afg = new w(strArr[0]);
            this.afg.o("word", this.mForumName);
            if (this.mType != 6) {
                this.afg.o(ImageViewerConfig.FORUM_ID, this.mForumId);
                this.afg.o("z", this.mThreadId);
                if (this.mType == 4) {
                    this.afg.o("ntn", "set");
                } else if (this.mType == 5) {
                    this.afg.o("ntn", "");
                } else if (this.mType == 2) {
                    this.afg.o("ntn", "set");
                    this.afg.o("cid", this.ckX);
                } else {
                    this.afg.o("ntn", "");
                }
            }
            this.afg.uh().uX().mIsNeedTbs = true;
            String tG = this.afg.tG();
            if (this.afg.uh().uY().qV()) {
                if (this.mType == 6) {
                    try {
                        JSONArray optJSONArray = new JSONObject(tG).optJSONArray("cates");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            j jVar = new j();
                            jVar.parserJson(optJSONArray.optJSONObject(i));
                            this.daC.add(jVar);
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
            a.this.dax = null;
            if (this.afg == null) {
                a.this.mLoadDataCallBack.d(null);
                return;
            }
            f fVar = new f();
            fVar.An = bool.booleanValue();
            if (bool.booleanValue()) {
                if (this.mType == 6) {
                    fVar.daD = this.daC;
                }
            } else {
                fVar.daB = this.afg.getErrorString();
            }
            a.this.mLoadDataCallBack.d(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afg != null) {
                this.afg.gJ();
            }
            a.this.dax = null;
            super.cancel(true);
            a.this.mLoadDataCallBack.d(null);
        }
    }
}
