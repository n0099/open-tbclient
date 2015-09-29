package com.baidu.tieba.image;

import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class j {
    private String aTB;
    HashMap<String, ImageUrlData> ajS;
    private ArrayList<String> bOF;
    private String bOH;
    private String bOI;
    private boolean bOO;
    private String mForumId;
    private String mFrom;
    private String mUserId;
    private String bOG = null;
    private String ajY = null;
    private boolean bOJ = false;
    private boolean bOK = true;
    private a bOL = null;
    private int bOM = 0;
    private boolean bON = false;
    private b bOP = null;
    private HashMap<String, String> bOQ = new HashMap<>();
    private com.baidu.tbadk.core.data.b bOR = null;

    /* loaded from: classes.dex */
    public interface b {
        void F(int i, String str);

        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, com.baidu.tbadk.core.data.b bVar);
    }

    public j(ArrayList<String> arrayList, HashMap<String, ImageUrlData> hashMap, String str, String str2, String str3, String str4, String str5, String str6) {
        this.bOF = null;
        this.bOH = null;
        this.mForumId = null;
        this.aTB = null;
        this.bOI = null;
        this.bOO = false;
        this.mUserId = null;
        this.bOF = arrayList;
        this.ajS = hashMap;
        if (this.bOF == null) {
            this.bOF = new ArrayList<>();
        }
        int size = this.bOF.size();
        for (int i = 0; i < size; i++) {
            String str7 = this.bOF.get(i);
            this.bOQ.put(iQ(str7), str7);
        }
        this.bOH = str3;
        this.aTB = str2;
        this.mForumId = str;
        this.bOI = str4;
        if (this.bOI == null) {
            this.bOO = true;
        }
        this.mUserId = str5;
        this.mFrom = str6;
    }

    public void dE(boolean z) {
        this.bOK = z;
    }

    public void aad() {
        if (!this.bOJ && !this.bOO) {
            c(this.bOH, this.bOI, 10, 0);
        }
    }

    public void aae() {
        if (!this.bOO) {
            if (!this.bOJ) {
                aad();
            } else if (this.bOG != null && this.bOG.length() > 0) {
                this.bOK = true;
                c(this.bOG, null, 0, 10);
            }
        }
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.bOL != null) {
            if (str2 == null || !str2.equals(this.bOL.getPicId())) {
                this.bOL.cancel();
            } else {
                return;
            }
        }
        this.bOL = new a(str, str2, i, i2);
        this.bOL.setPriority(3);
        this.bOL.execute(new Object[0]);
    }

    public void a(b bVar) {
        this.bOP = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, m> {
        private com.baidu.tbadk.core.util.w Th = null;
        private String bOH;
        private String bOS;
        private int bOT;
        private int bOU;

        public a(String str, String str2, int i, int i2) {
            this.bOH = null;
            this.bOS = null;
            this.bOT = 0;
            this.bOU = 0;
            this.bOS = str2;
            this.bOH = str;
            this.bOT = i;
            this.bOU = i2;
        }

        public String getPicId() {
            return this.bOS;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: u */
        public m doInBackground(Object... objArr) {
            this.Th = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.IMAGE_PB_ADDRESS);
            this.Th.o("kw", j.this.aTB);
            this.Th.o("tid", this.bOH);
            if (this.bOS != null) {
                this.Th.o("pic_id", this.bOS);
            }
            this.Th.o("next", String.valueOf(this.bOT));
            this.Th.o("prev", String.valueOf(this.bOU));
            if (!j.this.bON) {
                this.Th.o("not_see_lz", String.valueOf(1));
            }
            BdLog.d("mIsReserver=" + j.this.bOK);
            if (!j.this.bOK) {
                this.Th.o("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(j.this.mFrom, true)) {
                this.Th.o("obj_type", j.this.mFrom);
            }
            aaf();
            this.Th.uh().uX().abL = false;
            String tG = this.Th.tG();
            if (!this.Th.uh().uY().qV()) {
                return null;
            }
            m mVar = new m();
            mVar.y(tG, true);
            return mVar;
        }

        private void aaf() {
            this.Th.o("forum_id", j.this.mForumId);
            this.Th.o("user_id", j.this.mUserId == null ? "0" : j.this.mUserId);
            this.Th.o("scr_w", String.valueOf(com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp())));
            this.Th.o("scr_h", String.valueOf(com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp())));
            this.Th.o("q_type", String.valueOf(as.uI().uK() ? 2 : 1));
            this.Th.o("_os_version", Build.VERSION.RELEASE);
            this.Th.o("net_type", com.baidu.tbadk.core.util.a.h.getNetType());
            this.Th.o("page_name", "PB");
            this.Th.o("pic_index", String.valueOf(j.this.bOF.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.Th != null) {
                this.Th.gJ();
            }
            j.this.bOL = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(m mVar) {
            boolean z;
            int i;
            int i2;
            String str;
            super.onPostExecute(mVar);
            j.this.bOL = null;
            if (mVar != null) {
                j.this.bOM = mVar.getImageNum();
                j.this.bOR = mVar.aah();
                if (this.bOS == null) {
                    j.this.bOF.clear();
                    j.this.bOQ.clear();
                }
                LinkedList<l> aag = mVar.aag();
                int size = aag.size();
                if (size <= 0) {
                    j.this.bOJ = true;
                } else {
                    for (int i3 = 0; i3 < size; i3++) {
                        l lVar = aag.get(i3);
                        String a = j.this.a(lVar);
                        String iQ = j.this.iQ(a);
                        if (!j.this.bOQ.containsKey(iQ)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = a;
                            imageUrlData.urlType = 10;
                            imageUrlData.originalUrl = lVar.Fj();
                            imageUrlData.originalSize = lVar.getOriginalSize();
                            j.this.bOF.add(a);
                            j.this.ajS.put(a, imageUrlData);
                            j.this.bOQ.put(iQ, a);
                        }
                    }
                    l lVar2 = aag.get(size - 1);
                    j.this.bOI = lVar2.getImageID();
                    if (j.this.bOM == lVar2.getIndex()) {
                        j.this.bOJ = true;
                    } else {
                        j.this.bOJ = false;
                    }
                }
                boolean z2 = j.this.bOJ && j.this.bOG != null && j.this.bOG.length() > 0;
                if (this.bOS == null) {
                    j.this.bOH = this.bOH;
                    z = true;
                    i = 0;
                } else {
                    z = false;
                    i = -1;
                }
                if (j.this.bOP != null) {
                    j.this.bOP.a(j.this.bOF, i, j.this.bOM, z2, j.this.ajY, z, j.this.bOR);
                }
            } else if (j.this.bOP != null) {
                if (this.Th != null) {
                    i2 = this.Th.ul();
                    str = this.bOS == null ? this.Th.getErrorString() : null;
                } else {
                    i2 = -1;
                    str = null;
                }
                j.this.bOP.F(i2, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(l lVar) {
        if (lVar.Ff() != null && lVar.Ff().length() > 0) {
            return lVar.Ff();
        }
        StringBuilder sb = new StringBuilder((int) SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
        if (lVar.getHeight() * lVar.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
            double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (lVar.getHeight() * lVar.getWidth()));
            sb.append("width=");
            sb.append(String.valueOf((int) (lVar.getWidth() * sqrt)));
            sb.append("&height=");
            sb.append(String.valueOf((int) (sqrt * lVar.getHeight())));
        } else {
            sb.append("width=");
            sb.append(String.valueOf(lVar.getWidth()));
            sb.append("&height=");
            sb.append(String.valueOf(lVar.getHeight()));
        }
        sb.append("&src=");
        sb.append(ar.aR(lVar.getImageUrl()));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String iQ(String str) {
        int lastIndexOf;
        int indexOf;
        String aS = ar.aS(str);
        if (aS != null) {
            if (aS.indexOf(".baidu.com") != -1 && (lastIndexOf = aS.lastIndexOf("/")) != -1 && (indexOf = aS.indexOf(".", lastIndexOf)) != -1) {
                return aS.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return aS;
    }
}
